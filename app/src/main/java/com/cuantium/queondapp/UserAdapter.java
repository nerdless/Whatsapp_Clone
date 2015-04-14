package com.cuantium.queondapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends ArrayAdapter<User> {
    public UserAdapter(Context context, ArrayList<User> users) {
        super(context, 0,  users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        User user = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_user, parent, false);
        }
        // Lookup view for data population
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView phone = (TextView) convertView.findViewById(R.id.phone);
        // Populate the data into the template view using the data object
        name.setText(user.getName());
        phone.setText(user.getPhone_number());
        //Log.i("myLog",user.getName()+" nombre esta en adapter");
        //Log.i("myLog",user.getPhone_number()+" telefono esta en adapter");
        //Log.i("myLog","***********************");
        // Return the completed view to render on screen
        return convertView;
    }
}
