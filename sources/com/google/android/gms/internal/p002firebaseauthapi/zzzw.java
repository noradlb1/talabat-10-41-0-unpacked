package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzw  reason: invalid package */
final class zzzw extends zzabp {
    private final zzwq zza;

    public zzzw(EmailAuthCredential emailAuthCredential, @Nullable String str) {
        super(2);
        Preconditions.checkNotNull(emailAuthCredential, "credential cannot be null");
        this.zza = new zzwq(emailAuthCredential, str);
    }

    public final String zza() {
        return "sendSignInLinkToEmail";
    }

    public final void zzb() {
        zzx zzS = zzaal.zzS(this.zzg, this.zzo);
        ((zzg) this.zzi).zza(this.zzn, zzS);
        zzm(new zzr(zzS));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzz(this.zza, this.zzf);
    }
}
