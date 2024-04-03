package com.uxcam.internals;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import com.google.android.gms.maps.GoogleMap;
import io.flutter.embedding.android.FlutterSurfaceView;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import mz.k;
import mz.l;
import mz.m;
import mz.n;
import mz.o;
import mz.p;
import mz.q;

public final class fu {

    /* renamed from: c  reason: collision with root package name */
    public static CountDownLatch f13411c = new CountDownLatch(1);

    /* renamed from: a  reason: collision with root package name */
    public final CountDownLatch f13412a = new CountDownLatch(2);

    /* renamed from: b  reason: collision with root package name */
    public boolean f13413b = false;

    public void a(fv fvVar, eh ehVar) {
        if (fvVar.f13414a != null) {
            a(false, fvVar.f13421h);
            if (fn.f13379j) {
                Bitmap bitmap = fvVar.f13415b;
                new Canvas(bitmap).drawColor(Color.rgb(200, 0, 0));
                this.f13412a.countDown();
                ehVar.a(bitmap);
                return;
            }
            List<io> a11 = ((fd) fs.a().f13408k).a(fvVar.f13414a);
            if (fvVar.f13419f) {
                Rect rect = new Rect();
                io ioVar = null;
                for (io ioVar2 : a11) {
                    Rect rect2 = ioVar2.f13663b;
                    if (rect.width() < rect2.width() && rect.height() < rect2.height()) {
                        rect = new Rect(rect2);
                        ioVar = new io(ioVar2.f13662a, ioVar2.f13663b, ioVar2.f13664c);
                    }
                }
                if (ioVar != null) {
                    ArrayList arrayList = (ArrayList) a11;
                    arrayList.clear();
                    arrayList.add(ioVar);
                }
            }
            a((List) a11, ehVar, (ei) new p(fvVar), fvVar);
            if (gm.F) {
                fj.a();
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Parameter activity cannot be null.");
    }

    /* access modifiers changed from: private */
    public void a(List list, fv fvVar, eh ehVar, ei eiVar) {
        try {
            a(list, fvVar.f13415b, ehVar, eiVar, fvVar);
            this.f13412a.countDown();
            if (fvVar.f13419f) {
                return;
            }
        } catch (Exception e11) {
            fx fxVar = new fx();
            fxVar.a("EXCEPTION");
            fxVar.a("site_of_error", "ScreenShotTaker::takeBitmapUnchecked() -> runOnUiThread");
            fxVar.a("reason", e11.getMessage());
            fxVar.a(2);
            ehVar.a((Bitmap) null);
            this.f13412a.countDown();
            if (fvVar.f13419f) {
                return;
            }
        } catch (Throwable th2) {
            this.f13412a.countDown();
            if (!fvVar.f13419f) {
                this.f13412a.countDown();
            }
            throw th2;
        }
        this.f13412a.countDown();
    }

    public static void a(boolean z11, String str) {
        try {
            ip ipVar = fs.a().f13401d;
            WeakReference weakReference = fn.f13381l;
            if (weakReference != null && weakReference.get() != null) {
                f13411c = new CountDownLatch(1);
                if (z11) {
                    ((iq) ipVar).a(str);
                } else {
                    new Handler(Looper.getMainLooper()).post(new m(ipVar, str));
                }
                f13411c.await(20, TimeUnit.MILLISECONDS);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            fx fxVar = new fx();
            fxVar.a("EXCEPTION");
            fxVar.a("site_of_error", "ScreenshotTaker::scanWebViewForOccludedView()");
            fxVar.a("reason", e11.getMessage());
            fxVar.a(2);
        }
    }

    @SuppressLint({"NewApi"})
    public final void a(Canvas canvas, io ioVar, Bitmap bitmap, fv fvVar, eh ehVar) {
        try {
            if (!fvVar.f13420g || !fvVar.f13419f) {
                a(ioVar, bitmap, canvas, ehVar, fvVar);
            } else {
                a(bitmap, canvas, ioVar, ehVar);
            }
        } catch (IllegalArgumentException e11) {
            gu.f13504c.getClass();
            fx fxVar = new fx();
            fxVar.a("site_of_error", "ScreenshotTaker::drawRootToBitmap");
            fxVar.a("reason", e11.getMessage());
            fxVar.a(2);
            if (fvVar.f13419f) {
                this.f13412a.countDown();
            }
            ehVar.a((Bitmap) null);
        } catch (Exception e12) {
            fx fxVar2 = new fx();
            fxVar2.a("reason", e12.getMessage());
            fxVar2.a("site_of_error", "ScreenshotTaker");
            fxVar2.a(2);
            if (fvVar.f13419f) {
                this.f13412a.countDown();
            }
            ehVar.a((Bitmap) null);
        }
    }

    public static void a(fv fvVar, io ioVar, Bitmap bitmap) {
        a(true, fvVar.f13421h);
    }

    public final ft a(Bitmap bitmap) {
        Point c11 = bm.c(ia.f13617c);
        return new ft(c11.y, ((float) bitmap.getWidth()) / ((float) c11.x));
    }

    public final Canvas a(ft ftVar, Bitmap bitmap, io ioVar) {
        Canvas canvas = new Canvas(bitmap);
        Rect rect = ioVar.f13663b;
        float f11 = ftVar.f13410b;
        canvas.translate(((float) rect.left) * f11, ((float) rect.top) * f11);
        float f12 = ftVar.f13410b;
        canvas.scale(f12, f12);
        return canvas;
    }

    public final void a(List list, eh ehVar, ei eiVar, fv fvVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            a(list, fvVar.f13415b, ehVar, eiVar, fvVar);
            return;
        }
        fvVar.f13414a.runOnUiThread(new n(this, list, fvVar, ehVar, eiVar));
        this.f13412a.await(500, TimeUnit.MILLISECONDS);
    }

    public final void a(List list, Bitmap bitmap, eh ehVar, ei eiVar, fv fvVar) {
        this.f13413b = true;
        if (list.size() == 0) {
            this.f13412a.countDown();
            ehVar.a(bitmap);
        } else if (!fvVar.f13419f) {
            a(list, bitmap, ehVar, fvVar, eiVar);
        } else {
            a(a(a(bitmap), bitmap, (io) list.get(0)), (io) list.get(0), bitmap, fvVar, (eh) new k(eiVar, list, ehVar));
        }
    }

    public static /* synthetic */ void a(ei eiVar, List list, eh ehVar, Bitmap bitmap) {
        eiVar.a((io) list.get(0), bitmap);
        ehVar.a(bitmap);
    }

    public final void a(List list, Bitmap bitmap, eh ehVar, fv fvVar, ei eiVar) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            io ioVar = (io) it.next();
            a(a(a(bitmap), bitmap, ioVar), ioVar, bitmap, fvVar, (eh) new o(eiVar, ioVar));
        }
        ehVar.a(bitmap);
    }

    public static /* synthetic */ void a(ei eiVar, io ioVar, Bitmap bitmap) {
        gu.a("occlusion").getClass();
        eiVar.a(ioVar, bitmap);
    }

    @RequiresApi(api = 26)
    public final void a(Bitmap bitmap, Canvas canvas, io ioVar, eh ehVar) {
        q qVar = new q(this, ehVar);
        gd gdVar = fs.a().f13405h;
        ArrayList<hr> arrayList = fn.f13382m;
        ((ge) gdVar).getClass();
        ArrayList arrayList2 = new ArrayList();
        arrayList.size();
        for (hr hrVar : arrayList) {
            View view = (View) hrVar.f13590b.get();
            View view2 = ioVar.f13662a;
            if (view2 != null && view != null && view.getVisibility() == 0 && view.isShown()) {
                int[] iArr = new int[2];
                view.getLocationOnScreen(iArr);
                int[] iArr2 = new int[2];
                view2.getLocationOnScreen(iArr2);
                float f11 = (float) (iArr[0] - iArr2[0]);
                float f12 = (float) (iArr[1] - iArr2[1]);
                arrayList2.add(new RectF(f11, f12, ((float) view.getWidth()) + f11, ((float) view.getHeight()) + f12));
            }
        }
        ((eo) fs.a().f13399b).a(new en(bitmap, canvas, qVar, arrayList2));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(eh ehVar, Bitmap bitmap) {
        this.f13412a.countDown();
        ehVar.a(bitmap);
    }

    public final void a(io ioVar, Bitmap bitmap, Canvas canvas, eh ehVar, fv fvVar) {
        List list;
        List list2;
        io ioVar2 = ioVar;
        Canvas canvas2 = canvas;
        fv fvVar2 = fvVar;
        ce ceVar = fvVar2.f13418e;
        GoogleMap googleMap = fvVar2.f13417d;
        int i11 = Build.VERSION.SDK_INT;
        boolean z11 = gm.H;
        WeakReference weakReference = fn.f13381l;
        boolean z12 = gm.I;
        dn dnVar = new dn(ioVar, bitmap, canvas, ceVar, googleMap, i11, z11, weakReference, z12, fvVar2.f13416c, fm.f13363b);
        dm dmVar = fs.a().f13398a;
        l lVar = new l();
        Cdo doVar = (Cdo) dmVar;
        doVar.getClass();
        WindowManager.LayoutParams layoutParams = ioVar2.f13664c;
        if ((layoutParams.flags & 2) == 2) {
            canvas2.drawARGB((int) (layoutParams.dimAmount * 255.0f), 0, 0, 0);
        }
        if (ioVar2.f13662a.isAttachedToWindow()) {
            if (!z11 || weakReference == null || weakReference.get() == null) {
                ioVar2.f13662a.draw(canvas2);
            } else {
                View view = ioVar2.f13662a;
                view.setDrawingCacheEnabled(true);
                canvas2.drawBitmap(view.getDrawingCache(), 0.0f, 0.0f, (Paint) null);
                view.setDrawingCacheEnabled(false);
            }
            if (z12 && (list2 = ceVar.f13116a) != null && !list2.isEmpty()) {
                int[] iArr = new int[2];
                try {
                    for (WeakReference weakReference2 : ceVar.f13116a) {
                        ((FlutterView) weakReference2.get()).getLocationOnScreen(iArr);
                        FlutterNativeView flutterNativeView = ((FlutterView) weakReference2.get()).getFlutterNativeView();
                        Method declaredMethod = flutterNativeView.getClass().getDeclaredMethod("getFlutterJNI", (Class[]) null);
                        declaredMethod.setAccessible(true);
                        canvas2.drawBitmap(((FlutterJNI) declaredMethod.invoke(flutterNativeView, new Object[0])).getBitmap(), (float) iArr[0], (float) iArr[1], (Paint) null);
                    }
                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
                    e11.printStackTrace();
                    fx fxVar = new fx();
                    fxVar.a("EXCEPTION");
                    fxVar.a("site_of_error", "ScreenshotTaker::drawViewOnCanvas()");
                    fxVar.a("reason", e11.getMessage());
                    fxVar.a(2);
                }
            }
            Canvas canvas3 = dnVar.f13219b;
            ce ceVar2 = dnVar.f13220c;
            if (dnVar.f13224g && ceVar2 != null && (list = ceVar2.f13117b) != null && !list.isEmpty()) {
                try {
                    for (WeakReference weakReference3 : dnVar.f13220c.f13117b) {
                        int[] iArr2 = new int[2];
                        ((FlutterSurfaceView) weakReference3.get()).getLocationOnScreen(iArr2);
                        canvas3.drawBitmap(((FlutterRenderer) ex.a("flutterRenderer", weakReference3.get())).getBitmap(), (float) iArr2[0], (float) iArr2[1], (Paint) null);
                    }
                } catch (Exception e12) {
                    e12.printStackTrace();
                    fx fxVar2 = new fx();
                    fxVar2.a("EXCEPTION");
                    fxVar2.a("site_of_error", "ScreenshotTaker::drawViewOnCanvas()");
                    fxVar2.a("reason", e12.getMessage());
                    fxVar2.a(2);
                }
            }
            doVar.a(dnVar, lVar);
        }
        ehVar.a(bitmap);
    }
}
