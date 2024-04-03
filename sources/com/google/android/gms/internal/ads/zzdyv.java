package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.nonagon.signalgeneration.zze;
import com.google.firebase.analytics.FirebaseAnalytics;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Map;

@Deprecated
public final class zzdyv {
    private final ConcurrentHashMap<String, String> zza;
    private final zzcio zzb;

    public zzdyv(zzdze zzdze, zzcio zzcio) {
        this.zza = new ConcurrentHashMap<>(zzdze.zzb);
        this.zzb = zzcio;
    }

    public final Map<String, String> zza() {
        return this.zza;
    }

    public final void zzb(zzfdz zzfdz) {
        String str;
        if (zzfdz.zzb.zza.size() > 0) {
            switch (zzfdz.zzb.zza.get(0).zzb) {
                case 1:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "banner");
                    break;
                case 2:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "interstitial");
                    break;
                case 3:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "native_express");
                    break;
                case 4:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "native_advanced");
                    break;
                case 5:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "rewarded");
                    break;
                case 6:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "app_open_ad");
                    ConcurrentHashMap<String, String> concurrentHashMap = this.zza;
                    if (true != this.zzb.zzj()) {
                        str = "0";
                    } else {
                        str = "1";
                    }
                    concurrentHashMap.put("as", str);
                    break;
                default:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "unknown");
                    break;
            }
        }
        if (!TextUtils.isEmpty(zzfdz.zzb.zzb.zzb)) {
            this.zza.put("gqi", zzfdz.zzb.zzb.zzb);
        }
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfs)).booleanValue()) {
            boolean zzd = zze.zzd(zzfdz);
            this.zza.put("scar", String.valueOf(zzd));
            if (zzd) {
                String zzb2 = zze.zzb(zzfdz);
                if (!TextUtils.isEmpty(zzb2)) {
                    this.zza.put("ragent", zzb2);
                }
                String zza2 = zze.zza(zzfdz);
                if (!TextUtils.isEmpty(zza2)) {
                    this.zza.put("rtype", zza2);
                }
            }
        }
    }

    public final void zzc(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zza.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zza.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }
}
