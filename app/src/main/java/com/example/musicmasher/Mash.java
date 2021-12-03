package com.example.musicmasher;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
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
import java.util.Map;
import java.util.Random;

import java.util.HashMap;
import java.util.TreeMap;

public class Mash extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mash2);
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
        Map<String, ArrayList<Pair<String, String>>> map = new TreeMap<String, ArrayList<Pair<String, String>>>(String.CASE_INSENSITIVE_ORDER);;

        /**
         * To whomever wants to help me add artists,
         * add their key as ALL lowercase please.
         */
        map.put("Drake", new ArrayList<Pair<String, String>> (
                Arrays.asList(new Pair<>("God's Plan", "upbeat"),
                        new Pair<>("Way 2 Sexy", "confident"),
                        new Pair<>("Toosie Slide", "upbeat"),
                        new Pair<>("Know Yourself", "sad"),
                        new Pair<>("One Dance", "upbeat"),
                        new Pair<>("Laugh Now Cry Later", "sad")
        )));
        map.put("Kanye West", new ArrayList<Pair<String, String>> (
                Arrays.asList(new Pair<>("Praise God", "upbeat"),
                        new Pair<>("Flashing Lights", "confident"),
                        new Pair<>("Jesus Walks", "upbeat"),
                        new Pair<>("Off the Grid", "sad"),
                        new Pair<>("Heartless", "angry")
        )));
        map.put("Taylor Swift", new ArrayList<Pair<String, String>> (
                Arrays.asList(
                    new Pair<>("Blank Space", "confident"),
                    new Pair<>("Look What You Made Me Do", "upbeat"),
                    new Pair<>("You Belong With Me", "upbeat"),
                    new Pair<>("Bad Blood", "angry")
        )));
        map.put("Ariana Grande", new ArrayList<Pair<String, String>> (
                Arrays.asList(
                        new Pair<>("Thank you next", "confident"),
                        new Pair<>("God Is a Woman", "upbeat"),
                        new Pair<>("Rain on Me", "sad"),
                        new Pair<>("Bang Bang", "confident")
        )));
        map.put("Justin Bieber", new ArrayList<Pair<String, String>> (
                Arrays.asList(
                        new Pair<>("Baby", "confident"),
                        new Pair<>("Holy", "upbeat"),
                        new Pair<>("STAY", "sad"),
                        new Pair<>("Love Yourself ", "upbeat"),
                        new Pair<>("LONELY", "sad"),
                        new Pair<>("Mood", "angry")
        )));
        map.put("Adele", new ArrayList<Pair<String, String>> (
                Arrays.asList(
                        new Pair<>("Easy on Me", "confident"),
                        new Pair<>("Rolling in the Deep", "angry"),
                        new Pair<>("Someone Like You", "sad"),
                        new Pair<>("Send My Love", "upbeat"),
                        new Pair<>("Set Fire to the Rain", "sad")
        )));
        map.put("Mariah Carey", new ArrayList<Pair<String, String>> (
                Arrays.asList(
                        new Pair<>("All I want for Christmas is You", "upbeat"),
                        new Pair<>("We Belong Together", "confident"),
                        new Pair<>("Without You", "sad"),
                        new Pair<>("Always be My Baby", "upbeat"),
                        new Pair<>( "Obsessed", "angry")
        )));
        map.put("Madonna", new ArrayList<Pair<String, String>> (
                Arrays.asList(
                        new Pair<>("Like A Virgin", "upbeat"),
                        new Pair<>("Frozen" , "sad"),
                        new Pair<>("Hung up", "angry"),
                        new Pair<>("The Power of Goodbye", "confident")
        )));
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
                    result.add(songs1.get(i) + " | " + artomg);
                }
                else
                {
                    result.add(songs2.get(i) + " | " + artomg2);


                }

            Log.d("Tag", result.toString());

            String mood = getIntent().getStringExtra("MOOD");
            String wow = result.toString();
            Bundle passMashed = new Bundle();
            Intent passToNewPage = new Intent(view.getContext(), PlaylistGenerated.class);
            passToNewPage.putExtra("MOOD", mood);
            passToNewPage.putExtra("LIST", result);
            passToNewPage.putExtra("ARTIST1", artomg);
            passToNewPage.putExtra("ARTIST2", artomg2);
            startActivity(passToNewPage);
            }
        }
        else
        {
            new AlertDialog.Builder(this)
                    .setTitle("Artist(s) not found!")
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
        Switch cb1 = (Switch) findViewById(R.id.switch1);
        mood = cb1.isChecked() ? false: true;
        updateCurrentMoodString(mood);


    }}
