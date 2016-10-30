package com.example.inyoung.handler_ex;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv;
    private Button btn;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView)findViewById(R.id.tv);
        btn = (Button)findViewById(R.id.btn);

    }

    public void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.btn :
                Thread th = new Thread(new Runnable(){
                    int i = 0 ;
                    @Override
                    public void run() {
                        while(20 > i)
                        {
                            try {
                                // 스레드 1초 정지
                                Thread.sleep(1000);

                                // 전달할 메세지 객체 준비
                                Message msg = new Message();

                                // 메세지 구분자 설정
                                msg.what = 1;

                                // 메세지에 값 입력 public로 되어있어서 바로 접근 가능
                                msg.arg1 = i;

                                // Handler에 메세지 전송 -> handleMessage()메소드로 전송 된다.
                                handler.sendMessage(msg);

                                System.out.println("Handler Call");

                                i++;

                            }catch (Exception e){e.printStackTrace();}

                        }
                    }
                } );

                th.start();
                break;
        }
    }


    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {

            switch(msg.what) // 메세지를 구분 한다.
            {
                case 1 :
                    // public 변수를 통해서 값을 가져 올 수 있다.
                    int i = msg.arg1;

                    // UI수정, (Thread에서는 UI수정이 안되기 때문이다)
                    tv.setText(""+i);
                    System.out.println("Handler Message Recive");
                    break;
            }
        }
    };
}
