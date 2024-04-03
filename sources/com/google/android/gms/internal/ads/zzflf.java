package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.text.TextUtils;
import android.webkit.WebView;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public final class zzflf extends zzflc {
    /* access modifiers changed from: private */
    public WebView zza;
    private Long zzb = null;
    private final Map<String, zzfkk> zzc;

    public zzflf(Map<String, zzfkk> map, String str) {
        this.zzc = map;
    }

    public final void zzc() {
        long j11;
        super.zzc();
        if (this.zzb == null) {
            j11 = 4000;
        } else {
            j11 = TimeUnit.MILLISECONDS.convert(System.nanoTime() - this.zzb.longValue(), TimeUnit.NANOSECONDS);
        }
        new Handler().postDelayed(new zzfle(this), Math.max(4000 - j11, ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS));
        this.zza = null;
    }

    public final void zzf(zzfke zzfke, zzfkc zzfkc) {
        JSONObject jSONObject = new JSONObject();
        Map<String, zzfkk> zzi = zzfkc.zzi();
        for (String next : zzi.keySet()) {
            zzflg.zzg(jSONObject, next, zzi.get(next));
        }
        zzg(zzfke, zzfkc, jSONObject);
    }

    public final void zzj() {
        WebView webView = new WebView(zzfkt.zzb().zza());
        this.zza = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        zzi(this.zza);
        WebView webView2 = this.zza;
        if (webView2 != null && !TextUtils.isEmpty((CharSequence) null)) {
            webView2.loadUrl("javascript: null");
        }
        Iterator<String> it = this.zzc.keySet().iterator();
        if (!it.hasNext()) {
            this.zzb = Long.valueOf(System.nanoTime());
            return;
        }
        zzfkk zzfkk = this.zzc.get(it.next());
        throw null;
    }
}
