package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.firebase.auth.internal.zzg;
import com.google.firebase.auth.internal.zzr;
import com.google.firebase.auth.internal.zzx;

@VisibleForTesting
/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzzv  reason: invalid package */
final class zzzv extends zzabp {
    @NonNull
    final String zza;
    @NonNull
    final String zzb;
    @Nullable
    final String zzc;
    @Nullable
    final String zzd;

    public zzzv(String str, String str2, @Nullable String str3, @Nullable String str4) {
        super(2);
        Preconditions.checkNotEmpty(str, "email cannot be null or empty");
        Preconditions.checkNotEmpty(str2, "password cannot be null or empty");
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
    }

    public final String zza() {
        return "signInWithEmailAndPassword";
    }

    public final void zzb() {
        zzx zzS = zzaal.zzS(this.zzg, this.zzo);
        ((zzg) this.zzi).zza(this.zzn, zzS);
        zzm(new zzr(zzS));
    }

    public final void zzc(TaskCompletionSource taskCompletionSource, zzaao zzaao) {
        this.zzk = new zzabo(this, taskCompletionSource);
        zzaao.zzy(this.zza, this.zzb, this.zzc, this.zzd, this.zzf);
    }
}
