package com.huawei.hms.location;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.locationSdk.b;
import com.huawei.hms.locationSdk.f;
import com.huawei.hms.locationSdk.w;

public class SettingsClient {
    private f locationClient;
    private Activity mActivity;
    private Context mContext;

    public SettingsClient(Activity activity) {
        this.mActivity = activity;
        this.locationClient = b.b(activity, (w) null);
    }

    public SettingsClient(Context context) {
        this.mContext = context;
        this.locationClient = b.b(context, (w) null);
    }

    public Task<LocationSettingsResponse> checkLocationSettings(LocationSettingsRequest locationSettingsRequest) {
        return this.locationClient.a(locationSettingsRequest);
    }

    public Task<Void> setLogConfig(LogConfig logConfig) {
        return this.locationClient.a(logConfig);
    }
}
