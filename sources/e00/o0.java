package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class o0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebChromeClientHostApi f13966a;

    public /* synthetic */ o0(GeneratedAndroidWebView.WebChromeClientHostApi webChromeClientHostApi) {
        this.f13966a = webChromeClientHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        r0.b(this.f13966a, obj, reply);
    }
}
