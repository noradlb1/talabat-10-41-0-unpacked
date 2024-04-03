package com.google.firebase.appindexing.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.IStatusCallback;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzl extends IStatusCallback.Stub {
    final /* synthetic */ TaskCompletionSource zza;
    final /* synthetic */ zzm zzb;

    public zzl(zzm zzm, TaskCompletionSource taskCompletionSource) {
        this.zzb = zzm;
        this.zza = taskCompletionSource;
    }

    public final void onResult(Status status) throws RemoteException {
        if (!this.zza.trySetResult(null)) {
            return;
        }
        if (status.isSuccess()) {
            this.zzb.zza.zzc.setResult(null);
        } else {
            this.zzb.zza.zzc.setException(zzaf.zza(status, "Indexing error, please try again."));
        }
    }
}
