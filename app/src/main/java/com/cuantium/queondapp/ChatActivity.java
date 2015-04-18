package com.cuantium.queondapp;

import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Random;

import butterknife.ButterKnife;
import butterknife.InjectView;
import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;


public class ChatActivity extends ActionBarActivity {
String title;
Drawable chat_img;
Boolean group_chat = false;
Boolean new_chat = false;
int chat_id;
Random rand = new Random();
Calendar current_time = Calendar.getInstance(); //ver https://docs.oracle.com/javase/6/docs/api/java/text/SimpleDateFormat.html y http://stackoverflow.com/questions/8654990/how-can-i-get-current-date-in-android
String recipient_phone;


@InjectView(R.id.write_msg)
EditText msg;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        Bundle extras = getIntent().getExtras();
        ButterKnife.inject(this);

        new_chat = extras.getBoolean("new_chat");
        if(new_chat)
        {
            recipient_phone = extras.getString("contact_phone");
            Realm usersRealm = Realm.getInstance(this, "Users.realm");
            RealmQuery<User> query = usersRealm.where(User.class);
            query.equalTo("phone_number", recipient_phone);
            RealmResults<User> contact = query.findAll();

            title = " " +contact.get(0).getName();
            //TODO:chage the image for the contact image
            //TODO:get a support method for getDrawable
            chat_img = getDrawable(R.mipmap.user_img);
            group_chat = false;


        }else
        {
//            String[] users_phones = extras.getStringArray("users_phones");
//            Realm chatsRealm = Realm.getInstance(this, "Users.realm");
//            RealmQuery<User> query = chatsRealm.where(User.class);
//            query.equalTo("phone_number", users_phones[0]);
//            //TODO: poner un while para que recorra en todos los usuarios http://realm.io/docs/java/#queries
//            RealmResults<User> user = query.findAll();
        }

        setTitle(title);

        CreateMsgView();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        if(group_chat)
        getMenuInflater().inflate(R.menu.menu_chat, menu);
        else
        getMenuInflater().inflate(R.menu.menu_indv_chat, menu);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(chat_img);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void CreateMsgView()
    {
//        final InputMethodManager myNote = (InputMethodManager) getSystemService(
//                this.INPUT_METHOD_SERVICE);
//        myNote.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);


        msg.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEND)
                {
                    sendMessage();

                    handled = true;
                }
                return handled;
            }
        });
    }

    private void sendMessage()
    {
        //TODO:Algoritm to get a new message id from external database
        //int new_msg_id = rand.nextInt(3000); //Random range just for now, util database
        if(new_chat)
        {
            //TODO:Algoritmo para pedir un new chat_id from external database
            chat_id = rand.nextInt(3000); //Random range just for now, util database

        }


        Log.i("myLog","El msg es "+msg.getText());
        Realm msg_database = Realm.getInstance(this, "Msgs.realm");
        msg_database.beginTransaction();
        Message new_msg = msg_database.createObject(Message.class);
        new_msg.setChat_id(chat_id);
        new_msg.setContent(String.valueOf(msg.getText()));
        new_msg.setCreation_date(current_time.getTime());
        new_msg.setSender_id("owner_id");//TODO:get user phone
        new_msg.setMsg_status(0);
        Log.i("myLog", "Fecha de creacion: " + String.valueOf(current_time.getTime()));
        msg_database.commitTransaction();

        if(new_chat)
        {
            Realm chat_database = Realm.getInstance(this, "Chats.realm");
            chat_database.beginTransaction();
            Chat this_chat = chat_database.createObject(Chat.class);
            this_chat.setChat_id(chat_id);
            this_chat.setCreation_Date(current_time.getTime());
            this_chat.setLast_msg(new_msg);
            this_chat.setOwner_id("owner_id");//TODO:Get user phone
            this_chat.setTitle(title);
            chat_database.commitTransaction();
            Log.i("myLog", "ya hiciste el chat!");
            new_chat = false;

            Realm chat_members_database = Realm.getInstance(this, "Chat_members.realm");
            chat_members_database.beginTransaction();
            Chat_Member new_chat_member = chat_members_database.createObject(Chat_Member.class);
            new_chat_member.setChat_id(chat_id);
            new_chat_member.setGroup_chat(false);
            new_chat_member.setUser_added_by("owner_id");//TODO:Get user phone
            new_chat_member.setUser_added_date(current_time.getTime());
            new_chat_member.setUser_id(recipient_phone);
            chat_members_database.commitTransaction();
        }







        msg.setText("");
    }
}
