package android.hci.edumusic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ian on 11/17/2014.
 */
public class BeatsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beats);

        Typeface title = Typeface.createFromAsset(getAssets(), "games.ttf");

        TextView titleText = (TextView) findViewById(R.id.beat_title);

        titleText.setTextSize(55);
        titleText.setTextColor(Color.DKGRAY);
        titleText.setTypeface(title, Typeface.BOLD);

        Typeface tf = Typeface.createFromAsset(getAssets(), "simple_girl.ttf");

        TextView levelOne = (TextView) findViewById(R.id.beatsOne);
        TextView levelTwo = (TextView) findViewById(R.id.beatsTwo);
        TextView levelThree = (TextView) findViewById(R.id.beatsThree);
        TextView levelFour = (TextView) findViewById(R.id.beatsFour);
        TextView levelFive = (TextView) findViewById(R.id.beatsFive);
        TextView levelSix = (TextView) findViewById(R.id.beatsSix);


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

    public boolean beatsLesson(View v){
        try{
            Intent k;
            Bundle b = new Bundle();
            switch(v.getId()){
                case R.id.beatsOne:
                    k = new Intent(BeatsActivity.this, BeatsLevelActivity.class);
                    b.putInt("Level", 1); //Passing parameter of level to BeatsLevelActivity
                    k.putExtras(b);
                    startActivity(k);
                break;
                case R.id.beatsTwo:
                    k = new Intent(BeatsActivity.this, BeatsLevelActivity.class);
                    b.putInt("Level", 2); //Passing parameter of level to BeatsLevelActivity
                    k.putExtras(b);
                    startActivity(k);
                break;
                case R.id.beatsThree:
                    k = new Intent(BeatsActivity.this, BeatsLevelActivity.class);
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

    public boolean disabled(View v){
        try{
            Intent k = new Intent(BeatsActivity.this, DisabledActivity.class);
            startActivity(k);
        } catch(Exception e){
            //TODO ACTUALLY DO SOMETHING
        }
        return true;
    }
}
