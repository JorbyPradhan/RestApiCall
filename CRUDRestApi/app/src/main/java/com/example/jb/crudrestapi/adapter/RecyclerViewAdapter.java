package com.example.jb.crudrestapi.adapter;

import android.content.Context;

import android.content.Intent;
import android.database.CursorJoiner;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.jb.crudrestapi.Main2Activity;
import com.example.jb.crudrestapi.R;
import com.example.jb.crudrestapi.model.Result;

import java.io.Serializable;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {
    private Context mContext;
    private List<Result> movieResult;
    private LayoutInflater inflater;

    public RecyclerViewAdapter(Context mContext, List<Result> movieResult) {
        this.mContext = mContext;
        this.movieResult = movieResult;
        inflater = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = inflater.inflate(R.layout.item,null);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
        final Result r = movieResult.get(i);
        myViewHolder.name.setText(r.getTitle());
        Glide.with(mContext).load("https://image.tmdb.org/t/p/w500/"+ r.getPosterPath()).into(myViewHolder.img);
        myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, Main2Activity.class);
                intent.putExtra("Title",  r);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movieResult.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.movie_poster);
            name = itemView.findViewById(R.id.movie_title);
        }
    }
}
