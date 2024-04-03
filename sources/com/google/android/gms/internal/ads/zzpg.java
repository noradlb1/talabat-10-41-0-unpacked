package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import java.io.IOException;

public final class zzpg implements zzpy, zzpx {
    public final zzpy zza;
    long zzb;
    @Nullable
    private zzpx zzc;
    private zzpf[] zzd = new zzpf[0];
    private long zze = 0;

    public zzpg(zzpy zzpy, boolean z11, long j11, long j12) {
        this.zza = zzpy;
        this.zzb = j12;
    }

    public final long zza(long j11, zzio zzio) {
        long j12;
        if (j11 == 0) {
            return 0;
        }
        long zzo = zzfn.zzo(zzio.zzf, 0, j11);
        long j13 = zzio.zzg;
        long j14 = this.zzb;
        if (j14 == Long.MIN_VALUE) {
            j12 = Long.MAX_VALUE;
        } else {
            j12 = j14 - j11;
        }
        long zzo2 = zzfn.zzo(j13, 0, j12);
        if (!(zzo == zzio.zzf && zzo2 == zzio.zzg)) {
            zzio = new zzio(zzo, zzo2);
        }
        return this.zza.zza(j11, zzio);
    }

    public final long zzb() {
        long zzb2 = this.zza.zzb();
        if (zzb2 != Long.MIN_VALUE) {
            long j11 = this.zzb;
            if (j11 == Long.MIN_VALUE || zzb2 < j11) {
                return zzb2;
            }
        }
        return Long.MIN_VALUE;
    }

    public final long zzc() {
        long zzc2 = this.zza.zzc();
        if (zzc2 != Long.MIN_VALUE) {
            long j11 = this.zzb;
            if (j11 == Long.MIN_VALUE || zzc2 < j11) {
                return zzc2;
            }
        }
        return Long.MIN_VALUE;
    }

    public final long zzd() {
        boolean z11;
        if (zzp()) {
            long j11 = this.zze;
            this.zze = C.TIME_UNSET;
            long zzd2 = zzd();
            if (zzd2 != C.TIME_UNSET) {
                return zzd2;
            }
            return j11;
        }
        long zzd3 = this.zza.zzd();
        if (zzd3 == C.TIME_UNSET) {
            return C.TIME_UNSET;
        }
        boolean z12 = false;
        if (zzd3 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzdy.zzf(z11);
        long j12 = this.zzb;
        if (j12 == Long.MIN_VALUE || zzd3 <= j12) {
            z12 = true;
        }
        zzdy.zzf(z12);
        return zzd3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        if (r0 > r3) goto L_0x0036;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zze(long r8) {
        /*
            r7 = this;
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7.zze = r0
            com.google.android.gms.internal.ads.zzpf[] r0 = r7.zzd
            int r1 = r0.length
            r2 = 0
            r3 = r2
        L_0x000c:
            if (r3 >= r1) goto L_0x0018
            r4 = r0[r3]
            if (r4 == 0) goto L_0x0015
            r4.zzc()
        L_0x0015:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x0018:
            com.google.android.gms.internal.ads.zzpy r0 = r7.zza
            long r0 = r0.zze(r8)
            int r8 = (r0 > r8 ? 1 : (r0 == r8 ? 0 : -1))
            r9 = 1
            if (r8 == 0) goto L_0x0035
            r3 = 0
            int r8 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r8 < 0) goto L_0x0036
            long r3 = r7.zzb
            r5 = -9223372036854775808
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 == 0) goto L_0x0035
            int r8 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r8 > 0) goto L_0x0036
        L_0x0035:
            r2 = r9
        L_0x0036:
            com.google.android.gms.internal.ads.zzdy.zzf(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpg.zze(long):long");
    }

    public final zzch zzf() {
        return this.zza.zzf();
    }

    public final /* bridge */ /* synthetic */ void zzg(zzrp zzrp) {
        zzpy zzpy = (zzpy) zzrp;
        zzpx zzpx = this.zzc;
        zzpx.getClass();
        zzpx.zzg(this);
    }

    public final void zzh(long j11, boolean z11) {
        this.zza.zzh(j11, false);
    }

    public final void zzi(zzpy zzpy) {
        zzpx zzpx = this.zzc;
        zzpx.getClass();
        zzpx.zzi(this);
    }

    public final void zzj() throws IOException {
        this.zza.zzj();
    }

    public final void zzk(zzpx zzpx, long j11) {
        this.zzc = zzpx;
        this.zza.zzk(this, j11);
    }

    public final void zzl(long j11) {
        this.zza.zzl(j11);
    }

    public final void zzm(long j11, long j12) {
        this.zzb = j12;
    }

    public final boolean zzn(long j11) {
        return this.zza.zzn(j11);
    }

    public final boolean zzo() {
        return this.zza.zzo();
    }

    public final boolean zzp() {
        return this.zze != C.TIME_UNSET;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004b, code lost:
        if (r4 > r8) goto L_0x004e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zzq(com.google.android.gms.internal.ads.zzsb[] r15, boolean[] r16, com.google.android.gms.internal.ads.zzrn[] r17, boolean[] r18, long r19) {
        /*
            r14 = this;
            r0 = r14
            r1 = r17
            int r2 = r1.length
            com.google.android.gms.internal.ads.zzpf[] r3 = new com.google.android.gms.internal.ads.zzpf[r2]
            r0.zzd = r3
            com.google.android.gms.internal.ads.zzrn[] r2 = new com.google.android.gms.internal.ads.zzrn[r2]
            r3 = 0
            r4 = r3
        L_0x000c:
            int r5 = r1.length
            r11 = 0
            if (r4 >= r5) goto L_0x0021
            com.google.android.gms.internal.ads.zzpf[] r5 = r0.zzd
            r6 = r1[r4]
            com.google.android.gms.internal.ads.zzpf r6 = (com.google.android.gms.internal.ads.zzpf) r6
            r5[r4] = r6
            if (r6 == 0) goto L_0x001c
            com.google.android.gms.internal.ads.zzrn r11 = r6.zza
        L_0x001c:
            r2[r4] = r11
            int r4 = r4 + 1
            goto L_0x000c
        L_0x0021:
            com.google.android.gms.internal.ads.zzpy r4 = r0.zza
            r5 = r15
            r6 = r16
            r7 = r2
            r8 = r18
            r9 = r19
            long r4 = r4.zzq(r5, r6, r7, r8, r9)
            r6 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r0.zze = r6
            int r6 = (r4 > r19 ? 1 : (r4 == r19 ? 0 : -1))
            r7 = 1
            if (r6 == 0) goto L_0x004f
            r8 = 0
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 < 0) goto L_0x004e
            long r8 = r0.zzb
            r12 = -9223372036854775808
            int r6 = (r8 > r12 ? 1 : (r8 == r12 ? 0 : -1))
            if (r6 == 0) goto L_0x004f
            int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r6 > 0) goto L_0x004e
            goto L_0x004f
        L_0x004e:
            r7 = r3
        L_0x004f:
            com.google.android.gms.internal.ads.zzdy.zzf(r7)
        L_0x0052:
            int r6 = r1.length
            if (r3 >= r6) goto L_0x0078
            r6 = r2[r3]
            if (r6 != 0) goto L_0x005e
            com.google.android.gms.internal.ads.zzpf[] r6 = r0.zzd
            r6[r3] = r11
            goto L_0x006f
        L_0x005e:
            com.google.android.gms.internal.ads.zzpf[] r7 = r0.zzd
            r8 = r7[r3]
            if (r8 == 0) goto L_0x0068
            com.google.android.gms.internal.ads.zzrn r8 = r8.zza
            if (r8 == r6) goto L_0x006f
        L_0x0068:
            com.google.android.gms.internal.ads.zzpf r8 = new com.google.android.gms.internal.ads.zzpf
            r8.<init>(r14, r6)
            r7[r3] = r8
        L_0x006f:
            com.google.android.gms.internal.ads.zzpf[] r6 = r0.zzd
            r6 = r6[r3]
            r1[r3] = r6
            int r3 = r3 + 1
            goto L_0x0052
        L_0x0078:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpg.zzq(com.google.android.gms.internal.ads.zzsb[], boolean[], com.google.android.gms.internal.ads.zzrn[], boolean[], long):long");
    }
}
