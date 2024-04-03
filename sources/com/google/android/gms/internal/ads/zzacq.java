package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;

final class zzacq implements zzacx {
    private final zzacw zza;
    /* access modifiers changed from: private */
    public final long zzb;
    /* access modifiers changed from: private */
    public final long zzc;
    /* access modifiers changed from: private */
    public final zzadc zzd;
    private int zze;
    /* access modifiers changed from: private */
    public long zzf;
    private long zzg;
    private long zzh;
    private long zzi;
    private long zzj;
    private long zzk;
    private long zzl;

    public zzacq(zzadc zzadc, long j11, long j12, long j13, long j14, boolean z11) {
        boolean z12;
        if (j11 < 0 || j12 <= j11) {
            z12 = false;
        } else {
            z12 = true;
        }
        zzdy.zzd(z12);
        this.zzd = zzadc;
        this.zzb = j11;
        this.zzc = j12;
        if (j13 == j12 - j11 || z11) {
            this.zzf = j14;
            this.zze = 4;
        } else {
            this.zze = 0;
        }
        this.zza = new zzacw();
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00b6 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b7  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzd(com.google.android.gms.internal.ads.zzwq r24) throws java.io.IOException {
        /*
            r23 = this;
            r0 = r23
            r1 = r24
            int r2 = r0.zze
            r3 = 1
            r5 = 0
            r6 = -1
            if (r2 == 0) goto L_0x00f8
            if (r2 == r3) goto L_0x010b
            r3 = 2
            r10 = 3
            if (r2 == r3) goto L_0x0018
            if (r2 == r10) goto L_0x0015
            return r6
        L_0x0015:
            r2 = r6
            goto L_0x00b9
        L_0x0018:
            long r2 = r0.zzi
            long r11 = r0.zzj
            int r2 = (r2 > r11 ? 1 : (r2 == r11 ? 0 : -1))
            if (r2 != 0) goto L_0x0024
        L_0x0020:
            r2 = r6
            r11 = r2
            goto L_0x00b2
        L_0x0024:
            long r2 = r24.zze()
            com.google.android.gms.internal.ads.zzacw r11 = r0.zza
            long r12 = r0.zzj
            boolean r11 = r11.zzc(r1, r12)
            if (r11 != 0) goto L_0x0043
            long r11 = r0.zzi
            int r2 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x003b
            r2 = r6
            goto L_0x00b2
        L_0x003b:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "No ogg page can be found."
            r1.<init>(r2)
            throw r1
        L_0x0043:
            com.google.android.gms.internal.ads.zzacw r11 = r0.zza
            r11.zzb(r1, r5)
            r24.zzj()
            long r11 = r0.zzh
            com.google.android.gms.internal.ads.zzacw r13 = r0.zza
            long r14 = r13.zzb
            long r11 = r11 - r14
            int r8 = r13.zzd
            int r9 = r13.zze
            int r8 = r8 + r9
            r16 = 0
            int r9 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r9 < 0) goto L_0x0065
            r16 = 72000(0x11940, double:3.55727E-319)
            int r13 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r13 >= 0) goto L_0x0065
            goto L_0x0020
        L_0x0065:
            if (r9 >= 0) goto L_0x006c
            r0.zzj = r2
            r0.zzl = r14
            goto L_0x007a
        L_0x006c:
            long r2 = r24.zze()
            long r13 = (long) r8
            long r2 = r2 + r13
            r0.zzi = r2
            com.google.android.gms.internal.ads.zzacw r2 = r0.zza
            long r2 = r2.zzb
            r0.zzk = r2
        L_0x007a:
            long r2 = r0.zzj
            long r13 = r0.zzi
            long r2 = r2 - r13
            r16 = 100000(0x186a0, double:4.94066E-319)
            int r2 = (r2 > r16 ? 1 : (r2 == r16 ? 0 : -1))
            if (r2 >= 0) goto L_0x008b
            r0.zzj = r13
            r2 = r6
            r11 = r13
            goto L_0x00b2
        L_0x008b:
            long r2 = (long) r8
            if (r9 > 0) goto L_0x0091
            r8 = 2
            goto L_0x0093
        L_0x0091:
            r8 = 1
        L_0x0093:
            long r13 = r24.zze()
            long r4 = r0.zzj
            long r6 = r0.zzi
            long r2 = r2 * r8
            long r13 = r13 - r2
            long r2 = r4 - r6
            long r11 = r11 * r2
            long r2 = r0.zzl
            long r8 = r0.zzk
            long r2 = r2 - r8
            long r11 = r11 / r2
            long r17 = r13 + r11
            r2 = -1
            long r21 = r4 + r2
            r19 = r6
            long r11 = com.google.android.gms.internal.ads.zzfn.zzo(r17, r19, r21)
        L_0x00b2:
            int r4 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r4 == 0) goto L_0x00b7
            return r11
        L_0x00b7:
            r0.zze = r10
        L_0x00b9:
            com.google.android.gms.internal.ads.zzacw r4 = r0.zza
            r4.zzc(r1, r2)
            com.google.android.gms.internal.ads.zzacw r2 = r0.zza
            r3 = 0
            r2.zzb(r1, r3)
            com.google.android.gms.internal.ads.zzacw r2 = r0.zza
            long r3 = r2.zzb
            long r5 = r0.zzh
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x00db
            r24.zzj()
            r1 = 4
            r0.zze = r1
            long r1 = r0.zzk
            r4 = 2
            long r1 = r1 + r4
            long r1 = -r1
            return r1
        L_0x00db:
            r4 = 2
            int r3 = r2.zzd
            int r2 = r2.zze
            r6 = r1
            com.google.android.gms.internal.ads.zzwk r6 = (com.google.android.gms.internal.ads.zzwk) r6
            int r3 = r3 + r2
            r2 = 0
            r6.zzo(r3, r2)
            long r2 = r24.zze()
            r0.zzi = r2
            com.google.android.gms.internal.ads.zzacw r2 = r0.zza
            long r2 = r2.zzb
            r0.zzk = r2
            r2 = -1
            goto L_0x00b9
        L_0x00f8:
            long r4 = r24.zze()
            r0.zzg = r4
            r0.zze = r3
            long r6 = r0.zzc
            r8 = -65307(0xffffffffffff00e5, double:NaN)
            long r6 = r6 + r8
            int r2 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r2 <= 0) goto L_0x010b
            return r6
        L_0x010b:
            com.google.android.gms.internal.ads.zzacw r2 = r0.zza
            r2.zza()
            com.google.android.gms.internal.ads.zzacw r2 = r0.zza
            r4 = -1
            boolean r2 = r2.zzc(r1, r4)
            if (r2 == 0) goto L_0x016e
            com.google.android.gms.internal.ads.zzacw r2 = r0.zza
            r4 = 0
            r2.zzb(r1, r4)
            com.google.android.gms.internal.ads.zzacw r2 = r0.zza
            int r5 = r2.zzd
            int r2 = r2.zze
            r6 = r1
            com.google.android.gms.internal.ads.zzwk r6 = (com.google.android.gms.internal.ads.zzwk) r6
            int r5 = r5 + r2
            r6.zzo(r5, r4)
            com.google.android.gms.internal.ads.zzacw r2 = r0.zza
            long r4 = r2.zzb
        L_0x0131:
            com.google.android.gms.internal.ads.zzacw r2 = r0.zza
            int r6 = r2.zza
            r7 = 4
            r6 = r6 & r7
            if (r6 == r7) goto L_0x0166
            r6 = -1
            boolean r2 = r2.zzc(r1, r6)
            if (r2 == 0) goto L_0x0166
            long r8 = r24.zze()
            long r10 = r0.zzc
            int r2 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r2 >= 0) goto L_0x0166
            com.google.android.gms.internal.ads.zzacw r2 = r0.zza
            boolean r2 = r2.zzb(r1, r3)
            if (r2 == 0) goto L_0x0166
            com.google.android.gms.internal.ads.zzacw r2 = r0.zza
            int r8 = r2.zzd
            int r2 = r2.zze
            int r8 = r8 + r2
            boolean r2 = com.google.android.gms.internal.ads.zzwt.zze(r1, r8)
            if (r2 != 0) goto L_0x0161
            goto L_0x0166
        L_0x0161:
            com.google.android.gms.internal.ads.zzacw r2 = r0.zza
            long r4 = r2.zzb
            goto L_0x0131
        L_0x0166:
            r0.zzf = r4
            r1 = 4
            r0.zze = r1
            long r1 = r0.zzg
            return r1
        L_0x016e:
            java.io.EOFException r1 = new java.io.EOFException
            r1.<init>()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzacq.zzd(com.google.android.gms.internal.ads.zzwq):long");
    }

    @Nullable
    public final /* bridge */ /* synthetic */ zzxp zze() {
        if (this.zzf != 0) {
            return new zzacp(this, (zzaco) null);
        }
        return null;
    }

    public final void zzg(long j11) {
        this.zzh = zzfn.zzo(j11, 0, -1 + this.zzf);
        this.zze = 2;
        this.zzi = this.zzb;
        this.zzj = this.zzc;
        this.zzk = 0;
        this.zzl = this.zzf;
    }
}
