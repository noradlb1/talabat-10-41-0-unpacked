package com.google.android.libraries.places.internal;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzadn extends zzadx {
    public zzadn(int i11) {
        super(i11, (zzadw) null);
    }

    public final void zza() {
        if (!zzj()) {
            for (int i11 = 0; i11 < zzb(); i11++) {
                Map.Entry zzg = zzg(i11);
                if (((zzabl) zzg.getKey()).zzc()) {
                    zzg.setValue(Collections.unmodifiableList((List) zzg.getValue()));
                }
            }
            for (Map.Entry entry : zzc()) {
                if (((zzabl) entry.getKey()).zzc()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
