package com.example.pokemon;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokemon.adapter.DataItemAdapter;
import com.example.pokemon.details.DetailsActivity;

public class MainActivity extends AppCompatActivity implements DataItemAdapter.Callback {
    private static final String TAG = "MainActivity";
    private MainViewModel mainViewModel;
    private LinearLayoutManager linearLayoutManager;
    private DataItemAdapter dataItemAdapter;
    private NestedScrollView nsvItems;
    private TextView tvNoItem;
    private RecyclerView rvItems;
    private ProgressBar pbItems;
    private int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainViewModel = new ViewModelProvider( this).get(MainViewModel.class);
        mainViewModel.setActivity(this);
        mainViewModel.getDatasFromServer();

        tvNoItem = findViewById(R.id.tv_no_item);
        nsvItems = findViewById(R.id.nsv_items);
        rvItems = findViewById(R.id.rv_items);
        pbItems = findViewById(R.id.pb_items);

        showData();
    }

    private void showData() {
        linearLayoutManager = new LinearLayoutManager(this);
        dataItemAdapter = new DataItemAdapter(this, this);

        mainViewModel.getDataItems(page).observe(this, dataItems -> {
            if (dataItems.size() > 0) {
                rvItems.setVisibility(View.VISIBLE);
                tvNoItem.setVisibility(View.GONE);

                dataItemAdapter.setDataItems(dataItems);
                rvItems.setAdapter(dataItemAdapter);
                rvItems.setLayoutManager(linearLayoutManager);
            } else {
                rvItems.setVisibility(View.GONE);
                tvNoItem.setVisibility(View.VISIBLE);
            }
        });

        nsvItems.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
                    page++;
                    pbItems.setVisibility(View.VISIBLE);
                    mainViewModel.getDataItems(page).observe(MainActivity.this, dataItems -> {
                        Log.d(TAG, "dataItems " + dataItems.size());
                        if (dataItems.size() > 0) {
                            rvItems.setVisibility(View.VISIBLE);
                            tvNoItem.setVisibility(View.GONE);
                            pbItems.setVisibility(View.GONE);

                            dataItemAdapter.setDataItems(dataItems);
                            rvItems.setAdapter(dataItemAdapter);
                            rvItems.setLayoutManager(linearLayoutManager);
                        } else {
                            rvItems.setVisibility(View.GONE);
                            tvNoItem.setVisibility(View.VISIBLE);
                        }
                    });
                }
            }
        });
    }

    @Override
    public void onItemClick(String id) {
        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        intent.putExtra("id", id);
        startActivity(intent);
    }
}