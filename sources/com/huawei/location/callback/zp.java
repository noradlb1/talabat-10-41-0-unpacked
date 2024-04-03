package com.huawei.location.callback;

import android.os.Bundle;
import com.huawei.hms.location.HwLocationResult;
import com.huawei.hms.support.api.entity.location.updates.RequestLocationUpdatesRequest;
import com.huawei.location.lite.common.log.LogConsole;
import com.huawei.location.utils.Vw;
import com.huawei.secure.android.common.intent.SafeBundle;

public class zp extends d2 {
    public zp(RequestLocationUpdatesRequest requestLocationUpdatesRequest, oc ocVar) {
        this.f50011c = new Vw.yn().yn("Location_locationCallback").FB(requestLocationUpdatesRequest.getTid());
        this.f50014yn = ocVar;
        this.f50012d = requestLocationUpdatesRequest;
    }

    public void yn(Bundle bundle) {
        LogConsole.i("HwCommonCallback", "handlerLocation");
        HwLocationResult hwLocationResult = (HwLocationResult) new SafeBundle(bundle).getParcelable("hwLocationResult");
        if (!a(hwLocationResult) && d(hwLocationResult.getLocation())) {
            yn(hwLocationResult);
        }
    }

    public void yn(boolean z11, boolean z12) {
        if (!z11 || !z12) {
            yn(false);
        }
    }
}
