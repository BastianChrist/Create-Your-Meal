package at.ac.tuwien.designthinking.server.controller;

import at.ac.tuwien.designthinking.server.dto.Context;
import at.ac.tuwien.designthinking.server.dto.Recipe;
import at.ac.tuwien.designthinking.server.dto.Scale;
import at.ac.tuwien.designthinking.server.service.interfaces.RecipeService;
import at.ac.tuwien.designthinking.server.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by schurli on 15.06.18.
 */
@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    public RecipeController(RecipeService ingredientService){
        this.recipeService = ingredientService;
    }

    @GetMapping("/recipes")
    //public List<Recipe> getRecipes(@RequestBody Context context){ //TODO: Warum brauchen wir hier den Context?
    public List<Recipe> getRecipes(){
        try {
            return recipeService.getAll(null);
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

    @GetMapping("/recipes/test")
    public List<Recipe> getTestRecipes(){
        try {
            Context context = new Context();
                    context.setWarm(true);
                    context.setMaxCookTime(45);
                    List<Scale> scales = new ArrayList<>();
                    scales.add(new Scale(1,10));
            scales.add(new Scale(2,12));
            scales.add(new Scale(3,14));
            scales.add(new Scale(4,16));
            scales.add(new Scale(5,17));
            scales.add(new Scale(6,18));
            context.setScales(scales);

                    return recipeService.getByContext(context);
        } catch (ServiceException e) {
            e.printStackTrace(); //TODO: Exception Mechanismus für UI festlegen
        }
        return null;
    }
}
