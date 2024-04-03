package com.google.android.libraries.places.internal;

import java.io.Serializable;
import java.lang.Comparable;
import javax.annotation.CheckForNull;

abstract class zzfz<C extends Comparable> implements Comparable<zzfz<C>>, Serializable {
    final C zza;

    public zzfz(C c11) {
        this.zza = c11;
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzfz) {
            try {
                if (compareTo((zzfz) obj) == 0) {
                    return true;
                }
            } catch (ClassCastException unused) {
            }
        }
        return false;
    }

    public abstract int hashCode();

    /* renamed from: zza */
    public int compareTo(zzfz<C> zzfz) {
        if (zzfz != zzfx.zzb) {
            if (zzfz == zzfv.zzb) {
                return -1;
            }
            int zza2 = zzgp.zza(this.zza, zzfz.zza);
            if (zza2 != 0) {
                return zza2;
            }
            boolean z11 = this instanceof zzfw;
            if (z11 == (zzfz instanceof zzfw)) {
                return 0;
            }
            if (!z11) {
                return -1;
            }
        }
        return 1;
    }

    public abstract void zzc(StringBuilder sb2);

    public abstract void zzd(StringBuilder sb2);

    public abstract boolean zze(C c11);
}
