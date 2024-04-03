package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

final class zzfxc implements Executor {
    final /* synthetic */ Executor zza;
    final /* synthetic */ zzfvg zzb;

    public zzfxc(Executor executor, zzfvg zzfvg) {
        this.zza = executor;
        this.zzb = zzfvg;
    }

    public final void execute(Runnable runnable) {
        try {
            this.zza.execute(runnable);
        } catch (RejectedExecutionException e11) {
            this.zzb.zzt(e11);
        }
    }
}
