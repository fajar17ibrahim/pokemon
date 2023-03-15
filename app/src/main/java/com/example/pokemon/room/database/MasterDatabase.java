package com.example.pokemon.room.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

import com.example.pokemon.room.MasterDao;
import com.example.pokemon.room.table.DataItemTable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {
        DataItemTable.class}, version = 1)

public abstract class MasterDatabase extends androidx.room.RoomDatabase {

    public abstract MasterDao masterDao();
    private static MasterDatabase instance;

    public static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(4);
    public static MasterDatabase getDatabase(Context context) {
        if (instance == null) {
            synchronized (MasterDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                                    MasterDatabase.class, "pokemon")
                            .build();
                }
            }
        }
        return instance;
    }
}
