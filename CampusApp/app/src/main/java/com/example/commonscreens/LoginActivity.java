package com.example.commonscreens;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        Button btnLogin = findViewById(R.id.btnLogin);
        Button btnRegister = findViewById(R.id.btnRegister);
        TextView tvForgot = findViewById(R.id.tvForgot);

        btnLogin.setOnClickListener(v -> attemptLogin());
        btnRegister.setOnClickListener(v ->
                startActivity(new Intent(this, RegisterActivity.class)));
        tvForgot.setOnClickListener(v ->
                startActivity(new Intent(this, ForgotPasswordActivity.class)));
    }

    private void attemptLogin() {
        String email = etEmail.getText().toString().trim();
        String pass = etPassword.getText().toString();

        if (email.isEmpty()) { etEmail.setError(getString(R.string.err_empty)); return; }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError(getString(R.string.err_email)); return;
        }
        if (pass.isEmpty()) { etPassword.setError(getString(R.string.err_empty)); return; }

        if (email.equalsIgnoreCase(UserStore.email) && pass.equals(UserStore.password)) {
            Intent i = new Intent(this, DashboardActivity.class);
            i.putExtra("name", UserStore.name);
            i.putExtra("email", UserStore.email);
            startActivity(i);
            finish();
        } else {
            etPassword.setError(getString(R.string.err_login));
        }
    }
}
