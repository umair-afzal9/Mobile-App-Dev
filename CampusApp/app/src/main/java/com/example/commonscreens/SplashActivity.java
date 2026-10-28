package com.example.commonscreens;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private boolean opened = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        findViewById(R.id.splashRoot).setOnClickListener(v -> goToLogin());
        new Handler(Looper.getMainLooper()).postDelayed(this::goToLogin, 2000);
    }

    private void goToLogin() {
        if (opened) return;
        opened = true;
        startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        finish();
    }
}
