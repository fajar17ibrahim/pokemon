package com.example.pokemon.room.table;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(tableName = "tb_master")
public class DataItemTable {

    @PrimaryKey
    @NonNull
    private String id;
    private String name;
    private String types;
    private String imgSmall;
    private String imgLarge;

    public DataItemTable(String id, String name, String types, String imgSmall, String imgLarge) {
        this.id = id;
        this.name = name;
        this.types = types;
        this.imgSmall = imgSmall;
        this.imgLarge = imgLarge;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTypes() {
        return types;
    }

    public String getImgSmall() {
        return imgSmall;
    }

    public String getImgLarge() {
        return imgLarge;
    }
}
