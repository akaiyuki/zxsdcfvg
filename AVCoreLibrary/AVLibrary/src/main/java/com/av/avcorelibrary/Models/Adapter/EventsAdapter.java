package com.av.avcorelibrary.Models.Adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.av.avcorelibrary.Controller.Configuration.AVConfiguration;
import com.av.avcorelibrary.Controller.Core.AppController;
import com.av.avcorelibrary.Object.EventListObject;
import com.av.avcorelibrary.R;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.realm.RealmResults;

/**
 * Created by CodeSyaona on 7/11/16.
 */
public class EventsAdapter extends ArrayAdapter<EventListObject> {

        Context mContext;
        RealmResults<EventListObject> mData;
        int mResId;

        static class ViewHolder {

            @BindView(R.id.eventname) TextView text1;
            @BindView(R.id.imgbanner) ImageView imgBanner;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
            }
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
                holder = new ViewHolder(convertView);

                convertView.setTag(holder);
            }
            else { holder = (ViewHolder) convertView.getTag(); }

            /* populate views */
            EventListObject row = mData.get(position);
            holder.text1.setText(row.getEventName());

            /* adding image background */
            Glide.with(AppController.getInstance())
                    .load(AVConfiguration.mainImageUrl+row.getBannerImage())
                    .into(holder.imgBanner);

            return convertView;
        }

}
