package com.example.iya.absenbasket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    Button btn_tambah ;

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
                Intent act_tambah_anggota = new Intent(getApplicationContext(),TambahAnggota.class);
                startActivity(act_tambah_anggota);
            }
        });
    }
}
