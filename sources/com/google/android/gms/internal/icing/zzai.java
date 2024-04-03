package com.google.android.gms.internal.icing;

import android.os.RemoteException;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BaseImplementation;

abstract class zzai<T extends Result> extends BaseImplementation.ApiMethodImpl<T, zzae> {
    public zzai(GoogleApiClient googleApiClient) {
        super((Api<?>) zze.zzb, googleApiClient);
    }

    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient) throws RemoteException {
        zza((zzaa) ((zzae) anyClient).getService());
    }

    @KeepForSdk
    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        super.setResult((Result) obj);
    }

    public abstract void zza(zzaa zzaa) throws RemoteException;
}
