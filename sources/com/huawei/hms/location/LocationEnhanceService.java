package com.huawei.hms.location;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.locationSdk.b;
import com.huawei.hms.locationSdk.i;
import com.huawei.hms.locationSdk.w;

public class LocationEnhanceService {
    private static final String TAG = "LocationEnhanceService";
    private i locationEnhanceClient;

    public LocationEnhanceService(Activity activity) {
        this.locationEnhanceClient = b.c(activity, (w) null);
    }

    public LocationEnhanceService(Context context) {
        this.locationEnhanceClient = b.c(context, (w) null);
    }

    private Task<Void> reportLocation(Location location, String str) {
        return this.locationEnhanceClient.a(location, str);
    }

    public Task<NavigationResult> getNavigationState(NavigationRequest navigationRequest) {
        return this.locationEnhanceClient.a(navigationRequest);
    }
}
