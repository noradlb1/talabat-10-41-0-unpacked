package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class g2 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebViewHostApi f13936a;

    public /* synthetic */ g2(GeneratedAndroidWebView.WebViewHostApi webViewHostApi) {
        this.f13936a = webViewHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.WebViewHostApi.CC.u(this.f13936a, obj, reply);
    }
}
