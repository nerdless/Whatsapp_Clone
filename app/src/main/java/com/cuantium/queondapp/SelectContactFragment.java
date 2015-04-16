package com.cuantium.queondapp;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.realm.Realm;
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
