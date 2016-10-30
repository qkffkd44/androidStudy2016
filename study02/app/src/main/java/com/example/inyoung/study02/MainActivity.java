package com.example.inyoung.study02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.inyoung.study02.Adapter.CustomAdapter;
import com.example.inyoung.study02.DTO.ContentDTO;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.list_View);

        adapter = new CustomAdapter();

        //한줄지우기 컨트롤+ D
        ContentDTO dto1 = new ContentDTO("타이틀" , "내용");
        ContentDTO dto2 = new ContentDTO("타이틀2" , "내용2");
        ContentDTO dto3 = new ContentDTO("타이틀3" , "내용3");

        adapter.addData(dto1);
        adapter.addData(dto2);
        adapter.addData(dto3);

        lv.setAdapter(adapter);

        adapter.notifyDataSetChanged();

        //추가하는 메소드

    }
}
