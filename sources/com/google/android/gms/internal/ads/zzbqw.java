package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.ads.internal.zzt;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import java.util.Map;

public final class zzbqw implements zzbrt<zzcop> {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcop zzcop = (zzcop) obj;
        String str = (String) map.get(NativeProtocol.WEB_DIALOG_ACTION);
        if ("tick".equals(str)) {
            String str2 = (String) map.get("label");
            String str3 = (String) map.get("start_label");
            String str4 = (String) map.get("timestamp");
            if (TextUtils.isEmpty(str2)) {
                zzciz.zzj("No label given for CSI tick.");
            } else if (TextUtils.isEmpty(str4)) {
                zzciz.zzj("No timestamp given for CSI tick.");
            } else {
                try {
                    long elapsedRealtime = zzt.zzA().elapsedRealtime() + (Long.parseLong(str4) - zzt.zzA().currentTimeMillis());
                    if (true == TextUtils.isEmpty(str3)) {
                        str3 = "native:view_load";
                    }
                    zzcop.zzo().zzc(str2, str3, elapsedRealtime);
                } catch (NumberFormatException e11) {
                    zzciz.zzk("Malformed timestamp for CSI tick.", e11);
                }
            }
        } else if (InstabugDbContract.ExperimentsEntry.COLUMN_EXPERIMENT.equals(str)) {
            String str5 = (String) map.get("value");
            if (TextUtils.isEmpty(str5)) {
                zzciz.zzj("No value given for CSI experiment.");
            } else {
                zzcop.zzo().zza().zzd("e", str5);
            }
        } else if ("extra".equals(str)) {
            String str6 = (String) map.get("name");
            String str7 = (String) map.get("value");
            if (TextUtils.isEmpty(str7)) {
                zzciz.zzj("No value given for CSI extra.");
            } else if (TextUtils.isEmpty(str6)) {
                zzciz.zzj("No name given for CSI extra.");
            } else {
                zzcop.zzo().zza().zzd(str6, str7);
            }
        }
    }
}
