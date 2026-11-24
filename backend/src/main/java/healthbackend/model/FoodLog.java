package healthbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "food_logs")
public class FoodLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private double calories;

    @Column(name = "protein_g")
    private double proteinG;

    @Column(name = "fat_g")
    private double fatG;

    @Column(name = "carbs_g")
    private double carbsG;

    public FoodLog() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getProteinG() {
        return proteinG;
    }

    public void setProteinG(double proteinG) {
        this.proteinG = proteinG;
    }

    public double getFatG() {
        return fatG;
    }

    public void setFatG(double fatG) {
        this.fatG = fatG;
    }

    public double getCarbsG() {
        return carbsG;
    }

    public void setCarbsG(double carbsG) {
        this.carbsG = carbsG;
    }
}
