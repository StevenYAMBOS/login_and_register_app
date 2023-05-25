package com.example.login_mysql

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf

/*
SQLiteOpenHelper est une classe dans le langage de programmation Kotlin qui facilite la gestion de la base de données SQLite sur les appareils Android.

SQLiteOpenHelper fournit une abstraction pour créer et mettre à jour la base de données SQLite. Il gère la création initiale de la base de données, la mise à jour de la structure de la base de données lorsque cela est nécessaire et fournit des méthodes pour effectuer des opérations de lecture et d'écriture sur la base de données.

Pour utiliser SQLiteOpenHelper, vous devez créer une sous-classe qui étend SQLiteOpenHelper et implémenter certaines méthodes clés :

1. onCreate(): Cette méthode est appelée lors de la création initiale de la base de données. Vous devez y définir le schéma de la base de données et créer les tables nécessaires.

2. onUpgrade(): Cette méthode est appelée lorsque la version de la base de données change. Vous pouvez y effectuer des opérations de mise à jour de la structure de la base de données, telles que la création de nouvelles tables, l'ajout de colonnes, etc.

3. onDowngrade(): Cette méthode est appelée lorsque la version de la base de données existante est inférieure à la version demandée. Vous pouvez y effectuer des opérations de rétrogradation de la structure de la base de données, telles que la suppression de tables ou de colonnes.

Une fois que vous avez créé votre classe SQLiteOpenHelper personnalisée, vous pouvez l'utiliser pour ouvrir une connexion vers la base de données, obtenir une référence à celle-ci et effectuer des opérations de lecture/écriture à l'aide de méthodes fournies par la classe SQLiteDatabase.

En utilisant SQLiteOpenHelper, vous pouvez gérer facilement la création, la mise à jour et l'accès à la base de données SQLite dans vos applications Android développées en Kotlin.
 */

class DBHelper(context: Context) : SQLiteOpenHelper (context, "UserDB", null, 1) {
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("CREATE TABLE UserDB(username TEXT primary key, password TEXT)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS UserDB")
    }

    fun insertData(username: String, password: String) : Boolean {
        val p0 = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put("username", username)
        contentValues.put("password", password)
        val result = p0.insert("UserDB", null, contentValues)
        if (result == -1.toLong()) {
            return false
        }
        return true
    }

    fun checkUserPassword(username: String, password: String): Boolean {
        val p0 = this.writableDatabase
        val query = "SELECT * FROM UserDB WHERE username = '$username' AND password = '$password'"
        val cursor = p0.rawQuery(query,null)
        if (cursor.count <= 0) {
            cursor.close()
            return false
        }
        cursor.close()
        return true
    }

}