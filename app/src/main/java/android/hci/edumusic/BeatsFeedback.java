package android.hci.edumusic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class BeatsFeedback extends Activity {

    EduMusicDB db;
    int levelId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beats_feedback);


        TextView levelOne = (TextView) findViewById(R.id.to_main);
        TextView levelTwo = (TextView) findViewById(R.id.beat_lvl);

        Typeface tf = Typeface.createFromAsset(getAssets(), "simple_girl.ttf");


        levelOne.setTextSize(15);
        levelOne.setTypeface(tf, Typeface.BOLD);
        levelTwo.setTextSize(15);
        levelTwo.setTypeface(tf, Typeface.BOLD);


        db = new EduMusicDB(this);

        Button notesButton = (Button) findViewById(R.id.notes);
        notesButton.setTypeface(tf, Typeface.BOLD);
        notesButton.setText(""+db.getPts());

        Bundle b = getIntent().getExtras();
        levelId = b.getInt("Level");
        db.setStars("B" + levelId, 3);

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
