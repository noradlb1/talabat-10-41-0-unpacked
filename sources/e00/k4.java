package e00;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugins.webviewflutter.WebViewFlutterPlugin;

public final /* synthetic */ class k4 {
    @Nullable
    public static WebView a(@NonNull FlutterEngine flutterEngine, long j11) {
        WebViewFlutterPlugin webViewFlutterPlugin = (WebViewFlutterPlugin) flutterEngine.getPlugins().get(WebViewFlutterPlugin.class);
        if (webViewFlutterPlugin == null || webViewFlutterPlugin.getInstanceManager() == null) {
            return null;
        }
        Object instance = webViewFlutterPlugin.getInstanceManager().getInstance(j11);
        if (instance instanceof WebView) {
            return (WebView) instance;
        }
        return null;
    }
}
