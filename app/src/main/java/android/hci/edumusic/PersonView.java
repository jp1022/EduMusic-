package android.hci.edumusic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by ian on 11/17/2014.
 */
public class PersonView extends View {

    Paint paint = new Paint();
    Paint noteColor = new Paint();
    EduMusicDB db;

    public PersonView(Context context) {
        super(context);
        db = new EduMusicDB(context);
        init(null, 0);
    }

    public PersonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        db = new EduMusicDB(context);
        init(attrs, 0);
    }

    public PersonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        db = new EduMusicDB(context);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet set, int defstyle) {
        paint.setColor(Color.CYAN);
        noteColor.setColor(Color.DKGRAY);
        paint.setAntiAlias(true);
        noteColor.setAntiAlias(true);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(50,50,50,paint);
        int notes= db.getPts();
        noteColor.setTextSize(50);
        canvas.drawText("" + notes, 40, 40, noteColor);

    }


}
