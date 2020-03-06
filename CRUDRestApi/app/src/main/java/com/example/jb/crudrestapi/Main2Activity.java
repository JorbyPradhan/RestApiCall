package com.example.jb.crudrestapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.jb.crudrestapi.model.Result;

public class Main2Activity extends AppCompatActivity {
private ImageView img;
private TextView title,overview,rating,release_date;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        img = findViewById(R.id.imageView);
        title = findViewById(R.id.txt_title);
        overview =findViewById(R.id.txt_overview);
        rating = findViewById(R.id.txt_voting);
        release_date = findViewById(R.id.txt_release);
        Result result = (Result)getIntent().getExtras().getSerializable("Title");
        if(result != null){
            Glide.with(this).load("https://image.tmdb.org/t/p/w500/"+result.getPosterPath()).into(img);
            title.setText(result.getTitle());
            overview.setText(result.getOverview());
            release_date.setText(result.getReleaseDate());
            rating.setText(Double.toString(result.getVoteAverage()));

        }

    }
}
