package com.google.android.gms.internal.places;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzde extends zzdb {
    public zzde(int i11) {
        super(i11, (zzde) null);
    }

    public final void zzab() {
        if (!isImmutable()) {
            for (int i11 = 0; i11 < zzcu(); i11++) {
                Map.Entry zzam = zzam(i11);
                if (((zzax) zzam.getKey()).zzaz()) {
                    zzam.setValue(Collections.unmodifiableList((List) zzam.getValue()));
                }
            }
            for (Map.Entry entry : zzcv()) {
                if (((zzax) entry.getKey()).zzaz()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzab();
    }
}
