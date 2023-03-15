package com.example.pokemon.details;

import android.app.Activity;
import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PagedList;

import com.example.pokemon.MainViewModelCallback;
import com.example.pokemon.model.DataItem;
import com.example.pokemon.room.table.DataItemTable;

import java.util.List;

public class DetailsViewModel extends AndroidViewModel {
    private DetailsRepository detailsRepository;
    private Activity activity;

    public DetailsViewModel(@NonNull Application application) {
        super(application);
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
        this.detailsRepository = new DetailsRepository(activity);
    }

    public LiveData<DataItemTable> getDataById(String id) {
        detailsRepository.getDataByIdFromServer(new DetailsViewModelCallback() {
            @Override
            public void onFailure(String message) {
                Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
            }
        }, id);

        return detailsRepository.getDataById(id);
    }
}
