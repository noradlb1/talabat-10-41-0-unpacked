package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class a1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebSettingsHostApi f13913a;

    public /* synthetic */ a1(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi) {
        this.f13913a = webSettingsHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        h1.f(this.f13913a, obj, reply);
    }
}
