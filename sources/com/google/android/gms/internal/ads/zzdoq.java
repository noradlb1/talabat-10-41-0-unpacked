package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzdoq implements zzgpr<Set<String>> {
    private final zzgqe<zzdqn> zza;

    public zzdoq(zzgqe<zzdqn> zzgqe) {
        this.zza = zzgqe;
    }

    public final /* bridge */ /* synthetic */ Object zzb() {
        Set set;
        if (((zzdon) this.zza).zza().zze() != null) {
            set = Collections.singleton("banner");
        } else {
            set = Collections.emptySet();
        }
        zzgpz.zzb(set);
        return set;
    }
}
