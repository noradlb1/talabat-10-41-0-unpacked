package com.instabug.featuresrequest.ui.custom;

import android.annotation.SuppressLint;
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
import android.widget.LinearLayout;
import androidx.annotation.RequiresApi;
import com.instabug.featuresrequest.R;

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class IbFrRippleView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Runnable f46660a = new a();

    /* renamed from: b  reason: collision with root package name */
    private int f46661b;

    /* renamed from: c  reason: collision with root package name */
    private int f46662c;

    /* renamed from: d  reason: collision with root package name */
    private int f46663d = 10;

    /* renamed from: e  reason: collision with root package name */
    private int f46664e = 200;

    /* renamed from: f  reason: collision with root package name */
    private int f46665f = 90;

    /* renamed from: g  reason: collision with root package name */
    private Handler f46666g;

    /* renamed from: h  reason: collision with root package name */
    private float f46667h = 0.0f;

    /* renamed from: i  reason: collision with root package name */
    private boolean f46668i = false;

    /* renamed from: j  reason: collision with root package name */
    private int f46669j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f46670k = 0;

    /* renamed from: l  reason: collision with root package name */
    private int f46671l = -1;

    /* renamed from: m  reason: collision with root package name */
    private float f46672m = -1.0f;

    /* renamed from: n  reason: collision with root package name */
    private float f46673n = -1.0f;

    /* renamed from: o  reason: collision with root package name */
    private int f46674o = 200;

    /* renamed from: p  reason: collision with root package name */
    private float f46675p;

    /* renamed from: q  reason: collision with root package name */
    private ScaleAnimation f46676q;

    /* renamed from: r  reason: collision with root package name */
    private Boolean f46677r;

    /* renamed from: s  reason: collision with root package name */
    private Boolean f46678s;

    /* renamed from: t  reason: collision with root package name */
    private Integer f46679t = 2;

    /* renamed from: u  reason: collision with root package name */
    private Paint f46680u;

    /* renamed from: v  reason: collision with root package name */
    private Bitmap f46681v;

    /* renamed from: w  reason: collision with root package name */
    private int f46682w;

    /* renamed from: x  reason: collision with root package name */
    private int f46683x;

    /* renamed from: y  reason: collision with root package name */
    private GestureDetector f46684y;

    /* renamed from: z  reason: collision with root package name */
    private c f46685z;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            IbFrRippleView.this.invalidate();
        }
    }

    public class b extends GestureDetector.SimpleOnGestureListener {
        public b() {
        }

        public void onLongPress(MotionEvent motionEvent) {
            super.onLongPress(motionEvent);
            IbFrRippleView.this.a(motionEvent);
            IbFrRippleView.this.a(Boolean.TRUE);
        }

        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return true;
        }

        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return true;
        }
    }

    public interface c {
        void a(IbFrRippleView ibFrRippleView);
    }

    public enum d {
        SIMPLE(0),
        DOUBLE(1),
        RECTANGLE(2);

        private d(int i11) {
        }
    }

    public IbFrRippleView(Context context) {
        super(context);
    }

    public IbFrRippleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    @RequiresApi(api = 11)
    public IbFrRippleView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context, attributeSet);
    }

    private Bitmap a(int i11) {
        Bitmap createBitmap = Bitmap.createBitmap(this.f46681v.getWidth(), this.f46681v.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        float f11 = this.f46672m;
        float f12 = (float) i11;
        float f13 = this.f46673n;
        Rect rect = new Rect((int) (f11 - f12), (int) (f13 - f12), (int) (f11 + f12), (int) (f13 + f12));
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        canvas.drawCircle(this.f46672m, this.f46673n, f12, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(this.f46681v, rect, rect, paint);
        return createBitmap;
    }

    private void a(float f11, float f12) {
        if (isEnabled() && !this.f46668i) {
            if (this.f46677r.booleanValue()) {
                startAnimation(this.f46676q);
            }
            this.f46667h = (float) Math.max(this.f46661b, this.f46662c);
            if (this.f46679t.intValue() != 2) {
                this.f46667h /= 2.0f;
            }
            this.f46667h -= (float) this.f46683x;
            if (this.f46678s.booleanValue() || this.f46679t.intValue() == 1) {
                this.f46672m = ((float) getMeasuredWidth()) / 2.0f;
                this.f46673n = ((float) getMeasuredHeight()) / 2.0f;
            } else {
                this.f46672m = f11;
                this.f46673n = f12;
            }
            this.f46668i = true;
            if (this.f46679t.intValue() == 1 && this.f46681v == null) {
                this.f46681v = getDrawingCache(true);
            }
            invalidate();
        }
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (!isInEditMode()) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IbFrRippleView);
            this.f46682w = obtainStyledAttributes.getColor(R.styleable.IbFrRippleView_ib_fr_rv_color, getResources().getColor(R.color.ib_fr_ripple_color));
            this.f46679t = Integer.valueOf(obtainStyledAttributes.getInt(R.styleable.IbFrRippleView_ib_fr_rv_type, 2));
            this.f46677r = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.IbFrRippleView_ib_fr_rv_zoom, true));
            this.f46678s = Boolean.valueOf(obtainStyledAttributes.getBoolean(R.styleable.IbFrRippleView_ib_fr_rv_centered, true));
            this.f46664e = obtainStyledAttributes.getInteger(R.styleable.IbFrRippleView_ib_fr_rv_rippleDuration, 200);
            this.f46663d = obtainStyledAttributes.getInteger(R.styleable.IbFrRippleView_ib_fr_rv_framerate, this.f46663d);
            this.f46665f = obtainStyledAttributes.getInteger(R.styleable.IbFrRippleView_ib_fr_rv_alpha, this.f46665f);
            this.f46683x = obtainStyledAttributes.getDimensionPixelSize(R.styleable.IbFrRippleView_ib_fr_rv_ripplePadding, 0);
            this.f46666g = new Handler();
            this.f46675p = obtainStyledAttributes.getFloat(R.styleable.IbFrRippleView_ib_fr_rv_zoomScale, 1.03f);
            this.f46674o = obtainStyledAttributes.getInt(R.styleable.IbFrRippleView_ib_fr_rv_zoomDuration, 200);
            obtainStyledAttributes.recycle();
            Paint paint = new Paint();
            this.f46680u = paint;
            paint.setAntiAlias(true);
            this.f46680u.setStyle(Paint.Style.FILL);
            this.f46680u.setColor(this.f46682w);
            this.f46680u.setAlpha(this.f46665f);
            setWillNotDraw(false);
            this.f46684y = new GestureDetector(context, new b());
            setDrawingCacheEnabled(true);
            setClickable(true);
        }
    }

    /* access modifiers changed from: private */
    public void a(Boolean bool) {
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

    public void a(MotionEvent motionEvent) {
        a(motionEvent.getX(), motionEvent.getY());
    }

    public void draw(Canvas canvas) {
        Paint paint;
        int i11;
        super.draw(canvas);
        if (this.f46668i) {
            canvas.save();
            int i12 = this.f46664e;
            int i13 = this.f46669j;
            int i14 = this.f46663d;
            if (i12 <= i13 * i14) {
                this.f46668i = false;
                this.f46669j = 0;
                this.f46671l = -1;
                this.f46670k = 0;
                if (Build.VERSION.SDK_INT != 23) {
                    canvas.restore();
                }
                invalidate();
                c cVar = this.f46685z;
                if (cVar != null) {
                    cVar.a(this);
                    return;
                }
                return;
            }
            this.f46666g.postDelayed(this.f46660a, (long) i14);
            if (this.f46669j == 0) {
                canvas.save();
            }
            canvas.drawCircle(this.f46672m, this.f46673n, this.f46667h * ((((float) this.f46669j) * ((float) this.f46663d)) / ((float) this.f46664e)), this.f46680u);
            this.f46680u.setColor(Color.parseColor("#ffff4444"));
            if (this.f46679t.intValue() == 1 && this.f46681v != null) {
                int i15 = this.f46669j;
                int i16 = this.f46663d;
                float f11 = (float) i16;
                int i17 = this.f46664e;
                if ((((float) i15) * f11) / ((float) i17) > 0.4f) {
                    if (this.f46671l == -1) {
                        this.f46671l = i17 - (i15 * i16);
                    }
                    int i18 = this.f46670k + 1;
                    this.f46670k = i18;
                    Bitmap a11 = a((int) (this.f46667h * ((((float) i18) * f11) / ((float) this.f46671l))));
                    canvas.drawBitmap(a11, 0.0f, 0.0f, this.f46680u);
                    a11.recycle();
                }
            }
            this.f46680u.setColor(this.f46682w);
            if (this.f46679t.intValue() == 1) {
                float f12 = (float) this.f46663d;
                if ((((float) this.f46669j) * f12) / ((float) this.f46664e) > 0.6f) {
                    paint = this.f46680u;
                    float f13 = (float) this.f46665f;
                    i11 = (int) (f13 - (((((float) this.f46670k) * f12) / ((float) this.f46671l)) * f13));
                } else {
                    paint = this.f46680u;
                    i11 = this.f46665f;
                }
            } else {
                paint = this.f46680u;
                float f14 = (float) this.f46665f;
                i11 = (int) (f14 - (((((float) this.f46669j) * ((float) this.f46663d)) / ((float) this.f46664e)) * f14));
            }
            paint.setAlpha(i11);
            this.f46669j++;
        }
    }

    public void drawableStateChanged() {
        super.drawableStateChanged();
    }

    public int getFrameRate() {
        return this.f46663d;
    }

    public int getRippleAlpha() {
        return this.f46665f;
    }

    public int getRippleColor() {
        return this.f46682w;
    }

    public int getRippleDuration() {
        return this.f46664e;
    }

    public int getRipplePadding() {
        return this.f46683x;
    }

    public d getRippleType() {
        return d.values()[this.f46679t.intValue()];
    }

    public int getZoomDuration() {
        return this.f46674o;
    }

    public float getZoomScale() {
        return this.f46675p;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        onTouchEvent(motionEvent);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        this.f46661b = i11;
        this.f46662c = i12;
        float f11 = this.f46675p;
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, f11, 1.0f, f11, ((float) i11) / 2.0f, ((float) i12) / 2.0f);
        this.f46676q = scaleAnimation;
        scaleAnimation.setDuration((long) this.f46674o);
        this.f46676q.setRepeatMode(2);
        this.f46676q.setRepeatCount(1);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.f46684y.onTouchEvent(motionEvent)) {
            a(motionEvent);
            a(Boolean.FALSE);
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setCentered(Boolean bool) {
        this.f46678s = bool;
    }

    public void setFrameRate(int i11) {
        this.f46663d = i11;
    }

    public void setOnRippleCompleteListener(c cVar) {
        this.f46685z = cVar;
    }

    public void setRippleAlpha(int i11) {
        this.f46665f = i11;
    }

    public void setRippleColor(int i11) {
        this.f46682w = i11;
    }

    public void setRippleDuration(int i11) {
        this.f46664e = i11;
    }

    public void setRipplePadding(int i11) {
        this.f46683x = i11;
    }

    public void setRippleType(d dVar) {
        this.f46679t = Integer.valueOf(dVar.ordinal());
    }

    public void setZoomDuration(int i11) {
        this.f46674o = i11;
    }

    public void setZoomScale(float f11) {
        this.f46675p = f11;
    }

    public void setZooming(Boolean bool) {
        this.f46677r = bool;
    }
}
