package at.ac.tuwien.designthinking.server.controller;

import at.ac.tuwien.designthinking.server.dto.*;
import at.ac.tuwien.designthinking.server.service.exception.ServiceException;
import at.ac.tuwien.designthinking.server.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Georg Edlinger on 31.05.18.
 */
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    public UserController (UserService userService){
        this.userService = userService;
    }

    @PostMapping("/login")
    public UserToken login(@RequestBody UserAccount user)
    {
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

    @GetMapping("/users/{userId}/recipes")
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
            return userService.addUserFavoriteRecipes(userId);
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


}