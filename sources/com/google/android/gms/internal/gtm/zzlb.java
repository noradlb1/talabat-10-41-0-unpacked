package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.provider.Settings;
import com.google.android.gms.common.internal.Preconditions;

public final class zzlb implements zzgz {
    private final Context zzrm;

    public zzlb(Context context) {
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
        String string = Settings.Secure.getString(this.zzrm.getContentResolver(), "android_id");
        if (string == null) {
            string = "";
        }
        return new zzom(string);
    }
}
