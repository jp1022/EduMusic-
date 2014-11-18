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

    public PersonView(Context context) {
        super(context);
        init(null, 0);
    }

    public PersonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public PersonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet set, int defstyle) {
        paint.setColor(Color.CYAN);
        paint.setAntiAlias(true);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(50,50,50,paint);
    }


}
