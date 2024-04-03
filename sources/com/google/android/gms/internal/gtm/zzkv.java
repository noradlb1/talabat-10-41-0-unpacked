package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.common.internal.Preconditions;

public final class zzkv implements zzgz {
    private final Context zzrm;

    public zzkv(Context context) {
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
            return new zzom(this.zzrm.getPackageManager().getPackageInfo(this.zzrm.getPackageName(), 0).versionName);
        } catch (PackageManager.NameNotFoundException e11) {
            String packageName = this.zzrm.getPackageName();
            String valueOf = String.valueOf(e11);
            StringBuilder sb2 = new StringBuilder(String.valueOf(packageName).length() + 25 + valueOf.length());
            sb2.append("Package name ");
            sb2.append(packageName);
            sb2.append(" not found. ");
            sb2.append(valueOf);
            zzev.zzav(sb2.toString());
            return zzog.zzaum;
        }
    }
}
