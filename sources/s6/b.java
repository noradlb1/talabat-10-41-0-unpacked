package s6;

import com.facebook.appevents.AppEvent;
import com.facebook.appevents.ondeviceprocessing.OnDeviceProcessingManager;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f34667b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ AppEvent f34668c;

    public /* synthetic */ b(String str, AppEvent appEvent) {
        this.f34667b = str;
        this.f34668c = appEvent;
    }

    public final void run() {
        OnDeviceProcessingManager.m8926sendCustomEventAsync$lambda1(this.f34667b, this.f34668c);
    }
}
