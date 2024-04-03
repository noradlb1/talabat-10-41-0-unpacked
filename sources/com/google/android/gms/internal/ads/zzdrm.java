package com.google.android.gms.internal.ads;

import android.view.View;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class zzdrm {
    private final zzdwj zza;
    private final zzduy zzb;
    private final zzcxp zzc;
    private final zzdqk zzd;

    public zzdrm(zzdwj zzdwj, zzduy zzduy, zzcxp zzcxp, zzdqk zzdqk) {
        this.zza = zzdwj;
        this.zzb = zzduy;
        this.zzc = zzcxp;
        this.zzd = zzdqk;
    }

    public final View zza() throws zzcpa {
        zzcop zza2 = this.zza.zza(zzbfi.zzc(), (zzfdn) null, (zzfdq) null);
        ((View) zza2).setVisibility(8);
        zza2.zzaf("/sendMessageToSdk", new zzdrg(this));
        zza2.zzaf("/adMuted", new zzdrh(this));
        this.zzb.zzj(new WeakReference(zza2), "/loadHtml", new zzdri(this));
        this.zzb.zzj(new WeakReference(zza2), "/showOverlay", new zzdrj(this));
        this.zzb.zzj(new WeakReference(zza2), "/hideOverlay", new zzdrk(this));
        return (View) zza2;
    }

    public final /* synthetic */ void zzb(zzcop zzcop, Map map) {
        this.zzb.zzg("sendMessageToNativeJs", map);
    }

    public final /* synthetic */ void zzc(zzcop zzcop, Map map) {
        this.zzd.zzf();
    }

    public final /* synthetic */ void zzd(Map map, boolean z11) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "htmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzb.zzg("sendMessageToNativeJs", hashMap);
    }

    public final /* synthetic */ void zze(zzcop zzcop, Map map) {
        zzciz.zzi("Showing native ads overlay.");
        zzcop.zzH().setVisibility(0);
        this.zzc.zze(true);
    }

    public final /* synthetic */ void zzf(zzcop zzcop, Map map) {
        zzciz.zzi("Hiding native ads overlay.");
        zzcop.zzH().setVisibility(8);
        this.zzc.zze(false);
    }
}
