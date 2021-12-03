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
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import java.util.TreeMap;

public class Mash extends AppCompatActivity {
    boolean mood = false;

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
        String message = "Current Mood: "+ currentMood;
        TextView currentMood2 = (TextView) findViewById(R.id.textView3);
        if (mood)
        {
            currentMood2.setText(message);
        }
        else {
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
        intent.putExtra("USERNAME", getIntent().getStringExtra("USERNAME"));
        startActivity(intent);
    }
    public void mashMe(View view) {
        Map<String, ArrayList<Pair<String, String>>> map =new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
        String currentmood = "";
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

        map.put("Mac Miller", new ArrayList<>(
                Arrays.asList(
                        new Pair<>("The Spins", "upbeat"),
                        new Pair<>("Self Care", "confident"),
                        new Pair<>("Weekend", "upbeat"),
                        new Pair<>("Ladders", "angry"),
                        new Pair<>("Come Back to Earth", "sad"),
                        new Pair<>("Jet Fuel", "angry"),
                        new Pair<>("So It Goes", "sad"))
        ));

        map.put("Rihanna", new ArrayList<>(
                Arrays.asList(
                        new Pair<>("Love On The Brain", "angry"),
                        new Pair<>("Umbrella", "upbeat"),
                        new Pair<>("Needed Me", "angry"),
                        new Pair<>("FourFiveSeconds", "sad"),
                        new Pair<>("Work", "angry"),
                        new Pair<>("Stay", "sad"),
                        new Pair<>("Pon De Replay", "confident"))
        ));

        map.put("Harry Styles", new ArrayList<>(
                Arrays.asList(
                        new Pair<>("Fine Line", "confident"),
                        new Pair<>("Watermelon Sugar", "upbeat"),
                        new Pair<>("Falling", "sad"),
                        new Pair<>("Golden", "confident"),
                        new Pair<>("Sign of the Times", "sad"),
                        new Pair<>("Adore You", "confident"),
                        new Pair<>("Sweet Creature", "upbeat"),
                        new Pair<>("She", "angry"),
                        new Pair<>("Two Ghosts", "sad"))
        ));

        map.put("Doja Cat", new ArrayList<>(
                Arrays.asList(
                        new Pair<>("Woman", "upbeat"),
                        new Pair<>("Need to Know", "angry"),
                        new Pair<>("Kiss Me More", "upbeat"),
                        new Pair<>("Get Into It (Yuh)", "confident"),
                        new Pair<>("You Right", "sad"),
                        new Pair<>("Ain't Shit", "angry"),
                        new Pair<>("Say So", "angry"),
                        new Pair<>("SCOOP", "upbeat"),
                        new Pair<>("Best Friend", "confident")
                )));
        map.put("Ed Sheeran", new ArrayList<>(
                Arrays.asList(
                        new Pair<>("Perfect", "confident"),
                        new Pair<>("Shape of You", "upbeat"),
                        new Pair<>("Photograph", "sad"),
                        new Pair<>("Thinking Out Loud", "sad"),
                        new Pair<>("A Team", "sad"),
                        new Pair<>("I See Fire", "angry"),
                        new Pair<>("Kiss Me", "confident"),
                        new Pair<>("I'm a Mess", "sad"),
                        new Pair<>("Castle on the Hill", "upbeat"))
        ));

        map.put("J. Cole", new ArrayList<>(
                Arrays.asList(
                        new Pair<>("No Role Modelz", "angry"),
                        new Pair<>("She Knows", "angry"),
                        new Pair<>("Work Out", "upbeat"),
                        new Pair<>("MIDDLE CHILD", "confident"),
                        new Pair<>("Wet Dreamz", "confident"),
                        new Pair<>("KOD", "upbeat"),
                        new Pair<>("Neighbors", "angry"),
                        new Pair<>("Power Trip", "upbeat"),
                        new Pair<>("Kevin's Heart", "sad"),
                        new Pair<>("Photograph", "sad"))
        ));



        EditText artist = (EditText) findViewById(R.id.editTextTextPersonName2);
        EditText artist1 = (EditText) findViewById(R.id.editTextTextPersonName);
        Log.d("artist", artist.getText().toString());
        ArrayList<Pair<String, String>> songs1 = null;
        ArrayList<Pair<String, String>> songs2 = null;

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

            if (mood == true)
            {

                Bundle b=this.getIntent().getExtras();
                String currentMoodGODDAMN = b.getString("MOOD");
                Log.d("currentMoodinControl", currentMoodGODDAMN);
                Log.d("songs1", songs1.toString());
                Log.d("songs1", songs2.toString());
                ArrayList<String> result1 = new ArrayList<String>();
                ArrayList<String> result2 = new ArrayList<String>();


                for (int i = 0; i < songs1.size(); i++)
                {

                    if (songs1.get(i).second.compareToIgnoreCase( currentMoodGODDAMN.trim()) ==0)
                    {

                        result1.add(songs1.get(i).first);
                    }
                }

                for (int i = 0; i < songs2.size(); i++)
                {
                    if (songs2.get(i).second.compareToIgnoreCase( currentMoodGODDAMN) ==0)
                    {
                        result2.add(songs2.get(i).first);
                    }
                }

                int bound = Math.min(result1.size(), result2.size());

                for (int i = 0; i < bound; i++) {

                    if (i % 2 == 1) //odd
                    {
                        result.add(result1.get(i) + " | " + artomg);
                    } else {
                        result.add(result2.get(i) + " | " + artomg2);

                    }
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
                    passToNewPage.putExtra("USERNAME", getIntent().getStringExtra("USERNAME"));
                    startActivity(passToNewPage);
                }

            else
            {
                int bound = Math.min(songs1.size(), songs2.size());

                for (int i = 0; i < bound; i++) {


                    if (i % 2 == 1) //odd
                    {
                        result.add(songs1.get(i).first + " | " + artomg);
                    } else {
                        result.add(songs2.get(i).first + " | " + artomg2);


                    }
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
                passToNewPage.putExtra("USERNAME", getIntent().getStringExtra("USERNAME"));
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
        Switch cb1 = (Switch) findViewById(R.id.switch1);
        mood = cb1.isChecked() ? true: false;
        updateCurrentMoodString(mood);


    }}