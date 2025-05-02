package com.example.codingpuzzle;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class WebLanguagesActivity extends AppCompatActivity {

    private CardView cssCard, htmlCard, javascriptCard, phpCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_languages);

        cssCard = findViewById(R.id.cssCard);
        htmlCard = findViewById(R.id.htmlCard);
        javascriptCard = findViewById(R.id.javascriptCard);
        phpCard = findViewById(R.id.phpCard);

        cssCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WebLanguagesActivity.this, CSSActivity.class);
                startActivity(intent);
            }
        });

        htmlCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WebLanguagesActivity.this, HTMLActivity.class);
                startActivity(intent);
            }
        });

        javascriptCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WebLanguagesActivity.this, JavascriptActivity.class);
                startActivity(intent);
            }
        });

        phpCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WebLanguagesActivity.this, PHPActivity.class);
                startActivity(intent);
            }
        });
    }
}