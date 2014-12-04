package android.hci.edumusic;

import android.app.Activity;
import android.media.AudioFormat;
import android.media.AudioRecord;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * Created by John on 12/4/14.
 */

//Amplitude code taken from StackOverFlow
// http://stackoverflow.com/questions/4777060/android-sample-microphone-without-recording-to-get-live-amplitude-level
    
public class ClapActivity extends Activity {

    private AudioRecord ar = null;
    private int minSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clap);
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

    public boolean start(View v) {
        minSize= AudioRecord.getMinBufferSize(8000, AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT);
        ar = new AudioRecord(MediaRecorder.AudioSource.MIC, 8000,AudioFormat.CHANNEL_IN_MONO, AudioFormat.ENCODING_PCM_16BIT,minSize);
        ar.startRecording();

        System.out.println("Its on");
        int i = 0;
        while(i < 100){
            i++;
            if(getAmp() > 30000){
                System.out.println("Clap!");
                try {
                    Thread.sleep(150);
                } catch(Exception e){
                    //TODO ACTUALLY DO SOMETHING
                }
            }
        }
        return true;
    }

    public boolean stop(View v) {
        if (ar != null) {
            ar.stop();
        }

        System.out.println("Its off");
        return true;
    }

    public boolean getAmplitude(View V) {
        short[] buffer = new short[minSize];
        ar.read(buffer, 0, minSize);
        int max = 0;
        for (short s : buffer)
        {
            if (Math.abs(s) > max)
            {
                max = Math.abs(s);
            }
        }

        System.out.println(max);

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
