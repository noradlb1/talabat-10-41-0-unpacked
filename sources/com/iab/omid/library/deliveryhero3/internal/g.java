package com.iab.omid.library.deliveryhero3.internal;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.iab.omid.library.deliveryhero3.adsession.ErrorType;
import com.iab.omid.library.deliveryhero3.utils.d;
import org.json.JSONObject;

public class g {

    /* renamed from: a  reason: collision with root package name */
    private static g f44966a = new g();

    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ WebView f44967b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44968c;

        public a(WebView webView, String str) {
            this.f44967b = webView;
            this.f44968c = str;
        }

        public void run() {
            g.this.c(this.f44967b, this.f44968c);
        }
    }

    private g() {
    }

    public static final g a() {
        return f44966a;
    }

    public void a(WebView webView) {
        b(webView, "finishSession", new Object[0]);
    }

    public void a(WebView webView, float f11) {
        b(webView, "setDeviceVolume", Float.valueOf(f11));
    }

    public void a(WebView webView, ErrorType errorType, String str) {
        b(webView, "error", errorType.toString(), str);
    }

    public void a(WebView webView, String str) {
        b(webView, "setNativeViewHierarchy", str);
    }

    public void a(WebView webView, String str, String str2) {
        if (str != null && !TextUtils.isEmpty(str2)) {
            c(webView, "(function() {this.omidVerificationProperties = this.omidVerificationProperties || {};Object.defineProperty(this.omidVerificationProperties, 'injectionId', {get: function() {var currentScript = document && document.currentScript;return currentScript && currentScript.getAttribute('data-injection-id');}, configurable: true});var script = document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");script.setAttribute(\"data-injection-id\",\"%INJECTION_ID%\");document.body.appendChild(script);})();".replace("%SCRIPT_SRC%", str).replace("%INJECTION_ID%", str2));
        }
    }

    public void a(WebView webView, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            b(webView, "publishMediaEvent", str, jSONObject);
            return;
        }
        b(webView, "publishMediaEvent", str);
    }

    public void a(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        b(webView, "startSession", str, jSONObject, jSONObject2, jSONObject3);
    }

    public void a(WebView webView, JSONObject jSONObject) {
        b(webView, "init", jSONObject);
    }

    public void b(WebView webView) {
        b(webView, "publishImpressionEvent", new Object[0]);
    }

    public void b(WebView webView, String str) {
        b(webView, "setState", str);
    }

    @VisibleForTesting
    public void b(WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb2 = new StringBuilder(128);
            sb2.append("if(window.omidBridge!==undefined){omidBridge.");
            sb2.append(str);
            sb2.append("(");
            d(sb2, objArr);
            sb2.append(")}");
            c(webView, sb2);
            return;
        }
        d.a("The WebView is null for " + str);
    }

    public void b(WebView webView, @NonNull JSONObject jSONObject) {
        b(webView, "publishLoadedEvent", jSONObject);
    }

    public void c(WebView webView) {
        b(webView, "publishLoadedEvent", new Object[0]);
    }

    @VisibleForTesting
    public void c(WebView webView, StringBuilder sb2) {
        String sb3 = sb2.toString();
        Handler handler = webView.getHandler();
        if (handler == null || Looper.myLooper() == handler.getLooper()) {
            c(webView, sb3);
        } else {
            handler.post(new a(webView, sb3));
        }
    }

    public void c(WebView webView, @NonNull JSONObject jSONObject) {
        b(webView, "setLastActivity", jSONObject);
    }

    public boolean c(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            webView.evaluateJavascript(str, (ValueCallback) null);
            return true;
        } catch (IllegalStateException unused) {
            webView.loadUrl("javascript: " + str);
            return true;
        }
    }

    @VisibleForTesting
    public void d(StringBuilder sb2, Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                if (obj == null) {
                    sb2.append('\"');
                } else {
                    if (obj instanceof String) {
                        String obj2 = obj.toString();
                        if (obj2.startsWith("{")) {
                            sb2.append(obj2);
                        } else {
                            sb2.append('\"');
                            sb2.append(obj2);
                        }
                    } else {
                        sb2.append(obj);
                    }
                    sb2.append(",");
                }
                sb2.append('\"');
                sb2.append(",");
            }
            sb2.setLength(sb2.length() - 1);
        }
    }
}
