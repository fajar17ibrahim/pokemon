package com.example.pokemon.network;

import com.example.pokemon.model.GetDataByIdResponse;
import com.example.pokemon.model.GetDataResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiService {
    String BASE_URL = "https://api.pokemontcg.io/v2/";

    @GET("cards")
    Call<GetDataResponse> getDatas();

    @GET("cards/{id}")
    Call<GetDataByIdResponse> getDataById(@Path("id") String id);
}
