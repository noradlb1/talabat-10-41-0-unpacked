package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class u2 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebViewHostApi f13988a;

    public /* synthetic */ u2(GeneratedAndroidWebView.WebViewHostApi webViewHostApi) {
        this.f13988a = webViewHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.WebViewHostApi.CC.k(this.f13988a, obj, reply);
    }
}
