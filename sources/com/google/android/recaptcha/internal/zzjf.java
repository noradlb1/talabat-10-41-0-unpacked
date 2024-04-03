package com.google.android.recaptcha.internal;

import java.util.Map;

final class zzjf extends zzjp {
    public zzjf(int i11) {
        super(i11, (zzjo) null);
    }

    public final void zza() {
        if (!zzj()) {
            for (int i11 = 0; i11 < zzb(); i11++) {
                ((zzgu) zzg(i11).getKey()).zzg();
            }
            for (Map.Entry key : zzc()) {
                ((zzgu) key.getKey()).zzg();
            }
        }
        super.zza();
    }
}
