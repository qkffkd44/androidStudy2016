package com.example.inyoung.hw01;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Inyoung on 2016-05-24.
 */
public class explainActivity extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.explain_layout);

    }

    public void onClick111(View v){
        switch (v.getId()){
            case R.id.backbutton:
                Intent intent = new Intent();
                intent.setClass(this, MainActivity.class);
                startActivity(intent);
                break;

        }


    }
}
