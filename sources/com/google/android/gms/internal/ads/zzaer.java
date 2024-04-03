package com.google.android.gms.internal.ads;

import androidx.core.view.InputDeviceCompat;

public final class zzaer implements zzafe {
    private final zzaeq zza;
    private final zzfd zzb = new zzfd(32);
    private int zzc;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    public zzaer(zzaeq zzaeq) {
        this.zza = zzaeq;
    }

    public final void zza(zzfd zzfd, int i11) {
        int i12;
        boolean z11;
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = zzfd.zzc() + zzfd.zzk();
        } else {
            i12 = -1;
        }
        if (this.zzf) {
            if (i13 != 0) {
                this.zzf = false;
                zzfd.zzF(i12);
                this.zzd = 0;
            } else {
                return;
            }
        }
        while (zzfd.zza() > 0) {
            int i14 = this.zzd;
            if (i14 < 3) {
                if (i14 == 0) {
                    int zzk = zzfd.zzk();
                    zzfd.zzF(zzfd.zzc() - 1);
                    if (zzk == 255) {
                        this.zzf = true;
                        return;
                    }
                }
                int min = Math.min(zzfd.zza(), 3 - this.zzd);
                zzfd.zzB(this.zzb.zzH(), this.zzd, min);
                int i15 = this.zzd + min;
                this.zzd = i15;
                if (i15 == 3) {
                    this.zzb.zzF(0);
                    this.zzb.zzE(3);
                    this.zzb.zzG(1);
                    int zzk2 = this.zzb.zzk();
                    int zzk3 = this.zzb.zzk();
                    if ((zzk2 & 128) != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    this.zze = z11;
                    this.zzc = (((zzk2 & 15) << 8) | zzk3) + 3;
                    int zzb2 = this.zzb.zzb();
                    int i16 = this.zzc;
                    if (zzb2 < i16) {
                        int zzb3 = this.zzb.zzb();
                        this.zzb.zzz(Math.min(InputDeviceCompat.SOURCE_TOUCHSCREEN, Math.max(i16, zzb3 + zzb3)));
                    }
                }
            } else {
                int min2 = Math.min(zzfd.zza(), this.zzc - this.zzd);
                zzfd.zzB(this.zzb.zzH(), this.zzd, min2);
                int i17 = this.zzd + min2;
                this.zzd = i17;
                int i18 = this.zzc;
                if (i17 != i18) {
                    continue;
                } else {
                    if (!this.zze) {
                        this.zzb.zzE(i18);
                    } else if (zzfn.zzg(this.zzb.zzH(), 0, this.zzc, -1) != 0) {
                        this.zzf = true;
                        return;
                    } else {
                        this.zzb.zzE(this.zzc - 4);
                    }
                    this.zzb.zzF(0);
                    this.zza.zza(this.zzb);
                    this.zzd = 0;
                }
            }
        }
    }

    public final void zzb(zzfk zzfk, zzws zzws, zzafd zzafd) {
        this.zza.zzb(zzfk, zzws, zzafd);
        this.zzf = true;
    }

    public final void zzc() {
        this.zzf = true;
    }
}
