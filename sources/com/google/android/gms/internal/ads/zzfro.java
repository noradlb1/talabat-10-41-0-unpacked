package com.google.android.gms.internal.ads;

import java.util.AbstractCollection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

final class zzfro extends AbstractCollection {
    final /* synthetic */ zzfrp zza;

    public zzfro(zzfrp zzfrp) {
        this.zza = zzfrp;
    }

    public final void clear() {
        this.zza.zzp();
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.zzu(obj);
    }

    public final Iterator iterator() {
        return this.zza.zzg();
    }

    public final int size() {
        return this.zza.zze();
    }
}
