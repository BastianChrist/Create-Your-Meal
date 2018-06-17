package at.ac.tuwien.designthinking.server.controller;

import at.ac.tuwien.designthinking.server.dto.Ingredient;
import at.ac.tuwien.designthinking.server.dto.User;
import at.ac.tuwien.designthinking.server.dto.UserToken;
import at.ac.tuwien.designthinking.server.persistence.IngredientDAO;
import at.ac.tuwien.designthinking.server.persistence.PersistenceException;
import at.ac.tuwien.designthinking.server.persistence.UserDAO;
import at.ac.tuwien.designthinking.server.service.IngredientService;
import at.ac.tuwien.designthinking.server.service.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by schurli on 15.06.18.
 */
@RestController
public class IngredientController {

    private IngredientService ingredientService;

    @Autowired
    public IngredientController(IngredientService ingredientService){
        this.ingredientService = ingredientService;
    }

    @GetMapping("/ingredients")
    public List<Ingredient> getAll(){
        try {
            return ingredientService.getAll();
        } catch (ServiceException e) {
            e.printStackTrace(); //TODO: Exception Mechanismus für UI festlegen
        }
        return null;
    }

    @GetMapping("/ingredients/{ingredientId}")
    public Ingredient getIngredient(@PathVariable("ingredientId") int ingredientId){
        try {
            return ingredientService.getById(ingredientId);
        } catch (ServiceException e) {
            e.printStackTrace(); //TODO: Exception Mechanismus für UI festlegen
        }
        return null;
    }

    @PutMapping("/ingredients/{ingredientId}")
    public Ingredient putIngredient(@PathVariable("ingredientId") int ingredientId, @RequestBody Ingredient ingredient){
        try {
            return ingredientService.changeIngredient(ingredientId, ingredient);
        } catch (ServiceException e) {
            e.printStackTrace(); //TODO: Exception Mechanismus für UI festlegen
        }
        return null;
    }





}
