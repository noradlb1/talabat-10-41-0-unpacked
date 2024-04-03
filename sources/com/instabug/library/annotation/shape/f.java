package com.instabug.library.annotation.shape;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import androidx.annotation.ColorInt;
import com.instabug.library.annotation.a;
import com.instabug.library.annotation.d;
import com.instabug.library.annotation.utility.c;

public class f extends g {

    /* renamed from: l  reason: collision with root package name */
    public int f34161l;

    /* renamed from: m  reason: collision with root package name */
    public Path f34162m = new Path();

    public f(@ColorInt int i11, float f11, int i12) {
        super(i11, f11);
        this.f34161l = i12;
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    private void b(Canvas canvas, d dVar) {
        canvas.drawPath(a(dVar), this.f34165k);
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public void a(Canvas canvas, PointF pointF, PointF pointF2, PointF pointF3, PointF pointF4) {
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public void a(Canvas canvas, d dVar, d dVar2) {
        if (c() && !dVar.f34110i) {
            dVar2.f34110i = true;
            float centerX = dVar.centerX();
            float centerY = dVar.centerY();
            PointF a11 = c.a(centerX, centerY, (float) this.f34161l, new PointF(dVar.left, dVar.top));
            PointF a12 = c.a(centerX, centerY, (float) this.f34161l, new PointF(dVar.right, dVar.top));
            PointF a13 = c.a(centerX, centerY, (float) this.f34161l, new PointF(dVar.right, dVar.bottom));
            PointF a14 = c.a(centerX, centerY, (float) this.f34161l, new PointF(dVar.left, dVar.bottom));
            dVar2.f34106e.set(a11);
            dVar2.f34107f.set(a12);
            dVar2.f34108g.set(a13);
            dVar2.f34109h.set(a14);
        }
        d(canvas, dVar);
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public void c(float f11, float f12, d dVar) {
        if (c()) {
            c(f11, f12, dVar, true);
            c(dVar);
        }
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public void d(float f11, float f12, d dVar) {
        if (c()) {
            d(f11, f12, dVar, true);
            c(dVar);
        }
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public void b(float f11, float f12, d dVar) {
        if (c()) {
            b(f11, f12, dVar, true);
            c(dVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(float r7, float r8, com.instabug.library.annotation.d r9, boolean r10) {
        /*
            r6 = this;
            android.graphics.PointF r0 = r9.f34108g
            r0.set(r7, r8)
            android.graphics.PointF r7 = r9.f34106e
            android.graphics.PointF r8 = r9.f34107f
            android.graphics.PointF r0 = r9.f34108g
            double r7 = com.instabug.library.annotation.utility.c.a((android.graphics.PointF) r7, (android.graphics.PointF) r8, (android.graphics.PointF) r0)
            float r7 = (float) r7
            android.graphics.PointF r8 = r9.f34108g
            float r0 = r8.y
            android.graphics.PointF r1 = r9.f34107f
            float r2 = r1.y
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x0036
            float r3 = r8.x
            float r4 = r1.x
            int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r5 >= 0) goto L_0x0025
            goto L_0x0036
        L_0x0025:
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x002d
            int r0 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x003e
        L_0x002d:
            int r0 = r6.f34161l
            int r0 = r0 + 90
            float r0 = (float) r0
            com.instabug.library.annotation.utility.c.a((float) r7, (float) r0, (android.graphics.PointF) r8, (android.graphics.PointF) r1)
            goto L_0x003e
        L_0x0036:
            int r0 = r6.f34161l
            int r0 = r0 + 270
            float r0 = (float) r0
            com.instabug.library.annotation.utility.c.a((float) r7, (float) r0, (android.graphics.PointF) r8, (android.graphics.PointF) r1)
        L_0x003e:
            android.graphics.PointF r7 = r9.f34106e
            android.graphics.PointF r8 = r9.f34109h
            android.graphics.PointF r0 = r9.f34108g
            double r7 = com.instabug.library.annotation.utility.c.a((android.graphics.PointF) r7, (android.graphics.PointF) r8, (android.graphics.PointF) r0)
            float r7 = (float) r7
            android.graphics.PointF r8 = r9.f34108g
            float r0 = r8.x
            android.graphics.PointF r1 = r9.f34109h
            float r2 = r1.x
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x006d
            float r3 = r8.y
            float r4 = r1.y
            int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x005e
            goto L_0x006d
        L_0x005e:
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x0066
            int r0 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0075
        L_0x0066:
            int r0 = r6.f34161l
            float r0 = (float) r0
            com.instabug.library.annotation.utility.c.a((float) r7, (float) r0, (android.graphics.PointF) r8, (android.graphics.PointF) r1)
            goto L_0x0075
        L_0x006d:
            int r0 = r6.f34161l
            int r0 = r0 + 180
            float r0 = (float) r0
            com.instabug.library.annotation.utility.c.a((float) r7, (float) r0, (android.graphics.PointF) r8, (android.graphics.PointF) r1)
        L_0x0075:
            if (r10 == 0) goto L_0x0081
            android.graphics.PointF r7 = r9.f34106e
            float r8 = r7.x
            float r7 = r7.y
            r10 = 0
            r6.a((float) r8, (float) r7, (com.instabug.library.annotation.d) r9, (boolean) r10)
        L_0x0081:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.annotation.shape.f.c(float, float, com.instabug.library.annotation.d, boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d(float r7, float r8, com.instabug.library.annotation.d r9, boolean r10) {
        /*
            r6 = this;
            android.graphics.PointF r0 = r9.f34109h
            r0.set(r7, r8)
            android.graphics.PointF r7 = r9.f34107f
            android.graphics.PointF r8 = r9.f34106e
            android.graphics.PointF r0 = r9.f34109h
            double r7 = com.instabug.library.annotation.utility.c.a((android.graphics.PointF) r7, (android.graphics.PointF) r8, (android.graphics.PointF) r0)
            float r7 = (float) r7
            android.graphics.PointF r8 = r9.f34109h
            float r0 = r8.y
            android.graphics.PointF r1 = r9.f34106e
            float r2 = r1.y
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x0036
            float r3 = r8.x
            float r4 = r1.x
            int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r5 >= 0) goto L_0x0025
            goto L_0x0036
        L_0x0025:
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x002d
            int r0 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x003e
        L_0x002d:
            int r0 = r6.f34161l
            int r0 = r0 + 90
            float r0 = (float) r0
            com.instabug.library.annotation.utility.c.a((float) r7, (float) r0, (android.graphics.PointF) r8, (android.graphics.PointF) r1)
            goto L_0x003e
        L_0x0036:
            int r0 = r6.f34161l
            int r0 = r0 + 270
            float r0 = (float) r0
            com.instabug.library.annotation.utility.c.a((float) r7, (float) r0, (android.graphics.PointF) r8, (android.graphics.PointF) r1)
        L_0x003e:
            android.graphics.PointF r7 = r9.f34107f
            android.graphics.PointF r8 = r9.f34108g
            android.graphics.PointF r0 = r9.f34109h
            double r7 = com.instabug.library.annotation.utility.c.a((android.graphics.PointF) r7, (android.graphics.PointF) r8, (android.graphics.PointF) r0)
            float r7 = (float) r7
            android.graphics.PointF r8 = r9.f34109h
            float r0 = r8.x
            android.graphics.PointF r1 = r9.f34108g
            float r2 = r1.x
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 < 0) goto L_0x006f
            float r3 = r8.y
            float r4 = r1.y
            int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r5 >= 0) goto L_0x005e
            goto L_0x006f
        L_0x005e:
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0066
            int r0 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0075
        L_0x0066:
            int r0 = r6.f34161l
            int r0 = r0 + 180
            float r0 = (float) r0
            com.instabug.library.annotation.utility.c.a((float) r7, (float) r0, (android.graphics.PointF) r8, (android.graphics.PointF) r1)
            goto L_0x0075
        L_0x006f:
            int r0 = r6.f34161l
            float r0 = (float) r0
            com.instabug.library.annotation.utility.c.a((float) r7, (float) r0, (android.graphics.PointF) r8, (android.graphics.PointF) r1)
        L_0x0075:
            if (r10 == 0) goto L_0x0081
            android.graphics.PointF r7 = r9.f34107f
            float r8 = r7.x
            float r7 = r7.y
            r10 = 0
            r6.b(r8, r7, r9, r10)
        L_0x0081:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.annotation.shape.f.d(float, float, com.instabug.library.annotation.d, boolean):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(float r7, float r8, com.instabug.library.annotation.d r9, boolean r10) {
        /*
            r6 = this;
            android.graphics.PointF r0 = r9.f34107f
            r0.set(r7, r8)
            android.graphics.PointF r7 = r9.f34109h
            android.graphics.PointF r8 = r9.f34106e
            android.graphics.PointF r0 = r9.f34107f
            double r7 = com.instabug.library.annotation.utility.c.a((android.graphics.PointF) r7, (android.graphics.PointF) r8, (android.graphics.PointF) r0)
            float r7 = (float) r7
            android.graphics.PointF r8 = r9.f34107f
            float r0 = r8.x
            android.graphics.PointF r1 = r9.f34106e
            float r2 = r1.x
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 > 0) goto L_0x0034
            float r3 = r8.y
            float r4 = r1.y
            int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x0025
            goto L_0x0034
        L_0x0025:
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 < 0) goto L_0x002d
            int r0 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x003c
        L_0x002d:
            int r0 = r6.f34161l
            float r0 = (float) r0
            com.instabug.library.annotation.utility.c.a((float) r7, (float) r0, (android.graphics.PointF) r8, (android.graphics.PointF) r1)
            goto L_0x003c
        L_0x0034:
            int r0 = r6.f34161l
            int r0 = r0 + 180
            float r0 = (float) r0
            com.instabug.library.annotation.utility.c.a((float) r7, (float) r0, (android.graphics.PointF) r8, (android.graphics.PointF) r1)
        L_0x003c:
            android.graphics.PointF r7 = r9.f34109h
            android.graphics.PointF r8 = r9.f34108g
            android.graphics.PointF r0 = r9.f34107f
            double r7 = com.instabug.library.annotation.utility.c.a((android.graphics.PointF) r7, (android.graphics.PointF) r8, (android.graphics.PointF) r0)
            float r7 = (float) r7
            android.graphics.PointF r8 = r9.f34107f
            float r0 = r8.y
            android.graphics.PointF r1 = r9.f34108g
            float r2 = r1.y
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 < 0) goto L_0x006d
            float r3 = r8.x
            float r4 = r1.x
            int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x005c
            goto L_0x006d
        L_0x005c:
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0064
            int r0 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0075
        L_0x0064:
            int r0 = r6.f34161l
            int r0 = r0 + 270
            float r0 = (float) r0
            com.instabug.library.annotation.utility.c.a((float) r7, (float) r0, (android.graphics.PointF) r8, (android.graphics.PointF) r1)
            goto L_0x0075
        L_0x006d:
            int r0 = r6.f34161l
            int r0 = r0 + 90
            float r0 = (float) r0
            com.instabug.library.annotation.utility.c.a((float) r7, (float) r0, (android.graphics.PointF) r8, (android.graphics.PointF) r1)
        L_0x0075:
            if (r10 == 0) goto L_0x0081
            android.graphics.PointF r7 = r9.f34109h
            float r8 = r7.x
            float r7 = r7.y
            r10 = 0
            r6.d(r8, r7, r9, r10)
        L_0x0081:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.annotation.shape.f.b(float, float, com.instabug.library.annotation.d, boolean):void");
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    private void c(d dVar) {
        RectF rectF = new RectF();
        this.f34162m.computeBounds(rectF, true);
        dVar.set(rectF);
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public void d(Canvas canvas, d dVar) {
        b(canvas, dVar);
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public void b(d dVar) {
        this.f34162m.reset();
        if (!c()) {
            this.f34162m.addRect(dVar, Path.Direction.CW);
            return;
        }
        Path path = this.f34162m;
        PointF pointF = dVar.f34106e;
        path.moveTo(pointF.x, pointF.y);
        Path path2 = this.f34162m;
        PointF pointF2 = dVar.f34107f;
        path2.lineTo(pointF2.x, pointF2.y);
        Path path3 = this.f34162m;
        PointF pointF3 = dVar.f34108g;
        path3.lineTo(pointF3.x, pointF3.y);
        Path path4 = this.f34162m;
        PointF pointF4 = dVar.f34109h;
        path4.lineTo(pointF4.x, pointF4.y);
        this.f34162m.close();
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    private boolean c() {
        int i11 = this.f34161l;
        return (i11 == 0 || i11 == 180 || i11 == 90) ? false : true;
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public boolean a(PointF pointF, d dVar) {
        if (!c()) {
            RectF rectF = new RectF(dVar);
            rectF.inset(50.0f, 50.0f);
            RectF rectF2 = new RectF(dVar);
            rectF2.inset(-50.0f, -50.0f);
            if (!rectF2.contains(pointF.x, pointF.y) || rectF.contains(pointF.x, pointF.y)) {
                return false;
            }
            return true;
        }
        float f11 = pointF.x;
        float f12 = pointF.y;
        RectF rectF3 = new RectF(f11 - 50.0f, f12 - 50.0f, f11 + 50.0f, f12 + 50.0f);
        for (PointF pointF2 : c.a(this.f34162m)) {
            if (rectF3.contains(pointF2.x, pointF2.y)) {
                return true;
            }
        }
        return false;
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public void a(d dVar, d dVar2, boolean z11) {
        if (!c() || z11) {
            dVar2.b(dVar);
        }
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public void a(Canvas canvas, d dVar, a[] aVarArr) {
        if (!c()) {
            aVarArr[0].a(dVar.left, dVar.top);
            aVarArr[1].a(dVar.right, dVar.top);
            aVarArr[2].a(dVar.right, dVar.bottom);
            aVarArr[3].a(dVar.left, dVar.bottom);
        } else {
            a aVar = aVarArr[0];
            PointF pointF = dVar.f34106e;
            aVar.a(pointF.x, pointF.y);
            a aVar2 = aVarArr[1];
            PointF pointF2 = dVar.f34107f;
            aVar2.a(pointF2.x, pointF2.y);
            a aVar3 = aVarArr[2];
            PointF pointF3 = dVar.f34108g;
            aVar3.a(pointF3.x, pointF3.y);
            a aVar4 = aVarArr[3];
            PointF pointF4 = dVar.f34109h;
            aVar4.a(pointF4.x, pointF4.y);
        }
        int color = this.f34165k.getColor();
        for (int i11 = 0; i11 < aVarArr.length; i11++) {
            aVarArr[i11].a(color);
            aVarArr[i11].a(canvas);
        }
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public void a(d dVar, d dVar2, int i11, int i12) {
        PointF pointF = dVar.f34106e;
        PointF pointF2 = dVar2.f34106e;
        float f11 = (float) i11;
        float f12 = (float) i12;
        pointF.set(pointF2.x + f11, pointF2.y + f12);
        PointF pointF3 = dVar.f34107f;
        PointF pointF4 = dVar2.f34107f;
        pointF3.set(pointF4.x + f11, pointF4.y + f12);
        PointF pointF5 = dVar.f34108g;
        PointF pointF6 = dVar2.f34108g;
        pointF5.set(pointF6.x + f11, pointF6.y + f12);
        PointF pointF7 = dVar.f34109h;
        PointF pointF8 = dVar2.f34109h;
        pointF7.set(pointF8.x + f11, pointF8.y + f12);
        dVar.left = dVar2.left + f11;
        dVar.top = dVar2.top + f12;
        dVar.right = dVar2.right + f11;
        dVar.bottom = dVar2.bottom + f12;
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public void a(float f11, float f12, d dVar) {
        if (c()) {
            a(f11, f12, dVar, true);
            c(dVar);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    @android.annotation.SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(float r7, float r8, com.instabug.library.annotation.d r9, boolean r10) {
        /*
            r6 = this;
            android.graphics.PointF r0 = r9.f34106e
            r0.set(r7, r8)
            android.graphics.PointF r7 = r9.f34108g
            android.graphics.PointF r8 = r9.f34107f
            android.graphics.PointF r0 = r9.f34106e
            double r7 = com.instabug.library.annotation.utility.c.a((android.graphics.PointF) r7, (android.graphics.PointF) r8, (android.graphics.PointF) r0)
            float r7 = (float) r7
            android.graphics.PointF r8 = r9.f34106e
            float r0 = r8.x
            android.graphics.PointF r1 = r9.f34107f
            float r2 = r1.x
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 < 0) goto L_0x0036
            float r3 = r8.y
            float r4 = r1.y
            int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r5 >= 0) goto L_0x0025
            goto L_0x0036
        L_0x0025:
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x002d
            int r0 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x003c
        L_0x002d:
            int r0 = r6.f34161l
            int r0 = r0 + 180
            float r0 = (float) r0
            com.instabug.library.annotation.utility.c.a((float) r7, (float) r0, (android.graphics.PointF) r8, (android.graphics.PointF) r1)
            goto L_0x003c
        L_0x0036:
            int r0 = r6.f34161l
            float r0 = (float) r0
            com.instabug.library.annotation.utility.c.a((float) r7, (float) r0, (android.graphics.PointF) r8, (android.graphics.PointF) r1)
        L_0x003c:
            android.graphics.PointF r7 = r9.f34108g
            android.graphics.PointF r8 = r9.f34109h
            android.graphics.PointF r0 = r9.f34106e
            double r7 = com.instabug.library.annotation.utility.c.a((android.graphics.PointF) r7, (android.graphics.PointF) r8, (android.graphics.PointF) r0)
            float r7 = (float) r7
            android.graphics.PointF r8 = r9.f34106e
            float r0 = r8.y
            android.graphics.PointF r1 = r9.f34109h
            float r2 = r1.y
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 < 0) goto L_0x006d
            float r3 = r8.x
            float r4 = r1.x
            int r5 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x005c
            goto L_0x006d
        L_0x005c:
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x0064
            int r0 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x0075
        L_0x0064:
            int r0 = r6.f34161l
            int r0 = r0 + 270
            float r0 = (float) r0
            com.instabug.library.annotation.utility.c.a((float) r7, (float) r0, (android.graphics.PointF) r8, (android.graphics.PointF) r1)
            goto L_0x0075
        L_0x006d:
            int r0 = r6.f34161l
            int r0 = r0 + 90
            float r0 = (float) r0
            com.instabug.library.annotation.utility.c.a((float) r7, (float) r0, (android.graphics.PointF) r8, (android.graphics.PointF) r1)
        L_0x0075:
            if (r10 == 0) goto L_0x0081
            android.graphics.PointF r7 = r9.f34108g
            float r8 = r7.x
            float r7 = r7.y
            r10 = 0
            r6.c(r8, r7, r9, r10)
        L_0x0081:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.annotation.shape.f.a(float, float, com.instabug.library.annotation.d, boolean):void");
    }

    @SuppressLint({"ERADICATE_INCONSISTENT_SUBCLASS_PARAMETER_ANNOTATION"})
    public Path a(d dVar) {
        if (c() && !dVar.f34110i) {
            dVar.f34110i = true;
            float centerX = dVar.centerX();
            float centerY = dVar.centerY();
            PointF a11 = c.a(centerX, centerY, (float) this.f34161l, new PointF(dVar.left, dVar.top));
            PointF a12 = c.a(centerX, centerY, (float) this.f34161l, new PointF(dVar.right, dVar.top));
            PointF a13 = c.a(centerX, centerY, (float) this.f34161l, new PointF(dVar.right, dVar.bottom));
            PointF a14 = c.a(centerX, centerY, (float) this.f34161l, new PointF(dVar.left, dVar.bottom));
            dVar.f34106e.set(a11);
            dVar.f34107f.set(a12);
            dVar.f34108g.set(a13);
            dVar.f34109h.set(a14);
        }
        b(dVar);
        return this.f34162m;
    }
}
