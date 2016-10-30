package com.example.inyoung.loading_ex;


import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;





public class MainActivity extends AppCompatActivity {

    private ImageView imgView;
    private TextView tv;
    private RelativeLayout main_layout;
    private Handler handle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = (ImageView)findViewById(R.id.imageView);
        tv = (TextView)findViewById(R.id.textView);
        main_layout = (RelativeLayout)findViewById(R.id.main_layout);

        handle = new Handler();

        loading();
    }

    private void loading()
    {
        Thread th = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    // 3초 대기
                    Thread.sleep(3000);

                    // handle 객체의 post를 통하면 바로 Handle 작업 Queue에 작업을 넣을 수 있다.
                    // 이때는 start메소드를 사용하지 않는다.
                    handle.post(new Runnable() {
                        @Override
                        public void run() {
                            // Gone로 지정
                            imgView.setVisibility(View.GONE);

                            // layout 보이기
                            main_layout.setVisibility(View.VISIBLE);
                        }
                    });


                }catch (Exception e){}

            }
        });

        th.start();

    }
}
