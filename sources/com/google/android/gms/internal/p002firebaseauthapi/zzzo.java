package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzg;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzo  reason: invalid package */
final class zzzo extends zzabp {
    public zzzo() {
        super(2);
    }

    public final String zza() {
        return "reload";
    }

    public final void zzb() {
        ((zzg) this.zzi).zza(this.zzn, zzaal.zzS(this.zzg, this.zzo));
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzq(this.zzh.zzf(), this.zzf);
    }
}
