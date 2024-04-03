package com.google.android.gms.internal.p002firebaseauthapi;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.firebase.auth.zze;
import java.util.List;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzxc  reason: invalid package */
final class zzxc implements zzabu {
    final /* synthetic */ zzabt zza;
    final /* synthetic */ String zzb;
    final /* synthetic */ String zzc;
    final /* synthetic */ Boolean zzd;
    final /* synthetic */ zze zze;
    final /* synthetic */ zzaan zzf;
    final /* synthetic */ zzadr zzg;

    public zzxc(zzyp zzyp, zzabt zzabt, String str, String str2, Boolean bool, zze zze2, zzaan zzaan, zzadr zzadr) {
        this.zza = zzabt;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bool;
        this.zze = zze2;
        this.zzf = zzaan;
        this.zzg = zzadr;
    }

    public final void zza(@Nullable String str) {
        this.zza.zza(str);
    }

    public final /* bridge */ /* synthetic */ void zzb(Object obj) {
        List list;
        List zzb2 = ((zzadh) obj).zzb();
        if (zzb2 == null || zzb2.isEmpty()) {
            this.zza.zza("No users.");
            return;
        }
        int i11 = 0;
        zzadi zzadi = (zzadi) zzb2.get(0);
        zzadx zzl = zzadi.zzl();
        if (zzl != null) {
            list = zzl.zzc();
        } else {
            list = null;
        }
        if (list != null && !list.isEmpty()) {
            if (!TextUtils.isEmpty(this.zzb)) {
                while (true) {
                    if (i11 >= list.size()) {
                        break;
                    } else if (((zzadw) list.get(i11)).zzf().equals(this.zzb)) {
                        ((zzadw) list.get(i11)).zzh(this.zzc);
                        break;
                    } else {
                        i11++;
                    }
                }
            } else {
                ((zzadw) list.get(0)).zzh(this.zzc);
            }
        }
        zzadi.zzh(this.zzd.booleanValue());
        zzadi.zze(this.zze);
        this.zzf.zzk(this.zzg, zzadi);
    }
}
