package android.hci.edumusic;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by ian on 11/17/2014.
 */
public class EduMusicDB extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String LEVEL_TABLE_NAME = "levels";
    private static final String STORE_TABLE_NAME = "store";
    private static final String POINTS_TABLE_NAME = "points";
    private static final String LEVEL_TABLE_CREATE =
            "CREATE TABLE " + LEVEL_TABLE_NAME + " (" +
                    "LEVEL TEXT, STARS INT)";
    private static final String STORE_TABLE_CREATE =
            "CREATE TABLE " + STORE_TABLE_NAME + " (" +
                    "INSTRUMENT TEXT, OWNED BOOLEAN, POINTS INT)";
    private static final String POINTS_TABLE_CREATE =
            "CREATE TABLE " + POINTS_TABLE_NAME + " (" +
                    "POINTS INT)";

    EduMusicDB(Context c){
        super(c, "EduMusicDB", null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db){
        db.execSQL("DROP TABLE IF EXISTS " + LEVEL_TABLE_NAME);
        db.execSQL(LEVEL_TABLE_CREATE);
        db.execSQL("DROP TABLE IF EXISTS " + STORE_TABLE_NAME);
        db.execSQL(STORE_TABLE_CREATE);
        db.execSQL("DROP TABLE IF EXISTS " + POINTS_TABLE_NAME);
        db.execSQL(POINTS_TABLE_CREATE);
        setUpLevels(db);
        setUpStore(db);
        setUpPts(db);
    }

    public void onUpgrade(SQLiteDatabase db, int a, int b){ //Borrowed from Ravi Tamada
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + LEVEL_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + STORE_TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + POINTS_TABLE_NAME);

        //Create Tables
        onCreate(db);
    }

    public void setUpLevels(SQLiteDatabase db){
        db.execSQL("INSERT INTO " + LEVEL_TABLE_NAME + " (LEVEL, STARS) VALUES(\'B1\', 0);");
        db.execSQL("INSERT INTO " + LEVEL_TABLE_NAME + " (LEVEL, STARS) VALUES(\'B2\', 0);");
        db.execSQL("INSERT INTO " + LEVEL_TABLE_NAME + " (LEVEL, STARS) VALUES(\'B3\', 0);");
        db.execSQL("INSERT INTO " + LEVEL_TABLE_NAME + " (LEVEL, STARS) VALUES(\'P1\', 0);");
        db.execSQL("INSERT INTO " + LEVEL_TABLE_NAME + " (LEVEL, STARS) VALUES(\'P2\', 0);");
        db.execSQL("INSERT INTO " + LEVEL_TABLE_NAME + " (LEVEL, STARS) VALUES(\'P3\', 0);");
        db.execSQL("COMMIT;");
    }

    public void setStars(String lvlName, int num){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " +  LEVEL_TABLE_NAME + " SET STARS=" + num + " WHERE LEVEL=\"" + lvlName + "\"");
    }

    public int getStars(String lvlName){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT LEVEL, STARS FROM " + LEVEL_TABLE_NAME, null);
        if(c.moveToFirst()){
            while(!c.isAfterLast()){
                Log.d(c.getString(0), lvlName);
                if(c.getString(0).equals(lvlName)){
                    Log.d("Stars", "" + c.getInt(1));
                    return c.getInt(1);
                } else {
                    c.moveToNext();
                }
            }
        }
        return -1;
    }

    public void setUpStore(SQLiteDatabase db){
        ContentValues drums = new ContentValues();
        drums.put("INSTRUMENT", "DRUM");
        drums.put("OWNED", false);
        drums.put("POINTS", 200);
        ContentValues piano = new ContentValues();
        piano.put("INSTRUMENT", "PIANO");
        piano.put("OWNED", false);
        piano.put("POINTS", 250);
        ContentValues kazoo = new ContentValues();
        kazoo.put("INSTRUMENT", "KAZOO");
        kazoo.put("OWNED", false);
        kazoo.put("POINTS", 300);
        db.insert(STORE_TABLE_NAME, null, drums);
        db.insert(STORE_TABLE_NAME, null, piano);
        db.insert(STORE_TABLE_NAME, null, kazoo);
    }

    public boolean getInstrument(String inst){
        SQLiteDatabase db = this.getWritableDatabase();
        int pts = 0;
        Cursor c = db.rawQuery("SELECT OWNED FROM " + STORE_TABLE_NAME + " WHERE INSTRUMENT = \"" + inst + "\";", null);
        if(c.moveToFirst()){
            return (c.getInt(0) > 0);
        }

        return false;
    }

    public void purchaseInstrument(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE " +  STORE_TABLE_NAME + " SET OWNED = '1' WHERE INSTRUMENT = \"" + name + "\";");
    }

    public void setUpPts(SQLiteDatabase db){
        ContentValues pts = new ContentValues();
        pts.put("POINTS", 150);
        db.insert(POINTS_TABLE_NAME, null, pts);
    }

    public int getPts(){
        SQLiteDatabase db = this.getReadableDatabase();
        int currPts = 0;
        Cursor c = db.rawQuery("SELECT POINTS FROM " + POINTS_TABLE_NAME, null);
        if(c.moveToFirst()){
            currPts = c.getInt(0);
        }
        db.close();
        return currPts;
    }

    public void addPts(int num){
        SQLiteDatabase db = this.getWritableDatabase();
        int currPts = 0;
        Cursor c = db.rawQuery("SELECT POINTS FROM " + POINTS_TABLE_NAME, null);
        if(c.moveToFirst()){
            currPts = c.getInt(0);
        }
        db.execSQL("UPDATE " +  POINTS_TABLE_NAME + " SET POINTS = " + (currPts + num));
        Log.d("Actual", "" + currPts);
    }
}
