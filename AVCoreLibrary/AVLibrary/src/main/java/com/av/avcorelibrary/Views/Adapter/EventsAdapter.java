package com.av.avcorelibrary.Views.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.av.avcorelibrary.Object.EventListObject;
import com.av.avcorelibrary.R;

import java.util.ArrayList;

import io.realm.RealmResults;

/**
 * Created by CodeSyaona on 7/11/16.
 */
public class EventsAdapter extends ArrayAdapter<EventListObject> {

        Context mContext;
        RealmResults<EventListObject> mData;
        int mResId;

        class ViewHolder{
            TextView text1;
        }

        public EventsAdapter(Context context, int resource, RealmResults<EventListObject> data) {
            super(context, resource, data);
            this.mContext = context;
            this.mResId = resource;
            this.mData = data;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null)
            {
                //Inflate layout
                LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
                convertView = inflater.inflate(mResId, null);
                holder = new ViewHolder();

                holder.text1 = (TextView) convertView.findViewById(R.id.eventname);
                convertView.setTag(holder);
            }
            else { holder = (ViewHolder) convertView.getTag(); }

            /* populate text view */
            EventListObject row = mData.get(position);
            holder.text1.setText(row.getEventName());

            return convertView;
        }

}
