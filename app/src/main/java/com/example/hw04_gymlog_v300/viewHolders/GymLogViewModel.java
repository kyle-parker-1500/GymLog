package com.example.hw04_gymlog_v300.viewHolders;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.hw04_gymlog_v300.database.GymLogRepository;
import com.example.hw04_gymlog_v300.database.entities.GymLog;

import java.util.List;

public class GymLogViewModel extends AndroidViewModel {
    // called recycler because it goes on forever
        // generates enough objects to fill display area and stops rendering them after they're out of view (repurposes them for new data)
        // kind of like minecraft chunks
    private final GymLogRepository repository;

    public GymLogViewModel(Application application) {
        super(application);
        repository = GymLogRepository.getRepository(application);
    }

    public LiveData<List<GymLog>> getAllLogsById(int userId) {
        return repository.getAllLogsByUserIdLiveData(userId);
    }

    public void insert(GymLog log) {
        repository.insertGymLog(log);
    }
}
