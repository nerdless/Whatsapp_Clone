package com.cuantium.queondapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;


public class ChatActivity extends ActionBarActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Bundle extras = getIntent().getExtras();
        String[] users_phones = extras.getStringArray("users_phones");


        Realm chatsRealm = Realm.getInstance(this, "Users.realm");
        RealmQuery<User> query = chatsRealm.where(User.class);
        query.equalTo("phone_number", users_phones[0]);
        //TODO: poner un while para que recorra en todos los usuarios http://realm.io/docs/java/#queries
        RealmResults<User> user = query.findAll();

        Toast.makeText(this,
                        "El user es " + user.get(0).getName(), Toast.LENGTH_LONG)
                        .show();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_chat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
