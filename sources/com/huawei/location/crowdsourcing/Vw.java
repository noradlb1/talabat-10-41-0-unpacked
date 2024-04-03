package com.huawei.location.crowdsourcing;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.location.crowdsourcing.Config;
import com.huawei.location.crowdsourcing.common.util.dC;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.PermissionUtil;
import com.huawei.location.lite.common.util.ROMUtil;
import com.huawei.secure.android.common.intent.SafeBundle;
import com.huawei.secure.android.common.intent.SafeIntent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class Vw {
    /* access modifiers changed from: private */
    @SuppressLint({"StaticFieldLeak"})
    public static Context Vw = null;

    /* renamed from: yn  reason: collision with root package name */
    private static boolean f50035yn = false;
    private long E5;
    @Nullable
    private C0078Vw FB;
    /* access modifiers changed from: private */
    public final FB G3;
    @Nullable
    private LW LW;
    private FB Ot;

    /* renamed from: d2  reason: collision with root package name */
    private double f50036d2;
    private final List<com.huawei.location.crowdsourcing.common.yn> dC = new ArrayList();

    /* renamed from: oc  reason: collision with root package name */
    private yn f50037oc;

    /* renamed from: ut  reason: collision with root package name */
    private dC f50038ut;

    /* renamed from: zp  reason: collision with root package name */
    private double f50039zp;

    public class FB extends Handler {
        public FB(Looper looper) {
            super(looper);
        }

        public void handleMessage(@NonNull Message message) {
            int i11 = message.what;
            if (i11 == 1) {
                LogConsole.i("Crowdsourcing", "handleMessage: LOCATION_CHANGED");
                Object obj = message.obj;
                if (!(obj instanceof Location)) {
                    LogConsole.e("Crowdsourcing", "handleMessage not location obj");
                } else {
                    Vw.f(Vw.this, (Location) obj);
                }
            } else if (i11 == 0) {
                LogConsole.i("Crowdsourcing", "begin init");
                if (Vw.g(Vw.this, getLooper())) {
                    LogConsole.i("Crowdsourcing", "init finished");
                    return;
                }
                LogConsole.e("Crowdsourcing", "init failed");
                Vw.e(Vw.this);
                getLooper().quitSafely();
            } else if (i11 != 2) {
                LogConsole.e("Crowdsourcing", "unknown msg:" + message.what);
            } else if (Config.FB.f50027yn.y(dC.Vw(Vw.b()))) {
                LogConsole.i("Crowdsourcing", "check mcc success");
            } else {
                LogConsole.e("Crowdsourcing", "check mcc failed");
                Vw.e(Vw.this);
                getLooper().quitSafely();
            }
        }
    }

    public class LW extends BroadcastReceiver {
        private LW() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = new SafeIntent(intent).getAction();
            if (action == null) {
                LogConsole.e("Crowdsourcing", "get null action");
            } else if (!action.equals("android.intent.action.SIM_STATE_CHANGED")) {
                LogConsole.e("Crowdsourcing", "receive unknown action,action:" + action);
            } else {
                LogConsole.d("Crowdsourcing", "onReceive action=" + action);
                Vw.this.G3.obtainMessage(2).sendToTarget();
            }
        }
    }

    /* renamed from: com.huawei.location.crowdsourcing.Vw$Vw  reason: collision with other inner class name */
    public class C0078Vw implements LocationListener {
        private C0078Vw() {
        }

        public void onLocationChanged(Location location) {
            if (location == null) {
                LogConsole.e("Crowdsourcing", "location null");
                return;
            }
            SafeBundle safeBundle = new SafeBundle(location.getExtras());
            if (safeBundle.getBundle() == null || safeBundle.getInt("accuracyType") != 1 || !ROMUtil.isHuaweiPlatformDevice()) {
                Vw.this.G3.obtainMessage(1, location).sendToTarget();
            } else {
                LogConsole.d("Crowdsourcing", "approximate not collect");
            }
        }

        public void onProviderDisabled(String str) {
            LogConsole.d("Crowdsourcing", "onProviderDisabled");
        }

        public void onProviderEnabled(String str) {
            LogConsole.d("Crowdsourcing", "onProviderEnabled");
        }

        public void onStatusChanged(String str, int i11, Bundle bundle) {
            LogConsole.d("Crowdsourcing", "onStatusChanged");
        }
    }

    private Vw(Looper looper) {
        this.G3 = new FB(looper);
    }

    private boolean FB() {
        String str;
        LW lw2 = new LW();
        this.LW = lw2;
        b().registerReceiver(lw2, new IntentFilter("android.intent.action.SIM_STATE_CHANGED"));
        LogConsole.i("Crowdsourcing", "sim state change register success");
        C0078Vw vw2 = new C0078Vw();
        this.FB = vw2;
        if (!a(this)) {
            str = "check permission failed";
        } else {
            Object systemService = Vw.getSystemService("location");
            if (!(systemService instanceof LocationManager)) {
                str = "not get LocationManager";
            } else {
                try {
                    ((LocationManager) systemService).requestLocationUpdates("passive", 0, 0.0f, vw2);
                    LogConsole.i("Crowdsourcing", "location listener register success");
                    return true;
                } catch (SecurityException unused) {
                    str = "LocationManager requestLocationUpdates throw SecurityException";
                } catch (IllegalArgumentException unused2) {
                    str = "LocationManager requestLocationUpdates throw IllegalArgumentException";
                } catch (Exception unused3) {
                    str = "LocationManager requestLocationUpdates throw other exception";
                }
            }
        }
        LogConsole.e("Crowdsourcing", str);
        return false;
    }

    public static boolean a(Vw vw2) {
        vw2.getClass();
        if (Build.VERSION.SDK_INT >= 29 && !PermissionUtil.checkSelfPermission(Vw, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            LogConsole.w("Crowdsourcing", "can not access background location");
        }
        return PermissionUtil.checkSelfPermission(Vw, "android.permission.ACCESS_FINE_LOCATION") && PermissionUtil.checkSelfPermission(Vw, "android.permission.ACCESS_COARSE_LOCATION");
    }

    @NonNull
    public static Context b() {
        return Vw;
    }

    public static void e(Vw vw2) {
        vw2.getClass();
        LogConsole.w("Crowdsourcing", "Stop");
        C0078Vw vw3 = vw2.FB;
        if (vw3 != null) {
            Object systemService = Vw.getSystemService("location");
            if (!(systemService instanceof LocationManager)) {
                LogConsole.e("Crowdsourcing", "not get LocationManager");
            } else {
                ((LocationManager) systemService).removeUpdates(vw3);
            }
        }
        LW lw2 = vw2.LW;
        if (lw2 != null) {
            b().unregisterReceiver(lw2);
        }
        for (com.huawei.location.crowdsourcing.common.yn yn2 : vw2.dC) {
            yn2.yn();
        }
        FB fb2 = vw2.Ot;
        if (fb2 != null) {
            fb2.Vw();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void f(com.huawei.location.crowdsourcing.Vw r16, android.location.Location r17) {
        /*
            r0 = r16
            r16.getClass()
            long r1 = java.lang.System.currentTimeMillis()
            long r3 = r0.E5
            long r1 = r1 - r3
            long r1 = java.lang.Math.abs(r1)
            com.huawei.location.crowdsourcing.Config r3 = com.huawei.location.crowdsourcing.Config.FB.f50027yn
            long r3 = r3.v()
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r4 = 1
            java.lang.String r5 = "Crowdsourcing"
            r6 = 0
            if (r3 >= 0) goto L_0x0036
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r7 = "not need collect, collect interval check failed. timeDiff:"
            r3.append(r7)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            com.huawei.location.lite.common.log.LogConsole.d(r5, r1)
        L_0x0034:
            r1 = r6
            goto L_0x006d
        L_0x0036:
            float[] r1 = new float[r4]
            double r7 = r17.getLatitude()
            double r9 = r17.getLongitude()
            double r11 = r0.f50036d2
            double r13 = r0.f50039zp
            r15 = r1
            android.location.Location.distanceBetween(r7, r9, r11, r13, r15)
            r1 = r1[r6]
            com.huawei.location.crowdsourcing.Config r2 = com.huawei.location.crowdsourcing.Config.FB.f50027yn
            int r2 = r2.z()
            float r2 = (float) r2
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x006c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "not need collect, collect distance check failed. distanceDiff:"
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.huawei.location.lite.common.log.LogConsole.d(r5, r1)
            goto L_0x0034
        L_0x006c:
            r1 = r4
        L_0x006d:
            if (r1 != 0) goto L_0x0070
            goto L_0x00a9
        L_0x0070:
            java.lang.String r1 = "collect"
            com.huawei.location.lite.common.log.LogConsole.d(r5, r1)
            com.huawei.location.crowdsourcing.dC r1 = r0.f50038ut
            java.util.List r1 = r1.d()
            com.huawei.location.crowdsourcing.yn r2 = r0.f50037oc
            java.util.List r2 = r2.b()
            if (r1 != 0) goto L_0x008e
            if (r2 != 0) goto L_0x008e
            java.lang.String r1 = "no wifi and no cell, not collect"
            com.huawei.location.lite.common.log.LogConsole.d(r5, r1)
            r5 = r17
            r4 = r6
            goto L_0x0095
        L_0x008e:
            com.huawei.location.crowdsourcing.FB r3 = r0.Ot
            r5 = r17
            r3.c(r5, r1, r2)
        L_0x0095:
            if (r4 == 0) goto L_0x00a9
            long r1 = java.lang.System.currentTimeMillis()
            r0.E5 = r1
            double r1 = r17.getLatitude()
            r0.f50036d2 = r1
            double r1 = r17.getLongitude()
            r0.f50039zp = r1
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.crowdsourcing.Vw.f(com.huawei.location.crowdsourcing.Vw, android.location.Location):void");
    }

    public static boolean g(Vw vw2, Looper looper) {
        String str;
        String str2;
        vw2.getClass();
        Config a11 = Config.FB.f50027yn;
        vw2.dC.add(a11);
        if (!a11.x(Vw, looper)) {
            str2 = "config init failed";
        } else if (a11.h()) {
            str2 = "switch is closed";
        } else {
            dC dCVar = new dC(looper);
            vw2.f50038ut = dCVar;
            vw2.dC.add(dCVar);
            yn ynVar = new yn();
            vw2.f50037oc = ynVar;
            vw2.dC.add(ynVar);
            try {
                FB fb2 = new FB(looper, Vw.getFilesDir().getCanonicalPath());
                vw2.Ot = fb2;
                vw2.dC.add(fb2);
                vw2.f50038ut.c();
                vw2.f50037oc.getClass();
                if (!PermissionUtil.checkSelfPermission(b(), "android.permission.ACCESS_FINE_LOCATION")) {
                    str = "cellCollector init failed";
                } else if (vw2.Ot.a()) {
                    return vw2.FB();
                } else {
                    str = "recorder init failed";
                }
            } catch (IOException unused) {
                str = "get folder path failed";
            }
            LogConsole.e("Crowdsourcing", str);
            return false;
        }
        LogConsole.e("Crowdsourcing", str2);
        return false;
    }

    public static void yn(Context context) {
        if (f50035yn) {
            LogConsole.d("Crowdsourcing", "double start");
        } else if (context == null) {
            LogConsole.e("Crowdsourcing", "context is null");
        } else {
            synchronized (Vw.class) {
                if (f50035yn) {
                    LogConsole.d("Crowdsourcing", "double start");
                    return;
                }
                LogConsole.i("Crowdsourcing", "start");
                Vw = context.getApplicationContext();
                HandlerThread handlerThread = new HandlerThread("Crowdsourcing");
                handlerThread.start();
                new Vw(handlerThread.getLooper()).G3.obtainMessage(0).sendToTarget();
                f50035yn = true;
            }
        }
    }
}
