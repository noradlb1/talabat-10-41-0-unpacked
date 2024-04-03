package com.instabug.library;

import android.os.Handler;
import android.os.Looper;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import com.instabug.library.ui.onboarding.WelcomeMessage;
import io.reactivex.functions.Consumer;

class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WelcomeMessage.State f50564b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c0 f50565c;

    public g(c0 c0Var, WelcomeMessage.State state) {
        this.f50565c = c0Var;
        this.f50564b = state;
    }

    /* renamed from: a */
    public void accept(SDKCoreEvent sDKCoreEvent) {
        Looper myLooper = Looper.myLooper();
        if (Looper.myLooper() != Looper.getMainLooper()) {
            myLooper = Looper.getMainLooper();
        }
        if (myLooper != null) {
            Handler unused = this.f50565c.f50541i = new Handler(myLooper);
            this.f50565c.f50541i.postDelayed(new f(this, sDKCoreEvent), 1000);
        }
    }
}
