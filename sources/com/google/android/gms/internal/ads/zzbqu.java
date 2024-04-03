package com.google.android.gms.internal.ads;

import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import java.util.Map;

public final class zzbqu implements zzbrt<Object> {
    private final zzbqv zza;

    public zzbqu(zzbqv zzbqv) {
        this.zza = zzbqv;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get("name");
        if (str == null) {
            zzciz.zzj("App event with no name parameter.");
        } else {
            this.zza.zzbL(str, map.get(CustomerInfoLocalDataSourceImpl.KEY));
        }
    }
}
