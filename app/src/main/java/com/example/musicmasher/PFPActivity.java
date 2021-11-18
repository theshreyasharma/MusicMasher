package com.example.musicmasher;

import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.os.Bundle;
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
        lv = findViewById(R.id.recap_list);
        ArrayAdapter<String> lv_arr;
        lv_arr = new ArrayAdapter<>(
                    this,
                           R.layout.support_simple_spinner_dropdown_item,
                           recap_list);
        lv.setAdapter(lv_arr);
    }
}
