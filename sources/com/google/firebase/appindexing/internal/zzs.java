package com.google.firebase.appindexing.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.icing.zzaa;
import com.google.android.gms.internal.icing.zzae;
import com.google.android.gms.tasks.TaskCompletionSource;

abstract class zzs extends TaskApiCall<zzae, Void> implements BaseImplementation.ResultHolder<Status> {
    protected TaskCompletionSource<Void> zzb;

    public zzs() {
        super((Feature[]) null, false, 9004);
    }

    public final /* bridge */ /* synthetic */ void doExecute(Api.AnyClient anyClient, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzb = taskCompletionSource;
        zza((zzaa) ((zzae) anyClient).getService());
    }

    public final void setFailedResult(Status status) {
        Preconditions.checkArgument(!status.isSuccess(), "Failed result must not be success.");
        String statusMessage = status.getStatusMessage();
        if (statusMessage == null) {
            statusMessage = "";
        }
        this.zzb.setException(zzaf.zza(status, statusMessage));
    }

    public final /* bridge */ /* synthetic */ void setResult(Object obj) {
        Status status = (Status) obj;
        if (status.isSuccess()) {
            this.zzb.setResult(null);
        } else {
            this.zzb.setException(zzaf.zza(status, "User Action indexing error, please try again."));
        }
    }

    public abstract void zza(zzaa zzaa) throws RemoteException;
}
