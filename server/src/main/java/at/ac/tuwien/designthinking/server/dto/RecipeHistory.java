package at.ac.tuwien.designthinking.server.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RecipeHistory {

    @Id
    private Integer id;

    private int userId;

    private int recipeId;

    private String cookedOn;

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getCookedOn() {
        return cookedOn;
    }

    public void setCookedOn(String cookedOn) {
        this.cookedOn = cookedOn;
    }
}
