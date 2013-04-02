main-application-adapter-architecture branch
=====================================


- 3 modules sont extraites,
-- main configure et lance l'application (la plupart des "new" se trouvent ici), il dépend de tout le monde
-- application, ne dépend de personne! Déclare les interfaces (minimales, ici Filter) pour les interactions avec le reste du monde (acces disque, bdd, UI,...)
-- adapter.plexus l'implémentation de Filter avec tout ce qui va avec. 
chacun devrait etre dans un module maven séparé pour enforcer la direction des dépendances (trop faible avec les packages)


Afin d'épargner les utilisateurs de savoir que Arguments est construit, puis configuré on peut le construire en un seul appel Arguments.parse().


# Strategie de tests # 
- Main avec un test d'intégration haut niveau - pas ou peu de mocks.
- application avec seulement des tests unitaires
- adapter.plexus, pas ou peu de mocks (s'assurer qu'on utilise bien l'outil http://www.mockobjects.com/2008/11/only-mock-types-you-own-revisited.html)

- [Master](https://github.com/sanlaville/Dojo69-Filtering "master branch") : introduction du dojo 
- [Approval Tests](https://github.com/sanlaville/Dojo69-Filtering/tree/ApprovalTests "Approval Tests branch") : un test d'intégration qui permet par exemple d'écrire rapidement un test sur un code legacy pour pouvoir le refactorer.
- [FilteringTest-ArgumentsMockito](https://github.com/sanlaville/Dojo69-Filtering/tree/FilteringTest-ArgumentsMockito "FilteringTest-ArgumentsMockito branch") : un test unitaire pour la classe `Filtering` sans bouchonner la dépendance externe [maven-filtering](http://maven.apache.org/shared/maven-filtering/ "Maven Filtering Web Site"). Utilisation de [FEST-Assert 2.x](https://github.com/alexruiz/fest-assert-2.x "Fest-Assert 2.x Github Repository") pour pallier aux [limitations de Approval Tests](https://github.com/sanlaville/Dojo69-Filtering/tree/ApprovalTests "Limitations de Approval Tests")
- [FilteringTest-DIP](https://github.com/sanlaville/Dojo69-Filtering/tree/FilteringTest-DIP "FilteringTest-DIP branch") : refactoring du test unitaire pour la classe `Filtering` (écrit dans la branche [FilteringTest-ArgumentsMockito](https://github.com/sanlaville/Dojo69-Filtering/tree/FilteringTest-ArgumentsMockito "FilteringTest-ArgumentsMockito branch")) pour essayer de le rendre plus lisible
