package com.example.assignmentmain

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBOpenHelper(context: Context)
    : SQLiteOpenHelper(context, "test.db", null, 1)
{
    // Defining tables and columns
    companion object {
        const val TABLE_NAME = "recipes"
        const val COLUMN_ID = "_id"
        const val COLUMN_RECIPE_TEXT = "recipe_text"
        const val COLUMN_IMAGE_URI = "image_uri"
    }
    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE = ("CREATE TABLE $TABLE_NAME (" +
                "$COLUMN_ID INTEGER PRIMARY KEY," +
                "$COLUMN_RECIPE_TEXT TEXT," +
                "$COLUMN_IMAGE_URI TEXT)")
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DROP_TABLE)
    }

    private val DROP_TABLE: String = "drop table test"

}