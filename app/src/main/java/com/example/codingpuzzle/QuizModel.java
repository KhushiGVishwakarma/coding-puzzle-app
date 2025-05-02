package com.example.codingpuzzle;

import java.util.List;
import java.util.Collections;

public class QuizModel {
    private String id;
    private String title;
    private String subtitle;
    private String time;
    private List<QuestionModel> questionList;

    public QuizModel() {
        this("", "", "", "", Collections.emptyList());
    }

    public QuizModel(String id, String title, String subtitle, String time, List<QuestionModel> questionList) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.time = time;
        this.questionList = questionList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public List<QuestionModel> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(List<QuestionModel> questionList) {
        this.questionList = questionList;
    }
}

class QuestionModel {
    private String question;
    private List<String> options;
    private String correct;

    public QuestionModel() {
        this("", Collections.emptyList(), "");
    }

    public QuestionModel(String question, List<String> options, String correct) {
        this.question = question;
        this.options = options;
        this.correct = correct;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getCorrect() {
        return correct;
    }

    public void setCorrect(String correct) {
        this.correct = correct;
    }
}