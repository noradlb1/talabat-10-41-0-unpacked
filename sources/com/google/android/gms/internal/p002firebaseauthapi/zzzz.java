package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzag;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzz  reason: invalid package */
final class zzzz extends zzabp {
    private final zzaen zza;

    public zzzz(zzag zzag, @Nullable String str) {
        super(12);
        Preconditions.checkNotNull(zzag);
        this.zza = zzaen.zzb(Preconditions.checkNotEmpty(zzag.zzd()), str);
    }

    public final String zza() {
        return "startMfaEnrollment";
    }

    public final void zzb() {
        zzm(this.zzz);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzD(this.zza, this.zzf);
    }
}
