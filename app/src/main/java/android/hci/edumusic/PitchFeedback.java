package android.hci.edumusic;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * Created by mshon on 11/20/14.
 */
public class PitchFeedback extends Activity {

    boolean correct;
    TextView feedbackTxt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pitch_feedback);
        feedbackTxt = (TextView) findViewById(R.id.feedback_text);
        Bundle b = getIntent().getExtras();
        correct = b.getBoolean("Result");
        if(correct){
            feedbackTxt.setText("Correct!");
        }else{
            feedbackTxt.setText("Incorrect!");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void pitchLevelSelect(View v){

        Intent k = new Intent(PitchFeedback.this, PitchActivity.class);
        startActivity(k);

    }

    public void mainMenu(View v){

        Intent k = new Intent(PitchFeedback.this, MainActivity.class);
        startActivity(k);

    }

}
