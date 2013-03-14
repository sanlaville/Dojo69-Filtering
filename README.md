Dojo69-Filtering
================

Git Repository pour la 69e session du CARA Dojo.

## Objectif ##
L'objectif est d'essayer différentes stratégies d'écriture de tests unitaires pour le code proposé : mock ou pas mock, tester uniquement des méthodes publiques ou plus...

Le but n'est pas de définir la meilleur stratégie mais plutôt de confronter différentes pratiques pour écrire des tests unitaires afin de confronter les avantages et inconvénients de chacune.

## Contexte ##
Dans cette session, nous partirons d'un code assez simple qui permet de filter un fichier de propriétés contenant des clés (du style prop1=${token-prop1}) et des fichiers de filtres contenant les valeurs des clés (du style token-prop1 = value1). 

L'implantation se base sur la librairie maven-filtering que nous ne remontons pas en cause dans cette session.

Le projet ne propose volontairement pas de tests unitaires pour les classes Filtering.java, Main.java et StandardFilterWrapper.java car c'est le but de ce dojo de confronter différentes stratégies de tests unitaires pour ces classes.

Pour lancer une exécution :

- packager le projet : mvn clean package
- se placer sous le répertoire target : cd target
- lancer la commande : java -jar dojo69-1.0.0-SNAPHOT-jar-with-dependencies.jar test-classes/config.properties test-classes/filter1.properties test-classes/filter2.properties
- le fichier de propriété filtré se trouve sous : test-classes/config.properties_valorized


## Déroulement ##
Nous ferons plusieurs groupes avec des stratégies différentes et nous partagerons ensuite sur les différentes pratiques. Nous essayerons de faire 2 itérations de 45 minutes : 30 minutes de codage + 15 minutes d'échanges.
 