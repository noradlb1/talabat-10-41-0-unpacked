package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zzaec implements zzadr {
    private final zzaes zza;
    private String zzb;
    private zzxt zzc;
    private zzaeb zzd;
    private boolean zze;
    private final boolean[] zzf = new boolean[3];
    private final zzaeg zzg = new zzaeg(32, 128);
    private final zzaeg zzh = new zzaeg(33, 128);
    private final zzaeg zzi = new zzaeg(34, 128);
    private final zzaeg zzj = new zzaeg(39, 128);
    private final zzaeg zzk = new zzaeg(40, 128);
    private long zzl;
    private long zzm = C.TIME_UNSET;
    private final zzfd zzn = new zzfd();

    public zzaec(zzaes zzaes) {
        this.zza = zzaes;
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzf(byte[] bArr, int i11, int i12) {
        this.zzd.zzb(bArr, i11, i12);
        if (!this.zze) {
            this.zzg.zza(bArr, i11, i12);
            this.zzh.zza(bArr, i11, i12);
            this.zzi.zza(bArr, i11, i12);
        }
        this.zzj.zza(bArr, i11, i12);
        this.zzk.zza(bArr, i11, i12);
    }

    /* JADX WARNING: Removed duplicated region for block: B:154:0x0358  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x037b  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0385  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x03ba  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x03cc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzfd r37) {
        /*
            r36 = this;
            r0 = r36
            com.google.android.gms.internal.ads.zzxt r1 = r0.zzc
            com.google.android.gms.internal.ads.zzdy.zzb(r1)
            int r1 = com.google.android.gms.internal.ads.zzfn.zza
        L_0x0009:
            int r1 = r37.zza()
            if (r1 <= 0) goto L_0x03e5
            int r1 = r37.zzc()
            int r2 = r37.zzd()
            byte[] r3 = r37.zzH()
            long r4 = r0.zzl
            int r6 = r37.zza()
            long r6 = (long) r6
            long r4 = r4 + r6
            r0.zzl = r4
            com.google.android.gms.internal.ads.zzxt r4 = r0.zzc
            int r5 = r37.zza()
            r6 = r37
            com.google.android.gms.internal.ads.zzxr.zzb(r4, r6, r5)
        L_0x0030:
            if (r1 >= r2) goto L_0x0009
            boolean[] r4 = r0.zzf
            int r4 = com.google.android.gms.internal.ads.zzeu.zza(r3, r1, r2, r4)
            if (r4 == r2) goto L_0x03e2
            int r5 = r4 + 3
            byte r7 = r3[r5]
            r7 = r7 & 126(0x7e, float:1.77E-43)
            r8 = 1
            int r7 = r7 >> r8
            int r9 = r4 - r1
            if (r9 <= 0) goto L_0x0049
            r0.zzf(r3, r1, r4)
        L_0x0049:
            int r12 = r2 - r4
            long r10 = r0.zzl
            long r13 = (long) r12
            long r10 = r10 - r13
            if (r9 >= 0) goto L_0x0053
            int r4 = -r9
            goto L_0x0054
        L_0x0053:
            r4 = 0
        L_0x0054:
            long r13 = r0.zzm
            com.google.android.gms.internal.ads.zzaeb r9 = r0.zzd
            boolean r15 = r0.zze
            r9.zza(r10, r12, r15)
            boolean r9 = r0.zze
            if (r9 != 0) goto L_0x0342
            com.google.android.gms.internal.ads.zzaeg r9 = r0.zzg
            r9.zzd(r4)
            com.google.android.gms.internal.ads.zzaeg r9 = r0.zzh
            r9.zzd(r4)
            com.google.android.gms.internal.ads.zzaeg r9 = r0.zzi
            r9.zzd(r4)
            com.google.android.gms.internal.ads.zzaeg r9 = r0.zzg
            boolean r9 = r9.zze()
            if (r9 == 0) goto L_0x0342
            com.google.android.gms.internal.ads.zzaeg r9 = r0.zzh
            boolean r9 = r9.zze()
            if (r9 == 0) goto L_0x0342
            com.google.android.gms.internal.ads.zzaeg r9 = r0.zzi
            boolean r9 = r9.zze()
            if (r9 == 0) goto L_0x0342
            com.google.android.gms.internal.ads.zzxt r9 = r0.zzc
            java.lang.String r8 = r0.zzb
            com.google.android.gms.internal.ads.zzaeg r15 = r0.zzg
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzh
            r18 = r5
            com.google.android.gms.internal.ads.zzaeg r5 = r0.zzi
            int r6 = r15.zzb
            r19 = r2
            int r2 = r1.zzb
            int r2 = r2 + r6
            r20 = r3
            int r3 = r5.zzb
            int r2 = r2 + r3
            byte[] r2 = new byte[r2]
            byte[] r3 = r15.zza
            r21 = r7
            r7 = 0
            java.lang.System.arraycopy(r3, r7, r2, r7, r6)
            byte[] r3 = r1.zza
            int r6 = r15.zzb
            r17 = r12
            int r12 = r1.zzb
            java.lang.System.arraycopy(r3, r7, r2, r6, r12)
            byte[] r3 = r5.zza
            int r6 = r15.zzb
            int r12 = r1.zzb
            int r6 = r6 + r12
            int r5 = r5.zzb
            java.lang.System.arraycopy(r3, r7, r2, r6, r5)
            com.google.android.gms.internal.ads.zzfe r3 = new com.google.android.gms.internal.ads.zzfe
            byte[] r5 = r1.zza
            int r1 = r1.zzb
            r3.<init>(r5, r7, r1)
            r1 = 44
            r3.zze(r1)
            r1 = 3
            int r5 = r3.zza(r1)
            r3.zzd()
            r6 = 2
            int r22 = r3.zza(r6)
            boolean r23 = r3.zzf()
            r12 = 5
            int r24 = r3.zza(r12)
            r12 = r7
            r25 = r12
        L_0x00e8:
            r15 = 32
            if (r12 >= r15) goto L_0x00fa
            boolean r15 = r3.zzf()
            if (r15 == 0) goto L_0x00f7
            r15 = 1
            int r26 = r15 << r12
            r25 = r25 | r26
        L_0x00f7:
            int r12 = r12 + 1
            goto L_0x00e8
        L_0x00fa:
            r12 = 6
            int[] r15 = new int[r12]
        L_0x00fd:
            r6 = 8
            if (r7 >= r12) goto L_0x010a
            int r6 = r3.zza(r6)
            r15[r7] = r6
            int r7 = r7 + 1
            goto L_0x00fd
        L_0x010a:
            int r7 = r3.zza(r6)
            r6 = 0
            r12 = 0
        L_0x0110:
            if (r6 >= r5) goto L_0x0125
            boolean r29 = r3.zzf()
            if (r29 == 0) goto L_0x011a
            int r12 = r12 + 89
        L_0x011a:
            boolean r29 = r3.zzf()
            if (r29 == 0) goto L_0x0122
            int r12 = r12 + 8
        L_0x0122:
            int r6 = r6 + 1
            goto L_0x0110
        L_0x0125:
            r3.zze(r12)
            if (r5 <= 0) goto L_0x0130
            int r6 = 8 - r5
            int r6 = r6 + r6
            r3.zze(r6)
        L_0x0130:
            r3.zzc()
            int r6 = r3.zzc()
            if (r6 != r1) goto L_0x013d
            r3.zzd()
            r6 = r1
        L_0x013d:
            int r12 = r3.zzc()
            int r29 = r3.zzc()
            boolean r30 = r3.zzf()
            if (r30 == 0) goto L_0x0180
            int r30 = r3.zzc()
            int r31 = r3.zzc()
            int r32 = r3.zzc()
            int r33 = r3.zzc()
            r1 = 1
            if (r6 == r1) goto L_0x016b
            r1 = 2
            if (r6 != r1) goto L_0x0166
            r34 = r10
            r1 = 2
            r6 = 2
            goto L_0x0169
        L_0x0166:
            r34 = r10
            r1 = 1
        L_0x0169:
            r10 = 1
            goto L_0x016f
        L_0x016b:
            r34 = r10
            r10 = r1
            r1 = 2
        L_0x016f:
            if (r6 != r10) goto L_0x0173
            r6 = 2
            goto L_0x0174
        L_0x0173:
            r6 = 1
        L_0x0174:
            int r30 = r30 + r31
            int r1 = r1 * r30
            int r12 = r12 - r1
            int r32 = r32 + r33
            int r6 = r6 * r32
            int r29 = r29 - r6
            goto L_0x0182
        L_0x0180:
            r34 = r10
        L_0x0182:
            r3.zzc()
            r3.zzc()
            int r1 = r3.zzc()
            boolean r6 = r3.zzf()
            r10 = 1
            if (r10 == r6) goto L_0x0195
            r6 = r5
            goto L_0x0196
        L_0x0195:
            r6 = 0
        L_0x0196:
            if (r6 > r5) goto L_0x01a4
            r3.zzc()
            r3.zzc()
            r3.zzc()
            int r6 = r6 + 1
            goto L_0x0196
        L_0x01a4:
            r3.zzc()
            r3.zzc()
            r3.zzc()
            r3.zzc()
            r3.zzc()
            r3.zzc()
            boolean r5 = r3.zzf()
            r6 = 4
            if (r5 == 0) goto L_0x0205
            boolean r5 = r3.zzf()
            if (r5 == 0) goto L_0x0205
            r5 = 0
        L_0x01c4:
            if (r5 >= r6) goto L_0x0205
            r10 = 0
        L_0x01c7:
            r11 = 6
            if (r10 >= r11) goto L_0x01fe
            boolean r28 = r3.zzf()
            if (r28 != 0) goto L_0x01d7
            r3.zzc()
            r32 = r13
        L_0x01d5:
            r6 = 3
            goto L_0x01f4
        L_0x01d7:
            int r28 = r5 + r5
            int r28 = r28 + 4
            r11 = 1
            int r6 = r11 << r28
            r32 = r13
            r13 = 64
            int r6 = java.lang.Math.min(r13, r6)
            if (r5 <= r11) goto L_0x01eb
            r3.zzb()
        L_0x01eb:
            r11 = 0
        L_0x01ec:
            if (r11 >= r6) goto L_0x01d5
            r3.zzb()
            int r11 = r11 + 1
            goto L_0x01ec
        L_0x01f4:
            if (r5 != r6) goto L_0x01f8
            r11 = r6
            goto L_0x01f9
        L_0x01f8:
            r11 = 1
        L_0x01f9:
            int r10 = r10 + r11
            r13 = r32
            r6 = 4
            goto L_0x01c7
        L_0x01fe:
            r32 = r13
            r6 = 3
            int r5 = r5 + 1
            r6 = 4
            goto L_0x01c4
        L_0x0205:
            r32 = r13
            r5 = 2
            r3.zze(r5)
            boolean r5 = r3.zzf()
            if (r5 == 0) goto L_0x021f
            r5 = 8
            r3.zze(r5)
            r3.zzc()
            r3.zzc()
            r3.zzd()
        L_0x021f:
            int r5 = r3.zzc()
            r6 = 0
            r10 = 0
            r11 = 0
        L_0x0226:
            if (r6 >= r5) goto L_0x0272
            if (r6 == 0) goto L_0x022e
            boolean r10 = r3.zzf()
        L_0x022e:
            if (r10 == 0) goto L_0x0248
            r3.zzd()
            r3.zzc()
            r13 = 0
        L_0x0237:
            if (r13 > r11) goto L_0x0245
            boolean r14 = r3.zzf()
            if (r14 == 0) goto L_0x0242
            r3.zzd()
        L_0x0242:
            int r13 = r13 + 1
            goto L_0x0237
        L_0x0245:
            r28 = r5
            goto L_0x026d
        L_0x0248:
            int r11 = r3.zzc()
            int r13 = r3.zzc()
            int r14 = r11 + r13
            r28 = r5
            r5 = 0
        L_0x0255:
            if (r5 >= r11) goto L_0x0260
            r3.zzc()
            r3.zzd()
            int r5 = r5 + 1
            goto L_0x0255
        L_0x0260:
            r5 = 0
        L_0x0261:
            if (r5 >= r13) goto L_0x026c
            r3.zzc()
            r3.zzd()
            int r5 = r5 + 1
            goto L_0x0261
        L_0x026c:
            r11 = r14
        L_0x026d:
            int r6 = r6 + 1
            r5 = r28
            goto L_0x0226
        L_0x0272:
            boolean r5 = r3.zzf()
            if (r5 == 0) goto L_0x0288
            r5 = 0
        L_0x0279:
            int r6 = r3.zzc()
            if (r5 >= r6) goto L_0x0288
            r6 = 5
            int r10 = r1 + 5
            r3.zze(r10)
            int r5 = r5 + 1
            goto L_0x0279
        L_0x0288:
            r1 = 2
            r3.zze(r1)
            boolean r1 = r3.zzf()
            r5 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L_0x030d
            boolean r1 = r3.zzf()
            if (r1 == 0) goto L_0x02d8
            r1 = 8
            int r1 = r3.zza(r1)
            r6 = 255(0xff, float:3.57E-43)
            if (r1 != r6) goto L_0x02b6
            r1 = 16
            int r6 = r3.zza(r1)
            int r1 = r3.zza(r1)
            if (r6 == 0) goto L_0x02d8
            if (r1 == 0) goto L_0x02d8
            float r5 = (float) r6
            float r1 = (float) r1
            float r5 = r5 / r1
            goto L_0x02d8
        L_0x02b6:
            r6 = 17
            if (r1 >= r6) goto L_0x02c0
            float[] r5 = com.google.android.gms.internal.ads.zzeu.zzb
            r1 = r5[r1]
            r5 = r1
            goto L_0x02d8
        L_0x02c0:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r10 = 46
            r6.<init>(r10)
            java.lang.String r10 = "Unexpected aspect_ratio_idc value: "
            r6.append(r10)
            r6.append(r1)
            java.lang.String r1 = "H265Reader"
            java.lang.String r6 = r6.toString()
            android.util.Log.w(r1, r6)
        L_0x02d8:
            boolean r1 = r3.zzf()
            if (r1 == 0) goto L_0x02e1
            r3.zzd()
        L_0x02e1:
            boolean r1 = r3.zzf()
            if (r1 == 0) goto L_0x02f6
            r1 = 4
            r3.zze(r1)
            boolean r1 = r3.zzf()
            if (r1 == 0) goto L_0x02f6
            r1 = 24
            r3.zze(r1)
        L_0x02f6:
            boolean r1 = r3.zzf()
            if (r1 == 0) goto L_0x0302
            r3.zzc()
            r3.zzc()
        L_0x0302:
            r3.zzd()
            boolean r1 = r3.zzf()
            if (r1 == 0) goto L_0x030d
            int r29 = r29 + r29
        L_0x030d:
            r1 = r29
            r26 = r15
            r27 = r7
            java.lang.String r3 = com.google.android.gms.internal.ads.zzea.zzb(r22, r23, r24, r25, r26, r27)
            com.google.android.gms.internal.ads.zzz r6 = new com.google.android.gms.internal.ads.zzz
            r6.<init>()
            r6.zzH(r8)
            java.lang.String r7 = "video/hevc"
            r6.zzS(r7)
            r6.zzx(r3)
            r6.zzX(r12)
            r6.zzF(r1)
            r6.zzP(r5)
            java.util.List r1 = java.util.Collections.singletonList(r2)
            r6.zzI(r1)
            com.google.android.gms.internal.ads.zzab r1 = r6.zzY()
            r9.zzk(r1)
            r1 = 1
            r0.zze = r1
            goto L_0x0350
        L_0x0342:
            r19 = r2
            r20 = r3
            r18 = r5
            r21 = r7
            r34 = r10
            r17 = r12
            r32 = r13
        L_0x0350:
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzj
            boolean r1 = r1.zzd(r4)
            if (r1 == 0) goto L_0x037b
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzj
            byte[] r2 = r1.zza
            int r1 = r1.zzb
            int r1 = com.google.android.gms.internal.ads.zzeu.zzb(r2, r1)
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzn
            com.google.android.gms.internal.ads.zzaeg r3 = r0.zzj
            byte[] r3 = r3.zza
            r2.zzD(r3, r1)
            com.google.android.gms.internal.ads.zzfd r1 = r0.zzn
            r2 = 5
            r1.zzG(r2)
            com.google.android.gms.internal.ads.zzaes r1 = r0.zza
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzn
            r5 = r32
            r1.zza(r5, r2)
            goto L_0x037d
        L_0x037b:
            r5 = r32
        L_0x037d:
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzk
            boolean r1 = r1.zzd(r4)
            if (r1 == 0) goto L_0x03a5
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzk
            byte[] r2 = r1.zza
            int r1 = r1.zzb
            int r1 = com.google.android.gms.internal.ads.zzeu.zzb(r2, r1)
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzn
            com.google.android.gms.internal.ads.zzaeg r3 = r0.zzk
            byte[] r3 = r3.zza
            r2.zzD(r3, r1)
            com.google.android.gms.internal.ads.zzfd r1 = r0.zzn
            r2 = 5
            r1.zzG(r2)
            com.google.android.gms.internal.ads.zzaes r1 = r0.zza
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzn
            r1.zza(r5, r2)
        L_0x03a5:
            long r14 = r0.zzm
            com.google.android.gms.internal.ads.zzaeb r9 = r0.zzd
            boolean r1 = r0.zze
            r10 = r34
            r12 = r17
            r13 = r21
            r16 = r1
            r9.zzd(r10, r12, r13, r14, r16)
            boolean r1 = r0.zze
            if (r1 != 0) goto L_0x03cc
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzg
            r2 = r21
            r1.zzc(r2)
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzh
            r1.zzc(r2)
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzi
            r1.zzc(r2)
            goto L_0x03ce
        L_0x03cc:
            r2 = r21
        L_0x03ce:
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzj
            r1.zzc(r2)
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzk
            r1.zzc(r2)
            r6 = r37
            r1 = r18
            r2 = r19
            r3 = r20
            goto L_0x0030
        L_0x03e2:
            r0.zzf(r3, r1, r2)
        L_0x03e5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaec.zza(com.google.android.gms.internal.ads.zzfd):void");
    }

    public final void zzb(zzws zzws, zzafd zzafd) {
        zzafd.zzc();
        this.zzb = zzafd.zzb();
        zzxt zzv = zzws.zzv(zzafd.zza(), 2);
        this.zzc = zzv;
        this.zzd = new zzaeb(zzv);
        this.zza.zzb(zzws, zzafd);
    }

    public final void zzc() {
    }

    public final void zzd(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.zzm = j11;
        }
    }

    public final void zze() {
        this.zzl = 0;
        this.zzm = C.TIME_UNSET;
        zzeu.zze(this.zzf);
        this.zzg.zzb();
        this.zzh.zzb();
        this.zzi.zzb();
        this.zzj.zzb();
        this.zzk.zzb();
        zzaeb zzaeb = this.zzd;
        if (zzaeb != null) {
            zzaeb.zzc();
        }
    }
}
