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
 * Created by John on 11/25/14.
 */
public class InstruActivity extends Activity {

    EduMusicDB db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruments);
        db = new EduMusicDB(this);


        Typeface title = Typeface.createFromAsset(getAssets(), "games.ttf");

        TextView titleText = (TextView) findViewById(R.id.instr_title);

        titleText.setTextSize(30);
        titleText.setTextColor(Color.DKGRAY);
        titleText.setTypeface(title, Typeface.BOLD);

        Typeface tf = Typeface.createFromAsset(getAssets(), "simple_girl.ttf");

        TextView tubaButton = (TextView) findViewById(R.id.inst_tuba);
        TextView cymbalButton = (TextView) findViewById(R.id.inst_cymbal);
        TextView storeButton = (TextView) findViewById(R.id.go_store);
        TextView banjoButton = (TextView) findViewById(R.id.inst_banjo);
        TextView backButton = (TextView) findViewById(R.id.back);
        backButton.setTextSize(15);
        backButton.setTypeface(tf, Typeface.BOLD);


        tubaButton.setTextSize(20);
        tubaButton.setTypeface(tf, Typeface.BOLD);
        cymbalButton.setTextSize(20);
        cymbalButton.setTypeface(tf, Typeface.BOLD);
        storeButton.setTextSize(20);
        storeButton.setTypeface(tf, Typeface.BOLD);
        banjoButton.setTextSize(20);
        banjoButton.setTypeface(tf, Typeface.BOLD);

        if(!db.getInstrument("DRUM")){
            tubaButton.setVisibility(View.INVISIBLE);
        }
        if(!db.getInstrument("KAZOO")){
            cymbalButton.setVisibility(View.INVISIBLE);
        }
        if(!db.getInstrument("PIANO")){
            banjoButton.setVisibility(View.INVISIBLE);
        }
//
//
//        Button _p4 = (Button) findViewById(R.id.inst_tuba);
//        _p4.setAlpha(.1f);
//        _p4.setClickable(false);
//        Button _p5= (Button) findViewById(R.id.inst_cymbal);
//        _p5.setAlpha(.1f);
//        _p5.setClickable(false);
//        Button _p6 = (Button) findViewById(R.id.inst_banjo);
//        _p6.setAlpha(.1f);
//        _p6.setClickable(false);

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

    public boolean goStore(View v){
        try{
            Intent k = new Intent(InstruActivity.this, StoreActivity.class);
            startActivity(k);
        } catch(Exception e){
            //TODO ACTUALLY DO SOMETHING
        }
        return true;
    }

    public boolean disabled(View v){
        try{
            Intent k = new Intent(InstruActivity.this, DisabledActivity.class);
            startActivity(k);
        } catch(Exception e){
            //TODO ACTUALLY DO SOMETHING
        }
        return true;
    }

    public void toMain(View v){
        Intent k = new Intent(InstruActivity.this, MainActivity.class);
        startActivity(k);
    }

    public boolean goDrum(View v){
        try{
            Intent k = new Intent(InstruActivity.this, DrumActivity.class);
            startActivity(k);
        } catch(Exception e){
            //TODO ACTUALLY DO SOMETHING
        }
        return true;
    }

    public boolean goPiano(View v){
        try{
            Intent k = new Intent(InstruActivity.this, PianoActivity.class);
            startActivity(k);
        } catch(Exception e){
            //TODO ACTUALLY DO SOMETHING
        }
        return true;
    }

    public boolean goKazoo(View v){
        try{
            Intent k = new Intent(InstruActivity.this, KazooActivity.class);
            startActivity(k);
        } catch(Exception e){
            //TODO ACTUALLY DO SOMETHING
        }
        return true;
    }
}
