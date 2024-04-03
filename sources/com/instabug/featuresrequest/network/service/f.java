package com.instabug.featuresrequest.network.service;

import com.instabug.featuresrequest.settings.a;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.Calendar;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

class f implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f46577a;

    public f(g gVar, Request.Callbacks callbacks) {
        this.f46577a = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        InstabugSDKLogger.d("IBG-FR", "adding comment request succeeded, Response code: " + requestResponse.getResponseCode());
        InstabugSDKLogger.v("IBG-FR", "adding comment request succeeded, Response body: " + requestResponse.getResponseBody());
        if (requestResponse.getResponseCode() == 200) {
            try {
                a.a().a(Calendar.getInstance(Locale.ENGLISH).getTime().getTime());
                if (requestResponse.getResponseBody() == null) {
                    InstabugSDKLogger.e("IBG-FR", "Request response is null");
                } else {
                    this.f46577a.onSucceeded(new JSONObject((String) requestResponse.getResponseBody()));
                }
            } catch (JSONException e11) {
                InstabugSDKLogger.e("IBG-FR", "adding comment got JSONException: " + e11.getMessage(), e11);
                this.f46577a.onFailed(e11);
            }
        } else {
            Request.Callbacks callbacks = this.f46577a;
            callbacks.onFailed(new Throwable("adding comment request got error with response code:" + requestResponse.getResponseCode()));
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-FR", "adding comment got error: " + th2.getMessage(), th2);
        InstabugCore.reportError(th2, "Adding comment to feature request got error: " + th2.getMessage());
        this.f46577a.onFailed(th2);
    }
}
