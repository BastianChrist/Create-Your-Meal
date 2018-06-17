`recipePicture` blob,CREATE TABLE `Recipe` (
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
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES('Palatschinken Grundrezept','1','TRUE','5 - 15','4','ichkoche.at','Für das Palatschinken Grundrezept den Teig zubereiten. Dafür die Eier aufschlagen und gut verquirlen. Die Milch mit dem Mehl rasch glatt rühren, die Eier einmengen und alles mit einer Prise Salz versehen. Die geschmolzene Butter langsam unterrühren. Sollten im Palatschinkenteig Mehlklumpen sein, den Teig durch ein großes Sieb streichen.
Eine flache Pfanne (ideal sind Palatschinken-Pfannen) erhitzen und etwas Butter zerlassen. Mit einem Schöpflöffel soviel Teigmasse einfüllen, dass der Boden gerade dünn bedeckt ist. In die Mitte einleeren und durch Herumschwenken der Pfanne gleichmäßig verteilen.
Die Palatschinke nun auf einer Seite goldbraun werden lassen. Dabei mit mittlerer Hitze arbeiten. Lässt sich die Palatschinke in der Pfanne gut rütteln, kann man sie wenden.
Die zweite Seite ebenfalls goldbraun werden lassen.
Den gesamten Teig auf diese Weise aufbrauchen.
Die fertigen Palatschinken bis zu Füllung warm stellen.
Tipp
Palatschinken sind eine der beliebtesten österreichischen Nachspeisen. Sie können in unterschiedlichen Varianten zubereitet werden und beim Thema Füllung sind der Fantasie auch keine Grenzen gesetzt.
', '150 g Mehl (glatt)
2 Stk. Eier
250 ml Milch
1 EL Butter (geschmolzen)
1 Prise Salz
4 EL Butter (zerlassen, zum Herausbacken)
');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Karottensuppe','1','True','30 - 45','4','ichkoche.at','Karotten in Scheiben schneiden. Kartoffel in Würfel schneiden.
Zwiebel, Karotten, Kartoffel und eine Prise Salz in einen Topf geben und bei geringer Hitze rösten.
Die Gemüsesuppe zugießen.
Aufkochen lassen, dann die Hitze reduzieren und ca. 30 Minuten köcheln lassen.
Den Topf vom Herd nehmen und die Suppe etwas abkühlen lassen.
Die Suppe pürieren, in einen sauberen Topf geben und vorsichtig erhitzen.
Mit Salz und Pfeffer abschmecken.
1El Rahm mit dem Schneebesen unterrühren.
Mit Petersilie und den Vollkornwürfeln garnieren.
', '400 g Karotten
1 Stück Zwiebel (feingehackt)
130 g Kartoffeln (2 Stück)
Salz
Pfeffer
700 ml Gemüsesuppe
1 EL Rahm
Vollkornbrot (in Würfel geschnitten und in Pfanne kurz geröstet)
Petersilie');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Spaghetti Bolognese','3','true','30 - 45','4','ichkoche.at','Für die Spaghetti Bolognese das Faschierte in Olivenöl anbraten, ab und zu umrühren und anschließend salzen. Die Karotten putzen und fein würfeln. Zwiebeln in Ringe schneiden. Alles zusammen mit den Tomaten zum Faschierten geben und zugedeckt rund 10 Minuten mitschmoren lassen. Die Sauce mit etwas Wasser ablöschen, mit dem Suppenwürfel, Salz, Pfeffer und einer Prise Zucker abschmecken. 5 Minuten weiterköcheln lassen. Die Spaghetti in Salzwasser bissfest kochen, abtropfen lassen und mit der Sauce servieren.','250 g Faschiertes
1 EL Olivenöl
2 Stück Karotten
2 Stück Zwiebeln
1 Zehe Knoblauch
 400 g Tomaten (in Stücke geschnitten)
1/2 Stück Suppenwürfel
250 g Spaghetti
');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('','','','','','','','');

