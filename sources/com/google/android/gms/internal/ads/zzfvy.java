package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class zzfvy<V> extends zzfwa<V, List<V>> {
    public zzfvy(zzfsn<? extends zzfxa<? extends V>> zzfsn, boolean z11) {
        super(zzfsn, true);
        zzx();
    }

    public final /* bridge */ /* synthetic */ Object zzI(List list) {
        V v11;
        ArrayList zza = zzftk.zza(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzfvz zzfvz = (zzfvz) it.next();
            if (zzfvz != null) {
                v11 = zzfvz.zza;
            } else {
                v11 = null;
            }
            zza.add(v11);
        }
        return Collections.unmodifiableList(zza);
    }
}
