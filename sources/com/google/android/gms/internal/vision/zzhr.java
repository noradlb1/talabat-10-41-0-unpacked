package com.google.android.gms.internal.vision;

final class zzhr implements zzhz {
    private zzhz[] zzyl;

    public zzhr(zzhz... zzhzArr) {
        this.zzyl = zzhzArr;
    }

    public final boolean zza(Class<?> cls) {
        for (zzhz zza : this.zzyl) {
            if (zza.zza(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzia zzb(Class<?> cls) {
        String str;
        for (zzhz zzhz : this.zzyl) {
            if (zzhz.zza(cls)) {
                return zzhz.zzb(cls);
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
}
