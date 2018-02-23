package com.example.kevin.soaltesandroid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Pulau> mPulau;
    private ArrayList<Gunung> mGunung;
    private MainAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mGunung = new ArrayList<>();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new SimpleDividerItemDecoration(this));

        mAdapter = new MainAdapter(mGunung, this);
        mRecyclerView.setAdapter(mAdapter);

        initializeData();
    }

    private void initializeData() {
        mPulau = new ArrayList<>();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<ArrayList<Pulau>> call = api.getPulau();

        call.enqueue(new Callback<ArrayList<Pulau>>() {
            @Override
            public void onResponse(Call<ArrayList<Pulau>> call, Response<ArrayList<Pulau>> response) {
                mPulau = response.body();
                for (Pulau currentPulau : mPulau) {
                    for(int i = 0; i < currentPulau.getGunung().size(); i++) {
                        currentPulau.getGunung().get(i).setTempat(currentPulau.getNama());
                        mGunung.add(currentPulau.getGunung().get(i));
                    }
                }
                mAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Pulau>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
