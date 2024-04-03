package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyr  reason: invalid package */
final class zzyr extends zzabp {
    private final String zza;
    @Nullable
    private final String zzb;

    public zzyr(String str, @Nullable String str2) {
        super(7);
        Preconditions.checkNotEmpty(str, "code cannot be null or empty");
        this.zza = str;
        this.zzb = str2;
    }

    public final String zza() {
        return "applyActionCode";
    }

    public final void zzb() {
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zza(this.zza, this.zzb, this.zzf);
    }
}
