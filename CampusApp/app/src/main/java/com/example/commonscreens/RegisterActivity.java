package com.example.commonscreens;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText etName, etEmail, etPassword, etConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etConfirm = findViewById(R.id.etConfirm);
        Button btn = findViewById(R.id.btnCreate);

        btn.setOnClickListener(v -> validateAndSave());
    }

    private void validateAndSave() {
        String name = etName.getText().toString().trim();
        String email = etEmail.getText().toString().trim();
        String pass = etPassword.getText().toString();
        String confirm = etConfirm.getText().toString();

        if (name.isEmpty()) { etName.setError(getString(R.string.err_empty)); return; }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            etEmail.setError(getString(R.string.err_email)); return;
        }
        if (pass.length() < 6) { etPassword.setError(getString(R.string.err_pass_len)); return; }
        if (!pass.equals(confirm)) { etConfirm.setError(getString(R.string.err_match)); return; }

        UserStore.name = name;
        UserStore.email = email;
        UserStore.password = pass;

        Toast.makeText(this, R.string.msg_registered, Toast.LENGTH_SHORT).show();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }
}
