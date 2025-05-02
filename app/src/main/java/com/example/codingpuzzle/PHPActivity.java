package com.example.codingpuzzle;

import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.example.codingpuzzle.databinding.ActivityPhpBinding;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.FirebaseDatabase;
import java.util.ArrayList;
import java.util.List;

public class PHPActivity extends AppCompatActivity {

    private ActivityPhpBinding binding;
    private List<QuizModel> quizModelList;
    private QuizAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        quizModelList = new ArrayList<>();
        getDataFromFirebase();
    }

    private void setupRecyclerView() {
        adapter = new QuizAdapter(quizModelList);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(adapter);
    }

    private void getDataFromFirebase() {
        FirebaseDatabase.getInstance().getReference("Questions/PHP/quizzes")
                .get()
                .addOnSuccessListener(dataSnapshot -> {
                    if (dataSnapshot.exists()) {
                        for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                            QuizModel quizModel = snapshot.getValue(QuizModel.class);
                            if (quizModel != null) {
                                quizModelList.add(quizModel);
                            }
                        }
                        setupRecyclerView();
                    }
                })
                .addOnFailureListener(e -> {
                    Log.e("FirebaseError", "Error fetching data", e);
                });
    }
}