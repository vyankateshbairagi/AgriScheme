package com.example.agrischeme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URLEncoder;

public class viewpdf extends AppCompatActivity {
    WebView pdfview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpdf);
        pdfview=(WebView)findViewById(R.id.viewpdf);
        pdfview.getSettings().setJavaScriptEnabled(true);


        String filename=getIntent().getStringExtra("filename");
        String fileurl=getIntent().getStringExtra("fileurl");
        String filepan=getIntent().getStringExtra("filepan");
        String fileurl1=getIntent().getStringExtra("fileurl1");
        String fileuatara=getIntent().getStringExtra("fileuatara");
        String fileurl2=getIntent().getStringExtra("fileurl2");

        final ProgressDialog pd=new ProgressDialog(this);
        pd.setTitle(filename);
        pd.setTitle(filepan);
        pd.setTitle(fileuatara);
        pd.setMessage("Opening....!!!");


        pdfview.setWebViewClient(new WebViewClient()
        {
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                pd.show();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                pd.dismiss();
            }
        });

        String url="";
        try {
            url= URLEncoder.encode(fileurl,"UTF-8");
            url= URLEncoder.encode(fileurl1,"UTF-8");
            url= URLEncoder.encode(fileurl2,"UTF-8");


        }catch (Exception ex)
        {}

        pdfview.loadUrl("http://docs.google.com/gview?embedded=true&url=" + url);

    }


}