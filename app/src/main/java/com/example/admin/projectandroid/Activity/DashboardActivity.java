package com.example.admin.projectandroid.Activity;

import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.admin.projectandroid.Adapter.dash_adapter;
import com.example.admin.projectandroid.R;


public class DashboardActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private StaggeredGridLayoutManager mStaggeredLayoutManager;
    private dash_adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.dash_toolbar);
        mRecyclerView = (RecyclerView) findViewById(R.id.list);
        mStaggeredLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStaggeredLayoutManager);
        mAdapter = new dash_adapter(this);
        mRecyclerView.setAdapter(mAdapter);
        mStaggeredLayoutManager.setSpanCount(2);
        mAdapter.setOnItemClickListener(onItemClickListener);
    }
    dash_adapter.OnItemClickListener onItemClickListener = new dash_adapter.OnItemClickListener() {
        @Override
        public void onItemClick(View v, int position) {
            Toast.makeText(DashboardActivity.this, "Clicked " + position, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(DashboardActivity.this, DetailActivity.class);
            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation(DashboardActivity.this, (View) findViewById(R.id.placeName) ,"detailTrans");
            startActivity(intent, options.toBundle());

        }
    };





}
