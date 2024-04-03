package com.talabat.helpers;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.RelativeLayout;
import androidx.annotation.ColorRes;
import com.talabat.talabatcommon.R;

public class RippleView extends RelativeLayout {
    private int HEIGHT;
    private int WIDTH;
    private boolean animationRunning = false;
    private Handler canvasHandler;
    private int durationEmpty = -1;
    private int frameRate = 10;
    private GestureDetector gestureDetector;
    private Boolean hasToZoom;
    private Boolean isCentered;
    private OnRippleCompleteListener onCompletionListener;
    private Bitmap originBitmap;
    private Paint paint;
    private float radiusMax = 0.0f;
    private int rippleAlpha = 90;
    private int rippleColor;
    private int rippleDuration = 400;
    private int ripplePadding;
    private Integer rippleType;
    private final Runnable runnable = new Runnable() {
        public void run() {
            RippleView.this.invalidate();
        }
    };
    private ScaleAnimation scaleAnimation;
    private int timer = 0;
    private int timerEmpty = 0;

    /* renamed from: x  reason: collision with root package name */
    private float f60841x = -1.0f;

    /* renamed from: y  reason: collision with root package name */
    private float f60842y = -1.0f;
    private int zoomDuration;
    private float zoomScale;

    public interface OnRippleCompleteListener {
        void onComplete(RippleView rippleView);
    }

    public enum RippleType {
        SIMPLE(0),
        DOUBLE(1),
        RECTANGLE(2);
        

        /* renamed from: b  reason: collision with root package name */
        public int f60845b;

        private RippleType(int i11) {
            this.f60845b = i11;
        }
    }

    public RippleView(Context context) {
        super(context);
    }

    private void createAnimation(float f11, float f12) {
        if (isEnabled() && !this.animationRunning) {
            if (this.hasToZoom.booleanValue()) {
                startAnimation(this.scaleAnimation);
            }
            this.radiusMax = (float) Math.max(this.WIDTH, this.HEIGHT);
            if (this.rippleType.intValue() != 2) {
                this.radiusMax /= 2.0f;
            }
            this.radiusMax -= (float) this.ripplePadding;
            if (this.isCentered.booleanValue() || this.rippleType.intValue() == 1) {
                this.f60841x = (float) (getMeasuredWidth() / 2);
                this.f60842y = (float) (getMeasuredHeight() / 2);
            } else {
                this.f60841x = f11;
                this.f60842y = f12;
            }
            this.animationRunning = true;
            if (this.rippleType.intValue() == 1 && this.originBitmap == null) {
                this.originBitmap = getDrawingCache(true);
            }
            invalidate();
        }
    }

    private Bitmap getCircleBitmap(int i11) {
        Bitmap createBitmap = Bitmap.createBitmap(this.originBitmap.getWidth(), this.originBitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint2 = new Paint();
        float f11 = this.f60841x;
        float f12 = (float) i11;
        float f13 = this.f60842y;
        Rect rect = new Rect((int) (f11 - f12), (int) (f13 - f12), (int) (f11 + f12), (int) (f13 + f12));
        paint2.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(this.f60841x, this.f60842y, f12, paint2);
        paint2.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(this.originBitmap, rect, rect, paint2);
        return createBitmap;
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RippleView);
            this.rippleColor = obtainStyledAttributes.getColor(2, getResources().getColor(com.talabat.R.color.talabat_grey));
            this.rippleType = Integer.valueOf(obtainStyledAttributes.getInt(6, 0));
            this.hasToZoom = Boolean.valueOf(obtainStyledAttributes.getBoolean(7, false));
            this.isCentered = Boolean.valueOf(obtainStyledAttributes.getBoolean(1, false));
            this.rippleDuration = obtainStyledAttributes.getInteger(4, this.rippleDuration);
            this.frameRate = obtainStyledAttributes.getInteger(3, this.frameRate);
            this.rippleAlpha = obtainStyledAttributes.getInteger(0, this.rippleAlpha);
            this.ripplePadding = obtainStyledAttributes.getDimensionPixelSize(5, 0);
            this.canvasHandler = new Handler();
            this.zoomScale = obtainStyledAttributes.getFloat(9, 1.03f);
            this.zoomDuration = obtainStyledAttributes.getInt(8, 200);
            obtainStyledAttributes.recycle();
            Paint paint2 = new Paint();
            this.paint = paint2;
            paint2.setAntiAlias(true);
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setColor(this.rippleColor);
            this.paint.setAlpha(this.rippleAlpha);
            setWillNotDraw(false);
            this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                public void onLongPress(MotionEvent motionEvent) {
                    super.onLongPress(motionEvent);
                    RippleView.this.animateRipple(motionEvent);
                    RippleView.this.sendClickEvent(Boolean.TRUE);
                }

                public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
                    return true;
                }

                public boolean onSingleTapUp(MotionEvent motionEvent) {
                    return true;
                }
            });
            setDrawingCacheEnabled(true);
            setClickable(true);
        }
    }

    /* access modifiers changed from: private */
    public void sendClickEvent(Boolean bool) {
        if (getParent() instanceof AdapterView) {
            AdapterView adapterView = (AdapterView) getParent();
            int positionForView = adapterView.getPositionForView(this);
            long itemIdAtPosition = adapterView.getItemIdAtPosition(positionForView);
            if (bool.booleanValue()) {
                if (adapterView.getOnItemLongClickListener() != null) {
                    adapterView.getOnItemLongClickListener().onItemLongClick(adapterView, this, positionForView, itemIdAtPosition);
                }
            } else if (adapterView.getOnItemClickListener() != null) {
                adapterView.getOnItemClickListener().onItemClick(adapterView, this, positionForView, itemIdAtPosition);
            }
        }
    }

    public void animateRipple(MotionEvent motionEvent) {
        createAnimation(motionEvent.getX(), motionEvent.getY());
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.animationRunning) {
            canvas.save();
            int i11 = this.rippleDuration;
            int i12 = this.timer;
            int i13 = this.frameRate;
            if (i11 <= i12 * i13) {
                this.animationRunning = false;
                this.timer = 0;
                this.durationEmpty = -1;
                this.timerEmpty = 0;
                if (Build.VERSION.SDK_INT != 23) {
                    canvas.restore();
                }
                invalidate();
                OnRippleCompleteListener onRippleCompleteListener = this.onCompletionListener;
                if (onRippleCompleteListener != null) {
                    onRippleCompleteListener.onComplete(this);
                    return;
                }
                return;
            }
            this.canvasHandler.postDelayed(this.runnable, (long) i13);
            if (this.timer == 0) {
                canvas.save();
            }
            canvas.drawCircle(this.f60841x, this.f60842y, this.radiusMax * ((((float) this.timer) * ((float) this.frameRate)) / ((float) this.rippleDuration)), this.paint);
            this.paint.setColor(Color.parseColor("#ffff4444"));
            if (this.rippleType.intValue() == 1 && this.originBitmap != null) {
                int i14 = this.timer;
                int i15 = this.frameRate;
                float f11 = ((float) i14) * ((float) i15);
                int i16 = this.rippleDuration;
                if (f11 / ((float) i16) > 0.4f) {
                    if (this.durationEmpty == -1) {
                        this.durationEmpty = i16 - (i14 * i15);
                    }
                    int i17 = this.timerEmpty + 1;
                    this.timerEmpty = i17;
                    Bitmap circleBitmap = getCircleBitmap((int) (this.radiusMax * ((((float) i17) * ((float) i15)) / ((float) this.durationEmpty))));
                    canvas.drawBitmap(circleBitmap, 0.0f, 0.0f, this.paint);
                    circleBitmap.recycle();
                }
            }
            this.paint.setColor(this.rippleColor);
            if (this.rippleType.intValue() == 1) {
                int i18 = this.frameRate;
                if ((((float) this.timer) * ((float) i18)) / ((float) this.rippleDuration) > 0.6f) {
                    Paint paint2 = this.paint;
                    int i19 = this.rippleAlpha;
                    paint2.setAlpha((int) (((float) i19) - (((float) i19) * ((((float) this.timerEmpty) * ((float) i18)) / ((float) this.durationEmpty)))));
                } else {
                    this.paint.setAlpha(this.rippleAlpha);
                }
            } else {
                Paint paint3 = this.paint;
                int i21 = this.rippleAlpha;
                paint3.setAlpha((int) (((float) i21) - (((float) i21) * ((((float) this.timer) * ((float) this.frameRate)) / ((float) this.rippleDuration)))));
            }
            this.timer++;
        }
    }

    public int getFrameRate() {
        return this.frameRate;
    }

    public int getRippleAlpha() {
        return this.rippleAlpha;
    }

    public int getRippleColor() {
        return this.rippleColor;
    }

    public int getRippleDuration() {
        return this.rippleDuration;
    }

    public int getRipplePadding() {
        return this.ripplePadding;
    }

    public RippleType getRippleType() {
        return RippleType.values()[this.rippleType.intValue()];
    }

    public int getZoomDuration() {
        return this.zoomDuration;
    }

    public float getZoomScale() {
        return this.zoomScale;
    }

    public Boolean isCentered() {
        return this.isCentered;
    }

    public Boolean isZooming() {
        return this.hasToZoom;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        onTouchEvent(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.WIDTH = i11;
        this.HEIGHT = i12;
        float f11 = this.zoomScale;
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, f11, 1.0f, f11, (float) (i11 / 2), (float) (i12 / 2));
        this.scaleAnimation = scaleAnimation2;
        scaleAnimation2.setDuration((long) this.zoomDuration);
        this.scaleAnimation.setRepeatMode(2);
        this.scaleAnimation.setRepeatCount(1);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gestureDetector.onTouchEvent(motionEvent)) {
            animateRipple(motionEvent);
            sendClickEvent(Boolean.FALSE);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCentered(Boolean bool) {
        this.isCentered = bool;
    }

    public void setFrameRate(int i11) {
        this.frameRate = i11;
    }

    public void setOnRippleCompleteListener(OnRippleCompleteListener onRippleCompleteListener) {
        this.onCompletionListener = onRippleCompleteListener;
    }

    public void setRippleAlpha(int i11) {
        this.rippleAlpha = i11;
    }

    @ColorRes
    public void setRippleColor(int i11) {
        this.rippleColor = getResources().getColor(i11);
    }

    public void setRippleDuration(int i11) {
        this.rippleDuration = i11;
    }

    public void setRipplePadding(int i11) {
        this.ripplePadding = i11;
    }

    public void setRippleType(RippleType rippleType2) {
        this.rippleType = Integer.valueOf(rippleType2.ordinal());
    }

    public void setZoomDuration(int i11) {
        this.zoomDuration = i11;
    }

    public void setZoomScale(float f11) {
        this.zoomScale = f11;
    }

    public void setZooming(Boolean bool) {
        this.hasToZoom = bool;
    }

    public void animateRipple(float f11, float f12) {
        createAnimation(f11, f12);
    }

    public RippleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public RippleView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(context, attributeSet);
    }
}
