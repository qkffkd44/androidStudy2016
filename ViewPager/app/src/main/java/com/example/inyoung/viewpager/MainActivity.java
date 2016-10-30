package com.example.inyoung.viewpager;

import android.speech.tts.TextToSpeech;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.widget.TextView;

import com.example.inyoung.viewpager.Adapter.CustomPagerAdapter;
import com.example.inyoung.viewpager.DB.DBManager;
import com.example.inyoung.viewpager.Fragment.Fragment01;
import com.example.inyoung.viewpager.Fragment.Fragment02;
import com.example.inyoung.viewpager.Fragment.Fragment03;

public class MainActivity extends AppCompatActivity {

    private CustomPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private DBManager dbmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Title bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        mViewPager = (ViewPager) findViewById(R.id.container);

        //titlebar 설정
        setSupportActionBar(toolbar);

        mSectionsPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);

        //순서 주의!!!
        mSectionsPagerAdapter.addFragment(new Fragment01(), "단어 리스트");
        mSectionsPagerAdapter.addFragment(new Fragment03(), "단어 입력");
        mSectionsPagerAdapter.addFragment(new Fragment02(), "단어 사전");

        //viewpager 이랑 tablelayout 이랑 연결
        tabLayout.setupWithViewPager(mViewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.word_list);
        tabLayout.getTabAt(1).setIcon(R.drawable.word_edit);
        tabLayout.getTabAt(2).setIcon(R.drawable.dictionary);
         //DB 연동
        dbmanager = DBManager.get_Instance(this);
        dbmanager.DB_OPEN();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        dbmanager.DB_CLOSE();
    }
}
