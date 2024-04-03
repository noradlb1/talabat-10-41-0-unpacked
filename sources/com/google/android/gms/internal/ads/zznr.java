package com.google.android.gms.internal.ads;

import android.os.HandlerThread;

public final class zznr implements zzoe {
    private final zzfqs<HandlerThread> zzb;
    private final zzfqs<HandlerThread> zzc;

    public zznr(int i11, boolean z11) {
        zznp zznp = new zznp(i11);
        zznq zznq = new zznq(i11);
        this.zzb = zznp;
        this.zzc = zznq;
    }

    public static /* synthetic */ HandlerThread zza(int i11) {
        return new HandlerThread(zznt.zzs(i11, "ExoPlayer:MediaCodecAsyncAdapter:"));
    }

    public static /* synthetic */ HandlerThread zzb(int i11) {
        return new HandlerThread(zznt.zzs(i11, "ExoPlayer:MediaCodecQueueingThread:"));
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0058  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zznt zzc(com.google.android.gms.internal.ads.zzod r11) throws java.io.IOException {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzoh r0 = r11.zza
            java.lang.String r0 = r0.zza
            r1 = 0
            java.lang.String r2 = "createCodec:"
            java.lang.String r3 = java.lang.String.valueOf(r0)     // Catch:{ Exception -> 0x0054 }
            int r4 = r3.length()     // Catch:{ Exception -> 0x0054 }
            if (r4 == 0) goto L_0x0016
            java.lang.String r2 = r2.concat(r3)     // Catch:{ Exception -> 0x0054 }
            goto L_0x001c
        L_0x0016:
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x0054 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0054 }
            r2 = r3
        L_0x001c:
            com.google.android.gms.internal.ads.zzfl.zza(r2)     // Catch:{ Exception -> 0x0054 }
            android.media.MediaCodec r0 = android.media.MediaCodec.createByCodecName(r0)     // Catch:{ Exception -> 0x0054 }
            com.google.android.gms.internal.ads.zznt r9 = new com.google.android.gms.internal.ads.zznt     // Catch:{ Exception -> 0x0052 }
            com.google.android.gms.internal.ads.zzfqs<android.os.HandlerThread> r2 = r10.zzb     // Catch:{ Exception -> 0x0052 }
            com.google.android.gms.internal.ads.zznp r2 = (com.google.android.gms.internal.ads.zznp) r2     // Catch:{ Exception -> 0x0052 }
            int r2 = r2.zza     // Catch:{ Exception -> 0x0052 }
            android.os.HandlerThread r5 = zza(r2)     // Catch:{ Exception -> 0x0052 }
            com.google.android.gms.internal.ads.zzfqs<android.os.HandlerThread> r2 = r10.zzc     // Catch:{ Exception -> 0x0052 }
            com.google.android.gms.internal.ads.zznq r2 = (com.google.android.gms.internal.ads.zznq) r2     // Catch:{ Exception -> 0x0052 }
            int r2 = r2.zza     // Catch:{ Exception -> 0x0052 }
            android.os.HandlerThread r6 = zzb(r2)     // Catch:{ Exception -> 0x0052 }
            r7 = 0
            r8 = 0
            r3 = r9
            r4 = r0
            r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0052 }
            com.google.android.gms.internal.ads.zzfl.zzb()     // Catch:{ Exception -> 0x004f }
            android.media.MediaFormat r3 = r11.zzb     // Catch:{ Exception -> 0x004f }
            android.view.Surface r4 = r11.zzd     // Catch:{ Exception -> 0x004f }
            r5 = 0
            r6 = 0
            r7 = 0
            r2 = r9
            com.google.android.gms.internal.ads.zznt.zzh(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x004f }
            return r9
        L_0x004f:
            r11 = move-exception
            r1 = r9
            goto L_0x0056
        L_0x0052:
            r11 = move-exception
            goto L_0x0056
        L_0x0054:
            r11 = move-exception
            r0 = r1
        L_0x0056:
            if (r1 != 0) goto L_0x005e
            if (r0 == 0) goto L_0x0061
            r0.release()
            goto L_0x0061
        L_0x005e:
            r1.zzl()
        L_0x0061:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zznr.zzc(com.google.android.gms.internal.ads.zzod):com.google.android.gms.internal.ads.zznt");
    }
}
