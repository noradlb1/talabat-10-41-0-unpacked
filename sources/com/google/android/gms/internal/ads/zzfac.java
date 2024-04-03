package com.google.android.gms.internal.ads;

import java.util.Iterator;

public final /* synthetic */ class zzfac implements zzfvx {
    public final /* synthetic */ zzfad zza;
    public final /* synthetic */ zzffw zzb;
    public final /* synthetic */ zzdby zzc;

    public /* synthetic */ zzfac(zzfad zzfad, zzffw zzffw, zzdby zzdby) {
        this.zza = zzfad;
        this.zzb = zzffw;
        this.zzc = zzdby;
    }

    public final zzfxa zza(Object obj) {
        zzffw zzffw = this.zzb;
        zzdby zzdby = this.zzc;
        zzfdz zzfdz = (zzfdz) obj;
        zzffw.zzb = zzfdz;
        Iterator<zzfdn> it = zzfdz.zzb.zza.iterator();
        boolean z11 = false;
        loop0:
        while (true) {
            if (it.hasNext()) {
                Iterator<String> it2 = it.next().zza.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (!it2.next().contains("FirstPartyRenderer")) {
                            break loop0;
                        }
                        z11 = true;
                    }
                }
            } else if (z11) {
                return zzdby.zzh(zzfwq.zzi(zzfdz));
            }
        }
        return zzfwq.zzi(null);
    }
}
