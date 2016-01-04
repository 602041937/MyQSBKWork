package com.hpd.myqsbkwork;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class WelcomeActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.feiye_image);


        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    //显示图片
                    Thread.sleep(500);
                    imageView.post(new Runnable() {
                        @Override
                        public void run() {
                            imageView.setVisibility(View.VISIBLE);
                        }
                    });
                    //打开SecondActivity
                    Thread.sleep(1000);

                    Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }


}
