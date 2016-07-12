package com.av.avcorelibrary.Controller.Rest;

import android.util.Log;

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

    private ApiServiceEvent apiServiceEvent;
    private Retrofit retrofit;

    // Api Service Classes
    public static String eventApiService = "ApiServiceEvent.class";


    public RestClient(String className)
    {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy'-'MM'-'dd'T'HH':'mm':'ss'.'SSS'Z'")
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(getAVConfiguration())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        getApiRestService(className);

    }

    public static String getAVConfiguration(){
        if (AVConfiguration.Staging){
            return AVConfiguration.testBaseUrl;
        } else {
            return AVConfiguration.liveBaseUrl;
        }
    }

    public ApiServiceEvent getApiServiceEvent()
    {
        return apiServiceEvent;
    }

    private void getApiRestService(String apiServiceSelected){
        if (apiServiceSelected.equalsIgnoreCase(eventApiService)){
            apiServiceEvent = retrofit.create(ApiServiceEvent.class);
            getApiServiceEvent();
        }
    }


}
