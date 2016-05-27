package com.example.inyoung.hw01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Inyoung on 2016-05-24.
 */
public class questionActivity02 extends AppCompatActivity {
    private Button next_btn02;
    private EditText edit02;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout02);

        next_btn02 = (Button) findViewById(R.id.next_button02);
        edit02 = (EditText) findViewById(R.id.editText02);
    }

    public void onClick02(View v){
        switch (v.getId()){
            case R.id.next_button02:
                String msg = edit02.getText().toString();
                String answer = "어푸어푸";

                if(answer.equals(msg)) {
                    Intent intent = new Intent();
                    intent.setClass(this, questionActivity03.class);
                    startActivity(intent);
                }
                else {

                }


        }


    }
}
