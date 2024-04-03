package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaak  reason: invalid package */
final class zzaak extends zzabp {
    private final zzwo zza;

    public zzaak(zzaeb zzaeb) {
        super(8);
        Preconditions.checkNotNull(zzaeb);
        this.zza = new zzwo(zzaeb);
    }

    public final String zza() {
        return "verifyPhoneNumber";
    }

    public final void zzb() {
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzt(this.zza, this.zzf);
    }
}
