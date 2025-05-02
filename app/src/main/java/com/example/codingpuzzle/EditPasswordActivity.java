package com.example.codingpuzzle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EditPasswordActivity extends AppCompatActivity {

    private EditText newPasswordEditText;
    private Button savePasswordButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_password);

        newPasswordEditText = findViewById(R.id.newPasswordEditText);
        savePasswordButton = findViewById(R.id.savePasswordButton);

        savePasswordButton.setOnClickListener(v -> updatePassword());
    }

    private void updatePassword() {
        String newPassword = newPasswordEditText.getText().toString().trim();

        if (newPassword.isEmpty()) {
            newPasswordEditText.setError("Password required");
            newPasswordEditText.requestFocus();
            return;
        }

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            user.updatePassword(newPassword)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(EditPasswordActivity.this, "Password updated", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(EditPasswordActivity.this, "Failed to update password", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
}
