package com.instabug.survey.announcements.network;

import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

class c implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f52263a;

    public c(d dVar, Request.Callbacks callbacks) {
        this.f52263a = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        InstabugSDKLogger.d("IBG-Surveys", "submittingAnnouncementRequest succeeded, Response code: " + requestResponse.getResponseCode());
        StringBuilder sb2 = new StringBuilder();
        sb2.append("submittingAnnouncementRequest Response body: ");
        sb2.append(requestResponse.getResponseBody() != null ? requestResponse.getResponseBody() : "body is null");
        InstabugSDKLogger.v("IBG-Surveys", sb2.toString());
        if (requestResponse.getResponseCode() == 200) {
            this.f52263a.onSucceeded(Boolean.TRUE);
            return;
        }
        this.f52263a.onSucceeded(Boolean.FALSE);
        Request.Callbacks callbacks = this.f52263a;
        callbacks.onFailed(new Throwable("submittingAnnouncementRequest got error with response code:" + requestResponse.getResponseCode()));
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-Surveys", "submittingAnnouncementRequest got error: " + th2.getMessage(), th2);
        this.f52263a.onFailed(th2);
    }
}
