package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class e implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.CookieManagerHostApi f13926a;

    public /* synthetic */ e(GeneratedAndroidWebView.CookieManagerHostApi cookieManagerHostApi) {
        this.f13926a = cookieManagerHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.CookieManagerHostApi.CC.d(this.f13926a, obj, reply);
    }
}
