package android.hci.edumusic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by ian on 11/17/2014.
 */
public class PitchActivity extends Activity{

    EduMusicDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitch);

        Typeface title = Typeface.createFromAsset(getAssets(), "games.ttf");

        TextView titleText = (TextView) findViewById(R.id.pitch_title);

        titleText.setTextSize(55);
        titleText.setTextColor(Color.DKGRAY);
        titleText.setTypeface(title, Typeface.BOLD);

        Typeface tf = Typeface.createFromAsset(getAssets(), "simple_girl.ttf");

        TextView levelOne = (TextView) findViewById(R.id.pitchOne);
        TextView levelTwo = (TextView) findViewById(R.id.pitchTwo);
        TextView levelThree = (TextView) findViewById(R.id.pitchThree);
        TextView levelFour = (TextView) findViewById(R.id.button4);
        TextView levelFive = (TextView) findViewById(R.id.button5);
        TextView levelSix = (TextView) findViewById(R.id.button6);
        TextView backButton = (TextView) findViewById(R.id.back);
        backButton.setTextSize(15);
        backButton.setTypeface(tf, Typeface.BOLD);

        levelOne.setTextSize(20);
        levelOne.setTypeface(tf, Typeface.BOLD);
        levelTwo.setTextSize(20);
        levelTwo.setTypeface(tf, Typeface.BOLD);
        levelThree.setTextSize(20);
        levelThree.setTypeface(tf, Typeface.BOLD);
        levelFour.setTextSize(20);
        levelFour.setTypeface(tf, Typeface.BOLD);
        levelFive.setTextSize(20);
        levelFive.setTypeface(tf, Typeface.BOLD);
        levelSix.setTextSize(20);
        levelSix.setTypeface(tf, Typeface.BOLD);
        db = new EduMusicDB(this);
        if(db.getStars("P1") <= 0) { //Grey out 2
            Button _p2 = (Button) findViewById(R.id.pitchTwo);
            _p2.setAlpha(.1f);
            _p2.setClickable(false);
        } else {
            Button _p2 = (Button) findViewById(R.id.pitchTwo);
            _p2.setAlpha(1f);
            _p2.setClickable(true);
        }
        if(db.getStars("P2") <= 0) { //Grey out 3
            Button _p3 = (Button) findViewById(R.id.pitchThree);
            _p3.setAlpha(.1f);
            _p3.setClickable(false);
        } else {
            Button _p3 = (Button) findViewById(R.id.pitchThree);
            _p3.setAlpha(1f);
            _p3.setClickable(true);
        }

        Button _p4 = (Button) findViewById(R.id.button4);
        _p4.setAlpha(.1f);
        _p4.setClickable(false);
        Button _p5= (Button) findViewById(R.id.button5);
        _p5.setAlpha(.1f);
        _p5.setClickable(false);
        Button _p6 = (Button) findViewById(R.id.button6);
        _p6.setAlpha(.1f);
        _p6.setClickable(false);


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

    public boolean pitchLesson(View v){
        try{
            Intent i;
            Bundle b = new Bundle();
            switch(v.getId()){
                case R.id.pitchOne:
                    i = new Intent(PitchActivity.this, PitchLevelActivity.class);
                    b.putInt("Level", 1); //Passing parameter of level to PitchLevelActivity
                    i.putExtras(b);
                    startActivity(i);
                    break;
                case R.id.pitchTwo:
                    i = new Intent(PitchActivity.this, PitchLevelActivity.class);
                    b.putInt("Level", 2); //Passing parameter of level to PitchLevelActivity
                    i.putExtras(b);
                    startActivity(i);
                    break;
                case R.id.pitchThree:
                    i = new Intent(PitchActivity.this, PitchLevelActivity.class);
                    b.putInt("Level", 3); //Passing parameter of level to PitchLevelActivity
                    i.putExtras(b);
                    startActivity(i);
                    break;
            }
        } catch(Exception e){
            //TODO ACTUALLY DO SOMETHING
        }
        return true;
    }

    public boolean disabled(View v){
        try{
            Intent k = new Intent(PitchActivity.this, DisabledActivity.class);
            startActivity(k);
        } catch(Exception e){
            //TODO ACTUALLY DO SOMETHING
        }
        return true;
    }

    public void toMain(View v){
        Intent k = new Intent(PitchActivity.this, MainActivity.class);
        startActivity(k);
    }


}
