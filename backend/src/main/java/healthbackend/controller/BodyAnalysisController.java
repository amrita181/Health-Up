package healthbackend.controller;

import healthbackend.dto.BodyAnalysisRequest;
import healthbackend.dto.BodyAnalysisResponse;
import healthbackend.service.BodyAnalysisService;
import org.springframework.web.bind.annotation.*;

@RestController
public class BodyAnalysisController {

    private final BodyAnalysisService bodyAnalysisService;

    public BodyAnalysisController(BodyAnalysisService bodyAnalysisService) {
        this.bodyAnalysisService = bodyAnalysisService;
    }

    @PostMapping("/body-analysis/")
    public BodyAnalysisResponse analyzeBody(
            @RequestBody BodyAnalysisRequest request) {

        return bodyAnalysisService.analyzeBody(request);
    }
}
