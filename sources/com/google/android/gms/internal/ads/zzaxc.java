package com.google.android.gms.internal.ads;

import java.util.List;

public final class zzaxc {
    public final List<byte[]> zza;
    public final int zzb;
    public final float zzc;

    private zzaxc(List<byte[]> list, int i11, int i12, int i13, float f11) {
        this.zza = list;
        this.zzb = i11;
        this.zzc = f11;
    }

    /* JADX WARNING: Removed duplicated region for block: B:61:0x00e0 A[Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00e4 A[Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0118 A[Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0126 A[Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0161 A[Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0172 A[Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzaxc zza(com.google.android.gms.internal.ads.zzawu r17) throws com.google.android.gms.internal.ads.zzapj {
        /*
            r0 = 4
            r1 = r17
            r1.zzw(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            int r0 = r17.zzg()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r2 = 3
            r0 = r0 & r2
            r3 = 1
            int r6 = r0 + 1
            if (r6 == r2) goto L_0x01a2
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r5.<init>()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            int r0 = r17.zzg()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r0 = r0 & 31
            r4 = 0
            r7 = r4
        L_0x001e:
            if (r7 >= r0) goto L_0x002a
            byte[] r8 = zzb(r17)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r5.add(r8)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            int r7 = r7 + 1
            goto L_0x001e
        L_0x002a:
            int r7 = r17.zzg()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r8 = r4
        L_0x002f:
            if (r8 >= r7) goto L_0x003b
            byte[] r9 = zzb(r17)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r5.add(r9)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            int r8 = r8 + 1
            goto L_0x002f
        L_0x003b:
            r1 = 1065353216(0x3f800000, float:1.0)
            if (r0 <= 0) goto L_0x0197
            java.lang.Object r0 = r5.get(r4)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            byte[] r0 = (byte[]) r0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            java.lang.Object r7 = r5.get(r4)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            byte[] r7 = (byte[]) r7     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            int r0 = r0.length     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            com.google.android.gms.internal.ads.zzawv r8 = new com.google.android.gms.internal.ads.zzawv     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r8.<init>(r7, r6, r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r0 = 8
            r8.zzd(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            int r7 = r8.zza(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r9 = 16
            r8.zzd(r9)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r10 = 100
            if (r7 == r10) goto L_0x008d
            r10 = 110(0x6e, float:1.54E-43)
            if (r7 == r10) goto L_0x008d
            r10 = 122(0x7a, float:1.71E-43)
            if (r7 == r10) goto L_0x008d
            r10 = 244(0xf4, float:3.42E-43)
            if (r7 == r10) goto L_0x008d
            r10 = 44
            if (r7 == r10) goto L_0x008d
            r10 = 83
            if (r7 == r10) goto L_0x008d
            r10 = 86
            if (r7 == r10) goto L_0x008d
            r10 = 118(0x76, float:1.65E-43)
            if (r7 == r10) goto L_0x008d
            r10 = 128(0x80, float:1.794E-43)
            if (r7 == r10) goto L_0x008d
            r10 = 138(0x8a, float:1.93E-43)
            if (r7 != r10) goto L_0x008b
            goto L_0x008d
        L_0x008b:
            r7 = r3
            goto L_0x00d7
        L_0x008d:
            int r7 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            if (r7 != r2) goto L_0x0098
            r8.zze()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r10 = r2
            goto L_0x0099
        L_0x0098:
            r10 = r7
        L_0x0099:
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r8.zzd(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            boolean r11 = r8.zze()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            if (r11 == 0) goto L_0x00d7
            if (r10 == r2) goto L_0x00ac
            r10 = r0
            goto L_0x00ae
        L_0x00ac:
            r10 = 12
        L_0x00ae:
            r11 = r4
        L_0x00af:
            if (r11 >= r10) goto L_0x00d7
            boolean r12 = r8.zze()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            if (r12 == 0) goto L_0x00d4
            r12 = 6
            if (r11 >= r12) goto L_0x00bc
            r12 = r9
            goto L_0x00be
        L_0x00bc:
            r12 = 64
        L_0x00be:
            r14 = r0
            r15 = r14
            r13 = r4
        L_0x00c1:
            if (r13 >= r12) goto L_0x00d4
            if (r14 == 0) goto L_0x00ce
            int r14 = r8.zzb()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            int r14 = r14 + r15
            int r14 = r14 + 256
            int r14 = r14 % 256
        L_0x00ce:
            if (r14 == 0) goto L_0x00d1
            r15 = r14
        L_0x00d1:
            int r13 = r13 + 1
            goto L_0x00c1
        L_0x00d4:
            int r11 = r11 + 1
            goto L_0x00af
        L_0x00d7:
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            int r10 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            if (r10 != 0) goto L_0x00e4
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            goto L_0x00ff
        L_0x00e4:
            if (r10 != r3) goto L_0x00ff
            r8.zze()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r8.zzb()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r8.zzb()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            int r10 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            long r10 = (long) r10     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
        L_0x00f4:
            long r12 = (long) r4     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            int r12 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r12 >= 0) goto L_0x00ff
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            int r4 = r4 + 1
            goto L_0x00f4
        L_0x00ff:
            r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r8.zzd(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            int r4 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            int r4 = r4 + r3
            int r10 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            int r10 = r10 + r3
            boolean r11 = r8.zze()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            int r12 = 2 - r11
            int r10 = r10 * r12
            if (r11 != 0) goto L_0x011b
            r8.zzd(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
        L_0x011b:
            r8.zzd(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            int r4 = r4 * r9
            int r10 = r10 * r9
            boolean r11 = r8.zze()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            if (r11 == 0) goto L_0x014d
            int r11 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            int r13 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            int r14 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            int r15 = r8.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            if (r7 != 0) goto L_0x0139
            goto L_0x0147
        L_0x0139:
            r16 = 2
            if (r7 != r2) goto L_0x013f
            r2 = r3
            goto L_0x0141
        L_0x013f:
            r2 = r16
        L_0x0141:
            if (r7 != r3) goto L_0x0145
            r3 = r16
        L_0x0145:
            int r12 = r12 * r3
            r3 = r2
        L_0x0147:
            int r11 = r11 + r13
            int r11 = r11 * r3
            int r4 = r4 - r11
            int r14 = r14 + r15
            int r14 = r14 * r12
            int r10 = r10 - r14
        L_0x014d:
            boolean r2 = r8.zze()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            if (r2 == 0) goto L_0x0193
            boolean r2 = r8.zze()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            if (r2 == 0) goto L_0x0193
            int r0 = r8.zza(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r2 = 255(0xff, float:3.57E-43)
            if (r0 != r2) goto L_0x0172
            int r0 = r8.zza(r9)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            int r2 = r8.zza(r9)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            if (r0 == 0) goto L_0x0193
            if (r2 == 0) goto L_0x0193
            float r0 = (float) r0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            float r1 = (float) r2     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            float r1 = r0 / r1
            goto L_0x0193
        L_0x0172:
            r2 = 17
            if (r0 >= r2) goto L_0x017b
            float[] r1 = com.google.android.gms.internal.ads.zzaws.zzb     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r1 = r1[r0]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            goto L_0x0193
        L_0x017b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r3 = 46
            r2.<init>(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            java.lang.String r3 = "Unexpected aspect_ratio_idc value: "
            r2.append(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r2.append(r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            java.lang.String r0 = "NalUnitUtil"
            java.lang.String r2 = r2.toString()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            android.util.Log.w(r0, r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
        L_0x0193:
            r9 = r1
            r7 = r4
            r8 = r10
            goto L_0x019b
        L_0x0197:
            r0 = -1
            r7 = r0
            r8 = r7
            r9 = r1
        L_0x019b:
            com.google.android.gms.internal.ads.zzaxc r0 = new com.google.android.gms.internal.ads.zzaxc     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            return r0
        L_0x01a2:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            r0.<init>()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
            throw r0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01a8 }
        L_0x01a8:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzapj r1 = new com.google.android.gms.internal.ads.zzapj
            java.lang.String r2 = "Error parsing AVC config"
            r1.<init>(r2, r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaxc.zza(com.google.android.gms.internal.ads.zzawu):com.google.android.gms.internal.ads.zzaxc");
    }

    private static byte[] zzb(zzawu zzawu) {
        int zzj = zzawu.zzj();
        int zzc2 = zzawu.zzc();
        zzawu.zzw(zzj);
        return zzawn.zzb(zzawu.zza, zzc2, zzj);
    }
}
