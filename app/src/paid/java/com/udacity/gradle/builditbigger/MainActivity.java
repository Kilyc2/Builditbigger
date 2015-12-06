package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.android.jokeslibrary.JokesDisplayActivity;


public class MainActivity extends ActionBarActivity {

    private ProgressBar spinner;
    private String joke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tellJoke(View view) {
        MainActivityFragment fragment = (MainActivityFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment);
        setSpinner(fragment.getSpinner());
        try {
            JokesAsyncTask jokeTask = new JokesAsyncTask(this);
            jokeTask.execute();
        } catch (Exception e) {
            sendJoke("Timed out!");
        }
    }

    protected void sendJoke(String joke) {
        this.joke = joke;
        goToActivityJoke();
    }

    private void goToActivityJoke() {
        Intent intent = new Intent(MainActivity.this, JokesDisplayActivity.class);
        intent.putExtra(JokesDisplayActivity.KEY_JOKE, this.joke);
        startActivity(intent);
    }

    private void setSpinner(ProgressBar spinner) {
        this.spinner = spinner;
    }

    public void setSpinnerVisible() {
        this.spinner.setVisibility(View.VISIBLE);
    }

    public void setSpinnerInvisible() {
        this.spinner.setVisibility(View.GONE);
    }
}
