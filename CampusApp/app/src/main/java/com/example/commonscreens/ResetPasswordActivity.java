package com.example.commonscreens;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ResetPasswordActivity extends AppCompatActivity {
    EditText etNew, etConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        etNew = findViewById(R.id.etNew);
        etConfirm = findViewById(R.id.etConfirm);
        Button btn = findViewById(R.id.btnReset);

        btn.setOnClickListener(v -> {
            String p1 = etNew.getText().toString();
            String p2 = etConfirm.getText().toString();

            if (p1.length() < 6) { etNew.setError(getString(R.string.err_pass_len)); return; }
            if (!p1.equals(p2)) { etConfirm.setError(getString(R.string.err_match)); return; }

            UserStore.password = p1;
            Toast.makeText(this, R.string.msg_reset_done, Toast.LENGTH_SHORT).show();

            Intent i = new Intent(this, LoginActivity.class);
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(i);
            finish();
        });
    }
}
