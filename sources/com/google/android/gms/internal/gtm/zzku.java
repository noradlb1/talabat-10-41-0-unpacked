package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.internal.Preconditions;

public final class zzku implements zzgz {
    private final Context zzrm;

    public zzku(Context context) {
        this.zzrm = (Context) Preconditions.checkNotNull(context);
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
            return new zzoe(Double.valueOf((double) this.zzrm.getPackageManager().getPackageInfo(this.zzrm.getPackageName(), 0).versionCode));
        } catch (PackageManager.NameNotFoundException e11) {
            String packageName = this.zzrm.getPackageName();
            String message = e11.getMessage();
            StringBuilder sb2 = new StringBuilder(String.valueOf(packageName).length() + 25 + String.valueOf(message).length());
            sb2.append("Package name ");
            sb2.append(packageName);
            sb2.append(" not found. ");
            sb2.append(message);
            zzev.zzav(sb2.toString());
            return zzog.zzaum;
        }
    }
}
