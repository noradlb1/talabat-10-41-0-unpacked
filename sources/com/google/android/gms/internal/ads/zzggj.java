package com.google.android.gms.internal.ads;

public final class zzggj {
    private static final zzgko<zzggj> zza = new zzggi();

    public static int zza(int i11) {
        if (i11 != 1) {
            return i11 - 2;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    public static int zzb(int i11) {
        if (i11 == 0) {
            return 2;
        }
        if (i11 == 1) {
            return 3;
        }
        if (i11 == 2) {
            return 4;
        }
        if (i11 != 3) {
            return i11 != 4 ? 0 : 6;
        }
        return 5;
    }
}
