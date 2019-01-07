package com.example.iya.absenbasket;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class DaftarAnggota extends AppCompatActivity  implements AdapterView.OnItemClickListener{
    ListView viewAnggota;
	ArrayList<String> listNama = new ArrayList<String>();
    ArrayAdapter adapter;
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, adapter.getPosition(position), Toast.LENGTH_SHORT).show();
    }
	public String url = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_anggota);
		url = Konstanta.BASE_URL+"absenbasket/seluruh_anggota.php";
        new seluruhPlayer().execute();
        //Log.d("iya",String.valueOf(R.array.anggota_array));
        //String[] listNama ={"Nadya"};
        listNama.add("Test");
        adapter = new ArrayAdapter(getApplicationContext(),R.layout.simple_list,listNama);
        ListView listview = (ListView) findViewById(R.id.listv_daftarAnggota) ;
        listview.setAdapter(adapter);

    }

    
    String success="";
    public class seluruhPlayer extends AsyncTask<String, String, String>
    {
        ArrayList<HashMap<String, String>> contactList = new
                ArrayList<HashMap<String, String>>();
        ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            pDialog = new ProgressDialog(DaftarAnggota.this);
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
						listNama.add(nama);
                        //Anggota angg = new Anggota(nama,posisi,jk,ttl,angkatan);
                        //anggotaList.add(angg);
                        //Log.d("Tiwi", "doInBackground: "+anggotaList.size());
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
                adapter.notifyDataSetChanged();
                pDialog.dismiss();
            } else {
                Toast.makeText(getApplicationContext(),
                        "Username/password salah gan.!!", Toast.LENGTH_LONG).show();
            }
        }
    }
    

    public void backDaftarAnggota(View v){
        Intent back = new Intent(this, MainMenu.class);

        startActivity(back);


    }
}
