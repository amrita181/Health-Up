
package healthbackend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import healthbackend.dto.NutritionRequest;
import healthbackend.dto.NutritionResponse;
import healthbackend.model.FoodLog;
import healthbackend.repository.FoodLogRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class NutritionService {

    private final FoodLogRepository foodLogRepository;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Value("${usda.api.key:}")
    private String apiKey;

    public NutritionService(
            FoodLogRepository foodLogRepository,
            ObjectMapper objectMapper) {
        this.foodLogRepository = foodLogRepository;
        this.objectMapper = objectMapper;
        this.restTemplate = new RestTemplate();
    }

    public NutritionResponse getNutrition(NutritionRequest request) {

        try {
            if (apiKey == null || apiKey.isBlank()) {
                throw new RuntimeException("USDA API key is missing.");
            }

            String url = UriComponentsBuilder
                    .fromUriString(
                            "https://api.nal.usda.gov/fdc/v1/foods/search")
                    .queryParam("api_key", apiKey)
                    .queryParam("query", request.getFood())
                    .queryParam("pageSize", 1)
                    .queryParam("dataType", "Foundation")
                    .queryParam("dataType", "Survey (FNDDS)")
                    .build()
                    .encode()
                    .toUriString();

            String json =
                    restTemplate.getForObject(url, String.class);

            JsonNode root = objectMapper.readTree(json);
            JsonNode foods = root.path("foods");

            if (!foods.isArray() || foods.isEmpty()) {
                throw new RuntimeException("No food found.");
            }

            JsonNode foodData = foods.get(0);

            String description =
                    foodData.path("description").asText();

            double calories = 0;
            double protein = 0;
            double fat = 0;
            double carbs = 0;

            for (JsonNode nutrient :
                    foodData.path("foodNutrients")) {

                String name = nutrient.path("nutrientName")
                        .asText().toLowerCase();

                String unit =
                        nutrient.path("unitName").asText();

                double value =
                        nutrient.path("value").asDouble(0);

                if (name.contains("protein")) {
                    protein = value;
                } else if (name.contains("energy")
                        && unit.equalsIgnoreCase("KCAL")) {
                    calories = value;
                } else if (name.contains("total lipid (fat)")) {
                    fat = value;
                } else if (name.contains(
                        "carbohydrate, by difference")) {
                    carbs = value;
                }
            }

            FoodLog log = new FoodLog();
            log.setDescription(description);
            log.setCalories(calories);
            log.setProteinG(protein);
            log.setFatG(fat);
            log.setCarbsG(carbs);

            foodLogRepository.save(log);

            NutritionResponse result = new NutritionResponse();
            result.setFood(description);
            result.setCalories(calories);
            result.setProtein(protein);
            result.setFat(fat);
            result.setCarbohydrates(carbs);

            return result;

        } catch (Exception e) {
            throw new RuntimeException(
                    "Nutrition lookup failed: " + e.getMessage(), e);
        }
    }
}
