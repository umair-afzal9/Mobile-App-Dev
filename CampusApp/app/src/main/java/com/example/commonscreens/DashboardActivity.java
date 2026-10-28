package com.example.commonscreens;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DashboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");

        findViewById(R.id.cardCourses).setOnClickListener(v -> toast(R.string.courses));
        findViewById(R.id.cardSchedule).setOnClickListener(v -> toast(R.string.schedule));
        findViewById(R.id.cardNotifications).setOnClickListener(v -> toast(R.string.notifications));

        findViewById(R.id.cardProfile).setOnClickListener(v -> {
            Intent i = new Intent(this, ProfileActivity.class);
            i.putExtra("name", name);
            i.putExtra("email", email);
            startActivity(i);
        });
    }

    private void toast(int resId) {
        Toast.makeText(this, getString(resId), Toast.LENGTH_SHORT).show();
    }
}
