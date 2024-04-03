package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class q0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebChromeClientHostApi f13974a;

    public /* synthetic */ q0(GeneratedAndroidWebView.WebChromeClientHostApi webChromeClientHostApi) {
        this.f13974a = webChromeClientHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        r0.d(this.f13974a, obj, reply);
    }
}
