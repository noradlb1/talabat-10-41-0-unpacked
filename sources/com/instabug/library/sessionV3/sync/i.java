package com.instabug.library.sessionV3.sync;

import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.TimeUtils;
import java.util.List;
import org.jetbrains.annotations.Nullable;

public final class i implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f51836a;

    public i(List list) {
        this.f51836a = list;
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable RequestResponse requestResponse) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.f51836a);
        sb2.append(" sent successfully ");
        sb2.append(requestResponse == null ? null : Integer.valueOf(requestResponse.getResponseCode()));
        InstabugSDKLogger.d("IBG-Core", sb2.toString());
        n nVar = n.f51841a;
        nVar.c().reset();
        nVar.d().a(this.f51836a);
        if (nVar.a().a() != 0) {
            nVar.a().c(0);
        }
        nVar.a().c(TimeUtils.currentTimeMillis());
        nVar.f();
    }

    /* renamed from: a */
    public void onFailed(@Nullable Throwable th2) {
        if (th2 != null && !n.f51841a.c().inspect(th2, this.f51836a)) {
            InstabugSDKLogger.e("IBG-Core", "something went wrong while syncing sessions", th2);
        }
    }
}
