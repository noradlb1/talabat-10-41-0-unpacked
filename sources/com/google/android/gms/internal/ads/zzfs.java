package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Handler;

final class zzfs {
    private final Context zza;
    private final zzfq zzb;

    public zzfs(Context context, Handler handler, zzfr zzfr) {
        this.zza = context.getApplicationContext();
        this.zzb = new zzfq(this, handler, zzfr);
    }
}
