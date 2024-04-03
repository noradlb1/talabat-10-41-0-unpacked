package com.google.android.libraries.places.internal;

final class zzadj implements zzacw {
    private final zzacz zza;
    private final String zzb;
    private final Object[] zzc;
    private final int zzd;

    public zzadj(zzacz zzacz, String str, Object[] objArr) {
        this.zza = zzacz;
        this.zzb = str;
        this.zzc = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.zzd = charAt;
            return;
        }
        char c11 = charAt & 8191;
        int i11 = 13;
        int i12 = 1;
        while (true) {
            int i13 = i12 + 1;
            char charAt2 = str.charAt(i12);
            if (charAt2 >= 55296) {
                c11 |= (charAt2 & 8191) << i11;
                i11 += 13;
                i12 = i13;
            } else {
                this.zzd = c11 | (charAt2 << i11);
                return;
            }
        }
    }

    public final zzacz zza() {
        return this.zza;
    }

    public final boolean zzb() {
        return (this.zzd & 2) == 2;
    }

    public final int zzc() {
        return (this.zzd & 1) == 1 ? 1 : 2;
    }

    public final String zzd() {
        return this.zzb;
    }

    public final Object[] zze() {
        return this.zzc;
    }
}
