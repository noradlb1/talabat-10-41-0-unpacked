package com.google.android.gms.fido.fido2;

import android.app.PendingIntent;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.internal.fido.zzl;
import com.google.android.gms.tasks.TaskCompletionSource;

final class zzq extends zzl {
    final /* synthetic */ TaskCompletionSource zza;

    public zzq(Fido2PrivilegedApiClient fido2PrivilegedApiClient, TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    public final void zzb(Status status, @Nullable PendingIntent pendingIntent) {
        TaskUtil.setResultOrApiException(status, pendingIntent, this.zza);
    }
}
