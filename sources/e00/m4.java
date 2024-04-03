package e00;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import io.flutter.plugins.webviewflutter.InstanceManager;

public final /* synthetic */ class m4 implements InstanceManager.FinalizationListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ BinaryMessenger f13959a;

    public /* synthetic */ m4(BinaryMessenger binaryMessenger) {
        this.f13959a = binaryMessenger;
    }

    public final void onFinalize(long j11) {
        new GeneratedAndroidWebView.JavaObjectFlutterApi(this.f13959a).dispose(Long.valueOf(j11), new l4());
    }
}
