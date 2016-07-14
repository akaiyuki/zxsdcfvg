package com.av.avcorelibrary.Realm;

import android.app.Activity;
import android.app.Application;
import android.support.v4.app.Fragment;

import com.av.avcorelibrary.Object.EventListObject;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by CodeSyaona on 7/13/16.
 */
public class RealmController {

    private static RealmController mInstance;
    private final Realm mRealm;

    public RealmController(Application application) {
        mRealm = Realm.getDefaultInstance();
    }

    public static RealmController with(Fragment fragment) {

        if (mInstance == null) {
            mInstance = new RealmController(fragment.getActivity().getApplication());
        }
        return mInstance;
    }

    public static RealmController with(Activity activity) {

        if (mInstance == null) {
            mInstance = new RealmController(activity.getApplication());
        }
        return mInstance;
    }

    public static RealmController with(Application application) {

        if (mInstance == null) {
            mInstance = new RealmController(application);
        }
        return mInstance;
    }

    public static RealmController getInstance() {

        return mInstance;
    }

    public Realm getRealm() {

        return mRealm;
    }


    //delete event class
    public void clearAll() {

        mRealm.beginTransaction();
        mRealm.delete(EventListObject.class);
        mRealm.commitTransaction();
    }

    //find all objects
    public RealmResults<EventListObject> getEvents() {

        return mRealm.where(EventListObject.class).findAll();
    }

    //query a single item with the given id
    public EventListObject getEvent(String id) {

        return mRealm.where(EventListObject.class).equalTo("event_id", id).findFirst();
    }

    //create realm event object
    public EventListObject createEventObject(){
        return mRealm.createObject(EventListObject.class);
    }


    //query event example
    public RealmResults<EventListObject> queryedEvents() {

        return mRealm.where(EventListObject.class)
                .contains("event_name", "Tuesdays at Chaos")
                .or()
                .contains("venue_name", "Chaos")
                .findAll();

    }
}
