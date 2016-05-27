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
public class questionActivity01 extends AppCompatActivity {

    private Button next_btn01;
    private EditText edit01;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout01);

        next_btn01 = (Button) findViewById(R.id.next_button01);
        edit01 = (EditText) findViewById(R.id.editText01);
    }

    public void onClick01(View v){
        switch (v.getId()){
            case R.id.next_button01:
                String msg = edit01.getText().toString();
                String answer = "언덕";

                if(answer.equals(msg)) {
                    Intent intent = new Intent();
                    intent.setClass(this, questionActivity02.class);
                    startActivity(intent);
                }
                else {

                }
                break;


        }


    }
}
