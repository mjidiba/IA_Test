package com.example.amineabboudi.working_app;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.AttributeSet;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/**
 * Created by amineabboudi on 7/18/17.
 */

public class BlueDotClass extends SubsamplingScaleImageView {
    private float radius = 1.0f;
    private PointF dotCenter = null;
    private  PointF destCenter=null;

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setDotCenter(PointF dotCenter) {
        this.dotCenter = dotCenter;
    }

    public void setDestCenter(PointF destCenter) {
        this.destCenter=destCenter;
    }

    public BlueDotClass(Context context) {
        this(context, null);
    }

    public BlueDotClass(Context context, AttributeSet attr) {
        super(context, attr);
        initialise();
    }

    private void initialise() {
        setWillNotDraw(false);
        setPanLimit(SubsamplingScaleImageView.PAN_LIMIT_CENTER);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (!isReady()) {
            return;
        }

        if (dotCenter != null) {
            PointF vPoint = sourceToViewCoord(dotCenter);
            float scaledRadius = getScale() * radius;
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(getResources().getColor(R.color.ia_blue));
            canvas.drawCircle(vPoint.x, vPoint.y, scaledRadius, paint);
        }

        if (destCenter != null) {
            PointF vPoint = sourceToViewCoord(destCenter);
            float scaledRadius = getScale() * radius;
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(getResources().getColor(R.color.dest_circle));
            canvas.drawCircle(vPoint.x, vPoint.y, scaledRadius, paint);
        }

    }
}
