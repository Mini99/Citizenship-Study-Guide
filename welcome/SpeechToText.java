package com.example.welcome;

import android.content.Intent;
import android.os.Handler;
import android.speech.RecognizerIntent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TextView;
import android.widget.ImageButton;
import java.util.ArrayList;
import android.view.View;

import org.w3c.dom.Text;

import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;



public class SpeechToText extends AppCompatActivity {

    private static final int REQUEST_CODE_SPEECH_INPUT = 1000;

    TextView mTextTv;
    TextView mTextTv2;
    TextView givenText;
    ImageButton mVoiceBtn;
    Button bnext;

    // String question1 = new String("George Washington was the first president");

    List<String> list;
    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speech_to_text);

        mTextTv = findViewById(R.id.textTv);
        mTextTv2 = findViewById(R.id.textTv2);
        givenText = findViewById(R.id.textTv);
        mVoiceBtn = findViewById(R.id.voiceBtn);
        bnext = findViewById(R.id.bnext);

        list = new ArrayList<>();
        list.add("George Washington was the first President");
        list.add("When is Thanksgiving");
        list.add("Who is the Father of Our Country");
        list.add("When is Columbus Day");
        list.add("Who is on the $1 bill");
        list.add("What city was the first capital of the United States");
        list.add("Who lived here first");
        list.add("George Washington is on the one-dollar bill");
        list.add("When is Independence Day");
        list.add("What are the colors of the American flag");
        list.add("What is the capital of the United States");
        list.add("Who elects Congress");
        list.add("Who was the second President");
        list.add("Where is the White House");
        list.add("Who was George Washington");
        list.add("The President lives in the White House");
        list.add("How many states does the U.S.  have");
        list.add("Who was Abraham Lincoln");
        list.add("When is Presidents’ Day");
        list.add("A United States citizen has the right to vote");
        list.add("When is Labor Day");
        list.add("Name one right in the Bill of Rights");
        list.add("Where does Congress meet");
        list.add("What country is to the north of the United States");
        list.add("What do we have to pay to the government");
        list.add("Who can vote");
        list.add("When is Flag Day");
        list.add("What is the largest state");
        list.add("How many senators does the Congress have");
        list.add("What state has the most people");
        list.add("What country is to the south of the United States");
        list.add("When is Memorial Day");
        list.add("What was the first state");
        list.add("George Washington is the Father of Our Country");

        Collections.shuffle(list, new Random(System.nanoTime()));


        mTextTv.setText(list.get(index));



        mVoiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speak();
            }
        });

        final Button button = (Button) findViewById(R.id.bnext);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });

    }



    private void speak() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hi speak something");

        try {
            startActivityForResult(intent, REQUEST_CODE_SPEECH_INPUT);
        } catch (Exception e) {
            Toast.makeText(this, "" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_CODE_SPEECH_INPUT: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    String question = new String();
                    question = list.get(index);


                    if (question.equalsIgnoreCase(result.get(0))) {
                        mTextTv2.setText("Correct!");
                        bnext.setVisibility(View.VISIBLE);



                    } else {
                        mTextTv2.setText("Sorry, try again.");
                    }

                }
                break;
            }

        }

    }

}

