package com.instabug.survey.network.service;

import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

class e implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f52415a;

    public e(g gVar, Request.Callbacks callbacks) {
        this.f52415a = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        InstabugSDKLogger.d("IBG-Surveys", "submittingSurveyRequest Succeeded, Response code: " + requestResponse.getResponseCode());
        if (requestResponse.getResponseCode() == 200) {
            this.f52415a.onSucceeded(Boolean.TRUE);
            return;
        }
        this.f52415a.onSucceeded(Boolean.FALSE);
        Request.Callbacks callbacks = this.f52415a;
        callbacks.onFailed(new Throwable("submittingSurveyRequest got error with response code:" + requestResponse.getResponseCode()));
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-Surveys", "submittingSurveyRequest got error: " + th2.getMessage(), th2);
        this.f52415a.onFailed(th2);
    }
}
