package com.example.pokemon;

import android.app.Activity;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.pokemon.model.DataItem;
import com.example.pokemon.model.GetDataResponse;
import com.example.pokemon.network.Connection;
import com.example.pokemon.network.RetrofitClient;
import com.example.pokemon.room.MasterDao;
import com.example.pokemon.room.database.MasterDatabase;
import com.example.pokemon.room.table.DataItemTable;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {
    private static final String TAG = "MainRepository";

    private Activity activity;
    private MasterDatabase masterDatabase;
    private MasterDao masterDao;

    public MainRepository(Activity activity) {
        this.activity = activity;
        masterDatabase = MasterDatabase.getDatabase(activity);
        masterDao = masterDatabase.masterDao();
    }

    public void getDatasFromServer(MainViewModelCallback callback) {
        if (Connection.isNetworkAvailable(activity)) {
            Call<GetDataResponse> call = RetrofitClient.getInstance().getMyApi().getDatas();
            call.enqueue(new Callback<GetDataResponse>() {
                @Override
                public void onResponse(Call<GetDataResponse> call, Response<GetDataResponse> response) {
                    List<DataItem> dataItems = response.body().getData();

                    for (DataItem dataItem : dataItems) {
                        DataItemTable dataItemTable = new DataItemTable(dataItem.getId(), dataItem.getName(), dataItem.getTypes().toString(), dataItem.getImages().getSmall(), dataItem.getImages().getLarge());
                        MasterDatabase.databaseWriteExecutor.execute(() -> {
                            masterDao.insert(dataItemTable);
                        });
                    }
                }

                @Override
                public void onFailure(Call<GetDataResponse> call, Throwable t) {
                    t.printStackTrace();
                    callback.onFailure(t.getMessage());
                }
            });
        }
    }

    public LiveData<PagedList<DataItemTable>> getPagedList(PagedList.Config config) {
        DataSource.Factory<Integer, DataItemTable> factory = masterDao.getDataListPaged();
        return new LivePagedListBuilder<>(factory, config).build();
    }
}
