package com.google.firebase.appindexing.internal;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.icing.zzar;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

@VisibleForTesting
final class zzo implements OnCompleteListener<Void>, Executor {
    /* access modifiers changed from: private */
    @NonNull
    public final GoogleApi<?> zza;
    @NonNull
    private final Handler zzb;
    /* access modifiers changed from: private */
    @GuardedBy("pendingCalls")
    public final Queue<zzn> zzc = new ArrayDeque();
    /* access modifiers changed from: private */
    @GuardedBy("pendingCalls")
    public int zzd = 0;

    public zzo(@NonNull GoogleApi<?> googleApi) {
        this.zza = googleApi;
        this.zzb = new zzar(googleApi.getLooper());
    }

    public final void execute(Runnable runnable) {
        this.zzb.post(runnable);
    }

    public final void onComplete(@NonNull Task<Void> task) {
        zzn zzn;
        boolean z11;
        synchronized (this.zzc) {
            if (this.zzd == 2) {
                zzn = this.zzc.peek();
                if (zzn != null) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                Preconditions.checkState(z11);
            } else {
                zzn = null;
            }
            this.zzd = 0;
        }
        if (zzn != null) {
            zzn.zzb();
        }
    }

    public final Task<Void> zza(zzz zzz) {
        boolean isEmpty;
        zzn zzn = new zzn(this, zzz);
        Task<Void> zza2 = zzn.zza();
        zza2.addOnCompleteListener((Executor) this, (OnCompleteListener<Void>) this);
        synchronized (this.zzc) {
            isEmpty = this.zzc.isEmpty();
            this.zzc.add(zzn);
        }
        if (isEmpty) {
            zzn.zzb();
        }
        return zza2;
    }
}
