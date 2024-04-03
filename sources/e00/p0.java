package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class p0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebChromeClientHostApi f13970a;

    public /* synthetic */ p0(GeneratedAndroidWebView.WebChromeClientHostApi webChromeClientHostApi) {
        this.f13970a = webChromeClientHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        r0.c(this.f13970a, obj, reply);
    }
}
