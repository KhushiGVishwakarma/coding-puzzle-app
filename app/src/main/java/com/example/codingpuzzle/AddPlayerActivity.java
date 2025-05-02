package com.example.codingpuzzle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddPlayerActivity extends AppCompatActivity {

    private EditText playerNameInput;
    private EditText playerScoreInput;
    private Button addPlayerButton;

    private FirebaseFirestore db;
    private CollectionReference playersRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_player);

        db = FirebaseFirestore.getInstance();
        playersRef = db.collection("players");

        playerNameInput = findViewById(R.id.player_name_input);
        playerScoreInput = findViewById(R.id.player_score_input);
        addPlayerButton = findViewById(R.id.add_player_button);

        addPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addPlayer();
            }
        });
    }

    private void addPlayer() {
        String name = playerNameInput.getText().toString().trim();
        String scoreStr = playerScoreInput.getText().toString().trim();

        if (name.isEmpty() || scoreStr.isEmpty()) {
            Toast.makeText(this, "Please enter both name and score.", Toast.LENGTH_SHORT).show();
            return;
        }

        int score;
        try {
            score = Integer.parseInt(scoreStr);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Invalid score. Please enter a number.", Toast.LENGTH_SHORT).show();
            return;
        }

        Player player = new Player(name, score);

        playersRef.add(player)
                .addOnSuccessListener(documentReference -> {
                    Toast.makeText(this, "Player added successfully!", Toast.LENGTH_SHORT).show();
                    playerNameInput.setText("");
                    playerScoreInput.setText("");
                })
                .addOnFailureListener(e -> {
                    Toast.makeText(this, "Error adding player: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                });
    }
}
