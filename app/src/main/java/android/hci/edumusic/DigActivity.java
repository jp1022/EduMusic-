package android.hci.edumusic;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by John on 11/21/14.
 */
public class DigActivity extends Activity{

    EduMusicDB db;
    final Handler my_handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dig);
        db = new EduMusicDB(this);

        Typeface tf = Typeface.createFromAsset(getAssets(), "simple_girl.ttf");

        TextView titleText = (TextView) findViewById(R.id.textView);

        titleText.setTextSize(48);
        titleText.setTextColor(Color.DKGRAY);
        titleText.setTypeface(tf, Typeface.BOLD);
        titleText.setGravity(Gravity.CENTER);

        TextView digDescButton = (TextView) findViewById(R.id.dig_description);
        TextView purchaseButton = (TextView) findViewById(R.id.dig_transaction);

        digDescButton.setTextSize(15);
        digDescButton.setTypeface(tf, Typeface.BOLD);
        purchaseButton.setTextSize(15);
        purchaseButton.setTypeface(tf, Typeface.BOLD);

        if(db.getPts() < 300){
            purchaseButton.setAlpha(.1f);
            purchaseButton.setClickable(false);
        }

        if(db.getInstrument("DIG")){
            purchaseButton.setVisibility(View.INVISIBLE);
        }

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

    public void playDig(View v){
        MediaPlayer mp;
        mp = MediaPlayer.create(DigActivity.this, R.raw.didgeridoo);
        mp.start();
    }

    public void purchased(View v){
        db.purchaseInstrument("DIG");
        db.addPts(-300);
        MediaPlayer mp = MediaPlayer.create(DigActivity.this, R.raw.caching);
        mp.start();
        Timer t = new Timer();
        t.schedule(new TimerTask() {
            public void run() {
                my_refresh();
            }
        }, 1500);

    }

    private void my_refresh(){
        my_handler.post(refreshRunnable);
    }

    final Runnable refreshRunnable = new Runnable(){
        public void run(){
            recreate();
        }
    };
}
