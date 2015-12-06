package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.android.jokeslibrary.JokesDisplayActivity;
import com.example.kilyc2.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class MainActivity extends ActionBarActivity {

    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        MainActivityFragment fragment = (MainActivityFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment);
        setSpinner(fragment.spinner);
        try {
            JokesAsyncTask jokeTask = new JokesAsyncTask(this);
            jokeTask.execute();
        } catch (Exception e) {
            sendJoke("Timed out!");
        }
    }

    protected void sendJoke(String joke) {
        Intent intent = new Intent(MainActivity.this, JokesDisplayActivity.class);
        intent.putExtra(JokesDisplayActivity.KEY_JOKE, joke);
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
