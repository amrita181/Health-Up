package healthbackend.controller;

import healthbackend.dto.PlanRequest;
import healthbackend.dto.PlanResponse;
import healthbackend.service.PlanService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {
        "http://localhost:3000",
        "http://localhost:5173"
})
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping("/generate-plan/")
    public PlanResponse generatePlan(@RequestBody PlanRequest request) {
        return planService.generatePlan(request);
    }
}
