package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;

public final class zzaef implements zzadr {
    private final zzfd zza;
    private final zzxj zzb;
    @Nullable
    private final String zzc;
    private zzxt zzd;
    private String zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private boolean zzi;
    private long zzj;
    private int zzk;
    private long zzl;

    public zzaef() {
        this((String) null);
    }

    public final void zza(zzfd zzfd) {
        boolean z11;
        boolean z12;
        zzdy.zzb(this.zzd);
        while (zzfd.zza() > 0) {
            int i11 = this.zzf;
            if (i11 == 0) {
                byte[] zzH = zzfd.zzH();
                int zzc2 = zzfd.zzc();
                int zzd2 = zzfd.zzd();
                while (true) {
                    if (zzc2 >= zzd2) {
                        zzfd.zzF(zzd2);
                        break;
                    }
                    byte b11 = zzH[zzc2];
                    if ((b11 & 255) == 255) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!this.zzi || (b11 & 224) != 224) {
                        z12 = false;
                    } else {
                        z12 = true;
                    }
                    this.zzi = z11;
                    if (z12) {
                        zzfd.zzF(zzc2 + 1);
                        this.zzi = false;
                        this.zza.zzH()[1] = zzH[zzc2];
                        this.zzg = 2;
                        this.zzf = 1;
                        break;
                    }
                    zzc2++;
                }
            } else if (i11 != 1) {
                int min = Math.min(zzfd.zza(), this.zzk - this.zzg);
                zzxr.zzb(this.zzd, zzfd, min);
                int i12 = this.zzg + min;
                this.zzg = i12;
                int i13 = this.zzk;
                if (i12 >= i13) {
                    long j11 = this.zzl;
                    if (j11 != C.TIME_UNSET) {
                        this.zzd.zzs(j11, 1, i13, 0, (zzxs) null);
                        this.zzl += this.zzj;
                    }
                    this.zzg = 0;
                    this.zzf = 0;
                }
            } else {
                int min2 = Math.min(zzfd.zza(), 4 - this.zzg);
                zzfd.zzB(this.zza.zzH(), this.zzg, min2);
                int i14 = this.zzg + min2;
                this.zzg = i14;
                if (i14 >= 4) {
                    this.zza.zzF(0);
                    if (!this.zzb.zza(this.zza.zze())) {
                        this.zzg = 0;
                        this.zzf = 1;
                    } else {
                        zzxj zzxj = this.zzb;
                        this.zzk = zzxj.zzc;
                        if (!this.zzh) {
                            this.zzj = (((long) zzxj.zzg) * 1000000) / ((long) zzxj.zzd);
                            zzz zzz = new zzz();
                            zzz.zzH(this.zze);
                            zzz.zzS(this.zzb.zzb);
                            zzz.zzL(4096);
                            zzz.zzw(this.zzb.zze);
                            zzz.zzT(this.zzb.zzd);
                            zzz.zzK(this.zzc);
                            this.zzd.zzk(zzz.zzY());
                            this.zzh = true;
                        }
                        this.zza.zzF(0);
                        zzxr.zzb(this.zzd, this.zza, 4);
                        this.zzf = 2;
                    }
                }
            }
        }
    }

    public final void zzb(zzws zzws, zzafd zzafd) {
        zzafd.zzc();
        this.zze = zzafd.zzb();
        this.zzd = zzws.zzv(zzafd.zza(), 1);
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
        this.zzi = false;
        this.zzl = C.TIME_UNSET;
    }

    public zzaef(@Nullable String str) {
        this.zzf = 0;
        zzfd zzfd = new zzfd(4);
        this.zza = zzfd;
        zzfd.zzH()[0] = -1;
        this.zzb = new zzxj();
        this.zzl = C.TIME_UNSET;
        this.zzc = str;
    }
}
