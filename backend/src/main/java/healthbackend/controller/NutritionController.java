package healthbackend.controller;

import healthbackend.dto.NutritionRequest;
import healthbackend.dto.NutritionResponse;
import healthbackend.service.NutritionService;
import org.springframework.web.bind.annotation.*;

@RestController
public class NutritionController {

    private final NutritionService nutritionService;

    public NutritionController(NutritionService nutritionService) {
        this.nutritionService = nutritionService;
    }

    @PostMapping("/nutrition/")
    public NutritionResponse getNutrition(
            @RequestBody NutritionRequest request) {

        return nutritionService.getNutrition(request);
    }
}
