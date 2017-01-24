package com.example.uplift.consentisrad;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class StoryDetailActivity extends AppCompatActivity {

    private boolean loveSent;
    private boolean favorited;
    private ContentWarningDialog cdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loveSent = false;
        favorited = false;
    }

    public void sendLove(View v) {
        if (!loveSent) {
            Snackbar.make(v, "Thank you for sending love and support.", Snackbar.LENGTH_LONG).show();
            FloatingActionButton fabLove = (FloatingActionButton) findViewById(R.id.fabLove);
            int res = getResources().getIdentifier("ic_love_sent", "drawable", getPackageName());
            fabLove.setImageResource(res);
            loveSent = true;
        }
    }

    public void favStory(View v) {
        if (!favorited) {
            Snackbar.make(v, "This story is now in your favorites.", Snackbar.LENGTH_LONG).show();
            FloatingActionButton fabLove = (FloatingActionButton) findViewById(R.id.fabLove);
            int res = getResources().getIdentifier("ic_story_faved", "drawable", getPackageName());

            ImageView iv = (ImageView) findViewById(R.id.star);
            iv.setImageResource(res);

            favorited = true;
        }
    }

    public void addCW(View v) {
        cdd=new ContentWarningDialog(StoryDetailActivity.this);
        cdd.show();
    }

    public void submitText(View v) {
        cdd.createLabel();
    }

}
