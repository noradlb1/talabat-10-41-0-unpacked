package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class s0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebSettingsHostApi f13980a;

    public /* synthetic */ s0(GeneratedAndroidWebView.WebSettingsHostApi webSettingsHostApi) {
        this.f13980a = webSettingsHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        h1.b(this.f13980a, obj, reply);
    }
}
