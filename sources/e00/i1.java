package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class i1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebStorageHostApi f13943a;

    public /* synthetic */ i1(GeneratedAndroidWebView.WebStorageHostApi webStorageHostApi) {
        this.f13943a = webStorageHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        k1.b(this.f13943a, obj, reply);
    }
}
