package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zztd extends zztc {
    public zztd(int i11) {
        super(i11, (zztd) null);
    }

    public final void zzmi() {
        if (!isImmutable()) {
            for (int i11 = 0; i11 < zzra(); i11++) {
                Map.Entry zzbv = zzbv(i11);
                if (((zzqv) zzbv.getKey()).zzoz()) {
                    zzbv.setValue(Collections.unmodifiableList((List) zzbv.getValue()));
                }
            }
            for (Map.Entry entry : zzrb()) {
                if (((zzqv) entry.getKey()).zzoz()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzmi();
    }
}
