package io.flutter.plugin.platform;

import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.plugin.platform.PlatformViewsController;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsController.AnonymousClass1 f14286b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VirtualDisplayController f14287c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ float f14288d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ PlatformViewsChannel.PlatformViewBufferResized f14289e;

    public /* synthetic */ c(PlatformViewsController.AnonymousClass1 r12, VirtualDisplayController virtualDisplayController, float f11, PlatformViewsChannel.PlatformViewBufferResized platformViewBufferResized) {
        this.f14286b = r12;
        this.f14287c = virtualDisplayController;
        this.f14288d = f11;
        this.f14289e = platformViewBufferResized;
    }

    public final void run() {
        this.f14286b.lambda$resize$0(this.f14287c, this.f14288d, this.f14289e);
    }
}
