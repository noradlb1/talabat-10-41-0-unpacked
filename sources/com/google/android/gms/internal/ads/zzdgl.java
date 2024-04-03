package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Set;

public final class zzdgl extends zzdkb<zzfmb> implements zzbqt {
    private final Bundle zzb = new Bundle();

    public zzdgl(Set<zzdlw<zzfmb>> set) {
        super(set);
    }

    public final synchronized void zza(String str, Bundle bundle) {
        this.zzb.putAll(bundle);
        zzo(zzdgk.zza);
    }

    public final synchronized Bundle zzb() {
        return new Bundle(this.zzb);
    }
}
