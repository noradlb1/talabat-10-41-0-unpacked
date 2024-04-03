package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.huawei.wisesecurity.ucs.common.exception.UcsErrorCode;
import com.wang.avi.Indicator;
import java.util.ArrayList;

public class LineScalePartyIndicator extends Indicator {
    public static final float SCALE = 1.0f;

    /* renamed from: c  reason: collision with root package name */
    public float[] f13781c = {1.0f, 1.0f, 1.0f, 1.0f, 1.0f};

    public void draw(Canvas canvas, Paint paint) {
        float width = (float) (getWidth() / 9);
        float height = (float) (getHeight() / 2);
        for (int i11 = 0; i11 < 4; i11++) {
            canvas.save();
            float f11 = width / 2.0f;
            canvas.translate((((float) ((i11 * 2) + 2)) * width) - f11, height);
            float f12 = this.f13781c[i11];
            canvas.scale(f12, f12);
            canvas.drawRoundRect(new RectF((-width) / 2.0f, ((float) (-getHeight())) / 2.5f, f11, ((float) getHeight()) / 2.5f), 5.0f, 5.0f, paint);
            canvas.restore();
        }
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        long[] jArr = {1260, 430, UcsErrorCode.DOWNLOAD_KEY_COMPONENT_ERROR, 730};
        long[] jArr2 = {770, 290, 280, 740};
        for (final int i11 = 0; i11 < 4; i11++) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{1.0f, 0.4f, 1.0f});
            ofFloat.setDuration(jArr[i11]);
            ofFloat.setRepeatCount(-1);
            ofFloat.setStartDelay(jArr2[i11]);
            addUpdateListener(ofFloat, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    LineScalePartyIndicator.this.f13781c[i11] = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    LineScalePartyIndicator.this.postInvalidate();
                }
            });
            arrayList.add(ofFloat);
        }
        return arrayList;
    }
}
