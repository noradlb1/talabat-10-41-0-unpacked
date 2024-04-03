package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.Comparator;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzafn  reason: invalid package */
final class zzafn implements Comparator {
    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzafv zzafv = (zzafv) obj;
        zzafv zzafv2 = (zzafv) obj2;
        zzafm zzafm = new zzafm(zzafv);
        zzafm zzafm2 = new zzafm(zzafv2);
        while (zzafm.hasNext() && zzafm2.hasNext()) {
            int compareTo = Integer.valueOf(zzafm.zza() & 255).compareTo(Integer.valueOf(zzafm2.zza() & 255));
            if (compareTo != 0) {
                return compareTo;
            }
        }
        return Integer.valueOf(zzafv.zzd()).compareTo(Integer.valueOf(zzafv2.zzd()));
    }
}
