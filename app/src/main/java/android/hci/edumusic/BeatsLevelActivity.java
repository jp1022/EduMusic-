package android.hci.edumusic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ian on 11/19/2014.
 */
public class BeatsLevelActivity extends Activity {
    int levelId;
    EduMusicDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beatslevel);

        Typeface tf = Typeface.createFromAsset(getAssets(), "simple_girl.ttf");

        TextView levelOne = (TextView) findViewById(R.id.startRhythm);

        levelOne.setTextSize(15);
        levelOne.setTypeface(tf, Typeface.BOLD);


        Bundle b = getIntent().getExtras();
        levelId = b.getInt("Level");

        db = new EduMusicDB(this);
        Button notesButton = (Button) findViewById(R.id.notes);
        notesButton.setTypeface(tf, Typeface.BOLD);
        notesButton.setText(""+db.getPts());
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

    public boolean playRhythm(View v){
        try{
            Intent k;
            Bundle b = new Bundle();
            MediaPlayer mp;
            switch(levelId){
                case 1:
                    //Level 1 audio
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.beatsone);
                    mp.start();
                    Thread.sleep(5000);
                    //Start tone
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.clapstart);
                    mp.start();
                    Thread.sleep(500);
                    mp.stop();
                    Thread.sleep(3500);

                    k = new Intent(BeatsLevelActivity.this, BeatsFeedback.class);
                    b.putInt("Level", 1); //Passing parameter of level to BeatsLevelActivity
                    k.putExtras(b);
                    startActivity(k);
                break;
                case 2:
                    //Level 2
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.beatstwo);
                    mp.start();
                    Thread.sleep(5250);
                    //Start tone
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.clapstart);
                    mp.start();
                    Thread.sleep(500);
                    mp.stop();
                    Thread.sleep(3500);

                    k = new Intent(BeatsLevelActivity.this, BeatsFeedback.class);
                    b.putInt("Level", 2); //Passing parameter of level to BeatsLevelActivity
                    k.putExtras(b);
                    startActivity(k);
                break;
                case 3:
                    //Level 3
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.beatsthree);
                    mp.start();
                    Thread.sleep(5000);
                    //Start tone
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.clapstart);
                    mp.start();
                    Thread.sleep(500);
                    mp.stop();
                    Thread.sleep(3500);

                    k = new Intent(BeatsLevelActivity.this, BeatsFeedback.class);
                    b.putInt("Level", 3); //Passing parameter of level to BeatsLevelActivity
                    k.putExtras(b);
                    startActivity(k);
                break;
            }
        } catch(Exception e){
            //TODO ACTUALLY DO SOMETHING
        }
        return true;
    }

}
