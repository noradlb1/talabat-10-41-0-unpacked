package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class c implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.CookieManagerHostApi f13918a;

    public /* synthetic */ c(GeneratedAndroidWebView.CookieManagerHostApi cookieManagerHostApi) {
        this.f13918a = cookieManagerHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.CookieManagerHostApi.CC.b(this.f13918a, obj, reply);
    }
}
