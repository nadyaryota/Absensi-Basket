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
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class TambahAbsen extends AppCompatActivity {
    private List<Anggota> anggotaList = new ArrayList<>();
    private RecyclerView recyclerView;
    private AnggotaAdapter aAdapter;

    String url, success;
    //Context viewku;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_absen);

        //Ambil tanggal sekarang
        TextView isitgl = findViewById(R.id.txt_isitanggal);
        String myFormat = "dd/MM/yy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
        String tgl = sdf.format(new Date());
        isitgl.setText(tgl);

        //Hide Alasan
        //EditText alasan = findViewById(R.id.);

        //alasan.setVisibility(View.INVISIBLE);




        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //aAdapter = new AnggotaAdapter(anggotaList);
        aAdapter = new AnggotaAdapter(anggotaList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(aAdapter);
        //prepareAnggotaData();
        //viewku = getApplicationContext();
        url = Konstanta.BASE_URL+"absenbasket/viewMember.php";
        new ViewPlayer().execute();
    }

    public void prepareAnggotaData(){
        Anggota anggota1 = new Anggota("nama", "posisi", "jk", "ttl", 2016);
        anggotaList.add(anggota1);
        Anggota anggota2 = new Anggota("Test", "posisi", "jk", "ttl", 2016);
        anggotaList.add(anggota2);
        aAdapter.notifyDataSetChanged();
    }

    public void backButton(View v){
        Intent back = new Intent(this, MainMenu.class);

        startActivity(back);
    }
    public void saveButton(View v){
        Intent save = new Intent(this, History.class);

        startActivity(save);
    }
    public class ViewPlayer extends AsyncTask<String, String, String>
    {
        ArrayList<HashMap<String, String>> contactList = new
                ArrayList<HashMap<String, String>>();
        ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            pDialog = new ProgressDialog(TambahAbsen.this);
            pDialog.setMessage("Tunggu Bentar ya...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }
        @Override
        protected String doInBackground(String... arg0) {
            JSONParser jParser = new JSONParser();
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
}
