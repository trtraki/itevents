package com.itevents.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.view.ViewGroup;
import android.widget.TextView;

import com.itevents.dao.ItEventsItem;
import com.itevents.app.R;

public class ItEventsListItemAdapter  extends ArrayAdapter<ItEventsItem> {
    LayoutInflater itEventsLayoutInflater;
    public ItEventsListItemAdapter(Context context, ItEventsItem[] items) {
        super(context, 0, items);
        itEventsLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itEventListView = null;

        if (convertView == null) {
            try {
                itEventListView = itEventsLayoutInflater.inflate(R.layout.fragment_study_list, parent, false);
            } catch (Exception e) {
                Log.e("ItEventListItemAdapter", e.getMessage());
            }
        } else {
            itEventListView = convertView;
        }

        ItEventsItem itEventsItem =  getItem(position);


        TextView titleView = (TextView) itEventListView.findViewById(R.id.title);
        titleView.setText("title:" + itEventsItem.getTitle());

        TextView dateView = (TextView) itEventListView.findViewById(R.id.date);
        dateView.setText("date:" + itEventsItem.getDate());

        TextView prefectureView = (TextView) itEventListView.findViewById(R.id.prefecture);
        prefectureView.setText("prefecture:" + itEventsItem.getPrefecture());


        return itEventListView;
    }
}
