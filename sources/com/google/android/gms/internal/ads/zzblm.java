package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.internal.zzt;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

public final class zzblm {
    private final String zza = zzbms.zzb.zze();
    private final Map<String, String> zzb;
    private final Context zzc;
    private final String zzd;

    public zzblm(Context context, String str) {
        String str2;
        String str3;
        this.zzc = context;
        this.zzd = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzb = linkedHashMap;
        linkedHashMap.put("s", "gmob_sdk");
        linkedHashMap.put("v", ExifInterface.GPS_MEASUREMENT_3D);
        linkedHashMap.put("os", Build.VERSION.RELEASE);
        linkedHashMap.put("api_v", Build.VERSION.SDK);
        zzt.zzp();
        linkedHashMap.put("device", com.google.android.gms.ads.internal.util.zzt.zzx());
        if (context.getApplicationContext() != null) {
            str2 = context.getApplicationContext().getPackageName();
        } else {
            str2 = context.getPackageName();
        }
        linkedHashMap.put("app", str2);
        zzt.zzp();
        if (true != com.google.android.gms.ads.internal.util.zzt.zzI(context)) {
            str3 = "0";
        } else {
            str3 = "1";
        }
        linkedHashMap.put("is_lite_sdk", str3);
        Future<zzcdv> zzb2 = zzt.zzm().zzb(context);
        try {
            linkedHashMap.put("network_coarse", Integer.toString(zzb2.get().zzk));
            linkedHashMap.put("network_fine", Integer.toString(zzb2.get().zzl));
        } catch (Exception e11) {
            zzt.zzo().zzs(e11, "CsiConfiguration.CsiConfiguration");
        }
    }

    public final Context zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zzd;
    }

    public final String zzc() {
        return this.zza;
    }

    public final Map<String, String> zzd() {
        return this.zzb;
    }
}
