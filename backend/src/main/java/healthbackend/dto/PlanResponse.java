package healthbackend.dto;

import java.util.List;

public class PlanResponse {

    private String bmi;
    private String category;
    private List<String> workout;
    private List<String> diet;

    public PlanResponse() {
    }

    public String getBmi() {
        return bmi;
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<String> getWorkout() {
        return workout;
    }

    public void setWorkout(List<String> workout) {
        this.workout = workout;
    }

    public List<String> getDiet() {
        return diet;
    }

    public void setDiet(List<String> diet) {
        this.diet = diet;
    }
}
