package healthbackend.controller;

import healthbackend.dto.NutritionRequest;
import healthbackend.dto.NutritionResponse;
import healthbackend.service.NutritionService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {
        "http://localhost:3000",
        "http://localhost:5173"
})
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
