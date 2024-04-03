package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class y1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebViewHostApi f14001a;

    public /* synthetic */ y1(GeneratedAndroidWebView.WebViewHostApi webViewHostApi) {
        this.f14001a = webViewHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.WebViewHostApi.CC.c(this.f14001a, obj, reply);
    }
}
