package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.instabug.library.model.NetworkLog;
import java.util.Map;

public final /* synthetic */ class zzdri implements zzbrt {
    public final /* synthetic */ zzdrm zza;

    public /* synthetic */ zzdri(zzdrm zzdrm) {
        this.zza = zzdrm;
    }

    public final void zza(Object obj, Map map) {
        zzcop zzcop = (zzcop) obj;
        zzcop.zzP().zzz(new zzdrl(this.zza, map));
        String str = (String) map.get("overlayHtml");
        String str2 = (String) map.get("baseUrl");
        if (TextUtils.isEmpty(str2)) {
            zzcop.loadData(str, NetworkLog.HTML, "UTF-8");
        } else {
            zzcop.loadDataWithBaseURL(str2, str, NetworkLog.HTML, "UTF-8", (String) null);
        }
    }
}
