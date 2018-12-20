package com.example.iya.absenbasket;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;

public class TambahAnggota extends AppCompatActivity {
    Button saveAnggota;
    EditText editNama, editTtl, editTahunmsk ;
    RadioButton radioL, radioP;
    Spinner dropdown;

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_anggota);
        //get the spinner from the xml.

        editNama = findViewById(R.id.edt_nama);
        editTtl = findViewById(R.id.edt_ttl);
        editTahunmsk = findViewById(R.id.edt_thnMasuk);

        dropdown = findViewById(R.id.spinnerPosisi);
//create a list of items for the spinner.
        String[] items = new String[]{"Point Guard", "Shooting Guard", "Small Foward", "Power Forward" , "Center"};
//create an adapter to describe how the items are displayed, adapters are used in several places in android.
//There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);


        saveAnggota = findViewById(R.id.btn_saveTambahAnggota);

        //2
        saveAnggota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nama = encodeUrl(editNama.getText().toString());
                String ttl = encodeUrl(editTtl.getText().toString());
                String posisi = encodeUrl(dropdown.getSelectedItem().toString());
                String tahunMsk = encodeUrl(editTahunmsk.getText().toString());
                //Radio terpilih
                int selectedId = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                String jk = encodeUrl(radioButton.getText().toString());
                url = "http://192.168.1.185/absenbasket/tambah.php?" + "nama=" + nama + "&ttl=" + ttl + "&posisi=" + posisi + "&angkatan=" + tahunMsk + "&jk=" + jk ;

                Log.d("Nadya", "onClick: "+url);
                new Tambah().execute();

            }
        });

    }
    String encodeUrl(String value){
        try {
            return URLEncoder.encode(value,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return value;
        }

    }

    String url, success;
    public class Tambah extends AsyncTask<String, String, String>
    {
        ArrayList<HashMap<String, String>> contactList = new
                ArrayList<HashMap<String, String>>();
        ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            pDialog = new ProgressDialog(TambahAnggota.this);
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


            } catch (Exception e) {

                Log.e("erro", "tidak bisa ambil data 1");
            }
            return null;
        }
        @Override
        protected void onPostExecute(String result) {

            super.onPostExecute(result);
            pDialog.dismiss();
            if (success.equals("1")) {
                Intent a = new Intent(getApplicationContext(), MainMenu.class);
                startActivity(a);
                finish();
            } else {
                Toast.makeText(getApplicationContext(),
                        "Username/password salah gan.!!", Toast.LENGTH_LONG).show();
            }
        }
    }

    public void saveTambahAnggota(View v){
        Intent save = new Intent(this, DaftarAnggota.class);

        startActivity(save);
    }
}
