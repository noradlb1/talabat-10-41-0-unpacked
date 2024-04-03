package com.instabug.library.invocation.invoker;

import android.annotation.SuppressLint;
import android.content.Context;
import com.instabug.library.invocation.InvocationManager;
import com.instabug.library.invocation.a;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.q;
import com.instabug.library.util.r;

public class v implements a, q {

    /* renamed from: a  reason: collision with root package name */
    private r f51403a;

    /* renamed from: b  reason: collision with root package name */
    private a f51404b;

    /* renamed from: c  reason: collision with root package name */
    private volatile boolean f51405c;

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public v(Context context, a aVar) {
        this.f51404b = aVar;
        this.f51403a = new r(context, this);
    }

    public void a() {
        InstabugSDKLogger.d("IBG-Core", "Shake detected, invoking SDK");
        InvocationManager.getInstance().setLastUsedInvoker(this);
        this.f51404b.a();
    }

    /* renamed from: a */
    public void handle(Void voidR) {
    }

    public boolean isActive() {
        return this.f51405c;
    }

    public void listen() {
        this.f51403a.a();
        this.f51405c = true;
        InstabugSDKLogger.d("IBG-Core", "Shake invoker: listen");
    }

    public void sleep() {
        this.f51403a.b();
        this.f51405c = false;
        InstabugSDKLogger.d("IBG-Core", "Shake invoker: sleep");
    }

    public void a(int i11) {
        this.f51403a.a(i11);
    }
}
