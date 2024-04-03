package io.flutter.plugin.platform;

import android.view.View;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.platform.PlatformViewsController;

public final /* synthetic */ class b implements View.OnFocusChangeListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsController.AnonymousClass1 f14284b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsChannel.PlatformViewCreationRequest f14285c;

    public /* synthetic */ b(PlatformViewsController.AnonymousClass1 r12, PlatformViewsChannel.PlatformViewCreationRequest platformViewCreationRequest) {
        this.f14284b = r12;
        this.f14285c = platformViewCreationRequest;
    }

    public final void onFocusChange(View view, boolean z11) {
        this.f14284b.lambda$configureForTextureLayerComposition$2(this.f14285c, view, z11);
    }
}
