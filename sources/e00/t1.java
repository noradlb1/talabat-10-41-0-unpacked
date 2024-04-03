package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class t1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebViewClientHostApi f13985a;

    public /* synthetic */ t1(GeneratedAndroidWebView.WebViewClientHostApi webViewClientHostApi) {
        this.f13985a = webViewClientHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        u1.c(this.f13985a, obj, reply);
    }
}
