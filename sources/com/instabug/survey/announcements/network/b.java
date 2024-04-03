package com.instabug.survey.announcements.network;

import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import org.json.JSONException;
import org.json.JSONObject;

class b implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f52262a;

    public b(d dVar, Request.Callbacks callbacks) {
        this.f52262a = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        JSONObject jSONObject;
        Request.Callbacks callbacks;
        InstabugSDKLogger.d("IBG-Surveys", "fetchingAnnouncementsRequest succeeded, Response code: " + requestResponse.getResponseCode());
        InstabugSDKLogger.v("IBG-Surveys", "Response: " + requestResponse);
        if (requestResponse.getResponseCode() == 200) {
            try {
                if (requestResponse.getResponseBody() != null) {
                    callbacks = this.f52262a;
                    jSONObject = new JSONObject((String) requestResponse.getResponseBody());
                } else {
                    callbacks = this.f52262a;
                    jSONObject = new JSONObject();
                }
                callbacks.onSucceeded(jSONObject);
            } catch (JSONException e11) {
                InstabugSDKLogger.e("IBG-Surveys", "submittingAnnouncementRequest got JSONException: " + e11.getMessage(), e11);
                this.f52262a.onFailed(e11);
            }
        } else {
            Request.Callbacks callbacks2 = this.f52262a;
            callbacks2.onFailed(new Throwable("Fetching Announcements got error with response code:" + requestResponse.getResponseCode()));
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-Surveys", "fetchingAnnouncementsRequest got error: " + th2.getMessage(), th2);
        this.f52262a.onFailed(th2);
    }
}
