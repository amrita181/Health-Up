package healthbackend.service;

import healthbackend.dto.PlanRequest;
import healthbackend.dto.PlanResponse;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PlanService {

    public PlanResponse generatePlan(PlanRequest request) {

        double heightInMeters = request.getHeight() / 100.0;

        double bmi = request.getWeight()
                / (heightInMeters * heightInMeters);

        String category;

        if (bmi < 18.5) {
            category = "Underweight";
        } else if (bmi < 25) {
            category = "Normal";
        } else if (bmi < 30) {
            category = "Overweight";
        } else {
            category = "Obese";
        }

        PlanResponse response = new PlanResponse();

        response.setBmi(String.format("%.2f", bmi));
        response.setCategory(category);

        response.setWorkout(Arrays.asList(
                "Walking",
                "Push-ups",
                "Squats",
                "Plank"
        ));

        response.setDiet(Arrays.asList(
                "Eat more vegetables",
                "Eat sufficient protein",
                "Drink enough water",
                "Avoid excessive junk food"
        ));

        return response;
    }
}
