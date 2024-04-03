package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzfkc {
    private final zzfkj zza;
    private final WebView zzb;
    private final List<zzfkk> zzc = new ArrayList();
    private final Map<String, zzfkk> zzd = new HashMap();
    private final String zze;
    @Nullable
    private final String zzf;
    private final zzfkd zzg;

    private zzfkc(zzfkj zzfkj, WebView webView, String str, List<zzfkk> list, @Nullable String str2, String str3, zzfkd zzfkd) {
        this.zza = zzfkj;
        this.zzb = webView;
        this.zzg = zzfkd;
        this.zzf = str2;
        this.zze = "";
    }

    public static zzfkc zzb(zzfkj zzfkj, WebView webView, @Nullable String str, String str2) {
        return new zzfkc(zzfkj, webView, (String) null, (List<zzfkk>) null, str, "", zzfkd.HTML);
    }

    public static zzfkc zzc(zzfkj zzfkj, WebView webView, @Nullable String str, String str2) {
        return new zzfkc(zzfkj, webView, (String) null, (List<zzfkk>) null, str, "", zzfkd.JAVASCRIPT);
    }

    public final WebView zza() {
        return this.zzb;
    }

    public final zzfkd zzd() {
        return this.zzg;
    }

    public final zzfkj zze() {
        return this.zza;
    }

    @Nullable
    public final String zzf() {
        return this.zzf;
    }

    public final String zzg() {
        return this.zze;
    }

    public final List<zzfkk> zzh() {
        return Collections.unmodifiableList(this.zzc);
    }

    public final Map<String, zzfkk> zzi() {
        return Collections.unmodifiableMap(this.zzd);
    }
}
