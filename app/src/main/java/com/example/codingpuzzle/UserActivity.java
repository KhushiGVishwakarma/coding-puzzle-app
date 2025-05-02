package com.example.codingpuzzle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserActivity extends AppCompatActivity {

    private Button Move;
    private Button logout;
    private GoogleSignInClient gClient;
    private GoogleSignInOptions gOptions;
    private TextView textViewWelcome;
    private TextView userEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Move = findViewById(R.id.Move);
        logout = findViewById(R.id.logout);
        textViewWelcome = findViewById(R.id.textViewWelcome);
        userEmail = findViewById(R.id.user_email);

        gOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        gClient = GoogleSignIn.getClient(this, gOptions);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        if (user != null) {
            String email = user.getEmail();
            String username = user.getDisplayName();

            textViewWelcome.setText("Welcome, " + (username != null ? username : " User ") + "!!!");
            userEmail.setText(email);
        }

        Move.setOnClickListener(v -> {
            Intent intent = new Intent(UserActivity.this, HomeActivity.class);
            startActivity(intent);
        });

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gClient.signOut().addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        finish();
                        startActivity(new Intent(UserActivity.this, LoginActivity.class));
                    }
                });
            }
        });
    }
}