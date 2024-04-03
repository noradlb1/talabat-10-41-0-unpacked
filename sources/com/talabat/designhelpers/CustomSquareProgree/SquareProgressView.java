package com.talabat.designhelpers.CustomSquareProgree;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;
import com.talabat.designhelpers.CustomSquareProgree.Utils.CalculationUtil;
import com.talabat.designhelpers.CustomSquareProgree.Utils.PercentStyle;
import java.text.DecimalFormat;

public class SquareProgressView extends View {
    private Canvas canvas;
    private boolean centerline = false;
    private boolean clearOnHundred = false;
    private int indeterminate_count = 1;
    private float indeterminate_width = 20.0f;
    private boolean isIndeterminate = false;
    private boolean outline = false;
    private Paint outlinePaint;
    private PercentStyle percentSettings = new PercentStyle(Paint.Align.CENTER, 150.0f, true);
    private double progress;
    private Paint progressBarPaint;
    private boolean roundedCorners = false;
    private float roundedCornersRadius = 10.0f;
    private boolean showProgress = false;
    private boolean startline = false;
    private float strokewidth = 0.0f;
    private Paint textPaint;
    private float widthInDp = 10.0f;

    public class DrawStop {
        /* access modifiers changed from: private */
        public float location;
        /* access modifiers changed from: private */
        public Place place;

        public DrawStop() {
        }
    }

    public enum Place {
        TOP,
        RIGHT,
        BOTTOM,
        LEFT
    }

    public SquareProgressView(Context context) {
        super(context);
        initializePaints(context);
    }

    private void drawCenterline(float f11) {
        float f12 = f11 / 2.0f;
        Path path = new Path();
        path.moveTo(f12, f12);
        path.lineTo(((float) this.canvas.getWidth()) - f12, f12);
        path.lineTo(((float) this.canvas.getWidth()) - f12, ((float) this.canvas.getHeight()) - f12);
        path.lineTo(f12, ((float) this.canvas.getHeight()) - f12);
        path.lineTo(f12, f12);
        this.canvas.drawPath(path, this.outlinePaint);
    }

    private void drawOutline() {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.lineTo((float) this.canvas.getWidth(), 0.0f);
        path.lineTo((float) this.canvas.getWidth(), (float) this.canvas.getHeight());
        path.lineTo(0.0f, (float) this.canvas.getHeight());
        path.lineTo(0.0f, 0.0f);
        this.canvas.drawPath(path, this.outlinePaint);
    }

    private void drawPercent(PercentStyle percentStyle) {
        this.textPaint.setTextAlign(percentStyle.getAlign());
        if (percentStyle.getTextSize() == 0.0f) {
            this.textPaint.setTextSize((float) ((this.canvas.getHeight() / 10) * 4));
        } else {
            this.textPaint.setTextSize(percentStyle.getTextSize());
        }
        String format = new DecimalFormat("###").format(getProgress());
        if (percentStyle.isPercentSign()) {
            format = format + this.percentSettings.getCustomText();
        }
        this.textPaint.setColor(this.percentSettings.getTextColor());
        Canvas canvas2 = this.canvas;
        canvas2.drawText(format, (float) (canvas2.getWidth() / 2), (float) ((int) (((float) (this.canvas.getHeight() / 2)) - ((this.textPaint.descent() + this.textPaint.ascent()) / 2.0f))), this.textPaint);
    }

    private void drawStartline() {
        Path path = new Path();
        path.moveTo((float) (this.canvas.getWidth() / 2), 0.0f);
        path.lineTo((float) (this.canvas.getWidth() / 2), this.strokewidth);
        this.canvas.drawPath(path, this.outlinePaint);
    }

    private void initializePaints(Context context) {
        Paint paint = new Paint();
        this.progressBarPaint = paint;
        paint.setColor(context.getResources().getColor(17170453));
        this.progressBarPaint.setStrokeWidth((float) CalculationUtil.convertDpToPx(this.widthInDp, getContext()));
        this.progressBarPaint.setAntiAlias(true);
        this.progressBarPaint.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint();
        this.outlinePaint = paint2;
        paint2.setColor(context.getResources().getColor(17170444));
        this.outlinePaint.setStrokeWidth(1.0f);
        this.outlinePaint.setAntiAlias(true);
        this.outlinePaint.setStyle(Paint.Style.STROKE);
        Paint paint3 = new Paint();
        this.textPaint = paint3;
        paint3.setColor(context.getResources().getColor(17170444));
        this.textPaint.setAntiAlias(true);
        this.textPaint.setStyle(Paint.Style.STROKE);
    }

    public DrawStop getDrawEnd(float f11, Canvas canvas2) {
        DrawStop drawStop = new DrawStop();
        this.strokewidth = (float) CalculationUtil.convertDpToPx(this.widthInDp, getContext());
        float width = (float) (canvas2.getWidth() / 2);
        if (f11 > width) {
            float f12 = f11 - width;
            if (f12 > ((float) canvas2.getHeight())) {
                float height = f12 - ((float) canvas2.getHeight());
                if (height > ((float) canvas2.getWidth())) {
                    float width2 = height - ((float) canvas2.getWidth());
                    if (width2 > ((float) canvas2.getHeight())) {
                        float height2 = width2 - ((float) canvas2.getHeight());
                        if (height2 == width) {
                            drawStop.place = Place.TOP;
                            drawStop.location = width;
                        } else {
                            drawStop.place = Place.TOP;
                            drawStop.location = this.strokewidth + height2;
                        }
                    } else {
                        drawStop.place = Place.LEFT;
                        drawStop.location = ((float) canvas2.getHeight()) - width2;
                    }
                } else {
                    drawStop.place = Place.BOTTOM;
                    drawStop.location = ((float) canvas2.getWidth()) - height;
                }
            } else {
                drawStop.place = Place.RIGHT;
                drawStop.location = this.strokewidth + f12;
            }
        } else {
            drawStop.place = Place.TOP;
            drawStop.location = width + f11;
        }
        return drawStop;
    }

    public PercentStyle getPercentStyle() {
        return this.percentSettings;
    }

    public double getProgress() {
        return this.progress;
    }

    public boolean isCenterline() {
        return this.centerline;
    }

    public boolean isClearOnHundred() {
        return this.clearOnHundred;
    }

    public boolean isIndeterminate() {
        return this.isIndeterminate;
    }

    public boolean isOutline() {
        return this.outline;
    }

    public boolean isRoundedCorners() {
        return this.roundedCorners;
    }

    public boolean isShowProgress() {
        return this.showProgress;
    }

    public boolean isStartline() {
        return this.startline;
    }

    public void onDraw(Canvas canvas2) {
        this.canvas = canvas2;
        super.onDraw(canvas2);
        this.strokewidth = (float) CalculationUtil.convertDpToPx(this.widthInDp, getContext());
        float width = ((float) (((canvas2.getWidth() + canvas2.getHeight()) + canvas2.getHeight()) + canvas2.getWidth())) - this.strokewidth;
        if (isOutline()) {
            drawOutline();
        }
        if (isStartline()) {
            drawStartline();
        }
        if (isShowProgress()) {
            drawPercent(this.percentSettings);
        }
        if (isCenterline()) {
            drawCenterline(this.strokewidth);
        }
        if ((isClearOnHundred() && this.progress == 100.0d) || this.progress <= 0.0d) {
            return;
        }
        if (isIndeterminate()) {
            Path path = new Path();
            DrawStop drawEnd = getDrawEnd((width / 100.0f) * Float.valueOf(String.valueOf(this.indeterminate_count)).floatValue(), canvas2);
            if (drawEnd.place == Place.TOP) {
                float a11 = drawEnd.location - this.indeterminate_width;
                float f11 = this.strokewidth;
                path.moveTo(a11 - f11, f11 / 2.0f);
                path.lineTo(drawEnd.location, this.strokewidth / 2.0f);
                canvas2.drawPath(path, this.progressBarPaint);
            }
            if (drawEnd.place == Place.RIGHT) {
                path.moveTo(((float) canvas2.getWidth()) - (this.strokewidth / 2.0f), drawEnd.location - this.indeterminate_width);
                float f12 = this.strokewidth;
                path.lineTo(((float) canvas2.getWidth()) - (f12 / 2.0f), f12 + drawEnd.location);
                canvas2.drawPath(path, this.progressBarPaint);
            }
            if (drawEnd.place == Place.BOTTOM) {
                path.moveTo((drawEnd.location - this.indeterminate_width) - this.strokewidth, ((float) canvas2.getHeight()) - (this.strokewidth / 2.0f));
                path.lineTo(drawEnd.location, ((float) canvas2.getHeight()) - (this.strokewidth / 2.0f));
                canvas2.drawPath(path, this.progressBarPaint);
            }
            if (drawEnd.place == Place.LEFT) {
                path.moveTo(this.strokewidth / 2.0f, (drawEnd.location - this.indeterminate_width) - this.strokewidth);
                path.lineTo(this.strokewidth / 2.0f, drawEnd.location);
                canvas2.drawPath(path, this.progressBarPaint);
            }
            int i11 = this.indeterminate_count + 1;
            this.indeterminate_count = i11;
            if (i11 > 100) {
                this.indeterminate_count = 0;
            }
            invalidate();
            return;
        }
        Path path2 = new Path();
        DrawStop drawEnd2 = getDrawEnd((width / 100.0f) * Float.valueOf(String.valueOf(this.progress)).floatValue(), canvas2);
        if (drawEnd2.place == Place.TOP) {
            if (drawEnd2.location > ((float) (canvas2.getWidth() / 2))) {
                path2.moveTo((float) (canvas2.getWidth() / 2), this.strokewidth / 2.0f);
                path2.lineTo(drawEnd2.location, this.strokewidth / 2.0f);
            } else {
                path2.moveTo((float) (canvas2.getWidth() / 2), this.strokewidth / 2.0f);
                float f13 = this.strokewidth;
                path2.lineTo(((float) canvas2.getWidth()) - (f13 / 2.0f), f13 / 2.0f);
                path2.lineTo(((float) canvas2.getWidth()) - (this.strokewidth / 2.0f), ((float) canvas2.getHeight()) - (this.strokewidth / 2.0f));
                path2.lineTo(this.strokewidth / 2.0f, ((float) canvas2.getHeight()) - (this.strokewidth / 2.0f));
                float f14 = this.strokewidth;
                path2.lineTo(f14 / 2.0f, f14 / 2.0f);
                path2.lineTo(drawEnd2.location, this.strokewidth / 2.0f);
            }
            canvas2.drawPath(path2, this.progressBarPaint);
        }
        if (drawEnd2.place == Place.RIGHT) {
            path2.moveTo((float) (canvas2.getWidth() / 2), this.strokewidth / 2.0f);
            float f15 = this.strokewidth;
            path2.lineTo(((float) canvas2.getWidth()) - (f15 / 2.0f), f15 / 2.0f);
            float f16 = this.strokewidth;
            path2.lineTo(((float) canvas2.getWidth()) - (f16 / 2.0f), (f16 / 2.0f) + drawEnd2.location);
            canvas2.drawPath(path2, this.progressBarPaint);
        }
        if (drawEnd2.place == Place.BOTTOM) {
            path2.moveTo((float) (canvas2.getWidth() / 2), this.strokewidth / 2.0f);
            float f17 = this.strokewidth;
            path2.lineTo(((float) canvas2.getWidth()) - (f17 / 2.0f), f17 / 2.0f);
            path2.lineTo(((float) canvas2.getWidth()) - (this.strokewidth / 2.0f), ((float) canvas2.getHeight()) - (this.strokewidth / 2.0f));
            path2.lineTo(drawEnd2.location, ((float) canvas2.getHeight()) - (this.strokewidth / 2.0f));
            canvas2.drawPath(path2, this.progressBarPaint);
        }
        if (drawEnd2.place == Place.LEFT) {
            path2.moveTo((float) (canvas2.getWidth() / 2), this.strokewidth / 2.0f);
            float f18 = this.strokewidth;
            path2.lineTo(((float) canvas2.getWidth()) - (f18 / 2.0f), f18 / 2.0f);
            path2.lineTo(((float) canvas2.getWidth()) - (this.strokewidth / 2.0f), ((float) canvas2.getHeight()) - (this.strokewidth / 2.0f));
            path2.lineTo(this.strokewidth / 2.0f, ((float) canvas2.getHeight()) - (this.strokewidth / 2.0f));
            path2.lineTo(this.strokewidth / 2.0f, drawEnd2.location);
            canvas2.drawPath(path2, this.progressBarPaint);
        }
    }

    public void setCenterline(boolean z11) {
        this.centerline = z11;
        invalidate();
    }

    public void setClearOnHundred(boolean z11) {
        this.clearOnHundred = z11;
        invalidate();
    }

    public void setColor(int i11) {
        this.progressBarPaint.setColor(i11);
        invalidate();
    }

    public void setIndeterminate(boolean z11) {
        this.isIndeterminate = z11;
        invalidate();
    }

    public void setOutline(boolean z11) {
        this.outline = z11;
        invalidate();
    }

    public void setPercentStyle(PercentStyle percentStyle) {
        this.percentSettings = percentStyle;
        invalidate();
    }

    public void setProgress(double d11) {
        this.progress = d11;
        invalidate();
    }

    public void setRoundedCorners(boolean z11, float f11) {
        this.roundedCorners = z11;
        this.roundedCornersRadius = f11;
        if (z11) {
            this.progressBarPaint.setPathEffect(new CornerPathEffect(this.roundedCornersRadius));
        } else {
            this.progressBarPaint.setPathEffect((PathEffect) null);
        }
        invalidate();
    }

    public void setShowProgress(boolean z11) {
        this.showProgress = z11;
        invalidate();
    }

    public void setStartline(boolean z11) {
        this.startline = z11;
        invalidate();
    }

    public void setWidthInDp(int i11) {
        float f11 = (float) i11;
        this.widthInDp = f11;
        this.progressBarPaint.setStrokeWidth((float) CalculationUtil.convertDpToPx(f11, getContext()));
        invalidate();
    }

    public SquareProgressView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initializePaints(context);
    }

    public SquareProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initializePaints(context);
    }
}
