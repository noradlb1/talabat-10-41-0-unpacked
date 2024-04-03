package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.ArrayDeque;

final class zzaaq {
    private final byte[] zza = new byte[8];
    private final ArrayDeque<zzaap> zzb = new ArrayDeque<>();
    private final zzaba zzc = new zzaba();
    private zzaar zzd;
    private int zze;
    private int zzf;
    private long zzg;

    private final long zzd(zzwq zzwq, int i11) throws IOException {
        ((zzwk) zzwq).zzn(this.zza, 0, i11, false);
        long j11 = 0;
        for (int i12 = 0; i12 < i11; i12++) {
            j11 = (j11 << 8) | ((long) (this.zza[i12] & 255));
        }
        return j11;
    }

    public final void zza(zzaar zzaar) {
        this.zzd = zzaar;
    }

    public final void zzb() {
        this.zze = 0;
        this.zzb.clear();
        this.zzc.zze();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0087, code lost:
        if (r0 == 1) goto L_0x0089;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzc(com.google.android.gms.internal.ads.zzwq r13) throws java.io.IOException {
        /*
            r12 = this;
            com.google.android.gms.internal.ads.zzaar r0 = r12.zzd
            com.google.android.gms.internal.ads.zzdy.zzb(r0)
        L_0x0005:
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzaap> r0 = r12.zzb
            java.lang.Object r0 = r0.peek()
            com.google.android.gms.internal.ads.zzaap r0 = (com.google.android.gms.internal.ads.zzaap) r0
            r1 = 1
            if (r0 == 0) goto L_0x0033
            long r2 = r13.zze()
            long r4 = r0.zzb
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 >= 0) goto L_0x001d
            goto L_0x0033
        L_0x001d:
            com.google.android.gms.internal.ads.zzaar r13 = r12.zzd
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzaap> r0 = r12.zzb
            java.lang.Object r0 = r0.pop()
            com.google.android.gms.internal.ads.zzaap r0 = (com.google.android.gms.internal.ads.zzaap) r0
            int r0 = r0.zza
            com.google.android.gms.internal.ads.zzaau r13 = (com.google.android.gms.internal.ads.zzaau) r13
            com.google.android.gms.internal.ads.zzaay r13 = r13.zza
            r13.zzh(r0)
            return r1
        L_0x0033:
            int r0 = r12.zze
            r2 = 2
            r3 = 4
            r4 = 0
            if (r0 != 0) goto L_0x0087
            com.google.android.gms.internal.ads.zzaba r0 = r12.zzc
            long r5 = r0.zzd(r13, r1, r4, r3)
            r7 = -2
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x007a
            r13.zzj()
        L_0x0049:
            byte[] r0 = r12.zza
            r5 = r13
            com.google.android.gms.internal.ads.zzwk r5 = (com.google.android.gms.internal.ads.zzwk) r5
            r5.zzm(r0, r4, r3, r4)
            byte[] r0 = r12.zza
            byte r0 = r0[r4]
            int r0 = com.google.android.gms.internal.ads.zzaba.zzb(r0)
            r6 = -1
            if (r0 == r6) goto L_0x0076
            if (r0 > r3) goto L_0x0076
            byte[] r6 = r12.zza
            long r6 = com.google.android.gms.internal.ads.zzaba.zzc(r6, r0, r4)
            int r6 = (int) r6
            com.google.android.gms.internal.ads.zzaar r7 = r12.zzd
            com.google.android.gms.internal.ads.zzaau r7 = (com.google.android.gms.internal.ads.zzaau) r7
            com.google.android.gms.internal.ads.zzaay r7 = r7.zza
            boolean r7 = com.google.android.gms.internal.ads.zzaay.zzo(r6)
            if (r7 == 0) goto L_0x0076
            r5.zzo(r0, r4)
            long r5 = (long) r6
            goto L_0x007a
        L_0x0076:
            r5.zzo(r1, r4)
            goto L_0x0049
        L_0x007a:
            r7 = -1
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 != 0) goto L_0x0081
            return r4
        L_0x0081:
            int r0 = (int) r5
            r12.zzf = r0
            r12.zze = r1
            goto L_0x0089
        L_0x0087:
            if (r0 != r1) goto L_0x0095
        L_0x0089:
            com.google.android.gms.internal.ads.zzaba r0 = r12.zzc
            r5 = 8
            long r5 = r0.zzd(r13, r4, r1, r5)
            r12.zzg = r5
            r12.zze = r2
        L_0x0095:
            com.google.android.gms.internal.ads.zzaar r0 = r12.zzd
            int r5 = r12.zzf
            com.google.android.gms.internal.ads.zzaau r0 = (com.google.android.gms.internal.ads.zzaau) r0
            com.google.android.gms.internal.ads.zzaay r0 = r0.zza
            int r0 = com.google.android.gms.internal.ads.zzaay.zzn(r5)
            if (r0 == 0) goto L_0x01a4
            r5 = 0
            if (r0 == r1) goto L_0x0181
            r6 = 8
            if (r0 == r2) goto L_0x0150
            r2 = 3
            if (r0 == r2) goto L_0x0105
            if (r0 == r3) goto L_0x00f4
            long r8 = r12.zzg
            r10 = 4
            int r0 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r0 == 0) goto L_0x00d4
            int r0 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r0 != 0) goto L_0x00bc
            goto L_0x00d4
        L_0x00bc:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r0 = 40
            r13.<init>(r0)
            java.lang.String r0 = "Invalid float size: "
            r13.append(r0)
            r13.append(r8)
            java.lang.String r13 = r13.toString()
            com.google.android.gms.internal.ads.zzbj r13 = com.google.android.gms.internal.ads.zzbj.zza(r13, r5)
            throw r13
        L_0x00d4:
            com.google.android.gms.internal.ads.zzaar r0 = r12.zzd
            int r2 = r12.zzf
            int r5 = (int) r8
            long r6 = r12.zzd(r13, r5)
            if (r5 != r3) goto L_0x00e6
            int r13 = (int) r6
            float r13 = java.lang.Float.intBitsToFloat(r13)
            double r5 = (double) r13
            goto L_0x00ea
        L_0x00e6:
            double r5 = java.lang.Double.longBitsToDouble(r6)
        L_0x00ea:
            com.google.android.gms.internal.ads.zzaau r0 = (com.google.android.gms.internal.ads.zzaau) r0
            com.google.android.gms.internal.ads.zzaay r13 = r0.zza
            r13.zzi(r2, r5)
            r12.zze = r4
            return r1
        L_0x00f4:
            com.google.android.gms.internal.ads.zzaar r0 = r12.zzd
            int r2 = r12.zzf
            long r5 = r12.zzg
            com.google.android.gms.internal.ads.zzaau r0 = (com.google.android.gms.internal.ads.zzaau) r0
            com.google.android.gms.internal.ads.zzaay r0 = r0.zza
            int r3 = (int) r5
            r0.zzg(r2, r3, r13)
            r12.zze = r4
            return r1
        L_0x0105:
            long r2 = r12.zzg
            r6 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 > 0) goto L_0x0138
            com.google.android.gms.internal.ads.zzaar r0 = r12.zzd
            int r5 = r12.zzf
            int r2 = (int) r2
            if (r2 != 0) goto L_0x0118
            java.lang.String r13 = ""
            goto L_0x012e
        L_0x0118:
            byte[] r3 = new byte[r2]
            com.google.android.gms.internal.ads.zzwk r13 = (com.google.android.gms.internal.ads.zzwk) r13
            r13.zzn(r3, r4, r2, r4)
        L_0x011f:
            if (r2 <= 0) goto L_0x0129
            int r13 = r2 + -1
            byte r6 = r3[r13]
            if (r6 != 0) goto L_0x0129
            r2 = r13
            goto L_0x011f
        L_0x0129:
            java.lang.String r13 = new java.lang.String
            r13.<init>(r3, r4, r2)
        L_0x012e:
            com.google.android.gms.internal.ads.zzaau r0 = (com.google.android.gms.internal.ads.zzaau) r0
            com.google.android.gms.internal.ads.zzaay r0 = r0.zza
            r0.zzl(r5, r13)
            r12.zze = r4
            return r1
        L_0x0138:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r0 = 41
            r13.<init>(r0)
            java.lang.String r0 = "String element size: "
            r13.append(r0)
            r13.append(r2)
            java.lang.String r13 = r13.toString()
            com.google.android.gms.internal.ads.zzbj r13 = com.google.android.gms.internal.ads.zzbj.zza(r13, r5)
            throw r13
        L_0x0150:
            long r2 = r12.zzg
            int r0 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r0 > 0) goto L_0x0169
            com.google.android.gms.internal.ads.zzaar r0 = r12.zzd
            int r5 = r12.zzf
            int r2 = (int) r2
            long r2 = r12.zzd(r13, r2)
            com.google.android.gms.internal.ads.zzaau r0 = (com.google.android.gms.internal.ads.zzaau) r0
            com.google.android.gms.internal.ads.zzaay r13 = r0.zza
            r13.zzj(r5, r2)
            r12.zze = r4
            return r1
        L_0x0169:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r0 = 42
            r13.<init>(r0)
            java.lang.String r0 = "Invalid integer size: "
            r13.append(r0)
            r13.append(r2)
            java.lang.String r13 = r13.toString()
            com.google.android.gms.internal.ads.zzbj r13 = com.google.android.gms.internal.ads.zzbj.zza(r13, r5)
            throw r13
        L_0x0181:
            long r7 = r13.zze()
            long r2 = r12.zzg
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzaap> r13 = r12.zzb
            com.google.android.gms.internal.ads.zzaap r0 = new com.google.android.gms.internal.ads.zzaap
            int r6 = r12.zzf
            long r2 = r2 + r7
            r0.<init>(r6, r2, r5)
            r13.push(r0)
            com.google.android.gms.internal.ads.zzaar r13 = r12.zzd
            int r6 = r12.zzf
            long r9 = r12.zzg
            com.google.android.gms.internal.ads.zzaau r13 = (com.google.android.gms.internal.ads.zzaau) r13
            com.google.android.gms.internal.ads.zzaay r5 = r13.zza
            r5.zzk(r6, r7, r9)
            r12.zze = r4
            return r1
        L_0x01a4:
            long r0 = r12.zzg
            r2 = r13
            com.google.android.gms.internal.ads.zzwk r2 = (com.google.android.gms.internal.ads.zzwk) r2
            int r0 = (int) r0
            r2.zzo(r0, r4)
            r12.zze = r4
            goto L_0x0005
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaaq.zzc(com.google.android.gms.internal.ads.zzwq):boolean");
    }
}
