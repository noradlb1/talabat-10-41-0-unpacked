package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class w implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.JavaObjectHostApi f13993a;

    public /* synthetic */ w(GeneratedAndroidWebView.JavaObjectHostApi javaObjectHostApi) {
        this.f13993a = javaObjectHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        x.b(this.f13993a, obj, reply);
    }
}
