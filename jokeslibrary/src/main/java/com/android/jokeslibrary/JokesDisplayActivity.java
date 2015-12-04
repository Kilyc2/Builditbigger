package com.android.jokeslibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokesDisplayActivity extends AppCompatActivity {

    public final static String KEY_JOKE = "JOKE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jokes_display);
        TextView textJoke = (TextView) findViewById(R.id.joke);
        textJoke.setText(getIntent().getExtras().getString(KEY_JOKE));
    }
}
