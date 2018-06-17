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
VALUES ('Lamm-Burger mit Ratatouille und Blauschimmelkäse','4','true','60+','4','ichkoche.at','Für die Lamm-Patties alle Zutaten in einer Schüssel verrühren, bis die Masse beginnt sich zu verbinden. Fleischmasse in einen Ring drücken, welcher denselben Durchmesser hat, wie die Burger Buns. Laibchen ("Patties") in einer Pfanne mit etwas Olivenöl auf beiden Seiten für ca. 2 Minuten braten. Patties mit dem Blauschimmelkäse belegen und im Backrohr mit Gratinier-Funktion für 1–2 Minuten überbacken.
Die Zucchini waschen, längs halbieren und in ca. 5 mm dicke Würfel schneiden. Paprika waschen, halbieren und entkernen. Fruchtfleisch in kleine Würfel schneiden. Jungzwiebeln putzen und schräg in sehr feine Scheiben/Ringe schneiden.
In einem kleinen Topf etwas Olivenöl erhitzen, Paprika, Zucchini und Jungzwiebeln darin scharf anbraten. Feinblättrig geschnittenen Knoblauch dazugeben, Tomatenmark unterrühren und mit etwas Wasser ablöschen. Mit Salz, Pfeffer und einer Prise Zucker würzen und abschmecken. Etwas einkochen lassen und mit dem abgezupften Thymian vollenden.
Burger Buns halbieren und in einer Pfanne ohne Fett rösten.
Bun-Hälften mit den Lamm-Patties und den restlichen Zutaten befüllen und Lamm-Burger mit Ratatouille und Blauschimmelkäse servieren.
Tipp
Für Lamm-Burger mit Ratatouille und Blauschimmelkäse können natürlich auch klassische Faschierte Laibchen als "Patties" verwendet werden.','4 Brioche Burger Buns
4-8 Stk. Blauschimmelkäse
2 Handvoll Salatblätter (gewaschen)
Für die Lamm-Patties:
600-700 g Lammfaschiertes
Kreuzkümmel
1 Knoblauchzehe (fein gehackt)
Meersalz
Pfeffer (aus der Mühle)
Für das Ratatouille:
 2 Zucchini (klein)
 1 Paprika (rot)
 1 Paprika (gelb)
2 Stangen Jungzwiebel
1 EL Tomatenmark
1-2 Knoblauchzehen (geschält)
Olivenöl (zum Anbraten)
1 Zweig Thymian
Salz
Pfeffer
Zucker
etwas Wasser
');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Nudelsalat','1','false','15','4','ichkoche.at','Für den schnellen, einfachen Nudelsalat die Nudeln Ihrer Wahl nach Packungsanleitung kochen.
In der Zwischenzeit alle Zutaten klein schneiden.
Gemeinsam mit dem Mais in eine große Schüssel geben.
Die fertig gekochten und leicht abgekühlten Nudeln zu den restlichen Zutaten geben und mit der Mayonnaise vermischen.
Den fertigen Nudelsalat ein wenig durchziehen lassen und gut gekühlt servieren.
Hier haben wir eine große Auswahl an weiteren Nudelsalat-Rezepten für Sie.
Tipp
Dieses Nudelsalat Rezept können Sie nach Belieben abwandeln, indem Sie die Pastasorte, die Käsesorte oder das Gemüse austauschen. Sie können Speck oder Schinken verwenden oder auch eine vegetarische Variante mit Tofu machen. Ihrer Kreativität sind keine Grenzen gesetzt. Erlaubt ist, was schmeckt!','500 g Nudeln (Sorte Ihrer Wahl)
 3 Stück Paprika (rot, gelb, grün)
350 g Mais (aus der Dose oder dem Glas)
Käse (Sorte Ihrer Wahl)
200 g Schinken
250 ml Mayonnaise');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Griechischer Salat','1','false','15','1','ichkoche.at','Für den griechischen Salat die ungeschälte Gurke gut waschen und in Stifte, die Tomate in Spalten schneiden. Die Paprikaschote entkernen und in Streifen schneiden. Die Jungzwiebel in Ringe, Basilikum und Schnittlauch fein schneiden. Alle Zutaten in einer Schüssel sanft vermischen.
Für die Marinade alle Zutaten verrühren und den Salat damit abmachen. Den griechischen Salat anrichten, Feta in Würfel schneiden und darüber streuen.
Tipp
Zu griechischem Salat passt resches Weißbrot.','1/4 Salatgurke (ungeschält)
 1 Tomate
 1/2 Paprika (grün)
1 Bund Jungzwiebeln
Basilikum
Schnittlauch
100 g Feta (oder anderer Schafskäse)
Für die Marinade:
1 EL Weinessig
Salz
Pfeffer
2-3 EL Olivenöl');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Boeuf Stroganoff','4','true','25-30','4','ichkoche.at','Für Boeuf Stroganoff zunächst den Lungenbraten in etwa 7 mm breite Streifen schneiden.
Die Zwiebeln fein hacken, Champignons in Scheiben und Gurkerl in feine Streifen schneiden.
Anschließend das Fleisch mit Salz und Pfeffer würzen und in heißem Öl rasch von beiden Seiten 2 Minuten anbraten. Aus der Pfanne heben und warm stellen.
Nun die Zwiebeln im verbliebenen Fett anschwitzen, Champignons beigeben und durchrösten. Mit Fond oder Suppe ablöschen und aufkochen lassen.
Den Sauerrahm mit Paprikapulver sowie Mehl glatt verrühren und zügig in die Sauce einrühren. Gurkerl beigeben und nochmals kurz durchkochen.
Die Filetspitzen wieder untermengen und nur noch kurz ziehen, aber keinesfalls mehr aufkochen lassen.
Das Boeuf Stroganoff kann nun in vorgewärmten Tellern angerichtet werden.','600 g Rindslungenbraten (die Spitze des Filets)
120 g Champignons
80 g Zwiebeln
100 g Essiggurkerl
200 ml Fond (braun, oder Rindsuppe)
100 g Sauerrahm
1 KL Mehl (glatt)
2-3 EL Öl
Salz
Pfeffer (aus der Mühle)
Paprikapukver (edelsüß)');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Gegrillter grüner Spargel mit Speck','1','true','10 - 15','2','ichkoche.at','Für den gegrillten grünen Spargel mit Speck zunächst den Spargel vorbereiten. Dazu die holzigen Enden wegschneiden. Grüner Spargel muss nicht geschält werden.
Den Spargel auf einem Teller mit ein paar Spritzern Olivenöl beträufeln. Salzen und pfeffern. Je drei Spargelstangen mit einem Streifen Speck einwickeln. Die Spargelpäckchen auf den heißen Grill oder in eine bereits heiße Bratpfanne legen und von allen Seiten grillen.
Den gegrillten grünen Spargel mit Speck als Beilage zu Steak oder Gegrilltem servieren.
Tipp
Sie können den gegrillten grünen Spargel mit Speck auch als Hauptspeise reichen.
Wer größere Blättchen an den Spargelstangen hat, kann diese auch wegschneiden oder den Spargel schälen. Grundsätzlich ist das aber nicht notwendig.','12 Stangen Spargel (grün)
4 Streifen Speck (lang)
Olivenöl
Salz (grobkörnig)
Pfeffer (aus der Mühle)');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Kartoffel-Gemüse-Gröstl mit Spiegelei','3','true','15 - 25','2','ichkoche.at','Für das Kartoffel-Gemüse-Gröstl mit Spiegelei die Kartoffeln schälen, in Scheibe schneiden und in einer Pfanne mit Butterschmalz braun braten. Karotten waschen, in Scheiben schneiden und kurz blanchieren. Ebenfalls Bohnen und Mais (wenn tiefgekühlt) blanchieren.
Zwiebel hacken, Knoblauch pressen und zu den Kartoffeln geben. Gemüse abschrecken und ebenfalls mit Kartoffeln mitrösten und würzen.
Ein Ei in eine separate Pfanne aufschlagen und kurz braten. Kartoffel-Gemüse-Mischung in einen Teller geben und Spiegelei oben drauf legen. Das Kartoffel-Gemüse-Gröstl mit Spiegelei gleich servieren.
Tipp
Das Kartoffel-Gemüse-Gröstl mit Spiegelei ist ein herrliches Restlessen und lässt sich auch mit unterschiedlichsten Gemüsearten, wie beispielsweise auch Zucchini zubereiten.','5 Stück Kartoffeln (gekocht)
1/2 Stück Zwiebel
1 Zehe Knoblauch
100 g Mais
2 Stück Karotten
100 g Stangenbohnen
Salz
1 Stück Ei
Pfeffer
Muskat');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Hühnergeschnetzeltes mit Paprika','2','true','15 - 20','2','ichkoche.at','Zuerst den Reis mit der richtigen Menge Wasser aufstellen.
Für Hühnergeschnetzeltes die Hühnerfilets in mundgerechte Stücke schneiden, mit Salz und Pfeffer würzen und in Mehl wenden.
Die Zwiebel und Paprika fein schneiden. Das Fleisch in einer Pfanne mit Olivenöl anbraten, Zwiebel und Paprika zugeben und anbraten.
Paprikapulver und Tomatenmark hinzugeben und mit Suppe und dem Sauerrahm aufgiesen. Einige Minuten einköcheln lassen.
Mit Salz und Pfeffer abschmecken.
Abschließend mit dem Reis in einer Schüssel anrichten.','250 g Hühnerfilet
1 ½ Tassen Reis
1 Stk Zwiebel
2 Stk Paprika
1 EL Paprikapulver
1 EL Mehl
Pfeffer
50 ml Gemüsesuppe
2 EL Sauerrahm
1 EL Tomatenmark
Salz');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Tofu-Gemüse-Wok','3','true','20 - 25','4','ichkoche.at','Für den schnellen Tofu-Gemüse-Wok zunächst das Gemüse putzen, waschen und in mundgerechte Streifen schneiden. Tofu ebenfalls in kleinere Würfel schneiden.
Einen Wok oder eine schwere (am besten gusseiserne) Pfanne erhitzen. Öl eingießen, erhitzen und die Tofu-Streifen darin anbraten. Das geschnittene Gemüse samt Chilischoten beigeben und ca. 2 Minuten weiterbraten. Ingwer, Knoblauch, Sojasauce und Ahornsirup hinzufügen und 1-2 Minuten mitbraten.
Den schnellen Tofu-Gemüse-Wok mit Salz, Pfeffer und Sesamöl abschmecken. In Schalen anrichten, mit Sesamkörnern bestreuen und servieren.
Tipp
Sowohl was die Gemüseauswahl als auch die Würzung betrifft, sind beim schnellen Tofu-Gemüse-Wok dem persönlichen Geschmack keine Grenzen gesetzt. So kann das Wok-Gemüse auch mit Zitronengras, Fisch- oder Chilisauce beliebig aromatisiert werden.','800 g Gemüse (gemischt, nach Marktlage, z.B. Chinakohl, Paprikaschoten, Pak Choi, Zucchini, etc)
2 Chilischoten
500 g Tofu (geräuchert)
4 EL Pflanzenöl
1 TL Ingwer (frisch gehackt)
1 TL Knoblauch (gehackt)
3 EL Sojasauce
1 TL Ahornsirup (oder 1 EL Zucker)
Salz
2 TL Sesamöl
Sesamkörner (zum Garnieren)
Pfeffer');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Geschmortes Huhn mit Garnelen','5','true','60 - 90','4','ichkoche.at','Das Huhn der Länge nach halbieren und in Viertel hacken bzw. mit der Geflügelschere teilen. Die Hühnerteile in eine Schüssel geben, mit Sojasauce übergießen und 30-45 Minuten marinieren. Währenddessen die Teile ab und an wenden und gut mit Sojasauce einstreichen. Nun in einem Wok oder einer schweren Pfanne reichlich Öl erhitzen. Die Hühnerteile aus der Marinade nehmen, abtropfen lassen und im heißen Öl rundum frittieren. Herausnehmen und auf Küchenkrepp abtropfen lassen. Übrig gebliebenes Öl abgießen und den Wok rasch mit einer Küchenrolle auswischen. Die verbliebene Sojasaucen-Marinade gemeinsam mit Reiswein, Honig, Frühlingszwiebeln sowie Sternanis hineingeben und aufkochen lassen. Die Hühnerteile wieder einlegen, so viel heißes Wasser zugießen, dass die Hühnerteile fast bedeckt sind, und 40-50 Minuten weichköcheln lassen. Hühnerstücke wieder herausheben und die Flüssigkeit bei großer Hitze stark einkochen lassen. Inzwischen die Pilze in Streifen schneiden (getrocknete Pilze vorher 20 Minuten in lauwarmem Wasser einweichen). Karotte und Lauch in Scheiben, die Hühnerinnereien in kleinere Würfel schneiden. Das Hühnerfleisch von den Knochen lösen, ebenfalls in mundgerechte Stücke schneiden und warmhalten. Das vorbereitete Gemüse gemeinsam mit den Erbsenschoten, Garnelen und Hühnerinnereien in den Wok geben, aufkochen lassen und 3-4 Minuten auf kleiner Flamme ziehen lassen. Mit in etwas Wasser aufgelöster Maisstärke binden. Das Hühnerfleisch anrichten, die fertige Sauce darübergießen und mit etwas Sesamöl beträufeln.','1 Huhn mit ca. 1,5 kg
4 Hühnerherzen
1 Hühnerleber
8 Garnelen
1 Handvoll Frische oder 20 g getrocknete chin. Pilze
 1 Karotte
1 Lauchstange
1 Handvoll Erbsenschoten
2 Klein gehackte Frühlingszwiebeln
125 ml Sojasauce
1 EL Reiswein
1 Sternanis
1 TL Honig
1 TL Maisstärke
1 TL Sesamöl
Pflanzenöl zum Frittieren
');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Gedämpfte Wantan-Täschchen mit Shrimps und Schweinefleisch','4','true','45 - 60','4','ichkoche.at','Shrimps- und Krebsfleisch fein schneiden, die Pilze klein hacken und beides gemeinsam mit dem Faschierten, mit Zucker, Salz, Pfeffer und Sesamöl vermischen. Mit der Speisestärke gut vermengen und den gehackten Koriander einrühren. Die Teigblätter auflegen und jeweils etwas Füllmasse in die Mitte setzen. Nach Belieben rund ausstechen und zu halbmondförmigen Täschchen zusammenklappen oder die Ecken so übereinanderklappen, dass ein Dreieck entsteht. Die Teigränder dabei mit Wasser befeuchten und gut festdrücken. Auf einen Dämpfeinsatz platzieren und im Bambuskörbchen (oder Topf) zugedeckt 8-10 Minuten dämpfen. Wontons mit etwas Sesamöl beträufeln und mit frisch gehacktem oder geriebenem Ingwer bestreuen. Am besten im Körbchen servieren.
Tipp
Die Füllmasse dieser Wontons kann beliebig, etwa durch gehackte geröstete Erdnüsse, frisch gehackten Ingwer oder Chili, abgewandelt werden.','20 Stück Wantan-Teigblätter (Zutaten für 20 Stück)
200 g Faschiertes Schweinefleisch (möglichst mager)
50 g Speck
200 g Shrimps- und/ oder Krebsfleisch
1 EL Frische chin. Pilze (od. eingeweichte)
Salz
Pfeffer
1/2 EL Zucker
1 TL Sesamöl
1 EL Speisestärke
1 EL Frisch gehacktes Koriandergrün
Sesamöl und Ingwer zum Garnieren');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Caprese','1','false','5','1','ichkoche.at','Für Mozzarella und Tomaten die Tomaten waschen und in Scheiben schneiden. Den Büffelmozzarella ebenso in dünne Scheiben schneiden.
Beides auf einem Teller dekorativ anordnen, mit Olivenöl und Essig beträufeln und mit Basilikumblättern bestreuen. Zusammen mit Baguette servieren.','250 g Büffelmozzarella
 250 g Tomaten
4 EL Olivenöl
1 EL Balsamicoessig
Salz
Basilikumblätter (grob zerzupft)');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Cordon Bleu','3','true','30 - 45','4','ichkoche.at','Erdäpfel im Wasser aufstellen. Dann schälen in Spalten schneiden und mit Petersilie und ein wenig Salz in Butter in der Pfanne schwenken.
Für das Cordon Bleu die Schnitzel auflegen, dünn ausklopfen und dabei darauf achten, dass sie nicht einreißen. Auf beiden Seiten salzen und pfeffern. Auf eine Hälfte jedes Schnitzels eine Scheibe Schinken, eine Scheibe Käse und wieder Schinken legen.
Zusammenklappen und die Ränder entweder mit dem Schnitzelklopfer fest zusammenklopfen oder mit Zahnstochern fixieren.
Eier in einem Suppenteller verschlagen. Nun Schnitzerl zuerst in Mehl wenden, durch das Ei ziehen und in Bröseln wälzen.
In einer großen Pfanne (oder 2 Pfannen) reichlich Öl erhitzen. Cordon Bleus einlegen, goldbraun herausbacken und auf Küchenkrepp abtropfen lassen.
Cordon Bleu mit Erdäpfelsalat oder Petersilerdäpfeln servieren.','4 Stk. Schnitzel (groß, vom Schwein, Kalb oder Hühner)
8 Scheiben Schinken (kleine)
4 Scheiben Käse (Emmentaler oder Gouda)
1-2 Stk. Eier (zum Panieren)
6-8 Erdäpfel
Mehl (zum Panieren)
Semmelbrösel
Pflanzenöl (zum Herausbacken)
Zitronenspalten (zum Garnieren)
Salz
Pfeffer');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Entenbrust mit Gänselebersauce und Birnen-Kartoffel-Gratin','5','true','90 - 120','4','ichkoche.at','Für die Entenbrust mit Gänselebersauce die Kartoffeln ca. 15 Minuten kochen. Sie sollen nicht weich sein, sondern noch schnittfest.
Schälen und in Scheiben schneiden. Die Birne schälen, entkernen und in dünne Scheiben schneiden. Sofort mit Zitronensaft beträufeln.
Creme fraiche, das Ei, Senf und die Gewürze in einer Schüssel mit dem Schneebesen gut abrühren.
Die Kartoffelscheiben abwechselnd mit den Birnenscheiben in vier kleine Gratinförmchen schichten und mit der Sauce begießen.
Im vorgeheizten Backrohr bei 200 Grad etwa 30-40 Minuten garen. Die Entenbrüste auf der Hautseite einschneiden.
In etwas Öl zuerst auf der Hautseite ca. 3 Minuten anbraten, wenden und ebenfalls 2-3 Minuten auf der Fleischseite anbraten.
Das Fleisch mit der Hautseite nach oben auf eine Alufolie legen, die Ränder hochschlagen und im Backofen bei 200 Grad ca. 10-15 Minuten fertigbraten.
Die Kerntemperatur sollte dabei ca. 70 Grad betragen. Die Ente sollte innen noch schön rosa und saftig sein, d. h. eventuell die Garzeit bis zum Erreichen der Kerntemperatur verlängern.
Am Ende der Garzeit unter dem Grill die Haut ca. 2-3 Minuten knusprig grillen.
Für die Gänselebersauce die gewürfelten Schalotten und den gewürfelten Knoblauch zusammen in Butterschmalz anschwitzen und mit Noilly Prat und Wein ablöschen.
Alles zur Hälfte einreduzieren und mit dem Schlagobers aufgießen. Nochmals kräftig einkochen lassen. Die Sauce soll eine sämige Konsistenz erhalten.
Würzen und das Creme fraiche einrühren. Die Gänseleber in einer Extrapfanne kurz abbraten und dann gemeinsam mit der Sauce pürieren, nochmals abschmecken.
Dünne Scheibchen von der Trüffel in die Sauce reiben und vorsichtig umrühren. Einen Saucenspiegel auf den Tellern anrichten, das Gratin darauf drapieren und die Entenbrust in zwei Teile ebenfalls darauflegen.
Die Entenbrust mit Gänselebersauce mit ein paar bunten ganzen Pfefferkörnern dekorieren.','4 Stk Entenbrüste (mit Haut)
Öl (zum Anbraten)
Für die Sauce:
2 Stk Schalotten
1 EL Butterschmalz
1 Zehe Knoblauch
150 ml Noilly Prat
150 ml Weißwein
200 ml Schlagobers
1 EL Creme fraiche
150 g Gänseleber
Trüffel (frische schwarze, alternativ Trüffel aus dem Glas oder Trüffelöl)
Salz
Pfeffer Für das Gratin:
 5 Stk Kartoffeln (große)
1 Stk Birne
1 Stk Ei
1 Becher Creme fraiche
Zitronensaft
1 TL Senf
Salz
Muskatnuß
Pfeffer');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Zucchini-Lauch-Quiche mit Mozzarella','3','true','60 - 90','4','ichkoche.at','Für die Zucchini-Lauch-Quiche den Backofen auf 200 °C vorheizen. Eine Quicheform mit 30 cm Durchmesser mit Backpapier auslegen. Den Mürbteig ausrollen und die Quicheform damit auskleiden.
Den Teig mit Backpapier auslegen, mit Bohnen oder Reis beschweren und ca. 20 Minuten Blindbacken. Die Bohnen bzw. Reis und das Backpapier entsorgen und die Temperatur des Backofens auf 180 °C reduzieren.
Die Eier aufschlagen, den Mascarpone, den kleingeschnittenen Mozzarella und den geriebenen Emmentaler sehr gut unterrühren. Mit den Kräutern, Salz und Pfeffer würzen.
Den Zucchino in dünne Streifen und den Lauch in dünne Ringe schneiden. Die Zwiebel fein würfeln. Das Gemüse auf dem Quicheboden verteilen und die Eiermasse darübergießen.
Die Quiche ca. 40 Minuten backen. Die Beerentomaten darauf verteilen und weitere 2-3 Minuten backen. Die Quiche mit Blattsalat servieren.
Tipp
Die Zucchini-Lauch-Quiche kann man auch mit Pizzakäse oder Fetakäse, anstatt mit Emmentaler machen. Wer es gerne herzhafter hat, kann noch etwas Speck hinzufügen.','300 g Mürbteig (entweder selbstgemacht oder fertig gekauft)
2 Stk Eier
1 Kugel Mozzarella
2 EL Emmentaler (gerieben)
250 g Mascarpone
1/2 Stange Lauch
 1 Stk Zucchino (kleiner gelber)
1 Stk Zwiebel (kleine)
Petersilie (frische)
Schnittlauch (frischer)
Thymian (frischer)
Salz
Pfeffer
50 g Beerentomaten (kleine)');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Burritos','2','true','20','2','ichkoche.at','Hühnerschnitzel in feine Streifen schneiden. Salzen und pfeffern. In einer Pfanne Öl gut erhitzen und die Hühnerstreifen darin rasch braten. Die Tomate in grobe Würfel, die Jungzwiebel in feine Ringe und die Salatblätter in grobe Streifen schneiden. Nun die Hühnerstreifen mit Käse, Tomaten und Jungzwiebelringen vermengen. Die Tortillas nach Belieben in einer beschichteten Pfanne oder im Backrohr kurz anwärmen. Tortillas aufbreiten und die vorbereitete Hühnermasse auftragen. Salsa und Mayonnaise darauf verteilen. Den geschnittenen Salat darüber streuen und einrollen. Dafür
die Tortilla zuerst auf 2 Seiten einklappen und dann von hinten nach vorne einrollen. Auf vorgewärmten Tellern anrichten.','2 Stück Tortillas
200 g Hühnerschnitzel
50 g Käse (gerieben)
 1 Stück Tomate
1 Stück Jungzwiebeln
2 EL Salsa (Würzsauce, im Delikatessenhandel erhältlich)
2 EL Mayonnaise
2 Stück Salatblätter
Öl (zum Braten)');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Chili con Carne','3','true','60 - 90','8','ichkoche.at','Die Paradeiser blanchieren (überbrühen), die Haut abziehen, entkernen und das Fruchtfleisch würfeln. Die Chilischoten fein hacken, zuvor die Kerne entfernen.
Zwiebeln fein hacken und in heißem Butterschmalz goldgelb rösten. Fleisch und Knoblauchzehen dazugeben und mitrösten. Die Paradeiser dazugeben, kurz durchrühren und mit der Rindsuppe aufgießen. Nun alle Gewürze zugeben und 45 Minuten köcheln lassen - falls nötig, noch Suppe zugießen.
Maiskörner und Kidneybohnen in ein Sieb geben und mit kaltem Wasser abspülen. Gut abtropfen lassen und unter das Chili mengen. Noch einmal kurz durchkochen und das Chili con Carne heiß servieren.
Tipp
Richten Sie das Chili con Carne mit einem Tupfen Sauerrahm und frischem Weißbrot an.','1 kg Rindfleisch (faschiert)
250 g Tomaten
3 Chilischoten (grün)
1 große Zwiebel
1 Dose Kidneybohnen
1 Dose Maiskörner
1 Knoblauchzehe (zerdrückt)
1-2 TL Chilipulver
2 TL Zucker
1 Lorbeerblatt
1/2 TL Thymian (gehackt)
2 TL Kreuzkümmel (gemahlen)
1/2 TL Oregano (gehackt)
1/2 TL Pfeffer (frisch gemahlen)
Salz
2 EL Butterschmalz
ca. 300 ml Rindsuppe');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Cevapcici mit Paprika','2','true','45','8','ichkoche.at','Für die Cevapcici mit Paprika zunächst Knoblauch schälen und fein hacken. Paprika waschen, entkernen und in kleine Würfel schneiden. Zwiebeln schälen und in Ringe schneiden.
Faschiertes mit Salz und Pfeffer würzen, mit Knoblauch und Paprika vermengen und mindestens 30 Minuten ruhen lassen.
Danach das Faschierte zu länglichen Cevapcici formen. Eventuell auf Spieße stecken. Am Griller oder in einer Pfanne mit etwas Öl von allen Seiten anbraten.
Cevapcici mit Paprika mit den Zwiebeln bestreut servieren.
Tipp
Cevapcici mit Paprika am besten mit Zwiebelsenf, Ajvar, Tomatenreis oder Salat servieren.','600 g Faschiertes (Rind- und Schweinefleisch oder Lamm- und Rindfleisch)
2 Zwiebel
 4 Paprika (scharf)
3 Knoblauchzehen
Salz
Pfeffer (aus der Mühle)');
INSERT INTO Recipe(name,type, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Porridge','Frühstück','1','true','10','1','ichkoche.at','Für den Porridge die Flüssigkeit, das Salz und die Haferflocken zum Kochen bringen. Alles zusammen ca. 3-4 Minuten köcheln lassen, danach umrühren.
Joghurt und Honig dazugeben, den Porridge mit Zimt bestäuben - und genießen.
Tipp
Wer es fruchtig liebt, kann auch kleingewürfelte Apfel- oder Birnenstückchen in den Porridge geben.','50 g Haferflocken (nach Geschmack)
1 Prise Salz
350 ml Milch (Wasser, oder Mischung)
1 EL Honig
1 EL Joghurt (griechisch)
Zimt');
INSERT INTO Recipe(name,type, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Pancakes','Frühstück','2','true','15','4','ichkoche.at','Für die Pancakes Eier trennen und Eiweiß zu Schnee schlagen. Eigelb verquirlen (3 EL warmes Wasser dazugeben, dann geht der Teig mehr auf) und Buttermilch dazurühren.
Zutaten, wie Mehl und Zucker dazu sieben und nochmals kurz verrühren. Zum Schluss Eischnee unterheben. Butter oder Butterschmalz in einer Pfanne zerrinnen lassen und die Pancakes rausbacken.
Mit Ahornsirup, Staubzucker oder Bacon servieren.
Tipp
Pancakes können in allen möglichen Varianten verfeinert werden. Sie schmecken auch mit Vanilleeis und eignen sich deshalb nicht nur als amerikanisches Frühstück, sondern auch als Dessert.','4 Stk Eier
40 g Staubzucker
150 ml Buttermilch
100 g Mehl (glatt)
1 Prise Salz
Butter (oder Butterschmalz)
Ahornsirup (nach Belieben)
Vanillezucker
Zimt');
INSERT INTO Recipe(name,type, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Topfenkipferl','Frühstück','3','false','45 - 60','5','ichkoche.at','Für die Topfenkipferl die handwarme, weiche Butter mit dem Mehl vermengen.
Nach und nach Topfen, Zitronensafttropfen und das Ei einkneten. Alles zu einem glatten Teig verkneten und für 20 Min abkühlen lassen.
Dann den Teig dünn ausrollen und zu Dreiecke schneiden. Unter der längeren Kannte einen Mokkalöffel Marmelade draufgeben und zu einem Kipferl einrollen.
Bei 190 Grad backen bis die Kipferl goldbraun sind.
Tipp
Die Topfenkipferl können auch mit Nutella gefüllt werden. Auch eine pikante Füllung (Käse, Mozzarella, Schinken oder Salami) schmeckt gut, aber da sollte man die Zitrone weglassen.','260 g Mehl
250 g Butter
250 g Topfen
1 Stk Ei
einige Tropfen Zitronensaft
Marmelade (nach Geschmack)');
INSERT INTO Recipe(name, type,difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Eierspeis mit Zwiebeln und Kernöl','Frühstück','2','true','15','2','ichkoche.at','Für die Eierspeis mit Zwiebeln und Kernöl die Eier in eine Schüssel schlagen und mit Salz sowie Pfeffer würzen. Mit einer Gabel verschlagen.
In einer Pfanne Butter erhitzen und die gehackte Zwiebel darin glasig anschwitzen. Die verschlagenen Eier hineingießen.
Die stockenden Eier mit einer Gabel von allen Seiten vorsichtig immer wieder zur Mitte ziehen, bis sie cremig gestockt sind. Eierspeis mit Zwiebeln auf vorgewärmten Tellern anrichten. Mit fein geschnittenem Schnittlauch bestreuen und mit Kernöl beträufeln.','4 Stück Eier
Butter (zum Andünsten)
1 Stück Zwiebel (fein gehackt)
Salz
Pfeffer
Schnittlauch (fein gehackt)
Kürbiskernöl');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Bunter Thunfischsalat','2','False','20','2','ichkoche.at','Für den Bunten Thunfischsalat Salat in der Salatschleuder bearbeiten oder per Hand waschen, abtropfen lassen und zerteilen. Thunfisch mit Essig, Ö, Senf und den Gewürzen vermischen.
Zwiebelringe, Radieschen, Paprika und den vorbereiteten Salat vermengen und zum Schluss den Thunfisch unter den Salat mischen.','1 Stk. Salat (grün)
 1 Stk. Paprika (grün)
 1 Stk. Paprika (gelb)
 1 Stk. Paprika (rot)
5 Stk. Radieschen (würfelig schneiden)
2 Dose(n) Thunfisch (in eigenem Saft)
1/2 Stk. Zwiebel (würfelig schneiden)
1 Schuss Apfelessig
1 Schuss Olivenöl
2 Zehe(n) Knoblauch
1 Schuss Senf
Salz
Pfeffer');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Kartoffellaibchen','2','true','40','5','ichkoche.at','Für die Kartoffellaibchen alle Zutaten rasch zu einem Teig verarbeiten und daraus Laibchen formen. Mit etwas zerlassener Butter bestreichen und im auf 180° C vorgeheizten Backrohr ca. 25 Minuten backen lassen.
Die fertigen Kartoffellaibchen aus dem Rohr nehmen und heiß genießen.
Tipp
Das Kartoffellaibchen Rezept kann als Beilage und als Hauptgericht serviert werden.',' 500 g Kartoffeln (gekocht und passiert)
5 EL Vollweizenmehl
Salz
1 Stk. Ei
100 g Zwiebeln
1 EL Petersilie
2 EL Butter');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Sommerlicher Nudelsalat','2','false','30','4','ichkoche.at','Für den sommerlichen Nudelsalat die Pasta nach Packungsangabe bissfest garen. Anschließend abgießen und mit kaltem Wasser abbrausen. Die Melone schälen und würfeln. Schnittlauch und Gartenkresse putzen.
Den Schinken in Streifen schneiden. Den Fetakäse würfeln. Olivenöl in einer Pfanne erhitzen, den Schinken zufügen und bei mittlerer Hitze für ca 5 Minuten anbraten.
Anschließend den Schinken aus der Pfanne nehmen und mit der Pasta vermengen. Die Cocktailtomaten in das verbliebene Olivenoel in die Pfanne geben und für ca. 4 Minuten auf mittlerer Hitze backen.
Bis sie beginnen zu platzen. Die Cocktailtomaten mit dem Fett zur Pasta geben und gut vermengen. Die Melonenwürfel, Fetakäse und Schnittlauch untermengen. Mit Salz und Pfeffer evtl. noch nachwürzen.
Zum Schluss noch vorsichtig den Vogerlsalat unterheben. Kurz vorm Servieren mit Gartenkresse bestreuen.
Tipp
Wer lieber keinen Schinken im Nudelsalat möchte, lässt ihn weg oder serviert ihn separat für die anderen Gäste.','230 g Quinoa Fussili
4 EL Olivenöl
80 g Schwarzwälder Schinken (oder Bergschinken)
1 Bund Schnittlauch
250 g Cocktailtomaten
450 g Melone (Honigmelone oder Galia)
75 g Gartenkresse
150 g Fetakäse
2 Handvoll Vogerlsalat
Salz
Pfeffer (schwarz aus der Mühle)');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Die perfekte Grillstelze','4','true','90 - 120','4','ichkoche.at','Für die perfekte Grillstelze zunächst die Stelze vorkochen. Dafür die Stelze in einem Topf mit heißem Wasser zustellen – die Stelze muss ganz mit Wasser bedeckt sein. Mit der ganzen Zwiebel, Kümmel, Lorbeerblatt, Thymian, 3 geschälten, halbierten Knoblauchzehen, Pfefferkörnern und reichlich Salz würzen. Die Stelze in diesem Sud 40 Minuten bei geringer Hitze köcheln.
Herausnehmen, leicht auskühlen lassen und die Schwarte quer zum Knochen alle Zentimeter einschneiden. Vorsicht – nur die Haut, nicht das Fleisch einschneiden!
Mit dem restlichen, in Scheiben geschnittenen Knoblauch spicken und mit Salz einreiben.
Die Stelze auf den Spieß stecken und bei indirekter Hitze und geschlossenem Deckel bei ca. 160 °C grillen.
Kurz vor Ende der Garzeit (nach knapp einer Stunde) noch einmal Kohle nachlegen (bzw. die Temperatur auf 200 °C erhöhen), damit die Schwarte für die perfekte Grillstelze knusprig wird und beim Reinbeißen richtig schön kracht.
Tipp
Wenn man die perfekte Grillstelze während des Grillens immer wieder mit Bier einpinselt, erhält sie einen besonders würzigen Geschmack.','1 Stelze (hintere Stelze vom Schwein)
1/2 Zwiebel
1 EL Kümmel
1 Lorbeerblatt
2 Zweige Thymian
6-7 Knoblauchzehen
6 Pfefferkörner
Salz
Drehspieß (evtl.)');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Tagliatelle mit Lachs-Rahm-Sauce','2','true','20 - 30','4','ichkoche.at','Für die Tagliatelle mit Lachs-Rahm-Sauce die Nudeln bissfest kochen, abseihen. In der Zwischenzeit den Lachs etwas antauen und diesen in Stücke schneiden.
Die Zwiebel fein hacken und im heißen Olivenöl goldbraun anbraten. Die Lachsstücke dazu geben und kurz mitrösten.
Mit Schlagobers aufgießen, den Sauerrahm gut unterrühren, 5 Minuten köcheln lassen und mit Salz, Pfeffer, Zitronensaft, Knoblauch und Suppenwürze nach Geschmack würzen.
Die bissfest gekochten Tagliatelle mit Lachs-Rahm-Sauce auf Tellern anrichten und mit frischer Petersilie bestreuen.','500 g Tagliatelle (oder andere Nudeln)
350 g Lachs
2 Stück Zwiebel
1/2 Becher Schlagobers
1/2 Becher Sauerrahm
Salz (nach Geschmack)
Suppenwürze und Knoblauch (nach Geschmack)
Frische Petersilie
1 EL Olivenöl
Pfeffer (nach Geschmack)
Zitronensaft (nach Geschmack)');
INSERT INTO Recipe(name, difficulty, isWarm, time_needed,servings,source, instructions, ingredients)
VALUES ('Gebratene Schweinsripperln','3','true','60 - 90','4','ichkoche.at','Für Gebratene Schweinsripperln für die Marinade alle Zutaten gut verrühren oder mixen und die Ripperln mindestens einen Tag vor dem Braten mit der Marinade einreiben.
Dann die Ripperln auf ein Blech geben und im vorgeheizten Backrohr bei ca. 165°C 40–55 Minuten knusprig braten. Dabei mehrmals wenden.
Als Beilage zu den Schweinsripperln empfehlen wir Knoblauch- oder Stangenweißbrot, Salate und Saucen nach Geschmack
Tipp
Die Würzung kann nicht nur für Schweinsripperln sondern auch für Schweinsbraten verwendet werden.','2 kg Schweinsrippchen
Marinade:
1 EL Salz (gestrichen voll)
1 EL Kümmel (gestrichen voll)
1/2 TL Pfeffer (aus der Mühle)
30 g Knoblauch (fein gehackt)
50 ml Öl
1 Prise Chilipulver (und/oder Paprikapulver)
1 TL Senf (und 1EL Ketchup, nach Geschmack)');



