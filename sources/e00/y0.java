package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class y0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebSettingsHostApi f14000a;

    public /* synthetic */ y0(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi) {
        this.f14000a = webSettingsHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        h1.d(this.f14000a, obj, reply);
    }
}
