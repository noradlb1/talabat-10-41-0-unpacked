package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

public final class zzcqn {
    /* access modifiers changed from: private */
    public zzcjf zza;
    /* access modifiers changed from: private */
    public Context zzb;
    /* access modifiers changed from: private */
    public WeakReference<Context> zzc;

    public final zzcqn zzc(Context context) {
        this.zzc = new WeakReference<>(context);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        this.zzb = context;
        return this;
    }

    public final zzcqn zzd(zzcjf zzcjf) {
        this.zza = zzcjf;
        return this;
    }
}
