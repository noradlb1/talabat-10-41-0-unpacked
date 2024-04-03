package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.mediation.MediationInterscrollerAd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzbyh extends zzbxp {
    private final MediationInterscrollerAd zza;

    public zzbyh(MediationInterscrollerAd mediationInterscrollerAd) {
        this.zza = mediationInterscrollerAd;
    }

    public final IObjectWrapper zze() {
        return ObjectWrapper.wrap(this.zza.getView());
    }

    public final boolean zzf() {
        return this.zza.shouldDelegateInterscrollerEffect();
    }
}
