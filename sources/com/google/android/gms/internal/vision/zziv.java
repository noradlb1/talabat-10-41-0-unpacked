package com.google.android.gms.internal.vision;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zziv extends zziw {
    public zziv(int i11) {
        super(i11, (zziv) null);
    }

    public final void zzdp() {
        if (!isImmutable()) {
            for (int i11 = 0; i11 < zzhx(); i11++) {
                Map.Entry zzbu = zzbu(i11);
                if (((zzgk) zzbu.getKey()).zzfu()) {
                    zzbu.setValue(Collections.unmodifiableList((List) zzbu.getValue()));
                }
            }
            for (Map.Entry entry : zzhy()) {
                if (((zzgk) entry.getKey()).zzfu()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzdp();
    }
}
