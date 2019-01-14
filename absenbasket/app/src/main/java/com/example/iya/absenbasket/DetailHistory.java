package com.example.iya.absenbasket;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DetailHistory extends AppCompatActivity {
    public static List<Anggota> anggotaList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AnggotaAdapter aAdapter;

    String url, success;
    int id ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_history);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //aAdapter = new AnggotaAdapter(anggotaList);
        AnggotaAdapter.mode = 2;
        aAdapter = new AnggotaAdapter(anggotaList);

        if(getIntent()!=null){
            id = getIntent().getIntExtra("id_sesi",-1);
        }
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(aAdapter);
        //prepareAnggotaData();
        //viewku = getApplicationContext();
        url = Konstanta.BASE_URL+ "absenbasket/viewAbsen.php?id="+id;
        Log.d("Tiwi", "onCreate: "+url);
        new ViewPlayer().execute();
    }
    public class ViewPlayer extends AsyncTask<String, String, String>
    {
        ArrayList<HashMap<String, String>> contactList = new
                ArrayList<HashMap<String, String>>();
        ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            pDialog = new ProgressDialog(DetailHistory.this);
            pDialog.setMessage("Tunggu Bentar ya...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }
        @Override
        protected String doInBackground(String... arg0) {
            JSONParser jParser = new JSONParser();
            anggotaList.clear();

            JSONObject json = jParser.getJSONFromUrl(url);
            try {
                success = json.getString("success");
                Log.e("error", "nilai sukses=" + success);
                JSONArray hasil = json.getJSONArray("data");
                if (success.equals("1")) {
                    for (int i = 0; i < hasil.length(); i++) {
                        JSONObject c = hasil.getJSONObject(i);
                        String nama, posisi, jk, ttl;
                        Integer angkatan;
                        nama = c.getString("nama");
                        Log.e("Tiwi", "doInBackground: "+nama );
                        posisi = c.getString("posisi");
                        jk = c.getString("jk");
                        ttl = c.getString("ttl");
                        angkatan = c.getInt("angkatan");
                        Anggota angg = new Anggota(nama,posisi,jk,ttl,angkatan);
                        angg.id = c.getInt("id");
                        angg.id_kehadiran = c.getInt("id_kehadiran");
                        angg.keterangan = c.getString("keterangan");
                        anggotaList.add(angg);
                        Log.d("Tiwi", "doInBackground: "+anggotaList.size());
                        //Log.e("ok", " ambil data");
                    }


                } else {
                    Log.e("erro", "tidak bisa ambil data 0");
                }
            } catch (Exception e) {

                Log.e("erro", "tidak bisa ambil data 1");
            }
            return null;
        }
        @Override
        protected void onPostExecute(String result) {

            super.onPostExecute(result);

            if (success.equals("1")) {
                aAdapter.notifyDataSetChanged();
                pDialog.dismiss();
            } else {
                Toast.makeText(getApplicationContext(),
                        "Username/password salah gan.!!", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void closeDetailHistory(View v){
        Intent close = new Intent(this, MainMenu.class);

        startActivity(close);
    }
}
