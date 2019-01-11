package com.example.iya.absenbasket;

public class Anggota {
    String nama, posisi, jk, ttl;
    Integer angkatan,id;
    public Anggota(){

    }
    public Anggota(String nama, String posisi, String jk, String ttl, Integer angkatan){
        this.nama = nama;
        this.posisi = posisi;
        this.jk = jk;
        this.ttl = ttl;
        this.angkatan = angkatan;
    }
    public String getNama() {
        return nama;
    }
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getPosisi() {
        return posisi;
    }
    public void setPosisi(String posisi) {
        this.posisi = posisi;
    }
    public String getJK() {
        return jk;
    }
    public void setJK(String jk) {
        this.jk = jk;
    }
    public String getTtl() {
        return ttl;
    }
    public void setTtl(String ttl) {
        this.ttl = ttl;
    }
    public Integer getAngkatan() {
        return angkatan;
    }
    public void setAngkatan(Integer angkatan) {
        this.angkatan = angkatan;
    }
}
