package com.google.firebase.appindexing.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.concurrent.Executor;

@VisibleForTesting
final class zzn {
    final /* synthetic */ zzo zza;
    /* access modifiers changed from: private */
    public final zzz zzb;
    /* access modifiers changed from: private */
    public final TaskCompletionSource<Void> zzc = new TaskCompletionSource<>();

    public zzn(zzo zzo, zzz zzz) {
        this.zza = zzo;
        this.zzb = zzz;
    }

    public final Task<Void> zza() {
        return this.zzc.getTask();
    }

    public final void zzb() {
        boolean z11;
        synchronized (this.zza.zzc) {
            if (this.zza.zzd == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            Preconditions.checkState(z11);
            int unused = this.zza.zzd = 1;
        }
        this.zza.zza.doWrite(new zzm(this, (zzi) null)).addOnFailureListener((Executor) this.zza, (OnFailureListener) new zzk(this));
    }

    public final /* synthetic */ void zzc(Exception exc) {
        zzn zzn;
        synchronized (this.zza.zzc) {
            if (this.zza.zzc.peek() == this) {
                this.zza.zzc.remove();
                int unused = this.zza.zzd = 0;
                zzn = (zzn) this.zza.zzc.peek();
            } else {
                zzn = null;
            }
        }
        this.zzc.trySetException(exc);
        if (zzn != null) {
            zzn.zzb();
        }
    }
}
