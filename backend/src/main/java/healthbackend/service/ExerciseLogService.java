package healthbackend.service;

import healthbackend.model.ExerciseLog;
import healthbackend.repository.ExerciseLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseLogService {

    private final ExerciseLogRepository repository;

    public ExerciseLogService(ExerciseLogRepository repository) {
        this.repository = repository;
    }

    public ExerciseLog saveExerciseLog(ExerciseLog exerciseLog) {
        return repository.save(exerciseLog);
    }

    public List<ExerciseLog> getAllExerciseLogs() {
        return repository.findAll();
    }
    public List<ExerciseLog> getUserHistory(String userId) {
    return repository.findByUserId(userId);
}
}
