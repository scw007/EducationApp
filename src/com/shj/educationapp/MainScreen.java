package com.shj.educationapp;

import android.graphics.Color;
import android.R.raw;
import android.graphics.PorterDuff;
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

public class MainScreen
    extends Screen
{
    private TextView textView1;
    private TextView textView2;
    private Button   Add;
    private Button   Subtract;
    private Button   Multiply;
    private MathGame mg;

    public void initialize()
    {
        textView2.setText("Hey There!");
        textView1.setText("Tap a button to start!");
        Add.getBackground().setColorFilter(Color.CYAN, PorterDuff.Mode.MULTIPLY);
        Subtract.getBackground().setColorFilter(Color.CYAN, PorterDuff.Mode.MULTIPLY);
        Multiply.getBackground().setColorFilter(Color.CYAN, PorterDuff.Mode.MULTIPLY);

    }
    public void AddClicked()
    {
        presentScreen(MathGameScreen.class, "+");
    }

    public void SubtractClicked()
    {
        presentScreen(MathGameScreen.class, "-");
    }

    public void MultiplyClicked()
    {
        presentScreen(MathGameScreen.class, "*");
    }

}
