package com.example.jb.crudrestapi;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jb.crudrestapi.adapter.RecyclerViewAdapter;
import com.example.jb.crudrestapi.model.Post;
import com.example.jb.crudrestapi.model.Result;
import com.example.jb.crudrestapi.model.WebServices;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerViewAdapter adapter;
    WebServices myWebServi;
    List<Result> movieResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rec_main);
        myWebServi = WebServices.retrofit.create(WebServices.class);
        movieResult = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        getAllpost();
       /* button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("");
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              // createdPost();
               //
            }
        });*/

    }

 /*   private void createdPost() {
        final Post post = new Post(513.231, 3422, false,"zero.jpg",12245, false,"zeromovie.jpg","Hindi","Zero",null,
                "Zero",5.5,"This story about duff life","2018-12-18");
        Call<Post> data = myWebServi.createPost(post);
        data.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if(response.isSuccessful()){
                    //textView.setText(String.valueOf(response.code()));
                    showPost(response.body());
                }
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {

            }
        });
    }*/

    private void getAllpost(){
        /*Map<String , String > param = new HashMap<>();
        param.put("oid", "1");
        param.put("_sort", "name");
        param.put("_order", "desc");
*/
     //Call<List<Post>> data = myWebServi.getPost("http://192.168.8.114:1919/org");
        Call<Post> data = myWebServi.getPost("https://api.themoviedb.org/3/movie/popular?api_key=7142a40c54b2c690a1f53e697a1d51aa&language=en-US&page=1");
     data.enqueue(new Callback<Post>() {
         @Override
         public void onResponse(Call<Post> call, Response<Post> response) {
             if(response.isSuccessful()){
                 for (Result result: response.body().getResults())
                 {
                    movieResult.add(new Result(result.getPosterPath(),result.getTitle(),result.getVoteAverage(),result.getOverview(),result.getReleaseDate()));
                   // showPost(result);
                 }
                 adapter = new RecyclerViewAdapter(getApplicationContext(),movieResult);
                 recyclerView.setAdapter(adapter);
                 Log.i("Movie Title", movieResult.get(1).getTitle());

             }

         /*    List<Result> results = response.body().getResults();
             textView.append("Title: " +String.valueOf(results.get(1).getTitle())+"\n");
             textView.append("Title: " +String.valueOf(response.body().getPage())+"\n");*/

         }

         @Override
         public void onFailure(Call<Post> call, Throwable t) {
             Log.e("error", t.getMessage() + call);
             Toast.makeText(MainActivity.this, "Enable Internet Connection", Toast.LENGTH_SHORT).show();
         }
     });


 }
    private void showPost(Result post) {
        movieResult.add(new Result(post.getPosterPath(),post.getTitle()));
       /* textView.append("Popularity: " +String.valueOf(post.getPopularity())+"\n");
       // textView.append("Popularity: " +String.valueOf(post.getTotalPages())+"\n");
        //textView.append("Popularity: " +String.valueOf(post.getTotalResults())+"\n");
        //textView.append("Popularity: " +String.valueOf(post.getResults())+"\n");
        textView.append("VoteCount: " +String.valueOf(post.getVoteCount())+"\n");
        textView.append("IsVideo: "+ String.valueOf(post.isVideo())+"\n");
        textView.append("PosterPath: " +post.getPosterPath()+"\n");
        textView.append("Id: " +String.valueOf(post.getId())+"\n");
        textView.append("IsAdult: "+ String.valueOf(post.isAdult())+"\n");
        textView.append("BackdropPath: " +String.valueOf(post.getBackdropPath())+"\n");
        textView.append("OriginalTitle: " +post.getOriginalTitle()+"\n");
        textView.append("GenreID: " +String.valueOf(post.getGenreIds())+"\n");
        textView.append("Title: " +String.valueOf(post.getTitle())+"\n");
        textView.append("VoteAvg: " +String.valueOf(post.getVoteAverage())+"\n");
        textView.append("Overview: " +String.valueOf(post.getOverview())+"\n");
        textView.append("Release: " +String.valueOf(post.getReleaseDate())+"\n");*/

    }
}
