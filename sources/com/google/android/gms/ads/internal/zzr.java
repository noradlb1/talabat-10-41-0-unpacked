package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbfd;
import com.google.android.gms.internal.ads.zzbmn;
import com.google.android.gms.internal.ads.zzciz;
import com.google.android.gms.internal.ads.zzcjf;
import com.google.android.gms.internal.ads.zzevk;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;

final class zzr {
    private final Context zza;
    private final String zzb;
    private final Map<String, String> zzc = new TreeMap();
    private String zzd;
    private String zze;
    private final String zzf;

    public zzr(Context context, String str) {
        String str2;
        this.zza = context.getApplicationContext();
        this.zzb = str;
        String packageName = context.getPackageName();
        try {
            String str3 = Wrappers.packageManager(context).getPackageInfo(context.getPackageName(), 0).versionName;
            StringBuilder sb2 = new StringBuilder(String.valueOf(packageName).length() + 1 + String.valueOf(str3).length());
            sb2.append(packageName);
            sb2.append(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE);
            sb2.append(str3);
            str2 = sb2.toString();
        } catch (PackageManager.NameNotFoundException e11) {
            zzciz.zzh("Unable to get package version name for reporting", e11);
            str2 = String.valueOf(packageName).concat("-missing");
        }
        this.zzf = str2;
    }

    public final String zza() {
        return this.zzf;
    }

    public final String zzb() {
        return this.zze;
    }

    public final String zzc() {
        return this.zzb;
    }

    public final String zzd() {
        return this.zzd;
    }

    public final Map<String, String> zze() {
        return this.zzc;
    }

    public final void zzf(zzbfd zzbfd, zzcjf zzcjf) {
        Bundle bundle;
        this.zzd = zzbfd.zzj.zza;
        Bundle bundle2 = zzbfd.zzm;
        if (bundle2 != null) {
            bundle = bundle2.getBundle(AdMobAdapter.class.getName());
        } else {
            bundle = null;
        }
        if (bundle != null) {
            String zze2 = zzbmn.zzc.zze();
            for (String next : bundle.keySet()) {
                if (zze2.equals(next)) {
                    this.zze = bundle.getString(next);
                } else if (next.startsWith("csa_")) {
                    this.zzc.put(next.substring(4), bundle.getString(next));
                }
            }
            this.zzc.put("SDKVersion", zzcjf.zza);
            if (zzbmn.zza.zze().booleanValue()) {
                try {
                    Bundle zza2 = zzevk.zza(this.zza, new JSONArray(zzbmn.zzb.zze()));
                    for (String next2 : zza2.keySet()) {
                        this.zzc.put(next2, zza2.get(next2).toString());
                    }
                } catch (JSONException e11) {
                    zzciz.zzh("Flag gads:afs:csa_tcf_data_to_collect not a valid JSON array", e11);
                }
            }
        }
    }
}
