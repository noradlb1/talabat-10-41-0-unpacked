package xz;

import android.view.View;
import io.flutter.plugin.platform.PlatformViewsController;

public final /* synthetic */ class d implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsController f24199b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f24200c;

    public /* synthetic */ d(PlatformViewsController platformViewsController, int i11) {
        this.f24199b = platformViewsController;
        this.f24200c = i11;
    }

    public final void onFocusChange(View view, boolean z11) {
        this.f24199b.lambda$initializePlatformViewIfNeeded$0(this.f24200c, view, z11);
    }
}
