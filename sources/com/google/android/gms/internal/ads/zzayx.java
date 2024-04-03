package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

final class zzayx implements Runnable {
    final ValueCallback<String> zza = new zzayw(this);
    final /* synthetic */ zzayp zzb;
    final /* synthetic */ WebView zzc;
    final /* synthetic */ boolean zzd;
    final /* synthetic */ zzayz zze;

    public zzayx(zzayz zzayz, zzayp zzayp, WebView webView, boolean z11) {
        this.zze = zzayz;
        this.zzb = zzayp;
        this.zzc = webView;
        this.zzd = z11;
    }

    public final void run() {
        if (this.zzc.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzc.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zza);
            } catch (Throwable unused) {
                ((zzayw) this.zza).onReceiveValue("");
            }
        }
    }
}
