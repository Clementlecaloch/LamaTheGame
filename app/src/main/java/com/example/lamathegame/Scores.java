package com.example.lamathegame;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Scores extends AppCompatActivity {

    private static final String MY_FILE_NAME = "score";
    private final String eol = System.getProperty("line.separator");
    TextView scores;

    public Context context;

    public Scores() {
        super();
        this.context = Scores.this;
    }

    public Scores(Context context) {
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scores);

        scores = findViewById(R.id.scores);

        //read scoreFile and display it on a TextView
        try {
            scores.setText(readScore());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addScore(String actualScoreText) throws IOException {

        BufferedWriter writer = null;
        try {
            String[] oldScoresText = readScore().split(eol);

            FileOutputStream outputStream = context.openFileOutput(MY_FILE_NAME, Context.MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            writer = new BufferedWriter(outputStreamWriter);

            //read potential previous scores then take the 3 or less best scores out of all
            ArrayList<Integer> oldScores = new ArrayList<Integer>();
            for (String score : oldScoresText) {
                if (score.equals("")) {
                    oldScores.add(0);
                }
                else {
                    oldScores.add(Integer.parseInt(score));
                }
            }
            Collections.reverse(oldScores);

            Integer scoreActual = Integer.parseInt(actualScoreText);
            for (Integer score : oldScores) {
                if (scoreActual > score) {
                    oldScores.set(oldScores.indexOf(score), scoreActual);
                }
            }
            Collections.reverse(oldScores);

            String bestScore = "";
            for (Integer score : oldScores) {
                bestScore += String.valueOf(score);
            }

            writer.write(bestScore);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private String readScore() throws IOException {
        FileInputStream inputStream = context.openFileInput(MY_FILE_NAME);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String value = "";

        StringBuilder stringBuilder = new StringBuilder();
        String line;
        while((line = bufferedReader.readLine()) != null){
            value = String.valueOf(stringBuilder.append(line + eol));
        }
        return value;
    }
}
