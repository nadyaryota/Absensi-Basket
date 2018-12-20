package com.example.iya.absenbasket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DaftarAnggota extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_anggota);
    }
    public void backDaftarAnggota(View v){
        Intent back = new Intent(this, MainMenu.class);

        startActivity(back);
    }
}
