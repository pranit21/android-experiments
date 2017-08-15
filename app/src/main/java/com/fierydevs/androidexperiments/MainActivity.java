package com.fierydevs.androidexperiments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.fierydevs.androidexperiments.svgdemo.SvgDemoActivity;
import com.fierydevs.androidexperiments.verticaltextviewdemo.VerticalTextActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager layoutManager;
    private ArrayList<ExperimentsModel> models;
    private ExperimentsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        layoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);

        models = new ArrayList<>();
        getExperiments();

        adapter = new ExperimentsAdapter(this, models);
        adapter.setOnItemClickListener(new ExperimentsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                ExperimentsModel model = models.get(position);
                Class<?> destClass = model.getDestClass();

                Intent intent = new Intent(MainActivity.this, destClass);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
    }

    private void getExperiments() {
        models.add(new ExperimentsModel("VerticalTextView", "Vertical TextView Demo", "", VerticalTextActivity.class));
        models.add(new ExperimentsModel("SVGDemo", "SVG Demo", "", SvgDemoActivity.class));
    }

}
