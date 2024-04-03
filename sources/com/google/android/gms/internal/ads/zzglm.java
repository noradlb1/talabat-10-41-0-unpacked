package com.google.android.gms.internal.ads;

final class zzglm implements zzglt {
    private final zzglt[] zza;

    public zzglm(zzglt... zzgltArr) {
        this.zza = zzgltArr;
    }

    public final zzgls zzb(Class<?> cls) {
        String str;
        zzglt[] zzgltArr = this.zza;
        for (int i11 = 0; i11 < 2; i11++) {
            zzglt zzglt = zzgltArr[i11];
            if (zzglt.zzc(cls)) {
                return zzglt.zzb(cls);
            }
        }
        String name2 = cls.getName();
        if (name2.length() != 0) {
            str = "No factory is available for message type: ".concat(name2);
        } else {
            str = new String("No factory is available for message type: ");
        }
        throw new UnsupportedOperationException(str);
    }

    public final boolean zzc(Class<?> cls) {
        zzglt[] zzgltArr = this.zza;
        for (int i11 = 0; i11 < 2; i11++) {
            if (zzgltArr[i11].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
