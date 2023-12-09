package com.example.assignmentmain

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBOpenHelper(context: Context, name: String, factory: SQLiteDatabase.CursorFactory?, version: Int)
    : SQLiteOpenHelper(context, name, factory, version)
{
    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(CREATE_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL(DROP_TABLE)
        db?.execSQL(CREATE_TABLE)
    }

    private val CREATE_TABLE: String = "create table test(" +
    "ID integer primary key autoincrement," +
    "FIRST_NAME string," +
    "LAST_NAME string," +
    "COURSE string" +
    ")"

    private val DROP_TABLE: String = "drop table test"

}