package dev.flutter.plugins.integration_test;

import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f13889b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f13890c;

    public /* synthetic */ b(MethodChannel.Result result, int i11) {
        this.f13889b = result;
        this.f13890c = i11;
    }

    public final void run() {
        this.f13889b.error("Could not copy the pixels", "result was " + this.f13890c, (Object) null);
    }
}
