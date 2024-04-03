package com.google.android.gms.internal.ads;

import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.google.common.base.Ascii;
import java.io.IOException;

public final class zzaep implements zzwp {
    public static final zzww zza = zzaen.zza;
    private final zzfk zzb = new zzfk(0);
    private final SparseArray<zzaeo> zzc = new SparseArray<>();
    private final zzfd zzd = new zzfd(4096);
    private final zzaem zze = new zzaem();
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private long zzi;
    @Nullable
    private zzael zzj;
    private zzws zzk;
    private boolean zzl;

    /* JADX WARNING: Removed duplicated region for block: B:59:0x014f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzwq r14, com.google.android.gms.internal.ads.zzxm r15) throws java.io.IOException {
        /*
            r13 = this;
            com.google.android.gms.internal.ads.zzws r0 = r13.zzk
            com.google.android.gms.internal.ads.zzdy.zzb(r0)
            long r7 = r14.zzc()
            r9 = -1
            int r0 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r0 == 0) goto L_0x001f
            com.google.android.gms.internal.ads.zzaem r1 = r13.zze
            boolean r1 = r1.zze()
            if (r1 == 0) goto L_0x0018
            goto L_0x001f
        L_0x0018:
            com.google.android.gms.internal.ads.zzaem r0 = r13.zze
            int r14 = r0.zza(r14, r15)
            return r14
        L_0x001f:
            boolean r1 = r13.zzl
            r11 = 1
            if (r1 != 0) goto L_0x0066
            r13.zzl = r11
            com.google.android.gms.internal.ads.zzaem r1 = r13.zze
            long r1 = r1.zzb()
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 == 0) goto L_0x0054
            com.google.android.gms.internal.ads.zzael r12 = new com.google.android.gms.internal.ads.zzael
            com.google.android.gms.internal.ads.zzaem r1 = r13.zze
            com.google.android.gms.internal.ads.zzfk r2 = r1.zzd()
            com.google.android.gms.internal.ads.zzaem r1 = r13.zze
            long r3 = r1.zzb()
            r1 = r12
            r5 = r7
            r1.<init>(r2, r3, r5)
            r13.zzj = r12
            com.google.android.gms.internal.ads.zzws r1 = r13.zzk
            com.google.android.gms.internal.ads.zzxp r2 = r12.zzb()
            r1.zzL(r2)
            goto L_0x0066
        L_0x0054:
            com.google.android.gms.internal.ads.zzws r1 = r13.zzk
            com.google.android.gms.internal.ads.zzxo r2 = new com.google.android.gms.internal.ads.zzxo
            com.google.android.gms.internal.ads.zzaem r3 = r13.zze
            long r3 = r3.zzb()
            r5 = 0
            r2.<init>(r3, r5)
            r1.zzL(r2)
        L_0x0066:
            com.google.android.gms.internal.ads.zzael r1 = r13.zzj
            if (r1 == 0) goto L_0x0078
            boolean r1 = r1.zze()
            if (r1 != 0) goto L_0x0071
            goto L_0x0078
        L_0x0071:
            com.google.android.gms.internal.ads.zzael r0 = r13.zzj
            int r14 = r0.zza(r14, r15)
            return r14
        L_0x0078:
            r14.zzj()
            if (r0 == 0) goto L_0x0083
            long r0 = r14.zzd()
            long r7 = r7 - r0
            goto L_0x0084
        L_0x0083:
            r7 = r9
        L_0x0084:
            int r15 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            r0 = -1
            if (r15 == 0) goto L_0x0091
            r1 = 4
            int r15 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r15 < 0) goto L_0x0090
            goto L_0x0091
        L_0x0090:
            return r0
        L_0x0091:
            com.google.android.gms.internal.ads.zzfd r15 = r13.zzd
            byte[] r15 = r15.zzH()
            r1 = 4
            r2 = 0
            boolean r15 = r14.zzm(r15, r2, r1, r11)
            if (r15 != 0) goto L_0x00a0
            return r0
        L_0x00a0:
            com.google.android.gms.internal.ads.zzfd r15 = r13.zzd
            r15.zzF(r2)
            com.google.android.gms.internal.ads.zzfd r15 = r13.zzd
            int r15 = r15.zze()
            r1 = 441(0x1b9, float:6.18E-43)
            if (r15 != r1) goto L_0x00b0
            return r0
        L_0x00b0:
            r0 = 442(0x1ba, float:6.2E-43)
            if (r15 != r0) goto L_0x00d6
            com.google.android.gms.internal.ads.zzfd r15 = r13.zzd
            byte[] r15 = r15.zzH()
            com.google.android.gms.internal.ads.zzwk r14 = (com.google.android.gms.internal.ads.zzwk) r14
            r0 = 10
            r14.zzm(r15, r2, r0, r2)
            com.google.android.gms.internal.ads.zzfd r15 = r13.zzd
            r0 = 9
            r15.zzF(r0)
            com.google.android.gms.internal.ads.zzfd r15 = r13.zzd
            int r15 = r15.zzk()
            r15 = r15 & 7
            int r15 = r15 + 14
            r14.zzo(r15, r2)
            return r2
        L_0x00d6:
            r0 = 443(0x1bb, float:6.21E-43)
            r1 = 2
            r3 = 6
            if (r15 != r0) goto L_0x00f7
            com.google.android.gms.internal.ads.zzfd r15 = r13.zzd
            byte[] r15 = r15.zzH()
            com.google.android.gms.internal.ads.zzwk r14 = (com.google.android.gms.internal.ads.zzwk) r14
            r14.zzm(r15, r2, r1, r2)
            com.google.android.gms.internal.ads.zzfd r15 = r13.zzd
            r15.zzF(r2)
            com.google.android.gms.internal.ads.zzfd r15 = r13.zzd
            int r15 = r15.zzo()
            int r15 = r15 + r3
            r14.zzo(r15, r2)
            return r2
        L_0x00f7:
            int r0 = r15 >> 8
            if (r0 == r11) goto L_0x0101
            com.google.android.gms.internal.ads.zzwk r14 = (com.google.android.gms.internal.ads.zzwk) r14
            r14.zzo(r11, r2)
            return r2
        L_0x0101:
            r15 = r15 & 255(0xff, float:3.57E-43)
            android.util.SparseArray<com.google.android.gms.internal.ads.zzaeo> r0 = r13.zzc
            java.lang.Object r0 = r0.get(r15)
            com.google.android.gms.internal.ads.zzaeo r0 = (com.google.android.gms.internal.ads.zzaeo) r0
            boolean r4 = r13.zzf
            if (r4 != 0) goto L_0x0188
            if (r0 != 0) goto L_0x0169
            r4 = 189(0xbd, float:2.65E-43)
            r5 = 0
            if (r15 != r4) goto L_0x0125
            com.google.android.gms.internal.ads.zzadh r4 = new com.google.android.gms.internal.ads.zzadh
            r4.<init>(r5)
            r13.zzg = r11
            long r5 = r14.zze()
            r13.zzi = r5
        L_0x0123:
            r5 = r4
            goto L_0x014d
        L_0x0125:
            r4 = r15 & 224(0xe0, float:3.14E-43)
            r6 = 192(0xc0, float:2.69E-43)
            if (r4 != r6) goto L_0x0139
            com.google.android.gms.internal.ads.zzaef r4 = new com.google.android.gms.internal.ads.zzaef
            r4.<init>(r5)
            r13.zzg = r11
            long r5 = r14.zze()
            r13.zzi = r5
            goto L_0x0123
        L_0x0139:
            r4 = r15 & 240(0xf0, float:3.36E-43)
            r6 = 224(0xe0, float:3.14E-43)
            if (r4 != r6) goto L_0x014d
            com.google.android.gms.internal.ads.zzadt r4 = new com.google.android.gms.internal.ads.zzadt
            r4.<init>(r5)
            r13.zzh = r11
            long r5 = r14.zze()
            r13.zzi = r5
            goto L_0x0123
        L_0x014d:
            if (r5 == 0) goto L_0x0169
            com.google.android.gms.internal.ads.zzafd r0 = new com.google.android.gms.internal.ads.zzafd
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = 256(0x100, float:3.59E-43)
            r0.<init>(r4, r15, r6)
            com.google.android.gms.internal.ads.zzws r4 = r13.zzk
            r5.zzb(r4, r0)
            com.google.android.gms.internal.ads.zzaeo r0 = new com.google.android.gms.internal.ads.zzaeo
            com.google.android.gms.internal.ads.zzfk r4 = r13.zzb
            r0.<init>(r5, r4)
            android.util.SparseArray<com.google.android.gms.internal.ads.zzaeo> r4 = r13.zzc
            r4.put(r15, r0)
        L_0x0169:
            boolean r15 = r13.zzg
            r4 = 1048576(0x100000, double:5.180654E-318)
            if (r15 == 0) goto L_0x0179
            boolean r15 = r13.zzh
            if (r15 == 0) goto L_0x0179
            long r4 = r13.zzi
            r6 = 8192(0x2000, double:4.0474E-320)
            long r4 = r4 + r6
        L_0x0179:
            long r6 = r14.zze()
            int r15 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r15 <= 0) goto L_0x0188
            r13.zzf = r11
            com.google.android.gms.internal.ads.zzws r15 = r13.zzk
            r15.zzB()
        L_0x0188:
            com.google.android.gms.internal.ads.zzfd r15 = r13.zzd
            byte[] r15 = r15.zzH()
            com.google.android.gms.internal.ads.zzwk r14 = (com.google.android.gms.internal.ads.zzwk) r14
            r14.zzm(r15, r2, r1, r2)
            com.google.android.gms.internal.ads.zzfd r15 = r13.zzd
            r15.zzF(r2)
            com.google.android.gms.internal.ads.zzfd r15 = r13.zzd
            int r15 = r15.zzo()
            int r15 = r15 + r3
            if (r0 != 0) goto L_0x01a5
            r14.zzo(r15, r2)
            goto L_0x01c6
        L_0x01a5:
            com.google.android.gms.internal.ads.zzfd r1 = r13.zzd
            r1.zzC(r15)
            com.google.android.gms.internal.ads.zzfd r1 = r13.zzd
            byte[] r1 = r1.zzH()
            r14.zzn(r1, r2, r15, r2)
            com.google.android.gms.internal.ads.zzfd r14 = r13.zzd
            r14.zzF(r3)
            com.google.android.gms.internal.ads.zzfd r14 = r13.zzd
            r0.zza(r14)
            com.google.android.gms.internal.ads.zzfd r14 = r13.zzd
            int r15 = r14.zzb()
            r14.zzE(r15)
        L_0x01c6:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaep.zza(com.google.android.gms.internal.ads.zzwq, com.google.android.gms.internal.ads.zzxm):int");
    }

    public final void zzb(zzws zzws) {
        this.zzk = zzws;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0021, code lost:
        if (r3 != r5) goto L_0x0023;
     */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038 A[LOOP:0: B:12:0x0030->B:14:0x0038, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzc(long r3, long r5) {
        /*
            r2 = this;
            com.google.android.gms.internal.ads.zzfk r3 = r2.zzb
            long r3 = r3.zze()
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.ads.zzfk r3 = r2.zzb
            long r3 = r3.zzc()
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x0028
            r0 = 0
            int r0 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x0028
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 == 0) goto L_0x0028
        L_0x0023:
            com.google.android.gms.internal.ads.zzfk r3 = r2.zzb
            r3.zzf(r5)
        L_0x0028:
            com.google.android.gms.internal.ads.zzael r3 = r2.zzj
            r4 = 0
            if (r3 == 0) goto L_0x0030
            r3.zzd(r5)
        L_0x0030:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzaeo> r3 = r2.zzc
            int r3 = r3.size()
            if (r4 >= r3) goto L_0x0046
            android.util.SparseArray<com.google.android.gms.internal.ads.zzaeo> r3 = r2.zzc
            java.lang.Object r3 = r3.valueAt(r4)
            com.google.android.gms.internal.ads.zzaeo r3 = (com.google.android.gms.internal.ads.zzaeo) r3
            r3.zzb()
            int r4 = r4 + 1
            goto L_0x0030
        L_0x0046:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaep.zzc(long, long):void");
    }

    public final boolean zzd(zzwq zzwq) throws IOException {
        byte[] bArr = new byte[14];
        zzwk zzwk = (zzwk) zzwq;
        zzwk.zzm(bArr, 0, 14, false);
        if ((((bArr[0] & 255) << Ascii.CAN) | ((bArr[1] & 255) << Ascii.DLE) | ((bArr[2] & 255) << 8) | (bArr[3] & 255)) != 442 || (bArr[4] & 196) != 68 || (bArr[6] & 4) != 4 || (bArr[8] & 4) != 4 || (bArr[9] & 1) != 1 || (bArr[12] & 3) != 3) {
            return false;
        }
        zzwk.zzl(bArr[13] & 7, false);
        zzwk.zzm(bArr, 0, 3, false);
        if ((((bArr[0] & 255) << Ascii.DLE) | ((bArr[1] & 255) << 8) | (bArr[2] & 255)) == 1) {
            return true;
        }
        return false;
    }
}
