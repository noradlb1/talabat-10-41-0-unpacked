package com.google.android.gms.internal.common;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Iterator;

public final class zzad extends zzaa {
    public zzad() {
        super(4);
    }

    @CanIgnoreReturnValue
    public final zzad zzb(Object obj) {
        super.zza(obj);
        return this;
    }

    @CanIgnoreReturnValue
    public final zzad zzc(Iterator it) {
        while (it.hasNext()) {
            super.zza(it.next());
        }
        return this;
    }

    public zzad(int i11) {
        super(4);
    }
}
