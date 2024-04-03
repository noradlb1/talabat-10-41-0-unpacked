package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.internal.zzg;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaag  reason: invalid package */
final class zzaag extends zzabp {
    private final PhoneAuthCredential zza;

    public zzaag(PhoneAuthCredential phoneAuthCredential) {
        super(2);
        this.zza = (PhoneAuthCredential) Preconditions.checkNotNull(phoneAuthCredential);
    }

    public final String zza() {
        return "updatePhoneNumber";
    }

    public final void zzb() {
        ((zzg) this.zzi).zza(this.zzn, zzaal.zzS(this.zzg, this.zzo));
        zzm((Object) null);
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzp(new zzwl(this.zzh.zzf(), this.zza), this.zzf);
    }
}
