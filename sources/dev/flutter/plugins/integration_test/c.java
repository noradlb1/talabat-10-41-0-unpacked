package dev.flutter.plugins.integration_test;

import android.os.Handler;
import io.flutter.embedding.android.FlutterView;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ boolean f13891b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FlutterView f13892c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f13893d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Handler f13894e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Handler f13895f;

    public /* synthetic */ c(boolean z11, FlutterView flutterView, MethodChannel.Result result, Handler handler, Handler handler2) {
        this.f13891b = z11;
        this.f13892c = flutterView;
        this.f13893d = result;
        this.f13894e = handler;
        this.f13895f = handler2;
    }

    public final void run() {
        FlutterDeviceScreenshot.lambda$takeScreenshot$1(this.f13891b, this.f13892c, this.f13893d, this.f13894e, this.f13895f);
    }
}
