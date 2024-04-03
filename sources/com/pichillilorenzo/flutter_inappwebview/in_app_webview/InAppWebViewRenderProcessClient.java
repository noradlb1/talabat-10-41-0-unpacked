package com.pichillilorenzo.flutter_inappwebview.in_app_webview;

import android.util.Log;
import android.webkit.WebView;
import androidx.webkit.WebViewFeature;
import androidx.webkit.WebViewRenderProcess;
import androidx.webkit.WebViewRenderProcessClient;
import com.facebook.internal.NativeProtocol;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class InAppWebViewRenderProcessClient extends WebViewRenderProcessClient {
    protected static final String LOG_TAG = "IAWRenderProcessClient";
    private final MethodChannel channel;

    public InAppWebViewRenderProcessClient(MethodChannel methodChannel) {
        this.channel = methodChannel;
    }

    public void dispose() {
    }

    public void onRenderProcessResponsive(WebView webView, final WebViewRenderProcess webViewRenderProcess) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", webView.getUrl());
        this.channel.invokeMethod("onRenderProcessResponsive", hashMap, new MethodChannel.Result() {
            public void error(String str, String str2, Object obj) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                if (str2 == null) {
                    str2 = "";
                }
                sb2.append(str2);
                Log.e(InAppWebViewRenderProcessClient.LOG_TAG, sb2.toString());
            }

            public void notImplemented() {
            }

            public void success(Object obj) {
                Integer num;
                if (obj != null && (num = (Integer) ((Map) obj).get(NativeProtocol.WEB_DIALOG_ACTION)) != null && webViewRenderProcess != null && num.intValue() == 0 && WebViewFeature.isFeatureSupported("WEB_VIEW_RENDERER_TERMINATE")) {
                    webViewRenderProcess.terminate();
                }
            }
        });
    }

    public void onRenderProcessUnresponsive(WebView webView, final WebViewRenderProcess webViewRenderProcess) {
        HashMap hashMap = new HashMap();
        hashMap.put("url", webView.getUrl());
        this.channel.invokeMethod("onRenderProcessUnresponsive", hashMap, new MethodChannel.Result() {
            public void error(String str, String str2, Object obj) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(str);
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
                if (str2 == null) {
                    str2 = "";
                }
                sb2.append(str2);
                Log.e(InAppWebViewRenderProcessClient.LOG_TAG, sb2.toString());
            }

            public void notImplemented() {
            }

            public void success(Object obj) {
                Integer num;
                if (obj != null && (num = (Integer) ((Map) obj).get(NativeProtocol.WEB_DIALOG_ACTION)) != null && webViewRenderProcess != null && num.intValue() == 0 && WebViewFeature.isFeatureSupported("WEB_VIEW_RENDERER_TERMINATE")) {
                    webViewRenderProcess.terminate();
                }
            }
        });
    }
}
