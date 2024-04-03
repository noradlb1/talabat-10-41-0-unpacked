package com.instabug.featuresrequest.network.service;

import com.instabug.featuresrequest.settings.a;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.Calendar;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

class d implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f46575a;

    public d(g gVar, Request.Callbacks callbacks) {
        this.f46575a = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        InstabugSDKLogger.d("IBG-FR", "Voting request succeeded, Response code: " + requestResponse.getResponseCode());
        InstabugSDKLogger.v("IBG-FR", "Voting succeeded, Response body: " + requestResponse.getResponseBody());
        if (requestResponse.getResponseCode() == 200) {
            try {
                a.a().a(Calendar.getInstance(Locale.ENGLISH).getTime().getTime());
                if (requestResponse.getResponseBody() == null) {
                    InstabugSDKLogger.e("IBG-FR", "Request response is null");
                } else {
                    this.f46575a.onSucceeded(new JSONObject((String) requestResponse.getResponseBody()));
                }
            } catch (JSONException e11) {
                InstabugSDKLogger.e("IBG-FR", "voting got JSONException: " + e11.getMessage(), e11);
                this.f46575a.onFailed(e11);
            }
        } else {
            Request.Callbacks callbacks = this.f46575a;
            callbacks.onFailed(new Throwable("vote request got error with response code:" + requestResponse.getResponseCode()));
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-FR", "voting got error: " + th2.getMessage(), th2);
        this.f46575a.onFailed(th2);
    }
}
