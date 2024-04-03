package com.google.android.libraries.places.api.model;

abstract class zzg extends zzbb {
    private final int zza;
    private final int zzb;

    public zzg(int i11, int i12) {
        this.zza = i11;
        this.zzb = i12;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzbb) {
            zzbb zzbb = (zzbb) obj;
            if (this.zza == zzbb.zzb() && this.zzb == zzbb.zza()) {
                return true;
            }
            return false;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza ^ 1000003) * 1000003) ^ this.zzb;
    }

    public final String toString() {
        int i11 = this.zza;
        int i12 = this.zzb;
        StringBuilder sb2 = new StringBuilder(54);
        sb2.append("SubstringMatch{offset=");
        sb2.append(i11);
        sb2.append(", length=");
        sb2.append(i12);
        sb2.append("}");
        return sb2.toString();
    }

    public final int zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zza;
    }
}
