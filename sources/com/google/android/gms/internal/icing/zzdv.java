package com.google.android.gms.internal.icing;

final class zzdv implements zzec {
    private final zzec[] zza;

    public zzdv(zzec... zzecArr) {
        this.zza = zzecArr;
    }

    public final boolean zzb(Class<?> cls) {
        zzec[] zzecArr = this.zza;
        for (int i11 = 0; i11 < 2; i11++) {
            if (zzecArr[i11].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    public final zzeb zzc(Class<?> cls) {
        String str;
        zzec[] zzecArr = this.zza;
        for (int i11 = 0; i11 < 2; i11++) {
            zzec zzec = zzecArr[i11];
            if (zzec.zzb(cls)) {
                return zzec.zzc(cls);
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
