package com.google.android.gms.phenotype;

import android.database.ContentObserver;
import android.os.Handler;

final class zzb extends ContentObserver {
    private final /* synthetic */ zza zzm;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzb(zza zza, Handler handler) {
        super((Handler) null);
        this.zzm = zza;
    }

    public final void onChange(boolean z11) {
        this.zzm.zzb();
    }
}
