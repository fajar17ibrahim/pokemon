package com.example.pokemon;

import android.app.Activity;
import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;

import com.example.pokemon.model.DataItem;
import com.example.pokemon.room.table.DataItemTable;

import java.util.List;

public class MainViewModel extends AndroidViewModel {
    private MainRepository mainRepository;
    private Activity activity;

    public MainViewModel(@NonNull Application application) {
        super(application);
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
        this.mainRepository = new MainRepository(activity);
    }

    public void getDatasFromServer() {
        mainRepository.getDatasFromServer(new MainViewModelCallback() {
            @Override
            public void onFailure(String message) {
                Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public LiveData<PagedList<DataItemTable>> getDataItems(int page) {
        PagedList.Config config = new PagedList.Config.Builder()
                .setPageSize(20)
                .setInitialLoadSizeHint(page * 20)
                .setPrefetchDistance(2)
                .setEnablePlaceholders(false)
                .build();

        return mainRepository.getPagedList(config);
    }
}
