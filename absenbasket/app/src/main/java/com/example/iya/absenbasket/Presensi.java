package com.example.iya.absenbasket;

public class Presensi {
    String nama, keterangan, tanggal;
    public Presensi(){

    }
    public Presensi(String nama, String keterangan, String tanggal){
        this.nama = nama;
        this.keterangan = keterangan;
        this.tanggal = tanggal;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getKeterangan() {
        return keterangan;
    }
    public void setKeterangan(String posisi) {
        this.keterangan = keterangan;
    }
    public String getTanggal() {
        return tanggal;
    }
    public void setTanggal(String jk) {
        this.tanggal = tanggal;
    }
}
