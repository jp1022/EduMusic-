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
 * Created by John on 11/25/14.
 */
public class InstruActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruments);

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


        tubaButton.setTextSize(20);
        tubaButton.setTypeface(tf, Typeface.BOLD);
        cymbalButton.setTextSize(20);
        cymbalButton.setTypeface(tf, Typeface.BOLD);
        storeButton.setTextSize(20);
        storeButton.setTypeface(tf, Typeface.BOLD);
        banjoButton.setTextSize(20);
        banjoButton.setTypeface(tf, Typeface.BOLD);

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
}
