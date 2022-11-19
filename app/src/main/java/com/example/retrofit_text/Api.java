package com.example.retrofit_text;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("api/rand.qinghua")
    Call<Data> getJsonData(@Query("format" )String format);


}
