package com.google.android.gms.internal.consent_sdk;

final class zzak implements zzar {
    private zzct<zzbh> zza;
    private zzct<zzbb> zzb;
    private zzct<zzat> zzc;
    private zzct zzd;
    private zzct<zzbe> zze;
    private final /* synthetic */ zzag zzf;

    private zzak(zzag zzag, zzbb zzbb) {
        this.zzf = zzag;
        this.zza = zzcq.zza(new zzbk(zzag.zza));
        this.zzb = zzcs.zza(zzbb);
        this.zzc = new zzcn();
        this.zzd = new zzbo(zzag.zza, this.zza, zzaq.zza, zzas.zza, zzag.zzh, zzag.zzi, this.zzc);
        this.zze = new zzbi(this.zza, zzaq.zza, this.zzd);
        zzcn.zza(this.zzc, zzcq.zza(new zzba(zzag.zza, zzag.zzc, this.zza, zzag.zzb, this.zzb, this.zze)));
    }

    public final zzat zza() {
        return this.zzc.zza();
    }

    public /* synthetic */ zzak(zzag zzag, zzbb zzbb, zzaf zzaf) {
        this(zzag, zzbb);
    }
}
