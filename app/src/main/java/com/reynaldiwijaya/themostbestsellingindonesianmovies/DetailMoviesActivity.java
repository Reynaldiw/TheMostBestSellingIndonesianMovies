package com.reynaldiwijaya.themostbestsellingindonesianmovies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailMoviesActivity extends AppCompatActivity {

    @BindView(R.id.imgMovie)
    ImageView imgMovie;
    @BindView(R.id.txtMovieDetail)
    TextView txtMovieDetail;
    @BindView(R.id.cardView)
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movies);
        ButterKnife.bind(this);

        txtMovieDetail.setText(getIntent().getStringExtra("df"));
        Glide.with(this).load(getIntent().getIntExtra("gf", 0)).into(imgMovie);


    }
}
