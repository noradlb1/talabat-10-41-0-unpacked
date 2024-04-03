package com.google.android.recaptcha.internal;

final class zzig implements zzin {
    private final zzin[] zza;

    public zzig(zzin... zzinArr) {
        this.zza = zzinArr;
    }

    public final zzim zzb(Class cls) {
        zzin[] zzinArr = this.zza;
        for (int i11 = 0; i11 < 2; i11++) {
            zzin zzin = zzinArr[i11];
            if (zzin.zzc(cls)) {
                return zzin.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    public final boolean zzc(Class cls) {
        zzin[] zzinArr = this.zza;
        for (int i11 = 0; i11 < 2; i11++) {
            if (zzinArr[i11].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
