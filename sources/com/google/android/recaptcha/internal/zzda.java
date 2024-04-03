package com.google.android.recaptcha.internal;

import android.net.Uri;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import java.io.ByteArrayInputStream;
import java.util.concurrent.TimeUnit;
import kotlin.Deprecated;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class zzda extends WebViewClient {
    final /* synthetic */ zzdi zza;

    public zzda(zzdi zzdi) {
        this.zza = zzdi;
    }

    public final void onLoadResource(@NotNull WebView webView, @NotNull String str) {
        System.currentTimeMillis();
    }

    public final void onPageFinished(@NotNull WebView webView, @NotNull String str) {
        zzai zzai = zzai.zza;
        zzai.zzc(new zzaf(zzln.INIT_NETWORK, this.zza.zzg, this.zza.zzh, this.zza.zzh, (String) null), this.zza.zze, this.zza.zzf);
        long zza2 = this.zza.zzn.zza(TimeUnit.MICROSECONDS);
        zzj zzj = zzj.zza;
        zzj.zza(zzl.zzl.zza(), zza2);
    }

    @Deprecated(message = "Use onReceivedError(WebView,request,error) instead")
    public final void onReceivedError(@NotNull WebView webView, int i11, @NotNull String str, @NotNull String str2) {
        super.onReceivedError(webView, i11, str, str2);
        zzf zzf = zzf.zze;
        zzd zzd = (zzd) this.zza.zzj.get(Integer.valueOf(i11));
        if (zzd == null) {
            zzd = zzd.zzb;
        }
        zzh zzh = new zzh(zzf, zzd);
        this.zza.zzm().hashCode();
        zzh.getMessage();
        this.zza.zzm().completeExceptionally(zzh);
    }

    @Deprecated(message = "Use shouldInterceptRequest(WebView,WebResourceRequest) instead")
    @Nullable
    public final WebResourceResponse shouldInterceptRequest(@NotNull WebView webView, @NotNull String str) {
        zzdk zzdk = zzdk.zza;
        if (zzdk.zza(Uri.parse(str))) {
            return super.shouldInterceptRequest(webView, str);
        }
        Uri parse = Uri.parse(str);
        zzh zzh = new zzh(zzf.zzc, zzd.zzu);
        this.zza.zzm().hashCode();
        parse.toString();
        this.zza.zzm().completeExceptionally(zzh);
        return new WebResourceResponse("text/plain", "UTF-8", new ByteArrayInputStream(new byte[0]));
    }
}
