package com.example.inyoung.hw02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.inyoung.hw02.Adapter.CustomAdapter;
import com.example.inyoung.hw02.DTO.ContentDTO;

public class MainActivity extends AppCompatActivity {

    TextView tv_title;
    TextView tv_content;
    EditText new_title;
    EditText new_content;
    ListView lv;
    CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView)findViewById(R.id.list_View);

        adapter = new CustomAdapter();

        new_title = (EditText)findViewById(R.id.title_editText);
        new_content = (EditText)findViewById(R.id.content_editText);

        //한줄지우기 컨트롤+ D
        ContentDTO dto1 = new ContentDTO("Hi" , "안녕");


        adapter.addData(dto1);


        lv.setAdapter(adapter);

        adapter.notifyDataSetChanged();



    }
    //추가하는 메소드, 지역변수 heap이아닌 static영역으로 지역변수는 자동으로 관리를 해준다
    // 지역변수 > 전역변수이기때문에 전역변수와 이름이 같은 지역변수를 선언해주면 지역변수의 변수가 이용된다
    public void onClick(View v){
        switch(v.getId()){
            case R.id.btn_add:
                String title = new_title.getText().toString();
                String content = new_content.getText().toString();

                //title.length() == 0
                if(title.getBytes().length <= 0 || content.getBytes().length <= 0){
                    Toast.makeText(MainActivity.this,"단어와 뜻을 모두 입력해주세요", Toast.LENGTH_SHORT).show();
                }
                else{
                    new_title.setText("");
                    new_content.setText("");
                    ContentDTO dto4 = new ContentDTO(title, content);
                    adapter.addData(dto4);
                    adapter.notifyDataSetChanged();

                }
            break;
        }
    }


}
