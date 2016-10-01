package com.udacity.gradle.builditbigger;

import android.os.AsyncTask;
import android.view.View;
import android.widget.ProgressBar;

import com.example.sbjr.myapplication.jokesbackend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

/**
 * Created by sbjr on 9/27/16.
 */

public class JokeFetcher extends AsyncTask<Void, Void, String> {

    private static MyApi apiService = null;
    private ProgressBar mProgress;
    private AsyncTaskCompleteListener mListener;

    public JokeFetcher(ProgressBar progressBar,AsyncTaskCompleteListener listener) {
        mProgress = progressBar;
        mListener = listener;
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
        mListener.taskComplete(s);
        super.onPostExecute(s);
    }
}
