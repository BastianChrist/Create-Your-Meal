package at.ac.tuwien.designthinking.server.service;

/**
 * Created by Bastian on 19.06.2018.
 */

import at.ac.tuwien.designthinking.server.dao.IngredientCategoryDAO;
import at.ac.tuwien.designthinking.server.dto.*;
import at.ac.tuwien.designthinking.server.service.exception.ServiceException;
import at.ac.tuwien.designthinking.server.service.interfaces.IngredientService;
import at.ac.tuwien.designthinking.server.service.interfaces.RecipeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 * Finds Recipes based on your preferences
 */
@Service
public class AlgortithmService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlgortithmService.class);
    private static IngredientService ingredientService;
    private static RecipeService recipeService;
    private static IngredientCategoryDAO ingredientCategoryDAO;
    private static UserScaleAssignment userScaleAssignment;
    public AlgortithmService(IngredientService ingredientService, RecipeService recipeService, IngredientCategoryDAO ingredientCategoryDAO, UserScaleAssignment userScaleAssignment){
        this.ingredientService = ingredientService;
        this.recipeService = recipeService;
        this.ingredientCategoryDAO = ingredientCategoryDAO;
        this.userScaleAssignment = userScaleAssignment;
    };

    //TODO
    //TreeMap Schlüssel Sensor Wert / Value kategorie nummer
    public TreeMap<Integer,Integer> getSensorData(){
        return null;
    }

    //muss das user scale assingment in den context?
    public List<Recipe> getRecipes(int userId, Context context) {
        TreeMap<Integer,Integer> sensorData = getSensorData();

        List<Recipe> recipesContext = null;
        try {
            recipesContext = recipeService.getByContext(context);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        List<Recipe> recipesPrio1 = null;
        List<Recipe> recipesPrio2 = null;
        List<Recipe> recipesPrio3 = null;
        List<Recipe> recipesPrio4 = null;
        List<Recipe> recipesPrio5 = null;
        List<Recipe> recipesPrio6 = null;
        for (int i = 0; i<6;i++) {
            Map.Entry<Integer, Integer> highest = sensorData.lastEntry();
            sensorData.remove(highest.getKey());

            int catId = getScaleID(highest);

            IngredientCategory c = ingredientCategoryDAO.getCategory(catId);
            List<Ingredient> ingredientsH = null;
            try {
                ingredientsH = ingredientService.getByCategory(c);
            } catch (ServiceException e) {
                e.printStackTrace();
            }

            Ingredient ingredient1 = ingredientsH.get((int) (ingredientsH.size() * Math.random() - 1));
            Ingredient ingredient2 = ingredientsH.get((int) (ingredientsH.size() * Math.random() - 1));
            try {

            switch (i) {
                case 0:
                    recipesPrio1 = recipeService.getRecipesByIngredient(ingredient1);
                    recipesPrio1.addAll(recipeService.getRecipesByIngredient(ingredient2));
                    break;
                case 1:
                    recipesPrio2 = recipeService.getRecipesByIngredient(ingredient1);
                    recipesPrio2.addAll(recipeService.getRecipesByIngredient(ingredient2));
                    break;
                case 2:
                    recipesPrio3 = recipeService.getRecipesByIngredient(ingredient1);
                    recipesPrio3.addAll(recipeService.getRecipesByIngredient(ingredient2));
                    break;
                case 3:
                    recipesPrio4 = recipeService.getRecipesByIngredient(ingredient1);
                    recipesPrio4.addAll(recipeService.getRecipesByIngredient(ingredient2));
                    break;
                case 4:
                    recipesPrio5 = recipeService.getRecipesByIngredient(ingredient1);
                    recipesPrio5.addAll(recipeService.getRecipesByIngredient(ingredient2));
                    break;
                case 5:
                    recipesPrio6 = recipeService.getRecipesByIngredient(ingredient1);
                    recipesPrio6.addAll(recipeService.getRecipesByIngredient(ingredient2));
                    break;
            }
            }catch (ServiceException e){
                e.printStackTrace();
            }
        }
        List<Recipe> recipes1 = new ArrayList<>();
        List<Recipe> recipes2 = new ArrayList<>();
        List<Recipe> recipes3 = new ArrayList<>();
        List<Recipe> recipes4 = new ArrayList<>();
        List<Recipe> recipes5 = new ArrayList<>();
        List<Recipe> recipes6 = new ArrayList<>();

        for (Recipe r: recipesContext) {
            if(recipesPrio1!=null && recipesPrio1.contains(r)){
                recipes1.add(r);
            }
        }
        for (Recipe r:recipes1) {
            if(recipesPrio2!=null && recipesPrio2.contains(r)){
                recipes2.add(r);
            }
        }
        for (Recipe r:recipes2) {
            if(recipesPrio3!=null && recipesPrio3.contains(r)){
                recipes3.add(r);
            }
        }
        for (Recipe r:recipes3) {
            if(recipesPrio4!=null && recipesPrio4.contains(r)){
                recipes4.add(r);
            }
        }
        for (Recipe r:recipes4) {
            if(recipesPrio5!=null && recipesPrio5.contains(r)){
                recipes5.add(r);
            }
        }
        for (Recipe r:recipes5) {
            if(recipesPrio5!=null && recipesPrio5.contains(r)){
                recipes6.add(r);
            }
        }
        List<Recipe> recipes = new ArrayList<>();

        recipes.addAll(recipes6);
        if (recipes.size()>=3) {
            return recipes;
        }
        recipes.addAll(recipes5);
        if (recipes.size()>=3) {
            return recipes;
        }
        recipes.addAll(recipes4);
        if (recipes.size()>=3) {
            return recipes;
        }
        recipes.addAll(recipes3);
        if (recipes.size()>=3) {
            return recipes;
        }
        recipes.addAll(recipes2);
        if (recipes.size()>=3) {
            return recipes;
        }
        recipes.addAll(recipes1);if (recipes.size()>=3) {
            return recipes;
        }
        recipes.addAll(recipesContext);
        return recipes;
    }

    public int getScaleID(Map.Entry<Integer,Integer> entry){
        int catId;

        switch (entry.getValue()){
            case 1:
                return catId = userScaleAssignment.getScale_one();
            case 2:
                return catId = userScaleAssignment.getScale_two();
            case 3:
                return catId = userScaleAssignment.getScale_three();
            case 4:
                return catId = userScaleAssignment.getScale_four();
            case 5:
                return catId = userScaleAssignment.getScale_five();
            case 6:
                return catId = userScaleAssignment.getScale_six();
        }
        return 0;
    }
}
