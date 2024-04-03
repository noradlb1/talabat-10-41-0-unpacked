package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.NoSuchElementException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzad  reason: invalid package */
abstract class zzad extends zzba {
    private final int zza;
    private int zzb;

    public zzad(int i11, int i12) {
        zzu.zzb(i12, i11, FirebaseAnalytics.Param.INDEX);
        this.zza = i11;
        this.zzb = i12;
    }

    public final boolean hasNext() {
        return this.zzb < this.zza;
    }

    public final boolean hasPrevious() {
        return this.zzb > 0;
    }

    public final Object next() {
        if (hasNext()) {
            int i11 = this.zzb;
            this.zzb = i11 + 1;
            return zza(i11);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.zzb;
    }

    public final Object previous() {
        if (hasPrevious()) {
            int i11 = this.zzb - 1;
            this.zzb = i11;
            return zza(i11);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.zzb - 1;
    }

    public abstract Object zza(int i11);
}
