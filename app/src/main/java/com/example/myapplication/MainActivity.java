package com.example.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    String nama;
    Button buton;
    EditText editText;
    TextView hello;
    Spinner spinner;
    EditText tahun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        buton = findViewById(R.id.button);
        hello = findViewById(R.id.hello);
        spinner = findViewById(R.id.spinner);
        tahun = findViewById(R.id.tahun);
        final ArrayAdapter<CharSequence> adapterbulan = ArrayAdapter.createFromResource(this,R.array.bulan,
                android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapterbulan);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Alert");
                alert.setMessage("Sudah Yakin dengan data anda ?");
                alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        hello.setText("Masukan Nama dan Bulan Lahir");
                        int tahunInput = Integer.parseInt(tahun.getText().toString());
                        Calendar now = Calendar.getInstance();
                        int umur = now.get(Calendar.YEAR)-tahunInput;
                        String usia = String.valueOf(umur);
                        Intent intent = new Intent(MainActivity.this, TerimaIntent.class);
                        intent.putExtra("hello",editText.getText().toString());
                        intent.putExtra("bulan", spinner.getSelectedItem().toString());
                        intent.putExtra("umur",usia);
                        intent.putExtra("tahun", tahun.getText().toString());
                        startActivity(intent);
                    }
                });
                alert.setNegativeButton("Batal", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alert.show();
            }
        });

    }

}
