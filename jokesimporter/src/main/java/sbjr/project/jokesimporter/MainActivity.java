package sbjr.project.jokesimporter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
        Intent intent = getIntent();
        String joke = intent.getStringExtra("Joke");
        mJokeText.setText(joke);
    }
}
