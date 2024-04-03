package dev.flutter.plugins.integration_test;

import android.graphics.Bitmap;
import android.view.PixelCopy;
import io.flutter.plugin.common.MethodChannel;

public final /* synthetic */ class f implements PixelCopy.OnPixelCopyFinishedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Bitmap f13901a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MethodChannel.Result f13902b;

    public /* synthetic */ f(Bitmap bitmap, MethodChannel.Result result) {
        this.f13901a = bitmap;
        this.f13902b = result;
    }

    public final void onPixelCopyFinished(int i11) {
        FlutterDeviceScreenshot.lambda$convertViewToBitmap$5(this.f13901a, this.f13902b, i11);
    }
}
