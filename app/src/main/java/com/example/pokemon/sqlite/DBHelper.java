package com.example.pokemon.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.pokemon.model.DataItem;
import com.example.pokemon.model.Images;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "db_pokemon";
    public static final String TB_MASTER = "tb_master";
    public static final String TB_IMAGES = "tb_images";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TB_MASTER
                + "(id text primary key, name text,types text)");

        db.execSQL("create table " + TB_IMAGES
                + "(id integer primary key autoincrement, small text,large text,master_id text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_MASTER);
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TB_IMAGES);
        onCreate(db);
    }

    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TB_MASTER, null, null);
        db.delete(TB_IMAGES, null, null);
    }

    public boolean insert(DataItem dataItem) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put("id", dataItem.getId());
        contentValues.put("name", dataItem.getName());
        contentValues.put("types", convertArrayToString(dataItem.getTypes()));
        db.insert(TB_MASTER, null, contentValues);

        ContentValues contentValuesImages = new ContentValues();
        contentValuesImages.put("small", dataItem.getImages().getSmall());
        contentValuesImages.put("large", dataItem.getImages().getLarge());
        contentValuesImages.put("master_id", dataItem.getId());
        db.insert(TB_IMAGES, null, contentValuesImages);

        return true;
    }

    @SuppressLint("Range")
    public ArrayList<DataItem> getAllDatas() {
        ArrayList<DataItem> array_list = new ArrayList<DataItem>();

        //hp = new HashMap();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + TB_MASTER, null);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            DataItem dataItem = new DataItem();
            dataItem.setName(res.getString(res.getColumnIndex("name")));
            dataItem.setTypes(convertStringToArray(res.getString(res.getColumnIndex("types"))));

            Cursor resImages = db.rawQuery("select * from " + TB_IMAGES + "where master_id=" + dataItem.getId(), null);
            resImages.moveToFirst();
            resImages.moveToNext();

            while (resImages.isAfterLast() == false) {
                Images images = new Images();
                images.setSmall(resImages.getString(resImages.getColumnIndex("small")));
                images.setLarge(resImages.getString(resImages.getColumnIndex("large")));
                dataItem.setImages(images);
            }
        }
        return array_list;
    }

    public static String strSeparator = "__,__";

    public static String convertArrayToString(List<String> array) {
        String str = "";
        for (int i = 0; i < array.size(); i++) {
            str = str + array.get(i);
            // Do not append comma at the end of last element
            if (i < array.size() - 1) {
                str = str + strSeparator;
            }
        }
        return str;
    }

    public static List<String> convertStringToArray(String str) {
        String[] arr = str.split(strSeparator);
        List<String> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            list.add(arr[i]);
        }
        return list;
    }
}
