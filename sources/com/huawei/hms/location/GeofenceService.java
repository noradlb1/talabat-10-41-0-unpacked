package com.huawei.hms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.locationSdk.b;
import com.huawei.hms.locationSdk.o;
import com.huawei.hms.locationSdk.w;
import java.util.List;

public class GeofenceService {
    private o locationClient;

    public GeofenceService(Activity activity) {
        this.locationClient = b.d(activity, (w) null);
    }

    public GeofenceService(Context context) {
        this.locationClient = b.d(context, (w) null);
    }

    public Task<Void> createGeofenceList(GeofenceRequest geofenceRequest, PendingIntent pendingIntent) {
        return this.locationClient.a(geofenceRequest, pendingIntent);
    }

    public Task<Void> deleteGeofenceList(PendingIntent pendingIntent) {
        return this.locationClient.a(pendingIntent);
    }

    public Task<Void> deleteGeofenceList(List<String> list) {
        return this.locationClient.a(list);
    }
}
