package com.awdroid.articleuitesting.ui;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.awdroid.articleuitesting.R;
import com.awdroid.articleuitesting.ui.adapter.ArticleAdapter;

import util.ArticleListFactory;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpList();
    }

    private void setUpList() {
        recyclerView = (RecyclerView) findViewById(R.id.articles_list);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(buildItemDecoration());
    }

    private RecyclerView.ItemDecoration buildItemDecoration() {
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);
        dividerItemDecoration.setDrawable(ContextCompat.getDrawable(this,
                R.drawable.articles_list_divider));
        return dividerItemDecoration;
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArticleAdapter adapter = new ArticleAdapter(this, ArticleListFactory.buildArticleList());
        recyclerView.setAdapter(adapter);
    }
}
