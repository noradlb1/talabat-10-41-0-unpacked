package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.ActionCodeSettings;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzq  reason: invalid package */
final class zzzq extends zzabp {
    @NonNull
    private final zzwn zza;
    private final String zzb;

    public zzzq(String str, ActionCodeSettings actionCodeSettings, @Nullable String str2, @Nullable String str3, String str4) {
        super(4);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        this.zza = new zzwn(str, actionCodeSettings, str2, str3);
        this.zzb = str4;
    }

    public final String zza() {
        return this.zzb;
    }

    public final void zzb() {
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzs(this.zza, this.zzf);
    }
}
