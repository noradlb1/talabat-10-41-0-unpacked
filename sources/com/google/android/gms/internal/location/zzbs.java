package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzbs extends zzbu {
    final /* synthetic */ PendingIntent zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbs(zzbv zzbv, GoogleApiClient googleApiClient, PendingIntent pendingIntent) {
        super(googleApiClient);
        this.zza = pendingIntent;
    }

    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzda) anyClient).zzx(this.zza, zzbv.zza(this));
    }
}
