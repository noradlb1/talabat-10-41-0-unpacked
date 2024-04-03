package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class j1 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.WebStorageHostApi f13947a;

    public /* synthetic */ j1(GeneratedAndroidWebView.WebStorageHostApi webStorageHostApi) {
        this.f13947a = webStorageHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        k1.c(this.f13947a, obj, reply);
    }
}
