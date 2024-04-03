package com.google.android.gms.internal.icing;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndexApi;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

@Deprecated
final class zzah implements AppIndexApi.ActionResult {
    private final zzal zza;
    private final PendingResult<Status> zzb;
    private final Action zzc;

    public zzah(zzal zzal, PendingResult<Status> pendingResult, Action action) {
        this.zza = zzal;
        this.zzb = pendingResult;
        this.zzc = action;
    }

    public final PendingResult<Status> end(GoogleApiClient googleApiClient) {
        String packageName = googleApiClient.getContext().getPackageName();
        zzx zza2 = zzaf.zza(this.zzc, System.currentTimeMillis(), packageName, 2);
        return this.zza.zza(googleApiClient, zza2);
    }

    public final PendingResult<Status> getPendingResult() {
        return this.zzb;
    }
}
