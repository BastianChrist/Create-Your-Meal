package at.ac.tuwien.designthinking.server.controller;

import at.ac.tuwien.designthinking.server.dto.*;
import at.ac.tuwien.designthinking.server.service.AlgorithmService;
import at.ac.tuwien.designthinking.server.service.exception.ServiceException;
import at.ac.tuwien.designthinking.server.service.interfaces.IngredientService;
import at.ac.tuwien.designthinking.server.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Georg Edlinger on 31.05.18.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private AlgorithmService algorithmService;

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    ScalesController scalesController;

    @Autowired
    public UserController (UserService userService, AlgorithmService algorithmService, IngredientService ingredientService){
        this.userService = userService;
        this.algorithmService=algorithmService;
        this.ingredientService=ingredientService;
    }

    @PostMapping("/login")
    public UserToken login(@RequestBody UserAccount user)
    {
        //TODO: algorithmService.startScales();
        return new UserToken(user.getFirstName());
    }

    @GetMapping("/users")
    public List<UserAccount> getUsers(){
        try {
            return userService.getUsers();
        } catch (ServiceException e) {
            e.printStackTrace(); //TODO: Exception Mechanismus für UI festlegen
        }
        return null;
    }

    @GetMapping("/users/{userId}")
    public UserAccount getUser(@PathVariable("userId") int userId){
        try {
            return userService.getUser(userId);
        } catch (ServiceException e) {
            e.printStackTrace(); //TODO: Exception Mechanismus für UI festlegen
        }
        return null;
    }

    @GetMapping("/users/{userId}/allergens")
    public List<Allergen> getUserAllergens(@PathVariable("userId") int userId){
        try {
            return userService.getUserAllergens(userId);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/users/{userId}/recipes")
    public List<Recipe> getRecipesForWeights(@PathVariable("userId") int userId,@RequestBody Context context){
        scalesController.stopScales();
        return algorithmService.getRecipes(userId, context, context.getScales());
    }

    @GetMapping("/users/{userId}/scale")
    public UserScaleAssignment getUserScaleAsssignment(@PathVariable("userId") int userId){
        try {
            return userService.getUserScaleAssignment(userId);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/users/{userId}/allergens")
    public List<Allergen> addUserAllergen(@PathVariable("userId") int userId, @RequestBody Allergen allergen){
        try {
            return userService.addUserAllergen(userId,allergen);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/users/{userId}/allergens/{allergenId}")
    public void deleteUserAllergen(@PathVariable("userId") int userId,@PathVariable("allergenId") int allergenId){
        try {
             userService.deleteUserAllergen(userId,allergenId);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @GetMapping("/users/{userId}/recipesHistory")
    public List<RecipeHistory> getUserRecipeHistory(@PathVariable("userId") int userId){
        try {
            return userService.getUserRecipeHistory(userId);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/users/{userId}/favorites")
    public List<Recipe> getUserFavoritesRecipes(@PathVariable("userId") int userId){
        try {
            return userService.getUserFavoriteRecipes(userId);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return null;
    }


    @PostMapping("/users/{userId}/favorites")
    public List<Recipe> addUserFavoritesRecipes(@PathVariable("userId") int userId){
        try {
            return userService.addUserFavoriteRecipes(userId);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return null;
    }
    @DeleteMapping("/users/{userId}/favorites")
    public List<Recipe> deleteUserFavoritesRecipes(@PathVariable("userId") int userId){
        try {
            userService.deleteUserFavoriteRecipes(userId);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return null;
    }

    @GetMapping("/users/{userId}/userscales")
    public HashMap<Integer,String> getUserScaleAssignment(@PathVariable("userId") int userId){
        try {
            UserScaleAssignment userScaleAssignment = userService.getUserScaleAssignment(userId);
            HashMap<Integer,String> categoryForScale= new HashMap<>();
            String category1= ingredientService.getIngredientCategoryById(userScaleAssignment.getScale_one()).getName();
            categoryForScale.put(1,category1);
            String category2= ingredientService.getIngredientCategoryById(userScaleAssignment.getScale_two()).getName();
            categoryForScale.put(2,category2);
            String category3= ingredientService.getIngredientCategoryById(userScaleAssignment.getScale_three()).getName();
            categoryForScale.put(3,category3);
            String category4= ingredientService.getIngredientCategoryById(userScaleAssignment.getScale_four()).getName();
            categoryForScale.put(4,category4);
            String category5= ingredientService.getIngredientCategoryById(userScaleAssignment.getScale_five()).getName();
            categoryForScale.put(5,category5);
            String category6= ingredientService.getIngredientCategoryById(userScaleAssignment.getScale_six()).getName();
            categoryForScale.put(6,category6);
            return categoryForScale;
        } catch (ServiceException e) {
            e.printStackTrace();
        }
        return null;
    }


}
