package com.example.hw04_gymlog_v300.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.hw04_gymlog_v300.Database.entities.GymLog;

import java.util.List;

// DAO - Data access object
@Dao
public interface GymLogDAO {
    // adds records to DB, onConflict will replace current elements in DB if matches
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    // room generates code to make this work
    void insert(GymLog gymLog);

    // static reference to name of table
    // all table names defined in DB class (avoids misspelling)
    @Query("Select * from " + GymLogDatabase.GYM_LOG_TABLE)
    List<GymLog> getAllRecords();
}
