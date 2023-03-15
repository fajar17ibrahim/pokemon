package com.example.pokemon.room;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.pokemon.model.DataItem;
import com.example.pokemon.room.table.DataItemTable;

import java.util.List;

@Dao
public interface MasterDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(DataItemTable dataItemTable);

    @Query("SELECT * FROM tb_master")
    DataSource.Factory<Integer, DataItemTable> getDataListPaged();
}
