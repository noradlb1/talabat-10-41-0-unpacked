package e00;

import io.flutter.plugins.webviewflutter.JavaScriptChannel;

public final /* synthetic */ class y2 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ JavaScriptChannel f14002b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f14003c;

    public /* synthetic */ y2(JavaScriptChannel javaScriptChannel, String str) {
        this.f14002b = javaScriptChannel;
        this.f14003c = str;
    }

    public final void run() {
        this.f14002b.lambda$postMessage$1(this.f14003c);
    }
}
