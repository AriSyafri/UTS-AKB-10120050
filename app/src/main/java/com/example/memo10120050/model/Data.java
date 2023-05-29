package com.example.memo10120050.model;

public class Data {
    // NIM : 10120050
    // Nama : Ari Syafri
    // Kelas : IF2
    private String id, tanggal, judul, kategori, isi;

    public Data(){

    }

    public Data(String id, String tanggal, String judul, String kategori, String isi) {
        this.id = id;
        this.tanggal = tanggal;
        this.judul = judul;
        this.kategori = kategori;
        this.isi = isi;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getIsi() {
        return isi;
    }

    public void setIsi(String isi) {
        this.isi = isi;
    }

}
