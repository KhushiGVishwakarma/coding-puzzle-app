package com.example.codingpuzzle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    private TextView usernameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        setupBottomNavigation();

        usernameTextView = findViewById(R.id.usernameTextView);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            String username = user.getDisplayName();

            if (username != null && !username.isEmpty()) {
                usernameTextView.setText(username);
            } else {

                usernameTextView.setText("No username available");
            }
        } else {
            usernameTextView.setText("User not logged in");
        }

        TextView editUsername = findViewById(R.id.editUsernameTextView);
        editUsername.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, EditUsernameActivity.class);
            startActivity(intent);
        });

        TextView editEmail = findViewById(R.id.editEmailTextView);
        editEmail.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, EditEmailActivity.class);
            startActivity(intent);
        });

        TextView changePassword = findViewById(R.id.changePasswordTextView);
        changePassword.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, EditPasswordActivity.class);
            startActivity(intent);
        });

        TextView About = findViewById(R.id.About);
        About.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, AboutActivity.class);
            startActivity(intent);
        });

        TextView logout = findViewById(R.id.logout);
        logout.setOnClickListener(v -> {
            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(ProfileActivity.this, StartPageActivity.class);
            startActivity(intent);
            finish();
        });

        TextView Feedback = findViewById(R.id.Feedback);
        Feedback.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, FeedbackActivity.class);
            startActivity(intent);
        });
    }

    private void setupBottomNavigation() {
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation);
        bottomNavigationView.setSelectedItemId(R.id.bottom_profile);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.bottom_home:
                    startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_leaderboard:
                    startActivity(new Intent(getApplicationContext(), LeaderboardActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_settings:
                    startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                    finish();
                    return true;
                case R.id.bottom_profile:
                    return true;
            }
            return false;
        });
    }
}
