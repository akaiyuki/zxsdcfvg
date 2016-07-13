package com.av.avcorelibrary.Models.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.av.avcorelibrary.Controller.Core.AVEngine;
import com.av.avcorelibrary.Controller.Core.BaseActivity;
import com.av.avcorelibrary.Controller.Rest.ApiResponse;
import com.av.avcorelibrary.Controller.Rest.RestClient;
import com.av.avcorelibrary.Models.Adapter.EventsAdapter;
import com.av.avcorelibrary.Object.EventListObject;
import com.av.avcorelibrary.R;
import com.av.avcorelibrary.Views.Gesture.SwipeActivity;
import com.av.avcorelibrary.Views.SlidingPanel.SlidingDrawerActivity;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.Realm;
import io.realm.RealmResults;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class EventsFragment extends Fragment {

    private EventsAdapter mAdapter;
    private ArrayList<EventListObject> mResultSet = new ArrayList<>();
    private Realm realm;
    private RealmResults<EventListObject> results;

    @BindView(R.id.listview_events)
    ListView listView;

    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        realm = AVEngine.realmConfiguration((BaseActivity) getActivity());
        results = realm.where(EventListObject.class).findAll();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_events, container, false);

        ButterKnife.bind(this, view);

        if (results.isEmpty()){
            requestApiGetEvents();
        }

        mAdapter = new EventsAdapter(getActivity(),R.layout.custom_row_list, results);
        listView.setAdapter(mAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), SwipeActivity.class));
            }
        });

        return view;
    }

    /* api call */
    private void requestApiGetEvents(){
        RestClient restClient = new RestClient(RestClient.eventApiService);

        Call<ApiResponse> call = restClient.getApiServiceEvent().getEvent("0","1");
        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful()){
                    Log.d("api client response", response.body().getMessage());

                    /* fetching json objects from api */
                    mResultSet.clear();
                    mResultSet.addAll(response.body().getData().getEvents());
                    mAdapter.notifyDataSetChanged();

                    realm.beginTransaction();
                    for (int i = 0; i<mResultSet.size(); i++){
                        EventListObject eventListObject = realm.createObject(EventListObject.class);
                        eventListObject.setEventName(mResultSet.get(i).getEventName());
                        eventListObject.setBannerImage(mResultSet.get(i).getBannerImage());
                    }
                    realm.commitTransaction();
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.d("api response", t.getMessage());
            }
        });
    }


}
