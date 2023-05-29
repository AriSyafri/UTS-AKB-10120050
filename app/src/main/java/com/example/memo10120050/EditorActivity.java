package com.example.memo10120050;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.memo10120050.helper.Helper;

public class EditorActivity extends AppCompatActivity {
    // NIM : 10120050
    // Nama : Ari Syafri
    // Kelas : IF2

    private EditText editTanggal,editJudul, editKategori, editIsi;
    private Button btnSave;

    private Helper db = new Helper(this);
    private String id, tanggal, judul, kategori, isi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editor);

        editTanggal = findViewById(R.id.edit_tanggal);
        editJudul = findViewById(R.id.edit_judul);
        editKategori = findViewById(R.id.edit_kategori);
        editIsi = findViewById(R.id.edit_isi);
        btnSave = findViewById(R.id.btn_save);

        id = getIntent().getStringExtra("id");
        tanggal = getIntent().getStringExtra("tanggal");
        judul = getIntent().getStringExtra("judul");
        kategori = getIntent().getStringExtra("kategori");
        isi = getIntent().getStringExtra("isi");

        if (id == null || id.equals("")) {
            setTitle("Tambah Catatan");
        } else {
            setTitle("Edit Catatan");
            editTanggal.setText(tanggal);
            editJudul.setText(judul);
            editKategori.setText(kategori);
            editIsi.setText(isi);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (id == null || id.equals("")){
                        save();
                    } else {
                        edit();
                    }
                } catch (Exception e) {
                    Log.e("Saving", e.getMessage());

                }
            }
        });
    }

    private void save(){
        if (String.valueOf(editTanggal.getText()).equals("") ||
                String.valueOf(editJudul.getText()).equals("") ||
                String.valueOf(editKategori.getText()).equals("") ||
                String.valueOf(editIsi.getText()).equals("")) {
            Toast.makeText(getApplicationContext(), "Silahkan isi semua data", Toast.LENGTH_SHORT).show();
        } else {
            db.insert(editTanggal.getText().toString(),editJudul.getText().toString(),editKategori.getText().toString(),editIsi.getText().toString());
            finish();
        }
    }

    private void edit(){
        if (String.valueOf(editTanggal.getText()).equals("") ||
                String.valueOf(editJudul.getText()).equals("") ||
                String.valueOf(editKategori.getText()).equals("") ||
                String.valueOf(editIsi.getText()).equals("")) {
            Toast.makeText(getApplicationContext(), "Silahkan isi semua data", Toast.LENGTH_SHORT).show();
        } else {
            db.update(Integer.parseInt(id), editTanggal.getText().toString(),editJudul.getText().toString(),editKategori.getText().toString(),editIsi.getText().toString());
            finish();
        }
    }
}