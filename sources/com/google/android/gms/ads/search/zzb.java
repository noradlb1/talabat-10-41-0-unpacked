package com.google.android.gms.ads.search;

import android.os.Bundle;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.internal.ads.zzbjf;

public final class zzb {
    /* access modifiers changed from: private */
    public final zzbjf zza = new zzbjf();
    /* access modifiers changed from: private */
    public String zzb;

    public final zzb zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
        this.zza.zzs(cls, bundle);
        return this;
    }

    public final zzb zzc(NetworkExtras networkExtras) {
        this.zza.zzw(networkExtras);
        return this;
    }

    public final zzb zzd(Class<? extends MediationAdapter> cls, Bundle bundle) {
        this.zza.zzv(cls, bundle);
        return this;
    }

    public final zzb zze(String str) {
        this.zzb = str;
        return this;
    }
}
