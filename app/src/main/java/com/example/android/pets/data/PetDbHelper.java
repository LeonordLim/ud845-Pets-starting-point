package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;

import com.example.android.pets.data.petContract.PetEntry;
/**
 * Created by AllinOne on 13/11/2017.
 */

public class PetDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = PetDbHelper.class.getSimpleName();

    /** Name of the database */
    public static final String DATABASE_NAME = "shelter.db";

    /**
     * Database version. If you change the database schema, you must increment the database version.
     */

    public static final int DATABASE_VERSION = 1;


    /**
     * Construct of a new instance of PetDbHelper
     * @param context of the app
     */
    public PetDbHelper(Context context){
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    public PetDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create a String that contains the SQL statement to create the pets table
             String SQL_CREATE_PETS_TABLE =  "CREATE TABLE " + PetEntry.TABLE_NAME + " ("
                     + PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                     + PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL, "
                     + PetEntry.COLUMN_PET_BREED + " TEXT, "
                     + PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL, "
                     + PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0);";

        /* Execute the SQL statement*/
        db.execSQL(SQL_CREATE_PETS_TABLE);
    }


    /**
     +     * This is called when the database needs to be upgraded.
     +     */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // The database is still at version 1, so there's nothing to do be done here.
    }
}
