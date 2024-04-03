package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;

final class zzt extends zzv {
    final /* synthetic */ long zza;
    final /* synthetic */ PendingIntent zzb;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzt(zzw zzw, GoogleApiClient googleApiClient, long j11, PendingIntent pendingIntent) {
        super(googleApiClient);
        this.zza = j11;
        this.zzb = pendingIntent;
    }

    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        boolean z11;
        zzf zzf = (zzf) anyClient;
        long j11 = this.zza;
        PendingIntent pendingIntent = this.zzb;
        Preconditions.checkNotNull(pendingIntent);
        if (j11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11, "detectionIntervalMillis must be >= 0");
        ((zzo) zzf.getService()).zzr(j11, true, pendingIntent);
        setResult(Status.RESULT_SUCCESS);
    }
}
