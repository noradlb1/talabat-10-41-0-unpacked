package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.internal.Preconditions;

public final class zzkt implements zzgz {
    private Context zzrm;

    public zzkt(Context context) {
        this.zzrm = context;
    }

    public final zzoa<?> zzb(zzfl zzfl, zzoa<?>... zzoaArr) {
        boolean z11;
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
        try {
            PackageManager packageManager = this.zzrm.getPackageManager();
            return new zzom(packageManager.getApplicationLabel(packageManager.getApplicationInfo(this.zzrm.getPackageName(), 0)).toString());
        } catch (PackageManager.NameNotFoundException unused) {
            return new zzom("");
        }
    }
}
