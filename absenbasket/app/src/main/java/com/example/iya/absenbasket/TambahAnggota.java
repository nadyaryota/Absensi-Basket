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
    String aksi ="";
    Anggota anggota ;
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
        String[] items = new String[]{"Point Guard", "Shooting Guard", "Small Foward", "Power Forward" , "Center"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioP = findViewById(R.id.radioP);
        radioL = findViewById(R.id.radioL);
        if(getIntent()!=null){
            aksi  = getIntent().getStringExtra("aksi");
            int index = getIntent().getIntExtra("index_anggota",-1);
            if(index!=-1) anggota = DaftarAnggota.listAnggota.get(index);
            if(aksi!=null) if(aksi.equals("edit")){
                editTahunmsk = findViewById(R.id.edt_thnMasuk);
                editNama.setText(anggota.nama);
                editTtl.setText(anggota.ttl);
                editTahunmsk.setText(anggota.angkatan+"");
                if(anggota.jk.equals("L"))
                    radioL.setChecked(true);
                else
                    radioP.setChecked(true);

                switch (anggota.posisi){

                    case "Point Guard" : {
                        dropdown.setSelection(0);
                        break;
                    }
                    case "Shooting Guard" : {
                        dropdown.setSelection(1);
                        break;
                    }
                    case "Small Foward" : {
                        dropdown.setSelection(2);
                        break;
                    }
                    case "Power Forward" : {
                        dropdown.setSelection(3);
                        break;
                    }
                    case "Center" : {
                        dropdown.setSelection(4);
                        break;
                    }

                }


            }
        }



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

                if(aksi!=null){
                    if(aksi.equals("edit")) url = Konstanta.BASE_URL+"absenbasket/edit.php?" + "nama=" + nama + "&ttl=" + ttl + "&posisi=" + posisi + "&angkatan=" + tahunMsk + "&jk=" + jk+"&id="+anggota.id ;
                    else url = Konstanta.BASE_URL+"absenbasket/tambah.php?" + "nama=" + nama + "&ttl=" + ttl + "&posisi=" + posisi + "&angkatan=" + tahunMsk + "&jk=" + jk ;
                }else{
                    url = Konstanta.BASE_URL+"absenbasket/tambah.php?" + "nama=" + nama + "&ttl=" + ttl + "&posisi=" + posisi + "&angkatan=" + tahunMsk + "&jk=" + jk ;
                }


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
                Intent a = new Intent(getApplicationContext(), DaftarAnggota.class);
                startActivity(a);
                finish();
            } else {
                Toast.makeText(getApplicationContext(),
                        "Username/password salah gan.!!", Toast.LENGTH_LONG).show();
            }
        }
    }


}
