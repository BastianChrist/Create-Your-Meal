INSERT INTO USERACCOUNT(ID,EMAIL,FIRSTNAME,LASTNAME,PASSWORD,PROFILEPICTURE)VALUES ('1','hilda.tellioglu@tuwien.ac.at','Hilda','Tellioglu',null,null );
INSERT INTO USERACCOUNT(ID,EMAIL,FIRSTNAME,LASTNAME,PASSWORD,PROFILEPICTURE)VALUES ('2','peter.fikar@tuwien.ac.at','Peter','Fikar',null,null);
INSERT INTO USERACCOUNT(ID,EMAIL,FIRSTNAME,LASTNAME,PASSWORD,PROFILEPICTURE)VALUES ('3',null,'Georg','Edlinger',null,null);
INSERT INTO USERACCOUNT(ID,EMAIL,FIRSTNAME,LASTNAME,PASSWORD,PROFILEPICTURE)VALUES ('4',null,'Bastian','Christ',null,null);

INSERT INTO USERSCALEASSIGNMENT (ID, USERID, SCALE_ONE, SCALE_TWO, SCALE_THREE, SCALE_FOUR, SCALE_FIVE, SCALE_SIX) VALUES (1,1,1,2,3,4,5,6);
INSERT INTO USERSCALEASSIGNMENT (ID, USERID, SCALE_ONE, SCALE_TWO, SCALE_THREE, SCALE_FOUR, SCALE_FIVE, SCALE_SIX) VALUES (2,2,1,2,3,4,5,6);
INSERT INTO USERSCALEASSIGNMENT (ID, USERID, SCALE_ONE, SCALE_TWO, SCALE_THREE, SCALE_FOUR, SCALE_FIVE, SCALE_SIX) VALUES (3,3,1,2,3,4,5,6);
INSERT INTO USERSCALEASSIGNMENT (ID, USERID, SCALE_ONE, SCALE_TWO, SCALE_THREE, SCALE_FOUR, SCALE_FIVE, SCALE_SIX) VALUES (4,4,1,2,3,4,5,6);

INSERT INTO USERALLERGIES (ID,ALLERGENID,DATEADDED,USERID) VALUES ('1','1','19-06-2018',1);
INSERT INTO USERALLERGIES (ID,ALLERGENID,DATEADDED,USERID) VALUES ('2','2','19-06-2018',1);
INSERT INTO USERALLERGIES (ID,ALLERGENID,DATEADDED,USERID) VALUES ('3','2','19-06-2018',2);

INSERT INTO RECIPEHISTORY(ID, USERID,RECIPEID,COOKEDON) VALUES (1,1,1,'19-06-2018');

INSERT INTO FAVORITERECIPE (ID,USERID,RECIPEID,FAVORITEDON) VALUES (1,1,15,'19-06-2018');


--- Queries to test Recipeservice
---SELECT * FROM Recipe r left join Ingredient i, UserAllergies ua WHERE i.ALLERGENID IS NOT ua.ALLERGENID

---SELECT * FROM UserAllergies, Ingredient,RecipeIngredients where userid=1 And Ingredient.AllergenId = UserAllergies.allergenid AND RecipeIngredients.IngredientId = Ingredient.id

---SELECT * FROM UserAllergies, Ingredient,RecipeIngredients, recipe where userid=1 And Ingredient.AllergenId = UserAllergies.allergenid AND RecipeIngredients.IngredientId = Ingredient.id And RecipeIngredients.recipeID= recipe.id
---< Rezepte, die man nicht kochen darf

---SELECT Distinct(Recipe.Id) FROM UserAllergies, Ingredient,RecipeIngredients, recipe where userid=1 And Ingredient.AllergenId= UserAllergies.allergenid AND RecipeIngredients.IngredientId = Ingredient.id And RecipeIngredients.recipeID= recipe.id

---SELECT Distinct(Recipe.name) FROM UserAllergies, Ingredient,RecipeIngredients, Recipe where userid=1 And Ingredient.AllergenId = UserAllergies.allergenid AND RecipeIngredients.IngredientId = Ingredient.id And RecipeIngredients.recipeId = recipe.id --!>