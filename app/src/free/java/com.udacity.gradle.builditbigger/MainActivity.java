package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.android.jokeslibrary.JokesDisplayActivity;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivity extends ActionBarActivity {

    private String joke;
    private InterstitialAd mInterstitialAd;
    private MainActivityFragment myFragment;
    private ProgressBar spinner;
    private Button buttonJoke;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myFragment = (MainActivityFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment);
        setButtonJoke(myFragment.getButtonJoke());
        mInterstitialAd = newInterstitialAd();
        loadInterstitial();
    }

    private InterstitialAd newInterstitialAd() {
        InterstitialAd interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getString(R.string.banner_ad_unit_id));
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                buttonJoke.setEnabled(true);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                buttonJoke.setEnabled(true);
            }

            @Override
            public void onAdClosed() {
                goToActivityJoke();
            }
        });
        return interstitialAd;
    }

    private void loadInterstitial() {
        buttonJoke.setEnabled(false);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("A1562FF4E1A4B9DE6F5B32A966F22C18").build();
        mInterstitialAd.loadAd(adRequest);
    }

    public void tellJoke(View view) {
        setSpinner(myFragment.getSpinner());
        try {
            JokesAsyncTask jokeTask = new JokesAsyncTask(this);
            jokeTask.execute();
        } catch (Exception e) {
            sendJoke("Timed out!");
        }
    }

    protected void sendJoke(String joke) {
        this.joke = joke;
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            goToActivityJoke();
        }
    }

    private void goToActivityJoke() {
        Intent intent = new Intent(MainActivity.this, JokesDisplayActivity.class);
        intent.putExtra(JokesDisplayActivity.KEY_JOKE, this.joke);
        startActivity(intent);
        loadInterstitial();
    }

    private void setButtonJoke(Button button) {
        this.buttonJoke = button;
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
