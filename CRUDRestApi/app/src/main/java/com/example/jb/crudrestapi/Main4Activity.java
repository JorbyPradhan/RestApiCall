package com.example.jb.crudrestapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jb.crudrestapi.model.Movie;
import com.example.jb.crudrestapi.model.Post;
import com.example.jb.crudrestapi.model.RestFulService;
import com.example.jb.crudrestapi.model.WebServices;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Main4Activity extends AppCompatActivity {
    private EditText movieName,director,main_lead,budget,dbo,obo,overview,rank,o_name, wbo;
    private Button Create;
    private RestFulService restFulService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        restFulService = RestFulService.retrofit.create(RestFulService.class);
        Create = findViewById(R.id.btn_Create);
        movieName =findViewById(R.id.s_tilte);
        main_lead =findViewById(R.id.s_lead);
        director =findViewById(R.id.s_director);
        budget =findViewById(R.id.s_budget);
        dbo =findViewById(R.id.s_db0);
        obo =findViewById(R.id.s_obo);
        wbo =findViewById(R.id.s_wbo);
        overview =findViewById(R.id.s_overview);
        rank =findViewById(R.id.s_rank);
        o_name =findViewById(R.id.s_o_name);
        Create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreatePost();
            }
        });
    }

    private void CreatePost() {
        Movie movie = new Movie(movieName.getText().toString(),main_lead.getText().toString(),director.getText().toString(),budget.getText().toString(),
                dbo.getText().toString(),obo.getText().toString(), wbo.getText().toString(),overview.getText().toString(),rank.getText().toString(),
                movieName.getText().toString(),o_name.getText().toString());
        Call<Movie> data = restFulService.createPost(movie);
        data.enqueue(new Callback<Movie>() {
            @Override
            public void onResponse(Call<Movie> call, Response<Movie> response) {
                if(response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"SuccessFul",Toast.LENGTH_SHORT).show();
                    //onBackPressed();
                }
            }

            @Override
            public void onFailure(Call<Movie> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    }
