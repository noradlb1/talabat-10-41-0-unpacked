package com.google.android.gms.internal.ads;

import com.facebook.internal.NativeProtocol;
import java.util.Map;

final class zzbrp implements zzbrt<zzcop> {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcop zzcop = (zzcop) obj;
        String str = (String) map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if ("pause".equals(str)) {
            zzcop.zzbv();
        } else if ("resume".equals(str)) {
            zzcop.zzbw();
        }
    }
}
