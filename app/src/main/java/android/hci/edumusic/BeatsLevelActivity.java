package android.hci.edumusic;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioRecord;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Bundle;
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
 * Created by ian on 11/19/2014.
 */
public class BeatsLevelActivity extends Activity {

    EduMusicDB db;
    int levelId;
    static int count = 0;
    //for audio
    static private AudioRecord ar = null;
    private int minSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beatslevel);
        db = new EduMusicDB(this);
        Typeface tf = Typeface.createFromAsset(getAssets(), "simple_girl.ttf");

        TextView levelOne = (TextView) findViewById(R.id.startRhythm);
        Button notesButton = (Button) findViewById(R.id.notes);
        TextView titleText = (TextView) findViewById(R.id.instruction);

        titleText.setTextSize(48);
        titleText.setTextColor(Color.DKGRAY);
        titleText.setTypeface(tf, Typeface.BOLD);
        titleText.setGravity(Gravity.CENTER);
        levelOne.setTextSize(15);
        levelOne.setTypeface(tf, Typeface.BOLD);
        notesButton.setTypeface(tf, Typeface.BOLD);
        notesButton.setText(""+db.getPts());

        Bundle b = getIntent().getExtras();
        levelId = b.getInt("Level");
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

    public boolean playRhythm(View v){
        Button beatsButton = (Button) findViewById(R.id.startRhythm);
        beatsButton.setAlpha(.1f);
        beatsButton.setClickable(false);
        minSize= AudioRecord.getMinBufferSize(8000, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);
        ar = new AudioRecord(MediaRecorder.AudioSource.MIC, 8000,AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT,minSize);
        ar.startRecording();
        try{
            MediaPlayer mp;
            switch(levelId){
                case 1:
                    //Level 1 audio
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.beatsone);
                    mp.start();
                break;
                case 2:
                    //Level 2
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.beatstwo);
                    mp.start();
                break;
                case 3:
                    //Level 3
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.beatsthree);
                    mp.start();
                break;
            }
        } catch(Exception e){
            //TODO ACTUALLY DO SOMETHING
        } finally {
            Timer t = new Timer();
            t.schedule(new TimerTask() {
                public void run() {
                    MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.clapstart);
                    mp.start();
                }
            }, 5500);
            for(int ct = 0; ct < 45; ct++) {
                t.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        int amp = getAmp();
                        if (amp > 15000) {
                            Log.d("Amp", "" + amp);
                            BeatsLevelActivity.count++;
                        }
                    }
                }, 5500 + 100 * ct);
            }
            t.schedule(new TimerTask() {
                public void run() {
                    Intent k = new Intent(BeatsLevelActivity.this, BeatsFeedback.class);
                    Bundle b = new Bundle();
                    b.putInt("Level", levelId);
                    b.putInt("Claps", BeatsLevelActivity.count);
                    k.putExtras(b);

                    BeatsLevelActivity.ar.release();
                    BeatsLevelActivity.count = 0;
                    startActivity(k);
                }
            }, 10000);
        }
        return true;
    }

    public int getAmp() {
        short[] buffer = new short[minSize];
        ar.read(buffer, 0, minSize);
        int max = 0;
        for (short s : buffer){
            if (Math.abs(s) > max){
                max = Math.abs(s);
            }
        }
        return max;
    }



}
