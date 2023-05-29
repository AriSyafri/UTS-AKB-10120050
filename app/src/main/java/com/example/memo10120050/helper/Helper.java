package com.example.memo10120050.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class Helper  extends SQLiteOpenHelper {
    // NIM : 10120050
    // Nama : Ari Syafri
    // Kelas : IF2
    private static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "catatan";

    public Helper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        final String SQL_CREATE_TABLE = "CREATE TABLE users (id INTEGER PRIMARY KEY autoincrement, tanggal TEXT NOT NULL, judul TEXT NOT NULL, kategori TEXT NOT NULL, isi TEXT NOT NULL)";
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS users");
        onCreate(sqLiteDatabase);

    }

    public ArrayList<HashMap<String, String>> getAll(){
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        String QUERY = "SELECT * FROM users";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(QUERY, null);
        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> map = new HashMap<>();
                map.put("id", cursor.getString(0));
                map.put("tanggal", cursor.getString(1));
                map.put("judul", cursor.getString(2));
                map.put("kategori", cursor.getString(3));
                map.put("isi", cursor.getString(4));
                list.add(map);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return list;
    }

    public void insert(String tanggal, String judul, String kategori, String isi) {
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "INSERT INTO users (tanggal,judul,kategori,isi) VALUES('"+tanggal+"', '"+judul+"', '"+kategori+"', '"+isi+"')";
        database.execSQL(QUERY);
    }

    public void update(int id, String tanggal, String judul, String kategori, String isi) {
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "UPDATE users SET tanggal = '"+tanggal+"', judul = '"+judul+"', kategori = '"+kategori+"', isi = '"+isi+"' WHERE id = "+id;
        database.execSQL(QUERY);
    }


    public void delete(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        String QUERY = "DELETE FROM users WHERE ID = "+id;
        database.execSQL(QUERY);
    }


}
