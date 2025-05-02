package com.example.codingpuzzle;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class StartPageActivity extends AppCompatActivity {

    private Button Move;
    private Button Settings;
    private Button About;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String theme = sharedPreferences.getString("app_theme", "Light");

        if (theme.equals("Dark")) {
            setTheme(androidx.appcompat.R.style.Theme_AppCompat_NoActionBar); // Replace with your dark theme
        } else {
            setTheme(com.developer.gbuttons.R.style.Theme_AppCompat_Light_NoActionBar); // Replace with your light theme
        }

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start_page);
        Move = findViewById(R.id.Move);
        Move.setOnClickListener(v -> {
            Intent intent = new Intent(StartPageActivity.this, LoginActivity.class);
            startActivity(intent);
        });
        Settings = findViewById(R.id.Settings);
        Settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartPageActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
        About = findViewById(R.id.About);
        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartPageActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }
}