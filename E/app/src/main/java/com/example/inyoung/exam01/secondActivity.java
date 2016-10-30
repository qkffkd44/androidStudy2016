package com.example.inyoung.exam01;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Inyoung on 2016-05-21.
 */
public class secondActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private ListView lv;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> data;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        lv = (ListView)findViewById(R.id.lv_second);

        // 데이터 생성
        data = new ArrayList<String>(1);

        data.add("a");
        data.add("b");
        data.add("c");
        data.add("d");

        //어뎁터 생성
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data);

        // List view와 연결
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(this);
    }

    // position : 몇번째를 클릭했나 Toast 큐
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Toast.makeText(this, position+" 번째 클릭 : " + data.get(position), Toast.LENGTH_SHORT).show();

    }
}
