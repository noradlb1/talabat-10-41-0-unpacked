package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzan;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyv  reason: invalid package */
final class zzyv extends zzabp {
    public zzyv() {
        super(5);
    }

    public final String zza() {
        return "delete";
    }

    public final void zzb() {
        ((zzan) this.zzi).zza();
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzg(this.zzh.zzf(), this.zzf);
    }
}
