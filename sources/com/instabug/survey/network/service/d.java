package com.instabug.survey.network.service;

import com.instabug.library.core.InstabugCore;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import org.json.JSONException;
import org.json.JSONObject;

class d implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f52414a;

    public d(g gVar, Request.Callbacks callbacks) {
        this.f52414a = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        JSONObject jSONObject;
        Request.Callbacks callbacks;
        InstabugSDKLogger.v("IBG-Surveys", "Fetching surveys succeeded, Response: " + requestResponse);
        InstabugSDKLogger.d("IBG-Surveys", "fetchingSurveysRequest succeeded, Response code: " + requestResponse.getResponseCode());
        if (requestResponse.getResponseCode() == 200) {
            try {
                if (requestResponse.getResponseBody() != null) {
                    callbacks = this.f52414a;
                    jSONObject = new JSONObject((String) requestResponse.getResponseBody());
                } else {
                    callbacks = this.f52414a;
                    jSONObject = new JSONObject();
                }
                callbacks.onSucceeded(jSONObject);
            } catch (JSONException e11) {
                InstabugSDKLogger.e("IBG-Surveys", "submittingSurveyRequest got JSONException: " + e11.getMessage(), e11);
                this.f52414a.onFailed(e11);
            }
        } else {
            Request.Callbacks callbacks2 = this.f52414a;
            callbacks2.onFailed(new Throwable("Fetching Surveys got error with response code:" + requestResponse.getResponseCode()));
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugCore.reportError(th2, "fetchingSurveysRequest got error: " + th2.getMessage());
        InstabugSDKLogger.e("IBG-Surveys", "fetchingSurveysRequest got error: " + th2.getMessage(), th2);
        this.f52414a.onFailed(th2);
    }
}
