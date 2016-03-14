package com.example.yangsiyoung.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Yang Si Young on 2016-03-13.
 */
public interface GithubService {
    @GET("users/{users}/repos")
    Call<List<Repo>> repoList(@Path("users") String users);
}
