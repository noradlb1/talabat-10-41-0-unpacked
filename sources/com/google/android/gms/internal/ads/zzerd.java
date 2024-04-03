package com.google.android.gms.internal.ads;

import com.google.android.gms.appset.AppSetIdInfo;

public final /* synthetic */ class zzerd implements zzfpv {
    public static final /* synthetic */ zzerd zza = new zzerd();

    private /* synthetic */ zzerd() {
    }

    public final Object apply(Object obj) {
        AppSetIdInfo appSetIdInfo = (AppSetIdInfo) obj;
        return new zzerf(appSetIdInfo.getId(), appSetIdInfo.getScope());
    }
}
