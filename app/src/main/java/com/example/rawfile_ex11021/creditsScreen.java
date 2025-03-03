package com.example.rawfile_ex11021;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class creditsScreen extends AppCompatActivity
{
    /**
     * Creates a new credits screen
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits_screen);
    }

    /**
     * once clicked, will throw the user back to the main activity
     * @param view
     */
    public void goBack(View view)
    {
        finish();
    }
}