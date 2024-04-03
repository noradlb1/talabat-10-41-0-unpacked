package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.util.MimeTypes;
import java.util.List;

public final class zzaes {
    private final List<zzab> zza;
    private final zzxt[] zzb;

    public zzaes(List<zzab> list) {
        this.zza = list;
        this.zzb = new zzxt[list.size()];
    }

    public final void zza(long j11, zzfd zzfd) {
        zzwh.zza(j11, zzfd, this.zzb);
    }

    public final void zzb(zzws zzws, zzafd zzafd) {
        String str;
        for (int i11 = 0; i11 < this.zzb.length; i11++) {
            zzafd.zzc();
            zzxt zzv = zzws.zzv(zzafd.zza(), 3);
            zzab zzab = this.zza.get(i11);
            String str2 = zzab.zzm;
            boolean z11 = true;
            if (!MimeTypes.APPLICATION_CEA608.equals(str2) && !MimeTypes.APPLICATION_CEA708.equals(str2)) {
                z11 = false;
            }
            String valueOf = String.valueOf(str2);
            if (valueOf.length() != 0) {
                str = "Invalid closed caption mime type provided: ".concat(valueOf);
            } else {
                str = new String("Invalid closed caption mime type provided: ");
            }
            zzdy.zze(z11, str);
            String str3 = zzab.zzb;
            if (str3 == null) {
                str3 = zzafd.zzb();
            }
            zzz zzz = new zzz();
            zzz.zzH(str3);
            zzz.zzS(str2);
            zzz.zzU(zzab.zze);
            zzz.zzK(zzab.zzd);
            zzz.zzu(zzab.zzE);
            zzz.zzI(zzab.zzo);
            zzv.zzk(zzz.zzY());
            this.zzb[i11] = zzv;
        }
    }
}
