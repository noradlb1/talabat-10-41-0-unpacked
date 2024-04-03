package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public final class zzdha extends zzdkb<zzdhc> implements zzdfl, zzdgq {
    private final zzfdn zzb;
    private final AtomicBoolean zzc = new AtomicBoolean();

    public zzdha(Set<zzdlw<zzdhc>> set, zzfdn zzfdn) {
        super(set);
        this.zzb = zzfdn;
    }

    private final void zzb() {
        zzbfk zzbfk;
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfH)).booleanValue() && this.zzc.compareAndSet(false, true) && (zzbfk = this.zzb.zzac) != null && zzbfk.zza == 3) {
            zzo(new zzdgz(this));
        }
    }

    public final /* synthetic */ void zza(zzdhc zzdhc) throws Exception {
        zzdhc.zzg(this.zzb.zzac);
    }

    public final void zzh() {
        if (this.zzb.zzb == 1) {
            zzb();
        }
    }

    public final void zzl() {
        int i11 = this.zzb.zzb;
        if (i11 == 2 || i11 == 5 || i11 == 4 || i11 == 6 || i11 == 7) {
            zzb();
        }
    }
}
