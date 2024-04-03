package dev.flutter.plugins.integration_test;

import android.os.Handler;
import io.flutter.embedding.android.FlutterView;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f13896b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FlutterView f13897c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f13898d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Handler f13899e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Handler f13900f;

    public /* synthetic */ d(boolean z11, FlutterView flutterView, MethodChannel.Result result, Handler handler, Handler handler2) {
        this.f13896b = z11;
        this.f13897c = flutterView;
        this.f13898d = result;
        this.f13899e = handler;
        this.f13900f = handler2;
    }

    public final void run() {
        FlutterDeviceScreenshot.waitForAndroidFrame(new c(this.f13896b, this.f13897c, this.f13898d, this.f13899e, this.f13900f));
    }
}
