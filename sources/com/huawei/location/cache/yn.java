package com.huawei.location.cache;

import android.location.Location;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.location.lite.common.log.LogConsole;
import j$.util.concurrent.ConcurrentHashMap;

public class yn {
    private static volatile yn Vw;

    /* renamed from: yn  reason: collision with root package name */
    private static final byte[] f50004yn = new byte[0];
    private ConcurrentHashMap<String, Vw> FB = new ConcurrentHashMap<>(11);
    private Location LW;

    private yn() {
    }

    public static yn Vw() {
        if (Vw == null) {
            synchronized (f50004yn) {
                if (Vw == null) {
                    Vw = new yn();
                }
            }
        }
        return Vw;
    }

    public Location FB() {
        if (this.LW == null) {
            LogConsole.i("RequestRecordCache", "cached lastLocation is null");
            return null;
        } else if (SystemClock.elapsedRealtime() - (this.LW.getElapsedRealtimeNanos() / 1000000) > 1200000) {
            LogConsole.i("RequestRecordCache", "cached lastLocation is expired");
            this.LW = null;
            return null;
        } else {
            LogConsole.i("RequestRecordCache", "cached lastLocation is in 20 minutes");
            return this.LW;
        }
    }

    public void FB(String str) {
        if (TextUtils.isEmpty(str)) {
            LogConsole.e("RequestRecordCache", "updateNumUpdate fail, uuid is null");
        } else if (!this.FB.containsKey(str)) {
            LogConsole.e("RequestRecordCache", "updateNumUpdate fail, requestCache is not contains");
        } else {
            Vw vw2 = this.FB.get(str);
            if (vw2 == null) {
                LogConsole.e("RequestRecordCache", "updateNumUpdate fail, wrapLocationRequest is null");
                return;
            }
            RequestLocationUpdatesRequest dC = vw2.dC();
            if (dC == null) {
                LogConsole.e("RequestRecordCache", "updateNumUpdate fail, requestLocationUpdatesRequest is null");
                return;
            }
            LocationRequest locationRequest = dC.getLocationRequest();
            if (locationRequest == null) {
                LogConsole.e("RequestRecordCache", "updateNumUpdate fail, locationRequest is null");
                return;
            }
            int numUpdates = locationRequest.getNumUpdates();
            if (numUpdates <= 1) {
                LogConsole.e("RequestRecordCache", "updateNumUpdate fail, numUpdate <= 1");
            } else {
                locationRequest.setNumUpdates(numUpdates - 1);
            }
        }
    }

    public Vw Vw(String str) {
        if (TextUtils.isEmpty(str)) {
            return new Vw(new RequestLocationUpdatesRequest());
        }
        if (!this.FB.containsKey(str)) {
            return new Vw(new RequestLocationUpdatesRequest());
        }
        Vw vw2 = this.FB.get(str);
        if (!(vw2 == null || vw2.yn() == null)) {
            vw2.yn().yn();
        }
        return this.FB.remove(str);
    }

    public ConcurrentHashMap<String, Vw> yn() {
        return this.FB;
    }

    public void yn(Location location) {
        this.LW = location;
    }

    public void yn(@NonNull Vw vw2) {
        if (vw2.yn() != null) {
            this.FB.put(vw2.d2(), vw2);
            LogConsole.i("RequestRecordCache", "add requestCache end, uuid is " + vw2.d2() + "," + this.FB.size());
        }
    }

    public boolean yn(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.FB.containsKey(str);
    }
}
