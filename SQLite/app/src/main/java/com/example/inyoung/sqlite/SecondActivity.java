package com.example.inyoung.sqlite;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.inyoung.sqlite.DB.DBManager;
import com.example.inyoung.sqlite.DTO.User;

/**
 * Created by Inyoung on 2016-06-04.
 */
public class SecondActivity extends AppCompatActivity {

    private EditText edt_m_id;
    private EditText edt_m_pw;
    private EditText edt_m_name;
    private EditText edt_m_age;
    private EditText edt_m_addr;

    private EditText edt_m_search;

    private DBManager mDBManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        edt_m_id = (EditText)findViewById(R.id.modify_id);
        edt_m_pw = (EditText)findViewById(R.id.modify_pw);
        edt_m_name = (EditText)findViewById(R.id.modify_name);
        edt_m_age = (EditText)findViewById(R.id.modify_age);
        edt_m_addr = (EditText)findViewById(R.id.modify_address);

        edt_m_search = (EditText)findViewById(R.id.edt_search);

        mDBManager= DBManager.get_Instance(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_modify:

                break;

            case R.id.btn_search:
                String name = edt_m_search.getText().toString();
                User u = mDBManager.Select(name);

                edt_m_id.setText(u.id);
                edt_m_pw.setText(u.pw);
                edt_m_name.setText(u.name);
                edt_m_age.setText(""+u.age);
                edt_m_addr.setText(u.addr);

                break;
        }
    }

}
