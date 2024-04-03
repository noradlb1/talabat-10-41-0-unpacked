package com.google.android.gms.internal.ads;

import com.apptimize.ed;
import com.facebook.internal.NativeProtocol;

public final class zzefr implements zzdhm, zzdgf, zzdeu, zzdhq {
    private final zzfin zza;
    private final zzfio zzb;
    private final zzcio zzc;

    public zzefr(zzfin zzfin, zzfio zzfio, zzcio zzcio) {
        this.zza = zzfin;
        this.zzb = zzfio;
        this.zzc = zzcio;
    }

    public final void zza(zzbew zzbew) {
        zzfin zzfin = this.zza;
        zzfin.zza(NativeProtocol.WEB_DIALOG_ACTION, "ftl");
        zzfin.zza("ftl", String.valueOf(zzbew.zza));
        zzfin.zza(ed.f42236a, zzbew.zzc);
        this.zzb.zzb(this.zza);
    }

    public final void zzbM(boolean z11) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfs)).booleanValue()) {
            this.zza.zza("scar", "true");
        }
    }

    public final void zzd(zzcdq zzcdq) {
        this.zza.zzi(zzcdq.zza);
    }

    public final void zze(zzfdz zzfdz) {
        this.zza.zzh(zzfdz, this.zzc);
    }

    public final void zzn() {
        zzfio zzfio = this.zzb;
        zzfin zzfin = this.zza;
        zzfin.zza(NativeProtocol.WEB_DIALOG_ACTION, "loaded");
        zzfio.zzb(zzfin);
    }
}
