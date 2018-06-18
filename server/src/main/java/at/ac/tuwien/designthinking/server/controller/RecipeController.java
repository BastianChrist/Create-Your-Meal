package at.ac.tuwien.designthinking.server.controller;

import at.ac.tuwien.designthinking.server.dto.Context;
import at.ac.tuwien.designthinking.server.dto.Recipe;
import at.ac.tuwien.designthinking.server.service.interfaces.RecipeService;
import at.ac.tuwien.designthinking.server.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by schurli on 15.06.18.
 */
public class RecipeController {

    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService ingredientService){
        this.recipeService = ingredientService;
    }

    @GetMapping("/recipes")
    public List<Recipe> getRecipes(@RequestBody Context context){
        try {
            return recipeService.getAll(context);
        } catch (ServiceException e) {
            e.printStackTrace(); //TODO: Exception Mechanismus für UI festlegen
        }
        return null;
    }

    @GetMapping("/recipes/{recipeId}")
    public Recipe getRecipe(@PathVariable("recipeId") int recipeId){
        try {
            return recipeService.getById(recipeId);
        } catch (ServiceException e) {
            e.printStackTrace(); //TODO: Exception Mechanismus für UI festlegen
        }
        return null;
    }
}
