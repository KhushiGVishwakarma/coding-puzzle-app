package com.example.codingpuzzle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class EditEmailActivity extends AppCompatActivity {

    private EditText newEmailEditText;
    private Button saveEmailButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_email);

        newEmailEditText = findViewById(R.id.newEmailEditText);
        saveEmailButton = findViewById(R.id.saveEmailButton);

        saveEmailButton.setOnClickListener(v -> updateEmail());
    }

    private void updateEmail() {
        String newEmail = newEmailEditText.getText().toString().trim();

        if (newEmail.isEmpty()) {
            newEmailEditText.setError("Email required");
            newEmailEditText.requestFocus();
            return;
        }

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            user.updateEmail(newEmail)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(EditEmailActivity.this, "Email updated", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(EditEmailActivity.this, "Failed to update email", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
}
