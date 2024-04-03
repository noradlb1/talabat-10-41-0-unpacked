package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.util.List;

public final class zzxg {
    public final List<byte[]> zza;
    public final int zzb;
    public final float zzc;
    @Nullable
    public final String zzd;

    private zzxg(List<byte[]> list, int i11, int i12, int i13, float f11, @Nullable String str) {
        this.zza = list;
        this.zzb = i11;
        this.zzc = f11;
        this.zzd = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:134:0x0296 A[Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }] */
    /* JADX WARNING: Removed duplicated region for block: B:137:0x029f A[Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x02b4 A[Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02c3 A[Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0120 A[Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0122 A[Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzxg zza(com.google.android.gms.internal.ads.zzfd r30) throws com.google.android.gms.internal.ads.zzbj {
        /*
            r0 = r30
            r1 = 21
            r0.zzG(r1)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            int r1 = r30.zzk()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r2 = 3
            r1 = r1 & r2
            int r3 = r30.zzk()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            int r4 = r30.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r5 = 0
            r6 = r5
            r7 = r6
        L_0x0018:
            r8 = 1
            if (r6 >= r3) goto L_0x0035
            r0.zzG(r8)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            int r8 = r30.zzo()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r9 = r5
        L_0x0023:
            if (r9 >= r8) goto L_0x0032
            int r10 = r30.zzo()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            int r11 = r10 + 4
            int r7 = r7 + r11
            r0.zzG(r10)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            int r9 = r9 + 1
            goto L_0x0023
        L_0x0032:
            int r6 = r6 + 1
            goto L_0x0018
        L_0x0035:
            r0.zzF(r4)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            byte[] r4 = new byte[r7]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r6 = -1
            r10 = 0
            r14 = r6
            r15 = r14
            r17 = r10
            r16 = 1065353216(0x3f800000, float:1.0)
            r6 = r5
            r10 = r6
        L_0x0044:
            if (r6 >= r3) goto L_0x02f0
            int r11 = r30.zzk()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r11 = r11 & 127(0x7f, float:1.78E-43)
            int r12 = r30.zzo()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r13 = r5
        L_0x0051:
            if (r13 >= r12) goto L_0x02e7
            int r9 = r30.zzo()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            byte[] r8 = com.google.android.gms.internal.ads.zzeu.zza     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r2 = 4
            java.lang.System.arraycopy(r8, r5, r4, r10, r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            int r10 = r10 + 4
            byte[] r8 = r30.zzH()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            int r5 = r30.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            java.lang.System.arraycopy(r8, r5, r4, r10, r9)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r5 = 33
            if (r11 != r5) goto L_0x02d4
            if (r13 != 0) goto L_0x02d4
            int r5 = r10 + r9
            int r8 = r10 + 2
            com.google.android.gms.internal.ads.zzfe r13 = new com.google.android.gms.internal.ads.zzfe     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r13.<init>(r4, r8, r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r13.zze(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r5 = 3
            int r8 = r13.zza(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r13.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r5 = 2
            int r18 = r13.zza(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            boolean r19 = r13.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r14 = 5
            int r20 = r13.zza(r14)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r15 = 0
            r21 = 0
        L_0x0095:
            r14 = 32
            if (r15 >= r14) goto L_0x00a7
            boolean r14 = r13.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            if (r14 == 0) goto L_0x00a4
            r14 = 1
            int r17 = r14 << r15
            r21 = r21 | r17
        L_0x00a4:
            int r15 = r15 + 1
            goto L_0x0095
        L_0x00a7:
            r14 = 6
            int[] r15 = new int[r14]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r2 = 0
        L_0x00ab:
            r5 = 8
            if (r2 >= r14) goto L_0x00b8
            int r5 = r13.zza(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r15[r2] = r5     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            int r2 = r2 + 1
            goto L_0x00ab
        L_0x00b8:
            int r23 = r13.zza(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r2 = 0
            r5 = 0
        L_0x00be:
            if (r2 >= r8) goto L_0x00d3
            boolean r24 = r13.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            if (r24 == 0) goto L_0x00c8
            int r5 = r5 + 89
        L_0x00c8:
            boolean r24 = r13.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            if (r24 == 0) goto L_0x00d0
            int r5 = r5 + 8
        L_0x00d0:
            int r2 = r2 + 1
            goto L_0x00be
        L_0x00d3:
            r13.zze(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            if (r8 <= 0) goto L_0x00de
            int r2 = 8 - r8
            int r2 = r2 + r2
            r13.zze(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
        L_0x00de:
            r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            int r5 = r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r2 = 3
            if (r5 != r2) goto L_0x00ec
            r13.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r5 = 3
        L_0x00ec:
            int r2 = r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            int r24 = r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            boolean r25 = r13.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            if (r25 == 0) goto L_0x012f
            int r25 = r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            int r26 = r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            int r27 = r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            int r28 = r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r14 = 1
            if (r5 == r14) goto L_0x011a
            r14 = 2
            if (r5 != r14) goto L_0x0115
            r29 = r3
            r3 = 1
            r5 = 2
            goto L_0x011d
        L_0x0115:
            r29 = r3
            r3 = 1
            r14 = 1
            goto L_0x011e
        L_0x011a:
            r29 = r3
            r3 = r14
        L_0x011d:
            r14 = 2
        L_0x011e:
            if (r5 != r3) goto L_0x0122
            r3 = 2
            goto L_0x0123
        L_0x0122:
            r3 = 1
        L_0x0123:
            int r25 = r25 + r26
            int r14 = r14 * r25
            int r2 = r2 - r14
            int r27 = r27 + r28
            int r3 = r3 * r27
            int r24 = r24 - r3
            goto L_0x0131
        L_0x012f:
            r29 = r3
        L_0x0131:
            r14 = r2
            r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            int r2 = r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            boolean r3 = r13.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r5 = 1
            if (r5 == r3) goto L_0x0145
            r3 = r8
            goto L_0x0146
        L_0x0145:
            r3 = 0
        L_0x0146:
            if (r3 > r8) goto L_0x0154
            r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            int r3 = r3 + 1
            goto L_0x0146
        L_0x0154:
            r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            boolean r3 = r13.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            if (r3 == 0) goto L_0x01b6
            boolean r3 = r13.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            if (r3 == 0) goto L_0x01b6
            r3 = 0
        L_0x0173:
            r5 = 4
            if (r3 >= r5) goto L_0x01b6
            r5 = 0
        L_0x0177:
            r8 = 6
            if (r5 >= r8) goto L_0x01b0
            boolean r25 = r13.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            if (r25 != 0) goto L_0x0187
            r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r26 = r11
        L_0x0185:
            r8 = 3
            goto L_0x01a7
        L_0x0187:
            int r25 = r3 + r3
            r22 = 4
            int r25 = r25 + 4
            r26 = r11
            r8 = 1
            int r11 = r8 << r25
            r8 = 64
            int r8 = java.lang.Math.min(r8, r11)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r11 = 1
            if (r3 <= r11) goto L_0x019e
            r13.zzb()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
        L_0x019e:
            r11 = 0
        L_0x019f:
            if (r11 >= r8) goto L_0x0185
            r13.zzb()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            int r11 = r11 + 1
            goto L_0x019f
        L_0x01a7:
            if (r3 != r8) goto L_0x01ab
            r11 = r8
            goto L_0x01ac
        L_0x01ab:
            r11 = 1
        L_0x01ac:
            int r5 = r5 + r11
            r11 = r26
            goto L_0x0177
        L_0x01b0:
            r26 = r11
            r8 = 3
            int r3 = r3 + 1
            goto L_0x0173
        L_0x01b6:
            r26 = r11
            r8 = 3
            r3 = 2
            r13.zze(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            boolean r3 = r13.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            if (r3 == 0) goto L_0x01d1
            r3 = 8
            r13.zze(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r13.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
        L_0x01d1:
            int r3 = r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r5 = 0
            r8 = 0
            r11 = 0
        L_0x01d8:
            if (r5 >= r3) goto L_0x022b
            if (r5 == 0) goto L_0x01e0
            boolean r11 = r13.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
        L_0x01e0:
            if (r11 == 0) goto L_0x01fc
            r13.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r25 = r3
            r3 = 0
        L_0x01eb:
            if (r3 > r8) goto L_0x01f9
            boolean r27 = r13.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            if (r27 == 0) goto L_0x01f6
            r13.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
        L_0x01f6:
            int r3 = r3 + 1
            goto L_0x01eb
        L_0x01f9:
            r28 = r11
            goto L_0x0224
        L_0x01fc:
            r25 = r3
            int r3 = r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            int r8 = r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            int r27 = r3 + r8
            r28 = r11
            r11 = 0
        L_0x020b:
            if (r11 >= r3) goto L_0x0216
            r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r13.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            int r11 = r11 + 1
            goto L_0x020b
        L_0x0216:
            r3 = 0
        L_0x0217:
            if (r3 >= r8) goto L_0x0222
            r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r13.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            int r3 = r3 + 1
            goto L_0x0217
        L_0x0222:
            r8 = r27
        L_0x0224:
            int r5 = r5 + 1
            r3 = r25
            r11 = r28
            goto L_0x01d8
        L_0x022b:
            boolean r3 = r13.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            if (r3 == 0) goto L_0x0241
            r3 = 0
        L_0x0232:
            int r5 = r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            if (r3 >= r5) goto L_0x0241
            r5 = 5
            int r8 = r2 + 5
            r13.zze(r8)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            int r3 = r3 + 1
            goto L_0x0232
        L_0x0241:
            r2 = 2
            r13.zze(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            boolean r2 = r13.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            if (r2 == 0) goto L_0x02c6
            boolean r2 = r13.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            if (r2 == 0) goto L_0x028e
            r2 = 8
            int r2 = r13.zza(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r3 = 255(0xff, float:3.57E-43)
            if (r2 != r3) goto L_0x026d
            r2 = 16
            int r3 = r13.zza(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            int r2 = r13.zza(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            if (r3 == 0) goto L_0x028e
            if (r2 == 0) goto L_0x028e
            float r3 = (float) r3     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            float r2 = (float) r2     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            float r3 = r3 / r2
            goto L_0x0290
        L_0x026d:
            r3 = 17
            if (r2 >= r3) goto L_0x0276
            float[] r3 = com.google.android.gms.internal.ads.zzeu.zzb     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r3 = r3[r2]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            goto L_0x0290
        L_0x0276:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r5 = 46
            r3.<init>(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            java.lang.String r5 = "Unexpected aspect_ratio_idc value: "
            r3.append(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r3.append(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            java.lang.String r2 = "NalUnitUtil"
            java.lang.String r3 = r3.toString()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            android.util.Log.w(r2, r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
        L_0x028e:
            r3 = 1065353216(0x3f800000, float:1.0)
        L_0x0290:
            boolean r2 = r13.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            if (r2 == 0) goto L_0x0299
            r13.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
        L_0x0299:
            boolean r2 = r13.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            if (r2 == 0) goto L_0x02ae
            r2 = 4
            r13.zze(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            boolean r2 = r13.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            if (r2 == 0) goto L_0x02ae
            r2 = 24
            r13.zze(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
        L_0x02ae:
            boolean r2 = r13.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            if (r2 == 0) goto L_0x02ba
            r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r13.zzc()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
        L_0x02ba:
            r13.zzd()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            boolean r2 = r13.zzf()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            if (r2 == 0) goto L_0x02c8
            int r24 = r24 + r24
            goto L_0x02c8
        L_0x02c6:
            r3 = 1065353216(0x3f800000, float:1.0)
        L_0x02c8:
            r22 = r15
            java.lang.String r17 = com.google.android.gms.internal.ads.zzea.zzb(r18, r19, r20, r21, r22, r23)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r16 = r3
            r15 = r24
            r13 = 0
            goto L_0x02d8
        L_0x02d4:
            r29 = r3
            r26 = r11
        L_0x02d8:
            int r10 = r10 + r9
            r0.zzG(r9)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r2 = 1
            int r13 = r13 + r2
            r8 = r2
            r11 = r26
            r3 = r29
            r2 = 3
            r5 = 0
            goto L_0x0051
        L_0x02e7:
            r29 = r3
            int r6 = r6 + 1
            r2 = 3
            r5 = 0
            r8 = 1
            goto L_0x0044
        L_0x02f0:
            if (r7 != 0) goto L_0x02f7
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            goto L_0x02fb
        L_0x02f7:
            java.util.List r0 = java.util.Collections.singletonList(r4)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
        L_0x02fb:
            r12 = r0
            com.google.android.gms.internal.ads.zzxg r0 = new com.google.android.gms.internal.ads.zzxg     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            r2 = 1
            int r13 = r1 + 1
            r11 = r0
            r11.<init>(r12, r13, r14, r15, r16, r17)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0306 }
            return r0
        L_0x0306:
            r0 = move-exception
            java.lang.String r1 = "Error parsing HEVC config"
            com.google.android.gms.internal.ads.zzbj r0 = com.google.android.gms.internal.ads.zzbj.zza(r1, r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzxg.zza(com.google.android.gms.internal.ads.zzfd):com.google.android.gms.internal.ads.zzxg");
    }
}
