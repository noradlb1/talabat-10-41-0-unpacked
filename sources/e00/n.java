package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class n implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.FlutterAssetManagerHostApi f13960a;

    public /* synthetic */ n(GeneratedAndroidWebView.FlutterAssetManagerHostApi flutterAssetManagerHostApi) {
        this.f13960a = flutterAssetManagerHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        p.b(this.f13960a, obj, reply);
    }
}
