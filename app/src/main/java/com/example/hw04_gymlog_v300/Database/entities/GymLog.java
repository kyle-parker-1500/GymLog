package com.example.hw04_gymlog_v300.Database.entities;

import androidx.room.Entity;

import java.time.LocalDate;

// entity says that the GymLog object will be stored in the database (don't have to supply tableName but good to)
@Entity(tableName = "gymLog")
public class GymLog {
    private int id;

    private String exercise;
    private double weight;
    private int reps;
    private LocalDate date;

}
