package at.ac.tuwien.designthinking.server.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Created by Bastian on 27.05.2018.
 */
@Entity
public class Recipe {

    @Id
    private int id;

    private String name;

    private String type; //TODO: MAybe an ENUM?

    private String difficulty;

    private boolean isWarm;

    private Integer time_needed;

    private int servings;

    private String source;

    private String dateAdded;

    private String instructions;

    private String ingredients;

    private String recipePicture; //TODO: Read Image

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public boolean isWarm() {
        return isWarm;
    }

    public void setWarm(boolean warm) {
        isWarm = warm;
    }

    public Integer getTime_needed() {
        return time_needed;
    }

    public void setTime_needed(Integer time_needed) {
        this.time_needed = time_needed;
    }

    public int getServings() {
        return servings;
    }

    public void setServings(int servings) {
        this.servings = servings;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(String dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getRecipePicture() {
        return recipePicture;
    }

    public void setRecipePicture(String recipePicture) {
        this.recipePicture = recipePicture;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return id == recipe.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
