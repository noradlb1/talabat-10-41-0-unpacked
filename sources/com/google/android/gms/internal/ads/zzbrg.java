package com.google.android.gms.internal.ads;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzt;
import java.util.HashMap;
import java.util.Map;

final class zzbrg implements zzbrt<zzcop> {
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcop zzcop = (zzcop) obj;
        zzt.zzp();
        DisplayMetrics zzy = com.google.android.gms.ads.internal.util.zzt.zzy((WindowManager) zzcop.getContext().getSystemService("window"));
        int i11 = zzy.widthPixels;
        int i12 = zzy.heightPixels;
        int[] iArr = new int[2];
        HashMap hashMap = new HashMap();
        ((View) zzcop).getLocationInWindow(iArr);
        hashMap.put("xInPixels", Integer.valueOf(iArr[0]));
        hashMap.put("yInPixels", Integer.valueOf(iArr[1]));
        hashMap.put("windowWidthInPixels", Integer.valueOf(i11));
        hashMap.put("windowHeightInPixels", Integer.valueOf(i12));
        zzcop.zzd("locationReady", hashMap);
        zzciz.zzj("GET LOCATION COMPILED");
    }
}
