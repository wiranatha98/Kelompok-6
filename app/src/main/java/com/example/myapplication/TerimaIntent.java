package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class TerimaIntent extends AppCompatActivity {
    TextView nama;
    TextView bulan_lahir;
    TextView tahun_lahir;
    TextView umur;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terima_intent);
        Intent intent = getIntent();
        nama = findViewById(R.id.nama);
        bulan_lahir = findViewById(R.id.bulan_lahir);
        tahun_lahir = findViewById(R.id.tahun_lahir);
        umur = findViewById(R.id.umur);
        String usia = String.valueOf(intent.getStringExtra("umur"));
        nama.setText(intent.getStringExtra("hello"));
        bulan_lahir.setText(intent.getStringExtra("bulan"));
        tahun_lahir.setText(intent.getStringExtra("tahun"));
        umur.setText(usia);
        Toast.makeText(getApplicationContext(),"Selamat Datang", Toast.LENGTH_LONG).show();
    }
}
