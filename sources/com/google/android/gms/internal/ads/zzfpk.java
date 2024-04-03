package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

public final /* synthetic */ class zzfpk implements OnCompleteListener {
    public final /* synthetic */ zzfxi zza;

    public /* synthetic */ zzfpk(zzfxi zzfxi) {
        this.zza = zzfxi;
    }

    public final void onComplete(Task task) {
        zzfxi zzfxi = this.zza;
        if (task.isCanceled()) {
            zzfxi.cancel(false);
        } else if (task.isSuccessful()) {
            zzfxi.zzs(task.getResult());
        } else {
            Exception exception = task.getException();
            if (exception != null) {
                zzfxi.zzt(exception);
                return;
            }
            throw new IllegalStateException();
        }
    }
}
