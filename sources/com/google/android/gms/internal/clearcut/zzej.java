package com.google.android.gms.internal.clearcut;

import java.util.Collections;
import java.util.List;
import java.util.Map;

final class zzej extends zzei {
    public zzej(int i11) {
        super(i11, (zzej) null);
    }

    public final void zzv() {
        if (!isImmutable()) {
            for (int i11 = 0; i11 < zzdr(); i11++) {
                Map.Entry zzak = zzak(i11);
                if (((zzca) zzak.getKey()).zzaw()) {
                    zzak.setValue(Collections.unmodifiableList((List) zzak.getValue()));
                }
            }
            for (Map.Entry entry : zzds()) {
                if (((zzca) entry.getKey()).zzaw()) {
                    entry.setValue(Collections.unmodifiableList((List) entry.getValue()));
                }
            }
        }
        super.zzv();
    }
}
