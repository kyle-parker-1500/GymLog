package com.example.hw04_gymlog_v300.database;

import android.app.Application;
import android.util.Log;

import com.example.hw04_gymlog_v300.database.entities.GymLog;
import com.example.hw04_gymlog_v300.MainActivity;
import com.example.hw04_gymlog_v300.database.entities.User;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class GymLogRepository {
    private GymLogDAO gymLogDAO;
    private final UserDAO userDAO;

    private ArrayList<GymLog> allLogs;

    // helps with singleton processes
    private static GymLogRepository repository;

    // constructor
    // made this a singleton (only one instance of GymLogRepository)
    private GymLogRepository(Application application) {
        GymLogDatabase db = GymLogDatabase.getDatabase(application);
        this.gymLogDAO = db.gymLogDAO();
        this.userDAO = db.userDAO();
        // casting this into an ArrayList -> casting a List to an ArrayList is easy bc of inheritance (ArrayList Inherits from List)
        this.allLogs = (ArrayList<GymLog>) this.gymLogDAO.getAllRecords();
    }

    // main code for singleton GymLogRepository
    public static GymLogRepository getRepository(Application application) {
        // helps with singleton processes
        if (repository != null) {
            return repository;
        }
        // submitting a task to future
        Future<GymLogRepository> future = GymLogDatabase.databaseWriteExecutor.submit(
                new Callable<GymLogRepository>() {
                    @Override
                    public GymLogRepository call() throws Exception {
                        return new GymLogRepository(application);
                    }
                }
        );
        try {
            return future.get();
        } catch (InterruptedException | ExecutionException e) {
            Log.i(MainActivity.TAG, "Problem when getting GymLogRepository, thread error.");
        }
        // once safe to return
        return null;
    }

    public ArrayList<GymLog> getAllLogs() {
        // gets a reference to something (this will be fulfilled at some point in the future)
        // gonna run in the background while other stuff happens
        Future<ArrayList<GymLog>> future = GymLogDatabase.databaseWriteExecutor.submit(
                // uses this on a thread-> don't make db calls on main ui thread
                // anonymous inner class
                new Callable<ArrayList<GymLog>>() {
                    @Override
                    public ArrayList<GymLog> call() throws Exception {
                        return (ArrayList<GymLog>) gymLogDAO.getAllRecords();
                    }
                }
        );
        // inner class throws exception, immediately trying to return the future
        // if thread gets interrupted or something causes the anonymous inner class to fail, throws exception
        try {
            // gonna try to pull info out of future object
            return future.get();
        // if it fails it'll output this
        } catch (InterruptedException | ExecutionException e) {
            Log.i(MainActivity.TAG, "Problem when getting all GymLogs in the repository");
        }
        // safely return null, may not want to always return null
        return null;
    }

    public void insertGymLog(GymLog gymLog) {
        GymLogDatabase.databaseWriteExecutor.execute(() -> {
            gymLogDAO.insert(gymLog);
        });
    }
    public void insertUser(User... user) {
        GymLogDatabase.databaseWriteExecutor.execute(() -> {
            userDAO.insert(user);
        });
    }
}
