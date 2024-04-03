package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class g1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebSettingsHostApi f13935a;

    public /* synthetic */ g1(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi) {
        this.f13935a = webSettingsHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        h1.k(this.f13935a, obj, reply);
    }
}
