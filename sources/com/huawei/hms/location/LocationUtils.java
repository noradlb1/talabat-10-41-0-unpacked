package com.huawei.hms.location;

import com.huawei.hms.locationSdk.a;
import com.huawei.hms.support.api.entity.location.coordinate.LonLat;

public class LocationUtils {
    public static LonLat convertCoord(double d11, double d12, int i11) {
        return a.a(d11, d12, i11);
    }
}
