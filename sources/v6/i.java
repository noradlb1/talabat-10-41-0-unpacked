package v6;

import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ FetchedAppSettingsManager.FetchedAppSettingsCallback f34752b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FetchedAppSettings f34753c;

    public /* synthetic */ i(FetchedAppSettingsManager.FetchedAppSettingsCallback fetchedAppSettingsCallback, FetchedAppSettings fetchedAppSettings) {
        this.f34752b = fetchedAppSettingsCallback;
        this.f34753c = fetchedAppSettings;
    }

    public final void run() {
        FetchedAppSettingsManager.m8954pollCallbacks$lambda2(this.f34752b, this.f34753c);
    }
}
