package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.location.zzr;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzcp extends zzj {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzr zzb;

    public zzcp(TaskCompletionSource taskCompletionSource, zzr zzr) {
        this.zza = taskCompletionSource;
        this.zzb = zzr;
    }

    public final void zzd(zzg zzg) {
        TaskUtil.setResultOrApiException(zzg.getStatus(), this.zza);
    }

    public final void zze() throws RemoteException {
        this.zzb.zzf();
    }
}
