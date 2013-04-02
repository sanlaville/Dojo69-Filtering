main-application-adapter-architecture branch
=====================================


# Découpage : Main - Application - Adaptateur

- **main** configure et lance l'application (la plupart des "new" se trouvent ici), il dépend de tout le monde
- **application**, ne dépend de personne! Déclare les interfaces (minimales, ici Filter) pour les interactions avec le reste du monde (acces disque, bdd, UI,...)
- **adapter.plexus** dépend de "application", implémente Filter avec tout ce qui va avec. 

chacun des modules devrait être dans un module maven séparé pour enforcer 
la direction des dépendances (trop faible avec les packages)


## Strategie de tests
- Main avec un test d'intégration haut niveau - pas ou peu de mocks.
- application avec seulement des tests unitaires
- adapter.plexus, pas ou peu de mocks (s'assurer qu'on utilise bien l'outil http://www.mockobjects.com/2008/11/only-mock-types-you-own-revisited.html). Tests d'intégration bas niveau - on teste la bonne utilisation de l'outil tiers à travers l'interface Filter

Ensuite on peu établir un "Contract Test" tel que proposé par le binôme de Laurent et nommé par JB Rainsberger 
[Contract Tests in Brief](http://legacy.thecodewhisperer.com/post/1325859246/in-brief-contract-tests)
 et [Contract Tests](http://legacy.thecodewhisperer.com/post/1172613515/stub-your-data-access-layer-it-wont-hurt)
afin de garantir que toutes les implementations de Filter remplissent le contrat dont l'application dépend. Ex: FilterTest et PlexusFilterTest

## Hors sujet

Afin d'épargner les utilisateurs de Arguments de savoir que Arguments est construit, puis configuré on peut le construire en un seul appel Arguments.parse().

L'utilisation de mock de Arguments (avec Mockito ou un mock à la main) dans FilteringTest me semble à déconseiller car ça ressemble à un ValueObject, 
cf http://www.mockobjects.com/2007/04/test-smell-everything-is-mocked.html
J'utiliserai plutôt 

        filtering.filter(new Arguments(in, out, filters));

#Branches

- [Master](https://github.com/sanlaville/Dojo69-Filtering "master branch") : introduction du dojo 
- [Approval Tests](https://github.com/sanlaville/Dojo69-Filtering/tree/ApprovalTests "Approval Tests branch") : un test d'intégration qui permet par exemple d'écrire rapidement un test sur un code legacy pour pouvoir le refactorer.
- [FilteringTest-ArgumentsMockito](https://github.com/sanlaville/Dojo69-Filtering/tree/FilteringTest-ArgumentsMockito "FilteringTest-ArgumentsMockito branch") : un test unitaire pour la classe `Filtering` sans bouchonner la dépendance externe [maven-filtering](http://maven.apache.org/shared/maven-filtering/ "Maven Filtering Web Site"). Utilisation de [FEST-Assert 2.x](https://github.com/alexruiz/fest-assert-2.x "Fest-Assert 2.x Github Repository") pour pallier aux [limitations de Approval Tests](https://github.com/sanlaville/Dojo69-Filtering/tree/ApprovalTests "Limitations de Approval Tests")
- [FilteringTest-DIP](https://github.com/sanlaville/Dojo69-Filtering/tree/FilteringTest-DIP "FilteringTest-DIP branch") : refactoring du test unitaire pour la classe `Filtering` (écrit dans la branche [FilteringTest-ArgumentsMockito](https://github.com/sanlaville/Dojo69-Filtering/tree/FilteringTest-ArgumentsMockito "FilteringTest-ArgumentsMockito branch")) pour essayer de le rendre plus lisible
