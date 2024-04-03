package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Message;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.View;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.internal.security.CertificateUtil;
import com.google.android.exoplayer2.upstream.cache.CacheDataSink;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzt;

@TargetApi(11)
public final class zzcoo extends WebChromeClient {
    private final zzcop zza;

    public zzcoo(zzcop zzcop) {
        this.zza = zzcop;
    }

    private static final Context zzb(WebView webView) {
        if (!(webView instanceof zzcop)) {
            return webView.getContext();
        }
        zzcop zzcop = (zzcop) webView;
        Activity zzk = zzcop.zzk();
        if (zzk != null) {
            return zzk;
        }
        return zzcop.getContext();
    }

    public final void onCloseWindow(WebView webView) {
        if (!(webView instanceof zzcop)) {
            zzciz.zzj("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        zzl zzN = ((zzcop) webView).zzN();
        if (zzN == null) {
            zzciz.zzj("Tried to close an AdWebView not associated with an overlay.");
        } else {
            zzN.zzb();
        }
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message = consoleMessage.message();
        String sourceId = consoleMessage.sourceId();
        int lineNumber = consoleMessage.lineNumber();
        StringBuilder sb2 = new StringBuilder(String.valueOf(message).length() + 19 + String.valueOf(sourceId).length());
        sb2.append("JS: ");
        sb2.append(message);
        sb2.append(" (");
        sb2.append(sourceId);
        sb2.append(CertificateUtil.DELIMITER);
        sb2.append(lineNumber);
        sb2.append(")");
        String sb3 = sb2.toString();
        if (sb3.contains("Application Cache")) {
            return super.onConsoleMessage(consoleMessage);
        }
        int i11 = zzcon.zza[consoleMessage.messageLevel().ordinal()];
        if (i11 == 1) {
            zzciz.zzg(sb3);
        } else if (i11 == 2) {
            zzciz.zzj(sb3);
        } else if (i11 == 3 || i11 == 4) {
            zzciz.zzi(sb3);
        } else if (i11 != 5) {
            zzciz.zzi(sb3);
        } else {
            zzciz.zze(sb3);
        }
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean z11, boolean z12, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(webView.getContext());
        if (this.zza.zzJ() != null) {
            webView2.setWebViewClient(this.zza.zzJ());
        }
        webViewTransport.setWebView(webView2);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String str, String str2, long j11, long j12, long j13, WebStorage.QuotaUpdater quotaUpdater) {
        long j14 = CacheDataSink.DEFAULT_FRAGMENT_SIZE - j13;
        if (j14 <= 0) {
            quotaUpdater.updateQuota(j11);
            return;
        }
        if (j11 == 0) {
            if (j12 > j14 || j12 > PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                j12 = 0;
            }
        } else if (j12 == 0) {
            j12 = Math.min(j11 + Math.min(PlaybackStateCompat.ACTION_PREPARE_FROM_URI, j14), PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED);
        } else {
            if (j12 <= Math.min(PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED - j11, j14)) {
                j11 += j12;
            }
            j12 = j11;
        }
        quotaUpdater.updateQuota(j12);
    }

    public final void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) {
        boolean z11;
        if (callback != null) {
            zzt.zzp();
            if (!com.google.android.gms.ads.internal.util.zzt.zzF(this.zza.getContext(), "android.permission.ACCESS_FINE_LOCATION")) {
                zzt.zzp();
                if (!com.google.android.gms.ads.internal.util.zzt.zzF(this.zza.getContext(), "android.permission.ACCESS_COARSE_LOCATION")) {
                    z11 = false;
                    callback.invoke(str, z11, true);
                }
            }
            z11 = true;
            callback.invoke(str, z11, true);
        }
    }

    public final void onHideCustomView() {
        zzl zzN = this.zza.zzN();
        if (zzN == null) {
            zzciz.zzj("Could not get ad overlay when hiding custom view.");
        } else {
            zzN.zzf();
        }
    }

    public final boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "alert", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "onBeforeUnload", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
        return zza(zzb(webView), "confirm", str, str2, (String) null, jsResult, (JsPromptResult) null, false);
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        return zza(zzb(webView), "prompt", str, str2, str3, (JsResult) null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long j11, long j12, WebStorage.QuotaUpdater quotaUpdater) {
        long j13 = j11 + PlaybackStateCompat.ACTION_PREPARE_FROM_URI;
        if (CacheDataSink.DEFAULT_FRAGMENT_SIZE - j12 < j13) {
            quotaUpdater.updateQuota(0);
        } else {
            quotaUpdater.updateQuota(j13);
        }
    }

    @Deprecated
    public final void onShowCustomView(View view, int i11, WebChromeClient.CustomViewCallback customViewCallback) {
        zzl zzN = this.zza.zzN();
        if (zzN == null) {
            zzciz.zzj("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        zzN.zzA(view, customViewCallback);
        zzN.zzy(i11);
    }

    public final boolean zza(Context context, String str, String str2, String str3, String str4, JsResult jsResult, JsPromptResult jsPromptResult, boolean z11) {
        zzb zzd;
        try {
            zzcop zzcop = this.zza;
            if (zzcop == null || zzcop.zzP() == null || this.zza.zzP().zzd() == null || (zzd = this.zza.zzP().zzd()) == null || zzd.zzc()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(str2);
                if (z11) {
                    LinearLayout linearLayout = new LinearLayout(context);
                    linearLayout.setOrientation(1);
                    TextView textView = new TextView(context);
                    textView.setText(str3);
                    EditText editText = new EditText(context);
                    editText.setText(str4);
                    linearLayout.addView(textView);
                    linearLayout.addView(editText);
                    builder.setView(linearLayout).setPositiveButton(17039370, new zzcom(jsPromptResult, editText)).setNegativeButton(17039360, new zzcol(jsPromptResult)).setOnCancelListener(new zzcok(jsPromptResult)).create().show();
                } else {
                    builder.setMessage(str3).setPositiveButton(17039370, new zzcoj(jsResult)).setNegativeButton(17039360, new zzcoi(jsResult)).setOnCancelListener(new zzcoh(jsResult)).create().show();
                }
                return true;
            }
            StringBuilder sb2 = new StringBuilder(str.length() + 11 + String.valueOf(str3).length());
            sb2.append("window.");
            sb2.append(str);
            sb2.append("('");
            sb2.append(str3);
            sb2.append("')");
            zzd.zzb(sb2.toString());
            return false;
        } catch (WindowManager.BadTokenException e11) {
            zzciz.zzk("Fail to display Dialog.", e11);
        }
    }

    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        onShowCustomView(view, -1, customViewCallback);
    }
}
