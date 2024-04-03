package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzg;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaaf  reason: invalid package */
final class zzaaf extends zzabp {
    private final String zza;

    public zzaaf(String str) {
        super(2);
        this.zza = Preconditions.checkNotEmpty(str, "password cannot be null or empty");
    }

    public final String zza() {
        return "updatePassword";
    }

    public final void zzb() {
        ((zzg) this.zzi).zza(this.zzn, zzaal.zzS(this.zzg, this.zzo));
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzc(this.zzh.zzf(), this.zza, this.zzf);
    }
}
