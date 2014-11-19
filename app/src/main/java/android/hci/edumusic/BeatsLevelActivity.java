package android.hci.edumusic;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by ian on 11/19/2014.
 */
public class BeatsLevelActivity extends Activity {
    int levelId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beatslevel);
        Bundle b = getIntent().getExtras();
        levelId = b.getInt("Level");
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
            MediaPlayer mp;
            switch(levelId){
                case 1:
                    //Level 1
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.beatsone);
                    mp.start();
                break;
                case 2:
                    //Level 2
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.beatstwo);
                    mp.start();
                break;
                case 3:
                    //Level 3
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.beatsthree);
                    mp.start();
                break;
            }
        } catch(Exception e){
            //TODO ACTUALLY DO SOMETHING
        }
        return true;
    }
}
