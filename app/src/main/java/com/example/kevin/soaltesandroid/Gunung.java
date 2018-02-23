package com.example.kevin.soaltesandroid;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Kevin on 2/24/2018.
 */

class Gunung {
    @SerializedName("nama_gunung")
    private String namaGunung;

    @SerializedName("foto_gunung")
    private String fotoGunungUrl;

    @SerializedName("tinggi_gunung")
    private String tinggiGunung;
    private String tempat;

    public String getNamaGunung() {
        return namaGunung;
    }

    public String getTempat() {
        return tempat;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public void setNamaGunung(String namaGunung) {
        this.namaGunung = namaGunung;
    }

    public String getFotoGunungUrl() {
        return fotoGunungUrl;
    }

    public void setFotoGunungUrl(String fotoGunungUrl) {
        this.fotoGunungUrl = fotoGunungUrl;
    }

    public String getTinggiGunung() {
        return tinggiGunung;
    }

    public void setTinggiGunung(String tinggiGunung) {
        this.tinggiGunung = tinggiGunung;
    }

    public Gunung(String namaGunung, String fotoGunungUrl, String tinggiGunung) {

        this.namaGunung = namaGunung;
        this.fotoGunungUrl = fotoGunungUrl;
        this.tinggiGunung = tinggiGunung;
    }
}
