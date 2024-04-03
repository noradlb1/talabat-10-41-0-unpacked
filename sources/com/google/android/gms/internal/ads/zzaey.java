package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import android.util.SparseIntArray;

final class zzaey implements zzaeq {
    final /* synthetic */ zzaez zza;
    private final zzfc zzb = new zzfc(new byte[5], 5);
    private final SparseArray<zzafe> zzc = new SparseArray<>();
    private final SparseIntArray zzd = new SparseIntArray();
    private final int zze;

    public zzaey(zzaez zzaez, int i11) {
        this.zza = zzaez;
        this.zze = i11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0117, code lost:
        if (r28.zzk() == 21) goto L_0x00e2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzfd r28) {
        /*
            r27 = this;
            r0 = r27
            r1 = r28
            int r2 = r28.zzk()
            r3 = 2
            if (r2 == r3) goto L_0x000c
            return
        L_0x000c:
            com.google.android.gms.internal.ads.zzaez r2 = r0.zza
            java.util.List r2 = r2.zzb
            r4 = 0
            java.lang.Object r2 = r2.get(r4)
            com.google.android.gms.internal.ads.zzfk r2 = (com.google.android.gms.internal.ads.zzfk) r2
            int r5 = r28.zzk()
            r5 = r5 & 128(0x80, float:1.794E-43)
            if (r5 != 0) goto L_0x0022
            return
        L_0x0022:
            r5 = 1
            r1.zzG(r5)
            int r6 = r28.zzo()
            r7 = 3
            r1.zzG(r7)
            com.google.android.gms.internal.ads.zzfc r8 = r0.zzb
            r1.zzA(r8, r3)
            com.google.android.gms.internal.ads.zzfc r8 = r0.zzb
            r8.zzj(r7)
            com.google.android.gms.internal.ads.zzaez r8 = r0.zza
            com.google.android.gms.internal.ads.zzfc r9 = r0.zzb
            r10 = 13
            int r9 = r9.zzc(r10)
            r8.zzq = r9
            com.google.android.gms.internal.ads.zzfc r8 = r0.zzb
            r1.zzA(r8, r3)
            com.google.android.gms.internal.ads.zzfc r3 = r0.zzb
            r8 = 4
            r3.zzj(r8)
            com.google.android.gms.internal.ads.zzfc r3 = r0.zzb
            r9 = 12
            int r3 = r3.zzc(r9)
            r1.zzG(r3)
            android.util.SparseArray<com.google.android.gms.internal.ads.zzafe> r3 = r0.zzc
            r3.clear()
            android.util.SparseIntArray r3 = r0.zzd
            r3.clear()
            int r3 = r28.zza()
        L_0x0069:
            if (r3 <= 0) goto L_0x01e6
            com.google.android.gms.internal.ads.zzfc r11 = r0.zzb
            r12 = 5
            r1.zzA(r11, r12)
            com.google.android.gms.internal.ads.zzfc r11 = r0.zzb
            r13 = 8
            int r11 = r11.zzc(r13)
            com.google.android.gms.internal.ads.zzfc r13 = r0.zzb
            r13.zzj(r7)
            com.google.android.gms.internal.ads.zzfc r13 = r0.zzb
            int r13 = r13.zzc(r10)
            com.google.android.gms.internal.ads.zzfc r14 = r0.zzb
            r14.zzj(r8)
            com.google.android.gms.internal.ads.zzfc r14 = r0.zzb
            int r14 = r14.zzc(r9)
            int r15 = r28.zzc()
            int r9 = r15 + r14
            r16 = 0
            r17 = -1
            r5 = r16
            r10 = r5
            r18 = r17
        L_0x009e:
            int r4 = r28.zzc()
            if (r4 >= r9) goto L_0x0196
            int r4 = r28.zzk()
            int r19 = r28.zzk()
            int r20 = r28.zzc()
            int r8 = r20 + r19
            if (r8 <= r9) goto L_0x00bb
            r21 = r2
            r22 = r6
            r12 = 4
            goto L_0x019b
        L_0x00bb:
            r19 = 172(0xac, float:2.41E-43)
            r20 = 135(0x87, float:1.89E-43)
            r22 = 129(0x81, float:1.81E-43)
            if (r4 != r12) goto L_0x00f3
            long r23 = r28.zzs()
            r25 = 1094921523(0x41432d33, double:5.409631094E-315)
            int r4 = (r23 > r25 ? 1 : (r23 == r25 ? 0 : -1))
            if (r4 != 0) goto L_0x00d1
            r18 = r22
            goto L_0x00ee
        L_0x00d1:
            r25 = 1161904947(0x45414333, double:5.74057318E-315)
            int r4 = (r23 > r25 ? 1 : (r23 == r25 ? 0 : -1))
            if (r4 != 0) goto L_0x00db
            r18 = r20
            goto L_0x00ee
        L_0x00db:
            r25 = 1094921524(0x41432d34, double:5.4096311E-315)
            int r4 = (r23 > r25 ? 1 : (r23 == r25 ? 0 : -1))
            if (r4 != 0) goto L_0x00e5
        L_0x00e2:
            r18 = r19
            goto L_0x00ee
        L_0x00e5:
            r19 = 1212503619(0x48455643, double:5.990563836E-315)
            int r4 = (r23 > r19 ? 1 : (r23 == r19 ? 0 : -1))
            if (r4 != 0) goto L_0x00ee
            r18 = 36
        L_0x00ee:
            r21 = r2
        L_0x00f0:
            r22 = r6
            goto L_0x010a
        L_0x00f3:
            r12 = 106(0x6a, float:1.49E-43)
            if (r4 != r12) goto L_0x0100
            r21 = r2
            r18 = r22
            r12 = 4
            r22 = r6
            goto L_0x0185
        L_0x0100:
            r12 = 122(0x7a, float:1.71E-43)
            if (r4 != r12) goto L_0x010d
            r21 = r2
            r22 = r6
            r18 = r20
        L_0x010a:
            r12 = 4
            goto L_0x0185
        L_0x010d:
            r12 = 127(0x7f, float:1.78E-43)
            if (r4 != r12) goto L_0x011a
            int r4 = r28.zzk()
            r12 = 21
            if (r4 != r12) goto L_0x00ee
            goto L_0x00e2
        L_0x011a:
            r12 = 123(0x7b, float:1.72E-43)
            if (r4 != r12) goto L_0x0125
            r4 = 138(0x8a, float:1.93E-43)
            r21 = r2
            r18 = r4
            goto L_0x00f0
        L_0x0125:
            r12 = 10
            if (r4 != r12) goto L_0x0137
            java.nio.charset.Charset r4 = com.google.android.gms.internal.ads.zzfpt.zzc
            java.lang.String r4 = r1.zzx(r7, r4)
            java.lang.String r4 = r4.trim()
            r21 = r2
            r10 = r4
            goto L_0x00f0
        L_0x0137:
            r12 = 89
            if (r4 != r12) goto L_0x0178
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
        L_0x0140:
            int r5 = r28.zzc()
            if (r5 >= r8) goto L_0x016f
            java.nio.charset.Charset r5 = com.google.android.gms.internal.ads.zzfpt.zzc
            java.lang.String r5 = r1.zzx(r7, r5)
            java.lang.String r5 = r5.trim()
            int r7 = r28.zzk()
            r21 = r2
            r12 = 4
            byte[] r2 = new byte[r12]
            r22 = r6
            r6 = 0
            r1.zzB(r2, r6, r12)
            com.google.android.gms.internal.ads.zzafa r6 = new com.google.android.gms.internal.ads.zzafa
            r6.<init>(r5, r7, r2)
            r4.add(r6)
            r2 = r21
            r6 = r22
            r7 = 3
            r12 = 89
            goto L_0x0140
        L_0x016f:
            r21 = r2
            r22 = r6
            r12 = 4
            r5 = r4
            r18 = 89
            goto L_0x0185
        L_0x0178:
            r21 = r2
            r22 = r6
            r12 = 4
            r2 = 111(0x6f, float:1.56E-43)
            if (r4 != r2) goto L_0x0185
            r2 = 257(0x101, float:3.6E-43)
            r18 = r2
        L_0x0185:
            int r2 = r28.zzc()
            int r8 = r8 - r2
            r1.zzG(r8)
            r8 = r12
            r2 = r21
            r6 = r22
            r7 = 3
            r12 = 5
            goto L_0x009e
        L_0x0196:
            r21 = r2
            r22 = r6
            r12 = r8
        L_0x019b:
            r1.zzF(r9)
            com.google.android.gms.internal.ads.zzafb r2 = new com.google.android.gms.internal.ads.zzafb
            byte[] r4 = r28.zzH()
            byte[] r4 = java.util.Arrays.copyOfRange(r4, r15, r9)
            r6 = r18
            r2.<init>(r6, r10, r5, r4)
            r4 = 6
            if (r11 == r4) goto L_0x01b3
            r4 = 5
            if (r11 != r4) goto L_0x01b5
        L_0x01b3:
            int r11 = r2.zza
        L_0x01b5:
            int r14 = r14 + 5
            int r3 = r3 - r14
            com.google.android.gms.internal.ads.zzaez r4 = r0.zza
            android.util.SparseBooleanArray r4 = r4.zzg
            boolean r4 = r4.get(r13)
            if (r4 != 0) goto L_0x01d8
            com.google.android.gms.internal.ads.zzaez r4 = r0.zza
            com.google.android.gms.internal.ads.zzafc r4 = r4.zze
            com.google.android.gms.internal.ads.zzafe r2 = r4.zza(r11, r2)
            android.util.SparseIntArray r4 = r0.zzd
            r4.put(r13, r13)
            android.util.SparseArray<com.google.android.gms.internal.ads.zzafe> r4 = r0.zzc
            r4.put(r13, r2)
        L_0x01d8:
            r8 = r12
            r2 = r21
            r6 = r22
            r4 = 0
            r5 = 1
            r7 = 3
            r9 = 12
            r10 = 13
            goto L_0x0069
        L_0x01e6:
            r21 = r2
            r22 = r6
            android.util.SparseIntArray r1 = r0.zzd
            int r1 = r1.size()
            r6 = 0
        L_0x01f1:
            if (r6 >= r1) goto L_0x0245
            android.util.SparseIntArray r2 = r0.zzd
            int r2 = r2.keyAt(r6)
            android.util.SparseIntArray r3 = r0.zzd
            int r3 = r3.valueAt(r6)
            com.google.android.gms.internal.ads.zzaez r4 = r0.zza
            android.util.SparseBooleanArray r4 = r4.zzg
            r5 = 1
            r4.put(r2, r5)
            com.google.android.gms.internal.ads.zzaez r4 = r0.zza
            android.util.SparseBooleanArray r4 = r4.zzh
            r4.put(r3, r5)
            android.util.SparseArray<com.google.android.gms.internal.ads.zzafe> r4 = r0.zzc
            java.lang.Object r4 = r4.valueAt(r6)
            com.google.android.gms.internal.ads.zzafe r4 = (com.google.android.gms.internal.ads.zzafe) r4
            if (r4 == 0) goto L_0x023a
            com.google.android.gms.internal.ads.zzaez r5 = r0.zza
            com.google.android.gms.internal.ads.zzws r5 = r5.zzk
            com.google.android.gms.internal.ads.zzafd r7 = new com.google.android.gms.internal.ads.zzafd
            r8 = 8192(0x2000, float:1.14794E-41)
            r9 = r22
            r7.<init>(r9, r2, r8)
            r2 = r21
            r4.zzb(r2, r5, r7)
            com.google.android.gms.internal.ads.zzaez r5 = r0.zza
            android.util.SparseArray r5 = r5.zzf
            r5.put(r3, r4)
            goto L_0x023e
        L_0x023a:
            r2 = r21
            r9 = r22
        L_0x023e:
            int r6 = r6 + 1
            r21 = r2
            r22 = r9
            goto L_0x01f1
        L_0x0245:
            com.google.android.gms.internal.ads.zzaez r1 = r0.zza
            android.util.SparseArray r1 = r1.zzf
            int r2 = r0.zze
            r1.remove(r2)
            com.google.android.gms.internal.ads.zzaez r1 = r0.zza
            r2 = 0
            r1.zzl = r2
            com.google.android.gms.internal.ads.zzaez r1 = r0.zza
            int r1 = r1.zzl
            if (r1 != 0) goto L_0x026d
            com.google.android.gms.internal.ads.zzaez r1 = r0.zza
            com.google.android.gms.internal.ads.zzws r1 = r1.zzk
            r1.zzB()
            com.google.android.gms.internal.ads.zzaez r1 = r0.zza
            r2 = 1
            r1.zzm = true
        L_0x026d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaey.zza(com.google.android.gms.internal.ads.zzfd):void");
    }

    public final void zzb(zzfk zzfk, zzws zzws, zzafd zzafd) {
    }
}
