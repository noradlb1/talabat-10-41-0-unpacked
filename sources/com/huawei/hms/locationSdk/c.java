package com.huawei.hms.locationSdk;

import android.app.PendingIntent;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.location.ActivityConversionRequest;

public interface c {
    Task<Void> a(long j11, PendingIntent pendingIntent);

    Task<Void> a(PendingIntent pendingIntent);

    Task<Void> a(ActivityConversionRequest activityConversionRequest, PendingIntent pendingIntent);

    Task<Void> b(PendingIntent pendingIntent);
}
