package com.wang.avi.indicators;

import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.huawei.location.lite.common.http.exception.ErrorCode;
import com.wang.avi.Indicator;
import java.util.ArrayList;
import net.bytebuddy.jar.asm.Opcodes;

public class BallGridBeatIndicator extends Indicator {
    public static final int ALPHA = 255;

    /* renamed from: c  reason: collision with root package name */
    public int[] f13708c = {255, 255, 255, 255, 255, 255, 255, 255, 255};

    public void draw(Canvas canvas, Paint paint) {
        float width = (((float) getWidth()) - 16.0f) / 6.0f;
        float f11 = 2.0f * width;
        float f12 = f11 + 4.0f;
        float width2 = ((float) (getWidth() / 2)) - f12;
        float width3 = ((float) (getWidth() / 2)) - f12;
        for (int i11 = 0; i11 < 3; i11++) {
            for (int i12 = 0; i12 < 3; i12++) {
                canvas.save();
                float f13 = (float) i12;
                float f14 = (f11 * f13) + width2 + (f13 * 4.0f);
                float f15 = (float) i11;
                canvas.translate(f14, (f11 * f15) + width3 + (f15 * 4.0f));
                paint.setAlpha(this.f13708c[(i11 * 3) + i12]);
                canvas.drawCircle(0.0f, 0.0f, width, paint);
                canvas.restore();
            }
        }
    }

    public ArrayList<ValueAnimator> onCreateAnimators() {
        ArrayList<ValueAnimator> arrayList = new ArrayList<>();
        int[] iArr = {960, 930, 1190, 1130, 1340, 940, 1200, 820, 1190};
        int[] iArr2 = {360, 400, 680, ErrorCode.HTTP_GONE, 710, -150, -120, 10, 320};
        for (final int i11 = 0; i11 < 9; i11++) {
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{255, Opcodes.JSR, 255});
            ofInt.setDuration((long) iArr[i11]);
            ofInt.setRepeatCount(-1);
            ofInt.setStartDelay((long) iArr2[i11]);
            addUpdateListener(ofInt, new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    BallGridBeatIndicator.this.f13708c[i11] = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    BallGridBeatIndicator.this.postInvalidate();
                }
            });
            arrayList.add(ofInt);
        }
        return arrayList;
    }
}
