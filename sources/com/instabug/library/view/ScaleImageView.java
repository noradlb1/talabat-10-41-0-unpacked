package com.instabug.library.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class ScaleImageView extends ImageView implements View.OnTouchListener {
    private float MAX_SCALE = 5.0f;
    private boolean isScaling;
    private Context mContext;
    private GestureDetector mDetector;
    private int mHeight;
    private int mIntrinsicHeight;
    private int mIntrinsicWidth;
    private Matrix mMatrix;
    private final float[] mMatrixValues = new float[9];
    private float mMinScale;
    private float mPrevDistance;
    private int mPrevMoveX;
    private int mPrevMoveY;
    private float mScale;
    private int mWidth;

    public class a extends GestureDetector.SimpleOnGestureListener {
        public a() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            ScaleImageView.this.b((int) motionEvent.getX(), (int) motionEvent.getY());
            ScaleImageView.this.cutting();
            return super.onDoubleTap(motionEvent);
        }
    }

    public ScaleImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        initialize();
    }

    private float dispDistance() {
        int i11 = this.mWidth;
        int i12 = this.mHeight;
        return (float) Math.sqrt((double) ((i11 * i11) + (i12 * i12)));
    }

    private float distance(float f11, float f12, float f13, float f14) {
        float f15 = f11 - f12;
        float f16 = f13 - f14;
        return (float) Math.sqrt((double) ((f15 * f15) + (f16 * f16)));
    }

    private void initialize() {
        setScaleType(ImageView.ScaleType.MATRIX);
        this.mMatrix = new Matrix();
        Drawable drawable = getDrawable();
        if (drawable != null) {
            this.mIntrinsicWidth = drawable.getIntrinsicWidth();
            this.mIntrinsicHeight = drawable.getIntrinsicHeight();
            setOnTouchListener(this);
        }
        this.mDetector = new GestureDetector(this.mContext, new a());
    }

    public float a(Matrix matrix, int i11) {
        matrix.getValues(this.mMatrixValues);
        return this.mMatrixValues[i11];
    }

    public void b(int i11, int i12) {
        if (this.mMinScale != getScale()) {
            float scale = getScale();
            float f11 = this.mMinScale;
            if (scale - f11 > 0.1f) {
                zoomTo(f11 / getScale(), i11, i12);
                return;
            }
        }
        zoomTo(this.MAX_SCALE / getScale(), i11, i12);
    }

    public void cutting() {
        int scale = (int) (((float) this.mIntrinsicWidth) * getScale());
        int scale2 = (int) (((float) this.mIntrinsicHeight) * getScale());
        if (getTranslateX() < ((float) (-(scale - this.mWidth)))) {
            this.mMatrix.postTranslate(-((getTranslateX() + ((float) scale)) - ((float) this.mWidth)), 0.0f);
        }
        if (getTranslateX() > 0.0f) {
            this.mMatrix.postTranslate(-getTranslateX(), 0.0f);
        }
        if (getTranslateY() < ((float) (-(scale2 - this.mHeight)))) {
            this.mMatrix.postTranslate(0.0f, -((getTranslateY() + ((float) scale2)) - ((float) this.mHeight)));
        }
        if (getTranslateY() > 0.0f) {
            this.mMatrix.postTranslate(0.0f, -getTranslateY());
        }
        int i11 = this.mWidth;
        if (scale < i11) {
            this.mMatrix.postTranslate(((float) (i11 - scale)) / 2.0f, 0.0f);
        }
        int i12 = this.mHeight;
        if (scale2 < i12) {
            this.mMatrix.postTranslate(0.0f, ((float) (i12 - scale2)) / 2.0f);
        }
        setImageMatrix(this.mMatrix);
    }

    public float getScale() {
        return a(this.mMatrix, 0);
    }

    public float getTranslateX() {
        return a(this.mMatrix, 2);
    }

    public float getTranslateY() {
        return a(this.mMatrix, 5);
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0026, code lost:
        if (r2 != 262) goto L_0x00c1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r7) {
        /*
            r6 = this;
            android.view.GestureDetector r0 = r6.mDetector
            boolean r0 = r0.onTouchEvent(r7)
            r1 = 1
            if (r0 == 0) goto L_0x000a
            return r1
        L_0x000a:
            int r0 = r7.getPointerCount()
            int r2 = r7.getAction()
            r3 = 0
            r4 = 2
            if (r2 == 0) goto L_0x0098
            if (r2 == r1) goto L_0x008f
            if (r2 == r4) goto L_0x002a
            r5 = 5
            if (r2 == r5) goto L_0x0098
            r5 = 6
            if (r2 == r5) goto L_0x008f
            r5 = 261(0x105, float:3.66E-43)
            if (r2 == r5) goto L_0x0098
            r0 = 262(0x106, float:3.67E-43)
            if (r2 == r0) goto L_0x008f
            goto L_0x00c1
        L_0x002a:
            if (r0 < r4) goto L_0x0060
            boolean r0 = r6.isScaling
            if (r0 == 0) goto L_0x0060
            float r0 = r7.getX(r3)
            float r2 = r7.getX(r1)
            float r3 = r7.getY(r3)
            float r7 = r7.getY(r1)
            float r7 = r6.distance(r0, r2, r3, r7)
            float r0 = r6.mPrevDistance
            float r0 = r7 - r0
            float r2 = r6.dispDistance()
            float r0 = r0 / r2
            r6.mPrevDistance = r7
            r7 = 1065353216(0x3f800000, float:1.0)
            float r0 = r0 + r7
            float r0 = r0 * r0
            int r7 = r6.mWidth
            int r7 = r7 / r4
            int r2 = r6.mHeight
            int r2 = r2 / r4
            r6.zoomTo(r0, r7, r2)
            r6.cutting()
            goto L_0x00c1
        L_0x0060:
            boolean r0 = r6.isScaling
            if (r0 != 0) goto L_0x00c1
            int r0 = r6.mPrevMoveX
            float r2 = r7.getX()
            int r2 = (int) r2
            int r0 = r0 - r2
            int r2 = r6.mPrevMoveY
            float r3 = r7.getY()
            int r3 = (int) r3
            int r2 = r2 - r3
            float r3 = r7.getX()
            int r3 = (int) r3
            r6.mPrevMoveX = r3
            float r7 = r7.getY()
            int r7 = (int) r7
            r6.mPrevMoveY = r7
            android.graphics.Matrix r7 = r6.mMatrix
            int r0 = -r0
            float r0 = (float) r0
            int r2 = -r2
            float r2 = (float) r2
            r7.postTranslate(r0, r2)
            r6.cutting()
            goto L_0x00c1
        L_0x008f:
            int r7 = r7.getPointerCount()
            if (r7 > r1) goto L_0x00c1
            r6.isScaling = r3
            goto L_0x00c1
        L_0x0098:
            if (r0 < r4) goto L_0x00b3
            float r0 = r7.getX(r3)
            float r2 = r7.getX(r1)
            float r3 = r7.getY(r3)
            float r7 = r7.getY(r1)
            float r7 = r6.distance(r0, r2, r3, r7)
            r6.mPrevDistance = r7
            r6.isScaling = r1
            goto L_0x00c1
        L_0x00b3:
            float r0 = r7.getX()
            int r0 = (int) r0
            r6.mPrevMoveX = r0
            float r7 = r7.getY()
            int r7 = (int) r7
            r6.mPrevMoveY = r7
        L_0x00c1:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.view.ScaleImageView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean setFrame(int i11, int i12, int i13, int i14) {
        int i15;
        int i16 = i13 - i11;
        this.mWidth = i16;
        this.mHeight = i14 - i12;
        this.mMatrix.reset();
        float f11 = ((float) i16) / ((float) this.mIntrinsicWidth);
        this.mScale = f11;
        float f12 = (float) this.mIntrinsicHeight;
        float f13 = (float) this.mHeight;
        int i17 = 0;
        if (f11 * f12 > f13) {
            float f14 = f13 / f12;
            this.mScale = f14;
            this.mMatrix.postScale(f14, f14);
            i15 = (i13 - this.mWidth) / 2;
        } else {
            this.mMatrix.postScale(f11, f11);
            i17 = (i14 - this.mHeight) / 2;
            i15 = 0;
        }
        this.mMatrix.postTranslate((float) i15, (float) i17);
        setImageMatrix(this.mMatrix);
        float f15 = this.mScale;
        this.mMinScale = f15;
        zoomTo(f15, this.mWidth / 2, this.mHeight / 2);
        cutting();
        return super.setFrame(i11, i12, i13, i14);
    }

    public void setImageBitmap(Bitmap bitmap) {
        super.setImageBitmap(bitmap);
        initialize();
    }

    public void setImageResource(int i11) {
        super.setImageResource(i11);
        initialize();
    }

    public void zoomTo(float f11, int i11, int i12) {
        if (getScale() * f11 >= this.mMinScale) {
            if (f11 < 1.0f || getScale() * f11 <= this.MAX_SCALE) {
                this.mMatrix.postScale(f11, f11);
                Matrix matrix = this.mMatrix;
                float f12 = (float) this.mWidth;
                float f13 = (float) this.mHeight;
                matrix.postTranslate((-((f12 * f11) - f12)) / 2.0f, (-((f13 * f11) - f13)) / 2.0f);
                this.mMatrix.postTranslate(((float) (-(i11 - (this.mWidth / 2)))) * f11, 0.0f);
                this.mMatrix.postTranslate(0.0f, ((float) (-(i12 - (this.mHeight / 2)))) * f11);
                setImageMatrix(this.mMatrix);
            }
        }
    }

    public ScaleImageView(Context context) {
        super(context);
        this.mContext = context;
        initialize();
    }
}
