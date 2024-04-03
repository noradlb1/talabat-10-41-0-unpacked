package com.google.android.gms.tagmanager;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzl;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.Map;

final class zzem extends zzbq {
    private static final String ID = zza.RESOLUTION.toString();
    private final Context zzrm;

    public zzem(Context context) {
        super(ID, new String[0]);
        this.zzrm = context;
    }

    public final zzl zzb(Map<String, zzl> map) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.zzrm.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        int i11 = displayMetrics.widthPixels;
        int i12 = displayMetrics.heightPixels;
        StringBuilder sb2 = new StringBuilder(23);
        sb2.append(i11);
        sb2.append(Param.X);
        sb2.append(i12);
        return zzgj.zzi(sb2.toString());
    }

    public final boolean zzgw() {
        return true;
    }
}
