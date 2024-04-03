package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.EmailAuthCredential;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzx;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzi  reason: invalid package */
final class zzzi extends zzabp {
    private final zzwq zza;

    public zzzi(EmailAuthCredential emailAuthCredential, @Nullable String str) {
        super(2);
        Preconditions.checkNotNull(emailAuthCredential, "Credential cannot be null");
        this.zza = new zzwq(emailAuthCredential, str);
    }

    public final String zza() {
        return "reauthenticateWithEmailLink";
    }

    public final void zzb() {
        zzx zzS = zzaal.zzS(this.zzg, this.zzo);
        if (this.zzh.getUid().equalsIgnoreCase(zzS.getUid())) {
            ((zzg) this.zzi).zza(this.zzn, zzS);
            zzm((Object) null);
            return;
        }
        zzl(new Status(FirebaseError.ERROR_USER_MISMATCH));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzz(this.zza, this.zzf);
    }
}
