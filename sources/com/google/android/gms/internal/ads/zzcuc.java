package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.nonagon.signalgeneration.zzf;
import com.google.android.gms.ads.nonagon.signalgeneration.zzg;
import com.google.android.gms.ads.nonagon.signalgeneration.zzz;

final class zzcuc implements zzf {
    private final zzcui zza;
    private zzded zzb;
    private zzz zzc;

    public /* synthetic */ zzcuc(zzcui zzcui, zzcub zzcub) {
        this.zza = zzcui;
    }

    public final /* synthetic */ zzf zza(zzded zzded) {
        this.zzb = zzded;
        return this;
    }

    public final /* synthetic */ zzf zzb(zzz zzz) {
        this.zzc = zzz;
        return this;
    }

    public final zzg zzc() {
        zzgpz.zzc(this.zzb, zzded.class);
        zzgpz.zzc(this.zzc, zzz.class);
        return new zzcue(this.zza, this.zzc, new zzdca(), new zzdzm(), this.zzb, new zzfff(), (zzfbi) null, (zzfaj) null, (zzcud) null);
    }
}
