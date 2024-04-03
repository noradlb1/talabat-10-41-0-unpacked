package com.uxcam.internals;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.webkit.WebView;
import com.uxcam.datamodel.UXConfig;
import com.uxcam.internals.gu;
import java.lang.ref.WeakReference;
import mz.f0;
import mz.g0;

public class hk {

    /* renamed from: a  reason: collision with root package name */
    public GestureDetector f13563a;

    /* renamed from: b  reason: collision with root package name */
    public ScaleGestureDetector f13564b;

    @SuppressLint({"AddJavascriptInterface"})
    public void a(boolean z11, Activity activity) {
        new Thread(new g0(activity, z11)).start();
    }

    public static void a(Activity activity, boolean z11) {
        String str;
        if (activity != null) {
            hm f11 = hm.f();
            f11.getClass();
            Context context = ia.f13617c;
            boolean z12 = hm.f().f13579d != 3;
            UXConfig.MultiSessionRecordStatus multiSessionRecordStatus = hm.e().f12944d;
            boolean z13 = multiSessionRecordStatus == UXConfig.MultiSessionRecordStatus.ENABLED || multiSessionRecordStatus == UXConfig.MultiSessionRecordStatus.DISABLED_BUT_NOT_STARTED || z11;
            if (multiSessionRecordStatus == UXConfig.MultiSessionRecordStatus.DISABLED_BUT_NOT_STARTED) {
                hm.e().f12944d = UXConfig.MultiSessionRecordStatus.DISABLED;
            }
            String str2 = "";
            if (!f11.f13581f && z12 && !hm.f13573p) {
                try {
                    if (hm.e().f12942b == null) {
                        UXConfig e11 = hm.e();
                        try {
                            Object obj = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData.get("uxcam_app_key");
                            if (obj instanceof Integer) {
                                str = obj.toString();
                            } else {
                                str = obj instanceof String ? (String) obj : null;
                            }
                        } catch (Exception e12) {
                            e12.getMessage();
                            gu.f13504c.getClass();
                            str = str2;
                        }
                        e11.f12942b = str;
                    }
                    if (hm.f().f13579d == 2) {
                        hm.f().f13579d = 0;
                    }
                    gu.ab a11 = gu.a("hm");
                    String str3 = hm.e().f12942b;
                    a11.getClass();
                    f11.f13580e = context;
                    boolean a12 = new eq(context).a("opt_out");
                    if (a12) {
                        gu.a("UXCam 3.4.4[561]").getClass();
                    }
                    if ((!a12 && !bi.f13066a && (hm.f().f13579d != 1)) && z13) {
                        f11.a(context);
                        f11.f13581f = true;
                        f11.f(hm.e().f12942b);
                    } else if (!z13) {
                        hm.f13573p = true;
                        if (!bi.f13066a) {
                            gu.f13504c.b("UXCam 3.4.4[561] : Multi Session status FALSE", new Object[0]);
                        }
                    }
                } catch (Exception e13) {
                    e13.getMessage();
                    gu.f13504c.getClass();
                    hm.f().f13579d = 3;
                }
            }
            hz hzVar = f11.f13582g;
            if (hzVar.f13612a != null) {
                eq eqVar = new eq(f11.f13580e);
                String str4 = f11.f13582g.f13612a;
                SharedPreferences sharedPreferences = eqVar.f13291a;
                if (sharedPreferences != null) {
                    sharedPreferences.edit().putString("user_id", str4).apply();
                }
            } else {
                SharedPreferences sharedPreferences2 = new eq(f11.f13580e).f13291a;
                if (sharedPreferences2 != null) {
                    str2 = sharedPreferences2.getString("user_id", (String) null);
                }
                hzVar.f13612a = str2;
            }
            int i11 = gm.f13468q;
            if (i11 == 0) {
                new eq(context).a(false);
                gm.f13468q = -1;
            } else if (i11 == 1) {
                new eq(context).a(true);
                gm.f13468q = -1;
            }
            try {
                WeakReference weakReference = fn.f13381l;
                if (!(weakReference == null || weakReference.get() == null)) {
                    ((WebView) fn.f13381l.get()).post(new f0());
                }
            } catch (Exception e14) {
                fx fxVar = new fx();
                fxVar.a("EXCEPTION");
                fxVar.a("site_of_error", "UXCamActivityData::onStartTask()");
                fxVar.a("reason", e14.getMessage());
                fxVar.a(2);
            }
            hm.f().getClass();
            if (ih.f13634a && bi.f13066a) {
                try {
                    if (hm.e().f12943c) {
                        hb.c().a(ia.f13617c, (String) null, false);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public static /* synthetic */ void a() {
        WeakReference weakReference;
        if (gm.G && (weakReference = fn.f13381l) != null && weakReference.get() != null) {
            ((WebView) fn.f13381l.get()).addJavascriptInterface(new hs(), "UXCam");
        }
    }

    public void a(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.f13563a;
        if (gestureDetector != null) {
            gestureDetector.onTouchEvent(motionEvent);
        } else if (hb.c().f13531b != null) {
            GestureDetector gestureDetector2 = new GestureDetector(ia.f13617c, hb.c().f13531b);
            gestureDetector2.setOnDoubleTapListener(hb.c().f13531b);
            this.f13563a = gestureDetector2;
            gestureDetector2.onTouchEvent(motionEvent);
        }
        ScaleGestureDetector scaleGestureDetector = this.f13564b;
        if (scaleGestureDetector != null) {
            try {
                scaleGestureDetector.onTouchEvent(motionEvent);
            } catch (Exception unused) {
                gu.a("UXCamActivityData -> dispatchTouchEvent").getClass();
            }
        } else if (hb.c().f13531b != null) {
            ScaleGestureDetector scaleGestureDetector2 = new ScaleGestureDetector(ia.f13617c, hb.c().f13531b);
            this.f13564b = scaleGestureDetector2;
            scaleGestureDetector2.onTouchEvent(motionEvent);
        }
    }
}
