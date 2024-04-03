package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class d0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.PermissionRequestHostApi f13923a;

    public /* synthetic */ d0(GeneratedAndroidWebView.PermissionRequestHostApi permissionRequestHostApi) {
        this.f13923a = permissionRequestHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        e0.c(this.f13923a, obj, reply);
    }
}
