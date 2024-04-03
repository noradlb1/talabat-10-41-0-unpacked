package e00;

import android.webkit.ValueCallback;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public final /* synthetic */ class a implements ValueCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GeneratedAndroidWebView.Result f13912a;

    public /* synthetic */ a(GeneratedAndroidWebView.Result result) {
        this.f13912a = result;
    }

    public final void onReceiveValue(Object obj) {
        this.f13912a.success((Boolean) obj);
    }
}
