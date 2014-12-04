package android.hci.edumusic;

import android.app.Activity;
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
 * Created by John on 11/21/14.
 */
public class KazooActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kazoo);

        Typeface tf = Typeface.createFromAsset(getAssets(), "simple_girl.ttf");

        TextView titleText = (TextView) findViewById(R.id.textView);

        titleText.setTextSize(48);
        titleText.setTextColor(Color.DKGRAY);
        titleText.setTypeface(tf, Typeface.BOLD);
        titleText.setGravity(Gravity.CENTER);

        TextView drumDescButton = (TextView) findViewById(R.id.drum_description);
        TextView purchaseButton = (TextView) findViewById(R.id.kazoo_transaction);

        drumDescButton.setTextSize(15);
        drumDescButton.setTypeface(tf, Typeface.BOLD);
        purchaseButton.setTextSize(15);
        purchaseButton.setTypeface(tf, Typeface.BOLD);


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

    public void playKazoo(View v){
        MediaPlayer mp;
        mp = MediaPlayer.create(KazooActivity.this, R.raw.didgeridoo);
        mp.start();
    }
}
