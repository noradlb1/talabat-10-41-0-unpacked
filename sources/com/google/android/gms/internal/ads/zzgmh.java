package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

final class zzgmh extends zzgix {
    final zzgml zza;
    zzgiz zzb = zzb();
    final /* synthetic */ zzgmn zzc;

    public zzgmh(zzgmn zzgmn) {
        this.zzc = zzgmn;
        this.zza = new zzgml(zzgmn, (zzgmk) null);
    }

    private final zzgiz zzb() {
        if (this.zza.hasNext()) {
            return this.zza.next().iterator();
        }
        return null;
    }

    public final boolean hasNext() {
        return this.zzb != null;
    }

    public final byte zza() {
        zzgiz zzgiz = this.zzb;
        if (zzgiz != null) {
            byte zza2 = zzgiz.zza();
            if (!this.zzb.hasNext()) {
                this.zzb = zzb();
            }
            return zza2;
        }
        throw new NoSuchElementException();
    }
}
