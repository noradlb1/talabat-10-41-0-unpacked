package t2;

import androidx.window.layout.SidecarWindowBackend;
import androidx.window.layout.WindowLayoutInfo;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SidecarWindowBackend.WindowLayoutChangeCallbackWrapper f44400b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WindowLayoutInfo f44401c;

    public /* synthetic */ d(SidecarWindowBackend.WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper, WindowLayoutInfo windowLayoutInfo) {
        this.f44400b = windowLayoutChangeCallbackWrapper;
        this.f44401c = windowLayoutInfo;
    }

    public final void run() {
        SidecarWindowBackend.WindowLayoutChangeCallbackWrapper.m9129accept$lambda0(this.f44400b, this.f44401c);
    }
}
