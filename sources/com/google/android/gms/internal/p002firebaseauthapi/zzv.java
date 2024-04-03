package com.google.android.gms.internal.p002firebaseauthapi;

import com.google.firebase.analytics.FirebaseAnalytics;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzv  reason: invalid package */
final class zzv extends zzz {
    final /* synthetic */ zzw zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzv(zzw zzw, zzab zzab, CharSequence charSequence) {
        super(zzab, charSequence);
        this.zza = zzw;
    }

    public final int zzc(int i11) {
        return i11 + 1;
    }

    public final int zzd(int i11) {
        zzj zzj = this.zza.zza;
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzu.zzb(i11, length, FirebaseAnalytics.Param.INDEX);
        while (i11 < length) {
            if (zzj.zza(charSequence.charAt(i11))) {
                return i11;
            }
            i11++;
        }
        return -1;
    }
}
