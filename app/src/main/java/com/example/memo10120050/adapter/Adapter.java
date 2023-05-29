package com.example.memo10120050.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.memo10120050.R;
import com.example.memo10120050.model.Data;

import java.util.List;

public class Adapter extends BaseAdapter {
    // Nim : 10120050
    // Nama : Ari Syafri
    // Kelas : IF-2

    private Activity activity;
    private LayoutInflater inflater;
    private List<Data> lists;

    public Adapter(Activity activity, List<Data> lists){
        this.activity = activity;
        this.lists = lists;
    }


    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater == null) {
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null && inflater != null) {
            //view = inflater.inflate(R.layout.lists_users, null);
        }

        if (view != null) {

            TextView tanggal = view.findViewById(R.id.text_tanggal);
            TextView judul = view.findViewById(R.id.text_judul);
            TextView kategori = view.findViewById(R.id.text_kategori);
            TextView isi = view.findViewById(R.id.text_isi);

            Data data = lists.get(i);
            tanggal.setText(data.getTanggal());
            judul.setText(data.getJudul());
            kategori.setText(data.getKategori());
            isi.setText(data.getIsi());
        }
        return view;
    }
}
