package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.Map;

final class zzfsa extends AbstractCollection {
    final /* synthetic */ zzfsb zza;

    public zzfsa(zzfsb zzfsb) {
        this.zza = zzfsb;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final Iterator iterator() {
        zzfsb zzfsb = this.zza;
        Map zzl = zzfsb.zzl();
        if (zzl != null) {
            return zzl.values().iterator();
        }
        return new zzfru(zzfsb);
    }

    public final int size() {
        return this.zza.size();
    }
}
