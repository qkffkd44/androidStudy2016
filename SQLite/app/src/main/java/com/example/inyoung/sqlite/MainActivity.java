package com.example.inyoung.sqlite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.inyoung.sqlite.DB.DBManager;
import com.example.inyoung.sqlite.DTO.User;

public class MainActivity extends AppCompatActivity {

    //1. DBManager --> 패키지 추가
    private DBManager mDBManager;
    private EditText edt_id;
    private EditText edt_pw;
    private EditText edt_name;
    private EditText edt_age;
    private EditText edt_addr;
    //2.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //dbmager 가져오기
        mDBManager = DBManager.get_Instance(this);

        edt_id = (EditText)findViewById(R.id.edt_id);
        edt_pw = (EditText)findViewById(R.id.edt_pw);
        edt_name = (EditText)findViewById(R.id.edt_name);
        edt_age = (EditText)findViewById(R.id.edt_age);
        edt_addr = (EditText)findViewById(R.id.edt_address);
    }

    public void onClick(View v){
        switch(v.getId()) {
            case R.id.addUser:
                create_DTO();

                Intent intent = new Intent();
                intent.setClass(this,SecondActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void create_DTO()
    {
        String id = edt_id.getText().toString();
        String pw = edt_pw.getText().toString();
        String name = edt_name.getText().toString();
        int age = Integer.parseInt(edt_age.getText().toString()); //edit 텍스트는 스트링으로 주기때문에 형변화 필요
        String addr = edt_addr.getText().toString();

        User u = new User(id, pw, name, age, addr);

        mDBManager.Insert(u); //객체를 통해서 Insert
    }

    //현재 액티비티가 활성화 될때
    @Override
    protected void onResume() {
        mDBManager.DB_OPEN();
        super.onResume();
    }

    //앱이 완전히 사라질때
    @Override
    protected void onDestroy() {
        mDBManager.DB_CLOSE();
        super.onDestroy();
    }
}


