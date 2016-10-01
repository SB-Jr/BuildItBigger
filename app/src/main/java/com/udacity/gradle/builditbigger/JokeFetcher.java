package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sbjr.myapplication.jokesbackend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import java.io.IOException;

/**
 * Created by sbjr on 9/27/16.
 */

public class JokeFetcher extends AsyncTask<Void, Void, String> {

    private static MyApi apiService = null;
    private ProgressBar mProgress;
    private Context mContext;
    private Intent mIntent;

    public JokeFetcher(Context context,Intent intent,ProgressBar progressBar) {
        mProgress = progressBar;
        mContext = context;
        mIntent = intent;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        if(mProgress!=null) {
            mProgress.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected String doInBackground(Void... params) {

        if(apiService==null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://builitbigger-nd.appspot.com/_ah/api/")
                    .setApplicationName("JokesTeller");

            apiService = builder.build();
        }

        try{
            return apiService.sayHi().execute().getData();
        }
        catch (Exception e){
            return e.getMessage();
        }

    }

    @Override
    protected void onPostExecute(String s) {
        if(mProgress!=null) {
            mProgress.setVisibility(View.INVISIBLE);
        }
        if(mIntent!=null) {
            mIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            mIntent.putExtra("Joke",s);
            mContext.startActivity(mIntent);
        }
        super.onPostExecute(s);
    }
}
