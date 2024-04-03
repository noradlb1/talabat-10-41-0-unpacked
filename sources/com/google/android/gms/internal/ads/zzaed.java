package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.util.MimeTypes;

public final class zzaed implements zzadr {
    private final zzfd zza = new zzfd(10);
    private zzxt zzb;
    private boolean zzc;
    private long zzd = C.TIME_UNSET;
    private int zze;
    private int zzf;

    public final void zza(zzfd zzfd) {
        zzdy.zzb(this.zzb);
        if (this.zzc) {
            int zza2 = zzfd.zza();
            int i11 = this.zzf;
            if (i11 < 10) {
                int min = Math.min(zza2, 10 - i11);
                System.arraycopy(zzfd.zzH(), zzfd.zzc(), this.zza.zzH(), this.zzf, min);
                if (this.zzf + min == 10) {
                    this.zza.zzF(0);
                    if (this.zza.zzk() == 73 && this.zza.zzk() == 68 && this.zza.zzk() == 51) {
                        this.zza.zzG(3);
                        this.zze = this.zza.zzj() + 10;
                    } else {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.zzc = false;
                        return;
                    }
                }
            }
            int min2 = Math.min(zza2, this.zze - this.zzf);
            zzxr.zzb(this.zzb, zzfd, min2);
            this.zzf += min2;
        }
    }

    public final void zzb(zzws zzws, zzafd zzafd) {
        zzafd.zzc();
        zzxt zzv = zzws.zzv(zzafd.zza(), 5);
        this.zzb = zzv;
        zzz zzz = new zzz();
        zzz.zzH(zzafd.zzb());
        zzz.zzS(MimeTypes.APPLICATION_ID3);
        zzv.zzk(zzz.zzY());
    }

    public final void zzc() {
        int i11;
        zzdy.zzb(this.zzb);
        if (this.zzc && (i11 = this.zze) != 0 && this.zzf == i11) {
            long j11 = this.zzd;
            if (j11 != C.TIME_UNSET) {
                this.zzb.zzs(j11, 1, i11, 0, (zzxs) null);
            }
            this.zzc = false;
        }
    }

    public final void zzd(long j11, int i11) {
        if ((i11 & 4) != 0) {
            this.zzc = true;
            if (j11 != C.TIME_UNSET) {
                this.zzd = j11;
            }
            this.zze = 0;
            this.zzf = 0;
        }
    }

    public final void zze() {
        this.zzc = false;
        this.zzd = C.TIME_UNSET;
    }
}
