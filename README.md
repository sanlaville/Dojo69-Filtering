Zohhak branch
=============
Dans cette branche, nous illustrons l'utilisation de la librairie [zohhak](http://code.google.com/p/zohhak/ "zohhak web site") au travers des tests unitaires [ArgumentsTest](https://github.com/sanlaville/Dojo69-Filtering/blob/zohhak/src/test/java/org/cara/dojo/dojo69/ArgumentsTest.java) et [FilteringTest](https://github.com/sanlaville/Dojo69-Filtering/blob/zohhak/src/test/java/org/cara/dojo/dojo69/FilteringTest.java). 

Cette branche a été initialisé à partir de la branche [FilteringTest-DIP](https://github.com/sanlaville/Dojo69-Filtering/tree/FilteringTest-DIP "FilteringTest-DIP branch") :

- On ne bouchonne pas notre dépendance externe [maven-filtering](http://maven.apache.org/shared/maven-filtering/ "Maven Filtering Web Site")
-  Utilisation d'une implantation simplifiée ArgumentsMock en suivant le [DIP](http://www.objectmentor.com/resources/articles/dip.pdf "Dependency Inversion Principle article") (Dependency Inversion Principle)
- Utilisation de [FEST-Assert 2.x](https://github.com/alexruiz/fest-assert-2.x "Fest-Assert 2.x Github Repository") pour vérifier que les deux fichiers (résultats et de référence) sont identiques

# Zohhak
[Zohhak](http://code.google.com/p/zohhak/ "zohhak web site") facilite l'écriture de tests unitaires avec la possibilité de définir des paramètres d'entrée pour chaque méthode de test dont les valeurs sont déclarées via une annotation `@TestWith`.

Un exemple vaut mieux qu'un long discours
<pre>
@TestWith({
    "clerk,      45'000 USD, GOLD",
    "supervisor, 60'000 GBP, PLATINUM"
})
public void canAcceptDebit(Employee employee, Money money, ClientType clientType) {
    assertTrue(   employee.canAcceptDebit(money, clientType)   );
}
</pre>

**Liens** : [Web Site](http://code.google.com/p/zohhak/ "Zohhak Web Site") | [Full Guide](http://code.google.com/p/zohhak/wiki/FullGuide "Zohhak full guide")

# Discussions
L'intérêt de [Zohhak](http://code.google.com/p/zohhak/ "zohhak web site") est qu'il permet de bien séparer le test unitaire de ses paramètres d'entrées. Ainsi il est possible de rejouer plusieurs fois le test unitaire en faisant varié les paramètres d'entrées. Cela évite d'écrire plusieurs tests unitaires juste pour faire cela. Nous avons un bon exemple dans la classe `ArgumentsTest` où nous avons pu regrouper les deux tests lorsque les arguments sont [inférieurs à 2](https://github.com/sanlaville/Dojo69-Filtering/blob/ApprovalTests/src/test/java/org/cara/dojo/dojo69/ArgumentsTest.java#L10-22) ou [null](https://github.com/sanlaville/Dojo69-Filtering/blob/ApprovalTests/src/test/java/org/cara/dojo/dojo69/ArgumentsTest.java#L24-35) en [une seule méthode](https://github.com/sanlaville/Dojo69-Filtering/blob/zohhak/src/test/java/org/cara/dojo/dojo69/ArgumentsTest.java#L14-31).

##Limitations rencontrées

- [Zohhak](http://code.google.com/p/zohhak/ "zohhak web site") ne nous permet pas pour le moment de définir une exception attendue comme on peut le faire avec JUnit via l'instruction
> `@Test(expected = IllegalArgumentException.class)` ;

- Dans la classe [FilteringTest](https://github.com/sanlaville/Dojo69-Filtering/blob/zohhak/src/test/java/org/cara/dojo/dojo69/FilteringTest.java) il aurait intéressant de pouvoir spécifier la signature suivante : 
> `public void filter_Should_GenerateFilteredFile_WithExpectedKey(String fileToProcess, String fileProcessed, File<String> filters, String expectedFileProcessedPath)`

	Cela n'a pas été possible même avec l'écriture d'une [coercion](http://code.google.com/p/zohhak/wiki/FullGuide#User_types "Zohhak Full Guide")
>	  @Coercion
>	  public File<String> buildFilters(String input) { ... }

	Nous pouvons tout de même noter que cette [coercion](http://code.google.com/p/zohhak/wiki/FullGuide#User_types "Zohhak Full Guide") fonctionne  avec la signature suivante
> `public void filter_Should_GenerateFilteredFile_WithExpectedKey(String fileToProcess, String fileProcessed, File filters, String expectedFileProcessedPath)`

	Dommage que [Zohhak](http://code.google.com/p/zohhak/ "zohhak web site") n'arrive pas à gérer les génériques dans la signature d'une méthode.


# Branches du projet

- [Master](https://github.com/sanlaville/Dojo69-Filtering "master branch") : introduction du dojo 
- [Approval Tests](https://github.com/sanlaville/Dojo69-Filtering/tree/ApprovalTests "Approval Tests branch") : un test d'intégration qui permet par exemple d'écrire rapidement un test sur un code legacy pour pouvoir le refactorer
- [FilteringTest-ArgumentsMockito](https://github.com/sanlaville/Dojo69-Filtering/tree/FilteringTest-ArgumentsMockito "FilteringTest-ArgumentsMockito branch") : un test unitaire pour la classe `Filtering` sans bouchonner la dépendance externe [maven-filtering](http://maven.apache.org/shared/maven-filtering/ "Maven Filtering Web Site"). Utilisation de [FEST-Assert 2.x](https://github.com/alexruiz/fest-assert-2.x "Fest-Assert 2.x Github Repository") pour pallier aux [limitations de Approval Tests](https://github.com/sanlaville/Dojo69-Filtering/tree/ApprovalTests "Limitations de Approval Tests")
- [FilteringTest-DIP](https://github.com/sanlaville/Dojo69-Filtering/tree/FilteringTest-DIP "FilteringTest-DIP branch") : refactoring du test unitaire pour la classe `Filtering` (écrit dans la branche [FilteringTest-ArgumentsMockito](https://github.com/sanlaville/Dojo69-Filtering/tree/FilteringTest-ArgumentsMockito "FilteringTest-ArgumentsMockito branch")) pour essayer de le rendre plus lisible
- [Zohhak](https://github.com/sanlaville/Dojo69-Filtering/tree/zohhak "zohhak branch") : illustration de l'utilisation de la librairie [zohhak](http://code.google.com/p/zohhak/ "zohhak web site") au travers des tests unitaires `ArgumentsTest` et `FilteringTest`
