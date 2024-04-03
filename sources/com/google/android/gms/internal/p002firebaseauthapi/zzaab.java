package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzg;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaab  reason: invalid package */
final class zzaab extends zzabp {
    private final String zza;
    private final String zzb;
    @Nullable
    private final String zzc;

    public zzaab(String str, String str2, @Nullable String str3) {
        super(2);
        this.zza = Preconditions.checkNotEmpty(str);
        this.zzb = Preconditions.checkNotEmpty(str2);
        this.zzc = str3;
    }

    public final String zza() {
        return "unenrollMfa";
    }

    public final void zzb() {
        ((zzg) this.zzi).zza(this.zzn, zzaal.zzS(this.zzg, this.zzo));
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzE(this.zza, this.zzb, this.zzc, this.zzf);
    }
}
