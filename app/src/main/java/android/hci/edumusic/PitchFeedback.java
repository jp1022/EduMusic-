package android.hci.edumusic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
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
    EduMusicDB db;
    int levelId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pitch_feedback);


        feedbackTxt = (TextView) findViewById(R.id.feedback_text);
        db = new EduMusicDB(this);

        Typeface tf = Typeface.createFromAsset(getAssets(), "simple_girl.ttf");

        feedbackTxt.setTextSize(48);
        feedbackTxt.setTextColor(Color.DKGRAY);
        feedbackTxt.setTypeface(tf, Typeface.BOLD);

        TextView levelOne = (TextView) findViewById(R.id.to_main);
        TextView levelTwo = (TextView) findViewById(R.id.pitch_lvl);

        levelOne.setTextSize(15);
        levelOne.setTypeface(tf, Typeface.BOLD);
        levelTwo.setTextSize(15);
        levelTwo.setTypeface(tf, Typeface.BOLD);



        Bundle b = getIntent().getExtras();
        levelId = b.getInt("Level");
        correct = b.getBoolean("Result");
        if(correct){

            feedbackTxt.setText("Correct!");
            db.setStars("P" + levelId, 3);
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
