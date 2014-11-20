package android.hci.edumusic;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.media.SoundPool.OnLoadCompleteListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


/**
 * Created by ian on 11/17/2014.
 */
public class PitchActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pitch);
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
            Intent k;
            Bundle b = new Bundle();
            switch(v.getId()){
                case R.id.pitchOne:
                    k = new Intent(PitchActivity.this, PitchLevelActivity.class);
                    b.putInt("Level", 1); //Passing parameter of level to BeatsLevelActivity
                    k.putExtras(b);
                    startActivity(k);
                    break;
                case R.id.pitchTwo:
                    k = new Intent(PitchActivity.this, PitchLevelActivity.class);
                    b.putInt("Level", 2); //Passing parameter of level to BeatsLevelActivity
                    k.putExtras(b);
                    startActivity(k);
                    break;
                case R.id.pitchThree:
                    k = new Intent(PitchActivity.this, PitchLevelActivity.class);
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



}
