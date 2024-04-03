package com.huawei.hms.location;

import android.app.Activity;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.locationSdk.b;
import com.huawei.hms.locationSdk.l;
import com.huawei.hms.locationSdk.w;
import java.util.List;
import java.util.Locale;

public class GeocoderService {
    private l locationClient;

    public GeocoderService(Activity activity, Locale locale) {
        this.locationClient = b.a(activity, locale, (w) null);
    }

    public GeocoderService(Context context, Locale locale) {
        this.locationClient = b.a(context, locale, (w) null);
    }

    public Task<List<HWLocation>> getFromLocation(GetFromLocationRequest getFromLocationRequest) {
        return this.locationClient.a(getFromLocationRequest);
    }

    public Task<List<HWLocation>> getFromLocationName(GetFromLocationNameRequest getFromLocationNameRequest) {
        return this.locationClient.a(getFromLocationNameRequest);
    }
}
