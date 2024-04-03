package com.huawei.hms.locationSdk;

import android.location.Location;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.location.NavigationRequest;
import com.huawei.hms.location.NavigationResult;

public interface i {
    Task<Void> a(Location location, String str);

    Task<NavigationResult> a(NavigationRequest navigationRequest);
}
