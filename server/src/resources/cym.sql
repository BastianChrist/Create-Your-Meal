CREATE TABLE `UserAccount` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	`firstName` varchar(255) NOT NULL,
	`lastName` varchar(255) NOT NULL,
	`profilePicture` blob,
	`email` varchar,
	`password` varchar,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `UserAllergies` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	`userId` INT NOT NULL ,
	`allergenId` INT NOT NULL ,
	`dateAdded` VARCHAR NOT NULL,
	PRIMARY KEY (`ID`)
);


CREATE TABLE `Allergen` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	`name` varchar NOT NULL,
	`code` varchar NOT NULL UNIQUE,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Ingredient` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	`name` varchar NOT NULL,
	`allergenId` INT NOT NULL,
	`category` VARCHAR NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `RecipeHistory` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	`userId` INT NOT NULL ,
	`recipeId` INT NOT NULL ,
	`cookedOn` VARCHAR ,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `Recipe` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	`name` varchar NOT NULL,
	`type` varchar,
	`difficulty` varchar NOT NULL,
	`isWarm` BOOLEAN NOT NULL,
	`time_needed` VARCHAR NOT NULL,
	`servings` INT NOT NULL,
	`source` varchar NOT NULL,
	`dateAdded` DATETIME,
	`instructions` varchar NOT NULL,
	`recipePicture` blob,
	`ingredients` VARCHAR NOT NULL,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `RecipeIngredients` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	`recipeId` INT NOT NULL AUTO_INCREMENT,
	`amount` VARCHAR NOT NULL ,
	`ingredientId` INT NOT NULL ,
	PRIMARY KEY (`ID`)
);


CREATE TABLE `FavoriteRecipe` (
	`ID` INT NOT NULL AUTO_INCREMENT UNIQUE,
	`userId` INT ,
	`recipeId` INT NOT NULL ,
	`favoritedOn` VARCHAR ,
	PRIMARY KEY (`userId`,`recipeId`)
);

CREATE TABLE `RecipeCategory` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	`name` varchar NOT NULL,
	`description` varchar,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `IngredientCategory` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	`name` varchar NOT NULL,
	`description` varchar ,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `RecipeHasCategory` (
	`ID` INT NOT NULL AUTO_INCREMENT,
	`recipeId` INT NOT NULL AUTO_INCREMENT,
	`recipeCategory` INT NOT NULL AUTO_INCREMENT,
	PRIMARY KEY (`ID`)
);

CREATE TABLE `UserScaleAssignment` (
	`ID` INT NOT NULL,
	`userId` INT NOT NULL UNIQUE,
	`scale_one` INT NOT NULL,
	`scale_two` INT NOT NULL,
	`scale_three` INT NOT NULL,
	`scale_four` INT NOT NULL,
	`scale_five` INT NOT NULL,
	`scale_six` INT NOT NULL
);

ALTER TABLE `UserAllergies` ADD CONSTRAINT `UserAllergies_fk0` FOREIGN KEY (`userId`) REFERENCES `UserAccount`(`ID`);

ALTER TABLE `UserAllergies` ADD CONSTRAINT `UserAllergies_fk1` FOREIGN KEY (`allergenId`) REFERENCES `Allergen`(`ID`);

ALTER TABLE `RecipeHistory` ADD CONSTRAINT `RecipeHistory_fk0` FOREIGN KEY (`userId`) REFERENCES `UserAccount`(`ID`);

ALTER TABLE `RecipeHistory` ADD CONSTRAINT `RecipeHistory_fk1` FOREIGN KEY (`recipeId`) REFERENCES `Recipe`(`ID`);

ALTER TABLE `Ingredient` ADD CONSTRAINT `Ingredient_fk1` FOREIGN KEY (`allergenId`) REFERENCES `Allergen`(`ID`);

ALTER TABLE `RecipeIngredients` ADD CONSTRAINT `RecipeIngredients_fk0` FOREIGN KEY (`recipeId`) REFERENCES `Recipe`(`ID`);

ALTER TABLE `RecipeIngredients` ADD CONSTRAINT `RecipeIngredients_fk1` FOREIGN KEY (`ingredientId`) REFERENCES `Ingredient`(`ID`);

ALTER TABLE `FavoriteRecipe` ADD CONSTRAINT `FavoriteRecipe_fk0` FOREIGN KEY (`userId`) REFERENCES `UserAccount`(`ID`);

ALTER TABLE `FavoriteRecipe` ADD CONSTRAINT `FavoriteRecipe_fk1` FOREIGN KEY (`recipeId`) REFERENCES `Recipe`(`ID`);

ALTER TABLE `RecipeHasCategory` ADD CONSTRAINT `RecipeHasCategory_fk0` FOREIGN KEY (`recipeId`) REFERENCES `Recipe`(`ID`);

ALTER TABLE `RecipeHasCategory` ADD CONSTRAINT `RecipeHasCategory_fk1` FOREIGN KEY (`recipeCategory`) REFERENCES `RecipeCategory`(`ID`);

ALTER TABLE `UserScaleAssignment` ADD CONSTRAINT `UserScaleAssignment_fk0` FOREIGN KEY (`userId`) REFERENCES `UserAccount`(`ID`);

ALTER TABLE `UserScaleAssignment` ADD CONSTRAINT `UserScaleAssignment_fk1` FOREIGN KEY (`scale_one`) REFERENCES `IngredientCategory`(`ID`);

ALTER TABLE `UserScaleAssignment` ADD CONSTRAINT `UserScaleAssignment_fk2` FOREIGN KEY (`scale_two`) REFERENCES `IngredientCategory`(`ID`);

ALTER TABLE `UserScaleAssignment` ADD CONSTRAINT `UserScaleAssignment_fk3` FOREIGN KEY (`scale_three`) REFERENCES `IngredientCategory`(`ID`);

ALTER TABLE `UserScaleAssignment` ADD CONSTRAINT `UserScaleAssignment_fk4` FOREIGN KEY (`scale_four`) REFERENCES `IngredientCategory`(`ID`);

ALTER TABLE `UserScaleAssignment` ADD CONSTRAINT `UserScaleAssignment_fk5` FOREIGN KEY (`scale_five`) REFERENCES `IngredientCategory`(`ID`);

ALTER TABLE `UserScaleAssignment` ADD CONSTRAINT `UserScaleAssignment_fk6` FOREIGN KEY (`scale_six`) REFERENCES `IngredientCategory`(`ID`);

