package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;
import com.google.firebase.auth.zze;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxs  reason: invalid package */
final class zzxs implements zzabu {
    final /* synthetic */ zzxt zza;

    public zzxs(zzxt zzxt) {
        this.zza = zzxt;
    }

    public final void zza(@Nullable String str) {
        this.zza.zzc.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzafc zzafc = (zzafc) obj;
        if (TextUtils.isEmpty(zzafc.zzb()) || TextUtils.isEmpty(zzafc.zzc())) {
            this.zza.zzc.zzh(zzai.zza("INTERNAL_SUCCESS_SIGN_OUT"));
            return;
        }
        zzadr zzadr = new zzadr(zzafc.zzc(), zzafc.zzb(), Long.valueOf(zzadt.zza(zzafc.zzb())), "Bearer");
        zzxt zzxt = this.zza;
        zzxt.zzd.zzQ(zzadr, (String) null, (String) null, Boolean.FALSE, (zze) null, zzxt.zzc, this);
    }
}
