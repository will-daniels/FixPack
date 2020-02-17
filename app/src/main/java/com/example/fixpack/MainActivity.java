package com.example.fixpack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<RecyclerItem> mManualList;

    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private Button buttonInsert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Dynamic Gradient Background */
        ConstraintLayout constraintLayout = findViewById(R.id.layout);
        AnimationDrawable animationDrawable = (AnimationDrawable) constraintLayout.getBackground();
        animationDrawable.setEnterFadeDuration(200);
        animationDrawable.setExitFadeDuration(8000);
        animationDrawable.start();

        /* Build RecyclerView */
        createManualList();
        buildRecyclerView();
        setButtons();
    }

    public void insertItem(int position) {
        mManualList.add(position, new RecyclerItem("Some New Manual", "Manual No: NEW"));
        mAdapter.notifyItemInserted(position);
    }

    public void removeItem(int position) {
        mManualList.remove(position);
        mAdapter.notifyItemRemoved(position);
    }

    public void changeItem(int position, String text) {
        mManualList.get(position).changeText1(text);
        mAdapter.notifyItemChanged(position);
    }

    public void createManualList() {
        mManualList = new ArrayList<>();
        mManualList.add(new RecyclerItem("Some Manual 1", "Manual No: 001"));
        mManualList.add(new RecyclerItem("Some Manual 2", "Manual No: 002"));
        mManualList.add(new RecyclerItem("Some Manual 3", "Manual No: 003"));
        mManualList.add(new RecyclerItem("Some Manual 4", "Manual No: 004"));
        mManualList.add(new RecyclerItem("Some Manual 5", "Manual No: 005"));
    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RecyclerAdapter(mManualList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                changeItem(position, "Clicked");
            }

            @Override
            public void onDeleteClick(int position) {
                removeItem(position);
            }
        });
    }

    public void setButtons() {
        buttonInsert = findViewById(R.id.scan_to_start);

        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertItem(0);
            }
        });
    }
}
