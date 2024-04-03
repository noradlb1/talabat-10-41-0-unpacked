package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import datamodels.TypesAliasesKt;
import java.util.HashMap;
import java.util.Map;

public final /* synthetic */ class zzbra implements zzbrt {
    public static final /* synthetic */ zzbra zza = new zzbra();

    private /* synthetic */ zzbra() {
    }

    public final void zza(Object obj, Map map) {
        String str;
        zzcpq zzcpq = (zzcpq) obj;
        zzbrt<zzcop> zzbrt = zzbrs.zza;
        String str2 = (String) map.get("urls");
        if (TextUtils.isEmpty(str2)) {
            zzciz.zzj("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str2.split(",");
        HashMap hashMap = new HashMap();
        PackageManager packageManager = zzcpq.getContext().getPackageManager();
        for (String str3 : split) {
            String[] split2 = str3.split(TypesAliasesKt.separator, 2);
            String trim = split2[0].trim();
            boolean z11 = true;
            if (split2.length > 1) {
                str = split2[1].trim();
            } else {
                str = "android.intent.action.VIEW";
            }
            if (packageManager.resolveActivity(new Intent(str, Uri.parse(trim)), 65536) == null) {
                z11 = false;
            }
            Boolean valueOf = Boolean.valueOf(z11);
            hashMap.put(str3, valueOf);
            String obj2 = valueOf.toString();
            StringBuilder sb2 = new StringBuilder(str3.length() + 14 + obj2.length());
            sb2.append("/canOpenURLs;");
            sb2.append(str3);
            sb2.append(TypesAliasesKt.separator);
            sb2.append(obj2);
            zze.zza(sb2.toString());
        }
        ((zzbuk) zzcpq).zzd("openableURLs", hashMap);
    }
}
