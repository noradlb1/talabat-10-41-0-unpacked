package com.google.android.libraries.places.internal;

final class zzacq implements zzacx {
    private final zzacx[] zza;

    public zzacq(zzacx... zzacxArr) {
        this.zza = zzacxArr;
    }

    public final zzacw zzb(Class<?> cls) {
        String str;
        zzacx[] zzacxArr = this.zza;
        for (int i11 = 0; i11 < 2; i11++) {
            zzacx zzacx = zzacxArr[i11];
            if (zzacx.zzc(cls)) {
                return zzacx.zzb(cls);
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
        zzacx[] zzacxArr = this.zza;
        for (int i11 = 0; i11 < 2; i11++) {
            if (zzacxArr[i11].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
