// might cause an error for Steven! ~16:30 video 3
package com.example.hw04_gymlog_v300.database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.hw04_gymlog_v300.database.entities.GymLog;
import com.example.hw04_gymlog_v300.MainActivity;
import com.example.hw04_gymlog_v300.database.typeConverters.LocalDateTypeConverter;

import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@TypeConverters(LocalDateTypeConverter.class)
@Database(entities = {GymLog.class}, version = 1, exportSchema = false)
public abstract class GymLogDatabase extends RoomDatabase {

    private static final String DATABASE_NAME = "GymLog_database";
    // names of tables go here
    public static final String GYM_LOG_TABLE = "gymLogTable";

    // volatile -> only lives in ram
    private static volatile GymLogDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4; // multithreading!!!

    // says: create service to supply threads
    // create @ startup and put in pool -> DB will have max of 4 threads
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static GymLogDatabase getDatabase(final Context context) {
        // INSTANCE not obj -> don't need .equals()
        if (INSTANCE == null) {
            // locks stuff into single thread
            // makes sure nothing is referencing our class (only want one instance of db)
            synchronized (GymLogDatabase.class) {
                // .fallbackToDestructiveMigration() -> basically helps us if version changes... I think (eg. oh.. I've made a mistake & app doesn't crash)
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            GymLogDatabase.class,
                                DATABASE_NAME
                            )
                            .fallbackToDestructiveMigration()
                            .addCallback(addDefaultValues)
                            .build();
                }
            }
        }
        return INSTANCE;
    }
    // .addCallback() does:
    private static final RoomDatabase.Callback addDefaultValues = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            Log.i(MainActivity.TAG, "DATABASE CREATED!");
            // TODO: add databaseWriteExecutor.execute(() -> {...});
        }
    };

    // for room to handle
    public abstract GymLogDAO gymLogDAO();
}
