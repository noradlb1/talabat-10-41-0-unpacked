package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzbxa {
    private static zzbxa zza;
    private final AtomicBoolean zzb = new AtomicBoolean(false);

    public static zzbxa zza() {
        if (zza == null) {
            zza = new zzbxa();
        }
        return zza;
    }

    @Nullable
    public final Thread zzb(Context context, @Nullable String str) {
        if (!this.zzb.compareAndSet(false, true)) {
            return null;
        }
        Thread thread = new Thread(new zzbwz(this, context, str));
        thread.start();
        return thread;
    }
}
