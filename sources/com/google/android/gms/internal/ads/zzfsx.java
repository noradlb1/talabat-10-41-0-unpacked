package com.google.android.gms.internal.ads;

import java.util.Iterator;

final class zzfsx extends zzfuu {
    final Iterator<? extends zzfsn> zza;
    Iterator zzb = zzfte.zza;
    final /* synthetic */ zzfta zzc;

    public zzfsx(zzfta zzfta) {
        this.zzc = zzfta;
        this.zza = ((zzfss) zzfta.zzb.values()).listIterator(0);
    }

    public final boolean hasNext() {
        return this.zzb.hasNext() || this.zza.hasNext();
    }

    public final Object next() {
        if (!this.zzb.hasNext()) {
            this.zzb = ((zzfsn) this.zza.next()).iterator();
        }
        return this.zzb.next();
    }
}
