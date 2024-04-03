package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;

public final class zzadh implements zzadr {
    private final zzfc zza;
    private final zzfd zzb;
    @Nullable
    private final String zzc;
    private String zzd;
    private zzxt zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private long zzi;
    private zzab zzj;
    private int zzk;
    private long zzl;

    public zzadh() {
        this((String) null);
    }

    public final void zza(zzfd zzfd) {
        boolean z11;
        boolean z12;
        zzdy.zzb(this.zze);
        while (zzfd.zza() > 0) {
            int i11 = this.zzf;
            if (i11 == 0) {
                while (true) {
                    if (zzfd.zza() <= 0) {
                        break;
                    } else if (!this.zzh) {
                        if (zzfd.zzk() == 11) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        this.zzh = z12;
                    } else {
                        int zzk2 = zzfd.zzk();
                        if (zzk2 == 119) {
                            this.zzh = false;
                            this.zzf = 1;
                            this.zzb.zzH()[0] = 11;
                            this.zzb.zzH()[1] = 119;
                            this.zzg = 2;
                            break;
                        }
                        if (zzk2 == 11) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        this.zzh = z11;
                    }
                }
            } else if (i11 != 1) {
                int min = Math.min(zzfd.zza(), this.zzk - this.zzg);
                zzxr.zzb(this.zze, zzfd, min);
                int i12 = this.zzg + min;
                this.zzg = i12;
                int i13 = this.zzk;
                if (i12 == i13) {
                    long j11 = this.zzl;
                    if (j11 != C.TIME_UNSET) {
                        this.zze.zzs(j11, 1, i13, 0, (zzxs) null);
                        this.zzl += this.zzi;
                    }
                    this.zzf = 0;
                }
            } else {
                byte[] zzH = this.zzb.zzH();
                int min2 = Math.min(zzfd.zza(), 128 - this.zzg);
                zzfd.zzB(zzH, this.zzg, min2);
                int i14 = this.zzg + min2;
                this.zzg = i14;
                if (i14 == 128) {
                    this.zza.zzh(0);
                    zzvu zzd2 = zzvv.zzd(this.zza);
                    zzab zzab = this.zzj;
                    if (zzab == null || zzd2.zzc != zzab.zzz || zzd2.zzb != zzab.zzA || !zzfn.zzP(zzd2.zza, zzab.zzm)) {
                        zzz zzz = new zzz();
                        zzz.zzH(this.zzd);
                        zzz.zzS(zzd2.zza);
                        zzz.zzw(zzd2.zzc);
                        zzz.zzT(zzd2.zzb);
                        zzz.zzK(this.zzc);
                        zzab zzY = zzz.zzY();
                        this.zzj = zzY;
                        this.zze.zzk(zzY);
                    }
                    this.zzk = zzd2.zzd;
                    this.zzi = (((long) zzd2.zze) * 1000000) / ((long) this.zzj.zzA);
                    this.zzb.zzF(0);
                    zzxr.zzb(this.zze, this.zzb, 128);
                    this.zzf = 2;
                }
            }
        }
    }

    public final void zzb(zzws zzws, zzafd zzafd) {
        zzafd.zzc();
        this.zzd = zzafd.zzb();
        this.zze = zzws.zzv(zzafd.zza(), 1);
    }

    public final void zzc() {
    }

    public final void zzd(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.zzl = j11;
        }
    }

    public final void zze() {
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = false;
        this.zzl = C.TIME_UNSET;
    }

    public zzadh(@Nullable String str) {
        zzfc zzfc = new zzfc(new byte[128], 128);
        this.zza = zzfc;
        this.zzb = new zzfd(zzfc.zza);
        this.zzf = 0;
        this.zzl = C.TIME_UNSET;
        this.zzc = str;
    }
}
