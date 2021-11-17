package com.example.musicmasher;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import java.util.HashMap;
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void updateCurrentMoodString(View view, boolean mood) {
        //does something cuz otherwise nothing
        String currentMood = "Happy";
        String message = mood ? "Current Mood: "+currentMood : "No Current Mood";
        TextView currentMood2 = (TextView) findViewById(R.id.textView3);
        if (mood)
        {
            //some stupid stuff text too large
            currentMood2.setTextSize(25);
            currentMood2.setText(message);
        }
        else {
            currentMood2.setTextSize(29);
            currentMood2.setText(message);
        }
    }
    public void fillRandomArtist(View view) {
        //does something
        EditText artist = (EditText) findViewById(R.id.editTextTextPersonName);
        String artistList[] = {"Kanye", "Drake", "Jon", "Adams", "Joe", "Poe"};
        int pickRandomNum = new Random().nextInt(artistList.length);
        artist.setText(artistList[pickRandomNum]);

    }
    public void fillRandomArtist2(View view) {
        //does something like last something -- > can merge this w/ other function probably by checking ids of button calling
        // but too much work.
        EditText artist = (EditText) findViewById(R.id.editTextTextPersonName2);
        String artistList[] = {"Kanye", "Drake", "Jon", "Adams", "Joe", "Poe"};
        int pickRandomNum = new Random().nextInt(artistList.length);
        artist.setText(artistList[pickRandomNum]);

    }
    public void mashMe(View view) {

        Button masher = (Button) findViewById(R.id.button);
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        //terrible idea loool, someone else fill out this arraylist
        map.put("Drake", new ArrayList<String>(
                Arrays.asList("DrakeSong1", "DrakeSong2")));
        map.put("Kanye", new ArrayList<String>(
                Arrays.asList("KanyeSong1", "KanyeSong2")));
        EditText artist = (EditText) findViewById(R.id.editTextTextPersonName2);
        EditText artist1 = (EditText) findViewById(R.id.editTextTextPersonName);
        ArrayList<String> songs1 = map.get(artist.getText().toString());
        ArrayList<String> songs2 = map.get(artist1.getText().toString());
        ArrayList<String> result = new ArrayList<String>();
        int bound = Math.min(songs1.size(), songs2.size());
        for(int i = 0; i<bound; i++)
        {
            result.add (songs1.get(i) +"x"  + songs2.get(i));

        }
        String wow = result.toString();
        Log.d("myTag", wow);

        TextView editoral = (TextView) findViewById(R.id.textView4);
        editoral.setText(wow);
        //felt like comments are needed here
        //Builds a new intent to pass onto the new page.
        // adds payload to the intent with the result string which is a mashing of
        // the songs of the artist, and then starts the avtivity
        // the new activity should be called 'MasherResult' --> someone has to create this.

        // NEED to test to determine if uniquekeylol needs to be const global
        // probably does, but thats something for next time.
        Bundle passMashed=new Bundle();
        //passMashed.putStringArray("UNIQUEKEYLOL", result);
        // Intent i=new Intent(this, MainActivity.class);
        // i.putExtras(passMashed);
        //   startActivity(i); // moves to masherresult page.
        /* This is how to read it from the masherresult page
        Bundle b=this.getIntent().getExtras();
        String[] array=b.getStringArray(UNIQUEKEYLOL);

         */


    }

    public void checkBoxFunction(View view) {
        boolean mood = true;
        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox);
        mood = cb1.isChecked() ? false: true;
        updateCurrentMoodString(view, mood);

        System.out.println(mood);

    }}