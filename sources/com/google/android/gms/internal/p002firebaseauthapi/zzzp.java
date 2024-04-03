package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeSettings;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzp  reason: invalid package */
final class zzzp extends zzabp {
    @NonNull
    private final zzwm zza;

    public zzzp(String str, @Nullable ActionCodeSettings actionCodeSettings) {
        super(6);
        Preconditions.checkNotEmpty(str, "token cannot be null or empty");
        this.zza = new zzwm(str, actionCodeSettings);
    }

    public final String zza() {
        return "sendEmailVerification";
    }

    public final void zzb() {
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzr(this.zza, this.zzf);
    }
}
