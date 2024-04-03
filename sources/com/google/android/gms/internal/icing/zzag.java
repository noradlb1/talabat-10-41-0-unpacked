package com.google.android.gms.internal.icing;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

final class zzag extends zzaj<Status> {
    final /* synthetic */ zzx[] zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzag(zzal zzal, GoogleApiClient googleApiClient, zzx[] zzxArr) {
        super(googleApiClient);
        this.zza = zzxArr;
    }

    public final void zza(zzaa zzaa) throws RemoteException {
        zzaa.zzd(new zzak(this), (String) null, this.zza);
    }
}
