package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class d implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.CookieManagerHostApi f13922a;

    public /* synthetic */ d(GeneratedAndroidWebView.CookieManagerHostApi cookieManagerHostApi) {
        this.f13922a = cookieManagerHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        GeneratedAndroidWebView.CookieManagerHostApi.CC.c(this.f13922a, obj, reply);
    }
}
