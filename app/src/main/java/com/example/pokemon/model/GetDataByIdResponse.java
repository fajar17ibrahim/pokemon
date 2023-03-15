package com.example.pokemon.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetDataByIdResponse {
    @SerializedName("data")
    private DataItem data;

    public DataItem getData() {
        return data;
    }
}
