package com.av.avcorelibrary.Models.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.av.avcorelibrary.Controller.Realm.RealmController;
import com.av.avcorelibrary.Controller.Rest.ApiResponse;
import com.av.avcorelibrary.Controller.Rest.RestClient;
import com.av.avcorelibrary.Models.Adapter.EventsAdapter;
import com.av.avcorelibrary.Object.EventListObject;
import com.av.avcorelibrary.R;
import com.tuesda.walker.circlerefresh.CircleRefreshLayout;

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
    private Boolean isRefreshing;

    @BindView(R.id.listview_events)
    ListView listView;

    @BindView(R.id.refresh_layout)
    CircleRefreshLayout mRefreshLayout;



    public EventsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* set realm configuration to this fragment */
        realm = RealmController.with(this).getRealm();
        results = RealmController.getInstance().getEvents();

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_events, container, false);

        ButterKnife.bind(this, view);

        if (results.isEmpty()){
            isRefreshing = false;
            requestApiGetEvents();
        }

        mAdapter = new EventsAdapter(getActivity(),R.layout.custom_row_list, results);
        listView.setAdapter(mAdapter);

        mRefreshLayout.setOnRefreshListener(new CircleRefreshLayout.OnCircleRefreshListener() {
            @Override
            public void completeRefresh() {
                mAdapter = new EventsAdapter(getActivity(),R.layout.custom_row_list, results);
                mAdapter.notifyDataSetChanged();
                listView.setAdapter(mAdapter);
            }

            @Override
            public void refreshing() {
                isRefreshing = true;
                RealmController.getInstance().clearAll();
                requestApiGetEvents();
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
                        EventListObject eventListObject = RealmController.getInstance().createEventObject();
                        eventListObject.setEventName(mResultSet.get(i).getEventName());
                        eventListObject.setBannerImage(mResultSet.get(i).getBannerImage());
                    }
                    realm.commitTransaction();
                }

                if (isRefreshing){
                    mRefreshLayout.finishRefreshing();
                }

            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                Log.d("api response", t.getMessage());

                if (isRefreshing){
                    mRefreshLayout.finishRefreshing();
                }

            }
        });
    }


}
