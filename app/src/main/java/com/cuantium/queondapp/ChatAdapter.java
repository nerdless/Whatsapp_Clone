package com.cuantium.queondapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ChatAdapter extends ArrayAdapter<Chat> {
    public ChatAdapter(Context context, ArrayList<Chat> chats)
    {
        super(context, 0, chats);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Chat chat = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_chat, parent, false);
        }

        //TODO: convert the imageurl to image and set the imageView
        //TODO: convert the last_msg_date to string and set it
        TextView title = (TextView) convertView.findViewById(R.id.chat_title);
        TextView msg_status = (TextView) convertView.findViewById(R.id.msg_status);
        TextView last_msg_date = (TextView) convertView.findViewById(R.id.last_msg_date);
        TextView msg_content = (TextView) convertView.findViewById(R.id.msg_content);

        title.setText(chat.getTitle());
        msg_status.setText(String.valueOf(chat.getLast_msg().getMsg_status()));
        last_msg_date.setText("22/04/15");
        msg_content.setText(String.valueOf(chat.getLast_msg().getContent()));

        return convertView;
    }
}
