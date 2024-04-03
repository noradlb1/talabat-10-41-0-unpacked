package com.google.android.gms.internal.ads;

import com.apptimize.ed;
import com.facebook.internal.NativeProtocol;

public final class zzdym implements zzdhm, zzdgf, zzdeu, zzdhq {
    private final zzdyv zza;
    private final zzdze zzb;

    public zzdym(zzdyv zzdyv, zzdze zzdze) {
        this.zza = zzdyv;
        this.zzb = zzdze;
    }

    public final void zza(zzbew zzbew) {
        this.zza.zza().put(NativeProtocol.WEB_DIALOG_ACTION, "ftl");
        this.zza.zza().put("ftl", String.valueOf(zzbew.zza));
        this.zza.zza().put(ed.f42236a, zzbew.zzc);
        this.zzb.zzc(this.zza.zza());
    }

    public final void zzbM(boolean z11) {
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfs)).booleanValue()) {
            this.zza.zza().put("scar", "true");
        }
    }

    public final void zzd(zzcdq zzcdq) {
        this.zza.zzc(zzcdq.zza);
    }

    public final void zze(zzfdz zzfdz) {
        this.zza.zzb(zzfdz);
    }

    public final void zzn() {
        this.zza.zza().put(NativeProtocol.WEB_DIALOG_ACTION, "loaded");
        this.zzb.zzc(this.zza.zza());
    }
}
