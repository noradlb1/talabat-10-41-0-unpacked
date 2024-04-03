package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzf  reason: invalid package */
final class zzzf extends zzabp {
    private final EmailAuthCredential zza;

    public zzzf(EmailAuthCredential emailAuthCredential) {
        super(2);
        this.zza = (EmailAuthCredential) Preconditions.checkNotNull(emailAuthCredential, "credential cannot be null");
    }

    public final String zza() {
        return "linkEmailAuthCredential";
    }

    public final void zzb() {
        zzx zzS = zzaal.zzS(this.zzg, this.zzo);
        ((zzg) this.zzi).zza(this.zzn, zzS);
        zzm(new zzr(zzS));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        EmailAuthCredential emailAuthCredential = this.zza;
        emailAuthCredential.zzb(this.zzh);
        zzaao.zzz(new zzwq(emailAuthCredential, (String) null), this.zzf);
    }
}
