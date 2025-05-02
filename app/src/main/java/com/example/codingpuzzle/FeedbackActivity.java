package com.example.codingpuzzle;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedbackActivity extends AppCompatActivity {

    private EditText usernameEditText, emailEditText, feedbackEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        usernameEditText = findViewById(R.id.usernameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        feedbackEditText = findViewById(R.id.editText_feedback);
        submitButton = findViewById(R.id.button_submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitFeedback();
            }
        });
    }

    private void submitFeedback() {
        String username = usernameEditText.getText().toString().trim();
        String email = emailEditText.getText().toString().trim();
        String feedback = feedbackEditText.getText().toString().trim();

        if (username.isEmpty() || !username.matches("[a-zA-Z0-9]{3,15}")) {
            usernameEditText.setError("Enter a valid username (3-15 alphanumeric characters).");
            return;
        }

        if (email.isEmpty() || !isValidEmail(email)) {
            emailEditText.setError("Enter a valid email address.");
            return;
        }

        if (feedback.isEmpty()) {
            feedbackEditText.setError("Please enter your feedback.");
            return;
        }

        Toast.makeText(this, "Feedback submitted successfully!", Toast.LENGTH_SHORT).show();

        usernameEditText.setText("");
        emailEditText.setText("");
        feedbackEditText.setText("");
    }

    private boolean isValidEmail(CharSequence email) {
        return !TextUtils.isEmpty(email) && Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }
}
