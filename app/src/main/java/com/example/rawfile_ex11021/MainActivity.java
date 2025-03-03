package com.example.rawfile_ex11021;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity
{
    /**
     * this is the main activity of the rawFile app project
     * @author ofek Dafna
     */
    private final String FILENAME = "raw.txt";

    TextView showingText;
    EditText inputText;
    Button rawFIleBtn,textBtn,credits;
    String line,fileName;
    int resourceId;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //----------------------------------------------------------------
        showingText = findViewById(R.id.showingText);
        inputText = findViewById(R.id.textInput);
        rawFIleBtn = findViewById(R.id.rawFileButton);
        textBtn = findViewById(R.id.textButton);
        credits = findViewById(R.id.credits);

    }

    /**
     * once the button is clicked, the data saved in the raw file will be shown on the screen
     * @param view
     */
    public void rawFileButton(View view)
    {
        try
        {
            fileName = FILENAME.substring(0,	(FILENAME.length() - 4));

            resourceId = this.getResources().getIdentifier(fileName,"raw",this.getPackageName());
            InputStream iS = this.getResources().openRawResource(resourceId);
            InputStreamReader iSR = new InputStreamReader(iS);
            BufferedReader bR = new BufferedReader(iSR);
            //-------------------------------------------------
            StringBuilder FileData = new StringBuilder();
            line = bR.readLine();
            while(line != null)
            {
                FileData.append(line+"\n");
                line = bR.readLine();
            }
            showingText.setText(FileData.toString());

            bR.close();
            iSR.close();
            iS.close();
        }
        catch (Exception e)
        {
            showingText.setText("Error reading file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /**
     * once the button is clicked, the data that the user had entered will be shown on the screen
     * @param view
     */
    public void textButton(View view)
    {
        showingText.setText(inputText.getText().toString());
    }

    /**
     * once the button is clicked, the user will be sent to the credits screen
     * @param view
     */
    public void credits(View view)
    {

    }
}