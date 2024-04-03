package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.internal.zzt;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import java.util.List;
import java.util.Map;

public final class zzfix {
    private final Context zza;
    private final String zzb;
    private final String zzc;

    public zzfix(Context context, zzcjf zzcjf) {
        this.zza = context;
        this.zzb = context.getPackageName();
        this.zzc = zzcjf.zza;
    }

    public final void zza(Map<String, String> map) {
        String str;
        map.put("s", "gmob_sdk");
        map.put("v", ExifInterface.GPS_MEASUREMENT_3D);
        map.put("os", Build.VERSION.RELEASE);
        map.put("api_v", Build.VERSION.SDK);
        zzt.zzp();
        map.put("device", com.google.android.gms.ads.internal.util.zzt.zzx());
        map.put("app", this.zzb);
        zzt.zzp();
        if (true != com.google.android.gms.ads.internal.util.zzt.zzI(this.zza)) {
            str = "0";
        } else {
            str = "1";
        }
        map.put("is_lite_sdk", str);
        List<String> zzb2 = zzblj.zzb();
        if (((Boolean) zzbgq.zzc().zzb(zzblj.zzfm)).booleanValue()) {
            zzb2.addAll(zzt.zzo().zzh().zzg().zzd());
        }
        map.put("e", TextUtils.join(",", zzb2));
        map.put(RemoteConfigConstants.RequestFieldKey.SDK_VERSION, this.zzc);
    }
}
