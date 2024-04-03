package com.iab.omid.library.deliveryhero3.publisher;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.iab.omid.library.deliveryhero3.adsession.AdEvents;
import com.iab.omid.library.deliveryhero3.adsession.AdSessionConfiguration;
import com.iab.omid.library.deliveryhero3.adsession.AdSessionContext;
import com.iab.omid.library.deliveryhero3.adsession.ErrorType;
import com.iab.omid.library.deliveryhero3.adsession.VerificationScriptResource;
import com.iab.omid.library.deliveryhero3.adsession.media.MediaEvents;
import com.iab.omid.library.deliveryhero3.internal.g;
import com.iab.omid.library.deliveryhero3.utils.c;
import com.iab.omid.library.deliveryhero3.utils.f;
import com.iab.omid.library.deliveryhero3.weakreference.b;
import com.visa.checkout.Profile;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class AdSessionStatePublisher {

    /* renamed from: a  reason: collision with root package name */
    private b f44980a = new b((WebView) null);

    /* renamed from: b  reason: collision with root package name */
    private AdEvents f44981b;

    /* renamed from: c  reason: collision with root package name */
    private MediaEvents f44982c;

    /* renamed from: d  reason: collision with root package name */
    private a f44983d;

    /* renamed from: e  reason: collision with root package name */
    private long f44984e;

    public enum a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_NOTVISIBLE
    }

    public AdSessionStatePublisher() {
        a();
    }

    public void a() {
        this.f44984e = f.b();
        this.f44983d = a.AD_STATE_IDLE;
    }

    public void a(float f11) {
        g.a().a(getWebView(), f11);
    }

    public void a(AdEvents adEvents) {
        this.f44981b = adEvents;
    }

    public void a(AdSessionConfiguration adSessionConfiguration) {
        g.a().a(getWebView(), adSessionConfiguration.toJsonObject());
    }

    public void a(ErrorType errorType, String str) {
        g.a().a(getWebView(), errorType, str);
    }

    public void a(com.iab.omid.library.deliveryhero3.adsession.a aVar, AdSessionContext adSessionContext) {
        c(aVar, adSessionContext, (JSONObject) null);
    }

    public void a(MediaEvents mediaEvents) {
        this.f44982c = mediaEvents;
    }

    public void a(String str) {
        g.a().a(getWebView(), str, (JSONObject) null);
    }

    public void a(String str, long j11) {
        a aVar;
        if (j11 >= this.f44984e && this.f44983d != (aVar = a.AD_STATE_NOTVISIBLE)) {
            this.f44983d = aVar;
            g.a().a(getWebView(), str);
        }
    }

    public void a(String str, JSONObject jSONObject) {
        g.a().a(getWebView(), str, jSONObject);
    }

    public void a(@NonNull Date date) {
        if (date != null) {
            JSONObject jSONObject = new JSONObject();
            c.a(jSONObject, "timestamp", Long.valueOf(date.getTime()));
            g.a().c(getWebView(), jSONObject);
        }
    }

    public void a(@NonNull JSONObject jSONObject) {
        g.a().b(getWebView(), jSONObject);
    }

    public void a(boolean z11) {
        if (e()) {
            g.a().b(getWebView(), z11 ? "foregrounded" : "backgrounded");
        }
    }

    public void b() {
        this.f44980a.clear();
    }

    public void b(WebView webView) {
        this.f44980a = new b(webView);
    }

    public void b(String str, long j11) {
        if (j11 >= this.f44984e) {
            this.f44983d = a.AD_STATE_VISIBLE;
            g.a().a(getWebView(), str);
        }
    }

    public AdEvents c() {
        return this.f44981b;
    }

    public void c(com.iab.omid.library.deliveryhero3.adsession.a aVar, AdSessionContext adSessionContext, JSONObject jSONObject) {
        String adSessionId = aVar.getAdSessionId();
        JSONObject jSONObject2 = new JSONObject();
        c.a(jSONObject2, Profile.ENVIRONMENT, "app");
        c.a(jSONObject2, "adSessionType", adSessionContext.getAdSessionContextType());
        c.a(jSONObject2, "deviceInfo", com.iab.omid.library.deliveryhero3.utils.b.d());
        c.a(jSONObject2, "deviceCategory", com.iab.omid.library.deliveryhero3.utils.a.a().toString());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put((Object) "clid");
        jSONArray.put((Object) "vlid");
        c.a(jSONObject2, "supports", jSONArray);
        JSONObject jSONObject3 = new JSONObject();
        c.a(jSONObject3, "partnerName", adSessionContext.getPartner().getName());
        c.a(jSONObject3, "partnerVersion", adSessionContext.getPartner().getVersion());
        c.a(jSONObject2, "omidNativeInfo", jSONObject3);
        JSONObject jSONObject4 = new JSONObject();
        c.a(jSONObject4, "libraryVersion", "1.4.8-Deliveryhero3");
        c.a(jSONObject4, "appId", com.iab.omid.library.deliveryhero3.internal.f.b().a().getApplicationContext().getPackageName());
        c.a(jSONObject2, "app", jSONObject4);
        if (adSessionContext.getContentUrl() != null) {
            c.a(jSONObject2, "contentUrl", adSessionContext.getContentUrl());
        }
        if (adSessionContext.getCustomReferenceData() != null) {
            c.a(jSONObject2, "customReferenceData", adSessionContext.getCustomReferenceData());
        }
        JSONObject jSONObject5 = new JSONObject();
        for (VerificationScriptResource next : adSessionContext.getVerificationScriptResources()) {
            c.a(jSONObject5, next.getVendorKey(), next.getVerificationParameters());
        }
        g.a().a(getWebView(), adSessionId, jSONObject2, jSONObject5, jSONObject);
    }

    public MediaEvents d() {
        return this.f44982c;
    }

    public boolean e() {
        return this.f44980a.get() != null;
    }

    public void f() {
        g.a().a(getWebView());
    }

    public void g() {
        g.a().b(getWebView());
    }

    public WebView getWebView() {
        return (WebView) this.f44980a.get();
    }

    public void h() {
        g.a().c(getWebView());
    }

    public void i() {
    }
}
