package com.huawei.hms.location;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.locationSdk.b;
import com.huawei.hms.locationSdk.c;
import com.huawei.hms.locationSdk.w;

public class ActivityIdentificationService {
    private c locationArClient;

    public ActivityIdentificationService(Activity activity) {
        this.locationArClient = b.a(activity, (w) null);
    }

    public ActivityIdentificationService(Context context) {
        this.locationArClient = b.a(context, (w) null);
    }

    public Task<Void> createActivityConversionUpdates(ActivityConversionRequest activityConversionRequest, PendingIntent pendingIntent) {
        return this.locationArClient.a(activityConversionRequest, pendingIntent);
    }

    public Task<Void> createActivityIdentificationUpdates(long j11, PendingIntent pendingIntent) {
        return this.locationArClient.a(j11, pendingIntent);
    }

    public Task<Void> deleteActivityConversionUpdates(PendingIntent pendingIntent) {
        return this.locationArClient.b(pendingIntent);
    }

    public Task<Void> deleteActivityIdentificationUpdates(PendingIntent pendingIntent) {
        return this.locationArClient.a(pendingIntent);
    }
}
