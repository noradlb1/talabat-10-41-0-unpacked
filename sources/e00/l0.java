package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import java.util.List;

public final /* synthetic */ class l0 implements BasicMessageChannel.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply f13952a;

    public /* synthetic */ l0(GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply reply) {
        this.f13952a = reply;
    }

    public final void reply(Object obj) {
        this.f13952a.reply((List) obj);
    }
}
