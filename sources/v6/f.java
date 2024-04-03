package v6;

import com.facebook.internal.FetchedAppGateKeepersManager;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FetchedAppGateKeepersManager.Callback f34747b;

    public /* synthetic */ f(FetchedAppGateKeepersManager.Callback callback) {
        this.f34747b = callback;
    }

    public final void run() {
        FetchedAppGateKeepersManager.m8951pollCallbacks$lambda1(this.f34747b);
    }
}
