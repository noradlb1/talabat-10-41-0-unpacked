package com.pichillilorenzo.flutter_inappwebview;

import androidx.webkit.WebViewFeature;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;

public class WebViewFeatureManager implements MethodChannel.MethodCallHandler {
    static final String LOG_TAG = "WebViewFeatureManager";
    public MethodChannel channel;
    public InAppWebViewFlutterPlugin plugin;

    public WebViewFeatureManager(InAppWebViewFlutterPlugin inAppWebViewFlutterPlugin) {
        this.plugin = inAppWebViewFlutterPlugin;
        MethodChannel methodChannel = new MethodChannel(inAppWebViewFlutterPlugin.messenger, "com.pichillilorenzo/flutter_inappwebview_android_webviewfeature");
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void dispose() {
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.plugin = null;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        if (!str.equals("isFeatureSupported")) {
            result.notImplemented();
        } else {
            result.success(Boolean.valueOf(WebViewFeature.isFeatureSupported((String) methodCall.argument("feature"))));
        }
    }
}
