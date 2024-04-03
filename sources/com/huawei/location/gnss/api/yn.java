package com.huawei.location.gnss.api;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.HandlerThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.huawei.location.gnss.sdm.Vw;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.lite.common.util.PermissionUtil;
import java.util.List;

public class yn {
    private static volatile yn Vw;

    /* renamed from: yn  reason: collision with root package name */
    private static final byte[] f50094yn = new byte[0];
    private Vw E5;
    private LocationManager FB;
    @Nullable
    private List<LocationListener> LW = null;
    private HandlerThread dC;

    private yn() {
        HandlerThread handlerThread = new HandlerThread("Loc-GNSS");
        this.dC = handlerThread;
        handlerThread.start();
        Object systemService = ContextUtil.getContext().getSystemService("location");
        if (systemService instanceof LocationManager) {
            this.FB = (LocationManager) systemService;
        }
    }

    public static yn yn() {
        if (Vw == null) {
            synchronized (f50094yn) {
                if (Vw == null) {
                    Vw = new yn();
                }
            }
        }
        return Vw;
    }

    public synchronized Location yn(String str) {
        Location location;
        try {
            location = this.FB.getLastKnownLocation(str);
        } catch (SecurityException unused) {
            LogConsole.e("GnssClient", "getLastKnownLocation, security exception");
            location = null;
        }
        return location;
    }

    public synchronized void yn(@NonNull LocationListener locationListener) {
        LogConsole.i("GnssClient", "removeLocationUpdates");
        if (!PermissionUtil.checkSelfPermission(ContextUtil.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
            LogConsole.e("GnssClient", "checkSelfPermission fail");
            return;
        }
        List<LocationListener> list = this.LW;
        if (list == null || !list.remove(locationListener)) {
            this.FB.removeUpdates(locationListener);
        } else {
            this.E5.Vw(locationListener);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x007a A[Catch:{ SecurityException -> 0x0105, IllegalArgumentException -> 0x0100, Exception -> 0x00f8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0083  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void yn(@androidx.annotation.NonNull com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest r9, android.location.LocationListener r10) {
        /*
            r8 = this;
            monitor-enter(r8)
            android.content.Context r0 = com.huawei.location.lite.common.android.context.ContextUtil.getContext()     // Catch:{ all -> 0x0115 }
            java.lang.String r1 = "android.permission.ACCESS_FINE_LOCATION"
            boolean r0 = com.huawei.location.lite.common.util.PermissionUtil.checkSelfPermission(r0, r1)     // Catch:{ all -> 0x0115 }
            if (r0 != 0) goto L_0x0016
            java.lang.String r9 = "GnssClient"
            java.lang.String r10 = "checkSelfPermission fail"
            com.huawei.location.lite.common.log.LogConsole.e(r9, r10)     // Catch:{ all -> 0x0115 }
            monitor-exit(r8)
            return
        L_0x0016:
            com.huawei.hms.location.LocationRequest r0 = r9.getLocationRequest()     // Catch:{ all -> 0x0115 }
            java.lang.String r9 = r9.getTid()     // Catch:{ all -> 0x0115 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x0115 }
            if (r9 != 0) goto L_0x010c
            if (r0 != 0) goto L_0x0028
            goto L_0x010c
        L_0x0028:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x0115 }
            r9.<init>()     // Catch:{ all -> 0x0115 }
            java.lang.String r1 = "requestLocationUpdates, priority is "
            r9.append(r1)     // Catch:{ all -> 0x0115 }
            int r1 = r0.getPriority()     // Catch:{ all -> 0x0115 }
            r9.append(r1)     // Catch:{ all -> 0x0115 }
            java.lang.String r1 = ", interval is "
            r9.append(r1)     // Catch:{ all -> 0x0115 }
            long r1 = r0.getInterval()     // Catch:{ all -> 0x0115 }
            r9.append(r1)     // Catch:{ all -> 0x0115 }
            java.lang.String r1 = ", smallestDisplacement is "
            r9.append(r1)     // Catch:{ all -> 0x0115 }
            float r1 = r0.getSmallestDisplacement()     // Catch:{ all -> 0x0115 }
            r9.append(r1)     // Catch:{ all -> 0x0115 }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x0115 }
            java.lang.String r1 = "GnssClient"
            com.huawei.location.lite.common.log.LogConsole.i(r1, r9)     // Catch:{ all -> 0x0115 }
            int r9 = r0.getPriority()     // Catch:{ all -> 0x0115 }
            r1 = 100
            if (r9 == r1) goto L_0x0071
            r1 = 200(0xc8, float:2.8E-43)
            if (r9 != r1) goto L_0x0067
            goto L_0x0071
        L_0x0067:
            r1 = 105(0x69, float:1.47E-43)
            if (r9 != r1) goto L_0x006e
            java.lang.String r9 = "passive"
            goto L_0x0073
        L_0x006e:
            java.lang.String r9 = ""
            goto L_0x0073
        L_0x0071:
            java.lang.String r9 = "gps"
        L_0x0073:
            r2 = r9
            boolean r9 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0115 }
            if (r9 == 0) goto L_0x0083
            java.lang.String r9 = "GnssClient"
            java.lang.String r10 = "priority is invalid"
            com.huawei.location.lite.common.log.LogConsole.e(r9, r10)     // Catch:{ all -> 0x0115 }
            monitor-exit(r8)
            return
        L_0x0083:
            java.lang.String r9 = "gps"
            boolean r9 = r2.equals(r9)     // Catch:{ all -> 0x0115 }
            if (r9 == 0) goto L_0x00d3
            java.util.Map r9 = r0.getExtras()     // Catch:{ all -> 0x0115 }
            if (r9 != 0) goto L_0x0093
            r9 = 0
            goto L_0x009f
        L_0x0093:
            java.lang.String r1 = "SuperGnssEnable"
            java.lang.Object r9 = r9.get(r1)     // Catch:{ all -> 0x0115 }
            java.lang.String r1 = "1"
            boolean r9 = r1.equals(r9)     // Catch:{ all -> 0x0115 }
        L_0x009f:
            if (r9 == 0) goto L_0x00d3
            java.util.List<android.location.LocationListener> r9 = r8.LW     // Catch:{ all -> 0x0115 }
            if (r9 != 0) goto L_0x00ac
            java.util.ArrayList r9 = new java.util.ArrayList     // Catch:{ all -> 0x0115 }
            r9.<init>()     // Catch:{ all -> 0x0115 }
            r8.LW = r9     // Catch:{ all -> 0x0115 }
        L_0x00ac:
            com.huawei.location.gnss.sdm.Vw r9 = r8.E5     // Catch:{ all -> 0x0115 }
            if (r9 != 0) goto L_0x00b7
            com.huawei.location.gnss.sdm.Vw r9 = new com.huawei.location.gnss.sdm.Vw     // Catch:{ all -> 0x0115 }
            r9.<init>()     // Catch:{ all -> 0x0115 }
            r8.E5 = r9     // Catch:{ all -> 0x0115 }
        L_0x00b7:
            com.huawei.location.gnss.sdm.Vw r9 = r8.E5     // Catch:{ all -> 0x0115 }
            long r3 = r0.getInterval()     // Catch:{ all -> 0x0115 }
            float r1 = r0.getSmallestDisplacement()     // Catch:{ all -> 0x0115 }
            boolean r9 = r9.yn(r3, r1, r10)     // Catch:{ all -> 0x0115 }
            if (r9 == 0) goto L_0x00d3
            java.util.List<android.location.LocationListener> r9 = r8.LW     // Catch:{ all -> 0x0115 }
            r9.remove(r10)     // Catch:{ all -> 0x0115 }
            java.util.List<android.location.LocationListener> r9 = r8.LW     // Catch:{ all -> 0x0115 }
            r9.add(r10)     // Catch:{ all -> 0x0115 }
            monitor-exit(r8)
            return
        L_0x00d3:
            android.os.HandlerThread r9 = r8.dC     // Catch:{ all -> 0x0115 }
            if (r9 != 0) goto L_0x00e3
            android.os.HandlerThread r9 = new android.os.HandlerThread     // Catch:{ all -> 0x0115 }
            java.lang.String r1 = "Loc-GNSS"
            r9.<init>(r1)     // Catch:{ all -> 0x0115 }
            r8.dC = r9     // Catch:{ all -> 0x0115 }
            r9.start()     // Catch:{ all -> 0x0115 }
        L_0x00e3:
            android.location.LocationManager r1 = r8.FB     // Catch:{ SecurityException -> 0x0105, IllegalArgumentException -> 0x0100, Exception -> 0x00f8 }
            long r3 = r0.getInterval()     // Catch:{ SecurityException -> 0x0105, IllegalArgumentException -> 0x0100, Exception -> 0x00f8 }
            float r5 = r0.getSmallestDisplacement()     // Catch:{ SecurityException -> 0x0105, IllegalArgumentException -> 0x0100, Exception -> 0x00f8 }
            android.os.HandlerThread r9 = r8.dC     // Catch:{ SecurityException -> 0x0105, IllegalArgumentException -> 0x0100, Exception -> 0x00f8 }
            android.os.Looper r7 = r9.getLooper()     // Catch:{ SecurityException -> 0x0105, IllegalArgumentException -> 0x0100, Exception -> 0x00f8 }
            r6 = r10
            r1.requestLocationUpdates(r2, r3, r5, r6, r7)     // Catch:{ SecurityException -> 0x0105, IllegalArgumentException -> 0x0100, Exception -> 0x00f8 }
            goto L_0x010a
        L_0x00f8:
            java.lang.String r9 = "GnssClient"
            java.lang.String r10 = "LocationManager requestLocationUpdates throw other exception"
        L_0x00fc:
            com.huawei.location.lite.common.log.LogConsole.e(r9, r10)     // Catch:{ all -> 0x0115 }
            goto L_0x010a
        L_0x0100:
            java.lang.String r9 = "GnssClient"
            java.lang.String r10 = "LocationManager requestLocationUpdates throw IllegalArgumentException"
            goto L_0x00fc
        L_0x0105:
            java.lang.String r9 = "GnssClient"
            java.lang.String r10 = "LocationManager requestLocationUpdates throw SecurityException"
            goto L_0x00fc
        L_0x010a:
            monitor-exit(r8)
            return
        L_0x010c:
            java.lang.String r9 = "GnssClient"
            java.lang.String r10 = "requestLocationUpdatesRequest is invalid"
            com.huawei.location.lite.common.log.LogConsole.e(r9, r10)     // Catch:{ all -> 0x0115 }
            monitor-exit(r8)
            return
        L_0x0115:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.gnss.api.yn.yn(com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest, android.location.LocationListener):void");
    }
}
