package com.av.avcorelibrary.Controller.Rest;

import com.av.avcorelibrary.Controller.ApiService.ApiServiceEvent.ApiServiceEvent;
import com.av.avcorelibrary.Controller.Configuration.AVConfiguration;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by CodeSyaona on 7/11/16.
 */
public class RestClient {

    private ApiServiceEvent apiService;

    public RestClient()
    {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(AVConfiguration.testBaseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        apiService = retrofit.create(ApiServiceEvent.class);
    }

    public ApiServiceEvent getApiService()
    {
        return apiService;
    }

}
