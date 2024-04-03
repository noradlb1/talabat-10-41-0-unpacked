package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import net.bytebuddy.jar.asm.Opcodes;

public final class zzadw implements zzadr {
    private static final float[] zza = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 1.0f};
    @Nullable
    private final zzafg zzb;
    @Nullable
    private final zzfd zzc;
    private final boolean[] zzd;
    private final zzadu zze;
    @Nullable
    private final zzaeg zzf;
    private zzadv zzg;
    private long zzh;
    private String zzi;
    private zzxt zzj;
    private boolean zzk;
    private long zzl;

    public zzadw() {
        this((zzafg) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x012e  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x018c  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x01bc  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x01cd A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzfd r19) {
        /*
            r18 = this;
            r0 = r18
            com.google.android.gms.internal.ads.zzadv r1 = r0.zzg
            com.google.android.gms.internal.ads.zzdy.zzb(r1)
            com.google.android.gms.internal.ads.zzxt r1 = r0.zzj
            com.google.android.gms.internal.ads.zzdy.zzb(r1)
            int r1 = r19.zzc()
            int r2 = r19.zzd()
            byte[] r3 = r19.zzH()
            long r4 = r0.zzh
            int r6 = r19.zza()
            long r6 = (long) r6
            long r4 = r4 + r6
            r0.zzh = r4
            com.google.android.gms.internal.ads.zzxt r4 = r0.zzj
            int r5 = r19.zza()
            r6 = r19
            com.google.android.gms.internal.ads.zzxr.zzb(r4, r6, r5)
        L_0x002d:
            boolean[] r4 = r0.zzd
            int r4 = com.google.android.gms.internal.ads.zzeu.zza(r3, r1, r2, r4)
            if (r4 != r2) goto L_0x0049
            boolean r4 = r0.zzk
            if (r4 != 0) goto L_0x003e
            com.google.android.gms.internal.ads.zzadu r4 = r0.zze
            r4.zza(r3, r1, r2)
        L_0x003e:
            com.google.android.gms.internal.ads.zzadv r4 = r0.zzg
            r4.zza(r3, r1, r2)
            com.google.android.gms.internal.ads.zzaeg r4 = r0.zzf
            r4.zza(r3, r1, r2)
            return
        L_0x0049:
            int r5 = r4 + 3
            byte[] r7 = r19.zzH()
            byte r7 = r7[r5]
            r7 = r7 & 255(0xff, float:3.57E-43)
            int r8 = r4 - r1
            boolean r9 = r0.zzk
            if (r9 != 0) goto L_0x0181
            if (r8 <= 0) goto L_0x0060
            com.google.android.gms.internal.ads.zzadu r9 = r0.zze
            r9.zza(r3, r1, r4)
        L_0x0060:
            if (r8 >= 0) goto L_0x0064
            int r9 = -r8
            goto L_0x0065
        L_0x0064:
            r9 = 0
        L_0x0065:
            com.google.android.gms.internal.ads.zzadu r12 = r0.zze
            boolean r9 = r12.zzc(r7, r9)
            if (r9 == 0) goto L_0x0181
            com.google.android.gms.internal.ads.zzxt r9 = r0.zzj
            com.google.android.gms.internal.ads.zzadu r12 = r0.zze
            int r13 = r12.zzb
            java.lang.String r14 = r0.zzi
            r14.getClass()
            byte[] r15 = r12.zzc
            int r12 = r12.zza
            byte[] r12 = java.util.Arrays.copyOf(r15, r12)
            com.google.android.gms.internal.ads.zzfc r15 = new com.google.android.gms.internal.ads.zzfc
            int r10 = r12.length
            r15.<init>(r12, r10)
            r15.zzk(r13)
            r10 = 4
            r15.zzk(r10)
            r15.zzi()
            r13 = 8
            r15.zzj(r13)
            boolean r16 = r15.zzl()
            r11 = 3
            if (r16 == 0) goto L_0x00a2
            r15.zzj(r10)
            r15.zzj(r11)
        L_0x00a2:
            int r10 = r15.zzc(r10)
            r16 = 1065353216(0x3f800000, float:1.0)
            java.lang.String r11 = "Invalid aspect ratio"
            java.lang.String r13 = "H263Reader"
            r17 = r5
            r5 = 15
            if (r10 != r5) goto L_0x00c7
            r5 = 8
            int r10 = r15.zzc(r5)
            int r5 = r15.zzc(r5)
            if (r5 != 0) goto L_0x00c2
            android.util.Log.w(r13, r11)
            goto L_0x00d2
        L_0x00c2:
            float r10 = (float) r10
            float r5 = (float) r5
            float r16 = r10 / r5
            goto L_0x00d2
        L_0x00c7:
            r5 = 7
            if (r10 >= r5) goto L_0x00cf
            float[] r5 = zza
            r16 = r5[r10]
            goto L_0x00d2
        L_0x00cf:
            android.util.Log.w(r13, r11)
        L_0x00d2:
            r5 = r16
            boolean r10 = r15.zzl()
            r11 = 2
            if (r10 == 0) goto L_0x0110
            r15.zzj(r11)
            r10 = 1
            r15.zzj(r10)
            boolean r10 = r15.zzl()
            if (r10 == 0) goto L_0x0110
            r10 = 15
            r15.zzj(r10)
            r15.zzi()
            r15.zzj(r10)
            r15.zzi()
            r15.zzj(r10)
            r15.zzi()
            r11 = 3
            r15.zzj(r11)
            r11 = 11
            r15.zzj(r11)
            r15.zzi()
            r15.zzj(r10)
            r15.zzi()
            r10 = 2
            goto L_0x0111
        L_0x0110:
            r10 = r11
        L_0x0111:
            int r10 = r15.zzc(r10)
            if (r10 == 0) goto L_0x011c
            java.lang.String r10 = "Unhandled video object layer shape"
            android.util.Log.w(r13, r10)
        L_0x011c:
            r15.zzi()
            r10 = 16
            int r10 = r15.zzc(r10)
            r15.zzi()
            boolean r11 = r15.zzl()
            if (r11 == 0) goto L_0x0143
            if (r10 != 0) goto L_0x0136
            java.lang.String r10 = "Invalid vop_increment_time_resolution"
            android.util.Log.w(r13, r10)
            goto L_0x0143
        L_0x0136:
            int r10 = r10 + -1
            r11 = 0
        L_0x0139:
            if (r10 <= 0) goto L_0x0140
            int r11 = r11 + 1
            int r10 = r10 >> 1
            goto L_0x0139
        L_0x0140:
            r15.zzj(r11)
        L_0x0143:
            r15.zzi()
            r10 = 13
            int r11 = r15.zzc(r10)
            r15.zzi()
            int r10 = r15.zzc(r10)
            r15.zzi()
            r15.zzi()
            com.google.android.gms.internal.ads.zzz r13 = new com.google.android.gms.internal.ads.zzz
            r13.<init>()
            r13.zzH(r14)
            java.lang.String r14 = "video/mp4v-es"
            r13.zzS(r14)
            r13.zzX(r11)
            r13.zzF(r10)
            r13.zzP(r5)
            java.util.List r5 = java.util.Collections.singletonList(r12)
            r13.zzI(r5)
            com.google.android.gms.internal.ads.zzab r5 = r13.zzY()
            r9.zzk(r5)
            r5 = 1
            r0.zzk = r5
            goto L_0x0183
        L_0x0181:
            r17 = r5
        L_0x0183:
            com.google.android.gms.internal.ads.zzadv r5 = r0.zzg
            r5.zza(r3, r1, r4)
            com.google.android.gms.internal.ads.zzaeg r5 = r0.zzf
            if (r8 <= 0) goto L_0x0191
            r5.zza(r3, r1, r4)
            r10 = 0
            goto L_0x0192
        L_0x0191:
            int r10 = -r8
        L_0x0192:
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzf
            boolean r1 = r1.zzd(r10)
            if (r1 == 0) goto L_0x01b8
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzf
            byte[] r5 = r1.zza
            int r1 = r1.zzb
            int r1 = com.google.android.gms.internal.ads.zzeu.zzb(r5, r1)
            com.google.android.gms.internal.ads.zzfd r5 = r0.zzc
            int r8 = com.google.android.gms.internal.ads.zzfn.zza
            com.google.android.gms.internal.ads.zzaeg r8 = r0.zzf
            byte[] r8 = r8.zza
            r5.zzD(r8, r1)
            com.google.android.gms.internal.ads.zzafg r1 = r0.zzb
            long r8 = r0.zzl
            com.google.android.gms.internal.ads.zzfd r5 = r0.zzc
            r1.zza(r8, r5)
        L_0x01b8:
            r1 = 178(0xb2, float:2.5E-43)
            if (r7 != r1) goto L_0x01cd
            byte[] r5 = r19.zzH()
            int r7 = r4 + 2
            byte r5 = r5[r7]
            r7 = 1
            if (r5 != r7) goto L_0x01cc
            com.google.android.gms.internal.ads.zzaeg r5 = r0.zzf
            r5.zzc(r1)
        L_0x01cc:
            r7 = r1
        L_0x01cd:
            int r1 = r2 - r4
            long r4 = r0.zzh
            com.google.android.gms.internal.ads.zzadv r8 = r0.zzg
            long r9 = (long) r1
            long r4 = r4 - r9
            boolean r9 = r0.zzk
            r8.zzb(r4, r1, r9)
            com.google.android.gms.internal.ads.zzadv r1 = r0.zzg
            long r4 = r0.zzl
            r1.zzc(r7, r4)
            r1 = r17
            goto L_0x002d
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadw.zza(com.google.android.gms.internal.ads.zzfd):void");
    }

    public final void zzb(zzws zzws, zzafd zzafd) {
        zzafd.zzc();
        this.zzi = zzafd.zzb();
        zzxt zzv = zzws.zzv(zzafd.zza(), 2);
        this.zzj = zzv;
        this.zzg = new zzadv(zzv);
        this.zzb.zzb(zzws, zzafd);
    }

    public final void zzc() {
    }

    public final void zzd(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.zzl = j11;
        }
    }

    public final void zze() {
        zzeu.zze(this.zzd);
        this.zze.zzb();
        zzadv zzadv = this.zzg;
        if (zzadv != null) {
            zzadv.zzd();
        }
        this.zzf.zzb();
        this.zzh = 0;
        this.zzl = C.TIME_UNSET;
    }

    public zzadw(@Nullable zzafg zzafg) {
        this.zzb = zzafg;
        this.zzd = new boolean[4];
        this.zze = new zzadu(128);
        this.zzl = C.TIME_UNSET;
        this.zzf = new zzaeg(Opcodes.GETSTATIC, 128);
        this.zzc = new zzfd();
    }
}
