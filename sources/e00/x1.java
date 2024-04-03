package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class x1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebViewHostApi f13998a;

    public /* synthetic */ x1(GeneratedAndroidWebView.WebViewHostApi webViewHostApi) {
        this.f13998a = webViewHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.WebViewHostApi.CC.m(this.f13998a, obj, reply);
    }
}
