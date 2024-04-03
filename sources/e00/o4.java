package e00;

import android.webkit.ValueCallback;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class o4 implements ValueCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.Result f13969a;

    public /* synthetic */ o4(GeneratedAndroidWebView.Result result) {
        this.f13969a = result;
    }

    public final void onReceiveValue(Object obj) {
        this.f13969a.success((String) obj);
    }
}
