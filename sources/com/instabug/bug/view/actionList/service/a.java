package com.instabug.bug.view.actionList.service;

import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import org.json.JSONArray;
import org.json.JSONException;

class a implements Request.Callbacks {
    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        InstabugSDKLogger.d("IBG-BR", "getReportCategories request Succeeded, Response code: " + requestResponse.getResponseCode());
        InstabugSDKLogger.v("IBG-BR", "getReportCategories request Succeeded, Response body: " + requestResponse.getResponseBody());
        d.h(System.currentTimeMillis());
        String str = (String) requestResponse.getResponseBody();
        if (str != null) {
            try {
                if (new JSONArray(str).length() == 0) {
                    d.b((String) null);
                } else {
                    d.b(str);
                }
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-BR", "getReportCategories request got error", th2);
    }
}
