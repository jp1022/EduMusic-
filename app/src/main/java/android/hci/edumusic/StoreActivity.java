package android.hci.edumusic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by ian on 11/17/2014.
 */
public class StoreActivity extends Activity{

    EduMusicDB db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);



        Typeface title = Typeface.createFromAsset(getAssets(), "games.ttf");

        TextView titleText = (TextView) findViewById(R.id.instr_title);

        titleText.setTextSize(55);
        titleText.setTextColor(Color.DKGRAY);
        titleText.setTypeface(title, Typeface.BOLD);

        Typeface tf = Typeface.createFromAsset(getAssets(), "simple_girl.ttf");

        TextView drumButton = (TextView) findViewById(R.id.inst_tuba);
        TextView pianoButton = (TextView) findViewById(R.id.inst_cymbal);
        TextView myInstrumentsButton = (TextView) findViewById(R.id.my_inst);
        TextView eggButton = (TextView) findViewById(R.id.go_store);
        TextView guitarButton = (TextView) findViewById(R.id.buy_guitar);
        TextView kazooButton = (TextView) findViewById(R.id.inst_banjo);
        TextView tromboneButton = (TextView) findViewById(R.id.buy_trombone);
        TextView backButton = (TextView) findViewById(R.id.back);
        backButton.setTextSize(15);
        backButton.setTypeface(tf, Typeface.BOLD);


        drumButton.setTextSize(20);
        drumButton.setTypeface(tf, Typeface.BOLD);
        pianoButton.setTextSize(20);
        pianoButton.setTypeface(tf, Typeface.BOLD);
        myInstrumentsButton.setTextSize(15);
        myInstrumentsButton.setTypeface(tf, Typeface.BOLD);
        eggButton.setTextSize(20);
        eggButton.setTypeface(tf, Typeface.BOLD);
        guitarButton.setTextSize(20);
        guitarButton.setTypeface(tf, Typeface.BOLD);
        kazooButton.setTextSize(20);
        kazooButton.setTypeface(tf, Typeface.BOLD);
        tromboneButton.setTextSize(20);
        tromboneButton.setTypeface(tf, Typeface.BOLD);

        Button _p4 = (Button) findViewById(R.id.go_store);
        _p4.setAlpha(.1f);
        _p4.setClickable(false);
        Button _p5= (Button) findViewById(R.id.buy_trombone);
        _p5.setAlpha(.1f);
        _p5.setClickable(false);
        Button _p6 = (Button) findViewById(R.id.buy_guitar);
        _p6.setAlpha(.1f);
        _p6.setClickable(false);


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

    public boolean goDrum(View v){
        try{
            Intent k = new Intent(StoreActivity.this, DrumActivity.class);
            startActivity(k);
        } catch(Exception e){
            //TODO ACTUALLY DO SOMETHING
        }
        return true;
    }

    public boolean goPiano(View v){
        try{
            Intent k = new Intent(StoreActivity.this, PianoActivity.class);
            startActivity(k);
        } catch(Exception e){
            //TODO ACTUALLY DO SOMETHING
        }
        return true;
    }

    public boolean goKazoo(View v){
        try{
            Intent k = new Intent(StoreActivity.this, KazooActivity.class);
            startActivity(k);
        } catch(Exception e){
            //TODO ACTUALLY DO SOMETHING
        }
        return true;
    }

    public boolean goInstrument(View v){
        try{
            Intent k = new Intent(StoreActivity.this, InstruActivity.class);
            startActivity(k);
        } catch(Exception e){
            //TODO ACTUALLY DO SOMETHING
        }
        return true;
    }

    public boolean disabled(View v){
        try{
            Intent k = new Intent(StoreActivity.this, DisabledActivity.class);
            startActivity(k);
        } catch(Exception e){
            //TODO ACTUALLY DO SOMETHING
        }
        return true;
    }

    public void toMain(View v){
        Intent k = new Intent(StoreActivity.this, MainActivity.class);
        startActivity(k);
    }
}
