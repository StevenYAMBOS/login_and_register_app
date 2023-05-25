**Portail de connexion MySQL/Kotlin**

Ce projet GitHub est une application Android développée en Kotlin qui propose un portail de connexion convivial pour les utilisateurs. L'application offre deux options principales : "S'inscrire" et "Se connecter".

Lorsqu'un utilisateur choisit de s'inscrire, il lui est demandé de fournir un nom d'utilisateur, un mot de passe et de confirmer ce dernier. Des restrictions sont mises en place pour garantir l'intégrité des données saisies. Par exemple, l'application vérifie si l'utilisateur a bien saisi un nom d'utilisateur et un mot de passe et si le mot de passe confirmé correspond au mot de passe initial. Ces vérifications aident à prévenir les erreurs de saisie et à renforcer la sécurité.

La base de données utilisée dans cette application est une base de données SQLite gérée par la classe SQLiteOpenHelper d'Android Studio. Cette approche permet de stocker les informations des utilisateurs de manière sécurisée et efficace.
