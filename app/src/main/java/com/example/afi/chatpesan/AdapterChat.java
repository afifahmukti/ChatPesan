package com.example.afi.chatpesan;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by afi on 03/11/2017.
 */

public class AdapterChat extends RecyclerView.Adapter<AdapterChat.ViewHolder>{
    JSONArray jsonArray;

    public AdapterChat(JSONArray jsonArray) {
        this.jsonArray = jsonArray;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.listchat,parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        try {
            JSONObject jsonObject = jsonArray.getJSONObject(position);
            holder.NamaChat.setText(jsonObject.getString("Nama Pengguna"));
            holder.IsiChat.setText(jsonObject.getString("Konten Chat"));
            holder.TanggalChat.setText(jsonObject.getString("Tanggal"));
        }
        catch (JSONException e){
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        return jsonArray.length();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView NamaChat, IsiChat, TanggalChat;
        public ViewHolder(View itemView) {
            super(itemView);
            NamaChat = (TextView) itemView.findViewById(R.id.NamaChat);
            IsiChat = (TextView) itemView.findViewById(R.id.IsiChat);
            TanggalChat = (TextView) itemView.findViewById(R.id.TanggalChat);
        }
    }
}
