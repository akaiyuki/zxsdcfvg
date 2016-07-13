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

    private static RealmController instance;
    private final Realm realm;

    public RealmController(Application application) {
        realm = Realm.getDefaultInstance();
    }

    public static RealmController with(Fragment fragment) {

        if (instance == null) {
            instance = new RealmController(fragment.getActivity().getApplication());
        }
        return instance;
    }

    public static RealmController with(Activity activity) {

        if (instance == null) {
            instance = new RealmController(activity.getApplication());
        }
        return instance;
    }

    public static RealmController with(Application application) {

        if (instance == null) {
            instance = new RealmController(application);
        }
        return instance;
    }

    public static RealmController getInstance() {

        return instance;
    }

    public Realm getRealm() {

        return realm;
    }


    //clear all objects
    public void clearAll() {

        realm.beginTransaction();
        realm.delete(EventListObject.class);
        realm.commitTransaction();
    }

    //find all objects
    public RealmResults<EventListObject> getEvents() {

        return realm.where(EventListObject.class).findAll();
    }

    //query a single item with the given id
    public EventListObject getEvent(String id) {

        return realm.where(EventListObject.class).equalTo("event_id", id).findFirst();
    }


    //query example
    public RealmResults<EventListObject> queryedEvents() {

        return realm.where(EventListObject.class)
                .contains("event_name", "Tuesdays at Chaos")
                .or()
                .contains("venue_name", "Chaos")
                .findAll();

    }
}
