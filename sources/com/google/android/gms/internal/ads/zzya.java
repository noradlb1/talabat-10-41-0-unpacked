package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.util.Arrays;

public final class zzya implements zzwp {
    public static final zzww zza = zzxz.zza;
    private static final int[] zzb = {13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
    private static final int[] zzc;
    private static final byte[] zzd = zzfn.zzW("#!AMR\n");
    private static final byte[] zze = zzfn.zzW("#!AMR-WB\n");
    private static final int zzf;
    private final byte[] zzg;
    private boolean zzh;
    private long zzi;
    private int zzj;
    private int zzk;
    private boolean zzl;
    private int zzm;
    private int zzn;
    private long zzo;
    private zzws zzp;
    private zzxt zzq;
    private zzxp zzr;
    private boolean zzs;

    static {
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        zzc = iArr;
        zzf = iArr[8];
    }

    public zzya() {
        this(0);
    }

    public zzya(int i11) {
        this.zzg = new byte[1];
        this.zzm = -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0039 A[Catch:{ EOFException -> 0x0098 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003e A[Catch:{ EOFException -> 0x0098 }] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x004f  */
    @org.checkerframework.checker.nullness.qual.RequiresNonNull({"trackOutput"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zze(com.google.android.gms.internal.ads.zzwq r12) throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.zzk
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L_0x0099
            r12.zzj()     // Catch:{ EOFException -> 0x0098 }
            byte[] r0 = r11.zzg     // Catch:{ EOFException -> 0x0098 }
            r4 = r12
            com.google.android.gms.internal.ads.zzwk r4 = (com.google.android.gms.internal.ads.zzwk) r4     // Catch:{ EOFException -> 0x0098 }
            r4.zzm(r0, r3, r2, r3)     // Catch:{ EOFException -> 0x0098 }
            byte[] r0 = r11.zzg     // Catch:{ EOFException -> 0x0098 }
            byte r0 = r0[r3]     // Catch:{ EOFException -> 0x0098 }
            r4 = r0 & 131(0x83, float:1.84E-43)
            r5 = 0
            if (r4 > 0) goto L_0x0080
            int r0 = r0 >> 3
            r0 = r0 & 15
            boolean r4 = r11.zzh     // Catch:{ EOFException -> 0x0098 }
            if (r4 == 0) goto L_0x002c
            r6 = 10
            if (r0 < r6) goto L_0x0037
            r6 = 13
            if (r0 <= r6) goto L_0x002c
            goto L_0x0037
        L_0x002c:
            if (r4 != 0) goto L_0x0055
            r6 = 12
            if (r0 < r6) goto L_0x0037
            r6 = 14
            if (r0 > r6) goto L_0x0037
            goto L_0x0055
        L_0x0037:
            if (r4 == 0) goto L_0x003e
            int[] r4 = zzc     // Catch:{ EOFException -> 0x0098 }
            r0 = r4[r0]     // Catch:{ EOFException -> 0x0098 }
            goto L_0x0042
        L_0x003e:
            int[] r4 = zzb     // Catch:{ EOFException -> 0x0098 }
            r0 = r4[r0]     // Catch:{ EOFException -> 0x0098 }
        L_0x0042:
            r11.zzj = r0     // Catch:{ EOFException -> 0x0098 }
            r11.zzk = r0
            int r4 = r11.zzm
            if (r4 != r1) goto L_0x004d
            r11.zzm = r0
            r4 = r0
        L_0x004d:
            if (r4 != r0) goto L_0x0099
            int r4 = r11.zzn
            int r4 = r4 + r2
            r11.zzn = r4
            goto L_0x0099
        L_0x0055:
            java.lang.String r12 = "WB"
            java.lang.String r3 = "NB"
            if (r2 == r4) goto L_0x005c
            r12 = r3
        L_0x005c:
            int r2 = r12.length()     // Catch:{ EOFException -> 0x0098 }
            int r2 = r2 + 35
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x0098 }
            r3.<init>(r2)     // Catch:{ EOFException -> 0x0098 }
            java.lang.String r2 = "Illegal AMR "
            r3.append(r2)     // Catch:{ EOFException -> 0x0098 }
            r3.append(r12)     // Catch:{ EOFException -> 0x0098 }
            java.lang.String r12 = " frame type "
            r3.append(r12)     // Catch:{ EOFException -> 0x0098 }
            r3.append(r0)     // Catch:{ EOFException -> 0x0098 }
            java.lang.String r12 = r3.toString()     // Catch:{ EOFException -> 0x0098 }
            com.google.android.gms.internal.ads.zzbj r12 = com.google.android.gms.internal.ads.zzbj.zza(r12, r5)     // Catch:{ EOFException -> 0x0098 }
            throw r12     // Catch:{ EOFException -> 0x0098 }
        L_0x0080:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ EOFException -> 0x0098 }
            r2 = 42
            r12.<init>(r2)     // Catch:{ EOFException -> 0x0098 }
            java.lang.String r2 = "Invalid padding bits for frame header "
            r12.append(r2)     // Catch:{ EOFException -> 0x0098 }
            r12.append(r0)     // Catch:{ EOFException -> 0x0098 }
            java.lang.String r12 = r12.toString()     // Catch:{ EOFException -> 0x0098 }
            com.google.android.gms.internal.ads.zzbj r12 = com.google.android.gms.internal.ads.zzbj.zza(r12, r5)     // Catch:{ EOFException -> 0x0098 }
            throw r12     // Catch:{ EOFException -> 0x0098 }
        L_0x0098:
            return r1
        L_0x0099:
            com.google.android.gms.internal.ads.zzxt r4 = r11.zzq
            int r12 = com.google.android.gms.internal.ads.zzxr.zza(r4, r12, r0, r2)
            if (r12 != r1) goto L_0x00a2
            return r1
        L_0x00a2:
            int r0 = r11.zzk
            int r0 = r0 - r12
            r11.zzk = r0
            if (r0 <= 0) goto L_0x00aa
            return r3
        L_0x00aa:
            com.google.android.gms.internal.ads.zzxt r4 = r11.zzq
            long r5 = r11.zzi
            r7 = 1
            int r8 = r11.zzj
            r9 = 0
            r10 = 0
            r4.zzs(r5, r7, r8, r9, r10)
            long r0 = r11.zzi
            r4 = 20000(0x4e20, double:9.8813E-320)
            long r0 = r0 + r4
            r11.zzi = r0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzya.zze(com.google.android.gms.internal.ads.zzwq):int");
    }

    private static boolean zzf(zzwq zzwq, byte[] bArr) throws IOException {
        zzwq.zzj();
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        ((zzwk) zzwq).zzm(bArr2, 0, length, false);
        return Arrays.equals(bArr2, bArr);
    }

    private final boolean zzg(zzwq zzwq) throws IOException {
        byte[] bArr = zzd;
        if (zzf(zzwq, bArr)) {
            this.zzh = false;
            ((zzwk) zzwq).zzo(bArr.length, false);
            return true;
        }
        byte[] bArr2 = zze;
        if (!zzf(zzwq, bArr2)) {
            return false;
        }
        this.zzh = true;
        ((zzwk) zzwq).zzo(bArr2.length, false);
        return true;
    }

    public final int zza(zzwq zzwq, zzxm zzxm) throws IOException {
        String str;
        int i11;
        zzdy.zzb(this.zzq);
        int i12 = zzfn.zza;
        if (zzwq.zze() != 0 || zzg(zzwq)) {
            if (!this.zzs) {
                this.zzs = true;
                boolean z11 = this.zzh;
                if (true != z11) {
                    str = MimeTypes.AUDIO_AMR_NB;
                } else {
                    str = MimeTypes.AUDIO_AMR_WB;
                }
                if (true != z11) {
                    i11 = 8000;
                } else {
                    i11 = AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND;
                }
                zzxt zzxt = this.zzq;
                zzz zzz = new zzz();
                zzz.zzS(str);
                zzz.zzL(zzf);
                zzz.zzw(1);
                zzz.zzT(i11);
                zzxt.zzk(zzz.zzY());
            }
            int zze2 = zze(zzwq);
            if (this.zzl) {
                return zze2;
            }
            zzxo zzxo = new zzxo(C.TIME_UNSET, 0);
            this.zzr = zzxo;
            this.zzp.zzL(zzxo);
            this.zzl = true;
            return zze2;
        }
        throw zzbj.zza("Could not find AMR header.", (Throwable) null);
    }

    public final void zzb(zzws zzws) {
        this.zzp = zzws;
        this.zzq = zzws.zzv(0, 1);
        zzws.zzB();
    }

    public final void zzc(long j11, long j12) {
        this.zzi = 0;
        this.zzj = 0;
        this.zzk = 0;
        this.zzo = 0;
    }

    public final boolean zzd(zzwq zzwq) throws IOException {
        return zzg(zzwq);
    }
}
