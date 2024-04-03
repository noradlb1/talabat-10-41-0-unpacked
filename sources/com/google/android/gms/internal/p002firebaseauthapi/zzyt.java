package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyt  reason: invalid package */
final class zzyt extends zzabp {
    private final zzwi zza;

    public zzyt(String str, String str2, @Nullable String str3) {
        super(4);
        Preconditions.checkNotEmpty(str, "code cannot be null or empty");
        Preconditions.checkNotEmpty(str2, "new password cannot be null or empty");
        this.zza = new zzwi(str, str2, str3);
    }

    public final String zza() {
        return "confirmPasswordReset";
    }

    public final void zzb() {
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zze(this.zza, this.zzf);
    }
}
