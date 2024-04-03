package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.TaskCompletionSource;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzr  reason: invalid package */
final class zzzr extends zzabp {
    private final zzwp zza;

    public zzzr(@Nullable String str) {
        super(9);
        this.zza = new zzwp(str);
    }

    public final String zza() {
        return "setFirebaseUIVersion";
    }

    public final void zzb() {
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzu(this.zza, this.zzf);
    }
}
