package com.av.avcorelibrary.Controller.Rest;


import com.av.avcorelibrary.Object.DataObject;
import com.google.gson.annotations.SerializedName;
import org.parceler.Parcel;

/**
 * Created by CodeSyaona on 7/11/16.
 */

@Parcel
public class ApiResponse {

    @SerializedName("Message")
    private String message;

    @SerializedName("Data")
    private DataObject data;

    @SerializedName("Status")
    private int status;


    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }


    public DataObject getData() {
        return data;
    }


}
