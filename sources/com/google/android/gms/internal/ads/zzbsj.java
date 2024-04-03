package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import java.util.Map;

public final class zzbsj implements zzbrt<Object> {
    private final zzbsi zza;

    public zzbsj(zzbsi zzbsi) {
        this.zza = zzbsi;
    }

    public static void zzb(zzcop zzcop, zzbsi zzbsi) {
        zzcop.zzaf("/reward", new zzbsj(zzbsi));
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if ("grant".equals(str)) {
            zzces zzces = null;
            try {
                int parseInt = Integer.parseInt(map.get("amount"));
                String str2 = map.get("type");
                if (!TextUtils.isEmpty(str2)) {
                    zzces = new zzces(str2, parseInt);
                }
            } catch (NumberFormatException e11) {
                zzciz.zzk("Unable to parse reward amount.", e11);
            }
            this.zza.zza(zzces);
        } else if ("video_start".equals(str)) {
            this.zza.zzc();
        } else if ("video_complete".equals(str)) {
            this.zza.zzb();
        }
    }
}
