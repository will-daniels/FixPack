package com.example.fixpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

public class InstructionActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private FragmentAdapter fAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction);

        viewPager = findViewById(R.id.pager);
        fAdapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager.setAdapter(fAdapter);
    }
}
