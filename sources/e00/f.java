package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class f implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.CookieManagerHostApi f13929a;

    public /* synthetic */ f(GeneratedAndroidWebView.CookieManagerHostApi cookieManagerHostApi) {
        this.f13929a = cookieManagerHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.CookieManagerHostApi.CC.e(this.f13929a, obj, reply);
    }
}
