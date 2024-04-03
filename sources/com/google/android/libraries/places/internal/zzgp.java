package com.google.android.libraries.places.internal;

import java.lang.Comparable;
import javax.annotation.CheckForNull;

public final class zzgp<C extends Comparable> extends zzgq {
    private static final zzgp<Comparable> zzc = new zzgp<>(zzfx.zzb, zzfv.zzb);
    final zzfz<C> zza;
    final zzfz<C> zzb;

    private zzgp(zzfz<C> zzfz, zzfz<C> zzfz2) {
        String str;
        this.zza = zzfz;
        this.zzb = zzfz2;
        if (zzfz.compareTo(zzfz2) > 0 || zzfz == zzfv.zzb || zzfz2 == zzfx.zzb) {
            String valueOf = String.valueOf(zzf(zzfz, zzfz2));
            if (valueOf.length() != 0) {
                str = "Invalid range: ".concat(valueOf);
            } else {
                str = new String("Invalid range: ");
            }
            throw new IllegalArgumentException(str);
        }
    }

    public static int zza(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    public static <C extends Comparable<?>> zzgp<C> zzb(C c11) {
        return new zzgp<>(new zzfy(c11), zzfv.zzb);
    }

    public static <C extends Comparable<?>> zzgp<C> zzc(C c11, C c12) {
        return new zzgp<>(new zzfy(c11), new zzfw(c12));
    }

    public static <C extends Comparable<?>> zzgp<C> zzd(C c11, C c12) {
        return new zzgp<>(new zzfy(c11), new zzfy(c12));
    }

    private static String zzf(zzfz<?> zzfz, zzfz<?> zzfz2) {
        StringBuilder sb2 = new StringBuilder(16);
        zzfz.zzc(sb2);
        sb2.append("..");
        zzfz2.zzd(sb2);
        return sb2.toString();
    }

    public final boolean equals(@CheckForNull Object obj) {
        if (obj instanceof zzgp) {
            zzgp zzgp = (zzgp) obj;
            if (!this.zza.equals(zzgp.zza) || !this.zzb.equals(zzgp.zzb)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (this.zza.hashCode() * 31) + this.zzb.hashCode();
    }

    public final String toString() {
        return zzf(this.zza, this.zzb);
    }

    public final boolean zze(C c11) {
        c11.getClass();
        if (!this.zza.zze(c11) || this.zzb.zze(c11)) {
            return false;
        }
        return true;
    }
}
