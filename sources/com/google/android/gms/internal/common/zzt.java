package com.google.android.gms.internal.common;

import com.google.firebase.analytics.FirebaseAnalytics;

final class zzt extends zzw {
    final /* synthetic */ zzu zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzt(zzu zzu, zzx zzx, CharSequence charSequence) {
        super(zzx, charSequence);
        this.zza = zzu;
    }

    public final int zzc(int i11) {
        return i11 + 1;
    }

    public final int zzd(int i11) {
        zzo zzo = this.zza.zza;
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzs.zzb(i11, length, FirebaseAnalytics.Param.INDEX);
        while (i11 < length) {
            if (zzo.zza(charSequence.charAt(i11))) {
                return i11;
            }
            i11++;
        }
        return -1;
    }
}
