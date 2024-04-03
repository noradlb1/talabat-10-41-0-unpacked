package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzblj;
import com.google.android.gms.internal.ads.zzbvx;
import com.google.android.gms.internal.ads.zzbwb;
import com.google.android.gms.internal.ads.zzbwe;
import com.google.android.gms.internal.ads.zzbwh;
import com.google.android.gms.internal.ads.zzcif;
import com.google.android.gms.internal.ads.zzciz;
import com.google.android.gms.internal.ads.zzcjf;
import com.google.android.gms.internal.ads.zzcjm;
import com.google.android.gms.internal.ads.zzcjp;
import com.google.android.gms.internal.ads.zzfwq;
import com.google.android.gms.internal.ads.zzfxa;
import com.google.android.gms.internal.ads.zzfxb;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zze {
    private Context zza;
    private long zzb = 0;

    public final void zza(Context context, zzcjf zzcjf, String str, @Nullable Runnable runnable) {
        zzb(context, zzcjf, true, (zzcif) null, str, (String) null, runnable);
    }

    @VisibleForTesting
    public final void zzb(Context context, zzcjf zzcjf, boolean z11, @Nullable zzcif zzcif, String str, @Nullable String str2, @Nullable Runnable runnable) {
        PackageInfo packageInfo;
        if (zzt.zzA().elapsedRealtime() - this.zzb < 5000) {
            zzciz.zzj("Not retrying to fetch app settings");
            return;
        }
        this.zzb = zzt.zzA().elapsedRealtime();
        if (zzcif != null) {
            long zza2 = zzcif.zza();
            if (zzt.zzA().currentTimeMillis() - zza2 <= ((Long) zzbgq.zzc().zzb(zzblj.zzcE)).longValue() && zzcif.zzi()) {
                return;
            }
        }
        if (context == null) {
            zzciz.zzj("Context not provided to fetch application settings");
        } else if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            Context applicationContext = context.getApplicationContext();
            if (applicationContext == null) {
                applicationContext = context;
            }
            this.zza = applicationContext;
            zzbwh zza3 = zzt.zzf().zza(this.zza, zzcjf);
            zzbwb<JSONObject> zzbwb = zzbwe.zza;
            zzbvx<I, O> zza4 = zza3.zza("google.afma.config.fetchAppSettings", zzbwb, zzbwb);
            try {
                JSONObject jSONObject = new JSONObject();
                if (!TextUtils.isEmpty(str)) {
                    jSONObject.put("app_id", (Object) str);
                } else if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put("ad_unit_id", (Object) str2);
                }
                jSONObject.put("is_init", z11);
                jSONObject.put("pn", (Object) context.getPackageName());
                jSONObject.put("experiment_ids", (Object) TextUtils.join(",", zzblj.zza()));
                try {
                    ApplicationInfo applicationInfo = this.zza.getApplicationInfo();
                    if (!(applicationInfo == null || (packageInfo = Wrappers.packageManager(context).getPackageInfo(applicationInfo.packageName, 0)) == null)) {
                        jSONObject.put("version", packageInfo.versionCode);
                    }
                } catch (PackageManager.NameNotFoundException unused) {
                    com.google.android.gms.ads.internal.util.zze.zza("Error fetching PackageInfo.");
                }
                zzfxa<O> zzb2 = zza4.zzb(jSONObject);
                zzd zzd = zzd.zza;
                zzfxb zzfxb = zzcjm.zzf;
                zzfxa<O> zzn = zzfwq.zzn(zzb2, zzd, zzfxb);
                if (runnable != null) {
                    zzb2.zzc(runnable, zzfxb);
                }
                zzcjp.zza(zzn, "ConfigLoader.maybeFetchNewAppSettings");
            } catch (Exception e11) {
                zzciz.zzh("Error requesting application settings", e11);
            }
        } else {
            zzciz.zzj("App settings could not be fetched. Required parameters missing");
        }
    }

    public final void zzc(Context context, zzcjf zzcjf, String str, zzcif zzcif) {
        zzb(context, zzcjf, false, zzcif, zzcif != null ? zzcif.zzb() : null, str, (Runnable) null);
    }
}
