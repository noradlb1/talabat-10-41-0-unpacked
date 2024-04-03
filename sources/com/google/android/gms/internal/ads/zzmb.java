package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.AudioTrack;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;

final class zzmb {
    @Nullable
    private final zzma zza;
    private int zzb;
    private long zzc;
    private long zzd;
    private long zze;
    private long zzf;

    public zzmb(AudioTrack audioTrack) {
        if (zzfn.zza >= 19) {
            this.zza = new zzma(audioTrack);
            zze();
            return;
        }
        this.zza = null;
        zzh(3);
    }

    private final void zzh(int i11) {
        this.zzb = i11;
        long j11 = 10000;
        if (i11 == 0) {
            this.zze = 0;
            this.zzf = -1;
            this.zzc = System.nanoTime() / 1000;
        } else if (i11 != 1) {
            j11 = (i11 == 2 || i11 == 3) ? 10000000 : 500000;
        } else {
            this.zzd = 10000;
            return;
        }
        this.zzd = j11;
    }

    @TargetApi(19)
    public final long zza() {
        zzma zzma = this.zza;
        if (zzma != null) {
            return zzma.zza();
        }
        return -1;
    }

    @TargetApi(19)
    public final long zzb() {
        zzma zzma = this.zza;
        return zzma != null ? zzma.zzb() : C.TIME_UNSET;
    }

    public final void zzc() {
        if (this.zzb == 4) {
            zze();
        }
    }

    public final void zzd() {
        zzh(4);
    }

    public final void zze() {
        if (this.zza != null) {
            zzh(0);
        }
    }

    public final boolean zzf() {
        return this.zzb == 2;
    }

    @TargetApi(19)
    public final boolean zzg(long j11) {
        zzma zzma = this.zza;
        if (zzma != null && j11 - this.zze >= this.zzd) {
            this.zze = j11;
            boolean zzc2 = zzma.zzc();
            int i11 = this.zzb;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 != 2) {
                        if (i11 == 3 && zzc2) {
                            zze();
                            return true;
                        }
                    } else if (!zzc2) {
                        zze();
                        return false;
                    }
                } else if (!zzc2) {
                    zze();
                } else if (this.zza.zza() > this.zzf) {
                    zzh(2);
                    return true;
                }
            } else if (zzc2) {
                if (this.zza.zzb() < this.zzc) {
                    return false;
                }
                this.zzf = this.zza.zza();
                zzh(1);
                return true;
            } else if (j11 - this.zzc > 500000) {
                zzh(3);
            }
            return zzc2;
        }
        return false;
    }
}
