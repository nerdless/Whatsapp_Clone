package com.cuantium.queondapp;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.UUID;

import butterknife.ButterKnife;
import io.realm.Realm;


public class NewContactActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_contact, menu);
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

    public void addContact(View button) {
        final EditText nameField = (EditText) findViewById(R.id.editName);
        String name = nameField.getText().toString();

        final EditText emailField = (EditText) findViewById(R.id.editEmail);
        String email = emailField.getText().toString();

        final EditText PhoneField = (EditText) findViewById(R.id.editPhone);
        String phone = PhoneField.getText().toString();

        Log.i("myLog","name: "+name);

        Realm realm = Realm.getInstance(getApplicationContext());
        realm.beginTransaction();
        User contact = realm.createObject(User.class);
        contact.setName(name);
        contact.setPhone_number(phone);
        realm.commitTransaction();


        finish();


    }
}
