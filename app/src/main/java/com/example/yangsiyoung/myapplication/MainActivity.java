package com.example.yangsiyoung.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.yangsiyoung.myapplication.list.RepositoryAdapter;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String baseURL = "https://api.github.com/";
    @Bind(R.id.listRepository)
    ListView listRepository;
    private RepositoryAdapter repositoryAdapter;
    private String repoName = "";
    private List<Repo> repoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build();

        GithubService gitHubService = retrofit.create(GithubService.class);
        Call<List<Repo>> callRepo = gitHubService.repoList("from20141002");

        callRepo.enqueue(new Callback<List<Repo>>() {
            @Override
            public void onResponse(Call<List<Repo>> call, Response<List<Repo>> response) {
                List<Repo> repoList = response.body();
                Log.d("aaaa", repoList.get(0).getName());

                setRepositoryList(repoList);
            }

            @Override
            public void onFailure(Call<List<Repo>> call, Throwable t) {

                Log.d("error","에러 내용은 " + t.toString());
            }
        });}

    public void setRepositoryList(List<Repo> repoList) {

        //ListView에 담을 Repository 리스트를 Adpater에 넣어 초기화 해줌.
        repositoryAdapter = new RepositoryAdapter(getApplicationContext(),repoList);
        if(listRepository != null){
            listRepository.setAdapter(repositoryAdapter);
            this.repoList = repoList;
            listRepository.setOnItemClickListener(onItemClickListener);

        }

        }

      AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener(){

          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

              //Intent에 해당 Repository URL 담아서 WebView를 실행할 Activity에 넘겨줌.
              Intent intent = new Intent(getApplicationContext(), LinkGithubRepositoryActivity.class);
              intent.putExtra("html_url", repoList.get(position).getHtml_url());
              startActivity(intent);


          }
      };

    }



