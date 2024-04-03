package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.ads.zzciy;
import com.google.android.gms.internal.ads.zzciz;
import java.io.IOException;

final class zzc extends zzb {
    private final Context zza;

    public zzc(Context context) {
        this.zza = context;
    }

    public final void zza() {
        boolean z11;
        try {
            z11 = AdvertisingIdClient.getIsAdIdFakeForDebugLogging(this.zza);
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException | IllegalStateException e11) {
            zzciz.zzh("Fail to get isAdIdFakeForDebugLogging", e11);
            z11 = false;
        }
        zzciy.zzj(z11);
        StringBuilder sb2 = new StringBuilder(43);
        sb2.append("Update ad debug logging enablement as ");
        sb2.append(z11);
        zzciz.zzj(sb2.toString());
    }
}
