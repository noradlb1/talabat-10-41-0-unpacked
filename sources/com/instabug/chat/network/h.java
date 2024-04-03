package com.instabug.chat.network;

import com.instabug.library.core.InstabugCore;
import com.instabug.library.networkv2.request.Request;

class h implements Request.Callbacks {
    public h(i iVar) {
    }

    /* renamed from: a */
    public void onSucceeded(Boolean bool) {
        InstabugCore.setPushNotificationTokenSent(bool.booleanValue());
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugCore.setPushNotificationTokenSent(false);
    }
}
