package com.example.pokemon;

import com.example.pokemon.model.DataItem;

import java.util.List;

public interface MainViewModelCallback {
    void onSuccess(List<DataItem> dataItems);
    void onFailure(String message);
}
