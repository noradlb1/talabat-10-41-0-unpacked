package androidx.cardview.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import androidx.cardview.widget.RoundRectDrawableWithShadow;

class CardViewBaseImpl implements CardViewImpl {

    /* renamed from: a  reason: collision with root package name */
    public final RectF f1016a = new RectF();

    private RoundRectDrawableWithShadow createBackground(Context context, ColorStateList colorStateList, float f11, float f12, float f13) {
        return new RoundRectDrawableWithShadow(context.getResources(), colorStateList, f11, f12, f13);
    }

    private RoundRectDrawableWithShadow getShadowBackground(CardViewDelegate cardViewDelegate) {
        return (RoundRectDrawableWithShadow) cardViewDelegate.getCardBackground();
    }

    public ColorStateList getBackgroundColor(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).c();
    }

    public float getElevation(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).i();
    }

    public float getMaxElevation(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).f();
    }

    public float getMinHeight(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).g();
    }

    public float getMinWidth(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).h();
    }

    public float getRadius(CardViewDelegate cardViewDelegate) {
        return getShadowBackground(cardViewDelegate).d();
    }

    public void initStatic() {
        RoundRectDrawableWithShadow.f1018a = new RoundRectDrawableWithShadow.RoundRectHelper() {
            public void drawRoundRect(Canvas canvas, RectF rectF, float f11, Paint paint) {
                Canvas canvas2 = canvas;
                RectF rectF2 = rectF;
                float f12 = 2.0f * f11;
                float width = (rectF.width() - f12) - 1.0f;
                float height = (rectF.height() - f12) - 1.0f;
                if (f11 >= 1.0f) {
                    float f13 = f11 + 0.5f;
                    float f14 = -f13;
                    CardViewBaseImpl.this.f1016a.set(f14, f14, f13, f13);
                    int save = canvas.save();
                    canvas2.translate(rectF2.left + f13, rectF2.top + f13);
                    Paint paint2 = paint;
                    canvas.drawArc(CardViewBaseImpl.this.f1016a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(width, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.f1016a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(height, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.f1016a, 180.0f, 90.0f, true, paint2);
                    canvas2.translate(width, 0.0f);
                    canvas2.rotate(90.0f);
                    canvas.drawArc(CardViewBaseImpl.this.f1016a, 180.0f, 90.0f, true, paint2);
                    canvas2.restoreToCount(save);
                    float f15 = rectF2.top;
                    canvas.drawRect((rectF2.left + f13) - 1.0f, f15, (rectF2.right - f13) + 1.0f, f15 + f13, paint2);
                    float f16 = rectF2.bottom;
                    Canvas canvas3 = canvas;
                    canvas3.drawRect((rectF2.left + f13) - 1.0f, f16 - f13, (rectF2.right - f13) + 1.0f, f16, paint2);
                }
                canvas.drawRect(rectF2.left, rectF2.top + f11, rectF2.right, rectF2.bottom - f11, paint);
            }
        };
    }

    public void initialize(CardViewDelegate cardViewDelegate, Context context, ColorStateList colorStateList, float f11, float f12, float f13) {
        RoundRectDrawableWithShadow createBackground = createBackground(context, colorStateList, f11, f12, f13);
        createBackground.j(cardViewDelegate.getPreventCornerOverlap());
        cardViewDelegate.setCardBackground(createBackground);
        updatePadding(cardViewDelegate);
    }

    public void onCompatPaddingChanged(CardViewDelegate cardViewDelegate) {
    }

    public void onPreventCornerOverlapChanged(CardViewDelegate cardViewDelegate) {
        getShadowBackground(cardViewDelegate).j(cardViewDelegate.getPreventCornerOverlap());
        updatePadding(cardViewDelegate);
    }

    public void setBackgroundColor(CardViewDelegate cardViewDelegate, @Nullable ColorStateList colorStateList) {
        getShadowBackground(cardViewDelegate).k(colorStateList);
    }

    public void setElevation(CardViewDelegate cardViewDelegate, float f11) {
        getShadowBackground(cardViewDelegate).n(f11);
    }

    public void setMaxElevation(CardViewDelegate cardViewDelegate, float f11) {
        getShadowBackground(cardViewDelegate).m(f11);
        updatePadding(cardViewDelegate);
    }

    public void setRadius(CardViewDelegate cardViewDelegate, float f11) {
        getShadowBackground(cardViewDelegate).l(f11);
        updatePadding(cardViewDelegate);
    }

    public void updatePadding(CardViewDelegate cardViewDelegate) {
        Rect rect = new Rect();
        getShadowBackground(cardViewDelegate).e(rect);
        cardViewDelegate.setMinWidthHeightInternal((int) Math.ceil((double) getMinWidth(cardViewDelegate)), (int) Math.ceil((double) getMinHeight(cardViewDelegate)));
        cardViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }
}
