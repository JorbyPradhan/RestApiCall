package com.example.jb.crudrestapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jb.crudrestapi.model.Movie;
import com.example.jb.crudrestapi.model.RestFulService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
private TextView txt_detail;
private Button CreatePost,GetPost;
private RestFulService restFulService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        restFulService = RestFulService.retrofit.create(RestFulService.class);
        txt_detail = findViewById(R.id.txt_detail);
        txt_detail.setText("Movie Name");
        CreatePost = findViewById(R.id.Crete_Btn);
        GetPost =findViewById(R.id.Read_Btn);
        CreatePost.setOnClickListener(this);
        GetPost.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Crete_Btn :
                Intent intent = new Intent(Main3Activity.this,Main4Activity.class);
                startActivity(intent);
                break;
            case R.id.Read_Btn:
               getDataInAPi();
                break;
        }
    }

    private void getDataInAPi(){
        Call<List<Movie>> data = restFulService.getAllMovie();
        data.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                if(response.isSuccessful()) {
                    for(Movie movie: response.body()){
                        txt_detail.append("\n"+movie.getMovieName());
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Erii",Toast.LENGTH_SHORT).show();
            }
        });
    }


}
