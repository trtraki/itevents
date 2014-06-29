package com.itevents.fragment;

import android.app.ListFragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.itevents.dao.ItEventsItem;
import com.itevents.adapter.ItEventsListItemAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


/**
 * A fragment representing a list of Items.
 * <p />
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p />
 * interface.
 */
public class IteventsFragment extends ListFragment {
    public RequestQueue vQueue;
    private static List responseObj = new ArrayList();

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (vQueue == null) {
            vQueue = Volley.newRequestQueue(getActivity());
        }

        JSONObject requestJson = new JSONObject();
        try {
            requestJson.put("p", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonArrayRequest jsonArrayRequest = null;
        jsonArrayRequest = new JsonArrayRequest("http://it-events.herokuapp.com/events",
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                        for (int i = 0; i < jsonArray.length(); i++) {
                            try {
                                JSONObject item = (JSONObject) jsonArray.get(i);
                                String title = item.getString("title");
                                String start = item.getString("start");
                                String address = item.getString("address");
                                String url = item.getString("url");
                                ItEventsItem itEventsItem = new ItEventsItem(
                                        title,
                                        start,
                                        address,
                                        url);
                                responseObj.add(itEventsItem);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        ItEventsListItemAdapter adapter = new ItEventsListItemAdapter(
                                getActivity(), (ItEventsItem[]) responseObj.toArray(new ItEventsItem[responseObj.size()]));


                        setListAdapter(adapter);
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        StackTraceElement[] errorMessage = volleyError.getStackTrace();
                        if (errorMessage != null) Log.d("MyApp", errorMessage.toString());
                    }
                }
            );

        vQueue.add(jsonArrayRequest);
        vQueue.start();
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        ListAdapter adapter = l.getAdapter();
        ItEventsItem itEventsItem = (ItEventsItem)adapter.getItem(position);

        Uri uri = Uri.parse(itEventsItem.getUrl());
        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        startActivity(intent);
    }
}
