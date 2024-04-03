package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

final class zzfry extends AbstractSet {
    final /* synthetic */ zzfsb zza;

    public zzfry(zzfsb zzfsb) {
        this.zza = zzfsb;
    }

    public final void clear() {
        this.zza.clear();
    }

    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.containsKey(obj);
    }

    public final Iterator iterator() {
        zzfsb zzfsb = this.zza;
        Map zzl = zzfsb.zzl();
        if (zzl != null) {
            return zzl.keySet().iterator();
        }
        return new zzfrs(zzfsb);
    }

    public final boolean remove(@CheckForNull Object obj) {
        Map zzl = this.zza.zzl();
        if (zzl != null) {
            return zzl.keySet().remove(obj);
        }
        if (this.zza.zzy(obj) == zzfsb.zzd) {
            return false;
        }
        return true;
    }

    public final int size() {
        return this.zza.size();
    }
}
