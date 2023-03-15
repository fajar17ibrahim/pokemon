package com.example.pokemon;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemon.adapter.DataItemAdapter;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private MainViewModel mainViewModel;
    private LinearLayoutManager linearLayoutManager;
    private DataItemAdapter dataItemAdapter;
    private NestedScrollView nsvItems;
    private RecyclerView rvItems;
    private ProgressBar pbItems;
    private int page = 1;
    private int limit = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new ViewModelProvider( this).get(MainViewModel.class);
        mainViewModel.setActivity(this);
        mainViewModel.getDatasFromServer();

        nsvItems = findViewById(R.id.nsv_items);
        rvItems = findViewById(R.id.rv_items);
        pbItems = findViewById(R.id.pb_items);

        showData();


    }

    private void showData() {
        linearLayoutManager = new LinearLayoutManager(this);
        dataItemAdapter = new DataItemAdapter(this);

        mainViewModel.getDataItems(page).observe(this, dataItems -> {
            dataItemAdapter.setDataItems(dataItems);
            rvItems.setAdapter(dataItemAdapter);
            rvItems.setLayoutManager(linearLayoutManager);
        });

        nsvItems.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
                    page++;
                    pbItems.setVisibility(View.VISIBLE);
                    mainViewModel.getDataItems(page).observe(MainActivity.this, dataItems -> {
                        pbItems.setVisibility(View.GONE);
                        Log.d(TAG, "dataItems " + dataItems.size());
                        dataItemAdapter.setDataItems(dataItems);
                        rvItems.setAdapter(dataItemAdapter);
                        rvItems.setLayoutManager(linearLayoutManager);
                    });
                }
            }
        });
    }
}