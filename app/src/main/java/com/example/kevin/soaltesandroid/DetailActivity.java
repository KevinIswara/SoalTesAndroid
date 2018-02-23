package com.example.kevin.soaltesandroid;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    private TextView nama;
    private TextView tempat;
    private TextView tinggi;
    private ImageView gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nama = (TextView)findViewById(R.id.nama_gunung);
        tempat = (TextView)findViewById(R.id.tempat_gunung);
        tinggi = (TextView)findViewById(R.id.tinggi_gunung);
        gambar = (ImageView)findViewById(R.id.gambar_gunung);

        nama.setText(getIntent().getStringExtra("nama"));
        tempat.setText(getIntent().getStringExtra("tempat"));
        tinggi.setText(getIntent().getStringExtra("tinggi"));

        Glide.with(getApplicationContext())
                .load(getIntent().getStringExtra("url"))
                .into(gambar);
    }
}
