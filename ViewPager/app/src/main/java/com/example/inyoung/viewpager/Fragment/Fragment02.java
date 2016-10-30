package com.example.inyoung.viewpager.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.example.inyoung.viewpager.R;

/**
 * Created by Inyoung on 2016-06-11.
 */
public class Fragment02 extends Fragment{

    View view;
    WebView webView;
    private String url = "http://dic.daum.net/index.do?dic=eng";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.tab_fragment02, container, false);

        webView = (WebView)view.findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);

        return view;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        //true 일때 현재 보고있는 현재화면 상태
        if(isVisibleToUser){

        }

        super.setUserVisibleHint(isVisibleToUser);
    }
}
