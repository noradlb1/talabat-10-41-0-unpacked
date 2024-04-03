package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzasx {
    private static final int[] zza = {zzaxb.zzg("isom"), zzaxb.zzg("iso2"), zzaxb.zzg("iso3"), zzaxb.zzg("iso4"), zzaxb.zzg("iso5"), zzaxb.zzg("iso6"), zzaxb.zzg("avc1"), zzaxb.zzg("hvc1"), zzaxb.zzg("hev1"), zzaxb.zzg("mp41"), zzaxb.zzg("mp42"), zzaxb.zzg("3g2a"), zzaxb.zzg("3g2b"), zzaxb.zzg("3gr6"), zzaxb.zzg("3gs6"), zzaxb.zzg("3ge6"), zzaxb.zzg("3gg6"), zzaxb.zzg("M4V "), zzaxb.zzg("M4A "), zzaxb.zzg("f4v "), zzaxb.zzg("kddi"), zzaxb.zzg("M4VP"), zzaxb.zzg("qt  "), zzaxb.zzg("MSNV")};

    public static boolean zza(zzari zzari) throws IOException, InterruptedException {
        return zzc(zzari, true);
    }

    public static boolean zzb(zzari zzari) throws IOException, InterruptedException {
        return zzc(zzari, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0094, code lost:
        r5 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zzc(com.google.android.gms.internal.ads.zzari r15, boolean r16) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r0 = r15
            long r1 = r15.zzc()
            r3 = -1
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r4 = 4096(0x1000, double:2.0237E-320)
            if (r3 == 0) goto L_0x0011
            int r3 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r3 <= 0) goto L_0x0012
        L_0x0011:
            r1 = r4
        L_0x0012:
            int r1 = (int) r1
            com.google.android.gms.internal.ads.zzawu r2 = new com.google.android.gms.internal.ads.zzawu
            r3 = 64
            r2.<init>((int) r3)
            r3 = 0
            r4 = r3
            r5 = r4
        L_0x001d:
            if (r4 >= r1) goto L_0x00b7
            r7 = 8
            r2.zzs(r7)
            byte[] r8 = r2.zza
            r15.zzg(r8, r3, r7, r3)
            long r8 = r2.zzm()
            int r10 = r2.zze()
            r11 = 1
            int r11 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r11 != 0) goto L_0x0046
            byte[] r8 = r2.zza
            r15.zzg(r8, r7, r7, r3)
            r8 = 16
            r2.zzu(r8)
            long r11 = r2.zzn()
            goto L_0x0048
        L_0x0046:
            r11 = r8
            r8 = r7
        L_0x0048:
            long r13 = (long) r8
            int r9 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r9 >= 0) goto L_0x004e
            return r3
        L_0x004e:
            int r4 = r4 + r8
            int r8 = com.google.android.gms.internal.ads.zzasg.zzE
            if (r10 == r8) goto L_0x001d
            int r8 = com.google.android.gms.internal.ads.zzasg.zzN
            if (r10 == r8) goto L_0x00b5
            int r8 = com.google.android.gms.internal.ads.zzasg.zzP
            if (r10 != r8) goto L_0x005c
            goto L_0x00b5
        L_0x005c:
            long r8 = (long) r4
            long r8 = r8 + r11
            long r8 = r8 - r13
            long r6 = (long) r1
            int r6 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r6 < 0) goto L_0x0065
            goto L_0x00b7
        L_0x0065:
            long r11 = r11 - r13
            int r6 = (int) r11
            int r4 = r4 + r6
            int r7 = com.google.android.gms.internal.ads.zzasg.zzd
            if (r10 != r7) goto L_0x00ae
            r7 = 8
            if (r6 >= r7) goto L_0x0071
            return r3
        L_0x0071:
            r2.zzs(r6)
            byte[] r7 = r2.zza
            r15.zzg(r7, r3, r6, r3)
            int r6 = r6 >> 2
            r7 = r3
        L_0x007c:
            if (r7 >= r6) goto L_0x00a9
            r8 = 1
            if (r7 != r8) goto L_0x0086
            r8 = 4
            r2.zzw(r8)
            goto L_0x00a6
        L_0x0086:
            int r8 = r2.zze()
            int r9 = r8 >>> 8
            java.lang.String r10 = "3gp"
            int r10 = com.google.android.gms.internal.ads.zzaxb.zzg(r10)
            if (r9 != r10) goto L_0x0096
        L_0x0094:
            r5 = 1
            goto L_0x00a9
        L_0x0096:
            int[] r9 = zza
            int r10 = r9.length
            r10 = r3
        L_0x009a:
            r11 = 24
            if (r10 >= r11) goto L_0x00a6
            r11 = r9[r10]
            if (r11 != r8) goto L_0x00a3
            goto L_0x0094
        L_0x00a3:
            int r10 = r10 + 1
            goto L_0x009a
        L_0x00a6:
            int r7 = r7 + 1
            goto L_0x007c
        L_0x00a9:
            if (r5 == 0) goto L_0x00ad
            goto L_0x001d
        L_0x00ad:
            return r3
        L_0x00ae:
            if (r6 == 0) goto L_0x001d
            r15.zzf(r6, r3)
            goto L_0x001d
        L_0x00b5:
            r8 = 1
            goto L_0x00b8
        L_0x00b7:
            r8 = r3
        L_0x00b8:
            if (r5 == 0) goto L_0x00c0
            r0 = r16
            if (r0 != r8) goto L_0x00c0
            r0 = 1
            return r0
        L_0x00c0:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasx.zzc(com.google.android.gms.internal.ads.zzari, boolean):boolean");
    }
}
