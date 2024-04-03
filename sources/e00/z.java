package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class z implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.JavaScriptChannelHostApi f14004a;

    public /* synthetic */ z(GeneratedAndroidWebView.JavaScriptChannelHostApi javaScriptChannelHostApi) {
        this.f14004a = javaScriptChannelHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        a0.b(this.f14004a, obj, reply);
    }
}
