package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.common.util.VisibleForTesting;
import com.huawei.hms.framework.common.ContainerUtils;

public final class zzchj {
    @VisibleForTesting
    public static Uri zza(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        if (indexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        int i11 = indexOf + 1;
        return Uri.parse(str.substring(0, i11) + str2 + "=" + str3 + ContainerUtils.FIELD_DELIMITER + str.substring(i11));
    }

    public static String zzb(Uri uri, Context context) {
        if (!zzt.zzn().zzu(context)) {
            return uri.toString();
        }
        String zza = zzt.zzn().zza(context);
        if (zza == null) {
            return uri.toString();
        }
        String str = (String) zzbgq.zzc().zzb(zzblj.zzZ);
        String uri2 = uri.toString();
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzY)).booleanValue() && uri2.contains(str)) {
            zzt.zzn().zzm(context, zza);
            return zzd(uri2, context).replace(str, zza);
        } else if (!TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            return uri2;
        } else {
            String uri3 = zza(zzd(uri2, context), "fbs_aeid", zza).toString();
            zzt.zzn().zzm(context, zza);
            return uri3;
        }
    }

    public static String zzc(String str, Context context, boolean z11) {
        String zza;
        if ((((Boolean) zzbgq.zzc().zzb(zzblj.zzag)).booleanValue() && !z11) || !zzt.zzn().zzu(context) || TextUtils.isEmpty(str) || (zza = zzt.zzn().zza(context)) == null) {
            return str;
        }
        String str2 = (String) zzbgq.zzc().zzb(zzblj.zzZ);
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzY)).booleanValue() || !str.contains(str2)) {
            if (str.contains("fbs_aeid")) {
                return str;
            }
            if (zzt.zzp().zzo(str)) {
                zzt.zzn().zzm(context, zza);
                return zza(zzd(str, context), "fbs_aeid", zza).toString();
            } else if (!zzt.zzp().zzp(str)) {
                return str;
            } else {
                zzt.zzn().zzn(context, zza);
                return zza(zzd(str, context), "fbs_aeid", zza).toString();
            }
        } else if (zzt.zzp().zzo(str)) {
            zzt.zzn().zzm(context, zza);
            return zzd(str, context).replace(str2, zza);
        } else if (!zzt.zzp().zzp(str)) {
            return str;
        } else {
            zzt.zzn().zzn(context, zza);
            return zzd(str, context).replace(str2, zza);
        }
    }

    private static String zzd(String str, Context context) {
        String zze = zzt.zzn().zze(context);
        String zzc = zzt.zzn().zzc(context);
        if (!str.contains("gmp_app_id") && !TextUtils.isEmpty(zze)) {
            str = zza(str, "gmp_app_id", zze).toString();
        }
        if (str.contains("fbs_aiid") || TextUtils.isEmpty(zzc)) {
            return str;
        }
        return zza(str, "fbs_aiid", zzc).toString();
    }
}
