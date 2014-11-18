package android.hci.edumusic;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ian on 11/17/2014.
 */
public class EduMusicDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String LEVEL_TABLE_NAME = "levels";
    private static final String STORE_TABLE_NAME = "store";
    private static final String LEVEL_TABLE_CREATE =
            "CREATE TABLE " + LEVEL_TABLE_NAME + " (" +
            "LEVEL TEXT, STARS INT)";
    private static final String STORE_TABLE_CREATE =
            "CREATE TABLE " + STORE_TABLE_NAME + " (" +
            "INSTRUMENT TEXT, OWNED BOOLEAN)";

    EduMusicDB(Context c){
        super(c, "EduMusicDB", null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS " + LEVEL_TABLE_NAME);
        db.execSQL(LEVEL_TABLE_CREATE);
        db.execSQL("DROP TABLE IF EXISTS " + STORE_TABLE_NAME);
        db.execSQL(STORE_TABLE_CREATE);
        setUpLevels(db);
    }

    public void onUpgrade(SQLiteDatabase db, int a, int b){ //Borrowed from Ravi Tamada
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + LEVEL_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + STORE_TABLE_NAME);
        //Create Tables
        onCreate(db);
    }

    public void updateInstrument(String level, int stars){ //Adopted from Ravi Tamada
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE" + LEVEL_TABLE_NAME + "SET STARS = " + stars + " WHERE LEVEL = " + level);
        db.close();
    }

    public void purchaseInstrument(String name){ //Adopted from Ravi Tamada
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE" +  STORE_TABLE_NAME + "SET OWNED = TRUE WHERE INSTRUMENT = " + name);
        db.close();
    }

    public void setUpLevels(SQLiteDatabase db){
        ContentValues beats_one = new ContentValues();
        beats_one.put("LEVEL", "B1");
        beats_one.put("STARS", 0);
        ContentValues beats_two = new ContentValues();
        beats_one.put("LEVEL", "B2");
        beats_one.put("STARS", 0);
        ContentValues beats_three = new ContentValues();
        beats_one.put("LEVEL", "B3");
        beats_one.put("STARS", 0);
        ContentValues pitch_one = new ContentValues();
        beats_one.put("LEVEL", "P1");
        beats_one.put("STARS", 0);
        ContentValues pitch_two = new ContentValues();
        beats_one.put("LEVEL", "P2");
        beats_one.put("STARS", 0);
        ContentValues pitch_three = new ContentValues();
        beats_one.put("LEVEL", "P3");
        beats_one.put("STARS", 0);
        db.insert(LEVEL_TABLE_NAME, null, beats_one);
        db.insert(LEVEL_TABLE_NAME, null, beats_two);
        db.insert(LEVEL_TABLE_NAME, null, beats_three);
        db.insert(LEVEL_TABLE_NAME, null, pitch_one);
        db.insert(LEVEL_TABLE_NAME, null, pitch_two);
        db.insert(LEVEL_TABLE_NAME, null, pitch_three);
    }

    public void setUpStore(SQLiteDatabase db){
        ContentValues drums = new ContentValues();
        drums.put("INSTRUMENT", "DRUM");
        drums.put("OWNED", false);
        ContentValues piano = new ContentValues();
        piano.put("INSTRUMENT", "PIANO");
        piano.put("OWNED", false);
        ContentValues kazoo = new ContentValues();
        kazoo.put("INSTRUMENT", "KAZOO");
        kazoo.put("OWNED", false);
        db.insert(STORE_TABLE_NAME, null, drums);
        db.insert(STORE_TABLE_NAME, null, piano);
        db.insert(STORE_TABLE_NAME, null, kazoo);
    }
}
