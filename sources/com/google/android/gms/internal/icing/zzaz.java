package com.google.android.gms.internal.icing;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;

final class zzaz extends zzaw {
    final /* synthetic */ zzba zza;

    public zzaz(zzba zzba) {
        this.zza = zzba;
    }

    public final void zzb(Status status, GoogleNowAuthState googleNowAuthState) {
        boolean unused = this.zza.zzc;
        this.zza.setResult(new zzbb(status, googleNowAuthState));
    }
}
