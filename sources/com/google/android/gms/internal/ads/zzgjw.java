package com.google.android.gms.internal.ads;

final class zzgjw {
    private final Object zza;
    private final int zzb;

    public zzgjw(Object obj, int i11) {
        this.zza = obj;
        this.zzb = i11;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzgjw)) {
            return false;
        }
        zzgjw zzgjw = (zzgjw) obj;
        if (this.zza == zzgjw.zza && this.zzb == zzgjw.zzb) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return (System.identityHashCode(this.zza) * 65535) + this.zzb;
    }
}
