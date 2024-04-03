package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class t implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.InstanceManagerHostApi f13983a;

    public /* synthetic */ t(GeneratedAndroidWebView.InstanceManagerHostApi instanceManagerHostApi) {
        this.f13983a = instanceManagerHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        u.b(this.f13983a, obj, reply);
    }
}
