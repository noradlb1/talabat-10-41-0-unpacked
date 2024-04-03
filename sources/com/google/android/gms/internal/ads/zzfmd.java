package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class zzfmd implements Continuation {
    public final /* synthetic */ zzail zza;
    public final /* synthetic */ int zzb;

    public /* synthetic */ zzfmd(zzail zzail, int i11) {
        this.zza = zzail;
        this.zzb = i11;
    }

    public final Object then(Task task) {
        zzail zzail = this.zza;
        int i11 = this.zzb;
        int i12 = zzfmh.zza;
        if (!task.isSuccessful()) {
            return Boolean.FALSE;
        }
        zzfoi zza2 = ((zzfoj) task.getResult()).zza(((zzaip) zzail.zzah()).zzar());
        zza2.zza(i11);
        zza2.zzc();
        return Boolean.TRUE;
    }
}
