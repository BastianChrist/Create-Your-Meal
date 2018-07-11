package at.ac.tuwien.designthinking.server.controller;

import at.ac.tuwien.designthinking.server.dto.Context;
import at.ac.tuwien.designthinking.server.dto.Ingredient;
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
                    scales.add(new Scale(1,0));
            scales.add(new Scale(2,0));
            scales.add(new Scale(3,0));
            scales.add(new Scale(4,0));
            scales.add(new Scale(5,100));
            scales.add(new Scale(6,0));
            context.setScales(scales);

                    return recipeService.getByContext(context);
        } catch (ServiceException e) {
            e.printStackTrace(); //TODO: Exception Mechanismus für UI festlegen
        }
        return null;
    }


    @GetMapping("/recipes/listtest")
    public List<Recipe> getTestRecipebyIngredientList(){
        try {
            ArrayList<Ingredient> testIngredients = new ArrayList<Ingredient>();
            Ingredient fleisch1 = new Ingredient();
            fleisch1.setId(7);
            testIngredients.add(fleisch1);
            Ingredient fleisch2 = new Ingredient();
            fleisch2.setId(18);
            testIngredients.add(fleisch2);
            Ingredient fleisch3 = new Ingredient();
            fleisch3.setId(34);
            testIngredients.add(fleisch3);
            Ingredient fleisch4 = new Ingredient();
            fleisch4.setId(42);
            testIngredients.add(fleisch4);
            Ingredient fleisch5 = new Ingredient();
            fleisch5.setId(50);
            testIngredients.add(fleisch5);
            Ingredient fleisch6 = new Ingredient();
            fleisch6.setId(54);
            testIngredients.add(fleisch6);
            Ingredient fleisch7 = new Ingredient();
            fleisch7.setId(66);
            testIngredients.add(fleisch7);
            Ingredient fleisch8 = new Ingredient();
            fleisch8.setId(79);
            testIngredients.add(fleisch8);
            Ingredient fleisch9 = new Ingredient();
            fleisch9.setId(86);
            testIngredients.add(fleisch9);
            Ingredient fleisch10 = new Ingredient();
            fleisch10.setId(91);
            testIngredients.add(fleisch10);
            Ingredient fleisch11 = new Ingredient();
            fleisch11.setId(110);
            testIngredients.add(fleisch11);
            Ingredient fleisch12 = new Ingredient();
            fleisch12.setId(135);
            testIngredients.add(fleisch12);
            Ingredient fleisch13 = new Ingredient();
            fleisch13.setId(138);
            testIngredients.add(fleisch13);
            return recipeService.getByIngredientlist(testIngredients);
        } catch (ServiceException e) {
            e.printStackTrace(); //TODO: Exception Mechanismus für UI festlegen
        }
        return null;
    }
}
