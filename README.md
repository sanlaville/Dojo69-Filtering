FilteringTest-DIP branch
========================
Dans cette branche, nous avons repris le test unitaire pour la classe `Filtering` (écrit dans la branche [FilteringTest-ArgumentsMockito](https://github.com/sanlaville/Dojo69-Filtering/tree/FilteringTest-ArgumentsMockito "FilteringTest-ArgumentsMockito branch")) pour essayer de le rendre plus lisible :

- On ne bouchonne pas notre dépendance externe [maven-filtering](http://maven.apache.org/shared/maven-filtering/ "Maven Filtering Web Site")
-  Utilisation d'une implantation simplifiée ArgumentsMock en suivant le [DIP](http://www.objectmentor.com/resources/articles/dip.pdf "Dependency Inversion Principle article") (Dependency Inversion Principle)
- Utilisation de [FEST-Assert 2.x](https://github.com/alexruiz/fest-assert-2.x "Fest-Assert 2.x Github Repository") pour vérifier que les deux fichiers (résultats et de référence) sont identiques

# Discussions
L'idée du [DIP](http://www.objectmentor.com/resources/articles/dip.pdf "Dependency Inversion Principle article") (Dependency Inversion Principle) est qu'une méthode qui peut être réutilisée dans différents contextes ne doit pas être dépendant d'un contexte particulier. Pour cela, la méthode doit prendre en paramètre une interface générique plutôt qu'un implantation concrète. Pour mieux comprendre, vous pouvez vous référer à l'article [DIP](http://www.objectmentor.com/resources/articles/dip.pdf "Dependency Inversion Principle article") qui montre un exemple avec une méthode `copy`.

Nous avons utilisé le [DIP](http://www.objectmentor.com/resources/articles/dip.pdf "Dependency Inversion Principle article") (Dependency Inversion Principle) sur la classe `Filtering` afin qu'elle prenne en paramètre une interface `IArguments` plutôt que `Arguments`. Cela nous a permis de créer une implantation simplifiée ArgumentsMock pour le test unitaire.

Le [DIP](http://www.objectmentor.com/resources/articles/dip.pdf "Dependency Inversion Principle article") (Dependency Inversion Principle) améliore la réutilisation d'une méthode/classe. Ce principe s'applique bien aux tests car nous pouvons dire qu'un test unitaire est une des premières réutilisation d'une méthode/classe. Nous pouvons voir ici un lien directe avec le fait que le TDD améliore la conception d'une application.

Comme souvent, si nous avons du mal à écrire/lire un test unitaire cela reflète une odeur ("smell") lié à l'implantation. Nous avons pu voir ici que le fait d'avoir voulu améliorer la lisibilité du test unitaire nous a amené à améliorer la conception du code source.

# Approval Tests vs FEST-Assert 2.x
Afin de pallier aux [limitations de Approval Tests](https://github.com/sanlaville/Dojo69-Filtering/tree/ApprovalTests "Limitations de Approval Tests"), nous utilisons cette fois la librairie [FEST-Assert 2.x](https://github.com/alexruiz/fest-assert-2.x "Fest-Assert 2.x Github Repository"). Cette librairie propose la classe [FileAssert](https://github.com/alexruiz/fest-assert-2.x/blob/master/src/main/java/org/fest/assertions/api/FileAssert.java "FileAssert source code") qui nous permet de facilement comparer les deux fichiers (résultats et de référence).

Un autre avantage est qu'il n'est plus nécessaire de rajouter un label (pour distinguer chaque item de la liste des clés) au début de chaque ligne dans le fichier de référence. Du coup, les fichiers de référence et de résultats correspondent bien au format attendu. Un exemple vaut mieux qu'un long discours :

- Avec Approval Tests : `key[1] = key-filter1=sucess: value from filter1`
- Avec FEST-Assert 2.x : `key-filter1=sucess: value from filter1`

Par contre, on perd l'avantage de l'utilisation des [Reporters](http://blog.approvaltests.com/2011/12/using-reporters-in-approval-tests.html "Approval Test Reporters article") de Approval Tests et le fait qu'il nous ouvre automatiquement un outil de merge comme TortoiseDiff ou WinMerge.


# Branches du projet

- [Master](https://github.com/sanlaville/Dojo69-Filtering "master branch") : introduction du dojo 
- [Approval Tests](https://github.com/sanlaville/Dojo69-Filtering/tree/ApprovalTests "Approval Tests branch") : un test d'intégration qui permet par exemple d'écrire rapidement un test sur un code legacy pour pouvoir le refactorer.
- [FilteringTest-ArgumentsMockito](https://github.com/sanlaville/Dojo69-Filtering/tree/FilteringTest-ArgumentsMockito "FilteringTest-ArgumentsMockito branch") : un test unitaire pour la classe `Filtering` sans bouchonner la dépendance externe [maven-filtering](http://maven.apache.org/shared/maven-filtering/ "Maven Filtering Web Site"). Utilisation de [FEST-Assert 2.x](https://github.com/alexruiz/fest-assert-2.x "Fest-Assert 2.x Github Repository") pour pallier aux [limitations de Approval Tests](https://github.com/sanlaville/Dojo69-Filtering/tree/ApprovalTests "Limitations de Approval Tests")
- [FilteringTest-DIP](https://github.com/sanlaville/Dojo69-Filtering/tree/FilteringTest-DIP "FilteringTest-DIP branch") : refactoring du test unitaire pour la classe `Filtering` (écrit dans la branche [FilteringTest-ArgumentsMockito](https://github.com/sanlaville/Dojo69-Filtering/tree/FilteringTest-ArgumentsMockito "FilteringTest-ArgumentsMockito branch")) pour essayer de le rendre plus lisible
