package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzgmr extends zzgnb {
    public zzgmr(int i11) {
        super(i11, (zzgna) null);
    }

    public final void zza() {
        if (!zzj()) {
            for (int i11 = 0; i11 < zzb(); i11++) {
                Map.Entry zzg = zzg(i11);
                if (((zzgkb) zzg.getKey()).zzc()) {
                    zzg.setValue(Collections.unmodifiableList((List) zzg.getValue()));
                }
            }
            for (Map.Entry entry : zzc()) {
                if (((zzgkb) entry.getKey()).zzc()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
