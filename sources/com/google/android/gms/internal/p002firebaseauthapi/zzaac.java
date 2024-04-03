package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaac  reason: invalid package */
final class zzaac extends zzabp {
    public zzaac() {
        super(2);
    }

    public final String zza() {
        return "unlinkEmailCredential";
    }

    public final void zzb() {
        zzx zzS = zzaal.zzS(this.zzg, this.zzo);
        ((zzg) this.zzi).zza(this.zzn, zzS);
        zzm(new zzr(zzS));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzF(this.zzh.zzf(), this.zzf);
    }
}
