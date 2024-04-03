package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class b1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebSettingsHostApi f13916a;

    public /* synthetic */ b1(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi) {
        this.f13916a = webSettingsHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        h1.g(this.f13916a, obj, reply);
    }
}
