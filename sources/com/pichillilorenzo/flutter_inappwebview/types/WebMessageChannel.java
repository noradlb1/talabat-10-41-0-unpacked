package com.pichillilorenzo.flutter_inappwebview.types;

import android.webkit.ValueCallback;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.WebViewCompat;
import androidx.webkit.WebViewFeature;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.pichillilorenzo.flutter_inappwebview.in_app_webview.InAppWebView;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebMessageChannel implements MethodChannel.MethodCallHandler {
    static final String LOG_TAG = "WebMessageChannel";
    public MethodChannel channel;
    public final List<WebMessagePortCompat> compatPorts;

    /* renamed from: id  reason: collision with root package name */
    public String f52881id;
    public final List<WebMessagePort> ports;
    public InAppWebViewInterface webView;

    public WebMessageChannel(String str, InAppWebViewInterface inAppWebViewInterface) {
        this.f52881id = str;
        BinaryMessenger binaryMessenger = inAppWebViewInterface.getPlugin().messenger;
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "com.pichillilorenzo/flutter_inappwebview_web_message_channel_" + str);
        this.channel = methodChannel;
        methodChannel.setMethodCallHandler(this);
        if (inAppWebViewInterface instanceof InAppWebView) {
            this.compatPorts = new ArrayList(Arrays.asList(WebViewCompat.createWebMessageChannel((InAppWebView) inAppWebViewInterface)));
            this.ports = new ArrayList();
        } else {
            this.ports = Arrays.asList(new WebMessagePort[]{new WebMessagePort("port1", this), new WebMessagePort("port2", this)});
            this.compatPorts = new ArrayList();
        }
        this.webView = inAppWebViewInterface;
    }

    private void closeForInAppWebView(Integer num, MethodChannel.Result result) {
        if (this.webView == null || this.compatPorts.size() <= 0 || !WebViewFeature.isFeatureSupported("WEB_MESSAGE_PORT_CLOSE")) {
            result.success(Boolean.TRUE);
            return;
        }
        try {
            this.compatPorts.get(num.intValue()).close();
            result.success(Boolean.TRUE);
        } catch (Exception e11) {
            result.error(LOG_TAG, e11.getMessage(), (Object) null);
        }
    }

    private void postMessageForInAppWebView(Integer num, Map<String, Object> map, MethodChannel.Result result) {
        if (this.webView == null || this.compatPorts.size() <= 0 || !WebViewFeature.isFeatureSupported("WEB_MESSAGE_PORT_POST_MESSAGE")) {
            result.success(Boolean.TRUE);
            return;
        }
        WebMessagePortCompat webMessagePortCompat = this.compatPorts.get(num.intValue());
        ArrayList arrayList = new ArrayList();
        List<Map> list = (List) map.get("ports");
        if (list != null) {
            for (Map map2 : list) {
                Integer num2 = (Integer) map2.get(FirebaseAnalytics.Param.INDEX);
                WebMessageChannel webMessageChannel = this.webView.getWebMessageChannels().get((String) map2.get("webMessageChannelId"));
                if (webMessageChannel != null) {
                    arrayList.add(webMessageChannel.compatPorts.get(num2.intValue()));
                }
            }
        }
        try {
            webMessagePortCompat.postMessage(new WebMessageCompat((String) map.get("data"), (WebMessagePortCompat[]) arrayList.toArray(new WebMessagePortCompat[0])));
            result.success(Boolean.TRUE);
        } catch (Exception e11) {
            result.error(LOG_TAG, e11.getMessage(), (Object) null);
        }
    }

    private void setWebMessageCallbackForInAppWebView(final Integer num, MethodChannel.Result result) {
        if (this.webView == null || this.compatPorts.size() <= 0 || !WebViewFeature.isFeatureSupported("WEB_MESSAGE_PORT_SET_MESSAGE_CALLBACK")) {
            result.success(Boolean.TRUE);
            return;
        }
        try {
            this.compatPorts.get(num.intValue()).setWebMessageCallback(new WebMessagePortCompat.WebMessageCallbackCompat() {
                public void onMessage(WebMessagePortCompat webMessagePortCompat, WebMessageCompat webMessageCompat) {
                    super.onMessage(webMessagePortCompat, webMessageCompat);
                    HashMap hashMap = new HashMap();
                    hashMap.put(FirebaseAnalytics.Param.INDEX, num);
                    hashMap.put("message", webMessageCompat != null ? webMessageCompat.getData() : null);
                    WebMessageChannel.this.channel.invokeMethod("onMessage", hashMap);
                }
            });
            result.success(Boolean.TRUE);
        } catch (Exception e11) {
            result.error(LOG_TAG, e11.getMessage(), (Object) null);
        }
    }

    public void dispose() {
        if (WebViewFeature.isFeatureSupported("WEB_MESSAGE_PORT_CLOSE")) {
            for (WebMessagePortCompat close : this.compatPorts) {
                try {
                    close.close();
                } catch (Exception unused) {
                }
            }
        }
        this.channel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
        this.compatPorts.clear();
        this.webView = null;
    }

    public void initJsInstance(InAppWebViewInterface inAppWebViewInterface, final ValueCallback<WebMessageChannel> valueCallback) {
        if (inAppWebViewInterface != null) {
            inAppWebViewInterface.evaluateJavascript("(function() {window.flutter_inappwebview._webMessageChannels['" + this.f52881id + "'] = new MessageChannel();})();", (ContentWorld) null, new ValueCallback<String>() {
                public void onReceiveValue(String str) {
                    valueCallback.onReceiveValue(this);
                }
            });
            return;
        }
        valueCallback.onReceiveValue(this);
    }

    public void onMessage(Integer num, String str) {
        HashMap hashMap = new HashMap();
        hashMap.put(FirebaseAnalytics.Param.INDEX, num);
        hashMap.put("message", str);
        this.channel.invokeMethod("onMessage", hashMap);
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        String str = methodCall.method;
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 94756344:
                if (str.equals("close")) {
                    c11 = 0;
                    break;
                }
                break;
            case 556190586:
                if (str.equals("setWebMessageCallback")) {
                    c11 = 1;
                    break;
                }
                break;
            case 1490029383:
                if (str.equals("postMessage")) {
                    c11 = 2;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                if (this.webView instanceof InAppWebView) {
                    closeForInAppWebView((Integer) methodCall.argument(FirebaseAnalytics.Param.INDEX), result);
                    return;
                }
                break;
            case 1:
                if (this.webView instanceof InAppWebView) {
                    setWebMessageCallbackForInAppWebView((Integer) methodCall.argument(FirebaseAnalytics.Param.INDEX), result);
                    return;
                }
                break;
            case 2:
                if (this.webView instanceof InAppWebView) {
                    postMessageForInAppWebView((Integer) methodCall.argument(FirebaseAnalytics.Param.INDEX), (Map) methodCall.argument("message"), result);
                    return;
                }
                break;
            default:
                result.notImplemented();
                return;
        }
        result.success(Boolean.TRUE);
    }

    public Map<String, Object> toMap() {
        HashMap hashMap = new HashMap();
        hashMap.put("id", this.f52881id);
        return hashMap;
    }
}
