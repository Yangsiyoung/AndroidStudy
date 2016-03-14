package com.example.yangsiyoung.myapplication;

/**
 * Created by Yang Si Young on 2016-03-13.
 */
public class Repo {

    private String name;
    private String html_url;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setHtml_url(String html_url){
        this.html_url = html_url;
    }

    public String getHtml_url(){
        return this.html_url;
    }
}
