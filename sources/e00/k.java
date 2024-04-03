package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class k implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.DownloadListenerHostApi f13949a;

    public /* synthetic */ k(GeneratedAndroidWebView.DownloadListenerHostApi downloadListenerHostApi) {
        this.f13949a = downloadListenerHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        l.b(this.f13949a, obj, reply);
    }
}
