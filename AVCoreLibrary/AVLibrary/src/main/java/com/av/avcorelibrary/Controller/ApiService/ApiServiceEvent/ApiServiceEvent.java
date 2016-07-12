package com.av.avcorelibrary.Controller.ApiService.ApiServiceEvent;

import com.av.avcorelibrary.Controller.Rest.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by CodeSyaona on 7/11/16.
 */
public interface ApiServiceEvent {

    /* api Get Method Call Event */
    @GET("event/public:getEvents:4")
    Call<ApiResponse> getEvent(@Query("venue_id") String venueId, @Query("is_rave") String raveId);

}
