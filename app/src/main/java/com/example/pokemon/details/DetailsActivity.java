package com.example.pokemon.details;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;
import com.example.pokemon.MainViewModel;
import com.example.pokemon.R;

public class DetailsActivity extends AppCompatActivity {
    private DetailsViewModel detailsViewModel;

    private ImageView ivBack;
    private ImageView ivItem;
    private TextView tvName;
    private TextView tvTypes;
    private String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ivBack = findViewById(R.id.iv_back);
        ivItem = findViewById(R.id.iv_item);
        tvName = findViewById(R.id.tv_name);
        tvTypes = findViewById(R.id.tv_type);

        Intent intent = getIntent();
        if (intent != null) {
            id = intent.getExtras().getString("id", "");
        }

        ivBack.setOnClickListener(v -> onBackPressed());

        detailsViewModel = new ViewModelProvider( this).get(DetailsViewModel.class);
        detailsViewModel.setActivity(this);
        detailsViewModel.getDataById(id).observe(this, dataItemTable -> {
            Glide.with(this)
                    .load(dataItemTable.getImgLarge())
                    .into(ivItem);

            tvName.setText(dataItemTable.getName());
            tvTypes.setText(dataItemTable.getTypes());
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}