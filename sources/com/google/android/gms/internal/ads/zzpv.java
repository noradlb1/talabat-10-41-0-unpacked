package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class zzpv extends zzpk<Void> {
    private final zzqb zza;
    private final boolean zzb;
    private final zzcc zzc;
    private final zzca zzd;
    private zzpt zze;
    @Nullable
    private zzps zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;

    public zzpv(zzqb zzqb, boolean z11) {
        boolean z12;
        this.zza = zzqb;
        if (z11) {
            zzqb.zzt();
            z12 = true;
        } else {
            z12 = false;
        }
        this.zzb = z12;
        this.zzc = new zzcc();
        this.zzd = new zzca();
        zzqb.zzF();
        this.zze = zzpt.zzq(zzqb.zzy());
    }

    private final Object zzD(Object obj) {
        if (this.zze.zzf == null || !obj.equals(zzpt.zzd)) {
            return obj;
        }
        return this.zze.zzf;
    }

    @RequiresNonNull({"unpreparedMaskingMediaPeriod"})
    private final void zzE(long j11) {
        zzps zzps = this.zzf;
        int zza2 = this.zze.zza(zzps.zza.zza);
        if (zza2 != -1) {
            zzpt zzpt = this.zze;
            zzca zzca = this.zzd;
            zzpt.zzd(zza2, zzca, false);
            long j12 = zzca.zze;
            if (j12 != C.TIME_UNSET && j11 >= j12) {
                j11 = Math.max(0, j12 - 1);
            }
            zzps.zzs(j11);
        }
    }

    public final void zzA(zzpy zzpy) {
        ((zzps) zzpy).zzt();
        if (zzpy == this.zzf) {
            this.zzf = null;
        }
    }

    /* renamed from: zzB */
    public final zzps zzC(zzpz zzpz, zztk zztk, long j11) {
        zzps zzps = new zzps(zzpz, zztk, j11, (byte[]) null);
        zzps.zzu(this.zza);
        if (this.zzh) {
            zzps.zzr(zzpz.zzc(zzD(zzpz.zza)));
        } else {
            this.zzf = zzps;
            if (!this.zzg) {
                this.zzg = true;
                zzx(null, this.zza);
            }
        }
        return zzps;
    }

    public final void zzm(@Nullable zzdx zzdx) {
        super.zzm(zzdx);
        if (!this.zzb) {
            this.zzg = true;
            zzx(null, this.zza);
        }
    }

    public final void zzp() {
        this.zzh = false;
        this.zzg = false;
        super.zzp();
    }

    @Nullable
    public final /* bridge */ /* synthetic */ zzpz zzu(Object obj, zzpz zzpz) {
        Void voidR = (Void) obj;
        Object obj2 = zzpz.zza;
        if (this.zze.zzf != null && this.zze.zzf.equals(obj2)) {
            obj2 = zzpt.zzd;
        }
        return zzpz.zzc(obj2);
    }

    public final void zzv() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0090  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* bridge */ /* synthetic */ void zzw(java.lang.Object r12, com.google.android.gms.internal.ads.zzqb r13, com.google.android.gms.internal.ads.zzcd r14) {
        /*
            r11 = this;
            java.lang.Void r12 = (java.lang.Void) r12
            boolean r12 = r11.zzh
            r13 = 0
            if (r12 == 0) goto L_0x001c
            com.google.android.gms.internal.ads.zzpt r12 = r11.zze
            com.google.android.gms.internal.ads.zzpt r12 = r12.zzp(r14)
            r11.zze = r12
            com.google.android.gms.internal.ads.zzps r12 = r11.zzf
            if (r12 == 0) goto L_0x009f
            long r0 = r12.zzm()
            r11.zzE(r0)
            goto L_0x009f
        L_0x001c:
            boolean r12 = r14.zzo()
            if (r12 == 0) goto L_0x0038
            boolean r12 = r11.zzi
            if (r12 == 0) goto L_0x002d
            com.google.android.gms.internal.ads.zzpt r12 = r11.zze
            com.google.android.gms.internal.ads.zzpt r12 = r12.zzp(r14)
            goto L_0x0035
        L_0x002d:
            java.lang.Object r12 = com.google.android.gms.internal.ads.zzcc.zza
            java.lang.Object r0 = com.google.android.gms.internal.ads.zzpt.zzd
            com.google.android.gms.internal.ads.zzpt r12 = com.google.android.gms.internal.ads.zzpt.zzr(r14, r12, r0)
        L_0x0035:
            r11.zze = r12
            goto L_0x009f
        L_0x0038:
            com.google.android.gms.internal.ads.zzcc r12 = r11.zzc
            r0 = 0
            r1 = 0
            r14.zze(r0, r12, r1)
            com.google.android.gms.internal.ads.zzcc r12 = r11.zzc
            java.lang.Object r12 = r12.zzc
            com.google.android.gms.internal.ads.zzps r3 = r11.zzf
            if (r3 == 0) goto L_0x0066
            long r3 = r3.zzp()
            com.google.android.gms.internal.ads.zzpt r5 = r11.zze
            com.google.android.gms.internal.ads.zzps r6 = r11.zzf
            com.google.android.gms.internal.ads.zzpz r6 = r6.zza
            java.lang.Object r6 = r6.zza
            com.google.android.gms.internal.ads.zzca r7 = r11.zzd
            r5.zzn(r6, r7)
            com.google.android.gms.internal.ads.zzpt r5 = r11.zze
            com.google.android.gms.internal.ads.zzcc r6 = r11.zzc
            r5.zze(r0, r6, r1)
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L_0x0066
            r9 = r3
            goto L_0x0067
        L_0x0066:
            r9 = r1
        L_0x0067:
            com.google.android.gms.internal.ads.zzcc r6 = r11.zzc
            com.google.android.gms.internal.ads.zzca r7 = r11.zzd
            r8 = 0
            r5 = r14
            android.util.Pair r0 = r5.zzl(r6, r7, r8, r9)
            java.lang.Object r1 = r0.first
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r2 = r0.longValue()
            boolean r0 = r11.zzi
            if (r0 == 0) goto L_0x0086
            com.google.android.gms.internal.ads.zzpt r12 = r11.zze
            com.google.android.gms.internal.ads.zzpt r12 = r12.zzp(r14)
            goto L_0x008a
        L_0x0086:
            com.google.android.gms.internal.ads.zzpt r12 = com.google.android.gms.internal.ads.zzpt.zzr(r14, r12, r1)
        L_0x008a:
            r11.zze = r12
            com.google.android.gms.internal.ads.zzps r12 = r11.zzf
            if (r12 == 0) goto L_0x009f
            r11.zzE(r2)
            com.google.android.gms.internal.ads.zzpz r12 = r12.zza
            java.lang.Object r13 = r12.zza
            java.lang.Object r13 = r11.zzD(r13)
            com.google.android.gms.internal.ads.zzpz r13 = r12.zzc(r13)
        L_0x009f:
            r12 = 1
            r11.zzi = r12
            r11.zzh = r12
            com.google.android.gms.internal.ads.zzpt r12 = r11.zze
            r11.zzn(r12)
            if (r13 == 0) goto L_0x00b3
            com.google.android.gms.internal.ads.zzps r12 = r11.zzf
            r12.getClass()
            r12.zzr(r13)
        L_0x00b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpv.zzw(java.lang.Object, com.google.android.gms.internal.ads.zzqb, com.google.android.gms.internal.ads.zzcd):void");
    }

    public final zzaz zzy() {
        return this.zza.zzy();
    }

    public final zzcd zzz() {
        return this.zze;
    }
}
