package com.example.commonscreens;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordActivity extends AppCompatActivity {
    EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        etEmail = findViewById(R.id.etEmail);
        Button btn = findViewById(R.id.btnSend);

        btn.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.setError(getString(R.string.err_email)); return;
            }
            if (!email.equalsIgnoreCase(UserStore.email)) {
                etEmail.setError(getString(R.string.err_not_found)); return;
            }
            Toast.makeText(this, R.string.msg_recovery, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, ResetPasswordActivity.class));
            finish();
        });
    }
}
