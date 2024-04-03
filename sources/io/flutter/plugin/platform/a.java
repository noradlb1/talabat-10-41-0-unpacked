package io.flutter.plugin.platform;

import io.flutter.plugin.platform.PlatformPlugin;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ PlatformPlugin.AnonymousClass2 f14282b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f14283c;

    public /* synthetic */ a(PlatformPlugin.AnonymousClass2 r12, int i11) {
        this.f14282b = r12;
        this.f14283c = i11;
    }

    public final void run() {
        this.f14282b.lambda$onSystemUiVisibilityChange$0(this.f14283c);
    }
}
