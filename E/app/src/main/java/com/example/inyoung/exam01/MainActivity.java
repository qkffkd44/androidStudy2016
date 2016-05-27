package com.example.inyoung.exam01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private Button btn;
    private EditText edit;
    //액티비티의 시작지점
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //layout 파일의 화면을 지정하는 메소드
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.hellow);
        btn = (Button)findViewById(R.id.btn);
        edit = (EditText)findViewById(R.id.inputtext);



    }

    public void onClick(View v){
        switch(v.getId()){
            case R.id.btn:
                String msg = edit.getText().toString();
                tv.setText(msg);
                break;

            case R.id.nextActivity:
                Intent intent = new Intent();
                intent.setClass(this, secondActivity.class);

                //액티비티 실행 메소드
                startActivity(intent);
                break;


        }
    }

}
