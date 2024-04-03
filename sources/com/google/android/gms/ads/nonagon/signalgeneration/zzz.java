package com.google.android.gms.ads.nonagon.signalgeneration;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public final class zzz {
    private final String zza;

    public /* synthetic */ zzz(zzx zzx, zzy zzy) {
        this.zza = zzx.zza;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzbbg zza() {
        /*
            r5 = this;
            java.lang.String r0 = r5.zza
            int r1 = r0.hashCode()
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r1) {
                case -1999289321: goto L_0x002b;
                case -1372958932: goto L_0x0021;
                case 543046670: goto L_0x0017;
                case 1951953708: goto L_0x000d;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0035
        L_0x000d:
            java.lang.String r1 = "BANNER"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0035
            r0 = 0
            goto L_0x0036
        L_0x0017:
            java.lang.String r1 = "REWARDED"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0035
            r0 = r2
            goto L_0x0036
        L_0x0021:
            java.lang.String r1 = "INTERSTITIAL"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0035
            r0 = r4
            goto L_0x0036
        L_0x002b:
            java.lang.String r1 = "NATIVE"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0035
            r0 = r3
            goto L_0x0036
        L_0x0035:
            r0 = -1
        L_0x0036:
            if (r0 == 0) goto L_0x004a
            if (r0 == r4) goto L_0x0047
            if (r0 == r3) goto L_0x0044
            if (r0 == r2) goto L_0x0041
            com.google.android.gms.internal.ads.zzbbg r0 = com.google.android.gms.internal.ads.zzbbg.AD_INITIATER_UNSPECIFIED
            return r0
        L_0x0041:
            com.google.android.gms.internal.ads.zzbbg r0 = com.google.android.gms.internal.ads.zzbbg.REWARD_BASED_VIDEO_AD
            return r0
        L_0x0044:
            com.google.android.gms.internal.ads.zzbbg r0 = com.google.android.gms.internal.ads.zzbbg.AD_LOADER
            return r0
        L_0x0047:
            com.google.android.gms.internal.ads.zzbbg r0 = com.google.android.gms.internal.ads.zzbbg.INTERSTITIAL
            return r0
        L_0x004a:
            com.google.android.gms.internal.ads.zzbbg r0 = com.google.android.gms.internal.ads.zzbbg.BANNER
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.nonagon.signalgeneration.zzz.zza():com.google.android.gms.internal.ads.zzbbg");
    }

    public final String zzb() {
        return this.zza.toLowerCase(Locale.ROOT);
    }

    public final Set<String> zzc() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.zza.toLowerCase(Locale.ROOT));
        return hashSet;
    }
}
