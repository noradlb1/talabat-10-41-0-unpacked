package com.huawei.location.gnss.api;

import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Looper;
import com.huawei.hms.location.LocationRequest;
import com.huawei.location.lite.common.android.context.ContextUtil;
import com.huawei.location.lite.common.log.LogConsole;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Vw {

    /* renamed from: yn  reason: collision with root package name */
    private LocationManager f50093yn;

    public Vw() {
        Object systemService = ContextUtil.getContext().getSystemService("location");
        if (systemService instanceof LocationManager) {
            this.f50093yn = (LocationManager) systemService;
        }
    }

    private void yn(LocationListener locationListener, LocationRequest locationRequest, String str, long j11, float f11) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        LogConsole.i("NativeNetworkProvider", "requestLocationByNative begin: " + locationRequest.toString());
        Class<?> cls = Class.forName("android.location.LocationRequest");
        Object newInstance = cls.newInstance();
        Class<String> cls2 = String.class;
        Class cls3 = Long.TYPE;
        Method method = cls.getMethod("createFromDeprecatedProvider", new Class[]{cls2, cls3, Float.TYPE, Boolean.TYPE});
        Method method2 = cls.getMethod("setFastestInterval", new Class[]{cls3});
        Method method3 = cls.getMethod("setExpireAt", new Class[]{cls3});
        Class cls4 = Integer.TYPE;
        Method method4 = cls.getMethod("setNumUpdates", new Class[]{cls4});
        Object invoke = cls.getMethod("setProvider", new Class[]{cls2}).invoke(method2.invoke(method4.invoke(method3.invoke(method.invoke(newInstance, new Object[]{str, Long.valueOf(j11), Float.valueOf(f11), Boolean.FALSE}), new Object[]{Long.valueOf(locationRequest.getExpirationTime())}), new Object[]{Integer.valueOf(locationRequest.getNumUpdates())}), new Object[]{Long.valueOf(locationRequest.getFastestInterval())}), new Object[]{str});
        Object invoke2 = cls.getMethod("setQuality", new Class[]{cls4}).invoke(invoke, new Object[]{Integer.valueOf(locationRequest.getPriority())});
        LocationManager.class.getMethod("requestLocationUpdates", new Class[]{cls, LocationListener.class, Looper.class}).invoke(this.f50093yn, new Object[]{invoke2, locationListener, Looper.getMainLooper()});
    }

    private void yn(String str, long j11, float f11, LocationListener locationListener) {
        String str2;
        LogConsole.i("NativeNetworkProvider", "requestLocationByAPI: provider: " + str + ", minTime: " + j11 + ", minDistance: " + f11);
        try {
            this.f50093yn.requestLocationUpdates(str, j11, f11, locationListener, Looper.getMainLooper());
            return;
        } catch (SecurityException unused) {
            str2 = "deratedRequest SecurityException";
        } catch (IllegalArgumentException unused2) {
            str2 = "deratedRequest IllegalArgumentException";
        } catch (Exception unused3) {
            str2 = "deratedRequest other exception";
        }
        LogConsole.e("LocationManagerAdapter", str2);
    }

    public synchronized void yn(LocationListener locationListener) {
        String str;
        String str2;
        try {
            this.f50093yn.removeUpdates(locationListener);
        } catch (IllegalArgumentException unused) {
            str = "NativeNetworkProvider";
            str2 = "removeUpdates, IllegalArgumentException";
        } catch (SecurityException unused2) {
            str = "NativeNetworkProvider";
            str2 = "removeUpdates, SecurityException";
        } catch (Exception unused3) {
            str = "NativeNetworkProvider";
            str2 = "removeUpdates, other exception";
        }
        LogConsole.e(str, str2);
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x0036 A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0038 A[SYNTHETIC, Splitter:B:25:0x0038] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void yn(com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest r11, android.location.LocationListener r12) {
        /*
            r10 = this;
            monitor-enter(r10)
            if (r11 == 0) goto L_0x0098
            if (r12 != 0) goto L_0x0007
            goto L_0x0098
        L_0x0007:
            com.huawei.hms.location.LocationRequest r2 = r11.getLocationRequest()     // Catch:{ all -> 0x00a1 }
            if (r2 != 0) goto L_0x0016
            java.lang.String r11 = "NativeNetworkProvider"
            java.lang.String r12 = "requestLocationFromNative, illegal argument"
            com.huawei.location.lite.common.log.LogConsole.e(r11, r12)     // Catch:{ all -> 0x00a1 }
            monitor-exit(r10)
            return
        L_0x0016:
            int r11 = r2.getPriority()     // Catch:{ all -> 0x00a1 }
            r0 = 100
            if (r11 == r0) goto L_0x002e
            r0 = 102(0x66, float:1.43E-43)
            if (r11 == r0) goto L_0x002e
            r0 = 104(0x68, float:1.46E-43)
            if (r11 == r0) goto L_0x002e
            r0 = 300(0x12c, float:4.2E-43)
            if (r11 != r0) goto L_0x002b
            goto L_0x002e
        L_0x002b:
            java.lang.String r11 = ""
            goto L_0x0030
        L_0x002e:
            java.lang.String r11 = "network"
        L_0x0030:
            boolean r0 = android.text.TextUtils.isEmpty(r11)     // Catch:{ all -> 0x00a1 }
            if (r0 == 0) goto L_0x0038
            monitor-exit(r10)
            return
        L_0x0038:
            long r0 = r2.getInterval()     // Catch:{ all -> 0x00a1 }
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            long r7 = java.lang.Math.min(r0, r3)     // Catch:{ all -> 0x00a1 }
            float r0 = r2.getSmallestDisplacement()     // Catch:{ all -> 0x00a1 }
            r1 = 2139095039(0x7f7fffff, float:3.4028235E38)
            float r9 = java.lang.Math.min(r0, r1)     // Catch:{ all -> 0x00a1 }
            r0 = r10
            r1 = r12
            r3 = r11
            r4 = r7
            r6 = r9
            r0.yn(r1, r2, r3, r4, r6)     // Catch:{ ClassNotFoundException -> 0x008e, IllegalAccessException -> 0x0086, InstantiationException -> 0x007e, NoSuchMethodException -> 0x0076, InvocationTargetException -> 0x0066, SecurityException -> 0x0061, Exception -> 0x0059 }
            goto L_0x0096
        L_0x0059:
            java.lang.String r11 = "NativeNetworkProvider"
            java.lang.String r12 = "requestLocationByNative other exception"
        L_0x005d:
            com.huawei.location.lite.common.log.LogConsole.e(r11, r12)     // Catch:{ all -> 0x00a1 }
            goto L_0x0096
        L_0x0061:
            java.lang.String r11 = "NativeNetworkProvider"
            java.lang.String r12 = "requestLocationByNative SecurityException"
            goto L_0x005d
        L_0x0066:
            java.lang.String r0 = "NativeNetworkProvider"
            java.lang.String r1 = "requestLocationByNative InvocationTargetException"
            com.huawei.location.lite.common.log.LogConsole.e(r0, r1)     // Catch:{ all -> 0x00a1 }
        L_0x006d:
            r3 = r10
            r4 = r11
            r5 = r7
            r7 = r9
            r8 = r12
            r3.yn(r4, r5, r7, r8)     // Catch:{ all -> 0x00a1 }
            goto L_0x0096
        L_0x0076:
            java.lang.String r0 = "NativeNetworkProvider"
            java.lang.String r1 = "requestLocationByNative NoSuchMethodException"
            com.huawei.location.lite.common.log.LogConsole.e(r0, r1)     // Catch:{ all -> 0x00a1 }
            goto L_0x006d
        L_0x007e:
            java.lang.String r0 = "NativeNetworkProvider"
            java.lang.String r1 = "requestLocationByNative InstantiationException"
            com.huawei.location.lite.common.log.LogConsole.e(r0, r1)     // Catch:{ all -> 0x00a1 }
            goto L_0x006d
        L_0x0086:
            java.lang.String r0 = "NativeNetworkProvider"
            java.lang.String r1 = "requestLocationByNative IllegalAccessException"
            com.huawei.location.lite.common.log.LogConsole.e(r0, r1)     // Catch:{ all -> 0x00a1 }
            goto L_0x006d
        L_0x008e:
            java.lang.String r0 = "NativeNetworkProvider"
            java.lang.String r1 = "requestLocationByNative ClassNotFoundException"
            com.huawei.location.lite.common.log.LogConsole.e(r0, r1)     // Catch:{ all -> 0x00a1 }
            goto L_0x006d
        L_0x0096:
            monitor-exit(r10)
            return
        L_0x0098:
            java.lang.String r11 = "NativeNetworkProvider"
            java.lang.String r12 = "requestLocationFromNative, illegal argument"
            com.huawei.location.lite.common.log.LogConsole.e(r11, r12)     // Catch:{ all -> 0x00a1 }
            monitor-exit(r10)
            return
        L_0x00a1:
            r11 = move-exception
            monitor-exit(r10)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.location.gnss.api.Vw.yn(com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest, android.location.LocationListener):void");
    }
}
