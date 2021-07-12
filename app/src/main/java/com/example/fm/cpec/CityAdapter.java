package com.example.fm.cpec;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fm on 1/1/2018.
 */

public class CityAdapter extends RecyclerView.Adapter<CityAdapter.MovieViewHolder> {

    private ArrayList<MainViewResponse> movies;
    private int rowLayout;
    private Context context;


    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        TextView movieTitle, area, sqr_yard,phase;

        public MovieViewHolder(View v) {
            super(v);
            area = (TextView) v.findViewById(R.id.areacity);
        }
    }

    public CityAdapter(ArrayList<MainViewResponse> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public CityAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.area.setText(movies.get(position).getCityarea());

    }

    @Override
    public int getItemCount() {
        return movies.size();
    }
}