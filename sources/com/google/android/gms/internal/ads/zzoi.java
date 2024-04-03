package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

public final class zzoi extends Exception {
    public final String zza;
    public final boolean zzb;
    @Nullable
    public final zzoh zzc;
    @Nullable
    public final String zzd;
    @Nullable
    public final zzoi zze;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzoi(com.google.android.gms.internal.ads.zzab r11, @androidx.annotation.Nullable java.lang.Throwable r12, boolean r13, int r14) {
        /*
            r10 = this;
            java.lang.String r13 = java.lang.String.valueOf(r11)
            int r0 = r13.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            int r0 = r0 + 36
            r1.<init>(r0)
            java.lang.String r0 = "Decoder init failed: ["
            r1.append(r0)
            r1.append(r14)
            java.lang.String r0 = "], "
            r1.append(r0)
            r1.append(r13)
            java.lang.String r5 = r11.zzm
            int r11 = java.lang.Math.abs(r14)
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r14 = 75
            r13.<init>(r14)
            java.lang.String r14 = "com.google.android.exoplayer2.mediacodec.MediaCodecRenderer_neg_"
            r13.append(r14)
            r13.append(r11)
            java.lang.String r3 = r1.toString()
            r6 = 0
            r7 = 0
            java.lang.String r8 = r13.toString()
            r9 = 0
            r2 = r10
            r4 = r12
            r2.<init>(r3, r4, r5, r6, r7, r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoi.<init>(com.google.android.gms.internal.ads.zzab, java.lang.Throwable, boolean, int):void");
    }

    public static /* bridge */ /* synthetic */ zzoi zza(zzoi zzoi, zzoi zzoi2) {
        return new zzoi(zzoi.getMessage(), zzoi.getCause(), zzoi.zza, false, zzoi.zzc, zzoi.zzd, zzoi2);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzoi(com.google.android.gms.internal.ads.zzab r9, @androidx.annotation.Nullable java.lang.Throwable r10, boolean r11, com.google.android.gms.internal.ads.zzoh r12) {
        /*
            r8 = this;
            java.lang.String r0 = r12.zza
            java.lang.String r1 = java.lang.String.valueOf(r9)
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r4 = r1.length()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            int r3 = r3 + 23
            int r3 = r3 + r4
            r6.<init>(r3)
            java.lang.String r3 = "Decoder init failed: "
            r6.append(r3)
            r6.append(r0)
            java.lang.String r0 = ", "
            r6.append(r0)
            r6.append(r1)
            java.lang.String r1 = r6.toString()
            java.lang.String r3 = r9.zzm
            int r0 = com.google.android.gms.internal.ads.zzfn.zza
            r4 = 21
            r6 = 0
            if (r0 < r4) goto L_0x0043
            boolean r0 = r10 instanceof android.media.MediaCodec.CodecException
            if (r0 == 0) goto L_0x0043
            r0 = r10
            android.media.MediaCodec$CodecException r0 = (android.media.MediaCodec.CodecException) r0
            java.lang.String r0 = r0.getDiagnosticInfo()
            r6 = r0
        L_0x0043:
            r4 = 0
            r7 = 0
            r0 = r8
            r2 = r10
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoi.<init>(com.google.android.gms.internal.ads.zzab, java.lang.Throwable, boolean, com.google.android.gms.internal.ads.zzoh):void");
    }

    private zzoi(String str, @Nullable Throwable th2, String str2, boolean z11, @Nullable zzoh zzoh, @Nullable String str3, @Nullable zzoi zzoi) {
        super(str, th2);
        this.zza = str2;
        this.zzb = false;
        this.zzc = zzoh;
        this.zzd = str3;
        this.zze = zzoi;
    }
}
