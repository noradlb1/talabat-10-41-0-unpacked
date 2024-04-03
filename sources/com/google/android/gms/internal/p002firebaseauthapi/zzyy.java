package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorAssertion;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyy  reason: invalid package */
final class zzyy extends zzabp {
    private final MultiFactorAssertion zza;
    private final String zzb;
    @Nullable
    private final String zzc;

    public zzyy(MultiFactorAssertion multiFactorAssertion, String str, @Nullable String str2) {
        super(2);
        this.zza = (MultiFactorAssertion) Preconditions.checkNotNull(multiFactorAssertion);
        this.zzb = Preconditions.checkNotEmpty(str);
        this.zzc = str2;
    }

    public final String zza() {
        return "finalizeMfaSignIn";
    }

    public final void zzb() {
        zzx zzS = zzaal.zzS(this.zzg, this.zzo);
        FirebaseUser firebaseUser = this.zzh;
        if (firebaseUser == null || firebaseUser.getUid().equalsIgnoreCase(zzS.getUid())) {
            ((zzg) this.zzi).zza(this.zzn, zzS);
            zzm(new zzr(zzS));
            return;
        }
        zzl(new Status(FirebaseError.ERROR_USER_MISMATCH));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzi(this.zzb, this.zza, this.zzc, this.zzf);
    }
}
