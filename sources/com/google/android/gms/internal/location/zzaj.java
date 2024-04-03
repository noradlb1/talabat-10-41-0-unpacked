package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

final class zzaj extends zzat {
    public zzaj(zzau zzau, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    public final /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        ((zzda) anyClient).zzr(zzau.zza(this));
    }
}
