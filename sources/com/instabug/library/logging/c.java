package com.instabug.library.logging;

import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.memory.Action;

class c implements Action {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String[] f51449a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ float f51450b;

    public c(String[] strArr, float f11) {
        this.f51449a = strArr;
        this.f51450b = f11;
    }

    public void onAffirmed() throws Throwable {
        this.f51449a[0] = d.a(this.f51450b);
    }

    public void onDenied() throws Throwable {
        InstabugSDKLogger.e("IBG-Core", "Not enough memory for retrieving network logs");
    }
}
