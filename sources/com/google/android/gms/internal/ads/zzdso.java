package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;

public final class zzdso {
    private final zzfxb zza;
    private final zzdtb zzb;
    private final zzdtg zzc;

    public zzdso(zzfxb zzfxb, zzdtb zzdtb, zzdtg zzdtg) {
        this.zza = zzfxb;
        this.zzb = zzdtb;
        this.zzc = zzdtg;
    }

    public final zzfxa<zzdqc> zza(zzfdz zzfdz, zzfdn zzfdn, JSONObject jSONObject) {
        zzfxa zzn;
        zzfdz zzfdz2 = zzfdz;
        zzfdn zzfdn2 = zzfdn;
        JSONObject jSONObject2 = jSONObject;
        zzfxa zzb2 = this.zza.zzb(new zzdsm(this, zzfdz2, zzfdn2, jSONObject2));
        zzfxa<List<zzbnu>> zzf = this.zzb.zzf(jSONObject2, "images");
        zzfxa<zzcop> zzg = this.zzb.zzg(jSONObject2, "images", zzfdn2, zzfdz2.zzb.zzb);
        zzfxa<zzbnu> zze = this.zzb.zze(jSONObject2, "secondary_image");
        zzfxa<zzbnu> zze2 = this.zzb.zze(jSONObject2, "app_icon");
        zzfxa<zzbnr> zzd = this.zzb.zzd(jSONObject2, "attribution");
        zzfxa<zzcop> zzh = this.zzb.zzh(jSONObject2, zzfdn2, zzfdz2.zzb.zzb);
        zzdtb zzdtb = this.zzb;
        if (!jSONObject2.optBoolean("enable_omid")) {
            zzn = zzfwq.zzi(null);
        } else {
            JSONObject optJSONObject = jSONObject2.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                zzn = zzfwq.zzi(null);
            } else {
                String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    zzn = zzfwq.zzi(null);
                } else {
                    zzn = zzfwq.zzn(zzfwq.zzi(null), new zzdsx(zzdtb, optString), zzcjm.zze);
                }
            }
        }
        zzfxa zzfxa = zzn;
        zzfxa<List<zzdtf>> zza2 = this.zzc.zza(jSONObject2, "custom_assets");
        return zzfwq.zzb(zzb2, zzf, zzg, zze, zze2, zzd, zzh, zzfxa, zza2).zza(new zzdsn(this, zzb2, zzf, zze2, zze, zzd, jSONObject, zzh, zzg, zzfxa, zza2), this.zza);
    }
}
