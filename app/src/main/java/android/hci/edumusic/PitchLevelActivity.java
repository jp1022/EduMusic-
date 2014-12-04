package android.hci.edumusic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * Created by mshon on 11/20/14.
 */
public class PitchLevelActivity extends Activity {

    TextView inst;

    int levelId;
    EduMusicDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitchlevel);

        Typeface tf = Typeface.createFromAsset(getAssets(), "simple_girl.ttf");

        TextView titleText = (TextView) findViewById(R.id.instruction);

        titleText.setTextSize(48);
        titleText.setTextColor(Color.DKGRAY);
        titleText.setTypeface(tf, Typeface.BOLD);
        titleText.setGravity(Gravity.CENTER);

        TextView levelOne = (TextView) findViewById(R.id.startPitch);
        TextView levelTwo = (TextView) findViewById(R.id.choice_one);
        TextView levelThree = (TextView) findViewById(R.id.choice_two);



        levelOne.setTextSize(15);
        levelOne.setTypeface(tf, Typeface.BOLD);
        levelTwo.setTextSize(15);
        levelTwo.setTypeface(tf, Typeface.BOLD);
        levelThree.setTextSize(15);
        levelThree.setTypeface(tf, Typeface.BOLD);


        Bundle b = getIntent().getExtras();
        levelId = b.getInt("Level");
        inst = (TextView) findViewById(R.id.instruction);
        // goals/questions for levels
        switch(levelId){
            case 1:
                inst.setText("Which is lower?");
                break;
            case 2:
                inst.setText("Which is higher?");
                break;
            case 3:
                inst.setText("Which is lower?");
                break;
        }
        db = new EduMusicDB(this);
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
                    mp = MediaPlayer.create(PitchLevelActivity.this, R.raw.piano_octave0mp);
                    mp.start();

                    Thread.sleep(2000);
                    //Start tone
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.piano_octave1mp);
                    mp.start();
                    Thread.sleep(2000);
                    mp.stop();

                    break;
                case 2:
                    //Level 2

                    mp = MediaPlayer.create(PitchLevelActivity.this, R.raw.guitar_octave3mp);
                    mp.start();
                    Thread.sleep(2000);
                    //Start tone
                    mp = MediaPlayer.create(PitchLevelActivity.this, R.raw.guitar_octave2mp);
                    mp.start();
                    Thread.sleep(2000);
                    mp.stop();

                    break;
                case 3:
                    //Level 3

                    mp = MediaPlayer.create(PitchLevelActivity.this, R.raw.femalevoice_aa_db4mp);
                    mp.start();
                    Thread.sleep(3000);
                    //Start tone
                    mp = MediaPlayer.create(PitchLevelActivity.this, R.raw.femalevoice_aa_a3mp);
                    mp.start();
                    Thread.sleep(3000);
                    mp.stop();

                    break;
            }
        } catch(Exception e){
            //TODO ACTUALLY DO SOMETHING
        }
        return true;
    }

    public boolean buttonOne(View v){

        Intent k;
        Bundle b = new Bundle();
        switch(levelId){
            case 1:
                // adding points since correct
                db.addPts(75);

                //correct answer!
                k = new Intent(PitchLevelActivity.this, PitchFeedback.class);
                b.putBoolean("Result",true);
                b.putInt("Level", 1);
                k.putExtras(b);
                startActivity(k);
                break;
            case 2:
                // adding points since correct
                db.addPts(75);

                //correct answer!
                k = new Intent(PitchLevelActivity.this, PitchFeedback.class);
                b.putBoolean("Result",true);
                b.putInt("Level", 1);
                k.putExtras(b);
                startActivity(k);
                break;
            case 3:
                // still give points for trying
                db.addPts(25);

                //incorrect answer!
                k = new Intent(PitchLevelActivity.this, PitchFeedback.class);
                b.putBoolean("Result",false);
                b.putInt("Level", 1);
                k.putExtras(b);
                startActivity(k);
                break;
        }
        return true;
    }

    public boolean buttonTwo(View v){

        Intent k;
        Bundle b = new Bundle();
        switch(levelId){
            case 1:
                // still give points for trying
                db.addPts(25);

                //incorrect answer!
                k = new Intent(PitchLevelActivity.this, PitchFeedback.class);
                b.putBoolean("Result",false);
                k.putExtras(b);
                startActivity(k);
                break;
            case 2:
                // still give points for trying
                db.addPts(25);

                //incorrect answer!
                k = new Intent(PitchLevelActivity.this, PitchFeedback.class);
                b.putBoolean("Result",false);
                k.putExtras(b);
                startActivity(k);
                break;
            case 3:

                // adding points since correct
                db.addPts(75);

                //correct answer!

                k = new Intent(PitchLevelActivity.this, PitchFeedback.class);
                b.putBoolean("Result",true);
                k.putExtras(b);
                startActivity(k);
                break;
        }
        return true;
    }
}
