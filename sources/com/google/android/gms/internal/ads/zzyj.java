package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.io.IOException;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zzyj implements zzwp {
    public static final zzww zza = zzyi.zza;
    private final zzfd zzb = new zzfd(4);
    private final zzfd zzc = new zzfd(9);
    private final zzfd zzd = new zzfd(11);
    private final zzfd zze = new zzfd();
    private final zzyk zzf = new zzyk();
    private zzws zzg;
    private int zzh = 1;
    private boolean zzi;
    private long zzj;
    private int zzk;
    private int zzl;
    private int zzm;
    private long zzn;
    private boolean zzo;
    private zzyh zzp;
    private zzyn zzq;

    private final zzfd zze(zzwq zzwq) throws IOException {
        if (this.zzm > this.zze.zzb()) {
            zzfd zzfd = this.zze;
            int zzb2 = zzfd.zzb();
            zzfd.zzD(new byte[Math.max(zzb2 + zzb2, this.zzm)], 0);
        } else {
            this.zze.zzF(0);
        }
        this.zze.zzE(this.zzm);
        ((zzwk) zzwq).zzn(this.zze.zzH(), 0, this.zzm, false);
        return this.zze;
    }

    @RequiresNonNull({"extractorOutput"})
    private final void zzf() {
        if (!this.zzo) {
            this.zzg.zzL(new zzxo(C.TIME_UNSET, 0));
            this.zzo = true;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0055  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00bc  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0009 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzwq r17, com.google.android.gms.internal.ads.zzxm r18) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            com.google.android.gms.internal.ads.zzws r2 = r0.zzg
            com.google.android.gms.internal.ads.zzdy.zzb(r2)
        L_0x0009:
            int r2 = r0.zzh
            r3 = -1
            r4 = 8
            r5 = 9
            r6 = 2
            r7 = 4
            r8 = 0
            r9 = 1
            if (r2 == r9) goto L_0x0122
            r10 = 3
            if (r2 == r6) goto L_0x0114
            if (r2 == r10) goto L_0x00cd
            if (r2 != r7) goto L_0x00c7
            boolean r2 = r0.zzi
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r2 == 0) goto L_0x002c
            long r2 = r0.zzj
            long r14 = r0.zzn
            long r2 = r2 + r14
            goto L_0x003b
        L_0x002c:
            com.google.android.gms.internal.ads.zzyk r2 = r0.zzf
            long r2 = r2.zzc()
            int r2 = (r2 > r12 ? 1 : (r2 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x0039
            r2 = 0
            goto L_0x003b
        L_0x0039:
            long r2 = r0.zzn
        L_0x003b:
            int r14 = r0.zzl
            if (r14 != r4) goto L_0x0052
            com.google.android.gms.internal.ads.zzyh r14 = r0.zzp
            if (r14 == 0) goto L_0x0053
            r16.zzf()
            com.google.android.gms.internal.ads.zzyh r4 = r0.zzp
            com.google.android.gms.internal.ads.zzfd r5 = r16.zze(r17)
            boolean r2 = r4.zzf(r5, r2)
        L_0x0050:
            r3 = r9
            goto L_0x00a6
        L_0x0052:
            r4 = r14
        L_0x0053:
            if (r4 != r5) goto L_0x0067
            com.google.android.gms.internal.ads.zzyn r4 = r0.zzq
            if (r4 == 0) goto L_0x009c
            r16.zzf()
            com.google.android.gms.internal.ads.zzyn r4 = r0.zzq
            com.google.android.gms.internal.ads.zzfd r5 = r16.zze(r17)
            boolean r2 = r4.zzf(r5, r2)
            goto L_0x0050
        L_0x0067:
            r5 = 18
            if (r4 != r5) goto L_0x009c
            boolean r4 = r0.zzo
            if (r4 != 0) goto L_0x009c
            com.google.android.gms.internal.ads.zzyk r4 = r0.zzf
            com.google.android.gms.internal.ads.zzfd r5 = r16.zze(r17)
            boolean r2 = r4.zzf(r5, r2)
            com.google.android.gms.internal.ads.zzyk r3 = r0.zzf
            long r3 = r3.zzc()
            int r5 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r5 == 0) goto L_0x0050
            com.google.android.gms.internal.ads.zzws r5 = r0.zzg
            com.google.android.gms.internal.ads.zzxi r14 = new com.google.android.gms.internal.ads.zzxi
            com.google.android.gms.internal.ads.zzyk r15 = r0.zzf
            long[] r15 = r15.zzd()
            com.google.android.gms.internal.ads.zzyk r10 = r0.zzf
            long[] r10 = r10.zze()
            r14.<init>(r15, r10, r3)
            r5.zzL(r14)
            r0.zzo = r9
            goto L_0x0050
        L_0x009c:
            int r2 = r0.zzm
            r3 = r1
            com.google.android.gms.internal.ads.zzwk r3 = (com.google.android.gms.internal.ads.zzwk) r3
            r3.zzo(r2, r8)
            r2 = r8
            r3 = r2
        L_0x00a6:
            boolean r4 = r0.zzi
            if (r4 != 0) goto L_0x00c0
            if (r2 == 0) goto L_0x00c0
            r0.zzi = r9
            com.google.android.gms.internal.ads.zzyk r2 = r0.zzf
            long r4 = r2.zzc()
            int r2 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x00bc
            long r4 = r0.zzn
            long r10 = -r4
            goto L_0x00be
        L_0x00bc:
            r10 = 0
        L_0x00be:
            r0.zzj = r10
        L_0x00c0:
            r0.zzk = r7
            r0.zzh = r6
            if (r3 == 0) goto L_0x0009
            return r8
        L_0x00c7:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            r1.<init>()
            throw r1
        L_0x00cd:
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzd
            byte[] r2 = r2.zzH()
            r4 = 11
            boolean r2 = r1.zzn(r2, r8, r4, r9)
            if (r2 != 0) goto L_0x00dc
            return r3
        L_0x00dc:
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzd
            r2.zzF(r8)
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzd
            int r2 = r2.zzk()
            r0.zzl = r2
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzd
            int r2 = r2.zzm()
            r0.zzm = r2
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzd
            int r2 = r2.zzm()
            long r2 = (long) r2
            r0.zzn = r2
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzd
            int r2 = r2.zzk()
            int r2 = r2 << 24
            long r2 = (long) r2
            long r4 = r0.zzn
            long r2 = r2 | r4
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 * r4
            r0.zzn = r2
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzd
            r2.zzG(r10)
            r0.zzh = r7
            goto L_0x0009
        L_0x0114:
            int r2 = r0.zzk
            r3 = r1
            com.google.android.gms.internal.ads.zzwk r3 = (com.google.android.gms.internal.ads.zzwk) r3
            r3.zzo(r2, r8)
            r0.zzk = r8
            r0.zzh = r10
            goto L_0x0009
        L_0x0122:
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzc
            byte[] r2 = r2.zzH()
            boolean r2 = r1.zzn(r2, r8, r5, r9)
            if (r2 != 0) goto L_0x012f
            return r3
        L_0x012f:
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzc
            r2.zzF(r8)
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzc
            r2.zzG(r7)
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzc
            int r2 = r2.zzk()
            r3 = r2 & 1
            r2 = r2 & r7
            if (r2 == 0) goto L_0x0155
            com.google.android.gms.internal.ads.zzyh r2 = r0.zzp
            if (r2 != 0) goto L_0x0155
            com.google.android.gms.internal.ads.zzyh r2 = new com.google.android.gms.internal.ads.zzyh
            com.google.android.gms.internal.ads.zzws r7 = r0.zzg
            com.google.android.gms.internal.ads.zzxt r4 = r7.zzv(r4, r9)
            r2.<init>(r4)
            r0.zzp = r2
        L_0x0155:
            if (r3 == 0) goto L_0x0168
            com.google.android.gms.internal.ads.zzyn r2 = r0.zzq
            if (r2 != 0) goto L_0x0168
            com.google.android.gms.internal.ads.zzyn r2 = new com.google.android.gms.internal.ads.zzyn
            com.google.android.gms.internal.ads.zzws r3 = r0.zzg
            com.google.android.gms.internal.ads.zzxt r3 = r3.zzv(r5, r6)
            r2.<init>(r3)
            r0.zzq = r2
        L_0x0168:
            com.google.android.gms.internal.ads.zzws r2 = r0.zzg
            r2.zzB()
            com.google.android.gms.internal.ads.zzfd r2 = r0.zzc
            int r2 = r2.zze()
            int r2 = r2 + -5
            r0.zzk = r2
            r0.zzh = r6
            goto L_0x0009
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzyj.zza(com.google.android.gms.internal.ads.zzwq, com.google.android.gms.internal.ads.zzxm):int");
    }

    public final void zzb(zzws zzws) {
        this.zzg = zzws;
    }

    public final void zzc(long j11, long j12) {
        if (j11 == 0) {
            this.zzh = 1;
            this.zzi = false;
        } else {
            this.zzh = 3;
        }
        this.zzk = 0;
    }

    public final boolean zzd(zzwq zzwq) throws IOException {
        zzwk zzwk = (zzwk) zzwq;
        zzwk.zzm(this.zzb.zzH(), 0, 3, false);
        this.zzb.zzF(0);
        if (this.zzb.zzm() != 4607062) {
            return false;
        }
        zzwk.zzm(this.zzb.zzH(), 0, 2, false);
        this.zzb.zzF(0);
        if ((this.zzb.zzo() & 250) != 0) {
            return false;
        }
        zzwk.zzm(this.zzb.zzH(), 0, 4, false);
        this.zzb.zzF(0);
        int zze2 = this.zzb.zze();
        zzwq.zzj();
        zzwk zzwk2 = (zzwk) zzwq;
        zzwk2.zzl(zze2, false);
        zzwk2.zzm(this.zzb.zzH(), 0, 4, false);
        this.zzb.zzF(0);
        if (this.zzb.zze() == 0) {
            return true;
        }
        return false;
    }
}
