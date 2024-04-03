package com.google.android.gms.internal.location;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.location.zzu;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzco extends zzj {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzu zzb;

    public zzco(TaskCompletionSource taskCompletionSource, zzu zzu) {
        this.zza = taskCompletionSource;
        this.zzb = zzu;
    }

    public final void zzd(zzg zzg) {
        TaskUtil.setResultOrApiException(zzg.getStatus(), this.zza);
    }

    public final void zze() throws RemoteException {
        this.zzb.zze();
    }
}
