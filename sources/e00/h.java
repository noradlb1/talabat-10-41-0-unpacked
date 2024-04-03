package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class h implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.CustomViewCallbackHostApi f13939a;

    public /* synthetic */ h(GeneratedAndroidWebView.CustomViewCallbackHostApi customViewCallbackHostApi) {
        this.f13939a = customViewCallbackHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        i.b(this.f13939a, obj, reply);
    }
}
