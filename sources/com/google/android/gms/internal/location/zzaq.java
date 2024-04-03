package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzaq extends zzat {
    final /* synthetic */ boolean zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzaq(zzau zzau, GoogleApiClient googleApiClient, boolean z11) {
        super(googleApiClient);
        this.zza = z11;
    }

    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzda) anyClient).zzA(this.zza, zzau.zza(this));
    }
}
