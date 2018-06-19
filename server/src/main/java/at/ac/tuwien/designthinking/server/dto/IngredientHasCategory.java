package at.ac.tuwien.designthinking.server.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class IngredientHasCategory {

    @Id
    private Integer Id;

    private Integer ingredientId;

    private Integer ingredientCategory;

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(Integer ingredientId) {
        this.ingredientId = ingredientId;
    }

    public Integer getIngredientCategory() {
        return ingredientCategory;
    }

    public void setIngredientCategory(Integer ingredientCategory) {
        this.ingredientCategory = ingredientCategory;
    }
}
