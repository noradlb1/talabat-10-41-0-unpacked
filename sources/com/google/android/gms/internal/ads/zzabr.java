package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;

final class zzabr implements zzabp {
    private final int zza;
    private final int zzb;
    private final zzfd zzc;

    public zzabr(zzabm zzabm, zzab zzab) {
        zzfd zzfd = zzabm.zza;
        this.zzc = zzfd;
        zzfd.zzF(12);
        int zzn = zzfd.zzn();
        if (MimeTypes.AUDIO_RAW.equals(zzab.zzm)) {
            int zzm = zzfn.zzm(zzab.zzB, zzab.zzz);
            if (zzn == 0 || zzn % zzm != 0) {
                StringBuilder sb2 = new StringBuilder(88);
                sb2.append("Audio sample size mismatch. stsd sample size: ");
                sb2.append(zzm);
                sb2.append(", stsz sample size: ");
                sb2.append(zzn);
                Log.w("AtomParsers", sb2.toString());
                zzn = zzm;
            }
        }
        this.zza = zzn == 0 ? -1 : zzn;
        this.zzb = zzfd.zzn();
    }

    public final int zza() {
        return this.zza;
    }

    public final int zzb() {
        return this.zzb;
    }

    public final int zzc() {
        int i11 = this.zza;
        return i11 == -1 ? this.zzc.zzn() : i11;
    }
}
