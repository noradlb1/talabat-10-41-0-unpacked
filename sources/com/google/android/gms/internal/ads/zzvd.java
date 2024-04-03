package com.google.android.gms.internal.ads;

import android.content.Context;
import android.util.Log;
import android.view.Display;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;

public final class zzvd {
    private final zzus zza = new zzus();
    @Nullable
    private final zzuz zzb;
    @Nullable
    private final zzvc zzc;
    private boolean zzd;
    @Nullable
    private Surface zze;
    private float zzf;
    private float zzg;
    private float zzh;
    private float zzi;
    private int zzj;
    private long zzk;
    private long zzl;
    private long zzm;
    private long zzn;
    private long zzo;
    private long zzp;
    private long zzq;

    public zzvd(@Nullable Context context) {
        zzuz zzuz;
        zzvc zzvc = null;
        if (context != null) {
            Context applicationContext = context.getApplicationContext();
            if (zzfn.zza >= 17) {
                zzuz = zzvb.zzc(applicationContext);
            } else {
                zzuz = null;
            }
            if (zzuz == null) {
                zzuz = zzva.zzc(applicationContext);
            }
        } else {
            zzuz = null;
        }
        this.zzb = zzuz;
        this.zzc = zzuz != null ? zzvc.zza() : zzvc;
        this.zzk = C.TIME_UNSET;
        this.zzl = C.TIME_UNSET;
        this.zzf = -1.0f;
        this.zzi = 1.0f;
        this.zzj = 0;
    }

    public static /* synthetic */ void zzb(zzvd zzvd, Display display) {
        if (display != null) {
            long refreshRate = (long) (1.0E9d / ((double) display.getRefreshRate()));
            zzvd.zzk = refreshRate;
            zzvd.zzl = (refreshRate * 80) / 100;
            return;
        }
        Log.w("VideoFrameReleaseHelper", "Unable to query display refresh rate");
        zzvd.zzk = C.TIME_UNSET;
        zzvd.zzl = C.TIME_UNSET;
    }

    private final void zzm() {
        Surface surface;
        if (zzfn.zza >= 30 && (surface = this.zze) != null && this.zzj != Integer.MIN_VALUE && this.zzh != 0.0f) {
            this.zzh = 0.0f;
            zzuy.zza(surface, 0.0f);
        }
    }

    private final void zzn() {
        this.zzm = 0;
        this.zzp = -1;
        this.zzn = -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        if (java.lang.Math.abs(r0 - r9.zzg) >= r2) goto L_0x0064;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        if (r9.zza.zzb() >= 30) goto L_0x0064;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzo() {
        /*
            r9 = this;
            int r0 = com.google.android.gms.internal.ads.zzfn.zza
            r1 = 30
            if (r0 < r1) goto L_0x006d
            android.view.Surface r0 = r9.zze
            if (r0 != 0) goto L_0x000b
            goto L_0x006d
        L_0x000b:
            com.google.android.gms.internal.ads.zzus r0 = r9.zza
            boolean r0 = r0.zzg()
            if (r0 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzus r0 = r9.zza
            float r0 = r0.zza()
            goto L_0x001c
        L_0x001a:
            float r0 = r9.zzf
        L_0x001c:
            float r2 = r9.zzg
            int r3 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r3 != 0) goto L_0x0023
            return
        L_0x0023:
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r4 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0058
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 == 0) goto L_0x0058
            com.google.android.gms.internal.ads.zzus r1 = r9.zza
            boolean r1 = r1.zzg()
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L_0x004b
            com.google.android.gms.internal.ads.zzus r1 = r9.zza
            long r3 = r1.zzd()
            r7 = 5000000000(0x12a05f200, double:2.470328229E-314)
            int r1 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r1 < 0) goto L_0x004b
            r2 = 1017370378(0x3ca3d70a, float:0.02)
        L_0x004b:
            float r1 = r9.zzg
            float r1 = r0 - r1
            float r1 = java.lang.Math.abs(r1)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 < 0) goto L_0x0063
            goto L_0x0064
        L_0x0058:
            if (r4 != 0) goto L_0x0068
            com.google.android.gms.internal.ads.zzus r2 = r9.zza
            int r2 = r2.zzb()
            if (r2 < r1) goto L_0x0063
            goto L_0x0064
        L_0x0063:
            r5 = r6
        L_0x0064:
            if (r5 == 0) goto L_0x0067
            goto L_0x0068
        L_0x0067:
            return
        L_0x0068:
            r9.zzg = r0
            r9.zzp(r6)
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzvd.zzo():void");
    }

    private final void zzp(boolean z11) {
        Surface surface;
        if (zzfn.zza >= 30 && (surface = this.zze) != null && this.zzj != Integer.MIN_VALUE) {
            float f11 = 0.0f;
            if (this.zzd) {
                float f12 = this.zzg;
                if (f12 != -1.0f) {
                    f11 = this.zzi * f12;
                }
            }
            if (z11 || this.zzh != f11) {
                this.zzh = f11;
                zzuy.zza(surface, f11);
            }
        }
    }

    public final long zza(long j11) {
        long j12;
        if (this.zzp != -1 && this.zza.zzg()) {
            long zzc2 = this.zzq + ((long) (((float) (this.zza.zzc() * (this.zzm - this.zzp))) / this.zzi));
            if (Math.abs(j11 - zzc2) <= 20000000) {
                j11 = zzc2;
            } else {
                zzn();
            }
        }
        this.zzn = this.zzm;
        this.zzo = j11;
        zzvc zzvc = this.zzc;
        if (zzvc == null || this.zzk == C.TIME_UNSET) {
            return j11;
        }
        long j13 = zzvc.zza;
        if (j13 == C.TIME_UNSET) {
            return j11;
        }
        long j14 = this.zzk;
        long j15 = j13 + (((j11 - j13) / j14) * j14);
        if (j11 <= j15) {
            j12 = j15 - j14;
        } else {
            long j16 = j15;
            j15 = j14 + j15;
            j12 = j16;
        }
        if (j15 - j11 >= j11 - j12) {
            j15 = j12;
        }
        return j15 - this.zzl;
    }

    public final void zzc() {
        zzuz zzuz = this.zzb;
        if (zzuz != null) {
            zzuz.zza();
            zzvc zzvc = this.zzc;
            zzvc.getClass();
            zzvc.zzc();
        }
    }

    public final void zzd() {
        if (this.zzb != null) {
            zzvc zzvc = this.zzc;
            zzvc.getClass();
            zzvc.zzb();
            this.zzb.zzb(new zzux(this));
        }
    }

    public final void zze(float f11) {
        this.zzf = f11;
        this.zza.zzf();
        zzo();
    }

    public final void zzf(long j11) {
        long j12 = this.zzn;
        if (j12 != -1) {
            this.zzp = j12;
            this.zzq = this.zzo;
        }
        this.zzm++;
        this.zza.zze(j11 * 1000);
        zzo();
    }

    public final void zzg(float f11) {
        this.zzi = f11;
        zzn();
        zzp(false);
    }

    public final void zzh() {
        zzn();
    }

    public final void zzi() {
        this.zzd = true;
        zzn();
        zzp(false);
    }

    public final void zzj() {
        this.zzd = false;
        zzm();
    }

    public final void zzk(@Nullable Surface surface) {
        if (true == (surface instanceof zzuq)) {
            surface = null;
        }
        if (this.zze != surface) {
            zzm();
            this.zze = surface;
            zzp(true);
        }
    }

    public final void zzl(int i11) {
        if (this.zzj != i11) {
            this.zzj = i11;
            zzp(true);
        }
    }
}
