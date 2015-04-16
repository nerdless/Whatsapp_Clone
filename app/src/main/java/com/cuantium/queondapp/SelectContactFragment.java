package com.cuantium.queondapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;

public class SelectContactFragment extends Fragment {
    ArrayList<User> users = new ArrayList<>();
    @InjectView(R.id.chatListView)
    ListView mListView;
    private UserAdapter mAdapter;



    public SelectContactFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.inject(this, rootView);

        loadData();
        if (users == null)
            Log.i("myLog", "no hay nada en la base");
        else {
            mAdapter = new UserAdapter(getActivity(), users);
            mListView.setAdapter(mAdapter);
        }

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id)
            {
//                Realm chatsRealm = Realm.getInstance(getActivity(), "Chats.realm");//hacer esto en base Chat_members y cruzar con type
//                RealmQuery<Chat> query = chatsRealm.where(Chat.class);
//
//                query.equalTo("owner_id", users.get(position).getPhone_number());
//                RealmResults<Chat> chat = query.findAll();

//                if(chat.size() == 0)
                String contact_phone;
                contact_phone = users.get(position).getPhone_number();
                Intent intent = new Intent(getActivity(), ChatActivity.class );
                intent.putExtra("contact_phone", contact_phone);
                intent.putExtra("new_chat",true);
                startActivity(intent);

//                users.get(position)
//                Toast.makeText(getActivity(),
//                        "Click ListItem Number " + position, Toast.LENGTH_LONG)
//                        .show();
            }
        });

        return rootView;

    }



    public void loadData() {
        //getActivity().getFilesDir();
        Realm realm = Realm.getInstance(getActivity(), "Users.realm");
        RealmResults<User> query = realm.where(User.class)
                .findAll();
        for (User p : query) {
            Log.i("myLog",p.getName()+" esta en loadData");
            users.add(p);
        }

    }



}
