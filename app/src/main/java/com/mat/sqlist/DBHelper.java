package com.mat.sqlist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by prk on 10/24/2017.
 */

public class DBHelper extends SQLiteOpenHelper {

    public final static String bookTable = "BookTable";
    public final static String bookId = "bookId";
    public final static String bookName = "bookName";
    public final static String bookPrice = "bookPrice";
    private static final String DATABASE_NAME = "db";
    private static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + bookTable + "(" +
                bookId + " INTEGER PRIMARY KEY," +
                bookName + " TEXT," +
                bookPrice + " INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + bookTable);
        onCreate(db);
    }

    public boolean insertBook(int id, String name, int price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues value = new ContentValues();

        value.put(bookId, id);
        value.put(bookName, name);
        value.put(bookPrice, price);

        db.insert(bookTable, null, value);
        return true;
    }

    public Cursor getCurrency() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("SELECT * FROM " + bookTable, null);
    }

}
