package at.ac.tuwien.designthinking.server.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RecipeHasCategory {

    @Id
    private Integer Id;

    private Integer recipeId;

    private Integer recipeCategory;


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public Integer getRecipeCategory() {
        return recipeCategory;
    }

    public void setRecipeCategory(Integer recipeCategory) {
        this.recipeCategory = recipeCategory;
    }
}
