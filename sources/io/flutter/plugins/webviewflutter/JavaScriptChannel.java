package io.flutter.plugins.webviewflutter;

import android.os.Handler;
import android.os.Looper;
import android.webkit.JavascriptInterface;
import androidx.annotation.NonNull;
import e00.x2;
import e00.y2;

public class JavaScriptChannel {

    /* renamed from: a  reason: collision with root package name */
    public final String f14424a;
    private final JavaScriptChannelFlutterApiImpl flutterApi;
    private final Handler platformThreadHandler;

    public JavaScriptChannel(@NonNull JavaScriptChannelFlutterApiImpl javaScriptChannelFlutterApiImpl, @NonNull String str, @NonNull Handler handler) {
        this.flutterApi = javaScriptChannelFlutterApiImpl;
        this.f14424a = str;
        this.platformThreadHandler = handler;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$postMessage$0(Void voidR) {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$postMessage$1(String str) {
        this.flutterApi.postMessage(this, str, new x2());
    }

    @JavascriptInterface
    public void postMessage(@NonNull String str) {
        y2 y2Var = new y2(this, str);
        if (this.platformThreadHandler.getLooper() == Looper.myLooper()) {
            y2Var.run();
        } else {
            this.platformThreadHandler.post(y2Var);
        }
    }
}
