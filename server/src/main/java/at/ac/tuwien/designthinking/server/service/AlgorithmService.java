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


    private ScaleThread scale1 = new ScaleThread(1);
    private ScaleThread scale2 = new ScaleThread(2);
    private ScaleThread scale3 = new ScaleThread(3);
    private ScaleThread scale4 = new ScaleThread(4);
    private ScaleThread scale5 = new ScaleThread(5);
    private ScaleThread scale6 = new ScaleThread(6);


    public AlgorithmService(IngredientService ingredientService, RecipeService recipeService, IngredientCategoryDAO ingredientCategoryDAO, UserService userService){
        this.ingredientService = ingredientService;
        this.recipeService = recipeService;
        this.ingredientCategoryDAO = ingredientCategoryDAO;
        this.userService = userService;
        scale1.start();
        scale2.start();
        scale3.start();
        scale4.start();
        scale5.start();
        scale6.start();
    };

    public List<Recipe> getRecipes(int userId, Context context, List<Scale> scales) {

        stopScales();
        scales.sort(new Comparator<Scale>() {
            @Override
            public int compare(Scale s1, Scale s2) {
                return s1.getWeight() > s2.getWeight() ? -1 : s1.getWeight() < s2.getWeight() ? +1 : 0;
            }
        });
        for(Scale scale: scales){
            System.out.println("scale key: "+scale.getNumber()+" scale weight "+scale.getWeight());
        }
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
            System.out.println("categoryId "+catId);
            try {
                c = ingredientCategoryDAO.getCategory(catId);
            } catch (DaoException e) {
                e.printStackTrace();
            }
            System.out.println("Category "+c.getId()+" name "+c.getName());
            List<Ingredient> ingredientsH = null;
            try {
                ingredientsH = ingredientService.getByCategory(c);
            } catch (ServiceException e) {
                e.printStackTrace();
            }
            System.out.println("size ingredients" + ingredientsH.size());
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

    public List<Scale> getWeights(){

        List<Scale> scaleList = new ArrayList<Scale>();
        scaleList.add(new Scale(scale1.getScaleNumber(),scale1.getWeight()));
        scaleList.add(new Scale(scale2.getScaleNumber(),scale2.getWeight()));
        scaleList.add(new Scale(scale3.getScaleNumber(),scale3.getWeight()));
        scaleList.add(new Scale(scale4.getScaleNumber(),scale4.getWeight()));
        scaleList.add(new Scale(scale5.getScaleNumber(),scale5.getWeight()));
        scaleList.add(new Scale(scale6.getScaleNumber(),scale6.getWeight()));
        return scaleList;

    }

    public void startScales() {
        System.out.println("is Alive scale1 " + scale1.isAlive());
        if (scale1.isAlive()) {
            scale1.interrupt();
        }
        if (scale2.isAlive()) {
            scale2.interrupt();
        }
        if (scale3.isAlive()) {
            scale3.interrupt();
        }
        if (scale4.isAlive()) {
            scale4.interrupt();
        }
        if (scale5.isAlive()) {
            scale5.interrupt();
        }
        if (scale6.isAlive()) {
            scale6.interrupt();
        }
    }
    private void stopScales(){
        scale1.setStopped(true);
        scale2.setStopped(true);
        scale3.setStopped(true);
        scale4.setStopped(true);
        scale5.setStopped(true);
        scale6.setStopped(true);


    }
}
