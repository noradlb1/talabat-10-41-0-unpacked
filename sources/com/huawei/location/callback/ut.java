package com.huawei.location.callback;

import android.location.Location;
import android.os.Bundle;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.logic.LW;
import com.huawei.location.utils.Vw;
import com.huawei.secure.android.common.intent.SafeBundle;

public class ut extends d2 {

    /* renamed from: ut  reason: collision with root package name */
    private Location f50016ut;

    /* renamed from: zp  reason: collision with root package name */
    private Location f50017zp;

    public ut(RequestLocationUpdatesRequest requestLocationUpdatesRequest, oc ocVar) {
        this.f50011c = new Vw.yn().yn("Location_locationCallback").FB(requestLocationUpdatesRequest.getTid());
        this.f50014yn = ocVar;
        this.f50012d = requestLocationUpdatesRequest;
    }

    public void onLocationChanged(Location location) {
        LogConsole.i("HwFusedCallback", "fused gnss location successful");
        if (!com.huawei.location.activity.model.Vw.yn(this.f50012d)) {
            try {
                LW.yn().yn(this.f50012d.getUuid());
                LogConsole.i("HwFusedCallback", "request expiration and remove");
            } catch (LocationServiceException unused) {
                LogConsole.e("HwFusedCallback", "throw locationServiceException");
            }
        } else {
            HwLocationResult hwLocationResult = new HwLocationResult();
            hwLocationResult.setLocation(location);
            LW(hwLocationResult);
        }
    }

    public void yn(Bundle bundle) {
        HwLocationResult hwLocationResult = (HwLocationResult) new SafeBundle(bundle).getParcelable("hwLocationResult");
        if (!a(hwLocationResult)) {
            Location location = hwLocationResult.getLocation();
            LogConsole.i("HwFusedCallback", "handlerFuesdLocation, location provider is " + location.getProvider());
            if ("gps".equals(location.getProvider())) {
                this.f50017zp = new Location(location);
            } else {
                this.f50016ut = new Location(location);
            }
            Location b11 = b(this.f50017zp, this.f50016ut);
            if (d(b11)) {
                hwLocationResult.setLocation(b11);
                yn(hwLocationResult);
            }
        }
    }

    public void yn(boolean z11, boolean z12) {
        if (!z11) {
            yn(false);
        }
    }
}
