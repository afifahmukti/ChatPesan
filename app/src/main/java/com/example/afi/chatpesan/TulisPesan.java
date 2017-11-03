package com.example.afi.chatpesan;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class TulisPesan extends AppCompatActivity {
    SharedPreferences sp;
    SharedPreferences.Editor spEdit;
    EditText NamaChat, IsiChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tulis_pesan);

        getSupportActionBar().setTitle("Buat Pesan");

        NamaChat = (EditText) findViewById(R.id.editnama);
        IsiChat = (EditText) findViewById(R.id.editchat);

        sp = getSharedPreferences(MainActivity.pref_1, 0);
        spEdit = sp.edit();

    }

    public void kirim(View view) {
        JSONObject jsonObject = new JSONObject();

        try{
            jsonObject.put("Nama Pengguna", NamaChat.getText().toString());
            jsonObject.put("Konten Chat", IsiChat.getText().toString());
            jsonObject.put("Tanggal", new SimpleDateFormat("dd-MM-yyyy").format(Calendar.getInstance().getTime()));
        }
        catch (JSONException e){
            e.printStackTrace();
        }

        if (sp.contains("PesanChat")){
            String content = sp.getString("PesanChat","No_PesanChat");
            try{
                JSONArray jsonArray = new JSONArray(content);
                jsonArray.put(jsonObject);
                spEdit.putString("PesanChat",jsonArray.toString());
                spEdit.apply();
            }
            catch (JSONException e){
                e.printStackTrace();
            }
        }
        else {
            JSONArray jsonArray = new JSONArray();
            jsonArray.put(jsonObject);
            spEdit.putString("PesanChat",jsonArray.toString());
            spEdit.apply();
        }
        finish();
    }

}
