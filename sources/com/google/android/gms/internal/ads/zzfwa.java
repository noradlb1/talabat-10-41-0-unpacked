package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import javax.annotation.CheckForNull;

abstract class zzfwa<V, C> extends zzfvp<V, C> {
    @CheckForNull
    private List<zzfvz<V>> zza;

    public zzfwa(zzfsn<? extends zzfxa<? extends V>> zzfsn, boolean z11) {
        super(zzfsn, true, true);
        List<zzfvz<V>> list;
        if (zzfsn.isEmpty()) {
            list = Collections.emptyList();
        } else {
            list = zzftk.zza(zzfsn.size());
        }
        for (int i11 = 0; i11 < zzfsn.size(); i11++) {
            list.add((Object) null);
        }
        this.zza = list;
    }

    public final void zzA(int i11) {
        super.zzA(i11);
        this.zza = null;
    }

    public abstract C zzI(List<zzfvz<V>> list);

    public final void zzb(int i11, V v11) {
        List<zzfvz<V>> list = this.zza;
        if (list != null) {
            list.set(i11, new zzfvz(v11));
        }
    }

    public final void zzw() {
        List<zzfvz<V>> list = this.zza;
        if (list != null) {
            zzs(zzI(list));
        }
    }
}
