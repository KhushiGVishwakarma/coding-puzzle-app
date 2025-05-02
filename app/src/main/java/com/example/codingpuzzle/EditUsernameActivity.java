package com.example.codingpuzzle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

public class EditUsernameActivity extends AppCompatActivity {

    private EditText newUsernameEditText;
    private Button saveUsernameButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_username);

        newUsernameEditText = findViewById(R.id.newUsernameEditText);
        saveUsernameButton = findViewById(R.id.saveUsernameButton);

        saveUsernameButton.setOnClickListener(v -> updateUsername());
    }

    private void updateUsername() {
        String newUsername = newUsernameEditText.getText().toString().trim();

        if (newUsername.isEmpty()) {
            newUsernameEditText.setError("Username required");
            newUsernameEditText.requestFocus();
            return;
        }

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder()
                    .setDisplayName(newUsername)
                    .build();

            user.updateProfile(profileUpdates)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(EditUsernameActivity.this, "Username updated", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(EditUsernameActivity.this, "Failed to update username", Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }
}
