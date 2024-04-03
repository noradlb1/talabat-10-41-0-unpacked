package com.google.android.gms.internal.gtm;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.common.internal.Preconditions;
import com.huawei.hms.flutter.map.constants.Param;

public final class zzlu implements zzgz {
    private DisplayMetrics zzarx = new DisplayMetrics();
    private Context zzrm;

    public zzlu(Context context) {
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
        ((WindowManager) this.zzrm.getSystemService("window")).getDefaultDisplay().getMetrics(this.zzarx);
        return new zzom(this.zzarx.widthPixels + Param.X + this.zzarx.heightPixels);
    }
}
