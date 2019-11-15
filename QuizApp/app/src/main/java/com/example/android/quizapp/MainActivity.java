package com.example.android.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int score = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getScore(View view) {
        EditText name = (EditText) findViewById(R.id.editText_name);
        String userName = name.getText().toString();
        TextView showScore = (TextView) findViewById(R.id.showScore);
        showScore.setText(createScoreSummary(userName));

        Context context = getApplicationContext();
        CharSequence text = createScoreSummary(userName);
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();


    }

    private String createScoreSummary(String userName) {
        String userScore = "Name: " + userName;
        userScore += "\nScore: " + score;

        RadioButton q1_correctAnswer, q2_correctAnswer, q4_correctAnswer;
        CheckBox q3_correctAnswer1, q3_correctAnswer2,q3_wrongAnswer;

        q1_correctAnswer = (RadioButton) findViewById(R.id.radioButton_q1_329M);
        q2_correctAnswer = (RadioButton) findViewById(R.id.radioButton_q2_no);
        q3_correctAnswer1 = (CheckBox) findViewById(R.id.checkbox_los);
        q3_correctAnswer2 = (CheckBox) findViewById(R.id.checkbox_sanDiego);
        q3_wrongAnswer = (CheckBox) findViewById(R.id.checkbox_nevada);
        q4_correctAnswer = (RadioButton) findViewById(R.id.radioButton_q4_newYork);

        if (q1_correctAnswer.isChecked())
            userScore += "\nQ1: Right Answer";
        else
            userScore += "\nQ1: Wrong Answer";
        if (q2_correctAnswer.isChecked())
            userScore += "\nQ2: Right Answer";
        else
            userScore += "\nQ2: Wrong Answer";

        if (q3_correctAnswer1.isChecked() && q3_correctAnswer2.isChecked()&& !q3_wrongAnswer.isChecked())
            userScore += "\nQ3: 2 Correct Answer";

        if (q4_correctAnswer.isChecked())
            userScore += "\nQ4: Right Answer";
        else
            userScore += "\nQ4: Wrong Answer";

        return userScore;
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButton_q1_300M:
            case R.id.radioButton_q1_350M:
            case R.id.radioButton_q2_yes:
            case R.id.radioButton_q4_losAngeles:
                if (checked)
                    // do nothing
                    if (score == 0)
                        break;
                score -= 5;

                break;

            case R.id.radioButton_q1_329M:
            case R.id.radioButton_q2_no:
            case R.id.radioButton_q4_newYork:

                if (checked)
                    // correct answer add 5 point
                    score += 5;
                break;
        }
    }


    public void onCheckboxClicked(View view) {
//        // Is the view now checked?
//        boolean checked = ((CheckBox) view).isChecked();
//
//        // Check which checkbox was clicked
//        switch (view.getId()) {
//            case R.id.checkbox_los:
//            case R.id.checkbox_sanDiego:
//                if (checked)
//                    // add 5 points to score
//                    score += 5;
//                break;
//            case R.id.checkbox_nevada:
//
//        }


        CheckBox q3_correctAnswer1 = (CheckBox) findViewById(R.id.checkbox_los);
        CheckBox q3_correctAnswer2 = (CheckBox) findViewById(R.id.checkbox_sanDiego);
        CheckBox q3_wrongAnswer = (CheckBox) findViewById(R.id.checkbox_nevada);

        if (q3_correctAnswer1.isChecked() && q3_correctAnswer2.isChecked()&& !q3_wrongAnswer.isChecked())
            score += 10;
        else if ((q3_correctAnswer1.isChecked() | q3_correctAnswer2.isChecked()| q3_wrongAnswer.isChecked()) && (score != 0))
        score -= 10;



    }

}
