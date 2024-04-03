package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class d2 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebViewHostApi f13925a;

    public /* synthetic */ d2(GeneratedAndroidWebView.WebViewHostApi webViewHostApi) {
        this.f13925a = webViewHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.WebViewHostApi.CC.s(this.f13925a, obj, reply);
    }
}
