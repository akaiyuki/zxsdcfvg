package com.av.avcorelibrary.Object;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by CodeSyaona on 7/11/16.
 */

@Parcel
public class DataObject {


    @SerializedName("list_info")
    private ArrayList<EventListObject> events;


    public ArrayList<EventListObject> getEvents() {
        return events;
    }

}
