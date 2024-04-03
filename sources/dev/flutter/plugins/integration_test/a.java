package dev.flutter.plugins.integration_test;

import io.flutter.plugin.common.MethodChannel;
import java.io.ByteArrayOutputStream;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f13887b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ByteArrayOutputStream f13888c;

    public /* synthetic */ a(MethodChannel.Result result, ByteArrayOutputStream byteArrayOutputStream) {
        this.f13887b = result;
        this.f13888c = byteArrayOutputStream;
    }

    public final void run() {
        this.f13887b.success(this.f13888c.toByteArray());
    }
}
