package com.google.android.gms.internal.ads;

import android.os.Build;
import com.google.android.gms.ads.internal.util.zzcl;
import java.util.HashMap;
import java.util.concurrent.Callable;

public final /* synthetic */ class zzexz implements Callable {
    public static final /* synthetic */ zzexz zza = new zzexz();

    private /* synthetic */ zzexz() {
    }

    public final Object call() {
        HashMap hashMap = new HashMap();
        String str = (String) zzbgq.zzc().zzb(zzblj.zzF);
        if (str != null && !str.isEmpty()) {
            if (Build.VERSION.SDK_INT >= ((Integer) zzbgq.zzc().zzb(zzblj.zzG)).intValue()) {
                for (String str2 : str.split(",", -1)) {
                    hashMap.put(str2, zzcl.zza(str2));
                }
            }
        }
        return new zzeyb(hashMap);
    }
}
