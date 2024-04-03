package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.auth.internal.zzai;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzyk  reason: invalid package */
final class zzyk implements zzabu {
    final /* synthetic */ UserProfileChangeRequest zza;
    final /* synthetic */ zzaan zzb;
    final /* synthetic */ zzyp zzc;

    public zzyk(zzyp zzyp, UserProfileChangeRequest userProfileChangeRequest, zzaan zzaan) {
        this.zzc = zzyp;
        this.zza = userProfileChangeRequest;
        this.zzb = zzaan;
    }

    public final void zza(@Nullable String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzadr zzadr = (zzadr) obj;
        zzaed zzaed = new zzaed();
        zzaed.zze(zzadr.zze());
        if (this.zza.zzb() || this.zza.getDisplayName() != null) {
            zzaed.zzc(this.zza.getDisplayName());
        }
        if (this.zza.zzc() || this.zza.getPhotoUri() != null) {
            zzaed.zzh(this.zza.zza());
        }
        zzyp.zze(this.zzc, this.zzb, zzadr, zzaed, this);
    }
}
