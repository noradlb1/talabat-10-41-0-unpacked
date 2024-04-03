package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zze;
import com.huawei.wearengine.common.Constants;
import datamodels.TypesAliasesKt;
import java.util.HashMap;
import java.util.Map;

public final /* synthetic */ class zzbqy implements zzbrt {
    public static final /* synthetic */ zzbqy zza = new zzbqy();

    private /* synthetic */ zzbqy() {
    }

    public final void zza(Object obj, Map map) {
        boolean z11;
        zzcpq zzcpq = (zzcpq) obj;
        zzbrt<zzcop> zzbrt = zzbrs.zza;
        if (!((Boolean) zzbgq.zzc().zzb(zzblj.zzfZ)).booleanValue()) {
            zzciz.zzj("canOpenAppGmsgHandler disabled.");
            return;
        }
        String str = (String) map.get(Constants.PACKAGE_NAME);
        if (TextUtils.isEmpty(str)) {
            zzciz.zzj("Package name missing in canOpenApp GMSG.");
            return;
        }
        HashMap hashMap = new HashMap();
        if (zzcpq.getContext().getPackageManager().getLaunchIntentForPackage(str) != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Boolean valueOf = Boolean.valueOf(z11);
        hashMap.put(str, valueOf);
        String obj2 = valueOf.toString();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 13 + obj2.length());
        sb2.append("/canOpenApp;");
        sb2.append(str);
        sb2.append(TypesAliasesKt.separator);
        sb2.append(obj2);
        zze.zza(sb2.toString());
        ((zzbuk) zzcpq).zzd("openableApp", hashMap);
    }
}
