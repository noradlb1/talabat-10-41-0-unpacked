package com.huawei.location.callback;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.location.activity.model.Vw;
import com.huawei.location.lite.common.exception.LocationServiceException;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.logic.LW;
import com.huawei.secure.android.common.intent.SafeBundle;

public class dC extends Ot {
    private Location G3;
    private Location Ot;

    public dC(RequestLocationUpdatesRequest requestLocationUpdatesRequest, oc ocVar) {
        super(requestLocationUpdatesRequest, ocVar);
    }

    public void onLocationChanged(Location location) {
        LogConsole.i("FusedForGCallback", "fusedForG gnss location successful");
        if (!Vw.yn(this.f50012d)) {
            try {
                LW.yn().yn(this.f50012d.getUuid());
                LogConsole.i("FusedForGCallback", "request expiration and remove");
            } catch (LocationServiceException unused) {
                LogConsole.e("FusedForGCallback", "throw locationServiceException");
            }
        } else if (TextUtils.equals("gps", location.getProvider())) {
            LogConsole.i("FusedForGCallback", "receive native gnss loc");
            HwLocationResult hwLocationResult = new HwLocationResult();
            hwLocationResult.setLocation(location);
            f(hwLocationResult);
        } else {
            super.onLocationChanged(location);
        }
    }

    public void yn(Bundle bundle) {
        HwLocationResult hwLocationResult = (HwLocationResult) new SafeBundle(bundle).getParcelable("hwLocationResult");
        if (!a(hwLocationResult)) {
            Location location = hwLocationResult.getLocation();
            LogConsole.i("FusedForGCallback", "handlerFuesdLocation, location provider is " + location.getProvider());
            if ("gps".equals(location.getProvider())) {
                this.G3 = new Location(location);
            } else {
                this.Ot = new Location(location);
            }
            Location b11 = b(this.G3, this.Ot);
            if (d(b11)) {
                hwLocationResult.setLocation(b11);
                this.f50009g.set(false);
                yn(hwLocationResult);
            }
        }
    }
}
