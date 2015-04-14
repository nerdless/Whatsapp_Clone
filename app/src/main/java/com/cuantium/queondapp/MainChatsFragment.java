package com.cuantium.queondapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by nerdless on 27/03/2015.
 */
public class MainChatsFragment extends Fragment {
    ArrayList<User> users = new ArrayList<>();
    //mListView = (ListView) findViewById(R.id.userListView);
    @InjectView(R.id.userListView)
    ListView mListView;
    //private ListView mListView;
    private UserAdapter mAdapter;

    public MainChatsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.inject(this,rootView);

        loadData();
        if (users == null)
            Log.i("myLog", "no hay nada en users");
        else {
            mAdapter = new UserAdapter(getActivity(), users);
            mListView.setAdapter(mAdapter);
        }

        return rootView;

    }

    public void loadData() {
        Realm realm = Realm.getInstance(getActivity());
        RealmResults<User> query = realm.where(User.class)
                .findAll();
        for (User p : query) {
            Log.i("myLog",p.getName()+" esta en loadData");
            users.add(p);
        }
    }

}


