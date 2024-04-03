package com.google.android.gms.internal.ads;

import android.os.Handler;
import java.util.concurrent.Executor;

public final class zzagj {
    private final Executor zza;

    public zzagj(Handler handler) {
        this.zza = new zzagh(this, handler);
    }

    public final void zza(zzags<?> zzags, zzahb zzahb) {
        zzags.zzm("post-error");
        zzagy zza2 = zzagy.zza(zzahb);
        Executor executor = this.zza;
        ((zzagh) executor).zza.post(new zzagi(zzags, zza2, (Runnable) null));
    }

    public final void zzb(zzags<?> zzags, zzagy<?> zzagy, Runnable runnable) {
        zzags.zzq();
        zzags.zzm("post-response");
        Executor executor = this.zza;
        ((zzagh) executor).zza.post(new zzagi(zzags, zzagy, runnable));
    }
}
