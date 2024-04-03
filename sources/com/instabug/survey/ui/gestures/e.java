package com.instabug.survey.ui.gestures;

import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;

public abstract class e {

    /* renamed from: a  reason: collision with root package name */
    private static int f52515a = 5;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f52516b = false;

    /* renamed from: c  reason: collision with root package name */
    private static float f52517c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    private static int f52518d = -1;

    /* renamed from: e  reason: collision with root package name */
    private static float f52519e;

    /* renamed from: f  reason: collision with root package name */
    private static float f52520f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private static WeakReference f52521g;

    public static void a() {
        WeakReference weakReference = f52521g;
        if (weakReference != null) {
            weakReference.clear();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        if (r0 < f52518d) goto L_0x0042;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0101, code lost:
        if (r7 > r8) goto L_0x0103;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0095  */
    /* JADX WARNING: Removed duplicated region for block: B:72:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.view.MotionEvent r7, boolean r8, boolean r9, @androidx.annotation.NonNull com.instabug.survey.ui.gestures.d r10, android.view.View r11, android.view.ViewGroup.LayoutParams r12) {
        /*
            int r0 = r7.getActionMasked()
            if (r0 == 0) goto L_0x010d
            r1 = 1060320051(0x3f333333, float:0.7)
            r2 = 0
            r3 = -1
            r4 = 1
            if (r0 == r4) goto L_0x00a8
            r5 = 2
            if (r0 == r5) goto L_0x0013
            goto L_0x011f
        L_0x0013:
            float r0 = f52517c
            float r5 = r7.getRawY()
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r9 == 0) goto L_0x0031
            if (r0 >= 0) goto L_0x0020
            goto L_0x004e
        L_0x0020:
            float r0 = f52517c
            float r5 = r7.getRawY()
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x0080
            int r0 = r12.height
            int r5 = f52518d
            if (r0 >= r5) goto L_0x0080
            goto L_0x0042
        L_0x0031:
            if (r8 == 0) goto L_0x004c
            if (r0 >= 0) goto L_0x0036
            goto L_0x004e
        L_0x0036:
            float r0 = f52517c
            float r5 = r7.getRawY()
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x0080
            int r0 = r12.height
        L_0x0042:
            float r0 = (float) r0
            float r5 = f52517c
            float r6 = r7.getRawY()
            float r5 = r5 - r6
            float r0 = r0 + r5
            goto L_0x0059
        L_0x004c:
            if (r0 >= 0) goto L_0x0066
        L_0x004e:
            int r0 = r12.height
            float r0 = (float) r0
            float r5 = r7.getRawY()
            float r6 = f52517c
            float r5 = r5 - r6
            float r0 = r0 - r5
        L_0x0059:
            int r0 = (int) r0
            r12.height = r0
            r11.setLayoutParams(r12)
        L_0x005f:
            float r7 = r7.getRawY()
            f52517c = r7
            goto L_0x0080
        L_0x0066:
            float r0 = f52517c
            float r5 = r7.getRawY()
            int r0 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x0080
            int r0 = r12.height
            int r5 = f52518d
            if (r0 >= r5) goto L_0x005f
            float r0 = (float) r0
            float r5 = f52517c
            float r6 = r7.getRawY()
            float r5 = r5 - r6
            float r0 = r0 + r5
            goto L_0x0059
        L_0x0080:
            int r7 = r12.height
            float r7 = (float) r7
            if (r8 == 0) goto L_0x0095
            int r8 = f52518d
            float r8 = (float) r8
            float r7 = r7 / r8
            r8 = 1073741824(0x40000000, float:2.0)
            int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r7 <= 0) goto L_0x00a4
            if (r9 != 0) goto L_0x011f
            r10.b()
            goto L_0x00a4
        L_0x0095:
            int r8 = f52518d
            float r8 = (float) r8
            float r7 = r7 / r8
            int r7 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r7 >= 0) goto L_0x00a4
            f52516b = r4
            r10.e()
            goto L_0x010a
        L_0x00a4:
            f52516b = r2
            goto L_0x011f
        L_0x00a8:
            float r0 = r7.getX()
            float r7 = r7.getY()
            float r5 = f52519e
            float r6 = f52520f
            boolean r7 = a(r5, r0, r6, r7)
            if (r7 == 0) goto L_0x00ca
            if (r8 == 0) goto L_0x00ca
            boolean r7 = f52516b
            if (r7 != 0) goto L_0x00ca
            if (r9 != 0) goto L_0x00ca
            r10.b()
            f52516b = r4
            f52518d = r3
            r2 = r4
        L_0x00ca:
            boolean r7 = f52516b
            if (r7 != 0) goto L_0x0107
            int r7 = f52518d
            if (r8 == 0) goto L_0x00fd
            int r8 = r12.height
            if (r7 == r8) goto L_0x00e7
            if (r7 <= r8) goto L_0x00e7
            float r9 = (float) r8
            float r12 = (float) r7
            float r9 = r9 / r12
            int r9 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r9 >= 0) goto L_0x0103
            f52516b = r4
            r10.e()
            f52518d = r3
            goto L_0x0107
        L_0x00e7:
            if (r7 == r8) goto L_0x0107
            if (r7 >= r8) goto L_0x0107
            float r12 = (float) r8
            float r0 = (float) r7
            float r12 = r12 / r0
            r0 = 1068708659(0x3fb33333, float:1.4)
            int r12 = (r12 > r0 ? 1 : (r12 == r0 ? 0 : -1))
            if (r12 <= 0) goto L_0x0103
            if (r9 != 0) goto L_0x0108
            r10.b()
            f52518d = r3
            goto L_0x0108
        L_0x00fd:
            int r8 = r12.height
            if (r7 == r8) goto L_0x0107
            if (r7 <= r8) goto L_0x0107
        L_0x0103:
            a((android.view.View) r11, (int) r8, (int) r7)
            goto L_0x0108
        L_0x0107:
            r4 = r2
        L_0x0108:
            if (r4 == 0) goto L_0x011f
        L_0x010a:
            f52518d = r3
            goto L_0x011f
        L_0x010d:
            float r8 = r7.getX()
            f52519e = r8
            float r8 = r7.getY()
            f52520f = r8
            float r7 = r7.getRawY()
            f52517c = r7
        L_0x011f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.survey.ui.gestures.e.a(android.view.MotionEvent, boolean, boolean, com.instabug.survey.ui.gestures.d, android.view.View, android.view.ViewGroup$LayoutParams):void");
    }

    private static void a(View view, int i11, int i12) {
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{i11, i12});
        ofInt.addUpdateListener(new c(view));
        ofInt.setDuration(300);
        ofInt.start();
    }

    public static void a(View view, MotionEvent motionEvent, @NonNull d dVar) {
        WeakReference weakReference = f52521g;
        if (weakReference == null || weakReference.get() == null) {
            f52521g = new WeakReference(dVar);
        }
        View view2 = (View) view.getParent();
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (f52518d == -1) {
            f52518d = layoutParams.height;
        }
        a(motionEvent, false, false, dVar, view2, layoutParams);
    }

    public static void a(View view, MotionEvent motionEvent, boolean z11, boolean z12, @NonNull d dVar) {
        WeakReference weakReference = f52521g;
        if (weakReference == null || weakReference.get() == null) {
            f52521g = new WeakReference(dVar);
        }
        ViewParent parent = view.getParent();
        if (!z11) {
            parent = parent.getParent().getParent().getParent();
        }
        View view2 = (View) parent;
        ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
        if (f52518d == -1) {
            f52518d = layoutParams.height;
        }
        a(motionEvent, z11, z12, dVar, view2, layoutParams);
    }

    private static boolean a(float f11, float f12, float f13, float f14) {
        float abs = Math.abs(f11 - f12);
        float abs2 = Math.abs(f13 - f14);
        float f15 = (float) f52515a;
        return abs <= f15 && abs2 <= f15;
    }

    public static void b() {
        f52518d = -1;
        f52517c = -1.0f;
    }
}
