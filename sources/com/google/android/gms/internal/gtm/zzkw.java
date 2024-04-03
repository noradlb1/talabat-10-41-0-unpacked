package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.telephony.TelephonyManager;
import com.google.android.gms.common.internal.Preconditions;

public final class zzkw implements zzgz {
    private final Context zzrm;

    public zzkw(Context context) {
        this.zzrm = (Context) Preconditions.checkNotNull(context);
    }

    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
        String networkOperatorName;
        boolean z12 = true;
        if (zzoaArr != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        if (zzoaArr.length != 0) {
            z12 = false;
        }
        Preconditions.checkArgument(z12);
        TelephonyManager telephonyManager = (TelephonyManager) this.zzrm.getSystemService("phone");
        zzog zzog = zzog.zzaum;
        if (telephonyManager == null || (networkOperatorName = telephonyManager.getNetworkOperatorName()) == null) {
            return zzog;
        }
        return new zzom(networkOperatorName);
    }
}
