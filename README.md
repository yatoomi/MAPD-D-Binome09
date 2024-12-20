Nous avons ajouté des commentaires détaillés dans le code pour clarifier 
le rôle de chaque classe et méthode dans le cadre du modèle de réseau de Petri.
Ces commentaires visent à faciliter la compréhension du fonctionnement interne
des classes, en particulier pour les nouveaux développeurs qui pourraient être
amenés à travailler sur ce code. En outre, des modifications ont été suggérées
 pour améliorer certaines méthodes :

Dans la classe `Edge`: Nous avons suggéré d'ajouter une validation
dans la méthode `setTokens` et la méthode `refresh` pour éviter que
le nombre de jetons ne devienne négatif. Cette amélioration garantirait
que le système de Petri fonctionne de manière cohérente en évitant des états
non souhaités.

Dans l'interface `IPetriNet`: nous avons ajouté une fonction step() sans argument,
le constructeur de l'interface était quant-à lui pas nécessaire car il est implicite.

Cependant pour les tests, nous avons essayé de réaliser au mieux dans la classe test,
mais il nous reste des difficultés.
