package com.google.android.gms.internal.ads;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzgml implements Iterator<zzgja>, j$.util.Iterator {
    private final ArrayDeque<zzgmn> zza;
    private zzgja zzb;

    public /* synthetic */ zzgml(zzgjf zzgjf, zzgmk zzgmk) {
        if (zzgjf instanceof zzgmn) {
            zzgmn zzgmn = (zzgmn) zzgjf;
            ArrayDeque<zzgmn> arrayDeque = new ArrayDeque<>(zzgmn.zzf());
            this.zza = arrayDeque;
            arrayDeque.push(zzgmn);
            this.zzb = zzb(zzgmn.zzd);
            return;
        }
        this.zza = null;
        this.zzb = (zzgja) zzgjf;
    }

    private final zzgja zzb(zzgjf zzgjf) {
        while (zzgjf instanceof zzgmn) {
            zzgmn zzgmn = (zzgmn) zzgjf;
            this.zza.push(zzgmn);
            zzgjf = zzgmn.zzd;
        }
        return (zzgja) zzgjf;
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public final boolean hasNext() {
        return this.zzb != null;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: zza */
    public final zzgja next() {
        zzgja zzgja;
        zzgja zzgja2 = this.zzb;
        if (zzgja2 != null) {
            do {
                ArrayDeque<zzgmn> arrayDeque = this.zza;
                zzgja = null;
                if (arrayDeque == null || arrayDeque.isEmpty()) {
                    this.zzb = zzgja;
                } else {
                    zzgja = zzb(this.zza.pop().zze);
                }
            } while (zzgja.zzD());
            this.zzb = zzgja;
            return zzgja2;
        }
        throw new NoSuchElementException();
    }
}
