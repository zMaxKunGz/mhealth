package mhealt.kku.funlhek.activity;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

import mhealt.kku.funlhek.R;

public class SpaceActivity extends VideoView {
    // Auto Intend
        /*Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SpaceActivity.this, MapsActivity.class));
                finish();
            }
        }, 2000); // หน่วงเวลา*/


    public SpaceActivity(Context context) {
        super(context);
    }

    public SpaceActivity(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SpaceActivity(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(widthMeasureSpec, heightMeasureSpec);
    }
}
