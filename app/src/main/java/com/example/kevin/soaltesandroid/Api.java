package com.example.kevin.soaltesandroid;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Kevin on 2/24/2018.
 */

public interface Api{
    String BASE_URL = "https://private-34eb0-indonesianmountain.apiary-mock.com/";

    @GET("questions")
    Call<ArrayList<Pulau>> getPulau();
}
