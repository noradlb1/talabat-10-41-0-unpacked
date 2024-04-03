package com.google.android.gms.internal.ads;

public final class zzffz implements zzffx {
    private final String zza;

    public zzffz(String str) {
        this.zza = str;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzffz)) {
            return false;
        }
        return this.zza.equals(((zzffz) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final String toString() {
        return this.zza;
    }
}
