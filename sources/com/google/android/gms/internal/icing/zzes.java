package com.google.android.gms.internal.icing;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzes extends zzez {
    public zzes(int i11) {
        super(i11, (zzes) null);
    }

    public final void zza() {
        if (!zzb()) {
            for (int i11 = 0; i11 < zzc(); i11++) {
                Map.Entry zzd = zzd(i11);
                if (((zzct) zzd.getKey()).zzc()) {
                    zzd.setValue(Collections.unmodifiableList((List) zzd.getValue()));
                }
            }
            for (Map.Entry entry : zze()) {
                if (((zzct) entry.getKey()).zzc()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zza();
    }
}
