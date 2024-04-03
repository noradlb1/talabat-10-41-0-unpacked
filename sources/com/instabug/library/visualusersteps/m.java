package com.instabug.library.visualusersteps;

import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.functions.Consumer;

class m implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String[] f52176b;

    public m(p pVar, String[] strArr) {
        this.f52176b = strArr;
    }

    /* renamed from: a */
    public void accept(Boolean bool) {
        if (!bool.booleanValue()) {
            InstabugSDKLogger.e("IBG-Core", this.f52176b[0]);
        } else {
            InstabugSDKLogger.d("IBG-Core", this.f52176b[0]);
        }
    }
}
