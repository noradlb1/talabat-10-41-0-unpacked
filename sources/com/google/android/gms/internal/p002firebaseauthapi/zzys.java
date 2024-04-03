package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzo;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzys  reason: invalid package */
final class zzys extends zzabp {
    private final String zza;
    @Nullable
    private final String zzb;

    public zzys(String str, @Nullable String str2) {
        super(4);
        Preconditions.checkNotEmpty(str, "code cannot be null or empty");
        this.zza = str;
        this.zzb = str2;
    }

    public final String zza() {
        return "checkActionCode";
    }

    public final void zzb() {
        zzm(new zzo(this.zzq));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzd(this.zza, this.zzb, this.zzf);
    }
}
