package healthbackend.controller;

import healthbackend.dto.ExerciseLogRequest;
import healthbackend.model.ExerciseLog;
import healthbackend.service.ExerciseLogService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExerciseLogController {

    private final ExerciseLogService service;

    public ExerciseLogController(ExerciseLogService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "HealthPro Backend API is Running";
    }

    @PostMapping("/track-exercise/")
    public ExerciseLog trackExercise(
            @RequestBody ExerciseLogRequest request) {

        ExerciseLog exerciseLog = new ExerciseLog();

        exerciseLog.setUserId(request.getUserId());
        exerciseLog.setBodyPart(request.getBodyPart());
        exerciseLog.setExercise(request.getExercise());

        return service.saveExerciseLog(exerciseLog);
    }

    @GetMapping("/history/{userId}/")
    public List<ExerciseLog> getUserHistory(
            @PathVariable String userId) {

        return service.getUserHistory(userId);
    }
}
