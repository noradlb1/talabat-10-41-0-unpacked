package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnFailureListener;

public final /* synthetic */ class zzfmu implements OnFailureListener {
    public final /* synthetic */ zzfna zza;

    public /* synthetic */ zzfmu(zzfna zzfna) {
        this.zza = zzfna;
    }

    public final void onFailure(Exception exc) {
        this.zza.zzf(exc);
    }
}
