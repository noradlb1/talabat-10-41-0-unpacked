package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class s1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebViewClientHostApi f13981a;

    public /* synthetic */ s1(GeneratedAndroidWebView.WebViewClientHostApi webViewClientHostApi) {
        this.f13981a = webViewClientHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        u1.b(this.f13981a, obj, reply);
    }
}
