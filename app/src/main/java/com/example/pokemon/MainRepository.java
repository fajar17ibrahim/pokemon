package com.example.pokemon;

import android.app.Activity;
import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import com.example.pokemon.model.DataItem;
import com.example.pokemon.model.GetDataResponse;
import com.example.pokemon.network.RetrofitClient;
import com.example.pokemon.room.MasterDao;
import com.example.pokemon.room.database.MasterDatabase;
import com.example.pokemon.room.table.DataItemTable;
import com.example.pokemon.sqlite.DBHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainRepository {
    private Activity activity;
    private DBHelper dbHelper;

    private MasterDatabase masterDatabase;
    private MasterDao masterDao;


    public MainRepository(Activity activity) {
        this.activity = activity;
        this.dbHelper = new DBHelper(activity);

        masterDatabase = MasterDatabase.getDatabase(activity);
        masterDao = masterDatabase.masterDao();
    }

    private static final String TAG = "MainRepository";

    public void getDatasFromServer(MainViewModelCallback callback) {
        Call<GetDataResponse> call = RetrofitClient.getInstance().getMyApi().getDatas();
        call.enqueue(new Callback<GetDataResponse>() {
            @Override
            public void onResponse(Call<GetDataResponse> call, Response<GetDataResponse> response) {
                List<DataItem> dataItems = response.body().getData();


//                dbHelper.deleteAll();
                for (DataItem dataItem : dataItems) {
                    DataItemTable dataItemTable = new DataItemTable(dataItem.getId(), dataItem.getName(), dataItem.getTypes().toString(), dataItem.getImages().getSmall(), dataItem.getImages().getLarge());
                    MasterDatabase.databaseWriteExecutor.execute(() -> {
                        masterDao.insert(dataItemTable);
                    });
//                    dbHelper.insert(dataItem);
                }

//                callback.onSuccess(dataItems);
            }

            @Override
            public void onFailure(Call<GetDataResponse> call, Throwable t) {
                t.printStackTrace();
//                Toast.makeText(activity, "Error get data", Toast.LENGTH_LONG).show();
                callback.onFailure(t.getMessage());
            }
        });

//        Call<ResponseBody> call = RetrofitClient.getInstance().getMyApi().getDataList();
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    Log.d(TAG, "response " + response.body().toString());
//
////                    JSONObject jsonObject = new JSONObject(response.body().toString());
////                    Log.d(TAG, "response-1 " + jsonObject);
//
//                } catch (Exception e) {
//                    throw new RuntimeException(e);
//                }
////                for (DataItem dataItem : dataItems) {
//
////                    dbHelper.insert(dataItem);
////                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                t.printStackTrace();
//            }
//
//        });
    }

    public LiveData<PagedList<DataItemTable>> getPagedList(PagedList.Config config) {
        DataSource.Factory<Integer, DataItemTable> factory = masterDao.getDataListPaged();
        return new LivePagedListBuilder<>(factory, config).build();
    }
}
