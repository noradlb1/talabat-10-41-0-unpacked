package e00;

import android.webkit.ValueCallback;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;
import io.flutter.plugins.webviewflutter.WebChromeClientHostApiImpl;
import java.util.List;

public final /* synthetic */ class g3 implements GeneratedAndroidWebView.WebChromeClientFlutterApi.Reply {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f13937a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ValueCallback f13938b;

    public /* synthetic */ g3(boolean z11, ValueCallback valueCallback) {
        this.f13937a = z11;
        this.f13938b = valueCallback;
    }

    public final void reply(Object obj) {
        WebChromeClientHostApiImpl.WebChromeClientImpl.lambda$onShowFileChooser$5(this.f13937a, this.f13938b, (List) obj);
    }
}
