package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class r implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.GeolocationPermissionsCallbackHostApi f13977a;

    public /* synthetic */ r(GeneratedAndroidWebView.GeolocationPermissionsCallbackHostApi geolocationPermissionsCallbackHostApi) {
        this.f13977a = geolocationPermissionsCallbackHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        s.b(this.f13977a, obj, reply);
    }
}
