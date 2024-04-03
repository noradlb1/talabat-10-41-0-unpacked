package com.google.android.gms.internal.ads;

import java.io.IOException;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

abstract class zzadc {
    private final zzacv zza = new zzacv();
    private zzxt zzb;
    private zzws zzc;
    private zzacx zzd;
    private long zze;
    private long zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private zzacz zzj = new zzacz();
    private long zzk;
    private boolean zzl;
    private boolean zzm;

    public abstract long zza(zzfd zzfd);

    public void zzb(boolean z11) {
        int i11;
        if (z11) {
            this.zzj = new zzacz();
            this.zzf = 0;
            i11 = 0;
        } else {
            i11 = 1;
        }
        this.zzh = i11;
        this.zze = -1;
        this.zzg = 0;
    }

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public abstract boolean zzc(zzfd zzfd, long j11, zzacz zzacz) throws IOException;

    public final int zze(zzwq zzwq, zzxm zzxm) throws IOException {
        boolean z11;
        zzwq zzwq2 = zzwq;
        zzdy.zzb(this.zzb);
        int i11 = zzfn.zza;
        int i12 = this.zzh;
        if (i12 == 0) {
            while (this.zza.zze(zzwq2)) {
                this.zzk = zzwq.zze() - this.zzf;
                if (zzc(this.zza.zza(), this.zzf, this.zzj)) {
                    this.zzf = zzwq.zze();
                } else {
                    zzab zzab = this.zzj.zza;
                    this.zzi = zzab.zzA;
                    if (!this.zzm) {
                        this.zzb.zzk(zzab);
                        this.zzm = true;
                    }
                    zzacx zzacx = this.zzj.zzb;
                    if (zzacx != null) {
                        this.zzd = zzacx;
                    } else if (zzwq.zzc() == -1) {
                        this.zzd = new zzadb((zzada) null);
                    } else {
                        zzacw zzb2 = this.zza.zzb();
                        if ((zzb2.zza & 4) != 0) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        this.zzd = new zzacq(this, this.zzf, zzwq.zzc(), (long) (zzb2.zzd + zzb2.zze), zzb2.zzb, z11);
                    }
                    this.zzh = 2;
                    this.zza.zzd();
                    return 0;
                }
            }
            this.zzh = 3;
            return -1;
        } else if (i12 == 1) {
            ((zzwk) zzwq2).zzo((int) this.zzf, false);
            this.zzh = 2;
            return 0;
        } else if (i12 != 2) {
            return -1;
        } else {
            long zzd2 = this.zzd.zzd(zzwq2);
            if (zzd2 >= 0) {
                zzxm.zza = zzd2;
                return 1;
            }
            if (zzd2 < -1) {
                zzi(-(zzd2 + 2));
            }
            if (!this.zzl) {
                zzxp zze2 = this.zzd.zze();
                zzdy.zzb(zze2);
                this.zzc.zzL(zze2);
                this.zzl = true;
            }
            if (this.zzk > 0 || this.zza.zze(zzwq2)) {
                this.zzk = 0;
                zzfd zza2 = this.zza.zza();
                long zza3 = zza(zza2);
                if (zza3 >= 0) {
                    long j11 = this.zzg;
                    if (j11 + zza3 >= this.zze) {
                        long zzf2 = zzf(j11);
                        zzxr.zzb(this.zzb, zza2, zza2.zzd());
                        this.zzb.zzs(zzf2, 1, zza2.zzd(), 0, (zzxs) null);
                        this.zze = -1;
                    }
                }
                this.zzg += zza3;
                return 0;
            }
            this.zzh = 3;
            return -1;
        }
    }

    public final long zzf(long j11) {
        return (j11 * 1000000) / ((long) this.zzi);
    }

    public final long zzg(long j11) {
        return (((long) this.zzi) * j11) / 1000000;
    }

    public final void zzh(zzws zzws, zzxt zzxt) {
        this.zzc = zzws;
        this.zzb = zzxt;
        zzb(true);
    }

    public void zzi(long j11) {
        this.zzg = j11;
    }

    public final void zzj(long j11, long j12) {
        this.zza.zzc();
        if (j11 == 0) {
            zzb(!this.zzl);
        } else if (this.zzh != 0) {
            long zzg2 = zzg(j12);
            this.zze = zzg2;
            zzacx zzacx = this.zzd;
            int i11 = zzfn.zza;
            zzacx.zzg(zzg2);
            this.zzh = 2;
        }
    }
}
