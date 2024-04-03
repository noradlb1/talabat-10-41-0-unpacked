package com.google.android.recaptcha.internal;

import java.util.NoSuchElementException;

final class zzez extends zzfb {
    final /* synthetic */ zzfi zza;
    private int zzb = 0;
    private final int zzc;

    public zzez(zzfi zzfi) {
        this.zza = zzfi;
        this.zzc = zzfi.zzd();
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i11 = this.zzb;
        if (i11 < this.zzc) {
            this.zzb = i11 + 1;
            return this.zza.zzb(i11);
        }
        throw new NoSuchElementException();
    }
}
