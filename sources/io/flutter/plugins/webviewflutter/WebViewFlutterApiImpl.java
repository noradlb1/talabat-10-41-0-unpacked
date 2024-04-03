package io.flutter.plugins.webviewflutter;

import android.webkit.WebView;
import androidx.annotation.NonNull;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugins.webviewflutter.GeneratedAndroidWebView;

public class WebViewFlutterApiImpl {
    private GeneratedAndroidWebView.WebViewFlutterApi api;
    private final BinaryMessenger binaryMessenger;
    private final InstanceManager instanceManager;

    public WebViewFlutterApiImpl(@NonNull BinaryMessenger binaryMessenger2, @NonNull InstanceManager instanceManager2) {
        this.binaryMessenger = binaryMessenger2;
        this.instanceManager = instanceManager2;
        this.api = new GeneratedAndroidWebView.WebViewFlutterApi(binaryMessenger2);
    }

    public void create(@NonNull WebView webView, @NonNull GeneratedAndroidWebView.WebViewFlutterApi.Reply<Void> reply) {
        if (!this.instanceManager.containsInstance(webView)) {
            this.api.create(Long.valueOf(this.instanceManager.addHostCreatedInstance(webView)), reply);
        }
    }
}
