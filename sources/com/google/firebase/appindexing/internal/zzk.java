package com.google.firebase.appindexing.internal;

import com.google.android.gms.tasks.OnFailureListener;

final /* synthetic */ class zzk implements OnFailureListener {
    private final zzn zza;

    public zzk(zzn zzn) {
        this.zza = zzn;
    }

    public final void onFailure(Exception exc) {
        this.zza.zzc(exc);
    }
}
