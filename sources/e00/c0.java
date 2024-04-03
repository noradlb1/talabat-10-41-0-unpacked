package e00;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class c0 implements BasicMessageChannel.MessageHandler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.PermissionRequestHostApi f13919a;

    public /* synthetic */ c0(GeneratedAndroidWebView.PermissionRequestHostApi permissionRequestHostApi) {
        this.f13919a = permissionRequestHostApi;
    }

    public final void onMessage(Object obj, BasicMessageChannel.Reply reply) {
        e0.b(this.f13919a, obj, reply);
    }
}
