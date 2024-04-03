package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.api.Status;
import com.google.firebase.FirebaseError;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxl  reason: invalid package */
final class zzxl implements zzabu {
    final /* synthetic */ zzabu zza;
    final /* synthetic */ zzxm zzb;

    public zzxl(zzxm zzxm, zzabu zzabu) {
        this.zzb = zzxm;
        this.zza = zzabu;
    }

    public final void zza(@Nullable String str) {
        this.zza.zza(str);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzafa zzafa = (zzafa) obj;
        if (!TextUtils.isEmpty(zzafa.zzf())) {
            this.zzb.zzb.zzg(new Status(FirebaseError.ERROR_CREDENTIAL_ALREADY_IN_USE), PhoneAuthCredential.zzd(zzafa.zzd(), zzafa.zzf()));
            return;
        }
        this.zzb.zzc.zzQ(new zzadr(zzafa.zze(), zzafa.zzc(), Long.valueOf(zzafa.zzb()), "Bearer"), (String) null, "phone", Boolean.valueOf(zzafa.zzg()), (zze) null, this.zzb.zzb, this.zza);
    }
}
