package com.google.android.gms.internal.ads;

import java.io.IOException;

public final class zzafl implements zzwp {
    public static final zzww zza = zzafh.zza;
    private zzws zzb;
    private zzxt zzc;
    private zzafj zzd;
    private int zze = -1;
    private long zzf = -1;

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
        if (r15 != 65534) goto L_0x0058;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0076  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(com.google.android.gms.internal.ads.zzwq r14, com.google.android.gms.internal.ads.zzxm r15) throws java.io.IOException {
        /*
            r13 = this;
            com.google.android.gms.internal.ads.zzxt r15 = r13.zzc
            com.google.android.gms.internal.ads.zzdy.zzb(r15)
            int r15 = com.google.android.gms.internal.ads.zzfn.zza
            com.google.android.gms.internal.ads.zzafj r15 = r13.zzd
            r0 = 1
            r1 = 0
            if (r15 != 0) goto L_0x0098
            com.google.android.gms.internal.ads.zzafm r5 = com.google.android.gms.internal.ads.zzafo.zza(r14)
            if (r5 == 0) goto L_0x0090
            int r15 = r5.zza
            r2 = 17
            if (r15 != r2) goto L_0x0026
            com.google.android.gms.internal.ads.zzafi r15 = new com.google.android.gms.internal.ads.zzafi
            com.google.android.gms.internal.ads.zzws r2 = r13.zzb
            com.google.android.gms.internal.ads.zzxt r3 = r13.zzc
            r15.<init>(r2, r3, r5)
            r13.zzd = r15
            goto L_0x0098
        L_0x0026:
            r2 = 6
            if (r15 != r2) goto L_0x0039
            com.google.android.gms.internal.ads.zzafk r15 = new com.google.android.gms.internal.ads.zzafk
            com.google.android.gms.internal.ads.zzws r3 = r13.zzb
            com.google.android.gms.internal.ads.zzxt r4 = r13.zzc
            java.lang.String r6 = "audio/g711-alaw"
            r7 = -1
            r2 = r15
            r2.<init>(r3, r4, r5, r6, r7)
            r13.zzd = r15
            goto L_0x0098
        L_0x0039:
            r2 = 7
            if (r15 != r2) goto L_0x004c
            com.google.android.gms.internal.ads.zzafk r15 = new com.google.android.gms.internal.ads.zzafk
            com.google.android.gms.internal.ads.zzws r3 = r13.zzb
            com.google.android.gms.internal.ads.zzxt r4 = r13.zzc
            java.lang.String r6 = "audio/g711-mlaw"
            r7 = -1
            r2 = r15
            r2.<init>(r3, r4, r5, r6, r7)
            r13.zzd = r15
            goto L_0x0098
        L_0x004c:
            int r2 = r5.zze
            if (r15 == r0) goto L_0x0060
            r3 = 3
            if (r15 == r3) goto L_0x005a
            r3 = 65534(0xfffe, float:9.1833E-41)
            if (r15 == r3) goto L_0x0060
        L_0x0058:
            r7 = r1
            goto L_0x0065
        L_0x005a:
            r15 = 32
            if (r2 != r15) goto L_0x0058
            r15 = 4
            goto L_0x0064
        L_0x0060:
            int r15 = com.google.android.gms.internal.ads.zzfn.zzl(r2)
        L_0x0064:
            r7 = r15
        L_0x0065:
            if (r7 == 0) goto L_0x0076
            com.google.android.gms.internal.ads.zzafk r15 = new com.google.android.gms.internal.ads.zzafk
            com.google.android.gms.internal.ads.zzws r3 = r13.zzb
            com.google.android.gms.internal.ads.zzxt r4 = r13.zzc
            java.lang.String r6 = "audio/raw"
            r2 = r15
            r2.<init>(r3, r4, r5, r6, r7)
            r13.zzd = r15
            goto L_0x0098
        L_0x0076:
            int r14 = r5.zza
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r0 = 40
            r15.<init>(r0)
            java.lang.String r0 = "Unsupported WAV format type: "
            r15.append(r0)
            r15.append(r14)
            java.lang.String r14 = r15.toString()
            com.google.android.gms.internal.ads.zzbj r14 = com.google.android.gms.internal.ads.zzbj.zzc(r14)
            throw r14
        L_0x0090:
            java.lang.String r14 = "Unsupported or unrecognized wav header."
            r15 = 0
            com.google.android.gms.internal.ads.zzbj r14 = com.google.android.gms.internal.ads.zzbj.zza(r14, r15)
            throw r14
        L_0x0098:
            int r15 = r13.zze
            r2 = -1
            r4 = -1
            if (r15 != r4) goto L_0x016c
            r14.zzj()
            com.google.android.gms.internal.ads.zzfd r15 = new com.google.android.gms.internal.ads.zzfd
            r5 = 8
            r15.<init>((int) r5)
            com.google.android.gms.internal.ads.zzafn r6 = com.google.android.gms.internal.ads.zzafn.zza(r14, r15)
        L_0x00ad:
            int r7 = r6.zza
            r8 = 1684108385(0x64617461, float:1.6635614E22)
            java.lang.String r9 = "WavHeaderReader"
            if (r7 == r8) goto L_0x010c
            r8 = 1380533830(0x52494646, float:2.16116855E11)
            if (r7 == r8) goto L_0x00d6
            r10 = 1718449184(0x666d7420, float:2.8033575E23)
            if (r7 == r10) goto L_0x00d6
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r11 = 39
            r10.<init>(r11)
            java.lang.String r11 = "Ignoring unknown WAV chunk: "
            r10.append(r11)
            r10.append(r7)
            java.lang.String r7 = r10.toString()
            android.util.Log.w(r9, r7)
        L_0x00d6:
            long r9 = r6.zzb
            r11 = 8
            long r9 = r9 + r11
            int r6 = r6.zza
            if (r6 != r8) goto L_0x00e1
            r9 = 12
        L_0x00e1:
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r7 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x00f4
            r6 = r14
            com.google.android.gms.internal.ads.zzwk r6 = (com.google.android.gms.internal.ads.zzwk) r6
            int r7 = (int) r9
            r6.zzo(r7, r1)
            com.google.android.gms.internal.ads.zzafn r6 = com.google.android.gms.internal.ads.zzafn.zza(r14, r15)
            goto L_0x00ad
        L_0x00f4:
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r15 = 51
            r14.<init>(r15)
            java.lang.String r15 = "Chunk is too large (~2GB+) to skip; id: "
            r14.append(r15)
            r14.append(r6)
            java.lang.String r14 = r14.toString()
            com.google.android.gms.internal.ads.zzbj r14 = com.google.android.gms.internal.ads.zzbj.zzc(r14)
            throw r14
        L_0x010c:
            r15 = r14
            com.google.android.gms.internal.ads.zzwk r15 = (com.google.android.gms.internal.ads.zzwk) r15
            r15.zzo(r5, r1)
            long r7 = r14.zze()
            long r5 = r6.zzb
            long r5 = r5 + r7
            long r10 = r14.zzc()
            int r15 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r15 == 0) goto L_0x0144
            int r15 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r15 <= 0) goto L_0x0144
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r12 = 69
            r15.<init>(r12)
            java.lang.String r12 = "Data exceeds input length: "
            r15.append(r12)
            r15.append(r5)
            java.lang.String r5 = ", "
            r15.append(r5)
            r15.append(r10)
            java.lang.String r15 = r15.toString()
            android.util.Log.w(r9, r15)
            r5 = r10
        L_0x0144:
            java.lang.Long r15 = java.lang.Long.valueOf(r7)
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            android.util.Pair r15 = android.util.Pair.create(r15, r5)
            java.lang.Object r5 = r15.first
            java.lang.Long r5 = (java.lang.Long) r5
            int r5 = r5.intValue()
            r13.zze = r5
            java.lang.Object r15 = r15.second
            java.lang.Long r15 = (java.lang.Long) r15
            long r5 = r15.longValue()
            r13.zzf = r5
            com.google.android.gms.internal.ads.zzafj r15 = r13.zzd
            int r7 = r13.zze
            r15.zza(r7, r5)
            goto L_0x017e
        L_0x016c:
            long r5 = r14.zze()
            r7 = 0
            int r15 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r15 != 0) goto L_0x017e
            int r15 = r13.zze
            r5 = r14
            com.google.android.gms.internal.ads.zzwk r5 = (com.google.android.gms.internal.ads.zzwk) r5
            r5.zzo(r15, r1)
        L_0x017e:
            long r5 = r13.zzf
            int r15 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1))
            if (r15 == 0) goto L_0x0185
            goto L_0x0186
        L_0x0185:
            r0 = r1
        L_0x0186:
            com.google.android.gms.internal.ads.zzdy.zzf(r0)
            long r2 = r13.zzf
            long r5 = r14.zze()
            com.google.android.gms.internal.ads.zzafj r15 = r13.zzd
            long r2 = r2 - r5
            boolean r14 = r15.zzc(r14, r2)
            if (r14 == 0) goto L_0x0199
            return r4
        L_0x0199:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzafl.zza(com.google.android.gms.internal.ads.zzwq, com.google.android.gms.internal.ads.zzxm):int");
    }

    public final void zzb(zzws zzws) {
        this.zzb = zzws;
        this.zzc = zzws.zzv(0, 1);
        zzws.zzB();
    }

    public final void zzc(long j11, long j12) {
        zzafj zzafj = this.zzd;
        if (zzafj != null) {
            zzafj.zzb(j12);
        }
    }

    public final boolean zzd(zzwq zzwq) throws IOException {
        return zzafo.zza(zzwq) != null;
    }
}
