Approval Tests branch
=====================
Dans cette branche, vous trouverez un test d'intégration qui permet par exemple d'écrire rapidement un test sur un code legacy pour pouvoir le refactorer.

Pour cela nous nous appuyons sur la librairie [ApprovalTests](http://approvaltests.sourceforge.net/ "Approval Tests Library") qui facilite l'écrire de tels tests. 

# Approval Tests
Cette librairie n'est actuellement pas disponible dans le repository central de maven. Vous devez donc l'installer sur votre repository local. Suivez les instructions qui se trouve dans le fichier [src\main\lib\README.txt](https://github.com/sanlaville/Dojo69-Filtering/blob/ApprovalTests/src/main/lib/README.txt "Instructions pour installer la librairie Approval Tests")

**Liens** : [Web Site](http://approvaltests.sourceforge.net/ "Approval Tests Library Web Site") | [Blog](http://blog.approvaltests.com/ "Approval Tests Library Blog") | [Source](https://github.com/approvals/ApprovalTests.Java "Approval Tests Library Github Repository") 

# Améliorations
## Lancement du test unitaire MainTest via maven
Pour le moment, cela ne fonctionne pas avec maven. Il faut lancer le test unitaire MainTest dans eclipse.</br>
Si vous savez comment faire, merci de m'envoyer un pull request.

## Approvals
Pour le moment, l'assertion se fait via l'instruction [Approvals.verifyAll("key", keys)](https://github.com/sanlaville/Dojo69-Filtering/blob/ApprovalTests/src/test/java/org/cara/dojo/dojo69/MainTest.java#L23); </br>
Cela fonctionne bien mais il serait plus intéressant de pouvoir directement indiquer à Approval Tests les deux fichiers à tester :

- le fichier produit : config-filtered.properties 
- et le fichier de référence : [MainTest.approvalTests.approved.txt](https://github.com/sanlaville/Dojo69-Filtering/blob/ApprovalTests/src/test/java/org/cara/dojo/dojo69/MainTest.approvalTests.approved.txt)

Il faut sans doute regarder vers l'instruction [Approvals.verify(generateFile)](https://github.com/approvals/ApprovalTests.Java/blob/master/java/org/approvaltests/Approvals.java#L159-162);

## Solutions possibles
Pour contourner ces deux limitations de Approval Tests, il est possible d'utiliser la librairie [FEST-Assert 2.x](https://github.com/alexruiz/fest-assert-2.x "FEST-Assert 2.x Git Repository") comme indiqué dans la section [Approval Tests vs FEST-Assert 2.x](https://github.com/sanlaville/Dojo69-Filtering/tree/FilteringTest-ArgumentsMockito "Approval Tests vs FEST-Assert 2.x")

# Branches du projet

- [Master](https://github.com/sanlaville/Dojo69-Filtering "master branch") : introduction du dojo 
- [Approval Tests](https://github.com/sanlaville/tree/ApprovalTests "Approval Tests branch") : un test d'intégration qui permet par exemple d'écrire rapidement un test sur un code legacy pour pouvoir le refactorer.
- [FilteringTest-ArgumentsMockito](https://github.com/sanlaville/Dojo69-Filtering/tree/FilteringTest-ArgumentsMockito "FilteringTest-ArgumentsMockito branch") : un test unitaire pour la classe `Filtering` sans bouchonner la dépendance externe [maven-filtering](http://maven.apache.org/shared/maven-filtering/ "Maven Filtering Web Site"). Utilisation de [FEST-Assert 2.x](https://github.com/alexruiz/fest-assert-2.x "Fest-Assert 2.x Github Repository") pour pallier aux [limitations de Approval Tests](https://github.com/sanlaville/Dojo69-Filtering/tree/ApprovalTests "Limitations de Approval Tests")
