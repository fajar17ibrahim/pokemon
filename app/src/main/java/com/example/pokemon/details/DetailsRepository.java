package com.example.pokemon.details;

import android.app.Activity;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.pokemon.MainViewModelCallback;
import com.example.pokemon.model.DataItem;
import com.example.pokemon.model.GetDataByIdResponse;
import com.example.pokemon.network.Connection;
import com.example.pokemon.network.RetrofitClient;
import com.example.pokemon.room.MasterDao;
import com.example.pokemon.room.database.MasterDatabase;
import com.example.pokemon.room.table.DataItemTable;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailsRepository {
    private static final String TAG = "DetailsRepository";
    private Activity activity;
    private MasterDatabase masterDatabase;

    private MasterDao masterDao;

    public DetailsRepository(Activity activity) {
        this.activity = activity;
        masterDatabase = MasterDatabase.getDatabase(activity);
        masterDao = masterDatabase.masterDao();
    }

    public void getDataByIdFromServer(DetailsViewModelCallback callback, String id) {
        if (Connection.isNetworkAvailable(activity)) {
            Call<GetDataByIdResponse> call = RetrofitClient.getInstance().getMyApi().getDataById(id);
            call.enqueue(new Callback<GetDataByIdResponse>() {
                @Override
                public void onResponse(Call<GetDataByIdResponse> call, Response<GetDataByIdResponse> response) {
                    DataItem dataItem = response.body().getData();
                    DataItemTable dataItemTable = new DataItemTable(dataItem.getId(), dataItem.getName(), dataItem.getTypes().toString(), dataItem.getImages().getSmall(), dataItem.getImages().getLarge());
                    MasterDatabase.databaseWriteExecutor.execute(() -> {
                        masterDao.insert(dataItemTable);
                    });
                }

                @Override
                public void onFailure(Call<GetDataByIdResponse> call, Throwable t) {
                    t.printStackTrace();
                    callback.onFailure(t.getMessage());
                }
            });
        }
    }

    public LiveData<DataItemTable> getDataById(String id) {
        return masterDao.getDataById(id);
    }
}
