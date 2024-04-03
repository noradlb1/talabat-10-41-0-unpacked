package com.instabug.library.networkv2.service.userattributes;

import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.List;

class f implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f51704a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f51705b;

    public f(g gVar, String str) {
        this.f51705b = gVar;
        this.f51704a = str;
    }

    /* renamed from: a */
    public void onSucceeded(List list) {
        if (list != null) {
            List b11 = this.f51705b.b(list, this.f51704a, false, 1);
            this.f51705b.f51707b.a();
            this.f51705b.f51707b.a(b11);
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-Core", "Syncing user attributes got error: " + th2.getMessage(), th2);
    }
}
