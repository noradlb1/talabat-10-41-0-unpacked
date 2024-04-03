package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxb  reason: invalid package */
final class zzxb implements zzabu {
    final /* synthetic */ zzaed zza;
    final /* synthetic */ zzadi zzb;
    final /* synthetic */ zzaan zzc;
    final /* synthetic */ zzadr zzd;
    final /* synthetic */ zzabt zze;
    final /* synthetic */ zzyp zzf;

    public zzxb(zzyp zzyp, zzaed zzaed, zzadi zzadi, zzaan zzaan, zzadr zzadr, zzabt zzabt) {
        this.zzf = zzyp;
        this.zza = zzaed;
        this.zzb = zzadi;
        this.zzc = zzaan;
        this.zzd = zzadr;
        this.zze = zzabt;
    }

    public final void zza(@Nullable String str) {
        this.zze.zza(str);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        zzaee zzaee = (zzaee) obj;
        if (this.zza.zzn("EMAIL")) {
            this.zzb.zzg((String) null);
        } else {
            zzaed zzaed = this.zza;
            if (zzaed.zzk() != null) {
                this.zzb.zzg(zzaed.zzk());
            }
        }
        if (this.zza.zzn("DISPLAY_NAME")) {
            this.zzb.zzf((String) null);
        } else {
            zzaed zzaed2 = this.zza;
            if (zzaed2.zzj() != null) {
                this.zzb.zzf(zzaed2.zzj());
            }
        }
        if (this.zza.zzn("PHOTO_URL")) {
            this.zzb.zzj((String) null);
        } else {
            zzaed zzaed3 = this.zza;
            if (zzaed3.zzm() != null) {
                this.zzb.zzj(zzaed3.zzm());
            }
        }
        if (!TextUtils.isEmpty(this.zza.zzl())) {
            this.zzb.zzi(Base64Utils.encode("redacted".getBytes()));
        }
        List zzf2 = zzaee.zzf();
        if (zzf2 == null) {
            zzf2 = new ArrayList();
        }
        this.zzb.zzk(zzf2);
        zzaan zzaan = this.zzc;
        zzadr zzadr = this.zzd;
        Preconditions.checkNotNull(zzadr);
        Preconditions.checkNotNull(zzaee);
        String zzd2 = zzaee.zzd();
        String zze2 = zzaee.zze();
        if (!TextUtils.isEmpty(zzd2) && !TextUtils.isEmpty(zze2)) {
            zzadr = new zzadr(zze2, zzd2, Long.valueOf(zzaee.zzb()), zzadr.zzg());
        }
        zzaan.zzk(zzadr, this.zzb);
    }
}
