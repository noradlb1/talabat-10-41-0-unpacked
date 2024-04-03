package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.internal.zzg;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyx  reason: invalid package */
final class zzyx extends zzabp {
    private final MultiFactorAssertion zza;
    private final String zzb;
    @Nullable
    private final String zzc;
    @Nullable
    private final String zzd;

    public zzyx(MultiFactorAssertion multiFactorAssertion, String str, @Nullable String str2, @Nullable String str3) {
        super(2);
        this.zza = (MultiFactorAssertion) Preconditions.checkNotNull(multiFactorAssertion);
        this.zzb = Preconditions.checkNotEmpty(str);
        this.zzc = str2;
        this.zzd = str3;
    }

    public final String zza() {
        return "finalizeMfaEnrollment";
    }

    public final void zzb() {
        ((zzg) this.zzi).zza(this.zzn, zzaal.zzS(this.zzg, this.zzo));
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzh(this.zza, this.zzb, this.zzc, this.zzd, this.zzf);
    }
}
