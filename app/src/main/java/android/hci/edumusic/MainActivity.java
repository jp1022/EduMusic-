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


public class MainActivity extends Activity {

    EduMusicDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new EduMusicDB(this);


        Typeface tf = Typeface.createFromAsset(getAssets(), "simple_girl.ttf");

        TextView levelOne = (TextView) findViewById(R.id.beatsButton);
        TextView levelTwo = (TextView) findViewById(R.id.gigButton);
        TextView levelThree = (TextView) findViewById(R.id.pitchButton);
        TextView levelFour = (TextView) findViewById(R.id.storeButton);
        TextView levelFive = (TextView) findViewById(R.id.settingsButton);
        TextView levelSix = (TextView) findViewById(R.id.triviaButton);


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

        Button _p4 = (Button) findViewById(R.id.gigButton);
        _p4.setAlpha(.1f);
        _p4.setClickable(false);
        Button _p5= (Button) findViewById(R.id.triviaButton);
        _p5.setAlpha(.1f);
        _p5.setClickable(false);
        Button _p6 = (Button) findViewById(R.id.settingsButton);
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

    public boolean goBeats(View v){
        try{
            Intent k = new Intent(MainActivity.this, BeatsActivity.class);
            startActivity(k);
        } catch(Exception e){
            //TODO ACTUALLY DO SOMETHING
        }
        return true;
    }

    public boolean goPitch(View v){
        try{
            Intent k = new Intent(MainActivity.this, PitchActivity.class);
            startActivity(k);
        } catch(Exception e){
            //TODO ACTUALLY DO SOMETHING
        }
        return true;
    }

    public boolean goStore(View v){
        try{
            Intent k = new Intent(MainActivity.this, StoreActivity.class);
            startActivity(k);
        } catch(Exception e){
            //TODO ACTUALLY DO SOMETHING
        }
        return true;
    }

    public boolean disabled(View v){
        try{
            Intent k = new Intent(MainActivity.this, DisabledActivity.class);
            startActivity(k);
        } catch(Exception e){
            //TODO ACTUALLY DO SOMETHING
        }
        return true;
    }

    public int getPts(){
        return db.getPts();
    }
}
