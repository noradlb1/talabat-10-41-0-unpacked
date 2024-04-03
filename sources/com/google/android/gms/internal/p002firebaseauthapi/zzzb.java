package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzb  reason: invalid package */
final class zzzb extends zzabp {
    private final zzwk zza;

    public zzzb(@Nullable String str, String str2) {
        super(10);
        Preconditions.checkNotEmpty("RECAPTCHA_ENTERPRISE");
        this.zza = new zzwk(str, "RECAPTCHA_ENTERPRISE");
    }

    public final String zza() {
        return "getRecaptchaConfig";
    }

    public final void zzb() {
        zzm(this.zzx);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzm(this.zza, this.zzf);
    }
}
