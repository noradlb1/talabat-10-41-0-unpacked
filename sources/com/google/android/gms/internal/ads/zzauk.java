package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.C;
import java.io.IOException;

public final class zzauk implements zzauo, zzaun {
    private final Uri zza;
    private final zzavv zzb;
    private final zzarl zzc;
    private final int zzd;
    private final Handler zze;
    private final zzauj zzf;
    private final zzapp zzg = new zzapp();
    private final int zzh;
    private zzaun zzi;
    private zzapr zzj;
    private boolean zzk;

    public zzauk(Uri uri, zzavv zzavv, zzarl zzarl, int i11, Handler handler, zzauj zzauj, String str, int i12) {
        this.zza = uri;
        this.zzb = zzavv;
        this.zzc = zzarl;
        this.zzd = i11;
        this.zze = handler;
        this.zzf = zzauj;
        this.zzh = i12;
    }

    public final void zza() throws IOException {
    }

    public final void zzb(zzaow zzaow, boolean z11, zzaun zzaun) {
        this.zzi = zzaun;
        zzavb zzavb = new zzavb(C.TIME_UNSET, false);
        this.zzj = zzavb;
        zzaun.zze(zzavb, (Object) null);
    }

    public final void zzc(zzaum zzaum) {
        ((zzaui) zzaum).zzx();
    }

    public final void zzd() {
        this.zzi = null;
    }

    public final void zze(zzapr zzapr, Object obj) {
        zzapp zzapp = this.zzg;
        boolean z11 = false;
        zzapr.zzd(0, zzapp, false);
        if (zzapp.zzc != C.TIME_UNSET) {
            z11 = true;
        }
        if (!this.zzk || z11) {
            this.zzj = zzapr;
            this.zzk = z11;
            this.zzi.zze(zzapr, (Object) null);
        }
    }

    public final zzaum zzf(int i11, zzavz zzavz) {
        boolean z11;
        if (i11 == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        zzawm.zzc(z11);
        return new zzaui(this.zza, this.zzb.zza(), this.zzc.zza(), this.zzd, this.zze, this.zzf, this, zzavz, (String) null, this.zzh, (byte[]) null);
    }
}
