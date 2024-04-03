package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.WeakHashMap;
import java.util.concurrent.Future;

public final class zzcdy {
    /* access modifiers changed from: private */
    public final WeakHashMap<Context, zzcdx> zza = new WeakHashMap<>();

    public final Future<zzcdv> zzb(Context context) {
        return zzcjm.zza.zzb(new zzcdw(this, context));
    }
}
