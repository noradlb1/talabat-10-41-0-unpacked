package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzacj {
    private static final int[] zza = {1769172845, 1769172786, 1769172787, 1769172788, 1769172789, 1769172790, 1769172793, Atom.TYPE_avc1, Atom.TYPE_hvc1, Atom.TYPE_hev1, Atom.TYPE_av01, 1836069937, 1836069938, 862401121, 862401122, 862417462, 862417718, 862414134, 862414646, 1295275552, 1295270176, 1714714144, 1801741417, 1295275600, Sniffer.BRAND_QUICKTIME, 1297305174, 1684175153, 1769172332, 1885955686};

    public static boolean zza(zzwq zzwq) throws IOException {
        return zzc(zzwq, true, false);
    }

    public static boolean zzb(zzwq zzwq, boolean z11) throws IOException {
        return zzc(zzwq, false, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00d3, code lost:
        r10 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x00fe, code lost:
        r4 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zzc(com.google.android.gms.internal.ads.zzwq r20, boolean r21, boolean r22) throws java.io.IOException {
        /*
            r0 = r20
            long r1 = r20.zzc()
            r3 = -1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r6 = 4096(0x1000, double:2.0237E-320)
            if (r5 == 0) goto L_0x0014
            int r8 = (r1 > r6 ? 1 : (r1 == r6 ? 0 : -1))
            if (r8 <= 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r6 = r1
        L_0x0014:
            int r6 = (int) r6
            com.google.android.gms.internal.ads.zzfd r7 = new com.google.android.gms.internal.ads.zzfd
            r8 = 64
            r7.<init>((int) r8)
            r8 = 0
            r9 = r8
            r10 = r9
        L_0x001f:
            r11 = 1
            if (r9 >= r6) goto L_0x00fe
            r12 = 8
            r7.zzC(r12)
            byte[] r13 = r7.zzH()
            boolean r13 = r0.zzm(r13, r8, r12, r11)
            if (r13 != 0) goto L_0x0034
            r4 = r8
            goto L_0x00ff
        L_0x0034:
            long r13 = r7.zzs()
            int r15 = r7.zze()
            r16 = 1
            int r16 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r16 != 0) goto L_0x0055
            byte[] r13 = r7.zzH()
            r0.zzh(r13, r12, r12)
            r13 = 16
            r7.zzE(r13)
            long r16 = r7.zzr()
            r3 = r16
            goto L_0x006f
        L_0x0055:
            r16 = 0
            int r16 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r16 != 0) goto L_0x006d
            long r16 = r20.zzc()
            int r18 = (r16 > r3 ? 1 : (r16 == r3 ? 0 : -1))
            if (r18 == 0) goto L_0x006d
            long r13 = r20.zzd()
            long r16 = r16 - r13
            r13 = 8
            long r13 = r16 + r13
        L_0x006d:
            r3 = r13
            r13 = r12
        L_0x006f:
            long r11 = (long) r13
            int r18 = (r3 > r11 ? 1 : (r3 == r11 ? 0 : -1))
            if (r18 >= 0) goto L_0x0075
            return r8
        L_0x0075:
            int r9 = r9 + r13
            r13 = 1836019574(0x6d6f6f76, float:4.631354E27)
            if (r15 != r13) goto L_0x0088
            int r3 = (int) r3
            int r6 = r6 + r3
            if (r5 == 0) goto L_0x0085
            long r3 = (long) r6
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0085
            int r6 = (int) r1
        L_0x0085:
            r3 = -1
            goto L_0x001f
        L_0x0088:
            r13 = 1836019558(0x6d6f6f66, float:4.6313494E27)
            if (r15 == r13) goto L_0x00fc
            r13 = 1836475768(0x6d766578, float:4.7659988E27)
            if (r15 != r13) goto L_0x0094
            goto L_0x00fc
        L_0x0094:
            r13 = r15
            long r14 = (long) r9
            long r14 = r14 + r3
            long r14 = r14 - r11
            r19 = r9
            long r8 = (long) r6
            int r8 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r8 < 0) goto L_0x00a0
            goto L_0x00fe
        L_0x00a0:
            long r3 = r3 - r11
            int r3 = (int) r3
            int r9 = r19 + r3
            r4 = 1718909296(0x66747970, float:2.8862439E23)
            r8 = r13
            if (r8 != r4) goto L_0x00f2
            r4 = 8
            if (r3 >= r4) goto L_0x00b0
            r4 = 0
            return r4
        L_0x00b0:
            r4 = 0
            r7.zzC(r3)
            byte[] r8 = r7.zzH()
            r0.zzh(r8, r4, r3)
            int r3 = r3 >> 2
            r4 = 0
        L_0x00be:
            if (r4 >= r3) goto L_0x00ed
            r8 = 1
            if (r4 != r8) goto L_0x00c8
            r8 = 4
            r7.zzG(r8)
            goto L_0x00ea
        L_0x00c8:
            int r8 = r7.zze()
            int r11 = r8 >>> 8
            r12 = 3368816(0x336770, float:4.720717E-39)
            if (r11 != r12) goto L_0x00d5
        L_0x00d3:
            r10 = 1
            goto L_0x00ed
        L_0x00d5:
            r11 = 1751476579(0x68656963, float:4.333464E24)
            if (r8 != r11) goto L_0x00db
            r8 = r11
        L_0x00db:
            int[] r11 = zza
            r12 = 0
        L_0x00de:
            r13 = 29
            if (r12 >= r13) goto L_0x00ea
            r13 = r11[r12]
            if (r13 != r8) goto L_0x00e7
            goto L_0x00d3
        L_0x00e7:
            int r12 = r12 + 1
            goto L_0x00de
        L_0x00ea:
            int r4 = r4 + 1
            goto L_0x00be
        L_0x00ed:
            if (r10 == 0) goto L_0x00f0
            goto L_0x00f7
        L_0x00f0:
            r3 = 0
            return r3
        L_0x00f2:
            if (r3 == 0) goto L_0x00f7
            r0.zzf(r3)
        L_0x00f7:
            r3 = -1
            r8 = 0
            goto L_0x001f
        L_0x00fc:
            r4 = 1
            goto L_0x00ff
        L_0x00fe:
            r4 = 0
        L_0x00ff:
            if (r10 == 0) goto L_0x0107
            r0 = r21
            if (r0 != r4) goto L_0x0107
            r0 = 1
            return r0
        L_0x0107:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacj.zzc(com.google.android.gms.internal.ads.zzwq, boolean, boolean):boolean");
    }
}
