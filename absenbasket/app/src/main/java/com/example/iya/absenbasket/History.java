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

public class History extends AppCompatActivity {
    public static List<ItemHistory> historyList= new ArrayList<>();
    private RecyclerView recyclerView;
    private Adapter_History aAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        //aAdapter = new AnggotaAdapter(anggotaList);
        aAdapter = new Adapter_History(historyList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(aAdapter);
        new ViewHistory().execute();
    }
    String success = "";
    String url = "";
    public class ViewHistory extends AsyncTask<String, String, String>
    {
        ArrayList<HashMap<String, String>> contactList = new
                ArrayList<HashMap<String, String>>();
        ProgressDialog pDialog;
        @Override
        protected void onPreExecute() {

            super.onPreExecute();
            pDialog = new ProgressDialog(History.this);
            pDialog.setMessage("Tunggu Bentar ya...");
            pDialog.setIndeterminate(false);
            pDialog.setCancelable(true);
            pDialog.show();
        }
        @Override
        protected String doInBackground(String... arg0) {
            JSONParser jParser = new JSONParser();

            url = Konstanta.BASE_URL + "absenbasket/viewHistory.php";
            JSONObject json = jParser.getJSONFromUrl(url);
            try {
                success = json.getString("success");
                Log.e("error", "nilai sukses=" + success);
                JSONArray hasil = json.getJSONArray("data");
                if (success.equals("1")) {
                    for (int i = 0; i < hasil.length(); i++) {
                        JSONObject c = hasil.getJSONObject(i);
                        int id;
                        String hari,author;
                        id = c.getInt("id");
                        hari = c.getString("hari");
                        author = c.getString("author");

                        ItemHistory item = new ItemHistory(id,hari,author);

                        historyList.add(item);
                        Log.d("Tiwi", "doInBackground: "+historyList.size());
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
    public void backHistory(View v){
        Intent back = new Intent(this, MainMenu.class);

        startActivity(back);
    }
}
