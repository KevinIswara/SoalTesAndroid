package com.example.kevin.soaltesandroid;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Kevin on 2/24/2018.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private ArrayList<Gunung> mGunungData;
    private Context mContext;

    public MainAdapter(ArrayList<Gunung> mGunung, Context mContext) {
        this.mGunungData = mGunung;
        this.mContext = mContext;

        if (mGunungData == null) {
            Toast.makeText(mContext, "Fetching data from Internet.....", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.list_gunung, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Gunung currentGunung = mGunungData.get(position);
        holder.bindTo(currentGunung);
    }

    @Override
    public int getItemCount() {
        return mGunungData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView namaGunung;
        private TextView tempatGunung;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            namaGunung = (TextView) itemView.findViewById(R.id.nama_gunung);
            tempatGunung = (TextView) itemView.findViewById(R.id.tempat_gunung);
        }

        public void bindTo(Gunung currentGunung) {
            namaGunung.setText(currentGunung.getNamaGunung());
            tempatGunung.setText(currentGunung.getTempat());
        }

        @Override
        public void onClick(View view) {
            Gunung currentGunung = mGunungData.get(getAdapterPosition());
            Intent detailIntent = new Intent(mContext, DetailActivity.class);
            detailIntent.putExtra("nama", currentGunung.getNamaGunung());
            detailIntent.putExtra("tempat", currentGunung.getTempat());
            detailIntent.putExtra("tinggi", currentGunung.getTinggiGunung());
            detailIntent.putExtra("url", currentGunung.getFotoGunungUrl());
            mContext.startActivity(detailIntent);
        }
    }
}
