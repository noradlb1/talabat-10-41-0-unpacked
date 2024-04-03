package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.ads.nonagon.signalgeneration.zze;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.HashMap;
import java.util.Map;

public final class zzfin {
    private final HashMap<String, String> zza;
    private final zzfiu zzb = new zzfiu(zzt.zzA());

    private zzfin() {
        HashMap<String, String> hashMap = new HashMap<>();
        this.zza = hashMap;
        hashMap.put("new_csi", "1");
    }

    public static zzfin zzb(String str) {
        zzfin zzfin = new zzfin();
        zzfin.zza.put(NativeProtocol.WEB_DIALOG_ACTION, str);
        return zzfin;
    }

    public static zzfin zzc(String str) {
        zzfin zzfin = new zzfin();
        zzfin.zza.put("request_id", str);
        return zzfin;
    }

    public final zzfin zza(@NonNull String str, @NonNull String str2) {
        this.zza.put(str, str2);
        return this;
    }

    public final zzfin zzd(@NonNull String str) {
        this.zzb.zzb(str);
        return this;
    }

    public final zzfin zze(@NonNull String str, @NonNull String str2) {
        this.zzb.zzc(str, str2);
        return this;
    }

    public final zzfin zzf(zzfdn zzfdn) {
        this.zza.put("aai", zzfdn.zzx);
        return this;
    }

    public final zzfin zzg(zzfdq zzfdq) {
        if (!TextUtils.isEmpty(zzfdq.zzb)) {
            this.zza.put("gqi", zzfdq.zzb);
        }
        return this;
    }

    public final zzfin zzh(zzfdz zzfdz, @Nullable zzcio zzcio) {
        String str;
        zzfdy zzfdy = zzfdz.zzb;
        zzg(zzfdy.zzb);
        if (!zzfdy.zza.isEmpty()) {
            switch (zzfdy.zza.get(0).zzb) {
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
                    if (zzcio != null) {
                        HashMap<String, String> hashMap = this.zza;
                        if (true != zzcio.zzj()) {
                            str = "0";
                        } else {
                            str = "1";
                        }
                        hashMap.put("as", str);
                        break;
                    }
                    break;
                default:
                    this.zza.put(FirebaseAnalytics.Param.AD_FORMAT, "unknown");
                    break;
            }
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
        return this;
    }

    public final zzfin zzi(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zza.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zza.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
        return this;
    }

    public final Map<String, String> zzj() {
        HashMap hashMap = new HashMap(this.zza);
        for (zzfit next : this.zzb.zza()) {
            hashMap.put(next.zza, next.zzb);
        }
        return hashMap;
    }
}
