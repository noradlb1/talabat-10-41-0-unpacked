package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzh;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzt  reason: invalid package */
final class zzzt extends zzabp {
    private final zzaes zza;

    public zzzt(AuthCredential authCredential, @Nullable String str) {
        super(2);
        Preconditions.checkNotNull(authCredential, "credential cannot be null");
        this.zza = zzh.zza(authCredential, str);
    }

    public final String zza() {
        return "signInWithCredential";
    }

    public final void zzb() {
        zzx zzS = zzaal.zzS(this.zzg, this.zzo);
        ((zzg) this.zzi).zza(this.zzn, zzS);
        zzm(new zzr(zzS));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzw(this.zza, this.zzf);
    }
}
