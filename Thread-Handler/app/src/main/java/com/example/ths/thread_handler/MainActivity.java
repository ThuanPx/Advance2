package com.example.ths.thread_handler;

import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicBoolean;

public class MainActivity extends AppCompatActivity {
    private final String TAG = getClass().getSimpleName();
    private Handler mHandler;
    private Button btStart;
    private TextView tv;
    private ProgressBar mProgressBar;
    private AtomicBoolean isRunning = new AtomicBoolean(false);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doStart();
            }
        });
        mHandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                mProgressBar.setProgress(msg.arg1);
                tv.setText(msg.arg1+"%");
            }
        };
    }

    private void doStart() {
        mProgressBar.setProgress(0);
        isRunning.set(false);
        Thread  thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 1;i<=100 && isRunning.get();i++){
                    Log.d(TAG,isRunning.get()+" - "+i);
                    SystemClock.sleep(100);
                    Message msg=mHandler.obtainMessage();
                    msg.arg1=i;
                    mHandler.sendMessage(msg);
                }
            }
        });
        isRunning.set(true);
        thread.start();
    }

    private void initView() {
        btStart = (Button) findViewById(R.id.btnstart);
        tv = (TextView) findViewById(R.id.tv);
        mProgressBar = (ProgressBar) findViewById(R.id.pro);
    }
}
