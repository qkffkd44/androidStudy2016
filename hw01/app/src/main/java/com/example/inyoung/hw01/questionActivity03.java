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
public class questionActivity03 extends AppCompatActivity {
    private Button next_btn03;
    private EditText edit03;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout03);

        next_btn03 = (Button) findViewById(R.id.next_button03);
        edit03 = (EditText)findViewById(R.id.editText03);
    }

    public void onClick03(View v){
        switch (v.getId()){
            case R.id.next_button03:
                String msg = edit03.getText().toString();
                String answer = "천도복숭아";

                if(answer.equals(msg)) {
                    //여기서 메인으로 가면서 엑티비티를 날릴때 intent를 새롭게 줌...
                    Intent intent = new Intent();
                    intent.setClass(this, finishActivity.class);
                    startActivity(intent);
                }
                else {

                }

        }


    }
}
