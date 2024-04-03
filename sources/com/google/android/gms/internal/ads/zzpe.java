package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import java.io.IOException;

public final class zzpe implements zzqq {
    private final zzww zza;
    @Nullable
    private zzwp zzb;
    @Nullable
    private zzwq zzc;

    public zzpe(zzww zzww) {
        this.zza = zzww;
    }

    public final int zza(zzxm zzxm) throws IOException {
        zzwp zzwp = this.zzb;
        zzwp.getClass();
        zzwq zzwq = this.zzc;
        zzwq.getClass();
        return zzwp.zza(zzwq, zzxm);
    }

    public final long zzb() {
        zzwq zzwq = this.zzc;
        if (zzwq != null) {
            return zzwq.zze();
        }
        return -1;
    }

    public final void zzc() {
        zzwp zzwp = this.zzb;
        if (zzwp instanceof zzabg) {
            ((zzabg) zzwp).zze();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003e, code lost:
        if (r0.zze() != r11) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0060, code lost:
        if (r0.zze() != r11) goto L_0x0063;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0063, code lost:
        r1 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzd(com.google.android.gms.internal.ads.zzdg r8, android.net.Uri r9, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r10, long r11, long r13, com.google.android.gms.internal.ads.zzws r15) throws java.io.IOException {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzwk r6 = new com.google.android.gms.internal.ads.zzwk
            r0 = r6
            r1 = r8
            r2 = r11
            r4 = r13
            r0.<init>(r1, r2, r4)
            r7.zzc = r6
            com.google.android.gms.internal.ads.zzwp r8 = r7.zzb
            if (r8 == 0) goto L_0x0010
            return
        L_0x0010:
            com.google.android.gms.internal.ads.zzww r8 = r7.zza
            com.google.android.gms.internal.ads.zzwp[] r8 = r8.zzb(r9, r10)
            int r10 = r8.length
            r13 = 0
            r14 = 1
            if (r10 != r14) goto L_0x0020
            r8 = r8[r13]
            r7.zzb = r8
            goto L_0x0073
        L_0x0020:
            r0 = r13
        L_0x0021:
            if (r0 >= r10) goto L_0x006f
            r1 = r8[r0]
            boolean r2 = r1.zzd(r6)     // Catch:{ EOFException -> 0x0056, all -> 0x0041 }
            if (r2 == 0) goto L_0x0034
            r7.zzb = r1     // Catch:{ EOFException -> 0x0056, all -> 0x0041 }
            com.google.android.gms.internal.ads.zzdy.zzf(r14)
            r6.zzj()
            goto L_0x006f
        L_0x0034:
            com.google.android.gms.internal.ads.zzwp r1 = r7.zzb
            if (r1 != 0) goto L_0x0065
            long r1 = r6.zze()
            int r1 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r1 != 0) goto L_0x0063
            goto L_0x0065
        L_0x0041:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzwp r9 = r7.zzb
            if (r9 != 0) goto L_0x004e
            long r9 = r6.zze()
            int r9 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r9 != 0) goto L_0x004f
        L_0x004e:
            r13 = r14
        L_0x004f:
            com.google.android.gms.internal.ads.zzdy.zzf(r13)
            r6.zzj()
            throw r8
        L_0x0056:
            com.google.android.gms.internal.ads.zzwp r1 = r7.zzb
            if (r1 != 0) goto L_0x0065
            long r1 = r6.zze()
            int r1 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r1 != 0) goto L_0x0063
            goto L_0x0065
        L_0x0063:
            r1 = r13
            goto L_0x0066
        L_0x0065:
            r1 = r14
        L_0x0066:
            com.google.android.gms.internal.ads.zzdy.zzf(r1)
            r6.zzj()
            int r0 = r0 + 1
            goto L_0x0021
        L_0x006f:
            com.google.android.gms.internal.ads.zzwp r10 = r7.zzb
            if (r10 == 0) goto L_0x0079
        L_0x0073:
            com.google.android.gms.internal.ads.zzwp r8 = r7.zzb
            r8.zzb(r15)
            return
        L_0x0079:
            com.google.android.gms.internal.ads.zzru r10 = new com.google.android.gms.internal.ads.zzru
            java.lang.String r8 = com.google.android.gms.internal.ads.zzfn.zzF(r8)
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            int r12 = r8.length()
            int r12 = r12 + 58
            r11.<init>(r12)
            java.lang.String r12 = "None of the available extractors ("
            r11.append(r12)
            r11.append(r8)
            java.lang.String r8 = ") could read the stream."
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            r10.<init>(r8, r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpe.zzd(com.google.android.gms.internal.ads.zzdg, android.net.Uri, java.util.Map, long, long, com.google.android.gms.internal.ads.zzws):void");
    }

    public final void zze() {
        if (this.zzb != null) {
            this.zzb = null;
        }
        this.zzc = null;
    }

    public final void zzf(long j11, long j12) {
        zzwp zzwp = this.zzb;
        zzwp.getClass();
        zzwp.zzc(j11, j12);
    }
}
