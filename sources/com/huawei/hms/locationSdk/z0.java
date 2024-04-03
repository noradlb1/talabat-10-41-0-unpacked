package com.huawei.hms.locationSdk;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.location.HWLocation;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.support.api.location.common.HMSLocationLog;
import com.huawei.hms.ui.SafeBundle;
import com.huawei.location.lite.common.util.ExecutorUtil;
import com.huawei.location.vdr.VdrManager;
import com.huawei.location.vdr.control.VDRControl;
import com.huawei.location.vdr.listener.IVdrLocationListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

@SuppressLint({"NewApi"})
public class z0 extends y0 implements IVdrLocationListener {

    /* renamed from: d  reason: collision with root package name */
    private AtomicBoolean f49220d = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public VdrManager f49221e;

    /* renamed from: f  reason: collision with root package name */
    private long f49222f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final String f49223g;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            HMSLocationLog.i(z0.this.a(), z0.this.f49189a, "new thread to judge vdr config");
            if (new VDRControl().isSupport(z0.this.f49223g)) {
                VdrManager unused = z0.this.f49221e = VdrManager.getInstance();
                z0.this.f49221e.registerVdrLocationLis(z0.this);
            }
        }
    }

    public class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LocationResult f49225a;

        public b(LocationResult locationResult) {
            this.f49225a = locationResult;
        }

        public void run() {
            z0.this.a(this.f49225a);
            z0.this.f49154b.c().onLocationResult(this.f49225a);
        }
    }

    public z0(String str, String str2, String str3, e0 e0Var, Looper looper, String str4, String str5) throws ApiException {
        super(str, str2, str3, e0Var, looper, str4);
        this.f49223g = str5;
    }

    private boolean a(Location location) {
        if (location == null) {
            return false;
        }
        return a(new SafeBundle(location.getExtras()).getInt("SourceType", -1));
    }

    public static HWLocation b(Location location) {
        if (location == null) {
            return null;
        }
        HWLocation hWLocation = new HWLocation();
        hWLocation.setTime(location.getTime());
        int i11 = Build.VERSION.SDK_INT;
        hWLocation.setElapsedRealtimeNanos(location.getElapsedRealtimeNanos());
        hWLocation.setLatitude(location.getLatitude());
        hWLocation.setLongitude(location.getLongitude());
        hWLocation.setAltitude(location.getAltitude());
        hWLocation.setProvider(location.getProvider());
        hWLocation.setSpeed(location.getSpeed());
        hWLocation.setBearing(location.getBearing());
        hWLocation.setAccuracy(location.getAccuracy());
        if (i11 >= 26) {
            hWLocation.setVerticalAccuracyMeters(location.getVerticalAccuracyMeters());
            hWLocation.setSpeedAccuracyMetersPerSecond(location.getSpeedAccuracyMetersPerSecond());
            hWLocation.setBearingAccuracyDegrees(location.getBearingAccuracyDegrees());
        }
        HashMap hashMap = new HashMap();
        Bundle extras = location.getExtras();
        if (extras != null && extras.containsKey("LocationSource")) {
            hashMap.put("LocationSource", extras.get("LocationSource"));
        }
        hWLocation.setExtraInfo(hashMap);
        return hWLocation;
    }

    public String a() {
        return "RequestLocationExVdrUpdatesTaskApiCall";
    }

    public void a(boolean z11) {
        super.a(z11);
        if (!z11) {
            VdrManager vdrManager = this.f49221e;
            if (vdrManager != null) {
                vdrManager.unRegisterVdrLocationLis(this.f49154b.h());
                this.f49221e = null;
            }
        } else if (this.f49220d.get()) {
            HMSLocationLog.i(a(), this.f49189a, "vdr has been judged, do not new thread here");
        } else {
            this.f49220d.set(true);
            ExecutorUtil.getInstance().execute(new a());
        }
    }

    public void b(LocationResult locationResult) {
        VdrManager vdrManager = this.f49221e;
        if (vdrManager == null || !vdrManager.isVdrIntervalStart()) {
            a(locationResult);
            this.f49154b.c().onLocationResult(locationResult);
            return;
        }
        HMSLocationLog.d(a(), this.f49189a, "vdr sync location");
        if (a(locationResult.getLastLocation())) {
            this.f49222f = locationResult.getLastLocation().getElapsedRealtimeNanos();
            this.f49154b.c().onLocationResult(locationResult);
        }
        this.f49221e.syncLocation(locationResult.getLastLocation());
    }

    public String getUuid() {
        return this.f49154b.h();
    }

    public void onVdrLocationChanged(Location location) {
        HMSLocationLog.i(a(), this.f49189a, "onVdrLocationChanged");
        if (location != null && location.getElapsedRealtimeNanos() - this.f49222f >= TimeUnit.MILLISECONDS.toNanos(this.f49154b.d().getFastestInterval() + 100)) {
            HWLocation b11 = b(location);
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(b11);
            this.f49155c.post(new b(LocationResult.create(arrayList)));
        }
    }
}
