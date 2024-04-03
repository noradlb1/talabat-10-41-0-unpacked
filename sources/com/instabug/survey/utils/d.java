package com.instabug.survey.utils;

import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.settings.c;
import java.io.FileNotFoundException;

class d implements Request.Callbacks {
    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        String simpleName = e.class.getSimpleName();
        InstabugSDKLogger.v(simpleName, "checkingIsLiveApp succeeded, Response code: " + requestResponse.getResponseCode());
        c.q();
        c.a(requestResponse.getResponseCode() == 200);
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        String str;
        if (th2 instanceof FileNotFoundException) {
            str = "Couldn't find this app on playstore";
        } else {
            str = "checkingIsLiveApp got error: " + th2.toString();
        }
        InstabugSDKLogger.w("IBG-Surveys", str);
        c.a(false);
        c.q();
    }
}
