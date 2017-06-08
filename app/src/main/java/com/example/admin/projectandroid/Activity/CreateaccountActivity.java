package com.example.admin.projectandroid.Activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.projectandroid.R;
import com.example.admin.projectandroid.Utils.ProgressGenerator;

public class CreateaccountActivity extends AppCompatActivity implements ProgressGenerator.OnCompleteListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createaccount);
    }

    @Override
    public void onComplete() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(CreateaccountActivity.this,LoginActivity.class);
                startActivity(i);
            }
        }, 1000);
    }
}
