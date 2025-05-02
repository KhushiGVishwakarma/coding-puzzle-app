package com.example.codingpuzzle;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import com.example.codingpuzzle.databinding.QuizItemRecyclerRowBinding;

public class QuizAdapter extends RecyclerView.Adapter<QuizAdapter.MyViewHolder> {

    private List<QuizModel> quizModelList;

    public QuizAdapter(List<QuizModel> quizModelList) {
        this.quizModelList = quizModelList;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final QuizItemRecyclerRowBinding binding;

        public MyViewHolder(QuizItemRecyclerRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(QuizModel model) {
            binding.quizTitleText.setText(model.getTitle());
            binding.quizSubtitleText.setText(model.getSubtitle());
            binding.quizTimeText.setText(model.getTime() + " min");

            binding.getRoot().setOnClickListener(v -> {
                Context context = binding.getRoot().getContext();
                Intent intent = new Intent(context, QuizActivity.class);
                QuizActivity.questionModelList = model.getQuestionList();
                QuizActivity.time = model.getTime();
                context.startActivity(intent);
            });
        }
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        QuizItemRecyclerRowBinding binding = QuizItemRecyclerRowBinding.inflate(inflater, parent, false);
        return new MyViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bind(quizModelList.get(position));
    }

    @Override
    public int getItemCount() {
        return quizModelList.size();
    }
}
