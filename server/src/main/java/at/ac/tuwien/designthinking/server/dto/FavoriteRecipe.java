package at.ac.tuwien.designthinking.server.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FavoriteRecipe {

    @Id
    private int Id;

    private Integer userId;

    private Integer recipeId;

    private String favoritedOn;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public String getFavoritedOn() {
        return favoritedOn;
    }

    public void setFavoritedOn(String favoritedOn) {
        this.favoritedOn = favoritedOn;
    }
}
