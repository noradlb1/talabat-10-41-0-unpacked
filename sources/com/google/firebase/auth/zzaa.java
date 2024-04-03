package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.zzbl;

final class zzaa extends zzbl {
    final /* synthetic */ boolean zza;
    final /* synthetic */ FirebaseUser zzb;
    final /* synthetic */ EmailAuthCredential zzc;
    final /* synthetic */ FirebaseAuth zzd;

    public zzaa(FirebaseAuth firebaseAuth, boolean z11, FirebaseUser firebaseUser, EmailAuthCredential emailAuthCredential) {
        this.zzd = firebaseAuth;
        this.zza = z11;
        this.zzb = firebaseUser;
        this.zzc = emailAuthCredential;
    }

    public final Task zza(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            Log.i("FirebaseAuth", "Email link login/reauth with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for login/reauth with email link");
        }
        if (this.zza) {
            FirebaseAuth firebaseAuth = this.zzd;
            return firebaseAuth.zzf.zzr(firebaseAuth.zzb, (FirebaseUser) Preconditions.checkNotNull(this.zzb), this.zzc, str, new zzad(this.zzd));
        }
        FirebaseAuth firebaseAuth2 = this.zzd;
        return firebaseAuth2.zzf.zzF(firebaseAuth2.zzb, this.zzc, str, new zzac(firebaseAuth2));
    }
}
