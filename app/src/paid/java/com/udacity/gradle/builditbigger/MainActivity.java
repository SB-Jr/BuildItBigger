package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import android.widget.ProgressBar;


public class MainActivity extends ActionBarActivity implements AsyncTaskCompleteListener{

    private ProgressBar mProgressJokeFetch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mProgressJokeFetch = (ProgressBar) findViewById(R.id.progress_joke);
        mProgressJokeFetch.setVisibility(View.INVISIBLE);
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

    public void tellJoke(View view){
        //Toast.makeText(this, "derp", Toast.LENGTH_SHORT).show();
        JokeFetcher jokeFetcher = new JokeFetcher(mProgressJokeFetch,this);
        jokeFetcher.execute();
    }


    @Override
    public void taskComplete(String s) {
        Intent intent = new Intent(getApplicationContext(), sbjr.project.jokesimporter.MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("Joke",s);
        startActivity(intent);
    }

}
