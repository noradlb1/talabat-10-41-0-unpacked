package com.google.android.libraries.places.internal;

import java.io.Closeable;

public final class zzjg implements Closeable {
    private static final ThreadLocal<zzjg> zza = new zzjf();
    private int zzb = 0;

    public static int zza() {
        return zza.get().zzb;
    }

    public final void close() {
        int i11 = this.zzb;
        if (i11 > 0) {
            this.zzb = i11 - 1;
            return;
        }
        throw new AssertionError("Mismatched calls to RecursionDepth (possible error in core library)");
    }
}
