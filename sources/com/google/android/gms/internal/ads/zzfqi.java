package com.google.android.gms.internal.ads;

import com.google.firebase.analytics.FirebaseAnalytics;

final class zzfqi extends zzfqn {
    final /* synthetic */ zzfqj zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfqi(zzfqj zzfqj, zzfqp zzfqp, CharSequence charSequence) {
        super(zzfqp, charSequence);
        this.zza = zzfqj;
    }

    public final int zzc(int i11) {
        return i11 + 1;
    }

    public final int zzd(int i11) {
        zzfps zzfps = this.zza.zza;
        CharSequence charSequence = this.zzb;
        int length = charSequence.length();
        zzfqg.zzb(i11, length, FirebaseAnalytics.Param.INDEX);
        while (i11 < length) {
            if (zzfps.zza(charSequence.charAt(i11))) {
                return i11;
            }
            i11++;
        }
        return -1;
    }
}
