package at.ac.tuwien.designthinking.server.service;

/**
 * Created by Bastian on 19.06.2018.
 */

import at.ac.tuwien.designthinking.server.dao.IngredientCategoryDAO;
import at.ac.tuwien.designthinking.server.dao.exception.DaoException;
import at.ac.tuwien.designthinking.server.dto.*;
import at.ac.tuwien.designthinking.server.service.exception.ServiceException;
import at.ac.tuwien.designthinking.server.service.interfaces.IngredientService;
import at.ac.tuwien.designthinking.server.service.interfaces.RecipeService;
import at.ac.tuwien.designthinking.server.service.interfaces.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;


/**
 * Finds Recipes based on your preferences
 */
@Service
public class AlgorithmService {
    private static final Logger LOGGER = LoggerFactory.getLogger(AlgorithmService.class);
    private static IngredientService ingredientService;
    private static RecipeService recipeService;
    private static IngredientCategoryDAO ingredientCategoryDAO;
    private static UserService userService;





    public AlgorithmService(IngredientService ingredientService, RecipeService recipeService, IngredientCategoryDAO ingredientCategoryDAO, UserService userService){
        this.ingredientService = ingredientService;
        this.recipeService = recipeService;
        this.ingredientCategoryDAO = ingredientCategoryDAO;
        this.userService = userService;

    };

    public List<Recipe> getRecipes(int userId, Context context, List<Scale> scales) {

        scales.sort(new Comparator<Scale>() {
            @Override
            public int compare(Scale s1, Scale s2) {
                return s1.getWeight() > s2.getWeight() ? -1 : s1.getWeight() < s2.getWeight() ? +1 : 0;
            }
        });
        List<Recipe> recipesContext = new ArrayList<>();
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

            int catId = getScaleID(scales.get(i).getNumber(), userId);

            IngredientCategory c = null;
            try {
                c = ingredientCategoryDAO.getCategory(catId);
            } catch (DaoException e) {
                e.printStackTrace();
            }
            List<Ingredient> ingredientsH = null;
            try {
                ingredientsH = ingredientService.getByCategory(c);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            Ingredient ingredient1 = ingredientsH.get((int) ((ingredientsH.size()-1) * Math.random()));
            Ingredient ingredient2 = ingredientsH.get((int) ((ingredientsH.size()-1) * Math.random()));
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

    public int getScaleID(int scaleNumber, int userId){
        int catId;
        UserScaleAssignment userScaleAssignment = null;
        try {
            userScaleAssignment = userService.getUserScaleAssignment(userId);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        switch (scaleNumber){
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
