package io.flutter.plugin.platform;

import android.view.View;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.platform.PlatformViewsController;

public final /* synthetic */ class d implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsController.AnonymousClass1 f14290b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsChannel.PlatformViewCreationRequest f14291c;

    public /* synthetic */ d(PlatformViewsController.AnonymousClass1 r12, PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
        this.f14290b = r12;
        this.f14291c = platformViewCreationRequest;
    }

    public final void onFocusChange(View view, boolean z11) {
        this.f14290b.lambda$configureForVirtualDisplay$1(this.f14291c, view, z11);
    }
}
