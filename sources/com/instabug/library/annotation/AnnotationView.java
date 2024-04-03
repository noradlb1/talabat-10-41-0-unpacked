package com.instabug.library.annotation;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import com.instabug.library.util.OrientationUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@SuppressLint({"LI_LAZY_INIT_UPDATE_STATIC", "ST_WRITE_TO_STATIC_FROM_INSTANCE_METHOD"})
public class AnnotationView extends AppCompatImageView {
    /* access modifiers changed from: private */
    @Nullable
    public static volatile e G;
    @Nullable
    private h A;
    private boolean B;
    @Nullable
    private com.instabug.library.annotation.shape.g C;
    @Nullable
    private d D;
    private volatile boolean E;
    public int F;

    /* renamed from: a  reason: collision with root package name */
    private final GestureDetector f34041a;
    @Nullable

    /* renamed from: b  reason: collision with root package name */
    private Path f34042b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private List f34043c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f34044d;

    /* renamed from: e  reason: collision with root package name */
    private int f34045e;

    /* renamed from: f  reason: collision with root package name */
    private final LinkedHashMap f34046f;

    /* renamed from: g  reason: collision with root package name */
    private float f34047g;

    /* renamed from: h  reason: collision with root package name */
    private float f34048h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f34049i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private volatile Drawable f34050j;

    /* renamed from: k  reason: collision with root package name */
    private final PointF[] f34051k;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private Bitmap f34052l;
    @Nullable

    /* renamed from: m  reason: collision with root package name */
    private Bitmap f34053m;

    /* renamed from: n  reason: collision with root package name */
    private int f34054n;

    /* renamed from: o  reason: collision with root package name */
    private volatile boolean f34055o;

    /* renamed from: p  reason: collision with root package name */
    private final a f34056p;

    /* renamed from: q  reason: collision with root package name */
    private final a f34057q;

    /* renamed from: r  reason: collision with root package name */
    private final a f34058r;

    /* renamed from: s  reason: collision with root package name */
    private final a f34059s;

    /* renamed from: t  reason: collision with root package name */
    private final PointF f34060t;

    /* renamed from: u  reason: collision with root package name */
    private volatile b f34061u;

    /* renamed from: v  reason: collision with root package name */
    private c f34062v;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: w  reason: collision with root package name */
    public volatile f f34063w;

    /* renamed from: x  reason: collision with root package name */
    private com.instabug.library.annotation.utility.a f34064x;
    @Nullable

    /* renamed from: y  reason: collision with root package name */
    private volatile f f34065y;
    @Nullable

    /* renamed from: z  reason: collision with root package name */
    private g f34066z;

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f34067a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f34068b;

        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|19|20|21|22|23|24|26) */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0064 */
        static {
            /*
                com.instabug.library.annotation.AnnotationView$b[] r0 = com.instabug.library.annotation.AnnotationView.b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f34068b = r0
                r1 = 1
                com.instabug.library.annotation.AnnotationView$b r2 = com.instabug.library.annotation.AnnotationView.b.DRAG     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f34068b     // Catch:{ NoSuchFieldError -> 0x001d }
                com.instabug.library.annotation.AnnotationView$b r3 = com.instabug.library.annotation.AnnotationView.b.RESIZE_BY_BOTTOM_RIGHT_BUTTON     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f34068b     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.instabug.library.annotation.AnnotationView$b r4 = com.instabug.library.annotation.AnnotationView.b.RESIZE_BY_BOTTOM_LEFT_BUTTON     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r3 = f34068b     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.instabug.library.annotation.AnnotationView$b r4 = com.instabug.library.annotation.AnnotationView.b.RESIZE_BY_TOP_LEFT_BUTTON     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r5 = 4
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r3 = f34068b     // Catch:{ NoSuchFieldError -> 0x003e }
                com.instabug.library.annotation.AnnotationView$b r4 = com.instabug.library.annotation.AnnotationView.b.RESIZE_BY_TOP_RIGHT_BUTTON     // Catch:{ NoSuchFieldError -> 0x003e }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5 = 5
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r3 = f34068b     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.instabug.library.annotation.AnnotationView$b r4 = com.instabug.library.annotation.AnnotationView.b.DRAW     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r5 = 6
                r3[r4] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                com.instabug.library.annotation.AnnotationView$c[] r3 = com.instabug.library.annotation.AnnotationView.c.values()
                int r3 = r3.length
                int[] r3 = new int[r3]
                f34067a = r3
                com.instabug.library.annotation.AnnotationView$c r4 = com.instabug.library.annotation.AnnotationView.c.DRAW_RECT     // Catch:{ NoSuchFieldError -> 0x005a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r3[r4] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r1 = f34067a     // Catch:{ NoSuchFieldError -> 0x0064 }
                com.instabug.library.annotation.AnnotationView$c r3 = com.instabug.library.annotation.AnnotationView.c.DRAW_CIRCLE     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r1[r3] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = f34067a     // Catch:{ NoSuchFieldError -> 0x006e }
                com.instabug.library.annotation.AnnotationView$c r1 = com.instabug.library.annotation.AnnotationView.c.DRAW_BLUR     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.annotation.AnnotationView.a.<clinit>():void");
        }
    }

    public enum b {
        NONE,
        DRAG,
        RESIZE_BY_TOP_LEFT_BUTTON,
        RESIZE_BY_TOP_RIGHT_BUTTON,
        RESIZE_BY_BOTTOM_RIGHT_BUTTON,
        RESIZE_BY_BOTTOM_LEFT_BUTTON,
        DRAW
    }

    public enum c {
        NONE,
        DRAW_PATH,
        DRAW_RECT,
        DRAW_CIRCLE,
        DRAW_BLUR,
        DRAW_ZOOM
    }

    public class d extends GestureDetector.SimpleOnGestureListener {
        private d() {
        }

        public boolean onDoubleTap(MotionEvent motionEvent) {
            f g11 = AnnotationView.this.f34063w;
            e e11 = AnnotationView.G;
            if (!(e11 == null || g11 == null)) {
                g11.d(AnnotationView.G);
                e11.a(false);
                if (e11.b() instanceof com.instabug.library.annotation.shape.h) {
                    AnnotationView annotationView = AnnotationView.this;
                    annotationView.F--;
                    annotationView.c();
                }
                e unused = AnnotationView.G = null;
                AnnotationView.this.i();
                AnnotationView.this.invalidate();
            }
            return true;
        }

        public /* synthetic */ d(AnnotationView annotationView, a aVar) {
            this();
        }
    }

    public enum e {
        HIGH,
        LOW
    }

    public interface f {
        void a();
    }

    public interface g {
        void a(boolean z11);
    }

    public interface h {
        void a(Path path, Path path2);
    }

    public AnnotationView(Context context) {
        this(context, (AttributeSet) null);
    }

    private void a(float f11, float f12) {
        for (PointF pointF : this.f34051k) {
            pointF.x = f11;
            pointF.y = f12;
        }
    }

    private void b(float f11, float f12) {
        float abs = Math.abs(f11 - this.f34047g);
        float abs2 = Math.abs(f12 - this.f34048h);
        if (abs >= 8.0f || abs2 >= 8.0f) {
            Path path = this.f34042b;
            if (path != null) {
                float f13 = this.f34047g;
                float f14 = this.f34048h;
                path.quadTo(f13, f14, (f11 + f13) / 2.0f, (f12 + f14) / 2.0f);
            }
            this.f34047g = f11;
            this.f34048h = f12;
            List list = this.f34043c;
            if (list != null) {
                list.add(new PointF(f11, f12));
            }
        }
    }

    private void c(float f11, float f12) {
        this.f34042b = new Path();
        this.f34043c = new ArrayList();
        this.f34046f.put(this.f34042b, Integer.valueOf(this.f34045e));
        this.f34042b.reset();
        this.f34042b.moveTo(f11, f12);
        this.f34043c.add(new PointF(f11, f12));
        this.f34047g = f11;
        this.f34048h = f12;
        a(f11, f12);
    }

    private void d() {
        Paint paint = new Paint();
        this.f34044d = paint;
        paint.setAntiAlias(true);
        this.f34044d.setDither(true);
        this.f34045e = -65536;
        this.f34044d.setColor(-65536);
        this.f34044d.setStyle(Paint.Style.STROKE);
        this.f34044d.setStrokeJoin(Paint.Join.ROUND);
        this.f34044d.setStrokeCap(Paint.Cap.ROUND);
        this.f34044d.setStrokeWidth(getContext().getResources().getDisplayMetrics().density * 4.0f);
    }

    @Nullable
    private Bitmap getOriginalBitmap() {
        if (this.f34052l == null) {
            this.f34052l = f();
        }
        return this.f34052l;
    }

    @Nullable
    private Bitmap getScaledBitmap() {
        Bitmap bitmap;
        if (getWidth() <= 0 || getHeight() <= 0) {
            return null;
        }
        if (this.f34053m == null && (bitmap = this.f34052l) != null) {
            this.f34053m = Bitmap.createScaledBitmap(bitmap, getWidth(), getHeight(), true);
        }
        return this.f34053m;
    }

    private f getScaledDrawables() {
        f fVar;
        this.f34064x.b((float) getHeight());
        this.f34064x.c((float) getWidth());
        if (this.f34063w == null) {
            fVar = new f();
        } else {
            fVar = this.f34063w;
        }
        if (fVar != null) {
            for (e eVar : fVar.a()) {
                d dVar = new d();
                dVar.set(eVar.f34114d.left * this.f34064x.b(), eVar.f34114d.top * this.f34064x.a(), eVar.f34114d.right * this.f34064x.b(), eVar.f34114d.bottom * this.f34064x.a());
                if (eVar.b() instanceof com.instabug.library.annotation.shape.a) {
                    ((com.instabug.library.annotation.shape.a) eVar.b()).c(dVar);
                }
                dVar.a(eVar.f34114d.f());
                eVar.c(new d(dVar));
            }
        }
        this.f34063w = fVar;
        return this.f34063w;
    }

    @Nullable
    private e getSelectedMarkUpDrawable() {
        f fVar = this.f34063w;
        if (fVar == null) {
            return null;
        }
        for (int b11 = fVar.b() - 1; b11 >= 0; b11--) {
            e a11 = fVar.a(b11);
            if (a11.a(this.f34060t)) {
                return a11;
            }
        }
        return null;
    }

    public static void setSelectedMarkUpDrawable(@Nullable e eVar) {
        G = eVar;
    }

    @Nullable
    public Bitmap f() {
        if (getWidth() <= 0 || getHeight() <= 0 || this.f34063w == null) {
            return null;
        }
        return a(this.f34063w.b());
    }

    public c getDrawingMode() {
        return this.f34062v;
    }

    public synchronized void j() {
        com.instabug.library.annotation.shape.g gVar;
        d dVar;
        if (!(G == null || (gVar = this.C) == null || (dVar = this.D) == null)) {
            a(gVar, dVar);
            invalidate();
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        OrientationUtils.lockScreenOrientation(getContext());
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f34053m = null;
        this.E = true;
    }

    public synchronized void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f34063w = null;
        G = null;
        OrientationUtils.unlockOrientation(getContext());
    }

    public synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Drawable drawable = this.f34050j;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        f fVar = this.f34063w;
        if (!this.f34055o && fVar != null) {
            this.f34054n = fVar.a().size();
        }
        if (fVar != null) {
            for (e eVar : fVar.a()) {
                b(eVar);
                eVar.c(canvas);
            }
        }
        e eVar2 = G;
        if (!this.f34055o && eVar2 != null) {
            if (this.B) {
                eVar2.b(canvas);
            }
            eVar2.a(canvas, this.f34056p, this.f34059s, this.f34057q, this.f34058r);
        }
        if (!this.f34046f.isEmpty()) {
            Iterator it = this.f34046f.entrySet().iterator();
            do {
                Map.Entry entry = (Map.Entry) it.next();
                this.f34044d.setColor(((Integer) entry.getValue()).intValue());
                canvas.drawPath((Path) entry.getKey(), this.f34044d);
            } while (it.hasNext());
        }
        if (this.E && eVar2 != null) {
            this.E = false;
            if (!eVar2.f34112b.b()) {
                a(eVar2.f34114d);
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        super.onMeasure(i11, i12);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        setMeasuredDimension(((measuredWidth - getPaddingLeft()) - getPaddingRight()) + getPaddingLeft() + getPaddingRight(), ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + getPaddingTop() + getPaddingBottom());
    }

    @SuppressLint({"ERADICATE_FIELD_NOT_NULLABLE"})
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f34064x = (com.instabug.library.annotation.utility.a) bundle.getSerializable("aspectRatioCalculator");
            this.f34054n = bundle.getInt("drawingLevel");
            this.F = bundle.getInt("magnifiersCount");
            this.f34062v = (c) bundle.getSerializable("drawingMode");
            parcelable = bundle.getParcelable("superState");
        }
        if (parcelable != null) {
            super.onRestoreInstanceState(parcelable);
        }
    }

    @Nullable
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        bundle.putSerializable("aspectRatioCalculator", this.f34064x);
        bundle.putSerializable("drawingMode", getDrawingMode());
        bundle.putInt("drawingLevel", this.f34054n);
        bundle.putInt("magnifiersCount", this.F);
        return bundle;
    }

    public synchronized void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        getScaledDrawables();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01a9, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean onTouchEvent(android.view.MotionEvent r11) {
        /*
            r10 = this;
            monitor-enter(r10)
            android.view.GestureDetector r0 = r10.f34041a     // Catch:{ all -> 0x01aa }
            boolean r0 = r0.onTouchEvent(r11)     // Catch:{ all -> 0x01aa }
            r1 = 1
            if (r0 == 0) goto L_0x000c
            monitor-exit(r10)
            return r1
        L_0x000c:
            int r0 = androidx.core.view.MotionEventCompat.getActionMasked(r11)     // Catch:{ all -> 0x01aa }
            float r2 = r11.getX()     // Catch:{ all -> 0x01aa }
            float r3 = r11.getY()     // Catch:{ all -> 0x01aa }
            r4 = 2
            r5 = 0
            if (r0 == 0) goto L_0x0071
            if (r0 == r1) goto L_0x002d
            if (r0 == r4) goto L_0x0022
            goto L_0x0157
        L_0x0022:
            r10.a((android.view.MotionEvent) r11)     // Catch:{ all -> 0x01aa }
            r10.i()     // Catch:{ all -> 0x01aa }
            r10.invalidate()     // Catch:{ all -> 0x01aa }
            goto L_0x0157
        L_0x002d:
            r10.B = r5     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.f r0 = r10.f34063w     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.e r6 = G     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.AnnotationView$b r7 = r10.f34061u     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.AnnotationView$b r8 = com.instabug.library.annotation.AnnotationView.b.DRAG     // Catch:{ all -> 0x01aa }
            if (r7 == r8) goto L_0x0051
            com.instabug.library.annotation.AnnotationView$b r7 = r10.f34061u     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.AnnotationView$b r8 = com.instabug.library.annotation.AnnotationView.b.RESIZE_BY_TOP_LEFT_BUTTON     // Catch:{ all -> 0x01aa }
            if (r7 == r8) goto L_0x0051
            com.instabug.library.annotation.AnnotationView$b r7 = r10.f34061u     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.AnnotationView$b r8 = com.instabug.library.annotation.AnnotationView.b.RESIZE_BY_TOP_RIGHT_BUTTON     // Catch:{ all -> 0x01aa }
            if (r7 == r8) goto L_0x0051
            com.instabug.library.annotation.AnnotationView$b r7 = r10.f34061u     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.AnnotationView$b r8 = com.instabug.library.annotation.AnnotationView.b.RESIZE_BY_BOTTOM_RIGHT_BUTTON     // Catch:{ all -> 0x01aa }
            if (r7 == r8) goto L_0x0051
            com.instabug.library.annotation.AnnotationView$b r7 = r10.f34061u     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.AnnotationView$b r8 = com.instabug.library.annotation.AnnotationView.b.RESIZE_BY_BOTTOM_LEFT_BUTTON     // Catch:{ all -> 0x01aa }
            if (r7 != r8) goto L_0x005d
        L_0x0051:
            if (r6 == 0) goto L_0x005d
            if (r0 == 0) goto L_0x005d
            com.instabug.library.annotation.e r7 = G     // Catch:{ all -> 0x01aa }
            r0.d(r7)     // Catch:{ all -> 0x01aa }
            r6.d()     // Catch:{ all -> 0x01aa }
        L_0x005d:
            android.graphics.PointF r0 = r10.f34060t     // Catch:{ all -> 0x01aa }
            r0.set(r2, r3)     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.AnnotationView$c r0 = r10.f34062v     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.AnnotationView$c r6 = com.instabug.library.annotation.AnnotationView.c.DRAW_PATH     // Catch:{ all -> 0x01aa }
            if (r0 == r6) goto L_0x0157
            com.instabug.library.annotation.AnnotationView$b r0 = com.instabug.library.annotation.AnnotationView.b.NONE     // Catch:{ all -> 0x01aa }
            r10.f34061u = r0     // Catch:{ all -> 0x01aa }
            r10.invalidate()     // Catch:{ all -> 0x01aa }
            goto L_0x0157
        L_0x0071:
            r10.B = r1     // Catch:{ all -> 0x01aa }
            r10.getOriginalBitmap()     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.AnnotationView$f r0 = r10.f34065y     // Catch:{ all -> 0x01aa }
            if (r0 == 0) goto L_0x007d
            r0.a()     // Catch:{ all -> 0x01aa }
        L_0x007d:
            android.graphics.PointF r0 = r10.f34060t     // Catch:{ all -> 0x01aa }
            r0.set(r2, r3)     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.a r0 = r10.f34057q     // Catch:{ all -> 0x01aa }
            android.graphics.PointF r6 = r10.f34060t     // Catch:{ all -> 0x01aa }
            boolean r0 = r0.a((android.graphics.PointF) r6)     // Catch:{ all -> 0x01aa }
            if (r0 == 0) goto L_0x0096
            com.instabug.library.annotation.e r0 = G     // Catch:{ all -> 0x01aa }
            if (r0 == 0) goto L_0x0096
            com.instabug.library.annotation.AnnotationView$b r0 = com.instabug.library.annotation.AnnotationView.b.RESIZE_BY_BOTTOM_RIGHT_BUTTON     // Catch:{ all -> 0x01aa }
            r10.f34061u = r0     // Catch:{ all -> 0x01aa }
            goto L_0x0151
        L_0x0096:
            com.instabug.library.annotation.a r0 = r10.f34058r     // Catch:{ all -> 0x01aa }
            android.graphics.PointF r6 = r10.f34060t     // Catch:{ all -> 0x01aa }
            boolean r0 = r0.a((android.graphics.PointF) r6)     // Catch:{ all -> 0x01aa }
            if (r0 == 0) goto L_0x00aa
            com.instabug.library.annotation.e r0 = G     // Catch:{ all -> 0x01aa }
            if (r0 == 0) goto L_0x00aa
            com.instabug.library.annotation.AnnotationView$b r0 = com.instabug.library.annotation.AnnotationView.b.RESIZE_BY_BOTTOM_LEFT_BUTTON     // Catch:{ all -> 0x01aa }
            r10.f34061u = r0     // Catch:{ all -> 0x01aa }
            goto L_0x0151
        L_0x00aa:
            com.instabug.library.annotation.a r0 = r10.f34056p     // Catch:{ all -> 0x01aa }
            android.graphics.PointF r6 = r10.f34060t     // Catch:{ all -> 0x01aa }
            boolean r0 = r0.a((android.graphics.PointF) r6)     // Catch:{ all -> 0x01aa }
            if (r0 == 0) goto L_0x00be
            com.instabug.library.annotation.e r0 = G     // Catch:{ all -> 0x01aa }
            if (r0 == 0) goto L_0x00be
            com.instabug.library.annotation.AnnotationView$b r0 = com.instabug.library.annotation.AnnotationView.b.RESIZE_BY_TOP_LEFT_BUTTON     // Catch:{ all -> 0x01aa }
            r10.f34061u = r0     // Catch:{ all -> 0x01aa }
            goto L_0x0151
        L_0x00be:
            com.instabug.library.annotation.a r0 = r10.f34059s     // Catch:{ all -> 0x01aa }
            android.graphics.PointF r6 = r10.f34060t     // Catch:{ all -> 0x01aa }
            boolean r0 = r0.a((android.graphics.PointF) r6)     // Catch:{ all -> 0x01aa }
            if (r0 == 0) goto L_0x00d2
            com.instabug.library.annotation.e r0 = G     // Catch:{ all -> 0x01aa }
            if (r0 == 0) goto L_0x00d2
            com.instabug.library.annotation.AnnotationView$b r0 = com.instabug.library.annotation.AnnotationView.b.RESIZE_BY_TOP_RIGHT_BUTTON     // Catch:{ all -> 0x01aa }
            r10.f34061u = r0     // Catch:{ all -> 0x01aa }
            goto L_0x0151
        L_0x00d2:
            com.instabug.library.annotation.e r0 = r10.getSelectedMarkUpDrawable()     // Catch:{ all -> 0x01aa }
            G = r0     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.f r0 = r10.f34063w     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.e r6 = G     // Catch:{ all -> 0x01aa }
            if (r6 != 0) goto L_0x014d
            if (r0 == 0) goto L_0x014d
            int[] r6 = com.instabug.library.annotation.AnnotationView.a.f34067a     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.AnnotationView$c r7 = r10.f34062v     // Catch:{ all -> 0x01aa }
            int r7 = r7.ordinal()     // Catch:{ all -> 0x01aa }
            r6 = r6[r7]     // Catch:{ all -> 0x01aa }
            if (r6 == r1) goto L_0x012c
            if (r6 == r4) goto L_0x010f
            r7 = 3
            if (r6 == r7) goto L_0x00f2
            goto L_0x0148
        L_0x00f2:
            com.instabug.library.annotation.e r6 = new com.instabug.library.annotation.e     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.shape.b r7 = new com.instabug.library.annotation.shape.b     // Catch:{ all -> 0x01aa }
            android.graphics.Bitmap r8 = r10.getOriginalBitmap()     // Catch:{ all -> 0x01aa }
            android.content.Context r9 = r10.getContext()     // Catch:{ all -> 0x01aa }
            r7.<init>(r8, r9)     // Catch:{ all -> 0x01aa }
            r6.<init>(r7)     // Catch:{ all -> 0x01aa }
            G = r6     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.e r6 = G     // Catch:{ all -> 0x01aa }
            r0.a((com.instabug.library.annotation.e) r6)     // Catch:{ all -> 0x01aa }
            r10.invalidate()     // Catch:{ all -> 0x01aa }
            goto L_0x0148
        L_0x010f:
            com.instabug.library.annotation.e r6 = new com.instabug.library.annotation.e     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.shape.d r7 = new com.instabug.library.annotation.shape.d     // Catch:{ all -> 0x01aa }
            int r8 = r10.f34045e     // Catch:{ all -> 0x01aa }
            android.graphics.Paint r9 = r10.f34044d     // Catch:{ all -> 0x01aa }
            float r9 = r9.getStrokeWidth()     // Catch:{ all -> 0x01aa }
            r7.<init>(r8, r9, r5)     // Catch:{ all -> 0x01aa }
            r6.<init>(r7)     // Catch:{ all -> 0x01aa }
            G = r6     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.e r6 = G     // Catch:{ all -> 0x01aa }
            r0.b(r6)     // Catch:{ all -> 0x01aa }
            r10.invalidate()     // Catch:{ all -> 0x01aa }
            goto L_0x0148
        L_0x012c:
            com.instabug.library.annotation.e r6 = new com.instabug.library.annotation.e     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.shape.f r7 = new com.instabug.library.annotation.shape.f     // Catch:{ all -> 0x01aa }
            int r8 = r10.f34045e     // Catch:{ all -> 0x01aa }
            android.graphics.Paint r9 = r10.f34044d     // Catch:{ all -> 0x01aa }
            float r9 = r9.getStrokeWidth()     // Catch:{ all -> 0x01aa }
            r7.<init>(r8, r9, r5)     // Catch:{ all -> 0x01aa }
            r6.<init>(r7)     // Catch:{ all -> 0x01aa }
            G = r6     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.e r6 = G     // Catch:{ all -> 0x01aa }
            r0.b(r6)     // Catch:{ all -> 0x01aa }
            r10.invalidate()     // Catch:{ all -> 0x01aa }
        L_0x0148:
            com.instabug.library.annotation.AnnotationView$b r0 = com.instabug.library.annotation.AnnotationView.b.DRAW     // Catch:{ all -> 0x01aa }
            r10.f34061u = r0     // Catch:{ all -> 0x01aa }
            goto L_0x0151
        L_0x014d:
            com.instabug.library.annotation.AnnotationView$b r0 = com.instabug.library.annotation.AnnotationView.b.DRAG     // Catch:{ all -> 0x01aa }
            r10.f34061u = r0     // Catch:{ all -> 0x01aa }
        L_0x0151:
            r10.i()     // Catch:{ all -> 0x01aa }
            r10.invalidate()     // Catch:{ all -> 0x01aa }
        L_0x0157:
            com.instabug.library.annotation.AnnotationView$b r0 = r10.f34061u     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.AnnotationView$b r6 = com.instabug.library.annotation.AnnotationView.b.RESIZE_BY_TOP_LEFT_BUTTON     // Catch:{ all -> 0x01aa }
            if (r0 == r6) goto L_0x01a8
            com.instabug.library.annotation.AnnotationView$b r0 = r10.f34061u     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.AnnotationView$b r6 = com.instabug.library.annotation.AnnotationView.b.RESIZE_BY_TOP_RIGHT_BUTTON     // Catch:{ all -> 0x01aa }
            if (r0 == r6) goto L_0x01a8
            com.instabug.library.annotation.AnnotationView$b r0 = r10.f34061u     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.AnnotationView$b r6 = com.instabug.library.annotation.AnnotationView.b.RESIZE_BY_BOTTOM_RIGHT_BUTTON     // Catch:{ all -> 0x01aa }
            if (r0 == r6) goto L_0x01a8
            com.instabug.library.annotation.AnnotationView$b r0 = r10.f34061u     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.AnnotationView$b r6 = com.instabug.library.annotation.AnnotationView.b.RESIZE_BY_BOTTOM_LEFT_BUTTON     // Catch:{ all -> 0x01aa }
            if (r0 == r6) goto L_0x01a8
            com.instabug.library.annotation.AnnotationView$b r0 = r10.f34061u     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.AnnotationView$b r6 = com.instabug.library.annotation.AnnotationView.b.DRAG     // Catch:{ all -> 0x01aa }
            if (r0 == r6) goto L_0x01a8
            com.instabug.library.annotation.AnnotationView$b r0 = r10.f34061u     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.AnnotationView$b r6 = com.instabug.library.annotation.AnnotationView.b.DRAW     // Catch:{ all -> 0x01aa }
            if (r0 != r6) goto L_0x01a8
            com.instabug.library.annotation.AnnotationView$c r0 = r10.f34062v     // Catch:{ all -> 0x01aa }
            com.instabug.library.annotation.AnnotationView$c r6 = com.instabug.library.annotation.AnnotationView.c.DRAW_PATH     // Catch:{ all -> 0x01aa }
            if (r0 != r6) goto L_0x01a8
            int r11 = r11.getAction()     // Catch:{ all -> 0x01aa }
            if (r11 == 0) goto L_0x01a3
            if (r11 == r1) goto L_0x0195
            if (r11 == r4) goto L_0x018c
            goto L_0x01a8
        L_0x018c:
            r10.f34049i = r1     // Catch:{ all -> 0x01aa }
            r10.b(r2, r3)     // Catch:{ all -> 0x01aa }
            r10.invalidate()     // Catch:{ all -> 0x01aa }
            goto L_0x01a8
        L_0x0195:
            r10.g()     // Catch:{ all -> 0x01aa }
            boolean r11 = r10.f34049i     // Catch:{ all -> 0x01aa }
            if (r11 != 0) goto L_0x019f
            r10.performClick()     // Catch:{ all -> 0x01aa }
        L_0x019f:
            r10.invalidate()     // Catch:{ all -> 0x01aa }
            goto L_0x01a8
        L_0x01a3:
            r10.f34049i = r5     // Catch:{ all -> 0x01aa }
            r10.c(r2, r3)     // Catch:{ all -> 0x01aa }
        L_0x01a8:
            monitor-exit(r10)
            return r1
        L_0x01aa:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.annotation.AnnotationView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setDrawingColor(int i11) {
        this.f34045e = i11;
        this.f34044d.setColor(i11);
    }

    public void setDrawingMode(c cVar) {
        this.f34062v = cVar;
    }

    public void setImageBitmap(Bitmap bitmap) {
        this.f34052l = bitmap;
        super.setImageBitmap(bitmap);
    }

    public void setOnActionDownListener(@Nullable f fVar) {
        this.f34065y = fVar;
    }

    /* renamed from: setOnNewMagnifierAddingAِِِbilityChangedListener  reason: contains not printable characters */
    public void m9022setOnNewMagnifierAddingAbilityChangedListener(g gVar) {
        this.f34066z = gVar;
    }

    public void setOnPathRecognizedListener(@Nullable h hVar) {
        this.A = hVar;
    }

    public void setScreenshot(@Nullable Drawable drawable) {
        this.f34050j = drawable;
    }

    public AnnotationView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void g() {
        Path path = this.f34042b;
        if (path != null && this.f34043c != null) {
            path.lineTo(this.f34047g, this.f34048h);
            if (new PathMeasure(path, false).getLength() < 20.0f) {
                this.f34046f.remove(path);
                return;
            }
            f fVar = this.f34063w;
            G = new e(new com.instabug.library.annotation.shape.e(path, this.f34044d.getStrokeWidth(), this.f34044d, this.f34043c));
            e eVar = G;
            d dVar = new d();
            path.computeBounds(dVar, true);
            if (eVar != null) {
                eVar.c(new d(dVar));
            }
            if (fVar != null) {
                fVar.b(G);
            }
            this.f34046f.remove(path);
            invalidate();
            a(dVar);
        }
    }

    /* access modifiers changed from: private */
    public void i() {
        f fVar = this.f34063w;
        e eVar = G;
        if (this.f34061u != b.DRAW && fVar != null && eVar != null) {
            for (int i11 = 1; i11 < fVar.b(); i11++) {
                e a11 = fVar.a(i11);
                if (fVar.c(eVar) <= i11 && (a11.b() instanceof com.instabug.library.annotation.shape.h) && a11.c()) {
                    ((com.instabug.library.annotation.shape.h) a11.b()).a(getScaledBitmap());
                }
            }
        }
    }

    public void h() {
        if (this.f34063w != null) {
            e c11 = this.f34063w.c();
            if (c11 != null && (c11.b() instanceof com.instabug.library.annotation.shape.h)) {
                this.F--;
                c();
            }
            setSelectedMarkUpDrawable((e) null);
            i();
            invalidate();
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public AnnotationView(Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f34046f = new LinkedHashMap();
        this.f34051k = new PointF[5];
        this.f34060t = new PointF();
        this.f34061u = b.NONE;
        this.f34062v = c.NONE;
        this.f34064x = new com.instabug.library.annotation.utility.a();
        int i12 = 0;
        this.E = false;
        this.f34063w = new f();
        this.f34041a = new GestureDetector(context, new d(this, (a) null));
        new Paint(1).setColor(-65281);
        this.f34056p = new a();
        this.f34057q = new a();
        this.f34058r = new a();
        this.f34059s = new a();
        d();
        while (true) {
            PointF[] pointFArr = this.f34051k;
            if (i12 < pointFArr.length) {
                pointFArr[i12] = new PointF();
                i12++;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:61:0x01d6, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized void a(com.instabug.library.annotation.d r12) {
        /*
            r11 = this;
            monitor-enter(r11)
            android.graphics.Path r0 = r11.f34042b     // Catch:{ all -> 0x01d7 }
            if (r0 != 0) goto L_0x0007
            monitor-exit(r11)
            return
        L_0x0007:
            com.instabug.library.annotation.recognition.c r0 = new com.instabug.library.annotation.recognition.c     // Catch:{ all -> 0x01d7 }
            r0.<init>()     // Catch:{ all -> 0x01d7 }
            android.graphics.Path r1 = r11.f34042b     // Catch:{ all -> 0x01d7 }
            com.instabug.library.annotation.recognition.c$a r0 = r0.a(r1)     // Catch:{ all -> 0x01d7 }
            com.instabug.library.annotation.recognition.e r1 = r0.f34131a     // Catch:{ all -> 0x01d7 }
            com.instabug.library.annotation.recognition.e r2 = com.instabug.library.annotation.recognition.e.ARROW     // Catch:{ all -> 0x01d7 }
            r3 = 1073741824(0x40000000, float:2.0)
            if (r1 == r2) goto L_0x0142
            com.instabug.library.annotation.recognition.e r4 = com.instabug.library.annotation.recognition.e.LINE     // Catch:{ all -> 0x01d7 }
            if (r1 != r4) goto L_0x0020
            goto L_0x0142
        L_0x0020:
            com.instabug.library.annotation.recognition.e r2 = com.instabug.library.annotation.recognition.e.RECT     // Catch:{ all -> 0x01d7 }
            r4 = 0
            r5 = 110(0x6e, float:1.54E-43)
            r6 = 70
            r7 = 20
            r8 = 90
            if (r1 != r2) goto L_0x00dc
            float r1 = r12.width()     // Catch:{ all -> 0x01d7 }
            float r2 = r12.height()     // Catch:{ all -> 0x01d7 }
            float r1 = java.lang.Math.max(r1, r2)     // Catch:{ all -> 0x01d7 }
            float r2 = r12.centerX()     // Catch:{ all -> 0x01d7 }
            float r1 = r1 / r3
            float r2 = r2 - r1
            float r3 = r12.centerX()     // Catch:{ all -> 0x01d7 }
            float r3 = r3 + r1
            float r9 = r12.centerY()     // Catch:{ all -> 0x01d7 }
            float r9 = r9 - r1
            float r10 = r12.centerY()     // Catch:{ all -> 0x01d7 }
            float r10 = r10 + r1
            r12.set(r2, r9, r3, r10)     // Catch:{ all -> 0x01d7 }
            float r1 = r0.f34133c     // Catch:{ all -> 0x01d7 }
            float r2 = r12.width()     // Catch:{ all -> 0x01d7 }
            float r1 = r1 * r2
            int r0 = r0.f34132b     // Catch:{ all -> 0x01d7 }
            r2 = 160(0xa0, float:2.24E-43)
            r3 = 180(0xb4, float:2.52E-43)
            if (r0 > r7) goto L_0x0061
            goto L_0x006c
        L_0x0061:
            if (r0 < r6) goto L_0x0067
            if (r0 > r5) goto L_0x0067
            r4 = r8
            goto L_0x006c
        L_0x0067:
            if (r0 < r2) goto L_0x006b
            r4 = r3
            goto L_0x006c
        L_0x006b:
            r4 = r0
        L_0x006c:
            if (r4 == 0) goto L_0x009a
            if (r4 != r3) goto L_0x0071
            goto L_0x009a
        L_0x0071:
            if (r4 != r8) goto L_0x007e
            float r3 = r12.top     // Catch:{ all -> 0x01d7 }
            float r3 = r3 + r1
            r12.top = r3     // Catch:{ all -> 0x01d7 }
            float r3 = r12.bottom     // Catch:{ all -> 0x01d7 }
            float r3 = r3 - r1
            r12.bottom = r3     // Catch:{ all -> 0x01d7 }
            goto L_0x00a4
        L_0x007e:
            if (r4 <= r8) goto L_0x008f
            if (r4 >= r3) goto L_0x008f
            int r4 = r4 + -90
            float r3 = r12.top     // Catch:{ all -> 0x01d7 }
            float r3 = r3 + r1
            r12.top = r3     // Catch:{ all -> 0x01d7 }
            float r3 = r12.bottom     // Catch:{ all -> 0x01d7 }
            float r3 = r3 - r1
            r12.bottom = r3     // Catch:{ all -> 0x01d7 }
            goto L_0x00a4
        L_0x008f:
            float r3 = r12.left     // Catch:{ all -> 0x01d7 }
            float r3 = r3 + r1
            r12.left = r3     // Catch:{ all -> 0x01d7 }
            float r3 = r12.right     // Catch:{ all -> 0x01d7 }
            float r3 = r3 - r1
            r12.right = r3     // Catch:{ all -> 0x01d7 }
            goto L_0x00a4
        L_0x009a:
            float r3 = r12.left     // Catch:{ all -> 0x01d7 }
            float r3 = r3 + r1
            r12.left = r3     // Catch:{ all -> 0x01d7 }
            float r3 = r12.right     // Catch:{ all -> 0x01d7 }
            float r3 = r3 - r1
            r12.right = r3     // Catch:{ all -> 0x01d7 }
        L_0x00a4:
            if (r0 < r7) goto L_0x00a8
            if (r0 <= r6) goto L_0x00ac
        L_0x00a8:
            if (r0 < r5) goto L_0x00cd
            if (r0 > r2) goto L_0x00cd
        L_0x00ac:
            float r0 = r12.width()     // Catch:{ all -> 0x01d7 }
            r1 = 1036831949(0x3dcccccd, float:0.1)
            float r0 = r0 * r1
            float r2 = r12.height()     // Catch:{ all -> 0x01d7 }
            float r2 = r2 * r1
            float r1 = r12.left     // Catch:{ all -> 0x01d7 }
            float r1 = r1 + r0
            r12.left = r1     // Catch:{ all -> 0x01d7 }
            float r1 = r12.right     // Catch:{ all -> 0x01d7 }
            float r1 = r1 - r0
            r12.right = r1     // Catch:{ all -> 0x01d7 }
            float r0 = r12.top     // Catch:{ all -> 0x01d7 }
            float r0 = r0 + r2
            r12.top = r0     // Catch:{ all -> 0x01d7 }
            float r0 = r12.bottom     // Catch:{ all -> 0x01d7 }
            float r0 = r0 - r2
            r12.bottom = r0     // Catch:{ all -> 0x01d7 }
        L_0x00cd:
            com.instabug.library.annotation.shape.f r0 = new com.instabug.library.annotation.shape.f     // Catch:{ all -> 0x01d7 }
            int r1 = r11.f34045e     // Catch:{ all -> 0x01d7 }
            android.graphics.Paint r2 = r11.f34044d     // Catch:{ all -> 0x01d7 }
            float r2 = r2.getStrokeWidth()     // Catch:{ all -> 0x01d7 }
            r0.<init>(r1, r2, r4)     // Catch:{ all -> 0x01d7 }
            goto L_0x01c6
        L_0x00dc:
            com.instabug.library.annotation.recognition.e r2 = com.instabug.library.annotation.recognition.e.OVAL     // Catch:{ all -> 0x01d7 }
            if (r1 != r2) goto L_0x013f
            float r1 = r12.width()     // Catch:{ all -> 0x01d7 }
            float r2 = r12.height()     // Catch:{ all -> 0x01d7 }
            float r1 = java.lang.Math.max(r1, r2)     // Catch:{ all -> 0x01d7 }
            float r2 = r12.centerX()     // Catch:{ all -> 0x01d7 }
            float r1 = r1 / r3
            float r2 = r2 - r1
            float r3 = r12.centerX()     // Catch:{ all -> 0x01d7 }
            float r3 = r3 + r1
            float r9 = r12.centerY()     // Catch:{ all -> 0x01d7 }
            float r9 = r9 - r1
            float r10 = r12.centerY()     // Catch:{ all -> 0x01d7 }
            float r10 = r10 + r1
            r12.set(r2, r9, r3, r10)     // Catch:{ all -> 0x01d7 }
            float r1 = r0.f34133c     // Catch:{ all -> 0x01d7 }
            float r2 = r12.width()     // Catch:{ all -> 0x01d7 }
            float r1 = r1 * r2
            int r0 = r0.f34132b     // Catch:{ all -> 0x01d7 }
            if (r0 > r7) goto L_0x0110
            goto L_0x0117
        L_0x0110:
            if (r0 < r6) goto L_0x0116
            if (r0 > r5) goto L_0x0116
            r4 = r8
            goto L_0x0117
        L_0x0116:
            r4 = r0
        L_0x0117:
            if (r4 < r8) goto L_0x0126
            int r4 = r4 + -90
            float r0 = r12.top     // Catch:{ all -> 0x01d7 }
            float r0 = r0 + r1
            r12.top = r0     // Catch:{ all -> 0x01d7 }
            float r0 = r12.bottom     // Catch:{ all -> 0x01d7 }
            float r0 = r0 - r1
            r12.bottom = r0     // Catch:{ all -> 0x01d7 }
            goto L_0x0130
        L_0x0126:
            float r0 = r12.left     // Catch:{ all -> 0x01d7 }
            float r0 = r0 + r1
            r12.left = r0     // Catch:{ all -> 0x01d7 }
            float r0 = r12.right     // Catch:{ all -> 0x01d7 }
            float r0 = r0 - r1
            r12.right = r0     // Catch:{ all -> 0x01d7 }
        L_0x0130:
            com.instabug.library.annotation.shape.d r0 = new com.instabug.library.annotation.shape.d     // Catch:{ all -> 0x01d7 }
            int r1 = r11.f34045e     // Catch:{ all -> 0x01d7 }
            android.graphics.Paint r2 = r11.f34044d     // Catch:{ all -> 0x01d7 }
            float r2 = r2.getStrokeWidth()     // Catch:{ all -> 0x01d7 }
            r0.<init>(r1, r2, r4)     // Catch:{ all -> 0x01d7 }
            goto L_0x01c6
        L_0x013f:
            r0 = 0
            goto L_0x01c6
        L_0x0142:
            float r1 = r12.width()     // Catch:{ all -> 0x01d7 }
            float r4 = r12.height()     // Catch:{ all -> 0x01d7 }
            float r1 = java.lang.Math.max(r1, r4)     // Catch:{ all -> 0x01d7 }
            float r4 = r12.centerX()     // Catch:{ all -> 0x01d7 }
            float r1 = r1 / r3
            float r4 = r4 - r1
            float r3 = r12.centerX()     // Catch:{ all -> 0x01d7 }
            float r3 = r3 + r1
            android.graphics.PointF r1 = new android.graphics.PointF     // Catch:{ all -> 0x01d7 }
            float r5 = r12.centerY()     // Catch:{ all -> 0x01d7 }
            r1.<init>(r4, r5)     // Catch:{ all -> 0x01d7 }
            android.graphics.PointF r4 = new android.graphics.PointF     // Catch:{ all -> 0x01d7 }
            float r5 = r12.centerY()     // Catch:{ all -> 0x01d7 }
            r4.<init>(r3, r5)     // Catch:{ all -> 0x01d7 }
            float r3 = r12.centerX()     // Catch:{ all -> 0x01d7 }
            float r5 = r12.centerY()     // Catch:{ all -> 0x01d7 }
            int r6 = r0.f34132b     // Catch:{ all -> 0x01d7 }
            float r6 = (float) r6     // Catch:{ all -> 0x01d7 }
            com.instabug.library.annotation.utility.c.a((float) r3, (float) r5, (float) r6, (android.graphics.PointF) r1)     // Catch:{ all -> 0x01d7 }
            float r3 = r12.centerX()     // Catch:{ all -> 0x01d7 }
            float r5 = r12.centerY()     // Catch:{ all -> 0x01d7 }
            int r6 = r0.f34132b     // Catch:{ all -> 0x01d7 }
            float r6 = (float) r6     // Catch:{ all -> 0x01d7 }
            com.instabug.library.annotation.utility.c.a((float) r3, (float) r5, (float) r6, (android.graphics.PointF) r4)     // Catch:{ all -> 0x01d7 }
            com.instabug.library.annotation.shape.a r3 = new com.instabug.library.annotation.shape.a     // Catch:{ all -> 0x01d7 }
            int r5 = r11.f34045e     // Catch:{ all -> 0x01d7 }
            android.graphics.Paint r6 = r11.f34044d     // Catch:{ all -> 0x01d7 }
            float r6 = r6.getStrokeWidth()     // Catch:{ all -> 0x01d7 }
            r3.<init>(r1, r4, r5, r6)     // Catch:{ all -> 0x01d7 }
            int r5 = r0.f34132b     // Catch:{ all -> 0x01d7 }
            r3.a((int) r5)     // Catch:{ all -> 0x01d7 }
            com.instabug.library.annotation.recognition.e r0 = r0.f34131a     // Catch:{ all -> 0x01d7 }
            if (r0 != r2) goto L_0x01a2
            java.lang.String r0 = "arrow"
            r3.a((java.lang.String) r0)     // Catch:{ all -> 0x01d7 }
        L_0x01a2:
            float r0 = r1.x     // Catch:{ all -> 0x01d7 }
            float r2 = r4.x     // Catch:{ all -> 0x01d7 }
            float r0 = java.lang.Math.min(r0, r2)     // Catch:{ all -> 0x01d7 }
            float r2 = r1.x     // Catch:{ all -> 0x01d7 }
            float r5 = r4.x     // Catch:{ all -> 0x01d7 }
            float r2 = java.lang.Math.max(r2, r5)     // Catch:{ all -> 0x01d7 }
            float r5 = r1.y     // Catch:{ all -> 0x01d7 }
            float r6 = r4.y     // Catch:{ all -> 0x01d7 }
            float r5 = java.lang.Math.min(r5, r6)     // Catch:{ all -> 0x01d7 }
            float r1 = r1.y     // Catch:{ all -> 0x01d7 }
            float r4 = r4.y     // Catch:{ all -> 0x01d7 }
            float r1 = java.lang.Math.max(r1, r4)     // Catch:{ all -> 0x01d7 }
            r12.set(r0, r5, r2, r1)     // Catch:{ all -> 0x01d7 }
            r0 = r3
        L_0x01c6:
            r11.C = r0     // Catch:{ all -> 0x01d7 }
            r11.D = r12     // Catch:{ all -> 0x01d7 }
            if (r0 == 0) goto L_0x01d5
            android.graphics.Path r1 = r11.f34042b     // Catch:{ all -> 0x01d7 }
            android.graphics.Path r12 = r0.a((com.instabug.library.annotation.d) r12)     // Catch:{ all -> 0x01d7 }
            r11.a((android.graphics.Path) r1, (android.graphics.Path) r12)     // Catch:{ all -> 0x01d7 }
        L_0x01d5:
            monitor-exit(r11)
            return
        L_0x01d7:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.annotation.AnnotationView.a(com.instabug.library.annotation.d):void");
    }

    public void b() {
        g gVar;
        if (this.F < 5) {
            a((com.instabug.library.annotation.shape.g) new com.instabug.library.annotation.shape.h(getScaledBitmap()));
            this.F++;
        }
        if (this.F == 5 && (gVar = this.f34066z) != null) {
            gVar.a(false);
        }
    }

    /* access modifiers changed from: private */
    public void c() {
        g gVar = this.f34066z;
        if (gVar != null) {
            if (this.F == 5) {
                gVar.a(false);
            }
            if (this.F == 4) {
                this.f34066z.a(true);
            }
        }
    }

    private void b(e eVar) {
        if (eVar.b() instanceof com.instabug.library.annotation.shape.h) {
            ((com.instabug.library.annotation.shape.h) eVar.b()).a(getScaledBitmap());
        } else if (eVar.b() instanceof com.instabug.library.annotation.shape.b) {
            ((com.instabug.library.annotation.shape.b) eVar.b()).a(getScaledBitmap());
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    private void a(com.instabug.library.annotation.shape.g gVar, d dVar) {
        f fVar = this.f34063w;
        e eVar = G;
        if (eVar != null && fVar != null && eVar.f34112b != null) {
            eVar.a(gVar, dVar);
            eVar.f34112b.a(true);
            fVar.d(G);
        }
    }

    private synchronized void a(MotionEvent motionEvent) {
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        e eVar = G;
        switch (a.f34068b[this.f34061u.ordinal()]) {
            case 1:
                if (eVar != null) {
                    PointF pointF = this.f34060t;
                    eVar.a((int) (x11 - pointF.x), (int) (y11 - pointF.y));
                    break;
                }
                break;
            case 2:
                if (eVar != null) {
                    d dVar = new d();
                    d dVar2 = eVar.f34116f;
                    float f11 = dVar2.left;
                    if (x11 < f11) {
                        dVar.left = dVar2.right + ((float) ((int) (x11 - this.f34060t.x)));
                        dVar.right = dVar2.left;
                    } else {
                        dVar.left = f11;
                        dVar.right = dVar2.right + ((float) ((int) (x11 - this.f34060t.x)));
                    }
                    float f12 = dVar2.top;
                    if (y11 < f12) {
                        dVar.top = dVar2.bottom + ((float) ((int) (y11 - this.f34060t.y)));
                        dVar.bottom = dVar2.top;
                    } else {
                        dVar.top = f12;
                        dVar.bottom = dVar2.bottom + ((float) ((int) (y11 - this.f34060t.y)));
                    }
                    eVar.b(dVar);
                    if (eVar.b() instanceof com.instabug.library.annotation.shape.f) {
                        ((com.instabug.library.annotation.shape.f) eVar.b()).c(x11, y11, eVar.f34114d);
                        break;
                    }
                }
                break;
            case 3:
                if (eVar != null) {
                    d dVar3 = new d();
                    d dVar4 = eVar.f34116f;
                    float f13 = dVar4.right;
                    if (x11 > f13) {
                        dVar3.left = f13;
                        dVar3.right = dVar4.left + ((float) ((int) (x11 - this.f34060t.x)));
                    } else {
                        dVar3.left = dVar4.left + ((float) ((int) (x11 - this.f34060t.x)));
                        dVar3.right = f13;
                    }
                    float f14 = dVar4.top;
                    if (y11 < f14) {
                        dVar3.top = dVar4.bottom + ((float) ((int) (y11 - this.f34060t.y)));
                        dVar3.bottom = dVar4.top;
                    } else {
                        dVar3.top = f14;
                        dVar3.bottom = dVar4.bottom + ((float) ((int) (y11 - this.f34060t.y)));
                    }
                    eVar.b(dVar3);
                    if (eVar.b() instanceof com.instabug.library.annotation.shape.f) {
                        ((com.instabug.library.annotation.shape.f) eVar.b()).d(x11, y11, eVar.f34114d);
                        break;
                    }
                }
                break;
            case 4:
                if (eVar != null) {
                    if (!(eVar.b() instanceof com.instabug.library.annotation.shape.a)) {
                        d dVar5 = new d();
                        d dVar6 = eVar.f34116f;
                        float f15 = dVar6.right;
                        if (x11 > f15) {
                            dVar5.left = f15;
                            dVar5.right = dVar6.left + ((float) ((int) (x11 - this.f34060t.x)));
                        } else {
                            dVar5.left = dVar6.left + ((float) ((int) (x11 - this.f34060t.x)));
                            dVar5.right = f15;
                        }
                        float f16 = dVar6.bottom;
                        if (y11 > f16) {
                            dVar5.top = f16;
                            dVar5.bottom = dVar6.top + ((float) ((int) (y11 - this.f34060t.y)));
                        } else {
                            dVar5.top = dVar6.top + ((float) ((int) (y11 - this.f34060t.y)));
                            dVar5.bottom = f16;
                        }
                        eVar.b(dVar5);
                        if (eVar.b() instanceof com.instabug.library.annotation.shape.f) {
                            ((com.instabug.library.annotation.shape.f) eVar.b()).a(x11, y11, eVar.f34114d);
                            break;
                        }
                    } else {
                        ((com.instabug.library.annotation.shape.a) eVar.b()).b(x11, y11, eVar.f34114d);
                        break;
                    }
                }
                break;
            case 5:
                if (eVar != null) {
                    if (!(eVar.b() instanceof com.instabug.library.annotation.shape.a)) {
                        d dVar7 = new d();
                        d dVar8 = eVar.f34116f;
                        float f17 = dVar8.left;
                        if (x11 < f17) {
                            dVar7.left = dVar8.right + ((float) ((int) (x11 - this.f34060t.x)));
                            dVar7.right = dVar8.left;
                        } else {
                            dVar7.left = f17;
                            dVar7.right = dVar8.right + ((float) ((int) (x11 - this.f34060t.x)));
                        }
                        float f18 = dVar8.bottom;
                        if (y11 > f18) {
                            dVar7.top = f18;
                            dVar7.bottom = dVar8.top + ((float) ((int) (y11 - this.f34060t.y)));
                        } else {
                            dVar7.top = dVar8.top + ((float) ((int) (y11 - this.f34060t.y)));
                            dVar7.bottom = f18;
                        }
                        eVar.b(dVar7);
                        if (eVar.b() instanceof com.instabug.library.annotation.shape.f) {
                            ((com.instabug.library.annotation.shape.f) eVar.b()).b(x11, y11, eVar.f34114d);
                            break;
                        }
                    } else {
                        ((com.instabug.library.annotation.shape.a) eVar.b()).a(x11, y11, eVar.f34114d);
                        break;
                    }
                }
                break;
            case 6:
                if (eVar != null) {
                    d dVar9 = new d();
                    PointF pointF2 = this.f34060t;
                    float f19 = pointF2.x;
                    if (x11 < f19) {
                        dVar9.left = (float) ((int) x11);
                        dVar9.right = (float) ((int) f19);
                    } else {
                        dVar9.left = (float) ((int) f19);
                        dVar9.right = (float) ((int) x11);
                    }
                    float f21 = pointF2.y;
                    if (y11 < f21) {
                        dVar9.top = (float) ((int) y11);
                        dVar9.bottom = (float) ((int) f21);
                    } else {
                        dVar9.top = (float) ((int) f21);
                        dVar9.bottom = (float) ((int) y11);
                    }
                    eVar.c(dVar9);
                    break;
                }
                break;
        }
    }

    public void a(com.instabug.library.annotation.shape.g gVar) {
        int min = Math.min(getWidth(), getHeight()) / 2;
        int width = (getWidth() - min) / 2;
        int height = (getHeight() - min) / 2;
        a(gVar, new d((float) width, (float) (height - 30), (float) (width + min), (float) (min + height + 30)), e.HIGH);
    }

    private void a(com.instabug.library.annotation.shape.g gVar, d dVar, e eVar) {
        e eVar2 = new e(gVar);
        eVar2.c(dVar);
        a(eVar2, eVar);
    }

    private void a(e eVar, e eVar2) {
        getOriginalBitmap();
        G = eVar;
        f fVar = this.f34063w;
        if (fVar != null) {
            if (eVar2 == e.LOW) {
                fVar.a(eVar);
            } else {
                fVar.b(eVar);
            }
            invalidate();
        }
    }

    private Bitmap a(int i11) {
        this.f34054n = i11;
        Bitmap createBitmap = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.f34055o = true;
        invalidate();
        draw(canvas);
        this.f34055o = false;
        invalidate();
        return createBitmap;
    }

    private void a(Path path, Path path2) {
        h hVar = this.A;
        if (hVar != null) {
            hVar.a(path, path2);
        }
    }
}
