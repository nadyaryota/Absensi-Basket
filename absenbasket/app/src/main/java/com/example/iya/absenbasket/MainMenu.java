package com.example.iya.absenbasket;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    Button btn_tambah;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        //1
        btn_tambah = findViewById(R.id.btn_tambahAnggota);

        //2
        btn_tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent act_tambah_anggota = new Intent(getApplicationContext(), TambahAnggota.class);
                startActivity(act_tambah_anggota);
            }
        });
    }

    public void tambahAbsen(View v) {
        Intent tambah = new Intent(this, TambahAbsen.class);

        startActivity(tambah);
    }

    public void historyAbsen(View v) {
        Intent history = new Intent(this, History.class);

        startActivity(history);
    }

    public void tambahAnggota(View v) {
        Intent tmbAnggota = new Intent(this, TambahAnggota.class);

        startActivity(tmbAnggota);
    }

    public void daftarAnggota(View v) {
        Intent daftarAngg = new Intent(this, DaftarAnggota.class);

        startActivity(daftarAngg);
    }

    public void logout(View v) {
        SharedPreferences sharedpreferences = getSharedPreferences
                (MainActivity.MyPREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.clear();
        editor.commit();
        moveTaskToBack(true);
        MainMenu.this.finish();
    }
}

