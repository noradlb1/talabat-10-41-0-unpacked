package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.RoundRectDrawableWithShadow;

@RequiresApi(17)
class CardViewApi17Impl extends CardViewBaseImpl {
    public void initStatic() {
        RoundRectDrawableWithShadow.f1018a = new RoundRectDrawableWithShadow.RoundRectHelper() {
            public void drawRoundRect(Canvas canvas, RectF rectF, float f11, Paint paint) {
                canvas.drawRoundRect(rectF, f11, f11, paint);
            }
        };
    }
}
