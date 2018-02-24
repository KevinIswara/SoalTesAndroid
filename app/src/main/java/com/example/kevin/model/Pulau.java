package com.example.kevin.model;

import com.example.kevin.model.Gunung;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by Kevin on 2/24/2018.
 */

// Kelas ini merupakan kelas yang menyimpan atribut-atribut pulau yaitu id, nama, latitude, longitude, dan
// daftar gunung dari sebuah pulau.
public class Pulau {

    @SerializedName("id")
    private String id;

    @SerializedName("pulau")
    private String nama;

    @SerializedName("lati")
    private String latitude;

    @SerializedName("longi")
    private String longitude;

    @SerializedName("gunung")
    private ArrayList<Gunung> gunung;

    public Pulau(String id, String nama, String latitude, String longitude, ArrayList<Gunung> gunung) {
        this.id = id;
        this.nama = nama;
        this.latitude = latitude;
        this.longitude = longitude;
        this.gunung = gunung;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getLatitute() {
        return latitude;
    }

    public void setLatitute(String latitute) {
        this.latitude = latitute;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public ArrayList<Gunung> getGunung() {
        return gunung;
    }

    public void setGunung(ArrayList<Gunung> gunung) {
        this.gunung = gunung;
    }
}
