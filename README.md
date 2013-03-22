Dojo69-Filtering
================

Git Repository pour la 69e session du CARA Dojo.

## Objectif ##
L'objectif est d'essayer différentes stratégies d'écriture de tests unitaires pour le code proposé : mock ou pas mock, tester uniquement des méthodes publiques ou plus...

Le but n'est pas de définir la meilleur stratégie mais plutôt de confronter différentes pratiques pour écrire des tests unitaires afin de confronter les avantages et inconvénients de chacune.

De plus, nous nous fixons la contrainte de ne pas remettre en cause le choix de la librairie externe utilisée [maven-filtering](http://maven.apache.org/shared/maven-filtering/ "Maven Filtering") afin de se rapprocher du cas où nous devons nous intégrer à un environnement prédéfini.

## Contexte ##
Dans cette session, nous partirons d'un code assez simple qui permet de filter un fichier de propriétés contenant des clés (du style `prop1=${token-prop1}`) à partir de fichiers de filtres contenant les valeurs des clés (du style `token-prop1 = value1`). 

Le projet ne propose volontairement pas de tests unitaires pour les classes Filtering.java, Main.java et StandardFilterWrapper.java car c'est le but de ce dojo de confronter différentes stratégies de tests unitaires pour ces classes.

Pour lancer une exécution :

- packager le projet : mvn clean package
- se placer sous le répertoire target : cd target
- lancer la commande :</br>
	`java -jar dojo69-1.0.0-SNAPHOT.jar test-classes/config.properties test-classes/config-filtered.properties test-classes/filter1.properties test-classes/filter2.properties`
- le fichier de propriété filtré se trouve sous : test-classes/config-filtered.properties

## Déroulement ##
Nous ferons plusieurs groupes avec des stratégies différentes et nous partagerons ensuite sur les différentes pratiques. Nous essayerons de faire 2 itérations de 45 minutes : 30 minutes de codage + 15 minutes d'échanges.

# Branches du projet

- [Master](https://github.com/sanlaville/Dojo69-Filtering "master branch") : introduction du dojo 
- [Approval Tests](https://github.com/sanlaville/Dojo69-Filtering "Approval Tests branch") : un test d'intégration qui permet par exemple d'écrire rapidement un test sur un code legacy pour pouvoir le refactorer.
