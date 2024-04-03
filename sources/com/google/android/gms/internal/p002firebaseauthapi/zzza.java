package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.TaskCompletionSource;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzza  reason: invalid package */
final class zzza extends zzabp {
    private final zzwj zza = new zzwj();

    public zzza() {
        super(11);
    }

    public final String zza() {
        return "getRecaptchaParam";
    }

    public final void zzb() {
        zzm(this.zzy);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzk(this.zza, this.zzf);
    }
}
