package com.reynaldiwijaya.themostbestsellingindonesianmovies;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class AdapterMovies extends RecyclerView.Adapter<AdapterMovies.ViewHolder> {
    Context context;
    String[] namaFilm, jumlahPenonton, detailFilm;
    int [] gambarFilm;

    public AdapterMovies(Context context, String[] namaFilm, String[] jumlahPenonton, int[] gambarFilm, String[] detailFilm) {
        this.context = context;
        this.namaFilm = namaFilm;
        this.jumlahPenonton = jumlahPenonton;
        this.gambarFilm = gambarFilm;
        this.detailFilm = detailFilm;
    }

    @NonNull
    @Override
    public AdapterMovies.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_movies,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterMovies.ViewHolder viewHolder, final int i) {
        viewHolder.namaFilm.setText(namaFilm[i]);
        viewHolder.jumlahPenonton.setText(jumlahPenonton[i]);
        Glide.with(context).load(gambarFilm[i]).into(viewHolder.gambarFilm);

        viewHolder.gambarFilm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, DetailMoviesActivity.class);
                pindah.putExtra("nf", namaFilm[i]);
                pindah.putExtra("df", detailFilm[i]);
                pindah.putExtra("gf",gambarFilm[i]);
                context.startActivity(pindah);
            }
        });

    }

    @Override
    public int getItemCount() {
        return gambarFilm.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView gambarFilm;
        TextView namaFilm, jumlahPenonton;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gambarFilm = itemView.findViewById(R.id.imgMovie);
            namaFilm = itemView.findViewById(R.id.txtMovieName);
            jumlahPenonton = itemView.findViewById(R.id.txtMovieViewers);
        }
    }
}
