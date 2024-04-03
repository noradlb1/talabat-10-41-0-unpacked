package com.iab.omid.library.deliveryhero3.publisher;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.util.Log;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.exoplayer2.ExoPlayer;
import com.iab.omid.library.deliveryhero3.adsession.AdSessionContext;
import com.iab.omid.library.deliveryhero3.adsession.VerificationScriptResource;
import com.iab.omid.library.deliveryhero3.internal.g;
import com.iab.omid.library.deliveryhero3.utils.c;
import com.iab.omid.library.deliveryhero3.utils.f;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

public class b extends AdSessionStatePublisher {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public WebView f44989f;

    /* renamed from: g  reason: collision with root package name */
    private Long f44990g = null;

    /* renamed from: h  reason: collision with root package name */
    private final Map<String, VerificationScriptResource> f44991h;

    /* renamed from: i  reason: collision with root package name */
    private final String f44992i;

    public class a extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public String f44993a = "OMID NativeBridge WebViewClient";

        public a() {
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            String str = this.f44993a;
            Log.w(str, "WebView renderer gone: " + renderProcessGoneDetail.toString());
            if (b.this.getWebView() != webView) {
                return super.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            Log.w(this.f44993a, "Deallocating the Native bridge as it is unusable. No further events will be generated for this session.");
            b.this.b((WebView) null);
            webView.destroy();
            return true;
        }
    }

    /* renamed from: com.iab.omid.library.deliveryhero3.publisher.b$b  reason: collision with other inner class name */
    public class C0051b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final WebView f44995a;

        public C0051b() {
            this.f44995a = b.this.f44989f;
        }

        public void run() {
            this.f44995a.destroy();
        }
    }

    public b(Map<String, VerificationScriptResource> map, String str) {
        this.f44991h = map;
        this.f44992i = str;
    }

    public void a(com.iab.omid.library.deliveryhero3.adsession.a aVar, AdSessionContext adSessionContext) {
        JSONObject jSONObject = new JSONObject();
        Map<String, VerificationScriptResource> injectedResourcesMap = adSessionContext.getInjectedResourcesMap();
        for (String next : injectedResourcesMap.keySet()) {
            c.a(jSONObject, next, injectedResourcesMap.get(next).toJsonObject());
        }
        c(aVar, adSessionContext, jSONObject);
    }

    public void b() {
        super.b();
        new Handler().postDelayed(new C0051b(), Math.max(4000 - (this.f44990g == null ? 4000 : TimeUnit.MILLISECONDS.convert(f.b() - this.f44990g.longValue(), TimeUnit.NANOSECONDS)), ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS));
        this.f44989f = null;
    }

    public void i() {
        super.i();
        k();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public void k() {
        WebView webView = new WebView(com.iab.omid.library.deliveryhero3.internal.f.b().a());
        this.f44989f = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        this.f44989f.getSettings().setAllowContentAccess(false);
        this.f44989f.getSettings().setAllowFileAccess(false);
        this.f44989f.setWebViewClient(new a());
        b(this.f44989f);
        g.a().c(this.f44989f, this.f44992i);
        for (String next : this.f44991h.keySet()) {
            g.a().a(this.f44989f, this.f44991h.get(next).getResourceUrl().toExternalForm(), next);
        }
        this.f44990g = Long.valueOf(f.b());
    }
}
