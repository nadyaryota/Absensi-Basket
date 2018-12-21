package com.example.iya.absenbasket;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class DaftarAnggota extends AppCompatActivity  implements AdapterView.OnItemClickListener{
    ListView viewAnggota;

    ArrayAdapter adapter;
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, adapter.getPosition(position), Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_anggota);
        Log.d("iya",String.valueOf(R.array.anggota_array));
        String[] listNama ={"Nadya"};
        adapter = new ArrayAdapter(getApplicationContext(),R.layout.simple_list,listNama);
        ListView listview = (ListView) findViewById(R.id.listv_daftarAnggota) ;
        listview.setAdapter(adapter);
    }

    /*public ListView getViewAnggota() {

        @Override
        public void onClick(final View v) {
        viewku = v;
        url = "http://192.168.1.156/absenbasket/viewAnggota.php" + "nama" + nama.getText().toString() + "&password=" + ttl.getText().toString();
        if
                (nama.getText().toString().trim().length() > 0 && ttl.getText().toString().trim().length() > 0)
        {
            new lihatAnggota().execute();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Username/password masih kosong gan.!!", Toast.LENGTH_LONG).show();
        }
    }
    return viewAnggota;
    });

    public class lihatAnggota extends DaftarAnggota <String, String, String> {

        ArrayList<HashMap<String, String>> viewAnggota = new
                ArrayList<HashMap<String, String>>();
        ProgressDialog pDialog;
        @Override
        protected void onPreExecute () {

            super.onPreExecute();
            pDialog = new ProgressDialog(DaftarAnggota.this);
            pDialog.setMessage("Tunggu Bentar ya...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }
    }
    */

    public void backDaftarAnggota(View v){
        Intent back = new Intent(this, MainMenu.class);

        startActivity(back);


    }
}
