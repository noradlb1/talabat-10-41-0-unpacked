package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzt;
import java.io.File;
import java.util.Collections;
import java.util.Map;

@TargetApi(11)
public class zzcps extends zzcow {
    public zzcps(zzcop zzcop, zzbay zzbay, boolean z11) {
        super(zzcop, zzbay, z11);
    }

    @Nullable
    public final WebResourceResponse zzM(WebView webView, String str, @Nullable Map<String, String> map) {
        String str2;
        if (!(webView instanceof zzcop)) {
            zzciz.zzj("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzcop zzcop = (zzcop) webView;
        zzcgf zzcgf = this.zza;
        if (zzcgf != null) {
            zzcgf.zzd(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzc(str, map);
        }
        if (zzcop.zzP() != null) {
            zzcop.zzP().zzD();
        }
        if (zzcop.zzQ().zzi()) {
            str2 = (String) zzbgq.zzc().zzb(zzblj.zzJ);
        } else if (zzcop.zzaC()) {
            str2 = (String) zzbgq.zzc().zzb(zzblj.zzI);
        } else {
            str2 = (String) zzbgq.zzc().zzb(zzblj.zzH);
        }
        zzt.zzp();
        return com.google.android.gms.ads.internal.util.zzt.zzB(zzcop.getContext(), zzcop.zzp().zza, str2);
    }
}
