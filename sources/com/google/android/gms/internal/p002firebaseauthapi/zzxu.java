package com.google.android.gms.internal.p002firebaseauthapi;

import androidx.annotation.Nullable;
import com.google.firebase.auth.internal.zzai;
import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxu  reason: invalid package */
final class zzxu implements zzabu {
    final /* synthetic */ zzaeh zza;
    final /* synthetic */ zzaan zzb;

    public zzxu(zzyp zzyp, zzaeh zzaeh, zzaan zzaan) {
        this.zza = zzaeh;
        this.zzb = zzaan;
    }

    public final void zza(@Nullable String str) {
        this.zzb.zzh(zzai.zza(str));
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaei zzaei = (zzaei) obj;
        zzaeh zzaeh = this.zza;
        if (zzaeh instanceof zzael) {
            this.zzb.zzb(zzaei.zzc());
        } else if (zzaeh instanceof zzaen) {
            this.zzb.zzp(zzaei);
        } else {
            String name2 = zzaeh.getClass().getName();
            throw new IllegalArgumentException("startMfaEnrollmentRequest must be an instance of either StartPhoneMfaEnrollmentRequest or StartTotpMfaEnrollmentRequest but was " + name2 + RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
        }
    }
}
