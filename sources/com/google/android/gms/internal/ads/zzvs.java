package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.audio.OpusUtil;

public final class zzvs {
    public static final /* synthetic */ int zza = 0;
    private static final int[] zzb = {96000, 88200, 64000, OpusUtil.SAMPLE_RATE, 44100, 32000, 24000, 22050, AacUtil.AAC_HE_V1_MAX_RATE_BYTES_PER_SECOND, 12000, 11025, 8000, 7350};
    private static final int[] zzc = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static zzvr zza(byte[] bArr) throws zzbj {
        return zzb(new zzfc(bArr, bArr.length), false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ba, code lost:
        if (r12 != 3) goto L_0x00dc;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0097  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.internal.ads.zzvr zzb(com.google.android.gms.internal.ads.zzfc r12, boolean r13) throws com.google.android.gms.internal.ads.zzbj {
        /*
            int r0 = zzc(r12)
            int r1 = zzd(r12)
            r2 = 4
            int r3 = r12.zzc(r2)
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r5 = 19
            r4.<init>(r5)
            java.lang.String r6 = "mp4a.40."
            r4.append(r6)
            r4.append(r0)
            java.lang.String r4 = r4.toString()
            r6 = 5
            r7 = 22
            if (r0 == r6) goto L_0x0029
            r6 = 29
            if (r0 != r6) goto L_0x0037
        L_0x0029:
            int r1 = zzd(r12)
            int r0 = zzc(r12)
            if (r0 != r7) goto L_0x0037
            int r3 = r12.zzc(r2)
        L_0x0037:
            if (r13 == 0) goto L_0x00dc
            r13 = 17
            r6 = 6
            r8 = 1
            r9 = 2
            r10 = 3
            if (r0 == r8) goto L_0x0069
            if (r0 == r9) goto L_0x0069
            if (r0 == r10) goto L_0x0069
            if (r0 == r2) goto L_0x0069
            if (r0 == r6) goto L_0x0069
            r2 = 7
            if (r0 == r2) goto L_0x0069
            if (r0 == r13) goto L_0x0069
            switch(r0) {
                case 19: goto L_0x0069;
                case 20: goto L_0x0069;
                case 21: goto L_0x0069;
                case 22: goto L_0x0069;
                case 23: goto L_0x0069;
                default: goto L_0x0051;
            }
        L_0x0051:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r13 = 42
            r12.<init>(r13)
            java.lang.String r13 = "Unsupported audio object type: "
            r12.append(r13)
            r12.append(r0)
            java.lang.String r12 = r12.toString()
            com.google.android.gms.internal.ads.zzbj r12 = com.google.android.gms.internal.ads.zzbj.zzc(r12)
            throw r12
        L_0x0069:
            boolean r2 = r12.zzl()
            if (r2 == 0) goto L_0x0076
            java.lang.String r2 = "AacUtil"
            java.lang.String r11 = "Unexpected frameLengthFlag = 1"
            android.util.Log.w(r2, r11)
        L_0x0076:
            boolean r2 = r12.zzl()
            if (r2 == 0) goto L_0x0081
            r2 = 14
            r12.zzj(r2)
        L_0x0081:
            boolean r2 = r12.zzl()
            if (r3 == 0) goto L_0x00d6
            r11 = 20
            if (r0 == r6) goto L_0x0091
            if (r0 != r11) goto L_0x008f
            r0 = r11
            goto L_0x0091
        L_0x008f:
            r6 = r0
            goto L_0x0095
        L_0x0091:
            r6 = r0
            r12.zzj(r10)
        L_0x0095:
            if (r2 == 0) goto L_0x00b0
            if (r0 != r7) goto L_0x009f
            r0 = 16
            r12.zzj(r0)
            goto L_0x00a0
        L_0x009f:
            r7 = r0
        L_0x00a0:
            if (r7 == r13) goto L_0x00aa
            if (r7 == r5) goto L_0x00aa
            if (r7 == r11) goto L_0x00aa
            r13 = 23
            if (r7 != r13) goto L_0x00ad
        L_0x00aa:
            r12.zzj(r10)
        L_0x00ad:
            r12.zzj(r8)
        L_0x00b0:
            switch(r6) {
                case 17: goto L_0x00b4;
                case 18: goto L_0x00b3;
                case 19: goto L_0x00b4;
                case 20: goto L_0x00b4;
                case 21: goto L_0x00b4;
                case 22: goto L_0x00b4;
                case 23: goto L_0x00b4;
                default: goto L_0x00b3;
            }
        L_0x00b3:
            goto L_0x00dc
        L_0x00b4:
            int r12 = r12.zzc(r9)
            if (r12 == r9) goto L_0x00bd
            if (r12 == r10) goto L_0x00be
            goto L_0x00dc
        L_0x00bd:
            r10 = r12
        L_0x00be:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r13 = 33
            r12.<init>(r13)
            java.lang.String r13 = "Unsupported epConfig: "
            r12.append(r13)
            r12.append(r10)
            java.lang.String r12 = r12.toString()
            com.google.android.gms.internal.ads.zzbj r12 = com.google.android.gms.internal.ads.zzbj.zzc(r12)
            throw r12
        L_0x00d6:
            java.lang.UnsupportedOperationException r12 = new java.lang.UnsupportedOperationException
            r12.<init>()
            throw r12
        L_0x00dc:
            int[] r12 = zzc
            r12 = r12[r3]
            r13 = -1
            r0 = 0
            if (r12 == r13) goto L_0x00ea
            com.google.android.gms.internal.ads.zzvr r13 = new com.google.android.gms.internal.ads.zzvr
            r13.<init>(r1, r12, r4, r0)
            return r13
        L_0x00ea:
            com.google.android.gms.internal.ads.zzbj r12 = com.google.android.gms.internal.ads.zzbj.zza(r0, r0)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvs.zzb(com.google.android.gms.internal.ads.zzfc, boolean):com.google.android.gms.internal.ads.zzvr");
    }

    private static int zzc(zzfc zzfc) {
        int zzc2 = zzfc.zzc(5);
        if (zzc2 == 31) {
            return zzfc.zzc(6) + 32;
        }
        return zzc2;
    }

    private static int zzd(zzfc zzfc) throws zzbj {
        int zzc2 = zzfc.zzc(4);
        if (zzc2 == 15) {
            return zzfc.zzc(24);
        }
        if (zzc2 < 13) {
            return zzb[zzc2];
        }
        throw zzbj.zza((String) null, (Throwable) null);
    }
}
