package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.ActivityRecognitionApi;

public final class zzw implements ActivityRecognitionApi {
    public final PendingResult<Status> removeActivityUpdates(GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        return googleApiClient.execute(new zzu(this, googleApiClient, pendingIntent));
    }

    public final PendingResult<Status> requestActivityUpdates(GoogleApiClient googleApiClient, long j11, PendingIntent pendingIntent) {
        return googleApiClient.execute(new zzt(this, googleApiClient, j11, pendingIntent));
    }
}
