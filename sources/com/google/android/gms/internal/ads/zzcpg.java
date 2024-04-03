package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

final class zzcpg implements zzbrt<zzcop> {
    final /* synthetic */ zzcpi zza;

    public zzcpg(zzcpi zzcpi) {
        this.zza = zzcpi;
    }

    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcop zzcop = (zzcop) obj;
        if (map != null) {
            String str = (String) map.get("height");
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zza) {
                        if (this.zza.zzG != parseInt) {
                            this.zza.zzG = parseInt;
                            this.zza.requestLayout();
                        }
                    }
                } catch (Exception e11) {
                    zzciz.zzk("Exception occurred while getting webview content height", e11);
                }
            }
        }
    }
}
