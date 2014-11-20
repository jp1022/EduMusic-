package android.hci.edumusic;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

/**
 * Created by mshon on 11/20/14.
 */
public class PitchLevelActivity extends Activity {

    Button one = (Button) findViewById(R.id.choice_one);
    Button two = (Button) findViewById(R.id.choice_two);
    int levelId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitchlevel);
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

    public boolean playPitch(View v){
        try{
            MediaPlayer mp;
            switch(levelId){
                case 1:
                    //Level 1
//                    mp = MediaPlayer.create(getApplicationContext(), R.raw.beatsone);
//                    mp.start();
                    break;
                case 2:
                    //Level 2
//                    mp = MediaPlayer.create(getApplicationContext(), R.raw.beatstwo);
//                    mp.start();
                    break;
                case 3:
                    //Level 3
//                    mp = MediaPlayer.create(getApplicationContext(), R.raw.beatsthree);
//                    mp.start();
                    break;
            }
        } catch(Exception e){
            //TODO ACTUALLY DO SOMETHING
        }
        return true;
    }

    public boolean buttonOne(View v){

        switch(levelId){
            case 1:
                return true;
            case 2:
                return false;
            case 3:
                return true;
        }
        return false;
    }

    public boolean buttonTwo(View v){
        switch(levelId){
            case 1:
                return false;
            case 2:
                return true;
            case 3:
                return false;
        }
        return false;
    }
}
