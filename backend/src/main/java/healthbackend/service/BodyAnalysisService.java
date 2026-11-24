package healthbackend.service;

import healthbackend.dto.BodyAnalysisRequest;
import healthbackend.dto.BodyAnalysisResponse;
import org.springframework.stereotype.Service;

@Service
public class BodyAnalysisService {

    public BodyAnalysisResponse analyzeBody(BodyAnalysisRequest request) {

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

        BodyAnalysisResponse response = new BodyAnalysisResponse();

        response.setBmi(Math.round(bmi * 100.0) / 100.0);
        response.setCategory(category);
        response.setMessage("Body analysis completed successfully");

        return response;
    }
}
