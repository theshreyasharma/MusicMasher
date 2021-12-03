package com.example.musicmasher;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Random;

import java.util.HashMap;
import java.util.TreeMap;

public class Mash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mash);
        ImageView imageRounded= (ImageView) findViewById(R.id.imageLeft);
                imageRounded.setClipToOutline(true);
        if (getIntent().getStringExtra("MOOD") != null) {
            updateCurrentMoodString(true);
        } else {
            updateCurrentMoodString(false);
        }
        AutoCompleteTextView textView = (AutoCompleteTextView) findViewById(R.id.editTextTextPersonName);
        String[] artists = getResources().getStringArray(R.array.artist_array);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, artists);
        textView.setAdapter(adapter);
        AutoCompleteTextView textView2 = (AutoCompleteTextView) findViewById(R.id.editTextTextPersonName2);
        String[] artists2 = getResources().getStringArray(R.array.artist_array);
        ArrayAdapter<String> adapter2 =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, artists2);
        textView2.setAdapter(adapter2);
    }
    public void updateCurrentMoodString(boolean mood) {
        Log.d("tag", "control");
        Bundle b=this.getIntent().getExtras();
        String currentMood =b.getString("MOOD");
        String message = mood ? "Current Mood: "+currentMood : "No Current Mood";
        TextView currentMood2 = (TextView) findViewById(R.id.textView3);
        if (mood)
        {
            currentMood2.setTextSize(25);
            currentMood2.setText(message);
        }
        else {
            currentMood2.setTextSize(25);
            currentMood2.setText(message);
        }
    }
    public void fillRandomArtist(View view) {
        EditText artist = (EditText) findViewById(R.id.editTextTextPersonName);
        String artistList[] = getResources().getStringArray(R.array.artist_array);

        int pickRandomNum = new Random().nextInt(artistList.length);
        artist.setText(artistList[pickRandomNum]);

    }
    public void fillRandomArtist2(View view) {
        EditText artist = (EditText) findViewById(R.id.editTextTextPersonName2);
        String artistList[] = getResources().getStringArray(R.array.artist_array);
        int pickRandomNum = new Random().nextInt(artistList.length);
        artist.setText(artistList[pickRandomNum]);

    }

    public void onClickProfile(View view) {
            String mood = getIntent().getStringExtra("MOOD");
            Intent intent = new Intent(view.getContext(), PFPActivity.class);
            intent.putExtra("MOOD", mood);
            startActivity(intent);
        }
    public void mashMe(View view) {
        HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();

        /**
         * To whomever wants to help me add artists,
         * add their key as ALL lowercase please.
         */
        map.put("drake", new ArrayList<String>(
                Arrays.asList("God's Plan", "Way 2 Sexy", "Toosie Slide", "Know Yourself", "One Dance", "Laugh Now Cry Later")));
        map.put("kanye west", new ArrayList<String>(
                Arrays.asList("Praise God", "Flashing Lights", "Off the Grid", "Heartless")));
        map.put("taylor swift", new ArrayList<String>(
                Arrays.asList("Blank Space", "Look What You Made Me Do", "You Belong With Me", "Bad Blood")));
        map.put("ariana grande", new ArrayList<String>(
                Arrays.asList("Thank you next", "God Is a Woman", "Rain on Me", "Bang Bang")));
        map.put("justin bieber", new ArrayList<String>(
                Arrays.asList("Baby", "Holy", "STAY", "LONELY", "Love Yourself ", "Mood")));
        map.put("adele", new ArrayList<String>(
                Arrays.asList("Easy on Me", "Rolling in the Deep", "Someone Like You", "Send My Love", "Set Fire to the Rain")));
        map.put("mariah carey", new ArrayList<String>(
                Arrays.asList("All I want for Christmas is You", "We Belong Together", "Without You", "Always be My Baby", "Obsessed")));
        map.put("madonna", new ArrayList<String>(
                Arrays.asList("Hung up", "Frozen ", "Hung up", "The Power of Goodbye")));
        EditText artist = (EditText) findViewById(R.id.editTextTextPersonName2);
        EditText artist1 = (EditText) findViewById(R.id.editTextTextPersonName);
        Log.d("artist", artist.getText().toString());
        ArrayList<String> songs1 = null;
        ArrayList<String> songs2 = null;

        if(map.containsKey(artist.getText().toString().toLowerCase().trim())&& map.containsKey(artist1.getText().toString().toLowerCase().trim())) {
            songs1 = map.get(artist.getText().toString().toLowerCase().trim());
            songs2 = map.get(artist1.getText().toString().toLowerCase().trim());
            String artomg = "";
            String artomg2 = "";
            for(String key : map.keySet())
            {
                if (key.toLowerCase().trim().compareToIgnoreCase( artist.getText().toString().toLowerCase().trim()) == 0)
                {
                    artomg  = key;

                }

            }
            for(String key : map.keySet())
            {
                if (key.toLowerCase().trim().compareToIgnoreCase( artist1.getText().toString().toLowerCase().trim()) == 0)
                {
                    artomg2  = key;

                }
            }

            ArrayList<String> result = new ArrayList<String>();
            int bound = Math.min(songs1.size(), songs2.size());
            for (int i = 0; i < bound; i++) {



                if (i%2 == 1) //odd
                {
                    result.add(songs1.get(i) + " | " + artist.getText().toString().toLowerCase());
                }
                else
                {
                    result.add(songs2.get(i) + " | " + artist1.getText().toString().toLowerCase());


                }
            }
            Log.d("Tag", result.toString());

            String mood = getIntent().getStringExtra("MOOD");
            String wow = result.toString();
            Bundle passMashed = new Bundle();
            Intent passToNewPage = new Intent(view.getContext(), PlaylistGenerated.class);
            passToNewPage.putExtra("MOOD", mood);
            passToNewPage.putExtra("LIST", result);
            passToNewPage.putExtra("ARTIST1", artist.getText().toString().toLowerCase());
            passToNewPage.putExtra("ARTIST2", artist1.getText().toString().toLowerCase());
            startActivity(passToNewPage);
            }
        }
        else
        {
            new AlertDialog.Builder(this)
                    .setTitle("Error: Artist(s) not found")
                    .setMessage("Masher does not have data for one or more of the artists you entered. \n" +
                            "Try using the default ones!")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        //idk maybe we autopopultate?
                        }
                    })
                    .setNegativeButton(android.R.string.no, null)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }
    public void checkBoxFunction(View view) {
        boolean mood = true;
        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox);
        mood = cb1.isChecked() ? false: true;
        updateCurrentMoodString(mood);


    }}
