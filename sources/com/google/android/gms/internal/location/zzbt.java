package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.List;

final class zzbt extends zzbu {
    final /* synthetic */ List zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzbt(zzbv zzbv, GoogleApiClient googleApiClient, List list) {
        super(googleApiClient);
        this.zza = list;
    }

    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzda) anyClient).zzy(this.zza, zzbv.zza(this));
    }
}
