package com.example.jh352160.new_demo.test11;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.jh352160.new_demo.R;

/**
 * Created by jh352160 on 2016/10/13.
 */

public class Test11 extends AppCompatActivity {

    WebView mWebView;

    private static final String TAG=Test11.class.getSimpleName();
    //web缓存目录
    private static final String APP_CACHE_DIRNAME="/webcache";
    private String url;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.test11);
        mWebView=(WebView)findViewById(R.id.webView);

        WebSettings webSettings=mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        url="http://blog.csdn.net/wwj_748/article/details/44810283";

        findView();
    }

    public void findView(){
        initWebView();
        mWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onLoadResource(WebView view, String url) {
                Log.i(TAG,"onLoadResource url="+url);
                super.onLoadResource(view, url);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.i(TAG,"intercept url="+url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
    }

    private void initWebView() {

    }

}
