package com.google.firebase.auth;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.internal.zzbl;

final class zzo extends zzbl {
    final /* synthetic */ String zza;
    final /* synthetic */ ActionCodeSettings zzb;
    final /* synthetic */ FirebaseAuth zzc;

    public zzo(FirebaseAuth firebaseAuth, String str, ActionCodeSettings actionCodeSettings) {
        this.zzc = firebaseAuth;
        this.zza = str;
        this.zzb = actionCodeSettings;
    }

    public final Task zza(@Nullable String str) {
        if (TextUtils.isEmpty(str)) {
            String str2 = this.zza;
            Log.i("FirebaseAuth", "Password reset request " + str2 + " with empty reCAPTCHA token");
        } else {
            Log.i("FirebaseAuth", "Got reCAPTCHA token for password reset of email ".concat(String.valueOf(this.zza)));
        }
        FirebaseAuth firebaseAuth = this.zzc;
        return firebaseAuth.zzf.zzy(firebaseAuth.zzb, this.zza, this.zzb, firebaseAuth.zzl, str);
    }
}
