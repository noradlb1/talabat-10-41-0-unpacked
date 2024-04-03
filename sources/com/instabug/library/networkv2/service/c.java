package com.instabug.library.networkv2.service;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEventPublisher;
import com.instabug.library.model.b;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Endpoints;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.TaskDebouncer;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

public class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f51667c;

    /* renamed from: a  reason: collision with root package name */
    private final TaskDebouncer f51668a = new TaskDebouncer(TimeUnit.SECONDS.toMillis(2));

    /* renamed from: b  reason: collision with root package name */
    private final NetworkManager f51669b = new NetworkManager();

    private c() {
    }

    public static synchronized c b() {
        c cVar;
        synchronized (c.class) {
            if (f51667c == null) {
                f51667c = new c();
            }
            cVar = f51667c;
        }
        return cVar;
    }

    @VisibleForTesting
    public Request a() throws JSONException {
        String a11;
        Request.Builder method = new Request.Builder().endpoint(Endpoints.APP_SETTINGS).method("GET");
        b featuresCache = SettingsManager.getInstance().getFeaturesCache();
        if (!(featuresCache == null || featuresCache.a() == null || (a11 = featuresCache.a()) == null)) {
            method.addHeader(new RequestParameter("If-Match", a11));
        }
        return method.build();
    }

    public void b(Request.Callbacks callbacks) {
        this.f51668a.debounce((Runnable) new a(this, callbacks));
    }

    /* access modifiers changed from: private */
    public void a(Request.Callbacks callbacks) {
        if (callbacks != null) {
            try {
                InstabugSDKLogger.d("IBG-Core", "Getting enabled features for this application");
                this.f51669b.doRequest(IBGNetworkWorker.CORE, 1, a(), (Request.Callbacks<RequestResponse, Throwable>) new b(this, callbacks));
            } catch (JSONException e11) {
                callbacks.onFailed(e11);
            }
        }
    }

    /* access modifiers changed from: private */
    @Nullable
    public String a(RequestResponse requestResponse) {
        int responseCode = requestResponse.getResponseCode();
        if (responseCode == 200) {
            String str = (String) requestResponse.getResponseBody();
            long j11 = 0;
            if (str != null) {
                try {
                    j11 = new JSONObject(str).optLong(RemoteMessageConst.TTL, 0);
                } catch (JSONException e11) {
                    InstabugSDKLogger.e("IBG-Core", "Failed to cache features settings due to: " + e11.getMessage());
                }
            }
            SettingsManager.getInstance().setFeaturesCache(new b(j11, "11.7.0", requestResponse.getHeaders().get("If-Match")));
            return str;
        } else if (responseCode != 304) {
            InstabugSDKLogger.d("IBG-Core", "Caught unhandled case with code (" + responseCode + ")");
            return null;
        } else {
            InstabugSDKLogger.d("IBG-Core", "Features list did not get modified. Moving on...");
            SDKCoreEventPublisher.post(new SDKCoreEvent("features", SDKCoreEvent.Feature.VALUE_FETCHED));
            return null;
        }
    }
}
