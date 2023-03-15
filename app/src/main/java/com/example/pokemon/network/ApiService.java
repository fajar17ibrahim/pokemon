package com.example.pokemon.network;

import com.example.pokemon.model.GetDataResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    String BASE_URL = "https://api.pokemontcg.io/v2/";

    @GET("cards")
    Call<GetDataResponse> getDatas();

    @GET("cards")
    Call<ResponseBody> getDataList();
}
