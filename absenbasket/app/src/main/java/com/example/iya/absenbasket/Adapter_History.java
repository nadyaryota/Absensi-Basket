package com.example.iya.absenbasket;

import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.content.Intent;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class Adapter_History extends RecyclerView.Adapter<Adapter_History.MyViewHolder>{

    private List<ItemHistory> historyList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView hari, author;
        public Button lihat;

        public MyViewHolder(View view) {
            super(view);
            hari = (TextView) view.findViewById(R.id.txt_hariHistory);
            author = (TextView) view.findViewById(R.id.txt_author);
            lihat = (Button) view.findViewById(R.id.btn_lihat);



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


    public Adapter_History(List<ItemHistory> historyList) {
        this.historyList = historyList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_history, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        ItemHistory history = historyList.get(position);
        //
        holder.hari.setText(history.hari);
        holder.author.setText(history.author);
        holder.lihat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailAbsen = new Intent(v.getContext(),DetailHistory.class);
                detailAbsen.putExtra("id_sesi",historyList.get(position).id_sesi);
                v.getContext().startActivity(detailAbsen);
            }
        });

    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

}
