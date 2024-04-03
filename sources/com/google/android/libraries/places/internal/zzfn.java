package com.google.android.libraries.places.internal;

import com.google.firebase.analytics.FirebaseAnalytics;

final class zzfn extends zzfp {
    final /* synthetic */ zzfo zza;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzfn(zzfo zzfo, zzfq zzfq, CharSequence charSequence) {
        super(zzfq, "2.5.0");
        this.zza = zzfo;
    }

    public final int zzc(int i11) {
        return i11 + 1;
    }

    public final int zzd(int i11) {
        int length = "2.5.0".length();
        zzfm.zzb(i11, length, FirebaseAnalytics.Param.INDEX);
        while (i11 < length) {
            if ("2.5.0".charAt(i11) == '.') {
                return i11;
            }
            i11++;
        }
        return -1;
    }
}
