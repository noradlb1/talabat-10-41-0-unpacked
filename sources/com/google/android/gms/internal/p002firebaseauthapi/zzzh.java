package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzh;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzh  reason: invalid package */
final class zzzh extends zzabp {
    private final zzaes zza;

    public zzzh(AuthCredential authCredential, @Nullable String str) {
        super(2);
        Preconditions.checkNotNull(authCredential, "credential cannot be null");
        zzaes zza2 = zzh.zza(authCredential, str);
        zza2.zzb(false);
        this.zza = zza2;
    }

    public final String zza() {
        return "reauthenticateWithCredentialWithData";
    }

    public final void zzb() {
        zzx zzS = zzaal.zzS(this.zzg, this.zzo);
        if (this.zzh.getUid().equalsIgnoreCase(zzS.getUid())) {
            ((zzg) this.zzi).zza(this.zzn, zzS);
            zzm(new zzr(zzS));
            return;
        }
        zzl(new Status(FirebaseError.ERROR_USER_MISMATCH));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzw(this.zza, this.zzf);
    }
}
