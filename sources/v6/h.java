package v6;

import com.facebook.internal.FetchedAppSettingsManager;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FetchedAppSettingsManager.FetchedAppSettingsCallback f34751b;

    public /* synthetic */ h(FetchedAppSettingsManager.FetchedAppSettingsCallback fetchedAppSettingsCallback) {
        this.f34751b = fetchedAppSettingsCallback;
    }

    public final void run() {
        FetchedAppSettingsManager.m8953pollCallbacks$lambda1(this.f34751b);
    }
}
