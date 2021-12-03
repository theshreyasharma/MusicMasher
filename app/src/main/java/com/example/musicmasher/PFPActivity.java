package com.example.musicmasher;

import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PFPActivity extends AppCompatActivity {
    ListView lv;
    String[] recap_list = {
                            "Kanye West x Drake | Confident",
                            "Perturbator x Carpenter Brut | Powerful",
                            "Deafheaven x Lantlos | Sad",
                            "Acryl Madness x HEALTH | Focused"
                          };
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pfp);
        //get mood string
        Intent intent = getIntent();
        String mood = "None";
        if(getIntent().getExtras() != null) {
            mood = intent.getStringExtra("MOOD");
        }

        //get username string
        String username = "User";
        if(getIntent().getExtras() != null) {
            username = intent.getStringExtra("USERNAME");
        }
        TextView usernameView = findViewById(R.id.username);
        usernameView.setText(username);


        //set current Mood text
        TextView currentMood = findViewById(R.id.current_mood);
        if (mood == null) {
            currentMood.setText("Current  Mood: None");
        } else {
            currentMood.setText("Current  Mood: " + mood);
        }
        //populate recap list w/ hardcoded data
        lv = findViewById(R.id.recap_list);
        ArrayAdapter<String> lv_arr;
        lv_arr = new ArrayAdapter<>(
                    this,
                           R.layout.support_simple_spinner_dropdown_item,
                           recap_list);
        lv.setAdapter(lv_arr);
        //link mash, mood, listening history buttons to activities
        Button moodButton = findViewById(R.id.mood_button);
        Button mashButton = findViewById(R.id.mash_button);
        String finalMood = mood;
        String user = username;
        moodButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MoodFinder.class);
                intent.putExtra("MOOD", finalMood);
                intent.putExtra("USERNAME", user);
                startActivity(intent);
            }
        });

//        String finalMood = mood;
        mashButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Mash.class);
                intent.putExtra("MOOD", finalMood);
                intent.putExtra("USERNAME", user);
                startActivity(intent);
            }
        });

        Button listeningHistory = findViewById(R.id.listening_history);
        listeningHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ListeningHistory.class);
                intent.putExtra("MOOD", finalMood);
                intent.putExtra("USERNAME", user);
                startActivity(intent);
            }
        });

    }
    public void signOut(View view) {
        startActivity(new Intent(getApplicationContext(), Login.class));
    }

}
