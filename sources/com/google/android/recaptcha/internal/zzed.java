package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.List;

final class zzed extends zzdy {
    final /* synthetic */ Iterable zza;
    final /* synthetic */ int zzb;

    public zzed(Iterable iterable, int i11) {
        this.zza = iterable;
        this.zzb = i11;
    }

    public final Iterator iterator() {
        boolean z11;
        Iterable iterable = this.zza;
        if (iterable instanceof List) {
            List list = (List) iterable;
            return list.subList(Math.min(list.size(), this.zzb), list.size()).iterator();
        }
        Iterator it = iterable.iterator();
        int i11 = this.zzb;
        it.getClass();
        if (i11 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdr.zzb(z11, "numberToAdvance must be nonnegative");
        for (int i12 = 0; i12 < i11 && it.hasNext(); i12++) {
            it.next();
        }
        return new zzec(this, it);
    }
}
