package com.uxcam.internals;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.ViewGroup;
import com.google.android.gms.maps.GoogleMap;
import com.newrelic.agent.android.harvest.AgentHealth;
import com.uxcam.datamodel.UXCamBlur;
import com.uxcam.datamodel.UXCamOcclusion;
import com.uxcam.datamodel.UXCamOverlay;
import java.lang.ref.WeakReference;
import mz.f;
import mz.g;
import mz.h;
import mz.i;

public class fm {

    /* renamed from: a  reason: collision with root package name */
    public static int f13362a = 0;

    /* renamed from: b  reason: collision with root package name */
    public static Bitmap f13363b = null;

    /* renamed from: c  reason: collision with root package name */
    public static int f13364c = -1;

    /* renamed from: d  reason: collision with root package name */
    public static boolean f13365d = false;

    /* renamed from: e  reason: collision with root package name */
    public static boolean f13366e = false;

    /* renamed from: f  reason: collision with root package name */
    public static WeakReference f13367f;

    /* renamed from: g  reason: collision with root package name */
    public static GoogleMap f13368g;

    /* renamed from: h  reason: collision with root package name */
    public static int f13369h;

    /* renamed from: i  reason: collision with root package name */
    public static int f13370i;

    /* renamed from: j  reason: collision with root package name */
    public static ce f13371j;

    /* renamed from: k  reason: collision with root package name */
    public static UXCamOcclusion f13372k;

    public static void a(Bitmap bitmap, fu fuVar, eh ehVar, int i11, boolean z11) {
        if (!id.a()) {
            al a11 = al.a();
            a11.f13000b = bitmap;
            a11.f12999a.add(bitmap);
        } else {
            b(bitmap);
            al.a().a(b(bitmap));
        }
        if (!fuVar.f13413b) {
            ehVar.a((Bitmap) null);
        }
        hl.a("Helper Orientation ").append(f13364c);
        if (!z11) {
            ehVar.a(bitmap);
            return;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        ehVar.a(Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true));
    }

    public static void b(eh ehVar) {
        int size = fn.f13375f.size();
        f13362a++;
        if (size < 10) {
            a((Bitmap) null, (eh) new f(size, ehVar));
        }
    }

    public static boolean b() {
        boolean z11 = ee.c(hb.f13528k) || hh.f13548g;
        boolean z12 = f13366e;
        f13366e = z11;
        if (z12 || z11) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(android.app.Activity r4) {
        /*
            r0 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r4 = r4.findViewById(r0)
            android.view.View r4 = r4.getRootView()
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            com.uxcam.internals.fs r0 = com.uxcam.internals.fs.a()
            com.uxcam.internals.gd r0 = r0.f13405h
            int r1 = f13369h
            com.uxcam.internals.ge r0 = (com.uxcam.internals.ge) r0
            r0.getClass()
            android.graphics.Rect r0 = new android.graphics.Rect
            r0.<init>()
            r4.getWindowVisibleDisplayFrame(r0)
            int r4 = r0.height()
            r2 = -1
            if (r1 == 0) goto L_0x0036
            int r3 = r4 + 150
            if (r1 <= r3) goto L_0x0030
            int r0 = r0.bottom
            goto L_0x0037
        L_0x0030:
            int r1 = r1 + 150
            if (r1 >= r4) goto L_0x0036
            r0 = 0
            goto L_0x0037
        L_0x0036:
            r0 = r2
        L_0x0037:
            f13369h = r4
            if (r0 == r2) goto L_0x003d
            f13370i = r0
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.fm.b(android.app.Activity):void");
    }

    public static void a(Bitmap bitmap) {
        al.a().a(bitmap.copy(bitmap.getConfig(), false));
        al.a().f12999a.size();
    }

    public static Bitmap b(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate(90.0f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public static void a(boolean z11, eh ehVar) {
        if (z11) {
            try {
                a(ehVar);
            } catch (Exception e11) {
                fx a11 = new fx().a(AgentHealth.DEFAULT_KEY);
                a11.a("site_of_error", "ScreenShotHelper::takeScreenshotShotAndEncode()");
                a11.a("reason", e11.getMessage());
                a11.a("", "").a(2);
            }
        } else {
            b(ehVar);
        }
    }

    public static void a(eh ehVar) {
        int i11 = fn.f13385p;
        if (i11 > 0) {
            fn.f13385p = i11 - 1;
        } else {
            a((Bitmap) null, (eh) new h(ehVar));
        }
    }

    public static /* synthetic */ void a(eh ehVar, Bitmap bitmap) {
        if (bitmap != null && fn.f13379j) {
            a(bitmap);
        }
        ehVar.a(bitmap);
    }

    public static /* synthetic */ void a(int i11, eh ehVar, Bitmap bitmap) {
        fn.f13375f.a(new fk(bitmap, i11, f13362a));
        ehVar.a(bitmap);
    }

    public static void a(Bitmap bitmap, eh ehVar) {
        int i11;
        int i12;
        eh ehVar2;
        Activity activity = (Activity) ia.c();
        int i13 = activity.getResources().getConfiguration().orientation;
        if (f13364c != i13 && !f13365d) {
            f13364c = i13;
            gu.a("scrolltest 2").getClass();
            hb.c().f13531b.a(10, 0.0f, 0.0f);
            f13369h = 0;
            f13370i = 0;
        }
        Bitmap bitmap2 = null;
        if (f13365d) {
            Bitmap bitmap3 = al.a().f13000b;
            if (bitmap3 != null) {
                if (a()) {
                    a(bitmap3);
                }
                ehVar2 = ehVar;
                bitmap2 = bitmap3;
            } else {
                ehVar2 = ehVar;
            }
            ehVar2.a(bitmap2);
        } else {
            eh ehVar3 = ehVar;
        }
        DisplayMetrics displayMetrics = activity.getResources().getDisplayMetrics();
        boolean z11 = displayMetrics.widthPixels > displayMetrics.heightPixels;
        if (z11) {
            i12 = fl.a().f13358c;
            i11 = fl.a().f13359d;
        } else {
            i12 = fl.a().f13359d;
            i11 = fl.a().f13358c;
        }
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
        }
        if (bitmap2.getHeight() != i12) {
            bitmap2 = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
        }
        try {
            fu fuVar = new fu();
            b(activity);
            a(activity);
            fuVar.a(new fv(activity, bitmap2, b(), f13367f, f13368g, f13371j, a(), !gm.I && Build.VERSION.SDK_INT >= 26, hb.f13528k), (eh) new g(activity, fuVar, ehVar, i13, z11));
        } catch (Exception e11) {
            e11.printStackTrace();
            new Paint().setColor(-16776961);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x01b2 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.app.Activity r19, com.uxcam.internals.fu r20, com.uxcam.internals.eh r21, int r22, boolean r23, android.graphics.Bitmap r24) {
        /*
            r7 = r24
            if (r7 == 0) goto L_0x033e
            com.uxcam.internals.fs r0 = com.uxcam.internals.fs.a()
            com.uxcam.internals.fc r0 = r0.f13408k
            com.uxcam.internals.fd r0 = (com.uxcam.internals.fd) r0
            r1 = r19
            java.util.List r0 = r0.a(r1)
            java.util.Iterator r1 = r0.iterator()
        L_0x0016:
            boolean r0 = r1.hasNext()
            r2 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r3 = 1077936128(0x40400000, float:3.0)
            r4 = 1
            r5 = 2
            if (r0 == 0) goto L_0x028d
            java.lang.Object r0 = r1.next()
            com.uxcam.internals.io r0 = (com.uxcam.internals.io) r0
            com.uxcam.internals.hb r6 = com.uxcam.internals.hb.c()
            java.lang.String r10 = r6.d()
            com.uxcam.internals.fs r6 = com.uxcam.internals.fs.a()
            com.uxcam.internals.gd r6 = r6.f13405h
            android.view.View r8 = r0.f13662a
            r9 = r8
            android.view.ViewGroup r9 = (android.view.ViewGroup) r9
            java.util.ArrayList r11 = com.uxcam.internals.fn.f13382m
            int r8 = com.uxcam.internals.gm.f13452a
            java.lang.String r8 = com.uxcam.internals.hb.f13528k
            com.uxcam.datamodel.UXCamOccludeAllTextFields r13 = com.uxcam.internals.ee.a((java.lang.String) r8)
            r8 = r6
            com.uxcam.internals.ge r8 = (com.uxcam.internals.ge) r8
            r12 = 1
            com.uxcam.internals.gf r6 = r8.a(r9, r10, r11, r12, r13)
            java.util.ArrayList r8 = com.uxcam.internals.fn.f13382m
            java.util.List r9 = r6.f13432a
            r8.addAll(r9)
            java.util.ArrayList r8 = com.uxcam.internals.fn.f13382m
            java.util.List r9 = r6.f13433b
            r8.removeAll(r9)
            java.lang.ref.WeakReference r6 = r6.f13434c
            if (r6 == 0) goto L_0x0061
            com.uxcam.internals.fn.f13381l = r6
        L_0x0061:
            android.content.Context r6 = com.uxcam.internals.ia.f13617c
            android.graphics.Point r6 = com.uxcam.internals.bm.c(r6)
            int r8 = r6.y
            int r6 = r6.x
            int r9 = r24.getWidth()
            float r9 = (float) r9
            float r6 = (float) r6
            float r9 = r9 / r6
            android.graphics.Canvas r6 = new android.graphics.Canvas
            r6.<init>(r7)
            android.graphics.Rect r10 = r0.f13663b
            int r11 = r10.left
            float r11 = (float) r11
            float r11 = r11 * r9
            int r10 = r10.top
            float r10 = (float) r10
            float r10 = r10 * r9
            r6.translate(r11, r10)
            r6.scale(r9, r9)
            java.lang.Class<com.uxcam.internals.ey> r10 = com.uxcam.internals.ey.class
            monitor-enter(r10)
            com.uxcam.internals.ey r11 = com.uxcam.internals.ey.f13303b     // Catch:{ all -> 0x028a }
            if (r11 != 0) goto L_0x0095
            com.uxcam.internals.ey r11 = new com.uxcam.internals.ey     // Catch:{ all -> 0x028a }
            r11.<init>()     // Catch:{ all -> 0x028a }
            com.uxcam.internals.ey.f13303b = r11     // Catch:{ all -> 0x028a }
        L_0x0095:
            com.uxcam.internals.ey r11 = com.uxcam.internals.ey.f13303b     // Catch:{ all -> 0x028a }
            monitor-exit(r10)
            com.uxcam.internals.bf r10 = r11.f13304a
            java.util.List r10 = r10.f13062a
            java.util.List r16 = java.util.Collections.unmodifiableList(r10)
            int r10 = r24.getWidth()
            float r10 = (float) r10
            float r10 = r10 / r9
            int r10 = (int) r10
            int r11 = r24.getHeight()
            float r11 = (float) r11
            float r11 = r11 / r9
            int r11 = (int) r11
            android.graphics.Paint r12 = new android.graphics.Paint
            r12.<init>()
            r12.setAntiAlias(r4)
            r12.setColor(r2)
            android.graphics.Paint$Style r2 = android.graphics.Paint.Style.FILL
            r12.setStyle(r2)
            android.graphics.Rect r2 = new android.graphics.Rect
            r15 = 0
            r2.<init>(r15, r8, r10, r11)
            r6.drawRect(r2, r12)
            int r2 = r2.height()
            float r2 = (float) r2
            float r2 = r2 * r9
            int r2 = (int) r2
            com.uxcam.internals.hb.f13526i = r2
            com.uxcam.internals.fs r2 = com.uxcam.internals.fs.a()
            com.uxcam.internals.gg r2 = r2.f13404g
            android.view.View r8 = r0.f13662a
            java.util.ArrayList r0 = com.uxcam.internals.fn.f13382m
            com.uxcam.internals.gh r2 = (com.uxcam.internals.gh) r2
            r2.getClass()
            boolean r2 = r0.isEmpty()
            r9 = -65536(0xffffffffffff0000, float:NaN)
            if (r2 != 0) goto L_0x01ac
            java.util.Iterator r2 = r0.iterator()
        L_0x00eb:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x01ac
            java.lang.Object r0 = r2.next()
            com.uxcam.internals.hr r0 = (com.uxcam.internals.hr) r0
            java.lang.ref.WeakReference r10 = r0.f13590b
            java.lang.Object r10 = r10.get()
            if (r10 == 0) goto L_0x00eb
            java.lang.ref.WeakReference r10 = r0.f13590b
            java.lang.Object r10 = r10.get()
            android.view.View r10 = (android.view.View) r10
            boolean r10 = r10.isShown()
            if (r10 == 0) goto L_0x00eb
            java.lang.ref.WeakReference r10 = r0.f13590b
            java.lang.Object r10 = r10.get()
            android.view.View r10 = (android.view.View) r10
            int r10 = r10.getVisibility()
            if (r10 != 0) goto L_0x00eb
            java.lang.ref.WeakReference r0 = r0.f13590b
            java.lang.Object r0 = r0.get()
            android.view.View r0 = (android.view.View) r0
            int[] r10 = new int[r5]     // Catch:{ Exception -> 0x0177 }
            r0.getLocationOnScreen(r10)     // Catch:{ Exception -> 0x0177 }
            android.graphics.Paint r14 = new android.graphics.Paint     // Catch:{ Exception -> 0x0177 }
            r14.<init>()     // Catch:{ Exception -> 0x0177 }
            r14.setColor(r9)     // Catch:{ Exception -> 0x0177 }
            r14.setStrokeWidth(r3)     // Catch:{ Exception -> 0x0177 }
            android.os.IBinder r11 = r8.getWindowToken()     // Catch:{ Exception -> 0x0177 }
            if (r11 == 0) goto L_0x0147
            android.os.IBinder r11 = r8.getWindowToken()     // Catch:{ Exception -> 0x0177 }
            android.os.IBinder r12 = r0.getWindowToken()     // Catch:{ Exception -> 0x0177 }
            boolean r11 = r11.equals(r12)     // Catch:{ Exception -> 0x0177 }
            if (r11 == 0) goto L_0x00eb
        L_0x0147:
            int[] r11 = new int[r5]     // Catch:{ Exception -> 0x0177 }
            r8.getLocationOnScreen(r11)     // Catch:{ Exception -> 0x0177 }
            r12 = r10[r15]     // Catch:{ Exception -> 0x0177 }
            r13 = r11[r15]     // Catch:{ Exception -> 0x0177 }
            int r12 = r12 - r13
            float r12 = (float) r12     // Catch:{ Exception -> 0x0177 }
            r10 = r10[r4]     // Catch:{ Exception -> 0x0177 }
            r11 = r11[r4]     // Catch:{ Exception -> 0x0177 }
            int r10 = r10 - r11
            float r13 = (float) r10     // Catch:{ Exception -> 0x0177 }
            int r10 = r0.getWidth()     // Catch:{ Exception -> 0x0177 }
            float r10 = (float) r10     // Catch:{ Exception -> 0x0177 }
            float r17 = r12 + r10
            int r0 = r0.getHeight()     // Catch:{ Exception -> 0x0177 }
            float r0 = (float) r0
            float r0 = r0 + r13
            r10 = r6
            r11 = r12
            r12 = r13
            r13 = r17
            r17 = r14
            r14 = r0
            r18 = r15
            r15 = r17
            r10.drawRect(r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x0175 }
            goto L_0x01a8
        L_0x0175:
            r0 = move-exception
            goto L_0x017a
        L_0x0177:
            r0 = move-exception
            r18 = r15
        L_0x017a:
            r10 = -7829368(0xffffffffff888888, float:NaN)
            r6.drawColor(r10)
            r0.printStackTrace()
            com.uxcam.internals.fx r10 = new com.uxcam.internals.fx
            r10.<init>()
            java.lang.String r11 = "EXCEPTION"
            r10.a((java.lang.String) r11)
            java.lang.String r11 = "site_of_error"
            java.lang.String r12 = "ScreenshotTaker::drawOverlayInViewRed()"
            r10.a((java.lang.String) r11, (java.lang.String) r12)
            java.lang.String r0 = r0.getMessage()
            java.lang.String r11 = "reason"
            r10.a((java.lang.String) r11, (java.lang.String) r0)
            java.lang.String r0 = "context"
            java.lang.String r11 = "Could not add red overlay to the occluded view."
            com.uxcam.internals.fx r0 = r10.a((java.lang.String) r0, (java.lang.String) r11)
            r0.a((int) r5)
        L_0x01a8:
            r15 = r18
            goto L_0x00eb
        L_0x01ac:
            r18 = r15
            java.util.Iterator r0 = r16.iterator()
        L_0x01b2:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0258
            java.lang.Object r2 = r0.next()
            com.uxcam.datamodel.OccludeComposable r2 = (com.uxcam.datamodel.OccludeComposable) r2
            java.lang.ref.WeakReference r5 = r2.getView()
            java.lang.Object r5 = r5.get()
            if (r5 == 0) goto L_0x01b2
            androidx.compose.ui.layout.LayoutCoordinates r5 = r2.getLayoutCoordinates()
            java.lang.ref.WeakReference r8 = r2.getView()
            java.lang.Object r8 = r8.get()
            android.view.View r8 = (android.view.View) r8
            boolean r10 = r5.isAttached()
            if (r10 != 0) goto L_0x01dd
            goto L_0x021b
        L_0x01dd:
            android.graphics.Rect r10 = new android.graphics.Rect
            r10.<init>()
            boolean r8 = r8.getGlobalVisibleRect(r10)
            if (r8 != 0) goto L_0x01e9
            goto L_0x021b
        L_0x01e9:
            androidx.compose.ui.geometry.Rect r5 = androidx.compose.ui.layout.LayoutCoordinatesKt.boundsInWindow(r5)
            float r8 = r5.getTop()
            int r11 = r10.top
            float r11 = (float) r11
            int r8 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r8 < 0) goto L_0x021b
            float r8 = r5.getLeft()
            int r11 = r10.left
            float r11 = (float) r11
            int r8 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r8 < 0) goto L_0x021b
            float r8 = r5.getRight()
            int r11 = r10.right
            float r11 = (float) r11
            int r8 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r8 > 0) goto L_0x021b
            float r5 = r5.getBottom()
            int r8 = r10.bottom
            float r8 = (float) r8
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 > 0) goto L_0x021b
            r15 = r4
            goto L_0x021d
        L_0x021b:
            r15 = r18
        L_0x021d:
            if (r15 == 0) goto L_0x01b2
            android.graphics.Paint r15 = new android.graphics.Paint
            r15.<init>()
            r15.setColor(r9)
            r15.setStrokeWidth(r3)
            float r5 = r2.getX()
            float r8 = r2.getParentX()
            float r11 = r8 + r5
            float r5 = r2.getY()
            float r8 = r2.getParentY()
            float r12 = r8 + r5
            float r5 = r2.getRight()
            float r8 = r2.getParentX()
            float r13 = r8 + r5
            float r5 = r2.getBottom()
            float r2 = r2.getParentY()
            float r14 = r2 + r5
            r10 = r6
            r10.drawRect(r11, r12, r13, r14, r15)
            goto L_0x01b2
        L_0x0258:
            java.util.ArrayList r0 = com.uxcam.internals.fn.f13383n
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0281
            java.util.ArrayList r0 = com.uxcam.internals.fn.f13383n
            java.util.Iterator r0 = r0.iterator()
        L_0x0266:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0281
            java.lang.Object r2 = r0.next()
            android.graphics.Rect r2 = (android.graphics.Rect) r2
            android.graphics.Paint r4 = new android.graphics.Paint
            r4.<init>()
            r4.setColor(r9)
            r4.setStrokeWidth(r3)
            r6.drawRect(r2, r4)
            goto L_0x0266
        L_0x0281:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            com.uxcam.internals.fn.f13383n = r0
            goto L_0x0016
        L_0x028a:
            r0 = move-exception
            monitor-exit(r10)
            throw r0
        L_0x028d:
            android.graphics.Paint r0 = new android.graphics.Paint
            r0.<init>()
            r1 = -3355444(0xffffffffffcccccc, float:NaN)
            r0.setColor(r1)
            r0.setStrokeWidth(r3)
            android.graphics.Paint r1 = new android.graphics.Paint
            r1.<init>()
            r1.setColor(r2)
            r1.setAntiAlias(r4)
            r2 = 1098907648(0x41800000, float:16.0)
            r1.setTextSize(r2)
            com.uxcam.internals.fs r2 = com.uxcam.internals.fs.a()
            com.uxcam.internals.di r2 = r2.f13406i
            int r3 = f13370i
            com.uxcam.internals.fl r4 = com.uxcam.internals.fl.a()
            float r4 = r4.f13356a
            android.graphics.Canvas r6 = new android.graphics.Canvas
            r6.<init>(r7)
            com.uxcam.internals.dj r2 = (com.uxcam.internals.dj) r2
            r2.getClass()
            if (r3 <= 0) goto L_0x0326
            float r2 = (float) r3
            float r2 = r2 * r4
            int r2 = (int) r2
            r12 = 0
            int r3 = r6.getWidth()     // Catch:{ Exception -> 0x02f7 }
            float r14 = (float) r3     // Catch:{ Exception -> 0x02f7 }
            int r3 = r6.getHeight()     // Catch:{ Exception -> 0x02f7 }
            float r15 = (float) r3     // Catch:{ Exception -> 0x02f7 }
            float r13 = (float) r2     // Catch:{ Exception -> 0x02f7 }
            r11 = r6
            r16 = r0
            r11.drawRect(r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x02f7 }
            int r0 = r6.getWidth()     // Catch:{ Exception -> 0x02f7 }
            int r0 = r0 / r5
            java.lang.String r3 = "Keyboard"
            float r3 = r1.measureText(r3)     // Catch:{ Exception -> 0x02f7 }
            int r3 = (int) r3     // Catch:{ Exception -> 0x02f7 }
            int r3 = r3 / r5
            int r0 = r0 - r3
            int r3 = r6.getHeight()     // Catch:{ Exception -> 0x02f7 }
            int r3 = r3 - r2
            int r3 = r3 / r5
            int r2 = r2 + r3
            java.lang.String r3 = "Keyboard"
            float r0 = (float) r0     // Catch:{ Exception -> 0x02f7 }
            float r2 = (float) r2     // Catch:{ Exception -> 0x02f7 }
            r6.drawText(r3, r0, r2, r1)     // Catch:{ Exception -> 0x02f7 }
            goto L_0x0326
        L_0x02f7:
            r0 = move-exception
            r1 = -65281(0xffffffffffff00ff, float:NaN)
            r6.drawColor(r1)
            r0.printStackTrace()
            com.uxcam.internals.fx r1 = new com.uxcam.internals.fx
            r1.<init>()
            java.lang.String r2 = "EXCEPTION"
            r1.a((java.lang.String) r2)
            java.lang.String r2 = "site_of_error"
            java.lang.String r3 = "ScreenshotTaker::drawKeyboardOverlay()"
            r1.a((java.lang.String) r2, (java.lang.String) r3)
            java.lang.String r0 = r0.getMessage()
            java.lang.String r2 = "reason"
            r1.a((java.lang.String) r2, (java.lang.String) r0)
            java.lang.String r0 = "context"
            java.lang.String r2 = "There was some error drawing the keyboard layout on the canvas."
            com.uxcam.internals.fx r0 = r1.a((java.lang.String) r0, (java.lang.String) r2)
            r0.a((int) r5)
        L_0x0326:
            boolean r0 = b()
            mz.e r8 = new mz.e
            r1 = r8
            r2 = r24
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r1.<init>(r2, r3, r4, r5, r6)
            a((android.graphics.Bitmap) r7, (boolean) r0, (com.uxcam.internals.cj) r8)
            goto L_0x0344
        L_0x033e:
            r0 = 0
            r1 = r21
            r1.a(r0)
        L_0x0344:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.fm.a(android.app.Activity, com.uxcam.internals.fu, com.uxcam.internals.eh, int, boolean, android.graphics.Bitmap):void");
    }

    public static void a(Bitmap bitmap, boolean z11, cj cjVar) {
        if (z11) {
            Canvas canvas = new Canvas(bitmap);
            i iVar = new i(bitmap, cjVar);
            ck ckVar = fs.a().f13400c;
            UXCamOcclusion b11 = ee.b(hb.f13528k);
            if (b11 == null) {
                b11 = f13372k;
                f13372k = null;
            } else {
                f13372k = b11;
            }
            Context context = ia.f13617c;
            cl clVar = (cl) ckVar;
            clVar.getClass();
            if (b11 == null) {
                iVar.a();
            } else if (b11.getClass() == UXCamOverlay.class) {
                canvas.drawColor(((UXCamOverlay) b11).f12938b);
                iVar.a();
            } else if (b11.getClass() == UXCamBlur.class) {
                clVar.a(((UXCamBlur) b11).f12931a, bitmap, context, iVar);
            }
        } else {
            cjVar.a();
        }
    }

    public static void a(Bitmap bitmap, cj cjVar) {
        int i11 = gm.f13452a;
        cjVar.a();
    }

    public static boolean a() {
        if (!hm.e().f12946f) {
            return false;
        }
        if (!gm.I && Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    public static void a(Activity activity) {
        if (ia.a("io.flutter.app.FlutterApplication") || ia.a("io.flutter.embedding.android.FlutterView") || ia.a("io.flutter.embedding.engine.FlutterJNI")) {
            f13371j = ((cg) fs.a().f13407j).a((ViewGroup) activity.findViewById(16908290).getRootView());
            gm.I = true;
        }
    }
}
