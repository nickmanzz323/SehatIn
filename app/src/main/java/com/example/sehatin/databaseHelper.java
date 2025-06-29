package com.example.sehatin;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
public class databaseHelper extends SQLiteOpenHelper{

    private Context context;
    private static final String DATABASE_NAME = "SehatIn.db";
    public static final int DATABASE_VERSION = 1;

    databaseHelper(@Nullable Context context) {
        super(context, "SehtaIn.db", null, 1);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createUserDatabase = "CREATE TABLE userData (UserID INTEGER PRIMARY KEY AUTOINCREMENT, name VARCHAR(255), email VARCHAR(255), password VARCHAR(255), goal VARCHAR(50), gender VARCHAR(5), active VARCHAR(15), height INT, weight INT, age INT, calorieIntake INT, proteinIntake INT, fatIntake INT, carbIntake INT);";
        db.execSQL(createUserDatabase);

        // Buat query untuk tabel baru disini
        // Contoh:
        // String namaTable = "query...";
        // db.execSQL(namaTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS userData");
        onCreate(db);

        // Drop table yang dibuat disini
        // Contoh:
        // db.execSQL("DROP TABLE IF EXIST namaTable");
        // onCreate(db);
    }

    public void insertUserData(String name, String email, String password, String gender, String goal, String active, int height, int weight, int age, int calorieIntake, int proteinIntake, int fatIntake, int carbIntake){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put("name", name);
        cv.put("email", email);
        cv.put("password", password);
        cv.put("gender", gender);
        cv.put("goal", goal);
        cv.put("active", active);
        cv.put("height", height);
        cv.put("weight", weight);
        cv.put("age", age);
        cv.put("calorieIntake", calorieIntake);
        cv.put("proteinIntake", proteinIntake);
        cv.put("fatIntake", fatIntake);
        cv.put("carbIntake", carbIntake);

        long result = db.insert("userData", null, cv);

        if(result == -1){
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show();
        }
    }

    public Boolean checkEmail(String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from userData where email = ?", new String[]{email});
        return cursor.getCount() > 0;
    }

    public Boolean checkUserPassword(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("Select * from userData where email = ? and password = ?", new String[] {email, password});
        return cursor.getCount() > 0;
    }

    Cursor searchUserData(String email, String password){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery("SELECT * FROM userData WHERE email = ? AND password = ?", new String[] {email, password});
        }
        return cursor;
    }
}

