package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class o implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.FlutterAssetManagerHostApi f13965a;

    public /* synthetic */ o(GeneratedAndroidWebView.FlutterAssetManagerHostApi flutterAssetManagerHostApi) {
        this.f13965a = flutterAssetManagerHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        p.c(this.f13965a, obj, reply);
    }
}
