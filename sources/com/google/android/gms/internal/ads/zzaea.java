package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zzaea implements zzadr {
    private final zzaes zza;
    private final zzaeg zzb = new zzaeg(7, 128);
    private final zzaeg zzc = new zzaeg(8, 128);
    private final zzaeg zzd = new zzaeg(6, 128);
    private long zze;
    private final boolean[] zzf = new boolean[3];
    private String zzg;
    private zzxt zzh;
    private zzadz zzi;
    private boolean zzj;
    private long zzk = C.TIME_UNSET;
    private boolean zzl;
    private final zzfd zzm = new zzfd();

    public zzaea(zzaes zzaes, boolean z11, boolean z12) {
        this.zza = zzaes;
    }

    @RequiresNonNull({"sampleReader"})
    private final void zzf(byte[] bArr, int i11, int i12) {
        if (!this.zzj) {
            this.zzb.zza(bArr, i11, i12);
            this.zzc.zza(bArr, i11, i12);
        }
        this.zzd.zza(bArr, i11, i12);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0172  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x017b  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0185 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzfd r20) {
        /*
            r19 = this;
            r0 = r19
            com.google.android.gms.internal.ads.zzxt r1 = r0.zzh
            com.google.android.gms.internal.ads.zzdy.zzb(r1)
            int r1 = com.google.android.gms.internal.ads.zzfn.zza
            int r1 = r20.zzc()
            int r2 = r20.zzd()
            byte[] r3 = r20.zzH()
            long r4 = r0.zze
            int r6 = r20.zza()
            long r6 = (long) r6
            long r4 = r4 + r6
            r0.zze = r4
            com.google.android.gms.internal.ads.zzxt r4 = r0.zzh
            int r5 = r20.zza()
            r6 = r20
            com.google.android.gms.internal.ads.zzxr.zzb(r4, r6, r5)
        L_0x002a:
            boolean[] r4 = r0.zzf
            int r4 = com.google.android.gms.internal.ads.zzeu.zza(r3, r1, r2, r4)
            if (r4 == r2) goto L_0x0195
            int r5 = r4 + 3
            byte r6 = r3[r5]
            r10 = r6 & 31
            int r6 = r4 - r1
            if (r6 <= 0) goto L_0x003f
            r0.zzf(r3, r1, r4)
        L_0x003f:
            int r14 = r2 - r4
            long r7 = r0.zze
            long r11 = (long) r14
            long r8 = r7 - r11
            if (r6 >= 0) goto L_0x004a
            int r4 = -r6
            goto L_0x004b
        L_0x004a:
            r4 = 0
        L_0x004b:
            long r6 = r0.zzk
            boolean r11 = r0.zzj
            r12 = 4
            if (r11 == 0) goto L_0x0058
        L_0x0052:
            r18 = r2
            r17 = r5
            goto L_0x013b
        L_0x0058:
            com.google.android.gms.internal.ads.zzaeg r11 = r0.zzb
            r11.zzd(r4)
            com.google.android.gms.internal.ads.zzaeg r11 = r0.zzc
            r11.zzd(r4)
            boolean r11 = r0.zzj
            if (r11 != 0) goto L_0x00fc
            com.google.android.gms.internal.ads.zzaeg r11 = r0.zzb
            boolean r11 = r11.zze()
            if (r11 == 0) goto L_0x0052
            com.google.android.gms.internal.ads.zzaeg r11 = r0.zzc
            boolean r11 = r11.zze()
            if (r11 == 0) goto L_0x0052
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            com.google.android.gms.internal.ads.zzaeg r13 = r0.zzb
            byte[] r15 = r13.zza
            int r13 = r13.zzb
            byte[] r13 = java.util.Arrays.copyOf(r15, r13)
            r11.add(r13)
            com.google.android.gms.internal.ads.zzaeg r13 = r0.zzc
            byte[] r15 = r13.zza
            int r13 = r13.zzb
            byte[] r13 = java.util.Arrays.copyOf(r15, r13)
            r11.add(r13)
            com.google.android.gms.internal.ads.zzaeg r13 = r0.zzb
            byte[] r15 = r13.zza
            int r13 = r13.zzb
            com.google.android.gms.internal.ads.zzet r13 = com.google.android.gms.internal.ads.zzeu.zzd(r15, r12, r13)
            com.google.android.gms.internal.ads.zzaeg r15 = r0.zzc
            byte[] r1 = r15.zza
            int r15 = r15.zzb
            com.google.android.gms.internal.ads.zzes r1 = com.google.android.gms.internal.ads.zzeu.zzc(r1, r12, r15)
            int r15 = r13.zza
            int r12 = r13.zzb
            r17 = r5
            int r5 = r13.zzc
            java.lang.String r5 = com.google.android.gms.internal.ads.zzea.zza(r15, r12, r5)
            com.google.android.gms.internal.ads.zzxt r12 = r0.zzh
            com.google.android.gms.internal.ads.zzz r15 = new com.google.android.gms.internal.ads.zzz
            r15.<init>()
            r18 = r2
            java.lang.String r2 = r0.zzg
            r15.zzH(r2)
            java.lang.String r2 = "video/avc"
            r15.zzS(r2)
            r15.zzx(r5)
            int r2 = r13.zze
            r15.zzX(r2)
            int r2 = r13.zzf
            r15.zzF(r2)
            float r2 = r13.zzg
            r15.zzP(r2)
            r15.zzI(r11)
            com.google.android.gms.internal.ads.zzab r2 = r15.zzY()
            r12.zzk(r2)
            r2 = 1
            r0.zzj = r2
            com.google.android.gms.internal.ads.zzadz r2 = r0.zzi
            r2.zzb(r13)
            com.google.android.gms.internal.ads.zzadz r2 = r0.zzi
            r2.zza(r1)
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzb
            r1.zzb()
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzc
            r1.zzb()
            goto L_0x013b
        L_0x00fc:
            r18 = r2
            r17 = r5
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzb
            boolean r1 = r1.zze()
            if (r1 == 0) goto L_0x011e
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzb
            byte[] r2 = r1.zza
            int r1 = r1.zzb
            r5 = 4
            com.google.android.gms.internal.ads.zzet r1 = com.google.android.gms.internal.ads.zzeu.zzd(r2, r5, r1)
            com.google.android.gms.internal.ads.zzadz r2 = r0.zzi
            r2.zzb(r1)
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzb
            r1.zzb()
            goto L_0x013b
        L_0x011e:
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzc
            boolean r1 = r1.zze()
            if (r1 == 0) goto L_0x013b
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzc
            byte[] r2 = r1.zza
            int r1 = r1.zzb
            r5 = 4
            com.google.android.gms.internal.ads.zzes r1 = com.google.android.gms.internal.ads.zzeu.zzc(r2, r5, r1)
            com.google.android.gms.internal.ads.zzadz r2 = r0.zzi
            r2.zza(r1)
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzc
            r1.zzb()
        L_0x013b:
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzd
            boolean r1 = r1.zzd(r4)
            if (r1 == 0) goto L_0x0163
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzd
            byte[] r2 = r1.zza
            int r1 = r1.zzb
            int r1 = com.google.android.gms.internal.ads.zzeu.zzb(r2, r1)
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzm
            com.google.android.gms.internal.ads.zzaeg r4 = r0.zzd
            byte[] r4 = r4.zza
            r2.zzD(r4, r1)
            com.google.android.gms.internal.ads.zzfd r1 = r0.zzm
            r2 = 4
            r1.zzF(r2)
            com.google.android.gms.internal.ads.zzaes r1 = r0.zza
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzm
            r1.zza(r6, r2)
        L_0x0163:
            com.google.android.gms.internal.ads.zzadz r11 = r0.zzi
            boolean r15 = r0.zzj
            boolean r1 = r0.zzl
            r12 = r8
            r16 = r1
            boolean r1 = r11.zze(r12, r14, r15, r16)
            if (r1 == 0) goto L_0x0175
            r1 = 0
            r0.zzl = r1
        L_0x0175:
            long r11 = r0.zzk
            boolean r1 = r0.zzj
            if (r1 != 0) goto L_0x0185
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzb
            r1.zzc(r10)
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzc
            r1.zzc(r10)
        L_0x0185:
            com.google.android.gms.internal.ads.zzaeg r1 = r0.zzd
            r1.zzc(r10)
            com.google.android.gms.internal.ads.zzadz r7 = r0.zzi
            r7.zzd(r8, r10, r11)
            r1 = r17
            r2 = r18
            goto L_0x002a
        L_0x0195:
            r0.zzf(r3, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaea.zza(com.google.android.gms.internal.ads.zzfd):void");
    }

    public final void zzb(zzws zzws, zzafd zzafd) {
        zzafd.zzc();
        this.zzg = zzafd.zzb();
        zzxt zzv = zzws.zzv(zzafd.zza(), 2);
        this.zzh = zzv;
        this.zzi = new zzadz(zzv, false, false);
        this.zza.zzb(zzws, zzafd);
    }

    public final void zzc() {
    }

    public final void zzd(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.zzk = j11;
        }
        this.zzl |= (i11 & 2) != 0;
    }

    public final void zze() {
        this.zze = 0;
        this.zzl = false;
        this.zzk = C.TIME_UNSET;
        zzeu.zze(this.zzf);
        this.zzb.zzb();
        this.zzc.zzb();
        this.zzd.zzb();
        zzadz zzadz = this.zzi;
        if (zzadz != null) {
            zzadz.zzc();
        }
    }
}
