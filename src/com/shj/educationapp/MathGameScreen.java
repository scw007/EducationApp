package com.shj.educationapp;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.R.raw;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.MediaPlayer;
import com.github.sendgrid.SendGrid;
import android.widget.Button;
import android.widget.TextView;
import sofia.app.Screen;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MathGameScreen
    extends Screen
{
    private TextView textView1;
    private TextView textView2;
    private Button   button1;
    private Button   button2;
    private Button   button3;
    private Button   button4;
    private MathGame mg;


    public void initialize(String str)
    {
        mg = new MathGame(str);
        this.newQuestion();
        button1.getBackground().setColorFilter(Color.CYAN, PorterDuff.Mode.MULTIPLY);
        button2.getBackground().setColorFilter(Color.CYAN, PorterDuff.Mode.MULTIPLY);
        button3.getBackground().setColorFilter(Color.CYAN, PorterDuff.Mode.MULTIPLY);
        button4.getBackground().setColorFilter(Color.CYAN, PorterDuff.Mode.MULTIPLY);

    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void button1Clicked()
    {

        if (button1.getText().equals(
            "     " + Integer.toString(mg.findAns((mg.getCurrentEquation())))
                + "     "))// the answer)
        {
            if (mg.getNumQuestAsked() < 9)
            {
                this.newQuestion();
                playSound("tada");
            }
            else
            // = 10
            {
                generateReport();
            }

        }
        else
        {
            playSound("uhoh");
            textView2.setText("Oops! Try again!");
            mg.addMistake();
        }
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void button2Clicked()
    {
        if (button2
            .getText()
            .equals(
                ("     "
                    + Integer.toString(mg.findAns((mg.getCurrentEquation()))) + "     ")))
        {
            if (mg.getNumQuestAsked() < 9)
            {
                this.newQuestion();
                playSound("tada");
            }
            else
            // = 10
            {
                generateReport();
            }

        }
        else
        {
            playSound("uhoh");
            textView2.setText("Oops! Try again!");
            mg.addMistake();
        }
    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void button3Clicked()
    {
        if (button3
            .getText()
            .equals(
                ("     "
                    + Integer.toString(mg.findAns((mg.getCurrentEquation()))) + "     ")))
        {
            if (mg.getNumQuestAsked() < 9)
            {
                this.newQuestion();
                playSound("tada");
            }
            else
            // = 10
            {
                generateReport();
            }

        }
        else
        {
            playSound("uhoh");
            textView2.setText("Oops! Try again!");
            mg.addMistake();
        }

    }


    // ----------------------------------------------------------
    /**
     * Place a description of your method here.
     */
    public void button4Clicked()
    {
        if (button4
            .getText()
            .equals(
                ("     "
                    + Integer.toString(mg.findAns((mg.getCurrentEquation()))) + "     ")))
        {
            if (mg.getNumQuestAsked() < 9)
            {
                this.newQuestion();
                playSound("tada");
            }
            else
            // = 10
            {
                generateReport();
            }

        }
        else
        {
            playSound("uhoh");
            textView2.setText("Oops! Try again!");
            mg.addMistake();
        }
    }


    public void generateReport()
    {

        int numQues = mg.getNumQuestAsked();
        int numMis = mg.getNumMistakes();

        SendGrid sendgrid = new SendGrid("username", "password");

        sendgrid.addTo("steven.whitehead007@gmail.com");
        sendgrid.addToName("Steven");
        sendgrid.setFrom("steven.whitehead007@gmail.com");
        sendgrid.setSubject("Education App Progress");

        String report =
            "Greetings. Your child had " + numMis + " mistakes on the "
                + mg.operationWord() + " test they just took. ";
        if (numMis == 0)
        {
            report += "That's impressive! Keep doing whatever you're doing!";
        }
        else if (numMis < 3)
        {
            report +=
                "Alright! Just a simple mistake or two! Make sure they take their time next try.";
        }
        else
        {
            report +=
                "Your child might not understand the core concepts. Maybe you should try taking the test with them to make sure they understand.";
        }
        sendgrid.setText(report);

        try
        {
            sendgrid.send();
        }
        finally
        {
            // No internet. Do nothing
        }

        finish();
    }


    public void newQuestion()
    {
        String eq = mg.generateEquation();
        textView1.setText(mg.generateQuestion(eq));
        textView2.setText("Try this problem!");

        int[] choices = mg.generateChoices(eq);
        button1.setText("     " + Integer.toString(choices[0]) + "     ");
        button2.setText("     " + Integer.toString(choices[1]) + "     ");
        button3.setText("     " + Integer.toString(choices[2]) + "     ");
        button4.setText("     " + Integer.toString(choices[3]) + "     ");
    }


    public void playSound(String sound)
    {
        MediaPlayer amp;
        System.out.println(sound);
        if (sound.equals("uhoh"))
        {
            amp = MediaPlayer.create(this, R.raw.uhoh);
        }
        else
        // (sound.equals("tada"))
        {
            amp = MediaPlayer.create(this, R.raw.tada);
        }
        amp.start();
    }
}
