package com.example.inyoung.hw01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button start_btn;
    private Button explain_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_btn = (Button) findViewById(R.id.start_button);
        explain_btn = (Button) findViewById(R.id.explain_button);
    }

    public void onClick00(View v) {
        switch (v.getId()) {
            case R.id.start_button:
                Intent intent = new Intent();
                intent.setClass(this, questionActivity01.class);
                startActivity(intent);
                break;

            case R.id.explain_button:
                Intent intent2 = new Intent();
                intent2.setClass(this, explainActivity.class);
                startActivity(intent2);
                break;
        }
    }

}
