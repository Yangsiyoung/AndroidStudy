package com.example.yangsiyoung.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LinkGithubRepositoryActivity extends AppCompatActivity {

    private Intent intent;
    @Bind(R.id.webView)
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_link_github_repository);
        ButterKnife.bind(this);
        intent = getIntent();
        Log.d("aaaa", "html_url 값은 " + intent.getStringExtra("html_url"));

        //넘겨받은 URL을 바탕으로 WebView 실행
        try {
            webView.setWebViewClient(new WebClient());

            WebSettings set = webView.getSettings();
            set.setJavaScriptEnabled(true);
            set.setBuiltInZoomControls(true);

            webView.loadUrl(intent.getStringExtra("html_url"));
        } catch(Exception e) {
            Log.d("error", "웹 뷰 에러 내용은 " + e.toString());
        }

    }

    class WebClient extends WebViewClient{
        public boolean shouldOverrideURLLoading(WebView webView, String url){
            webView.loadUrl(url);
            return true;
        }
    }
}
