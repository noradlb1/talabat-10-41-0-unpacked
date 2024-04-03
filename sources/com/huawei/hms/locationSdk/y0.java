package com.huawei.hms.locationSdk;

import android.os.Looper;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.support.api.location.common.HMSLocationLog;

public class y0 extends a1 {
    public y0(String str, String str2, String str3, e0 e0Var, Looper looper, String str4) throws ApiException {
        super(str, str2, str3, e0Var, looper, str4);
    }

    public String a() {
        return "RequestLocationExUpdatesTaskApiCall";
    }

    public int getApiLevel() {
        LocationRequest d11 = this.f49154b.d();
        if (d11 == null) {
            HMSLocationLog.e(a(), this.f49189a, "locationRequest is null");
            return super.getApiLevel();
        } else if (d11.getPriority() == 300) {
            return 5;
        } else {
            return super.getApiLevel();
        }
    }

    public int getMinApkVersion() {
        return 40003318;
    }
}
