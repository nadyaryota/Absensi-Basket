package com.example.iya.absenbasket;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class AnggotaAdapter extends RecyclerView.Adapter<AnggotaAdapter.MyViewHolder>{

    private List<Anggota> anggotaList;
    public static int mode = 1;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView nama;
        public Spinner spinner;
        public EditText alasan;

        public MyViewHolder(View view) {
            super(view);
            nama = (TextView) view.findViewById(R.id.recycler_nama);
            spinner = (Spinner) view.findViewById(R.id.recycler_spinner);
            alasan = (EditText) view.findViewById(R.id.recycler_alasan);
            if(mode == 2){
                spinner.setEnabled(false);
                alasan.setEnabled(false);
            }
            //Hide alasan jika hadir
//            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//                @Override
//                public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
//                    // your code here
//                    if(position==1) alasan.setVisibility(View.VISIBLE);
//                    else alasan.setVisibility(View.INVISIBLE);
//                }
//
//                @Override
//                public void onNothingSelected(AdapterView<?> parentView) {
//                    // your code here
//                }
//
//            });
        }
    }


    public AnggotaAdapter(List<Anggota> anggotaList) {
        if(mode==1){
            this.anggotaList = TambahAbsen.anggotaList;
        }else{
            this.anggotaList = DetailHistory.anggotaList;
        }

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_list_nama_anggota, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        Anggota anggota = anggotaList.get(position);
        Log.d("Tiwi", "onBindViewHolder: "+anggotaList.size());
        holder.nama.setText(anggota.getNama());
        holder.alasan.setVisibility(View.INVISIBLE);
        if(mode == 1) holder.alasan.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                TambahAbsen.anggotaList.get(position).keterangan = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        //create a list of items for the spinner.
        String[] items = new String[]{"Hadir", "Tidak Hadir"};
        //create an adapter to describe how the items are displayed, adapters are used in several places in android.
        //There are multiple variations of this, but this is the basic variant.
        ArrayAdapter<String> adapter = new ArrayAdapter<>(holder.itemView.getContext(), android.R.layout.simple_spinner_dropdown_item, items);
        //set the spinners adapter to the previously created one.
        holder.spinner.setAdapter(adapter);
        if(mode==1) holder.spinner.setEnabled(true);
        else {
            holder.spinner.setSelection(anggotaList.get(position).id_kehadiran-1);
            holder.spinner.setEnabled(false);

        }
        holder.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int spinposition, long id) {
                // your code here
                Log.d("sembarang","posisi = "+String.valueOf(spinposition));
                if(spinposition==1) {
                    holder.alasan.setVisibility(View.VISIBLE);
                    if(mode == 1) {TambahAbsen.anggotaList.get(position).id_kehadiran = 2;}
                    else {holder.alasan.setText(DetailHistory.anggotaList.get(position).keterangan);}}
                else {
                    holder.alasan.setVisibility(View.INVISIBLE);
                    if(mode == 1) TambahAbsen.anggotaList.get(position).id_kehadiran = 1;

                }
                //anggotaList.get(position).
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });
    }

    @Override
    public int getItemCount() {
        return anggotaList.size();
    }

}
