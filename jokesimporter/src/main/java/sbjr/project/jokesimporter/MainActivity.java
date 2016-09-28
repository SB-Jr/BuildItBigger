package sbjr.project.jokesimporter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mJokeText;
    private ProgressBar mProgressJokeFetch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_library);
        mJokeText = (TextView) findViewById(R.id.text_joke);
        mProgressJokeFetch = (ProgressBar) findViewById(R.id.progress_fetch_joke);
        mProgressJokeFetch.setVisibility(View.INVISIBLE);
    }


    public void fetchJokeButtonClick(View v){
        JokeFetcher jokeFetcher = new JokeFetcher();
        mProgressJokeFetch.setVisibility(View.VISIBLE);
        jokeFetcher.execute(getApplicationContext(),mJokeText,mProgressJokeFetch);
    }
}
