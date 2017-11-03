package com.example.afi.chatpesan;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;

public class MainActivity extends AppCompatActivity {
    public static String pref_1 = "file.main.pesanChat";
    RecyclerView recyclerView;
    AdapterChat adapterChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SharedPreferences sharedPreferences = getSharedPreferences(pref_1, 0);
        String content = sharedPreferences.getString("PesanChat","No_PesanChat");

        try {
            JSONArray jsonArray = new JSONArray(content);
            adapterChat = new AdapterChat(jsonArray);

            recyclerView.setAdapter(adapterChat);
            adapterChat.notifyDataSetChanged();
        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    public void buatPesan(View view) {
        Intent intent = new Intent(this, TulisPesan.class);
        startActivity(intent);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
        startActivity(getIntent());
    }
}
