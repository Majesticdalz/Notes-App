package com.example.admin.projectandroid.Activity;

import android.animation.Animator;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.ChangeBounds;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.dd.processbutton.iml.ActionProcessButton;
import com.example.admin.projectandroid.R;
import com.example.admin.projectandroid.Utils.ProgressGenerator;

public class LoginActivity extends AppCompatActivity implements ProgressGenerator.OnCompleteListener {

    public TextView mCreateAccount;
    public TextView mForgetPassword;
    public EditText mUsername;
    public EditText mPassword;
     ActionProcessButton btnSignIn;
    public TextInputLayout layUserEdit;
    public TextInputLayout layPassEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mCreateAccount = (TextView) findViewById(R.id.txtCreateAccount);
        mForgetPassword = (TextView) findViewById(R.id.txtForgetPassword);
        mPassword = (EditText) findViewById(R.id.txtPassword);
        mUsername = (EditText) findViewById(R.id.txtUsername);
        layPassEdit = (TextInputLayout) findViewById(R.id.textInputLayoutPass);
        layUserEdit = (TextInputLayout) findViewById(R.id.textInputLayoutUser);

        mCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,CreateaccountActivity.class);
                startActivity(i);

            }
        });

        mForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,ForgotActivity.class);
                startActivity(i);
            }
        });

        final ProgressGenerator progressGenerator = new ProgressGenerator(this);
         btnSignIn = (ActionProcessButton) findViewById(R.id.btnSignIn);

            btnSignIn.setMode(ActionProcessButton.Mode.ENDLESS);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressGenerator.start(btnSignIn);
                btnSignIn.setEnabled(false);
                mUsername.setEnabled(false);
                mPassword.setEnabled(false);
                mForgetPassword.setEnabled(false);
                mCreateAccount.setEnabled(false);
            }
        });

    }

    @Override
    public void onComplete() {
        mCreateAccount.setVisibility(View.INVISIBLE);
        mPassword.setVisibility(View.INVISIBLE);
        mCreateAccount.setVisibility(View.INVISIBLE);
        mForgetPassword.setVisibility(View.INVISIBLE);
        layUserEdit.setVisibility(View.INVISIBLE);
        layPassEdit.setVisibility(View.INVISIBLE);
        animateIntent(btnSignIn);

    }
    public void animateIntent(View view)
    {
        View myView = findViewById(R.id.welcomeLayout);
        int cx = myView.getWidth() / 2;
        int cy = myView.getHeight() / 2;
        float finalRadius = (float) Math.hypot(cx, cy);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Animator anim =
                    ViewAnimationUtils.createCircularReveal(myView, cx, cy, 0, finalRadius);
            myView.setVisibility(View.VISIBLE);
            anim.start();
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(LoginActivity.this,DashboardActivity.class);

                    ActivityOptionsCompat options = ActivityOptionsCompat.
                            makeSceneTransitionAnimation(LoginActivity.this,(View)findViewById(R.id.txtWelcome),"textTransition");
                    startActivity(i, options.toBundle());
                }
            }, 2000);

        }
        else
        {
            myView.setVisibility(View.VISIBLE);

        }
    }

}
