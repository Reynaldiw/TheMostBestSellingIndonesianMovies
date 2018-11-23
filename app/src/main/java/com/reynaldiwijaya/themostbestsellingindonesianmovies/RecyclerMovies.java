package com.reynaldiwijaya.themostbestsellingindonesianmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerMovies extends AppCompatActivity {

    String[] namaFilm , jumlahPenonton, detailFilm;
    int[] gambarFilm;

    @BindView(R.id.myRecycleView)
    RecyclerView myRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_movies);
        ButterKnife.bind(this);

        namaFilm = getResources().getStringArray(R.array.namaFilm);
        jumlahPenonton = getResources().getStringArray(R.array.jumlahPenonton);
        detailFilm = getResources().getStringArray(R.array.detailFilm);
        gambarFilm = new int[]{R.drawable.warkopdki,R.drawable.dilan,R.drawable.laskarpelangi,R.drawable.habibieainun,R.drawable.pengabdi,R.drawable.warkop2,R.drawable.aac,R.drawable.aadc2,R.drawable.boss,R.drawable.aac2};

        AdapterMovies adapterMovies = new AdapterMovies(this, namaFilm,jumlahPenonton,gambarFilm,detailFilm);

        myRecycleView.setHasFixedSize(true);
        myRecycleView.setLayoutManager(new LinearLayoutManager(this));
        myRecycleView.setAdapter(adapterMovies);

    }
}
