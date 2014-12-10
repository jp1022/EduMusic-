package android.hci.edumusic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class BeatsFeedback extends Activity {

    EduMusicDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beats_feedback);
        db = new EduMusicDB(this);
        Typeface tf = Typeface.createFromAsset(getAssets(), "simple_girl.ttf");

        TextView levelOne = (TextView) findViewById(R.id.to_main);
        TextView levelTwo = (TextView) findViewById(R.id.beat_lvl);
        Button notesButton = (Button) findViewById(R.id.notes);
        TextView feedbackTxt = (TextView) findViewById(R.id.feedback_text);

        levelOne.setTextSize(15);
        levelOne.setTypeface(tf, Typeface.BOLD);
        levelTwo.setTextSize(15);
        levelTwo.setTypeface(tf, Typeface.BOLD);
        notesButton.setTypeface(tf, Typeface.BOLD);
        notesButton.setText("" + db.getPts());
        feedbackTxt.setTextSize(48);
        feedbackTxt.setTextColor(Color.DKGRAY);
        feedbackTxt.setTypeface(tf, Typeface.BOLD);

        Bundle b = getIntent().getExtras();
        int levelId = b.getInt("Level");
        int claps = b.getInt("Claps");
        Log.d("Claps", "" + claps);
        if((levelId == 1 && claps == 3) || (levelId == 2 && claps == 6) || (levelId == 3 && claps == 6)){
            feedbackTxt.setText("Correct!");
            db.setStars("B" + levelId, 3);
        } else{
            feedbackTxt.setText("Incorrect!");
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.beats_feedback, menu);
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

    public void beatLevelSelect(View v){
        Intent k = new Intent(BeatsFeedback.this, BeatsActivity.class);
        startActivity(k);
    }

    public void mainMenu(View v){
        Intent k = new Intent(BeatsFeedback.this, MainActivity.class);
        startActivity(k);
    }
}
