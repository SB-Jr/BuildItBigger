package sbjr.project.jokesimporter;

import android.content.Context;
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

public class JokeFetcher extends AsyncTask<Object, Void, String> {

    private static MyApi apiService = null;
    private Context context;
    private TextView mJokeText;
    private ProgressBar mProgress;

    @Override
    protected String doInBackground(Object... params) {

        if(params.length==3) {
            context = (Context) params[0];
            mJokeText = (TextView) params[1];
            mProgress = (ProgressBar) params[2];
        }
        if(apiService==null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("http://10.0.3.2:8080/_ah/api/")
                    .setApplicationName("JokesTeller")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> request) throws IOException {
                            request.setDisableGZipContent(true);
                        }
                    });

            apiService = builder.build();
        }


        try{
            return apiService.sayHi("sbjr").execute().getData();
        }
        catch (Exception e){
            return e.getMessage();
        }

    }

    @Override
    protected void onPostExecute(String s) {
        if(mProgress!=null&&mJokeText!=null) {
            mProgress.setVisibility(View.INVISIBLE);
            mJokeText.setText(s);
        }
        super.onPostExecute(s);
    }
}
