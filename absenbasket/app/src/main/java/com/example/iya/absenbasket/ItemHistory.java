package com.example.iya.absenbasket;

public class ItemHistory {
    int id_sesi;

    String hari;

    public ItemHistory(int id_sesi,String hari, String author) {
        this.hari = hari;
        this.author = author;
        this.id_sesi = id_sesi;
    }

    String author;


    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
