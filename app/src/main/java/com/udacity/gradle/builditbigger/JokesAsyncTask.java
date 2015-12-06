package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;

import com.example.kilyc2.myapplication.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

public class JokesAsyncTask extends AsyncTask<Void, Void, String> {
    private MyApi myApiService = null;
    private MainActivity activity;

    public JokesAsyncTask() {
    }

    public JokesAsyncTask(MainActivity activity) {
        this.activity = activity;
    }

    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    .setRootUrl("https://builditbigger-1146.appspot.com/_ah/api/");
            myApiService = builder.build();
        }

        try {
            return myApiService.tellJoke().execute().getJoke();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if (this.activity != null) {
            this.activity.setSpinnerVisible();
        }
    }

    @Override
    protected void onPostExecute(String joke) {
        super.onPostExecute(joke);
        if (this.activity != null) {
            this.activity.setSpinnerInvisible();
            this.activity.sendJoke(joke);
        }
    }
}
