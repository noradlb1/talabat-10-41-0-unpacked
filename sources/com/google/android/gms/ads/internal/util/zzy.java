package com.google.android.gms.ads.internal.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.zzt;
import com.google.android.gms.internal.ads.zzbay;
import com.google.android.gms.internal.ads.zzciz;
import com.google.android.gms.internal.ads.zzcop;
import com.google.android.gms.internal.ads.zzcow;
import com.google.android.gms.internal.ads.zzcpt;
import java.io.InputStream;
import java.util.Map;

@TargetApi(21)
public class zzy extends zzx {
    public final int zzk() {
        return 16974374;
    }

    public final CookieManager zzl(Context context) {
        if (zzae.zzu()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th2) {
            zzciz.zzh("Failed to obtain CookieManager.", th2);
            zzt.zzo().zzs(th2, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    public final WebResourceResponse zzm(String str, String str2, int i11, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i11, str3, map, inputStream);
    }

    public final zzcow zzn(zzcop zzcop, zzbay zzbay, boolean z11) {
        return new zzcpt(zzcop, zzbay, z11);
    }
}
