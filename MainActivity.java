package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;



public class MainActivity extends AppCompatActivity {
    Random random = new Random();
    int randomNumber = random.nextInt(100) + 1;
    int lives = 5;
    boolean gameEnded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBtnClick (View view) {

        TextView livesView = findViewById(R.id.livesView);
        TextView hintView = findViewById(R.id.hintView);
        EditText edtGuess = findViewById(R.id.edtGuess);
        Button submitButton = findViewById(R.id.submitButton);

        String edtGuessString = edtGuess.getText().toString();
        int edtGuessInt = Integer.parseInt(edtGuessString);

        if (edtGuessInt > randomNumber && lives == 1 || edtGuessInt < randomNumber && lives == 1) {
            lives--;
            edtGuess.setVisibility(View.INVISIBLE);
            hintView.setText("You have run out of lives!");

        } else if (edtGuessInt > randomNumber) {
            hintView.setText("Guess lower.");
            edtGuess.setText("");
            lives--;
        } else if (edtGuessInt < randomNumber) {
            hintView.setText("Guess higher.");
            edtGuess.setText("");
            lives--;
        } else {
            hintView.setText("Congratulations, you have guessed the number!");            lives--;
            edtGuess.setVisibility(View.INVISIBLE);
            submitButton.setText("Restart");
            submitButton.setBackgroundColor(Color.RED);
        }
        livesView.setText(String.valueOf(lives));
    }

}