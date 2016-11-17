package com.example.artm.rockpaperscissors;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button button_paper, button_scissors, button_rock;
    ImageView imageView_computer, imageView_player;

    String ComputerChoice;
    String PlayerChoice;
    String Result;

    Random r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_paper = (Button) findViewById(R.id.button_paper);
        button_scissors = (Button) findViewById(R.id.button_scissors);
        button_rock = (Button) findViewById(R.id.button_rock);

        imageView_computer = (ImageView) findViewById(R.id.imageView_computer);
        imageView_player = (ImageView) findViewById(R.id.imageView_player);

        r = new Random();

        button_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayerChoice = "Paper";
                imageView_player.setImageResource(R.drawable.paper);
                ComputerChoices();
            }
        });

        button_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayerChoice = "Scissors";
                imageView_player.setImageResource(R.drawable.scissors);
                ComputerChoices();
            }
        });

        button_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PlayerChoice = "Rock";
                imageView_player.setImageResource(R.drawable.rock);
                ComputerChoices();
            }
        });
    }

    public void ComputerChoices() {
        int Computer = r.nextInt(3);

        if(Computer == 0) {
            ComputerChoice = "Paper";
            imageView_computer.setImageResource(R.drawable.paper);
        } else if(Computer == 1){
            ComputerChoice = "Scissors";
            imageView_computer.setImageResource(R.drawable.scissors);
        } else if(Computer == 2) {
            ComputerChoice = "Rock";
            imageView_computer.setImageResource(R.drawable.rock);
        }

        if(PlayerChoice.equals("Paper") && ComputerChoice.equals("Paper")) {
            Result = "It's Tie :(";
        }
        if(PlayerChoice.equals("Rock") && ComputerChoice.equals("Rock")) {
            Result = "It's Tie :(";
        }
        if(PlayerChoice.equals("Scissors") && ComputerChoice.equals("Scissors")) {
            Result = "It's Tie :(";
        }
        if(PlayerChoice.equals("Rock") && ComputerChoice.equals("Scissors")) {
            Result = "You Won!";
        }
        if(PlayerChoice.equals("Scissors") && ComputerChoice.equals("Paper")) {
            Result = "You Won!";
        }
        if(PlayerChoice.equals("Paper") && ComputerChoice.equals("Rock")) {
            Result = "You Won!";
        }
        if(PlayerChoice.equals("Paper") && ComputerChoice.equals("Scissors")) {
            Result = "You Lost!";
        }
        if(PlayerChoice.equals("Rock") && ComputerChoice.equals("Paper")) {
            Result = "You Lost!";
        }
        if(PlayerChoice.equals("Scissors") && ComputerChoice.equals("Rock")) {
            Result = "You Lost!";
        }

        Toast.makeText(MainActivity.this, Result, Toast.LENGTH_SHORT).show();
    }
}
