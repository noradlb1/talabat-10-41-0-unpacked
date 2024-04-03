package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzu  reason: invalid package */
final class zzzu extends zzabp {
    private final zzaev zza;

    public zzzu(String str, @Nullable String str2) {
        super(2);
        Preconditions.checkNotEmpty(str, "token cannot be null or empty");
        this.zza = new zzaev(str, str2);
    }

    public final String zza() {
        return "signInWithCustomToken";
    }

    public final void zzb() {
        zzx zzS = zzaal.zzS(this.zzg, this.zzo);
        ((zzg) this.zzi).zza(this.zzn, zzS);
        zzm(new zzr(zzS));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzx(this.zza, this.zzf);
    }
}
