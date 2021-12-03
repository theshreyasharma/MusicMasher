package com.example.musicmasher;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListeningHistory extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listening_history);
        String[] artists = {
                "Week 1: Drake", "Week 2: Kanye West", "Week 3: Perturbator", "Week 4: Lantlos"
        };
//        String artists = "Week 1: Drake\nWeek 2: Kanye West\nWeek 3: Perturbator\nWeek 4: Lantlos";
        ListView lv = findViewById(R.id.list);
        ArrayAdapter<String> lv_arr;
        lv_arr = new ArrayAdapter<>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                artists);
        lv.setAdapter(lv_arr);


        String[] recap_list = {
                "Kanye West x Drake | Confident",
                "Perturbator x Carpenter Brut | Powerful",
                "Deafheaven x Lantlos | Sad",
                "Acryl Madness x HEALTH | Focused"
        };
        ListView lv1 = findViewById(R.id.play);
        ArrayAdapter<String> lv1_arr;
        lv1_arr = new ArrayAdapter<>(
                this,
                R.layout.support_simple_spinner_dropdown_item,
                recap_list);
        lv1.setAdapter(lv1_arr);

        Button profileButton = findViewById(R.id.profile2);
        profileButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), PFPActivity.class);
                intent.putExtra("MOOD", getIntent().getStringExtra("MOOD"));
                intent.putExtra("USERNAME", getIntent().getStringExtra("USERNAME"));
                startActivity(intent);
            }
        });
    }
}
