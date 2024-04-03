package com.talabat.helpers;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;

public class TextDrawable extends ShapeDrawable {
    private static final float SHADE_FACTOR = 0.9f;
    private final Paint borderPaint;
    private final int borderThickness;
    private final int color;
    private final int fontSize;
    private final int height;
    private final float radius;
    private final RectShape shape;
    private final String text;
    private final Paint textPaint;
    private final int width;

    public static class Builder implements IConfigBuilder, IShapeBuilder, IBuilder {
        /* access modifiers changed from: private */
        public int borderThickness;
        /* access modifiers changed from: private */
        public int color;
        /* access modifiers changed from: private */
        public Typeface font;
        /* access modifiers changed from: private */
        public int fontSize;
        /* access modifiers changed from: private */
        public int height;
        /* access modifiers changed from: private */
        public boolean isBold;
        public float radius;
        /* access modifiers changed from: private */
        public RectShape shape;
        /* access modifiers changed from: private */
        public String text;
        public int textColor;
        /* access modifiers changed from: private */
        public boolean toUpperCase;
        /* access modifiers changed from: private */
        public int width;

        private Builder() {
            this.text = "";
            this.color = -7829368;
            this.textColor = -1;
            this.borderThickness = 0;
            this.width = -1;
            this.height = -1;
            this.shape = new RectShape();
            this.font = Typeface.create("sans-serif-light", 0);
            this.fontSize = -1;
            this.isBold = true;
            this.toUpperCase = false;
        }

        public IConfigBuilder beginConfig() {
            return this;
        }

        public IConfigBuilder bold() {
            this.isBold = true;
            return this;
        }

        public TextDrawable build(String str, int i11) {
            this.color = i11;
            this.text = str;
            return new TextDrawable(this);
        }

        public TextDrawable buildRect(String str, int i11) {
            rect();
            return build(str, i11);
        }

        public TextDrawable buildRound(String str, int i11) {
            round();
            return build(str, i11);
        }

        public TextDrawable buildRoundRect(String str, int i11, int i12) {
            roundRect(i12);
            return build(str, i11);
        }

        public IShapeBuilder endConfig() {
            return this;
        }

        public IConfigBuilder fontSize(int i11) {
            this.fontSize = i11;
            return this;
        }

        public IConfigBuilder height(int i11) {
            this.height = i11;
            return this;
        }

        public IBuilder rect() {
            this.shape = new RectShape();
            return this;
        }

        public IBuilder round() {
            this.shape = new OvalShape();
            return this;
        }

        public IBuilder roundRect(int i11) {
            float f11 = (float) i11;
            this.radius = f11;
            this.shape = new RoundRectShape(new float[]{f11, f11, f11, f11, f11, f11, f11, f11}, (RectF) null, (float[]) null);
            return this;
        }

        public IConfigBuilder textColor(int i11) {
            this.textColor = i11;
            return this;
        }

        public IConfigBuilder toUpperCase() {
            this.toUpperCase = true;
            return this;
        }

        public IConfigBuilder useFont(Typeface typeface) {
            this.font = typeface;
            return this;
        }

        public IConfigBuilder width(int i11) {
            this.width = i11;
            return this;
        }

        public IConfigBuilder withBorder(int i11) {
            this.borderThickness = i11;
            return this;
        }
    }

    public interface IBuilder {
        TextDrawable build(String str, int i11);
    }

    public interface IConfigBuilder {
        IConfigBuilder bold();

        IShapeBuilder endConfig();

        IConfigBuilder fontSize(int i11);

        IConfigBuilder height(int i11);

        IConfigBuilder textColor(int i11);

        IConfigBuilder toUpperCase();

        IConfigBuilder useFont(Typeface typeface);

        IConfigBuilder width(int i11);

        IConfigBuilder withBorder(int i11);
    }

    public interface IShapeBuilder {
        IConfigBuilder beginConfig();

        TextDrawable buildRect(String str, int i11);

        TextDrawable buildRound(String str, int i11);

        TextDrawable buildRoundRect(String str, int i11, int i12);

        IBuilder rect();

        IBuilder round();

        IBuilder roundRect(int i11);
    }

    private TextDrawable(Builder builder) {
        super(builder.shape);
        this.shape = builder.shape;
        this.height = builder.height;
        this.width = builder.width;
        this.radius = builder.radius;
        this.text = builder.toUpperCase ? builder.text.toUpperCase() : builder.text;
        int b11 = builder.color;
        this.color = b11;
        this.fontSize = builder.fontSize;
        Paint paint = new Paint();
        this.textPaint = paint;
        paint.setColor(builder.textColor);
        paint.setAntiAlias(true);
        paint.setFakeBoldText(builder.isBold);
        paint.setStyle(Paint.Style.FILL);
        paint.setTypeface(builder.font);
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setStrokeWidth((float) builder.borderThickness);
        int a11 = builder.borderThickness;
        this.borderThickness = a11;
        Paint paint2 = new Paint();
        this.borderPaint = paint2;
        paint2.setColor(getDarkerShade(b11));
        paint2.setStyle(Paint.Style.STROKE);
        paint2.setStrokeWidth((float) a11);
        getPaint().setColor(b11);
    }

    public static IShapeBuilder builder() {
        return new Builder();
    }

    private void drawBorder(Canvas canvas) {
        RectF rectF = new RectF(getBounds());
        int i11 = this.borderThickness;
        rectF.inset((float) (i11 / 2), (float) (i11 / 2));
        RectShape rectShape = this.shape;
        if (rectShape instanceof OvalShape) {
            canvas.drawOval(rectF, this.borderPaint);
        } else if (rectShape instanceof RoundRectShape) {
            float f11 = this.radius;
            canvas.drawRoundRect(rectF, f11, f11, this.borderPaint);
        } else {
            canvas.drawRect(rectF, this.borderPaint);
        }
    }

    private int getDarkerShade(int i11) {
        return Color.rgb((int) (((float) Color.red(i11)) * SHADE_FACTOR), (int) (((float) Color.green(i11)) * SHADE_FACTOR), (int) (((float) Color.blue(i11)) * SHADE_FACTOR));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        Rect bounds = getBounds();
        if (this.borderThickness > 0) {
            drawBorder(canvas);
        }
        int save = canvas.save();
        canvas.translate((float) bounds.left, (float) bounds.top);
        int i11 = this.width;
        if (i11 < 0) {
            i11 = bounds.width();
        }
        int i12 = this.height;
        if (i12 < 0) {
            i12 = bounds.height();
        }
        int i13 = this.fontSize;
        if (i13 < 0) {
            i13 = Math.min(i11, i12) / 2;
        }
        this.textPaint.setTextSize((float) i13);
        canvas.drawText(this.text, (float) (i11 / 2), ((float) (i12 / 2)) - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f), this.textPaint);
        canvas.restoreToCount(save);
    }

    public int getIntrinsicHeight() {
        return this.height;
    }

    public int getIntrinsicWidth() {
        return this.width;
    }

    public int getOpacity() {
        return -3;
    }

    public void setAlpha(int i11) {
        this.textPaint.setAlpha(i11);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.textPaint.setColorFilter(colorFilter);
    }
}
