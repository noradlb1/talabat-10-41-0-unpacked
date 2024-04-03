package com.huawei.location.callback;

import android.app.PendingIntent;
import com.huawei.location.router.interfaces.IRouterCallback;

public class LW {
    private IRouterCallback Vw;

    /* renamed from: yn  reason: collision with root package name */
    private PendingIntent f50006yn;

    public IRouterCallback Vw() {
        return this.Vw;
    }

    public PendingIntent yn() {
        return this.f50006yn;
    }

    public void yn(PendingIntent pendingIntent) {
        this.f50006yn = pendingIntent;
    }

    public void yn(IRouterCallback iRouterCallback) {
        this.Vw = iRouterCallback;
    }
}
